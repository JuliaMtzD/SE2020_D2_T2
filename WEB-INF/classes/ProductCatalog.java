import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;


@SuppressWarnings("serial")
public class ProductCatalog extends HttpServlet {
    Connection connection;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        connection = ConnectionUtils.getConnection(config);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
        res.setContentType("text/html");
        PrintWriter toClient = res.getWriter();
        

        toClient.println(Utils.header("Product Catalog"));

        Vector<ProductData> productList;
		productList = ProductData.getProductList(connection);

         for(int i=0; i< productList.size(); i++){
                ProductData product = productList.elementAt(i);
				toClient.println("<div class='w3-row'>");
				toClient.println("<div class='w3-third w3-padding-16'>");
				toClient.println("<p align='center'><b>" + product.productId  + "</b></p>");
				toClient.println("</div>");
				toClient.println("<div class='w3-third w3-padding-16'>");
				toClient.println("<p class='w3-border' align='center'>" +product.productName + "</p>");
				toClient.println("</div>");
				toClient.println("<div class='w3-third w3-padding-16'>");
				toClient.println("<p class='w3-border' align='center'>" +product.categoryId + "</p>");
				toClient.println("</div>");
				toClient.println("<div class='w3-third w3-padding-16'>");
				toClient.println("<p class='w3-border' align='center'>Cost: " +product.SellingPrice + "</p>");
				toClient.println("</div>");
				toClient.println("</div>");
				
        } 


        toClient.println(Utils.footer("Product Catalog"));
        toClient.close();
    }
}