import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;

@SuppressWarnings("serial")
public class WorkerHistorySuppliers extends HttpServlet {
    Connection connection;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        connection = ConnectionUtils.getConnection(config);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
        res.setContentType("text/html");
		String id = req.getParameter("id");
		
        PrintWriter toClient = res.getWriter();
		
		toClient.println(UtilsWorker.header("SUPPLIER'S ORDERS", "WorkerSuppliers"));
		
		
		toClient.println("<div class='w3-container w3-white  w3-padding-32 w3-margin-left  ' id='table'>");
		toClient.println("<div class='w3-content ' style='max-width:600px'> ");	
		toClient.println("<h1 class='w3-center'><b>ORDERS TO SUPPLIERS</b></h1>");
			
		Vector<SuppliersData> suppliers;
		suppliers = SuppliersData.getSupplier(connection, id);
		
		for(int i=0; i< suppliers.size(); i++){
			SuppliersData supplier = suppliers.elementAt(i);
			toClient.println("<h3 class='w3-center'><b>" + supplier.supplierName + "</b></h3><br>");
			toClient.println("<br><b>ID:</b> " + supplier.supplierId);
			toClient.println("<br><b>Adress:</b> " + supplier.supplierAdress);
			toClient.println("<br><b>Telephone number:</b> " + supplier.supplierTelephone);
			toClient.println("<br><b>Web page:</b> <a href='https://" + supplier.supplierWeb + "'>" + supplier.supplierWeb + "</a>");
		}
		
		toClient.println("<br>");
		toClient.println("<br>");
		toClient.println("<h2 class='w3-left'><b>ORDERS</b></h2><br>");
		toClient.println("<table class='w3-table w3-bordered ' style='margin:0 -8px'>");
		toClient.println("<div class='w3-half w3-margin-bottom'>");
		Vector<SuppliersData> ordersList;
		ordersList = SuppliersData.getSuppliersOrdersList(connection, id);
		
		for(int i=0; i< ordersList.size(); i++){	
			SuppliersData order = ordersList.elementAt(i);
			float precio =order.productBuyingPrice;
			int cantidad=order.quantity;
			float total = precio*cantidad;
			
			toClient.println("<tr class='w3-yellow w3-large w3-padding-32' ><th>" + order.orderDate + "</th><th>" + order.productName + "</th></tr>");
			toClient.println("<tr class='w3-padding-16'>");
				toClient.println("<td ><img src='cascos.png' class='w3-center' style='width:170px'></td>");
				toClient.println("<td>" + order.productDescription + "</td>");
				toClient.println("<td>" + order.quantity + " unidades</td>");
				toClient.println("<td width='200 px'><b>Precio: </b> "+ order.productBuyingPrice + " euros/unidad</td>");
				toClient.println("<td><b>Total:</b> " + total + " euros</td>");
				toClient.println("<td><a href='WorkerSupplierOrder?orderId=" + order.orderID + "' class='w3-button w3-block'><img src='market.png' class='w3-left' style='width:30px' ></a></td>");
			toClient.println("</tr>");
		}

		toClient.println("</div>");
		toClient.println("</table>");
		
		toClient.println("</div>");
		toClient.println("<br>");
		toClient.println("<br>");
		toClient.println("<br>");
		
		
		toClient.println(UtilsWorker.footer("SUPLLIER'S ORDERS"));
        toClient.println("</div>");
        toClient.close();
    }
}