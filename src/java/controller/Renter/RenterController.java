package controller.Renter;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import dao.UserDAO;
import jakarta.servlet.http.HttpSession;

@WebServlet(name="RenterController", urlPatterns={"/rentercontroller"})
public class RenterController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(RenterController.class.getName());

    private static final String RENTER_HOME = "renterhome";
    private static final String RENTER_PROFILE = "renterprofile";
    private static final String GUIDE_AND_RULE = "guideandrule";
    private static final String REQUEST = "request";
    private static final String RENTER_UPDATE_PROFILE = "renterupdate";
    private static final String RENTER_NEW = "news";
    private static final String ERROR_PAGE = "error.jsp"; // Define your error page path

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");

        // Check if the user is a renter
        if (email == null || password == null || !isUserRenter(email, password)) {
            LOGGER.warning("User is not a renter or not logged in.");
            response.sendRedirect("login.jsp");
            return;
        }

        String service = request.getParameter("service");

        if (service == null) {
            service = RENTER_HOME;
        }

        try {
            switch (service) {
                case RENTER_HOME:
                    request.getRequestDispatcher(RENTER_HOME).forward(request, response);
                    break;
                case RENTER_PROFILE:
                    request.getRequestDispatcher(RENTER_PROFILE).forward(request, response);
                    break;
                case GUIDE_AND_RULE:
                    request.getRequestDispatcher(GUIDE_AND_RULE).forward(request, response);
                    break;
                case REQUEST:
                    request.getRequestDispatcher(REQUEST).forward(request, response);
                    break;
                case RENTER_NEW:
                    request.getRequestDispatcher(RENTER_NEW).forward(request, response);
                    break;
                case RENTER_UPDATE_PROFILE:
                    request.getRequestDispatcher("UpdateProfileRenterController?service=formRenterUpdateProfile").forward(request, response);
                    break;
                default:
                    LOGGER.warning("Service not found: " + service);
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Service not found: " + service);
                    break;
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception occurred while processing service: " + service, e);
            response.sendRedirect(ERROR_PAGE);
        }
    }

    private boolean isUserRenter(String email, String password) {
        UserDAO userDAO = new UserDAO();
        int role = userDAO.getUserRoleByEmailAndPassword(email, password);
        return role == 1;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "RenterController Servlet";
    }
}
