import java.util.Vector;

import java.sql.Connection;

import java.sql.Statement;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;



public class ProductData {

    String	productId;

    String	productName;

    String	productDescription;

    int productSStock;

    int productsInStock;

	String categoryId;

	int supplierId;

	float SellingPrice;

	float BuyingPrice;

	
	

    ProductData (String productId, String productName, String categoryId, float SellingPrice) {

        this.productId    = productId;

        this.productName  = productName;
		
		this.categoryId = categoryId;
		
		this.SellingPrice = SellingPrice;



    }

	
    public static Vector<ProductData> getProductList(Connection connection, int category) {

        Vector<ProductData> vec = new Vector<ProductData>();

        String sql = "SELECT Products.ProductID, Products.ProductName, Products.Category, Products.SellingPrice FROM Products WHERE Products.Category="+category;


        System.out.println("getProductList: " + sql);

        try {

            Statement statement=connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while(result.next()) {
	
                ProductData product = new ProductData(

                    result.getString("ProductId"),

                    result.getString("ProductName"),
					
					result.getString("Category"),
					
					Float.parseFloat(result.getString("SellingPrice"))
					

                );
				
                vec.addElement(product);

            }

        } catch(SQLException e) {

            e.printStackTrace();

            System.out.println("Error in getProductList: " + sql + " Exception: " + e);

        }

        return vec;

    }


}