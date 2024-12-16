import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/FindPrimeServlet")
public class FindPrimeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));


        PrintWriter out = response.getWriter();
        response.setContentType("text/html");


        out.println("<html><body>");
        out.println("<h3>Prime Numbers Between " + a + " and " + b + ":</h3>");
        for (int i = a; i <= b; i++) {
            if (isPrime(i)) {
                out.print(i + " ");
            }
        }
        out.println("</body></html>");
    }


    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}