import java.util.Vector;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkerData {
    int workerId;
	String workerName;
	String workerLastName;
	String workerPassword;
	String workerEmail;
	String workerDepartment;

WorkerData (int workerId, String workerName, String workerLastName, String workerPassword, String workerEmail, String workerDepartment) {
        this.workerId = workerId;
        this.workerName  = workerName;
        this.workerLastName = workerLastName;
        this.workerPassword=workerPassword;
    	this.workerEmail=workerEmail;
    	this.workerDepartment=workerDepartment; 	
    }
    
    public static Vector<WorkerData> getWorkerList(Connection connection) {
        Vector<WorkerData> vec = new Vector<WorkerData>();
        
        String sql = "SELECT Workers.WorkerID, Workers.FirstName, Workers.LastName, Workers.Password, Workers.Email, Workers.Department FROM Workers WHERE (([Workers].[WorkerID]=1))";
        System.out.println("getClientList: " + sql);
        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            
		while(result.next() ) {
                WorkerData worker = new WorkerData(
                    result.getInt("WorkerID"),
                    result.getString("FirstName"),
                    result.getString("LastName"),
                    result.getString("Password"),
                    result.getString("Email"),
                    result.getString("Department")

                );
                vec.addElement(worker);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error in getWorkerList: " + sql + " Exception: " + e);
        }
        return vec;
    }
    
    public static Vector<WorkerData> getWorkerList2(Connection connection, String Id) {
        Vector<WorkerData> vec = new Vector<WorkerData>();
        
        String sql = "SELECT Workers.WorkerID, Workers.FirstName, Workers.LastName, Workers.Password, Workers.Email, Workers.Department FROM Workers WHERE (([Workers].[WorkerID]="+Id+")";
        System.out.println("getClientList: " + sql);
        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            
		while(result.next() ) {
                WorkerData worker = new WorkerData(
                    result.getInt("WorkerID"),
                    result.getString("FirstName"),
                    result.getString("LastName"),
                    result.getString("Password"),
                    result.getString("Email"),
                    result.getString("Department")

                );
                vec.addElement(worker);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error in getWorkerList: " + sql + " Exception: " + e);
        }
        return vec;
    }
	public static int updateWorker(Connection connection, WorkerData worker) {
        String sql ="UPDATE Workers "
            + "SET FirstName = ?, LastName = ?, Password = ?, Email=?, Department=?"
            + " WHERE WorkerID = ?";
        System.out.println("updateWorker: " + sql);
        int n = 0;
        try {
            PreparedStatement stmtUpdate= connection.prepareStatement(sql);
            stmtUpdate.setString(1,worker.workerName);
            stmtUpdate.setString(2,worker.workerLastName);
            stmtUpdate.setString(3,worker.workerPassword);
            stmtUpdate.setString(4,worker.workerEmail);
            stmtUpdate.setString(5,worker.workerDepartment);
            stmtUpdate.setInt(6,worker.workerId);

            
			
			n = stmtUpdate.executeUpdate();
            stmtUpdate.close();
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error in updateWorker: " + sql + " Exception: " + e);
        }
        return n;
    }
}