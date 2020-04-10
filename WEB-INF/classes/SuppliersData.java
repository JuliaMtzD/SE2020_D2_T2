import java.util.Vector;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SuppliersData {
    int supplierId;
	String supplierName;
    String supplierAdress;
    int supplierTelephone;
    String supplierWeb;
	int orderID;
	int quantity;
	String orderDate;
	String productName;
	float productBuyingPrice;
	String productDescription;

    SuppliersData (int supplierId, String supplierName, String supplierAdress, int supplierTelephone, String supplierWeb) {
        this.supplierId    = supplierId;
        this.supplierName  = supplierName;
        this.supplierAdress   = supplierAdress;
        this.supplierTelephone = supplierTelephone;
        this.supplierWeb = supplierWeb;
    }
	
	SuppliersData (int supplierId, int orderID, int quantity, String orderDate, String productName, float productBuyingPrice, String productDescription) {
        this.supplierId  = supplierId;
		this.orderID = orderID;
		this.quantity = quantity;
		this.orderDate = orderDate;
		this.productName = productName;
		this.productBuyingPrice = productBuyingPrice;
		this.productDescription = productDescription;
    }
	
    public static Vector<SuppliersData> getSuppliersList(Connection connection) {
        Vector<SuppliersData> vec = new Vector<SuppliersData>();
        String sql = "Select SupplierID, SupplierName, Adress, TelephoneNumber, WebPage FROM Suppliers";
        System.out.println("getSuppliersList: " + sql);
        try {
            Statement statement=connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()) {
                SuppliersData supplier = new SuppliersData(
                    Integer.parseInt(result.getString("SupplierID")),
                    result.getString("SupplierName"),
                    result.getString("Adress"),
                    Integer.parseInt(result.getString("TelephoneNumber")),
                    result.getString("WebPage")
                );
                vec.addElement(supplier);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error in getSuppliersList: " + sql + " Exception: " + e);
        }
        return vec;
    }
	public static Vector<SuppliersData> getSupplier(Connection connection, String id) {
        Vector<SuppliersData> vec = new Vector<SuppliersData>();
        String sql = "Select SupplierName, Adress, TelephoneNumber, WebPage FROM Suppliers";
		sql += " WHERE SupplierID=?";
        System.out.println("getSupplier: " + sql);
        try {
            PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(id));
            ResultSet result = pstmt.executeQuery();
            while(result.next()) {
                SuppliersData supplier = new SuppliersData(
                    Integer.parseInt(id),
                    result.getString("SupplierName"),
                    result.getString("Adress"),
                    Integer.parseInt(result.getString("TelephoneNumber")),
                    result.getString("WebPage")
                );
                vec.addElement(supplier);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error in getSupplier: " + sql + " Exception: " + e);
        }
        return vec;
    }
	public static Vector<SuppliersData> getSuppliersOrdersList(Connection connection, String id) {
        Vector<SuppliersData> vec = new Vector<SuppliersData>();
        String sql = "Select ProductName, Products.BuyingPrice as BuyingPrice, Products.Description as Description, SuppliersOrders.OrderID as OrderID,SuppliersOrders.Quantity as Quantity, SuppliersOrders.OrderDate as OrderDate FROM Products, SuppliersOrders";
		sql += " WHERE Products.ProductID=SuppliersOrders.Product AND SuppliersOrders.Supplier=?";
        System.out.println("getSuppliersOrdersList: " + sql);
        try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(id));
            ResultSet result = pstmt.executeQuery();
            while(result.next()) {
                SuppliersData orderSupplier = new SuppliersData(
                    Integer.parseInt(id),
					Integer.parseInt(result.getString("OrderID")),
                    Integer.parseInt(result.getString("Quantity")),
                    result.getString("OrderDate"),
                    result.getString("ProductName"),
                    Float.parseFloat(result.getString("BuyingPrice")),
                    result.getString("Description")
					
                );
                vec.addElement(orderSupplier);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error in getSuppliersOrdersList: " + sql + " Exception: " + e);
        }
        return vec;
    }
}
	
	
	
	
	
	