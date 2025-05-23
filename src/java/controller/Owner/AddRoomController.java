package controller.Owner;

import java.io.IOException;
import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import dao.RoomDAO;
import model.Room;

@WebServlet(name = "AddRoomController", urlPatterns = {"/addroom"})
@MultipartConfig // Bắt buộc để upload ảnh
public class AddRoomController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String service = request.getParameter("service");
        if (service == null || service.equals("addRoom")) {
            // Xử lý các logic chuẩn bị cho trang nếu cần (ví dụ: load dữ liệu từ DB)
            request.getRequestDispatcher("Owner/addRoom.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        try {
            // 1. Lấy dữ liệu từ form
            int roomFloor = Integer.parseInt(request.getParameter("roomFloor"));
            int roomNumber = Integer.parseInt(request.getParameter("roomNumber"));
            int roomSize = Integer.parseInt(request.getParameter("roomSize"));
            int total = Integer.parseInt(request.getParameter("total"));
            BigDecimal roomFee = new BigDecimal(request.getParameter("roomFee"));
            int roomOccupant = Integer.parseInt(request.getParameter("roomOccupant"));
            int vipId = Integer.parseInt(request.getParameter("vipId"));

            // image
            Part part = request.getPart("roomImg");
            String imagePath = null;
            if (part.getSubmittedFileName() == null
                    || part.getSubmittedFileName().trim().isEmpty()
                    || part == null) {
                imagePath = null;
            } else {
                // duong dan luu anh
                String path = request.getServletContext().getRealPath("/images");
                File dir = new File(path);
                // xem duongd an nay ton tai chua
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File image = new File(dir, part.getSubmittedFileName());
                // ghi file vao trong duong dan
                part.write(image.getAbsolutePath());
                // lay ra cai context path cua project
                imagePath = request.getContextPath() + "/images/" + image.getName();
            }

            Room room = new Room();
            room.setRoomFloor(roomFloor);
            room.setRoomNumber(roomNumber);
            room.setRoomSize(roomSize);
            room.setRoomFee(roomFee);
            room.setRoomOccupant(roomOccupant);
            room.setTotal(total);
            room.setVipId(vipId);

            // Lưu tên file vào Room
            room.setRoomImg(imagePath);

            // 4. Gọi DAO để lưu vào DB
            RoomDAO roomDAO = new RoomDAO();
            roomDAO.addRoom(room);

            // 5. Redirect hoặc forward sau khi thành công
            response.sendRedirect(request.getContextPath() + "/OwnerController");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Có lỗi xảy ra khi thêm phòng.");
            request.getRequestDispatcher("addRoom.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "AddRoomController handles room creation.";
    }
}
