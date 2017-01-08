package facin.extensao.jsf4.web;

import facin.extensao.jsf4.negocio.Cpf;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Julio
 */
@FacesConverter(value = "cpfConversor")
public class CpfConversor implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        StringBuilder sequencia = new StringBuilder(value);
        //Caracteres permitidos '0...9', '.' e '-'
        boolean encontrouCaractereInvalido = false;
        int i = 0;
        while (i < sequencia.length() && !encontrouCaractereInvalido) {
            char c = sequencia.charAt(i);
            if (Character.isDigit(c)) {
                i++;
            } else if (c == '.') {
                sequencia.deleteCharAt(i);
            } else if (c == '-') {
                sequencia.deleteCharAt(i);
            } else {
                encontrouCaractereInvalido = true;
            }
        }
        if (encontrouCaractereInvalido) {
            FacesMessage mensagem = new FacesMessage("Erro de conversão. ", "CPF com formato incorreto: " + value);
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(mensagem);
        }
        return new Cpf(sequencia.toString());
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String valor = value.toString();
        StringBuilder sequencia = new StringBuilder();
        int tamanho = valor.length();
        for (int i = 0; i < tamanho; i++) {
            if (i == 3 || i == 6) {
                sequencia.append('.');
            } else if (i == 9) {
                sequencia.append('-');
            }
            if (i < 11) {
                sequencia.append(valor.charAt(i));
            } else {
                break;
            }
        }
        return sequencia.toString();
    }

}
