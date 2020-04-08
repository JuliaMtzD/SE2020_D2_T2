import java.sql.Connection;
import java.sql.DriverManager;
import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;


@SuppressWarnings("serial")
public class ConnectionUtils {
    public static Connection getConnection(ServletConfig config) throws ServletException {
        Connection connection = null;;
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //String url="jdbc:odbc:Database3";
			ServletContext context = config.getServletContext();
			System.out.println("realPath: " + context.getRealPath("Database3.mdb"));
			String url=new String("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};Dbq=" + context.getRealPath("Database3.mdb"));
            connection=DriverManager.getConnection(url); 
        } catch(Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static Connection getConnection() {
        Connection connection = null;;
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String url="jdbc:odbc:Database3";
            connection=DriverManager.getConnection(url); 
        } catch(Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static Connection close(Connection connection) {
        try {
            connection.close(); 
        } catch(Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}