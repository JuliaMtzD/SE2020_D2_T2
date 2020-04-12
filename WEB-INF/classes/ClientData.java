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
    int orders;
 	float revenue;


    ClientData (int clientId, String clientName,  int clientTelephone, int orders, float revenue) {
        this.clientId    = clientId;
        this.clientName  = clientName;
        this.clientTelephone = clientTelephone;
        this.orders=orders;
    	this.revenue=revenue;
    }
    public static Vector<ClientData> getClientList(Connection connection) {
        Vector<ClientData> vec = new Vector<ClientData>();
        
        
        
        String sql = " SELECT Clients.ClientID, Clients.ClientName, Clients.TelephoneNumber, Count(ClientOrders.OrderID) AS CuentaDeOrderID FROM Clients INNER JOIN ClientOrders ON Clients.ClientID = ClientOrders.Client GROUP BY Clients.ClientID, Clients.ClientName, Clients.TelephoneNumber ";
		String sql2 = "SELECT  Sum(Expr1) AS SumaDeExpr1 FROM (SELECT Clients.ClientID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]) AS Expr1 FROM Products INNER JOIN (Clients INNER JOIN (ClientOrders INNER JOIN ClientOrderDetails ON ClientOrders.OrderID = ClientOrderDetails.OrderID) ON Clients.ClientID = ClientOrders.Client) ON Products.ProductID = ClientOrderDetails.ProductID GROUP BY Clients.ClientID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity])) GROUP BY ClientID";
		

        System.out.println("getClientList: " + sql);
        System.out.println("getClientList: " + sql2);
        
        try {
            Statement statement=connection.createStatement();
            Statement statement2=connection.createStatement();
            
            ResultSet result = statement.executeQuery(sql);
            ResultSet result2 = statement2.executeQuery(sql2);
            
		while(result.next() && result2.next()) {
                ClientData client = new ClientData(
                    Integer.parseInt(result.getString("ClientID")),
                    result.getString("ClientName"),
                    Integer.parseInt(result.getString("TelephoneNumber")),
                    Integer.parseInt(result.getString("CuentaDeOrderID")),
               		Float.parseFloat(result2.getString("SumaDeExpr1"))
                );
                vec.addElement(client);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error in getClientList: " + sql + " Exception: " + e);
        }
        return vec;
    }

	

/* 
 public  static int[] getBestClient(Connection connection) {	
 		
 	int ID;
 	int money;
		String sql = "SELECT SumaDeExpr1, ClientID";
		
		sql= sql + "FROM (SELECT ClientID, Sum(Expr1) AS SumaDeExpr1";
		sql= sql + "FROM (SELECT Clients.ClientID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]) AS Expr1";
		sql= sql + "FROM Products INNER JOIN (Clients INNER JOIN (ClientOrders INNER JOIN ClientOrderDetails ON ClientOrders.OrderID = ClientOrderDetails.OrderID) ON Clients.ClientID = ClientOrders.Client) ON Products.ProductID = ClientOrderDetails.ProductID";
		sql= sql + "GROUP BY Clients.ClientID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]))  AS [Alias]";
		sql= sql + "GROUP BY ClientID)  AS Alias";
		sql= sql + "WHERE ((([Alias].[SumaDeExpr1])=(Select max(SumaDeExpr1) From (SELECT ClientID, Sum(Expr1) AS SumaDeExpr1";
		sql= sql + "FROM (SELECT Clients.ClientID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]) AS Expr1";
		sql= sql + "FROM Products INNER JOIN (Clients INNER JOIN (ClientOrders INNER JOIN ClientOrderDetails ON ClientOrders.OrderID = ClientOrderDetails.OrderID) ON Clients.ClientID = ClientOrders.Client) ON Products.ProductID = ClientOrderDetails.ProductID";
		sql= sql + "GROUP BY Clients.ClientID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]))  AS [Alias]";
		sql= sql + "GROUP BY ClientID))))";

        System.out.println("getClientList: " + sql);


        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            ID = result.getInt("ClientID");
            money =result.getInt("SumaDeExpr1");
               		
	
         }catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error in getBestClient: " + sql + " Exception: " + e);
        }
        
		int [] vec = {ID, money};
		
		return vec;
    }
 */

   
  
 public static int getBestClient(Connection connection) {
 
        
        String sql;
        sql="SELECT SumaDeExpr1, ClientID FROM (SELECT ClientID, Sum(Expr1) AS SumaDeExpr1 FROM (SELECT Clients.ClientID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]) AS Expr1 FROM Products INNER JOIN (Clients INNER JOIN (ClientOrders INNER JOIN ClientOrderDetails ON ClientOrders.OrderID = ClientOrderDetails.OrderID) ON Clients.ClientID = ClientOrders.Client) ON Products.ProductID = ClientOrderDetails.ProductID GROUP BY Clients.ClientID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]))  AS [Alias] GROUP BY ClientID)  AS Alias WHERE ((([Alias].[SumaDeExpr1])=(Select max(SumaDeExpr1) From (SELECT ClientID, Sum(Expr1) AS SumaDeExpr1 FROM (SELECT Clients.ClientID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]) AS Expr1 FROM Products INNER JOIN (Clients INNER JOIN (ClientOrders INNER JOIN ClientOrderDetails ON ClientOrders.OrderID = ClientOrderDetails.OrderID) ON Clients.ClientID = ClientOrders.Client) ON Products.ProductID = ClientOrderDetails.ProductID GROUP BY Clients.ClientID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]))  AS [Alias] GROUP BY ClientID))))";
        
        
        System.out.println("getBestClient: " + sql);
        int n = 0;
        
        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next() ) {
            n =result.getInt("ClientID");
			}

            
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error in getBestClient: " + sql + " Exception: " + e);
        }
        return n;
    }   
  
  public static float getBestRevenue(Connection connection) {
 
        
        String sql;
        sql="SELECT SumaDeExpr1, ClientID FROM (SELECT ClientID, Sum(Expr1) AS SumaDeExpr1 FROM (SELECT Clients.ClientID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]) AS Expr1 FROM Products INNER JOIN (Clients INNER JOIN (ClientOrders INNER JOIN ClientOrderDetails ON ClientOrders.OrderID = ClientOrderDetails.OrderID) ON Clients.ClientID = ClientOrders.Client) ON Products.ProductID = ClientOrderDetails.ProductID GROUP BY Clients.ClientID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]))  AS [Alias] GROUP BY ClientID)  AS Alias WHERE ((([Alias].[SumaDeExpr1])=(Select max(SumaDeExpr1) From (SELECT ClientID, Sum(Expr1) AS SumaDeExpr1 FROM (SELECT Clients.ClientID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]) AS Expr1 FROM Products INNER JOIN (Clients INNER JOIN (ClientOrders INNER JOIN ClientOrderDetails ON ClientOrders.OrderID = ClientOrderDetails.OrderID) ON Clients.ClientID = ClientOrders.Client) ON Products.ProductID = ClientOrderDetails.ProductID GROUP BY Clients.ClientID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]))  AS [Alias] GROUP BY ClientID))))";
        
        
        System.out.println("getBestRevenue: " + sql);
        float n = 0;
        
        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next() ) {
				n =result.getFloat("SumaDeExpr1");		
			}
            
            
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error in getBestClient: " + sql + " Exception: " + e);
        }
        return n;
    }      
    
}	
	
	
	