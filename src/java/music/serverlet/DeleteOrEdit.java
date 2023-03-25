package music.serverlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.business.Product;
import music.data.ProductIO;

@WebServlet(name = "DeleteOrEdit", urlPatterns = {"/DeleteOrEdit"})
public class DeleteOrEdit extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String type = request.getParameter("type");
        ProductIO IO = new ProductIO();
        String url = "";
        if (type.equals("delete")) {
            url = "/ConfirmDelete.jsp";
        } else if (type.equals("edit")) {
            url = "/Product.jsp";
        }
        String realPath = getServletContext().getRealPath("/WEB-INF/products.txt");
        Product p = IO.getProduct(code, realPath);
        
        request.setAttribute("code", p.getCode());
        request.setAttribute("description", p.getDescription());
        request.setAttribute("price", p.getPrice());

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
