package music.serverlet;

import java.io.IOException;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import music.business.Product;
import music.data.ProductIO;
import java.util.regex.Pattern;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "AddProduct", urlPatterns = {"/AddProduct"})
public class AddProduct extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/Product.jsp";
        String realPath = getServletContext().getRealPath("/WEB-INF/products.txt");
        ProductIO IO = new ProductIO();

        String code = request.getParameter("code");
        String description = request.getParameter("description");
        String price = request.getParameter("price");

        String errorPrice = "The price need a number";

        if (IO.exists(code, realPath)) {
            IO.update(new Product(code, description, Double.parseDouble(price)), realPath);
            url = "/index.html";
        } else if (!price.matches("^[0-9]+.?[0-9]+$")) {
            request.setAttribute("errorPrice", errorPrice);
            request.setAttribute("code", code);
            request.setAttribute("description", description);
            request.setAttribute("price", price);
        } else {
            Product p = new Product(code, description, Double.parseDouble(price));
            IO.insert(p, realPath);
            url = "/index.html";
        }

        // forward request and response objects to specified URL
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
