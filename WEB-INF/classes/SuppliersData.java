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


    SuppliersData (int supplierId, String supplierName, String supplierAdress, int supplierTelephone, String supplierWeb) {
        this.supplierId    = supplierId;
        this.supplierName  = supplierName;
        this.supplierAdress   = supplierAdress;
        this.supplierTelephone = supplierTelephone;
        this.supplierWeb = supplierWeb;
    }
    public static Vector<SuppliersData> getSuppliersList(Connection connection) {
        Vector<SuppliersData> vec = new Vector<SuppliersData>();
        String sql = "Select SupplierID, SupplierName, Adress, TelephoneNumber, WebPage FROM Suppliers";
        System.out.println("getProductList: " + sql);
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
            System.out.println("Error in getProductList: " + sql + " Exception: " + e);
        }
        return vec;
    }
}
	
	
	
	
	
	