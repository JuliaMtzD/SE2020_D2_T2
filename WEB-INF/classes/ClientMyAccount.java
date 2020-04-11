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

		
		String name="Mauris Foundation"; 
		
		Vector<ClientData2> clientdata;
		clientdata= ClientData2.getClient(connection,name);
		
		for(int i=0; i< clientdata.size(); i++){
                ClientData2 client = clientdata.elementAt(i);


				toClient.println("<form action='ClientMyAccount.html' target='_blank'>");
				toClient.println("<div class='w3-container w3-dark-grey w3-center w3-padding-32 w3-padding-large w3-text-align:left' >");
				toClient.println("<h4 class='w3-center'><b> Personal Information </b></h4>");
				
				toClient.println("<div class='w3-section' >");
				toClient.println("<label for='ClientID'> Username </label>");
				toClient.println("<input class='w3-input w3-border' type='text' name='ClientID' id='ClientID' readonly value='"+name+"' >");
				toClient.println("</div>");
				
				toClient.println("<div class='w3-section'>");
				toClient.println("<label for='ClientName'> Contact Name </label>");
				toClient.println("<input class='w3-input w3-border' type='text' name='ClientName' id='ClientName'  placeholder='Your name...'>");
				toClient.println("</div>");
				
				toClient.println("<div class='w3-section'>");
				toClient.println("<label for='ClientLastName'> Contact Last Name </label>");
				toClient.println("<input class='w3-input w3-border' type='text' name='ClientLastName' id='ClientLastName'  placeholder='Your lastname...'>");
				toClient.println("</div>");
				
				toClient.println("<div class='w3-section'>");
				toClient.println("<label for='ClientPassword'> Password </label>");
				toClient.println("<input class='w3-input w3-border' type='password' name='ClientPassword' id='ClientPassword'  placeholder='"+client.clientpassword+"'>");
				toClient.println("</div>");
				toClient.println("</div>");
				
				toClient.println("<div class='w3-container w3-grey w3-center w3-padding-32 w3-padding-large w3-text-align:left' >");
				toClient.println("<h4 class='w3-center'><b> Contact Information </b></h4>");
				toClient.println("<div class='w3-section'>");
				toClient.println("<label for='ClientPhone'> Phone Number </label>");
				toClient.println("<input class='w3-input w3-border' type='text' name='ClientPhone' id='ClientPhone'  placeholder='" + client.clienttelephone + "'>");
				toClient.println("</div>");
				
				
				toClient.println("<div class='w3-section'>");
				toClient.println("<label for='ClientEmail'> Email </label>");
				toClient.println("<input class='w3-input w3-border' type='text' name='ClientEmail' id='ClientEmail'  placeholder='" + client.cleintemail + " '>");
				toClient.println("</div>");
				
				toClient.println("<div class='w3-section'>");
				toClient.println("<label for='ClientAddress'> Address </label>");
				toClient.println("<input class='w3-input w3-border' type='text' name='ClientAddress' id='ClientAddress'  placeholder='" + client.clientadress + "'>");
				toClient.println("</div>");
				toClient.println("</div>");
			 
				toClient.println("<div class='w3-container w3-dark-grey w3-center w3-padding-32 w3-padding-large w3-text-align:left'>");
				toClient.println("<h4 class='w3-center'><b> Payment Information </b></h4>");
				toClient.println("<div class='w3-section'>");
				toClient.println("<label for='ClientCard'> Credit card </label>");
				toClient.println("<input class='w3-input w3-border' type='password' name='ClientCard' id='ClientCard'  placeholder='" + client.creditcard + "'>");
				toClient.println("</div>");
				toClient.println("</div>");
				
				
				toClient.println("<input type='submit' value='Save Changes' class='w3-button w3-block w3-yellow w3-margin-bottom' >");
				
				toClient.println("</form>");
        }

        toClient.println(Utils.footer("My Account"));
        toClient.close();
    }
}