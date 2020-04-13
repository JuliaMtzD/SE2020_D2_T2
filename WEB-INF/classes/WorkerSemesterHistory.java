import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;

@SuppressWarnings("serial")
public class WorkerSemesterHistory extends HttpServlet {
    Connection connection;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        connection = ConnectionUtils.getConnection(config);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
        res.setContentType("text/html");
        PrintWriter toClient = res.getWriter();
		
		toClient.println(UtilsWorker.header("SEMESTER HISTORY", "WorkerMainPage.html"));

	int  n1 = HistoryData.getOrdersSemester1(connection);
	float m1 = HistoryData.getRevenueSemester1(connection);
	
	int  n2 = HistoryData.getOrdersSemester2(connection);
	float  m2 = HistoryData.getRevenueSemester2(connection);
	
	int  n3 = HistoryData.getOrdersSemester3(connection);
	float  m3 = HistoryData.getRevenueSemester3(connection);
	
	int  n4 = HistoryData.getOrdersSemester4(connection);
	float  m4 = HistoryData.getRevenueSemester4(connection);


toClient.println("<div class='w3-main' style='margin-left:300px'>");

toClient.println("<div class='w3-container w3-white w3-center w3-padding-32 w3-padding-large w3-text-align:left' >");
   toClient.println("<div class='w3-content' style='max-width:600px'>");
    toClient.println("	<h1 class='w3-center'><b> HISTORY BY SEMESTER </b></h1>");
    	toClient.println("<div class='w3-container w3-dark-grey w3-center w3-padding-32 w3-padding-large w3-text-align:left' >");
       		toClient.println("<h4 class='w3-center'><b> 1st Semester 2019 (January - June) </b></h4>");
       		toClient.println("<div class='w3-container w3-grey w3-center w3-padding-32 w3-padding-large w3-text-align:left'>");
       		toClient.println("<h5 > Number of orders:"+ n1+" </h5>");
       		toClient.println("<h5 > Total revenue orders:"+ m1+" $</h5>");
       		toClient.println("<h5 > Orders: </h5>");
       		toClient.println(" <table class='w3-table w3-bordered' style='margin: 0-16 px'>");
			toClient.println("	<div class='w3-half w3-margin-bottom'>");
			toClient.println("	  <ul class='w3-ul w3-white w3-center'>");
			toClient.println("			<tr class='w3-yellow w3-large w3-padding-32'>");
			toClient.println("			  <th >Order ID </th>");
			toClient.println("			  <th>Order Date</th>");
			toClient.println("			  <th> Revenue</th>");
			toClient.println("			</tr>");
			
			Vector<HistoryData> historyList;
						historyList = HistoryData.getHistoryList1(connection);
		
        				for(int i=0; i< historyList.size(); i++){
							HistoryData history = historyList.elementAt(i);
							toClient.println("<tr class='w3-padding-16'>");
							toClient.println("<td>" + history.orderId + " </td>");
							toClient.println("<td>" + history.orderDate + " </td>");
							toClient.println("<td>" + history.revenue + " </td>");
							toClient.println("</tr>");
       					 }
			toClient.println("	  	</ul>");
			toClient.println("	  </div>");
			toClient.println("</table>");
       		toClient.println("</div>");
       toClient.println(" </div>");
        
       toClient.println(" <div class='w3-container w3-grey w3-center w3-padding-32 w3-padding-large w3-text-align:left' >");
        	toClient.println("<h4 class='w3-center'><b> 2nd Semester 2019 (July - December) </b></h4>");
       		toClient.println("<div class='w3-container w3-dark-grey w3-center w3-padding-32 w3-padding-large w3-text-align:left' >	");
       		toClient.println("<h5 > Number of orders: "+ n2+" </h5>");
       		toClient.println("<h5 > Total revenue orders: "+ m2 +" $</h5>");
       		toClient.println("<h5 > Orders: </h5>");
       		toClient.println(" <table class='w3-table w3-bordered' style='margin: 0-16 px'>");
			toClient.println("	<div class='w3-half w3-margin-bottom'>");
			toClient.println("	  <ul class='w3-ul w3-white w3-center'>");
			toClient.println("			<tr class='w3-yellow w3-large w3-padding-32'>");
			toClient.println("			  <th >Order ID </th>");
			toClient.println("			  <th>Order Date</th>");
			toClient.println("			  <th>Client</th>");
			toClient.println("			  <th> Revenue</th>");
			toClient.println("			</tr>");
			Vector<HistoryData> historyList2;
						historyList2 = HistoryData.getHistoryList2(connection);
		
        				for(int i=0; i< historyList.size(); i++){
							HistoryData history2 = historyList2.elementAt(i);
							toClient.println("<tr class='w3-padding-16'>");
							toClient.println("<td>" + history2.orderId + " </td>");
							toClient.println("<td>" + history2.orderDate + " </td>");
							toClient.println("<td>" + history2.revenue + " </td>");
							toClient.println("</tr>");
       					 }
			toClient.println("	  	</ul>");
			toClient.println("	  </div>");
			toClient.println("</table>");
       		toClient.println("</div>");
       toClient.println(" </div>");
        
    	toClient.println("<div class='w3-container w3-dark-grey w3-center w3-padding-32 w3-padding-large w3-text-align:left' >");
       	toClient.println("	<h4 class='w3-center'><b> 1st Semester 2020 (January - June) </b></h4>");
       	toClient.println("	<div class='w3-container w3-grey w3-center w3-padding-32 w3-padding-large w3-text-align:left' >	");
       		toClient.println("<h5 > Number of orders: "+n3+" </h5>");
       		toClient.println("<h5 > Total revenue orders: "+m3+" $</h5>");
       		toClient.println("<h5 > Orders: </h5>");
       		toClient.println(" <table class='w3-table w3-bordered' style='margin: 0-16 px'>");
			toClient.println("	<div class='w3-half w3-margin-bottom'>");
			toClient.println("	  <ul class='w3-ul w3-white w3-center'>");
			toClient.println("			<tr class='w3-yellow w3-large w3-padding-32'>");
			toClient.println("			  <th >Order ID </th>");
			toClient.println("			  <th>Order Date</th>");
			toClient.println("			  <th>Client</th>");
			toClient.println("			  <th> Revenue</th>");
			toClient.println("			</tr>");
			Vector<HistoryData> historyList3;
						historyList3 = HistoryData.getHistoryList3(connection);
		
        				for(int i=0; i< historyList3.size(); i++){
							HistoryData history3 = historyList3.elementAt(i);
							toClient.println("<tr class='w3-padding-16'>");
							toClient.println("<td>" + history3.orderId + " </td>");
							toClient.println("<td>" + history3.orderDate + " </td>");
							toClient.println("<td>" + history3.revenue + " </td>");
							toClient.println("</tr>");
       					 }
			toClient.println("	  	</ul>");
			toClient.println("	  </div>");
			toClient.println("</table>");
       		toClient.println("</div>");
       toClient.println(" </div>");
        
       toClient.println(" <div class='w3-container w3-grey w3-center w3-padding-32 w3-padding-large w3-text-align:left' >");
        toClient.println("	<h4 class='w3-center'><b> 2nd Semester 2020 (July - December) </b></h4>");
       	toClient.println("	<div class='w3-container w3-dark-grey w3-center w3-padding-32 w3-padding-large w3-text-align:left' >	");
       		toClient.println("<h5 > Number of orders: "+n4+" </h5>");
       		toClient.println("<h5 > Total revenue orders: "+m4+" $</h5>");
       		toClient.println("<h5 > Orders: </h5>");
       		toClient.println(" <table class='w3-table w3-bordered' style='margin: 0-16 px'>");
			toClient.println("	<div class='w3-half w3-margin-bottom'>");
			toClient.println("	  <ul class='w3-ul w3-white w3-center'>");
			toClient.println("			<tr class='w3-yellow w3-large w3-padding-32'>");
			toClient.println("			  <th >Order ID </th>");
			toClient.println("			  <th>Order Date</th>");
			toClient.println("			  <th>Client</th>");
			toClient.println("			  <th> Revenue</th>");
			toClient.println("			</tr>");
			Vector<HistoryData> historyList4;
						historyList4 = HistoryData.getHistoryList4(connection);
		
        				for(int i=0; i< historyList4.size(); i++){
							HistoryData history4 = historyList4.elementAt(i);
							toClient.println("<tr class='w3-padding-16'>");
							toClient.println("<td>" + history4.orderId + " </td>");
							toClient.println("<td>" + history4.orderDate + " </td>");
							toClient.println("<td>" + history4.revenue + " </td>");
							toClient.println("</tr>");
       					 }
			toClient.println("	  	</ul>");
			toClient.println("	  </div>");
			toClient.println("</table>");
       		toClient.println("</div>");
       toClient.println(" </div>");
        

 
 
  toClient.println("  </div>");
  toClient.println("</div>");
	
toClient.println("  </div>");
	
	
	
	
	toClient.println(UtilsWorker.footer("SEMESTER HISOTRY"));

	toClient.println("</div> ");
	toClient.close();

    }
}