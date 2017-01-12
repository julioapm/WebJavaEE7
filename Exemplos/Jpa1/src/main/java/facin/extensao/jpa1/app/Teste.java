package facin.extensao.jpa1.app;

import facin.extensao.jpa1.entidades.Autor;
import facin.extensao.jpa1.entidades.Editora;
import facin.extensao.jpa1.entidades.Livro;
import facin.extensao.jpa1.negocio.AutorDAO;
import facin.extensao.jpa1.negocio.AutorJPA;
import facin.extensao.jpa1.negocio.EditoraDAO;
import facin.extensao.jpa1.negocio.EditoraJPA;
import facin.extensao.jpa1.negocio.LivroDAO;
import facin.extensao.jpa1.negocio.LivroJPA;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

    public static void main(String[] args) {
        //Codigo de obtencao do EntityManager modo gerenciado pelo aplicativo
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa1PU");
        EntityManager gerenciador = fabrica.createEntityManager();
        try {
            //exemploRelacionamentoCascade(gerenciador);
            exemploPrincipal(gerenciador);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getCause());
            System.exit(0);
        } finally {
            //Codigo de fechamento do EntityManager
            gerenciador.close();
            fabrica.close();
        }
    }

    public static void exemploRelacionamentoCascade(EntityManager gerenciador) throws Exception {
        //teste1(gerenciador);
        //teste2(gerenciador);
        //teste3(gerenciador);
        //teste4(gerenciador);
    }

    public static void teste1(EntityManager gerenciador) throws Exception {
        //Configurar relacionamento nos dois lados, persistir lado fraco
        Editora editora = new Editora();
        editora.setCodigo(999);
        editora.setNome("999");

        Livro livro = new Livro();
        livro.setAno(2015);
        livro.setTitulo("Livro");

        livro.setEditora(editora);
        editora.addLivro(livro);

        gerenciador.getTransaction().begin();
        gerenciador.persist(editora);
        gerenciador.getTransaction().commit();
        //Verificar se editora e livro foram adicionados ao BD
        //Funciona, pois o dono do relacionamento também tem a referência correta para
        //a outra entidade e a operação tem cascade definido para persist
    }

    public static void teste2(EntityManager gerenciador) throws Exception {
        //Configurar relacionamento no lado forte, persistir lado forte
        Editora editora = new Editora();
        editora.setCodigo(999);
        editora.setNome("999");

        Livro livro = new Livro();
        livro.setAno(2015);
        livro.setTitulo("Livro");

        livro.setEditora(editora);

        gerenciador.getTransaction().begin();
        gerenciador.persist(livro);
        gerenciador.getTransaction().commit();
        //Verificar se editora e livro foram adicionados ao BD
        //Funciona, pois o dono do relacionamento tem a referência correta para
        //a outra entidade e a operação tem cascade definido para persist
    }

    public static void teste3(EntityManager gerenciador) throws Exception {
        //Configurar relacionamento no lado forte, persistir lado fraco
        Editora editora = new Editora();
        editora.setCodigo(999);
        editora.setNome("999");

        Livro livro = new Livro();
        livro.setAno(2015);
        livro.setTitulo("Livro");

        livro.setEditora(editora);

        gerenciador.getTransaction().begin();
        gerenciador.persist(editora);
        gerenciador.getTransaction().commit();
        //Verificar se editora e livro foram adicionados ao BD
        //Não funciona, pois não se tem a referência para o lado forte do relacionamento
    }

    public static void teste4(EntityManager gerenciador) throws Exception {
        //Configurar relacionamento no lado fraco, persistir lado fraco
        Editora editora = new Editora();
        editora.setCodigo(999);
        editora.setNome("999");

        Livro livro = new Livro();
        livro.setAno(2015);
        livro.setTitulo("Livro");

        ArrayList<Livro> livros = new ArrayList<Livro>();
        livros.add(livro);
        editora.setLivros(livros);

        gerenciador.getTransaction().begin();
        gerenciador.persist(editora);
        gerenciador.getTransaction().commit();
        //Verificar se editora e livro foram adicionados ao BD
        //Não funciona
        //Ambas entidades inseridas no banco pois operação tem cascade persist,
        //mas sem chave estrangeira entre tabelas pois o lado forte não tem referência
        //para a outra entidade
    }

    public static void exemploPrincipal(EntityManager gerenciador) throws Exception {
        //Codigo de manipulacao das entidades         
        AutorDAO autorDao = new AutorJPA(gerenciador);
        LivroDAO livroDao = new LivroJPA(gerenciador);
        EditoraDAO editoraDao = new EditoraJPA(gerenciador);

        autorDao.criar("John", "Doe");
        autorDao.criar("Mary", "Doe");

        Autor a1 = autorDao.buscar(1);
        System.out.println(a1);

        for (Autor a : autorDao.buscar()) {
            System.out.println(a);
        }

        for (Autor a : autorDao.buscarPorUltimoNome("Doe")) {
            System.out.println(a);
        }

        a1.setUltimoNome("Outro");
        autorDao.alterar(a1);
        for (Autor a : autorDao.buscar()) {
            System.out.println(a);
        }

        editoraDao.criar(1, "Da Casa");
        editoraDao.criar(2, "Outra Editora");

        livroDao.criar("Teste", 2012, 1, null);

        Autor[] autores = new Autor[2];
        autores[0] = autorDao.buscar(1);
        Autor a2 = new Autor();
        a2.setPrimeiroNome("Teste");
        a2.setUltimoNome("Novo");
        autores[1] = a2;
        livroDao.criar("Livro3", 2012, 1, autores);

        Livro l = livroDao.buscar(2);
        System.out.println(l);

        for (Editora e : editoraDao.buscar()) {
            System.out.println(e);
            for (Livro liv : e.getLivros()) {
                System.out.println(" " + liv);
            }
        }

//            for(Livro l : livroDao.buscarPorEditora(1)){
//                System.out.println(l);
//                for(Autor a : l.getAutores()){
//                    System.out.println(" " + a);
//                }
//            }
        livroDao.excluir(livroDao.buscar(2));
    }
}
