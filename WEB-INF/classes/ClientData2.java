import java.util.Vector;

import java.sql.Connection;

import java.sql.Statement;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;



public class ClientData2 {

    String	clientId;

    String	clientName;

    String	clientadress;

	String creditcard;

	String cleintemail;
	
	String clientpassword;

	String clienttelephone;
	
	

    ClientData2 (String clientId, String clientName, String clientadress, String creditcard, String cleintemail, String clientpassword, String clienttelephone) {

        this.clientId    = clientId;

        this.clientName  = clientName;
		
		this.clientadress = clientadress;
		
		this.creditcard = creditcard;

		this.cleintemail = cleintemail;
		
		this.clientpassword = clientpassword;
		
		this.clienttelephone = clienttelephone;

    }
	
	    ClientData2 (String clientId, String clientadress, String creditcard, String cleintemail, String clientpassword, String clienttelephone) {

        this.clientId    = clientId;
		
		this.clientadress = clientadress;
		
		this.creditcard = creditcard;

		this.cleintemail = cleintemail;
		
		this.clientpassword = clientpassword;
		
		this.clienttelephone = clienttelephone;

    }

	
    public static Vector<ClientData2> getClientList(Connection connection) {

        Vector<ClientData2> vec = new Vector<ClientData2>();

        String sql = "SELECT Clients.ClientID, Clients.ClientName, Clients.Adress, Clients.CreditCard, Clients.Email, Clients.Password, Clients.TelephoneNumber FROM Clients";


        System.out.println("getClientList: " + sql);

        try {

            Statement statement=connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while(result.next()) {
	
                ClientData2 client = new ClientData2(

                    result.getString("ClientID"),

                    result.getString("ClientName"),
					
					result.getString("Adress"),
					
					result.getString("CreditCard"),
					
					result.getString("Email"),
					
					result.getString("Password"),
					
					result.getString("TelephoneNumber")

                );
				
                vec.addElement(client);

            }

        } catch(SQLException e) {

            e.printStackTrace();

            System.out.println("Error in getClientList: " + sql + " Exception: " + e);

        }

        return vec;

    }


	
	public static Vector<ClientData2> getClient(Connection connection, String name) {

        Vector<ClientData2> vec = new Vector<ClientData2>();

        String sql = "SELECT Clients.ClientID, Clients.Adress, Clients.CreditCard, Clients.Email, Clients.Password, Clients.TelephoneNumber FROM Clients WHERE Clients.ClientName='"+name+"'";


        System.out.println("getClientList: " + sql);

        try {

            Statement statement=connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while(result.next()) {
	
                ClientData2 client = new ClientData2(

                    result.getString("ClientID"),
					
					result.getString("Adress"),
					
					result.getString("CreditCard"),
					
					result.getString("Email"),
					
					result.getString("Password"),
					
					result.getString("TelephoneNumber")

                );
				
                vec.addElement(client);

            }

        } catch(SQLException e) {

            e.printStackTrace();

            System.out.println("Error in getClient: " + sql + " Exception: " + e);

        }

        return vec;

    }
	
	
	
	
	
}