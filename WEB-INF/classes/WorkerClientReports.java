import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;

@SuppressWarnings("serial")
public class WorkerClientReports extends HttpServlet {
    Connection connection;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        connection = ConnectionUtils.getConnection(config);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
        res.setContentType("text/html");
        PrintWriter toClient = res.getWriter();
		
		toClient.println(UtilsWorker.header("CLIENT REPORT", "WorkerMainPage.html"));



toClient.println("<div class='w3-main'>");
toClient.println("<div class='w3-main' style='margin-left:300px'>");
toClient.println("<div class='w3-container w3-white w3-center w3-padding-32 w3-padding-large w3-text-align:left'>");
toClient.println(" <div class='w3-content' style='max-width:600px '> ");
toClient.println("<h1><b>BEST CLIENT</b></h1>");
toClient.println("<div class='w3-container w3-dark-grey w3-center w3-padding-32 w3-padding-large w3-text-align:left' id='personalinformation'> ");
 toClient.println("<h3 class='w3-center'><b> The best client is: </b></h3>");
       toClient.println("<h4 class='w3-center'> With a total revenue of  </h4>");
       toClient.println("</div>");
       toClient.println("</div>");
       toClient.println("</div>");
  

	toClient.println("<div class='w3-main ' style='margin:50px ' >");
	toClient.println("<h4>CLIENTS: </h4>");
		toClient.println(" <table class='w3-table w3-bordered' style='margin: 0-16 px'>");
			toClient.println("	<div class='w3-half w3-margin-bottom'>");
			toClient.println("	  <ul class='w3-ul w3-white w3-center '>");
					
						toClient.println("<tr class='w3-yellow w3-large w3-padding-32'>");
						toClient.println("<th>ID</th>");
						toClient.println("<th>Client Name</th>");
						toClient.println("<th>Telephone Number</th>");
						toClient.println("<th>Orders Purchased</th>");
						toClient.println("<th> Revenue</th>");
						toClient.println("</tr>");
      					Vector<ClientData> clientList;
						clientList = ClientData.getClientList(connection);
		
        				for(int i=0; i< clientList.size(); i++){
							ClientData client = clientList.elementAt(i);
							toClient.println("<tr class='w3-padding-16'>");
							toClient.println("<td>" + client.clientId + " </td>");
							toClient.println("<td>" + client.clientName + " </td>");
							toClient.println("<td>" + client.clientTelephone + " </td>");
							toClient.println("</tr>");
       					 }
					
				 toClient.println(" </ul>");
				toClient.println("  </div> ");
			toClient.println("</table>");
		
	
		toClient.println("</div>");
		toClient.println("</div>");
	toClient.println(UtilsWorker.footer("CLIENT REPORT"));

	toClient.println("</div> ");
	toClient.close();

    }
}