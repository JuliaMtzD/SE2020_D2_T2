import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;

@SuppressWarnings("serial")
public class WorkerUpdate extends HttpServlet {
    Connection connection;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        connection = ConnectionUtils.getConnection(config);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
        res.setContentType("text/html");
        String idStr = req.getParameter("WorkerID");
		
		
		      
		WorkerData worker = new WorkerData(
		
                    Integer.parseInt(req.getParameter("WorkerID")),
                    req.getParameter("WorkerName"),
                    req.getParameter("WorkerLastName"),
                    req.getParameter("WorkerPassword"),
                    req.getParameter("WorkerEmail"), 
                    req.getParameter("WorkerDepartment")        
                );
				
		
		 int n2 = WorkerData.updateWorker(connection, worker);

		
		//---------------------------------------------
//		res.sendRedirect("WorkerEdit?id=" + idStr + "&a=" + Math.random());
	res.sendRedirect("WorkerMyAccount?id="+idStr+""); 
    }
}