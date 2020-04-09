 import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;

@SuppressWarnings("serial")
public class WorkerSuppliers extends HttpServlet {
    Connection connection;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        connection = ConnectionUtils.getConnection(config);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
        res.setContentType("text/html");
        PrintWriter toClient = res.getWriter();
		
		toClient.println(UtilsWorker.header("SUPPLIERS", "WorkerMainPage.html"));



		toClient.println("<div class='w3-container w3-white  w3-padding-32 w3-margin-left-iker  ' id='table'>");
		toClient.println("<div class='w3-content ' style='max-width:600px'>");
		toClient.println("<h1 class='w3-center'><b>SUPPLIERS</b></h1>");
        toClient.println("<h6 class='w3-center'></h6>");
		
		
        toClient.println("<table class='w3-table w3-bordered ' style='margin:0 -8px'>");
        toClient.println("<div class='w3-half w3-margin-bottom'>");
        toClient.println("<ul class='w3-ul w3-white w3-center '>");
		
		toClient.println("<tr class='w3-yellow w3-large w3-padding-32'>");
			toClient.println("<th>ID</th>");
			toClient.println("<th>Supplier Name</th>");
			toClient.println("<th>Adress</th>");
			toClient.println("<th>Telephone Number</th>");
			toClient.println("<th>Web Page</th>");
			toClient.println("</tr>");
		
        Vector<SuppliersData> suppliersList;
		suppliersList = SuppliersData.getSuppliersList(connection);
		
        for(int i=0; i< suppliersList.size(); i++){
			SuppliersData supplier = suppliersList.elementAt(i);
			toClient.println("<tr class='w3-padding-16'>");
			toClient.println("<td>" + supplier.supplierId + " </td>");
			toClient.println("<td>" + supplier.supplierName + " </td>");
			toClient.println("<td>" + supplier.supplierAdress + " </td>");
			toClient.println("<td>" + supplier.supplierTelephone + " </td>");
			toClient.println("<td>" + supplier.supplierWeb + " </td>");
			toClient.println("<td><a href='WorkerHistorySuppliers?id=" + supplier.supplierId + "'><button class='w3-button w3-block w3-light-grey w3-'>Orders</button><a></td>");
			toClient.println("</tr>");
        }

        toClient.println("</ul>");
        toClient.println("</table>");
        toClient.println("</div>");
        toClient.println("</div>");
		 toClient.println(UtilsWorker.footer("SUPLLIERS"));
        toClient.println("</div>");
        toClient.close();
    }
}