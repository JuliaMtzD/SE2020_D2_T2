import java.util.Vector;

import java.sql.Connection;

import java.sql.Statement;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;



public class ProductData {

    int	productId;

    String	productName;

    String	productDescription;

    int productSStock;

    int productsInStock;

	int categoryId;

	int supplierId;

	int SellingPrice;

	int BuyingPrice;

	
	

    ProductData (int productId, String productName, int SellingPrice, int Category) {

        this.productId    = productId;

        this.productName  = productName;

        this.SellingPrice   = SellingPrice;

        this.categoryId = Category;

    }

	
    public static Vector<ProductData> getProductList(Connection connection) {

        Vector<ProductData> vec = new Vector<ProductData>();

        String sql = "SELECT Products.ProductID, Products.ProductName, Products.SellingPrice, Products.Category FROM Products";


        System.out.println("getProductList: " + sql);

        try {

            Statement statement=connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while(result.next()) {

                ProductData product = new ProductData(

                    Integer.parseInt(result.getString("ProductId")),

                    result.getString("ProductName"),

                    Integer.parseInt(result.getString("SellingPrice")),
					
					Integer.parseInt(result.getString("Category"))

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