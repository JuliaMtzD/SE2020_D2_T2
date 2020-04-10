import java.util.Vector;

import java.sql.Connection;

import java.sql.Statement;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;



public class CategoryData {

    String	categoryId;

    String	categoryName;

    String	categoryDescription;

	
	

    CategoryData (String categoryId, String categoryName, String categoryDescription) {

        this.categoryId    = categoryId;

        this.categoryName  = categoryName;
		
		this.categoryDescription = categoryDescription;

    }

	
    public static Vector<CategoryData> getCategoryList(Connection connection) {

        Vector<CategoryData> vec = new Vector<CategoryData>();

        String sql = "SELECT Categories.CategoryID, Categories.CategoryName, Categories.Description FROM Categories";



        System.out.println("getCategoryList: " + sql);

        try {

            Statement statement=connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            while(result.next()) {
	
                CategoryData category = new CategoryData(

                    result.getString("CategoryID"),

                    result.getString("CategoryName"),
					
					result.getString("Description")

                );
				
                vec.addElement(category);

            }

        } catch(SQLException e) {

            e.printStackTrace();

            System.out.println("Error in getCategoryList: " + sql + " Exception: " + e);

        }

        return vec;

    }


}