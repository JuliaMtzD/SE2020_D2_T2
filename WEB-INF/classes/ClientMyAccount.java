import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;


@SuppressWarnings("serial")
public class ClientMyAccount extends HttpServlet {
    Connection connection;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        connection = ConnectionUtils.getConnection(config);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
        res.setContentType("text/html");
        PrintWriter toClient = res.getWriter();
        

        toClient.println(Utils.header("My Account"));
		toClient.println("<table border='1'>");
		
		Vector<ClientData2> clientList;
		clientList = ClientData2.getClientList(connection);
		
		for(int i=0; i< clientList.size(); i++){
                ClientData2 client = clientList.elementAt(i);
                toClient.println("<tr>");
                toClient.println("<td>" + client.clientId + " </td>");
                toClient.println("<td>" + client.clientName + " </td>");
                toClient.println("<td>" + client.clientadress + " </td>");
                toClient.println("<td>" + client.creditcard + " </td>");
                toClient.println("<td>" + client.cleintemail + " </td>");
                toClient.println("<td>" + client.clientpassword + " </td>");
                toClient.println("<td>" + client.clienttelephone + " </td>");
                toClient.println("</tr>");
        }
		toClient.println("</table>");
        toClient.println(Utils.footer("My Account"));
        toClient.close();
    }
}