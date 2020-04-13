import java.util.Vector;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoryData {
    int orderId;
	String orderDate;
    float revenue;



    HistoryData (int orderId, String orderDate, float revenue) {
        this.orderId    = orderId;
        this.orderDate = orderDate;
    	this.revenue=revenue;
    }

 
 
	public static Vector<HistoryData> getHistoryList1(Connection connection) {
        Vector<HistoryData> vec = new Vector<HistoryData>();
        
        
        
       	String sql="SELECT OrderID, OrderDate, Sum(Expr1) AS SumaDeExpr1 FROM (SELECT ClientOrders.OrderID, ClientOrderDetails.ProductID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]) AS Expr1, ClientOrders.OrderDate FROM Products INNER JOIN (ClientOrders INNER JOIN ClientOrderDetails ON ClientOrders.OrderID = ClientOrderDetails.OrderID) ON Products.ProductID = ClientOrderDetails.ProductID WHERE (((ClientOrders.OrderDate) Between #1/1/2019# And #6/30/2019#)) )  AS [Alias] GROUP BY OrderID, OrderDate" ;
		System.out.println("getClientList: " + sql);

        
        try {
           	Statement statement=connection.createStatement();
          	 
          	ResultSet result = statement.executeQuery(sql);

            
		while(result.next()) {
                HistoryData history = new HistoryData(
                    Integer.parseInt(result.getString("OrderID")),
                    result.getString("OrderDate"),
               		Float.parseFloat(result.getString("SumaDeExpr1"))
                );
                vec.addElement(history);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error in getHistoryList: " + sql + " Exception: " + e);
        }
        return vec;
    }
   	public static Vector<HistoryData> getHistoryList2(Connection connection) {
        Vector<HistoryData> vec = new Vector<HistoryData>();
        
        
        
       	String sql="SELECT OrderID, OrderDate, Sum(Expr1) AS SumaDeExpr1 FROM (SELECT ClientOrders.OrderID, ClientOrderDetails.ProductID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]) AS Expr1, ClientOrders.OrderDate FROM Products INNER JOIN (ClientOrders INNER JOIN ClientOrderDetails ON ClientOrders.OrderID = ClientOrderDetails.OrderID) ON Products.ProductID = ClientOrderDetails.ProductID WHERE (((ClientOrders.OrderDate) Between #7/1/2019# And #12/31/2019#)) )  AS [Alias] GROUP BY OrderID, OrderDate" ;
		System.out.println("getClientList: " + sql);

        
        try {
           	Statement statement=connection.createStatement();
          	 
          	ResultSet result = statement.executeQuery(sql);

            
		while(result.next()) {
                HistoryData history = new HistoryData(
                    Integer.parseInt(result.getString("OrderID")),
                    result.getString("OrderDate"),
               		Float.parseFloat(result.getString("SumaDeExpr1"))
                );
                vec.addElement(history);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error in getHistoryList2: " + sql + " Exception: " + e);
        }
        return vec;
    }
   	public static Vector<HistoryData> getHistoryList3(Connection connection) {
        Vector<HistoryData> vec = new Vector<HistoryData>();
        
        
        
       	String sql="SELECT OrderID, OrderDate, Sum(Expr1) AS SumaDeExpr1 FROM (SELECT ClientOrders.OrderID, ClientOrderDetails.ProductID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]) AS Expr1, ClientOrders.OrderDate FROM Products INNER JOIN (ClientOrders INNER JOIN ClientOrderDetails ON ClientOrders.OrderID = ClientOrderDetails.OrderID) ON Products.ProductID = ClientOrderDetails.ProductID WHERE (((ClientOrders.OrderDate) Between #1/1/2020# And #6/30/2020#)) )  AS [Alias] GROUP BY OrderID, OrderDate" ;
		System.out.println("getHistoryList3: " + sql);

        
        try {
           	Statement statement=connection.createStatement();
          	 
          	ResultSet result = statement.executeQuery(sql);

            
		while(result.next()) {
                HistoryData history = new HistoryData(
                    Integer.parseInt(result.getString("OrderID")),
                    result.getString("OrderDate"),
               		Float.parseFloat(result.getString("SumaDeExpr1"))
                );
                vec.addElement(history);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error in getHistoryList3: " + sql + " Exception: " + e);
        }
        return vec;
    }
    public static Vector<HistoryData> getHistoryList4(Connection connection) {
        Vector<HistoryData> vec = new Vector<HistoryData>();
        
        
        
       	String sql="SELECT OrderID, OrderDate, Sum(Expr1) AS SumaDeExpr1 FROM (SELECT ClientOrders.OrderID, ClientOrderDetails.ProductID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]) AS Expr1, ClientOrders.OrderDate FROM Products INNER JOIN (ClientOrders INNER JOIN ClientOrderDetails ON ClientOrders.OrderID = ClientOrderDetails.OrderID) ON Products.ProductID = ClientOrderDetails.ProductID WHERE (((ClientOrders.OrderDate) Between #7/1/2020# And #12/31/2020#)) )  AS [Alias] GROUP BY OrderID, OrderDate" ;
		System.out.println("getHistoryList4: " + sql);

        
        try {
           	Statement statement=connection.createStatement();
          	 
          	ResultSet result = statement.executeQuery(sql);

            
		while(result.next()) {
                HistoryData history = new HistoryData(
                    Integer.parseInt(result.getString("OrderID")),
                    result.getString("OrderDate"),
               		Float.parseFloat(result.getString("SumaDeExpr1"))
                );
                vec.addElement(history);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error in getHistoryList4: " + sql + " Exception: " + e);
        }
        return vec;
    } 

 	public static int getOrdersSemester1(Connection connection) {
 
        
        String sql;
        sql="SELECT Count(OrderID) AS CuentaDeOrderID FROM (SELECT OrderID, OrderDate, Sum([Alias].Expr1) AS SumaDeExpr1 FROM (SELECT ClientOrders.OrderID, ClientOrderDetails.ProductID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]) AS Expr1, ClientOrders.OrderDate FROM Products INNER JOIN (ClientOrders INNER JOIN ClientOrderDetails ON ClientOrders.OrderID = ClientOrderDetails.OrderID) ON Products.ProductID = ClientOrderDetails.ProductID WHERE (((ClientOrders.OrderDate) Between #1/1/2019# And #6/30/2019#)) )  AS [Alias] GROUP BY OrderID, OrderDate)";
        
        System.out.println("getOrdersSemester1: " + sql);
        int n = 0;
        
        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next() ) {
            n =result.getInt("CuentaDeOrderID");
			}

            
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error in getOrdersSemester1: " + sql + " Exception: " + e);
        }
        return n;
    }   
  	public static float getRevenueSemester1(Connection connection) {
 
        
        String sql;
        sql="SELECT Sum(Expr1) AS SumaDeExpr1 FROM (SELECT ClientOrders.OrderID, ClientOrderDetails.ProductID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]) AS Expr1, ClientOrders.OrderDate FROM Products INNER JOIN (ClientOrders INNER JOIN ClientOrderDetails ON ClientOrders.OrderID = ClientOrderDetails.OrderID) ON Products.ProductID = ClientOrderDetails.ProductID WHERE (((ClientOrders.OrderDate) Between #1/1/2019# And #6/30/2019#)))";
        
        System.out.println("getRevenueSemester1: " + sql);
        float n = 0;
        
        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next() ) {
				n =result.getFloat("SumaDeExpr1");		
			}
            
            
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error in getRevenueSemester1: " + sql + " Exception: " + e);
        }
        return n;
    }     

  	public static int getOrdersSemester2(Connection connection) {
 
        
        String sql;
        sql="SELECT Count(OrderID) AS CuentaDeOrderID FROM (SELECT OrderID, OrderDate, Sum([Alias].Expr1) AS SumaDeExpr1 FROM (SELECT ClientOrders.OrderID, ClientOrderDetails.ProductID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]) AS Expr1, ClientOrders.OrderDate FROM Products INNER JOIN (ClientOrders INNER JOIN ClientOrderDetails ON ClientOrders.OrderID = ClientOrderDetails.OrderID) ON Products.ProductID = ClientOrderDetails.ProductID WHERE (((ClientOrders.OrderDate) Between #7/1/2019# And #12/31/2019#)) )  AS [Alias] GROUP BY OrderID, OrderDate)";
        
        System.out.println("getOrdersSemester1: " + sql);
        int n = 0;
        
        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next() ) {
            n =result.getInt("CuentaDeOrderID");
			}

            
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error in getOrdersSemester2: " + sql + " Exception: " + e);
        }
        return n;
    }   
  	public static float getRevenueSemester2(Connection connection) {
 
        
        String sql;
        sql="SELECT Sum(Expr1) AS SumaDeExpr1 FROM (SELECT ClientOrders.OrderID, ClientOrderDetails.ProductID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]) AS Expr1, ClientOrders.OrderDate FROM Products INNER JOIN (ClientOrders INNER JOIN ClientOrderDetails ON ClientOrders.OrderID = ClientOrderDetails.OrderID) ON Products.ProductID = ClientOrderDetails.ProductID WHERE (((ClientOrders.OrderDate) Between #7/1/2019# And #12/31/2019#)))";
        
        System.out.println("getRevenueSemester2: " + sql);
        float n = 0;
        
        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next() ) {
				n =result.getFloat("SumaDeExpr1");		
			}
            
            
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error in getRevenueSemester2: " + sql + " Exception: " + e);
        }
        return n;
    }       
    
 	public static int getOrdersSemester3(Connection connection) {
 
        
        String sql;
        sql="SELECT Count(OrderID) AS CuentaDeOrderID FROM (SELECT OrderID, OrderDate, Sum([Alias].Expr1) AS SumaDeExpr1 FROM (SELECT ClientOrders.OrderID, ClientOrderDetails.ProductID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]) AS Expr1, ClientOrders.OrderDate FROM Products INNER JOIN (ClientOrders INNER JOIN ClientOrderDetails ON ClientOrders.OrderID = ClientOrderDetails.OrderID) ON Products.ProductID = ClientOrderDetails.ProductID WHERE (((ClientOrders.OrderDate) Between #1/1/2020# And #6/30/2020#)) )  AS [Alias] GROUP BY OrderID, OrderDate)";
        
        System.out.println("getOrdersSemester3: " + sql);
        int n = 0;
        
        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next() ) {
            n =result.getInt("CuentaDeOrderID");
			}

            
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error in getOrdersSemester1: " + sql + " Exception: " + e);
        }
        return n;
    }   
  	public static float getRevenueSemester3(Connection connection) {
 
        
        String sql;
        sql="SELECT Sum(Expr1) AS SumaDeExpr1 FROM (SELECT ClientOrders.OrderID, ClientOrderDetails.ProductID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]) AS Expr1, ClientOrders.OrderDate FROM Products INNER JOIN (ClientOrders INNER JOIN ClientOrderDetails ON ClientOrders.OrderID = ClientOrderDetails.OrderID) ON Products.ProductID = ClientOrderDetails.ProductID WHERE (((ClientOrders.OrderDate) Between #1/1/2020# And #6/30/2020#)))";
        
        System.out.println("getRevenueSemester3: " + sql);
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

 	public static int getOrdersSemester4(Connection connection) {
 
        
        String sql;
        sql="SELECT Count(OrderID) AS CuentaDeOrderID FROM (SELECT OrderID, OrderDate, Sum([Alias].Expr1) AS SumaDeExpr1 FROM (SELECT ClientOrders.OrderID, ClientOrderDetails.ProductID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]) AS Expr1, ClientOrders.OrderDate FROM Products INNER JOIN (ClientOrders INNER JOIN ClientOrderDetails ON ClientOrders.OrderID = ClientOrderDetails.OrderID) ON Products.ProductID = ClientOrderDetails.ProductID WHERE (((ClientOrders.OrderDate) Between #7/1/2020# And #12/31/2020#)) )  AS [Alias] GROUP BY OrderID, OrderDate)";
        
        System.out.println("getOrdersSemester4: " + sql);
        int n = 0;
        
        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next() ) {
            n =result.getInt("CuentaDeOrderID");
			}

            
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error in getOrdersSemester1: " + sql + " Exception: " + e);
        }
        return n;
    }   
  	public static float getRevenueSemester4(Connection connection) {
 
        
        String sql;
        sql="SELECT Sum(Expr1) AS SumaDeExpr1 FROM (SELECT ClientOrders.OrderID, ClientOrderDetails.ProductID, ([Products].[SellingPrice]*[ClientOrderDetails].[Quantity]) AS Expr1, ClientOrders.OrderDate FROM Products INNER JOIN (ClientOrders INNER JOIN ClientOrderDetails ON ClientOrders.OrderID = ClientOrderDetails.OrderID) ON Products.ProductID = ClientOrderDetails.ProductID WHERE (((ClientOrders.OrderDate) Between #7/1/2020# And #12/31/2020#)))";
        
        System.out.println("getRevenueSemester1: " + sql);
        float n = 0;
        
        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next() ) {
				n =result.getFloat("SumaDeExpr1");		
			}
            
            
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error in getRevenueSemester4: " + sql + " Exception: " + e);
        }
        return n;
    }     
    
    
}	
	
	
	