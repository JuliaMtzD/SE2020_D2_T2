	
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;

@SuppressWarnings("serial")
public class WorkerMyAccount extends HttpServlet {
    Connection connection;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        connection = ConnectionUtils.getConnection(config);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
        res.setContentType("text/html");
        PrintWriter toClient = res.getWriter();
		
		toClient.println(UtilsWorker.header("MY ACCOUNT", "WorkerMainPage.html"));



toClient.println("<div class='w3-main' style='margin-left:300px'>");

toClient.println("<div class='w3-container w3-white w3-center w3-padding-32 w3-padding-large w3-text-align:left' id='LogIn'>");
  toClient.println("  <div class='w3-content' style='max-width:600px '>");
 toClient.println("   <h1 class='w3-center'><b>WORKER MY ACCOUNT</b></h1>");
 
 int ID = Integer.parseInt(req.getParameter("id"));

 Vector<WorkerData> workerList;
 workerList = WorkerData.getWorkerList2(connection, ID);
  
  
for(int i=0; i< workerList.size(); i++){  


		WorkerData worker = workerList.elementAt(i);  
    	toClient.println("<div class='w3-container w3-dark-grey w3-center w3-padding-32 w3-padding-large w3-text-align:left' id='personalinformation'>");
      	toClient.println(" <h4 class='w3-center'><b> Personal Information </b></h4>");
      	toClient.println(" <form action='WorkerUpdate' target='_blank'> ");
      

      	toClient.println(" <div class='w3-section' >");
       	toClient.println("   <label for='WorkerID'> Username </label>");
        toClient.println(" <input class='w3-input w3-border' type='text' name='WorkerID' id='WorkerID' readonly value="+ worker.workerId+" >");
       	toClient.println(" </div>");
  
        toClient.println("<div class='w3-section'>");
        toClient.println("<label for='WorkerName'> Name </label>");
        toClient.println("<input class='w3-input w3-border' type='text' name='WorkerName' id='WorkerName'  value="+ worker.workerName+">");
        toClient.println(" </div>");
        
        toClient.println("<div class='w3-section'>");
        toClient.println("<label for='WorkerLastName'> Last Name </label>");
		toClient.println("<input class='w3-input w3-border' type='text' name='WorkerLastName' id='WorkerLastName'  value="+ worker.workerLastName+">");
        toClient.println(" </div>");
        
        
        toClient.println(" <div class='w3-section' >");
        toClient.println("<label for='WorkerPasswod'> Password </label>");
		toClient.println("<input class='w3-input w3-border' type='password' name='WorkerPassword' id='WorkerPassword'  value="+ worker.workerPassword+">");
        toClient.println(" </div>");
        toClient.println(" </div>");
        
        toClient.println(" <div class='w3-container w3-grey w3-center w3-padding-32 w3-padding-large w3-text-align:left' id='Companyinformation'>");
    	toClient.println(" <h4 class='w3-center'><b> Company Information </b></h4>");
        
        toClient.println(" <div class='w3-section'>");
        toClient.println(" <label for='WorkerEmail'> Email </label>");
        toClient.println("  <input class='w3-input w3-border' type='text' name='WorkerEmail' id='WorkerEmail'  value="+ worker.workerEmail+">");
        toClient.println(" </div>");
        
        toClient.println(" <div class='w3-section' >");
         toClient.println("  <label for='WorkerDepartment'> Department </label>");
        toClient.println("  <input class='w3-input w3-border' type='text' name='WorkerDepartment' id='WorkerDepartment' value="+ worker.workerDepartment+">");
        toClient.println(" </div>");
        

        
         toClient.println(" </div>");
     }   
        

       toClient.println(" <input type='submit' value='Save Changes' class='w3-button w3-block w3-yellow w3-margin-bottom' >");
    	toClient.println("  <button type='submit' formaction='WorkerDelete' class='w3-button w3-block w3-yellow w3-margin-bottom' >Delete Account</button>");
      	toClient.println("</form>");
 
 
  toClient.println("  </div>");
  toClient.println("</div>");




 
   toClient.println("</div>");
	toClient.println(UtilsWorker.footer("CLIENT REPORT"));

	toClient.println("</div> ");
	toClient.close();

    }
}		
 				
 				
 				
 				
 				
 				
 