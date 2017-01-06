package facin.extensao.javaservlet7;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.util.Date;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author Julio
 */
@WebListener
public class OuvinteSessao implements HttpSessionListener {
    private static final DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(MessageFormat.format("Session ID {0} created at {1}", se.getSession().getId(), df.format(new Date(se.getSession().getCreationTime()))));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println(MessageFormat.format("Session ID {0} destroyed at {1}", se.getSession().getId(), df.format(new Date(System.currentTimeMillis()))));
    }
}
