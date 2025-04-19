package controller.Owner;

import dao.NewDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.News;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "AddNewController", urlPatterns = {"/addnews"})
@MultipartConfig
public class addNewController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(addNewController.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Owner/Addnews.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Part imagePart = request.getPart("image");
        String createAt = request.getParameter("createAt");

        if (title == null || title.isEmpty() || description == null || description.isEmpty() || imagePart == null || createAt == null || createAt.isEmpty()) {
            request.setAttribute("error", "All fields are required.");
            request.getRequestDispatcher("Owner/Addnews.jsp").forward(request, response);
            return;
        }

        byte[] photo = convertInputStreamToByteArray(imagePart.getInputStream());
        String imgBase64 = Base64.getEncoder().encodeToString(photo);

        NewDAO dao = new NewDAO();
        try {
            // Assuming createAt is in 'yyyy-MM-dd' format
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date createDate = dateFormat.parse(createAt);
            News news = new News(title, description, imgBase64, createAt);
            dao.insertNews(news);
            response.sendRedirect("displayNews"); // Use redirect to prevent form resubmission
        } catch (ParseException e) {
            LOGGER.log(Level.SEVERE, "Date parsing error", e);
            request.setAttribute("error", "Invalid date format.");
            request.getRequestDispatcher("Owner/Addnews.jsp").forward(request, response);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Database error", e);
            request.setAttribute("error", "An error occurred while saving the news.");
            request.getRequestDispatcher("Owner/Addnews.jsp").forward(request, response);
        }
    }

    private byte[] convertInputStreamToByteArray(InputStream inputStream) throws IOException {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            return outputStream.toByteArray();
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet for adding news";
    }
}
