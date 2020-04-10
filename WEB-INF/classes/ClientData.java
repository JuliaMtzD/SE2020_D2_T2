import java.util.Vector;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientData {
    int clientId;
	String clientName;
    int clientTelephone;


    ClientData (int clientId, String clientName,  int clientTelephone) {
        this.clientId    = clientId;
        this.clientName  = clientName;
        this.clientTelephone = clientTelephone;

    }
    public static Vector<ClientData> getClientList(Connection connection) {
        Vector<ClientData> vec = new Vector<ClientData>();
        String sql = "Select ClientID, ClientName, TelephoneNumber FROM Clients";
        System.out.println("getClientList: " + sql);
        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()) {
                ClientData client = new ClientData(
                    Integer.parseInt(result.getString("ClientID")),
                    result.getString("ClientName"),
                    Integer.parseInt(result.getString("TelephoneNumber"))
                );
                vec.addElement(client);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error in getClientList: " + sql + " Exception: " + e);
        }
        return vec;
    }
}
	
	
	
	
	
	