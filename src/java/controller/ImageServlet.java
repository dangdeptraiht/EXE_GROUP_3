package controller;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/images/*")
public class ImageServlet extends HttpServlet {

    public final String IMAGE_DIR = "D:/uploaded_images";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String imageName = request.getPathInfo(); // lấy phần sau /images/
        if (imageName == null || imageName.equals("/")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Thiếu tên ảnh.");
            return;
        }

        File file = new File(IMAGE_DIR, imageName.substring(1)); // bỏ dấu /

        if (!file.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Không tìm thấy ảnh.");
            return;
        }

        String mimeType = getServletContext().getMimeType(file.getName());
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }

        response.setContentType(mimeType);
        response.setContentLengthLong(file.length());

        try (InputStream in = new FileInputStream(file);
             OutputStream out = response.getOutputStream()) {
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}
