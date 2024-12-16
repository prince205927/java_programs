import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/DisplayInterestServlet")
public class DisplayInterestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();
        
        // Retrieve session attributes
        Object principalObj = session.getAttribute("principal");
        Object rateObj = session.getAttribute("rate");
        Object timeObj = session.getAttribute("time");
        Object interestObj = session.getAttribute("interest");
        
        // Check if all attributes exist
        if (principalObj == null || rateObj == null || timeObj == null || interestObj == null) {
            out.println("<html><body>");
            out.println("<h2>Error</h2>");
            out.println("<p>Session data is missing. Please recalculate.</p>");
            out.println("<a href='index.html'>Go Back</a>");
            out.println("</body></html>");
            return;
        }
        
        // Cast to Double
        Double principal = (Double) principalObj;
        Double rate = (Double) rateObj;
        Double time = (Double) timeObj;
        Double interest = (Double) interestObj;
        
        // Create HTML output
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Interest Calculation Result</title></head>");
        out.println("<body>");
        out.println("<h2>Interest Calculation Result</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>Parameter</th><th>Value</th></tr>");
        out.println("<tr><td>Principal Amount</td><td>" + String.format("%.2f", principal) + "</td></tr>");
        out.println("<tr><td>Interest Rate</td><td>" + String.format("%.2f", rate) + "%</td></tr>");
        out.println("<tr><td>Time Period</td><td>" + String.format("%.2f", time) + " years</td></tr>");
        out.println("<tr><td>Total Interest</td><td>" + String.format("%.2f", interest) + "</td></tr>");
        out.println("</table>");
        out.println("<br>");
        out.println("<a href='index.html'>Calculate Again</a>");
        out.println("</body>");
        out.println("</html>");
               }
    }
