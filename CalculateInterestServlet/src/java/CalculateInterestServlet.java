import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/CalculateInterestServlet")
public class CalculateInterestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Get parameters
        String principalStr = request.getParameter("principal");
        String rateStr = request.getParameter("rate");
        String timeStr = request.getParameter("time");
        
        // Validate input
        if (principalStr == null || rateStr == null || timeStr == null ||
            principalStr.trim().isEmpty() || rateStr.trim().isEmpty() || timeStr.trim().isEmpty()) {
            
            // Handle invalid input
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Error</h2>");
            out.println("<p>Please enter all values.</p>");
            out.println("<a href='index.html'>Go Back</a>");
            out.println("</body></html>");
            return;
        }
        
        try {
            // Parse input parameters
            double principal = Double.parseDouble(principalStr);
            double rate = Double.parseDouble(rateStr);
            double time = Double.parseDouble(timeStr);


            // Calculate simple interest
            double interest = (principal * rate * time) / 100;


            // Create session and store interest
            HttpSession session = request.getSession();
            session.setAttribute("principal", principal);
            session.setAttribute("rate", rate);
            session.setAttribute("time", time);
            session.setAttribute("interest", interest);


            // Forward instead of redirect
            request.getRequestDispatcher("/DisplayInterestServlet").forward(request, response);
        
        } catch (NumberFormatException e) {
            // Handle invalid numeric input
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Error</h2>");
            out.println("<p>Please enter valid numeric values.</p>");
            out.println("<a href='index.html'>Go Back</a>");
            out.println("</body></html>");
        }
    }
}