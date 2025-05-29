package controller;


/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
@WebServlet(urlPatterns = {"/chatbot"})
public class ChatServlet extends HttpServlet {

    private static final String API_KEY = "AIzaSyDkzxbTZLJsHq_p2A_VjuFqTRmd7rvSl8E";
    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + API_KEY;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("chat.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userMessage = request.getParameter("message");
        String botReply = callGeminiAPI(userMessage);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("reply", botReply);

        response.getWriter().write(jsonResponse.toString());
    }

    private String callGeminiAPI(String userMessage) {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");

            // 🎯 Prompt định hướng
            String systemPrompt = """
        Bạn là một trợ lý AI thân thiện cho website HoLa StayNow - nền tảng đặt và quản lý phòng trọ tại khu vực Hòa Lạc, Hà Nội.
        Website cung cấp thông tin về các loại phòng, giá cả, tiện ích và hỗ trợ người dùng đặt phòng online.
        Nếu người dùng hỏi về dịch vụ, vị trí, cách đặt phòng, hoặc giá – hãy trả lời ngắn gọn, dễ hiểu và lịch sự.
        Nếu bạn không chắc chắn về câu hỏi, hãy nói: "Xin lỗi, tôi không chắc chắn về thông tin này. Bạn có thể liên hệ quản lý để biết thêm chi tiết."
                                   - Có 3 loại phòng: Tiêu chuẩn (800k/tháng), Cao cấp (1.2 triệu/tháng), VIP (1.5 triệu/tháng).
                                      - Mỗi phòng đều có wifi, vệ sinh riêng và chỗ để xe.
                                      - Người dùng có thể đặt phòng trên website.
                                      - Website không hỗ trợ thanh toán online, chỉ đặt giữ chỗ.
                                      - Nếu người dùng hỏi về vị trí: "Địa chỉ: Thôn 3, Thạch Hòa, Thạch Thất, Hà Nội".
        """;

            String fullPrompt = systemPrompt + "\nKhách: " + userMessage;

            String jsonInput = "{ \"contents\": [ { \"parts\": [ { \"text\": \"" + fullPrompt.replace("\"", "\\\"") + "\" } ] } ] }";

            try (OutputStream os = conn.getOutputStream()) {
                os.write(jsonInput.getBytes(StandardCharsets.UTF_8));
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();

            JSONObject responseJson = new JSONObject(sb.toString());
            return responseJson.getJSONArray("candidates")
                    .getJSONObject(0)
                    .getJSONObject("content")
                    .getJSONArray("parts")
                    .getJSONObject(0)
                    .getString("text");

        } catch (Exception e) {
            e.printStackTrace();
            return "Xin lỗi, hệ thống đang gặp sự cố!";
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
