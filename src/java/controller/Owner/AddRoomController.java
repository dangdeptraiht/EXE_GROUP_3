package controller.Owner;

import java.util.UUID;
import controller.ImageServlet;
import java.io.IOException;
import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.io.File;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import dao.RoomDAO;
import dao.VipDAO;
import java.util.List;
import model.Room;
import model.Vip;

@WebServlet(name = "AddRoomController", urlPatterns = {"/addroom"})
@MultipartConfig // Bắt buộc để upload ảnh
public class AddRoomController extends HttpServlet {

    VipDAO vipDAO = new VipDAO();
    RoomDAO roomDAO = new RoomDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String service = request.getParameter("service");
        if (service == null || service.equals("addRoom")) {
            // Lấy danh sách VIP từ DB

            List<Vip> vipList = vipDAO.getAllVips();
            request.setAttribute("vipList", vipList);

            // random chuỗi ck
            String paymentCode = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8).toUpperCase();
            request.setAttribute("paymentCode", paymentCode);

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
            String paymentCode = request.getParameter("paymentCode");
            // image
            Part part = request.getPart("roomImg");
            String imageUrl = null;

            if (part != null && part.getSize() > 0) {
                File uploadDir = new File(new ImageServlet().IMAGE_DIR);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();

                // Optionally rename to avoid conflicts
                String newFileName = System.currentTimeMillis() + "_" + fileName;

                File imageFile = new File(uploadDir, newFileName);
                part.write(imageFile.getAbsolutePath());

                // Tạo URL để truy cập ảnh qua servlet
                imageUrl = request.getContextPath() + "/images/" + newFileName;
            }

            Room room = new Room();
            room.setRoomFloor(roomFloor);
            room.setRoomNumber(roomNumber);
            room.setRoomSize(roomSize);
            room.setRoomFee(roomFee);
            room.setRoomOccupant(roomOccupant);
            room.setTotal(total);
            room.setVipId(vipId);
            room.setPaymentCode(paymentCode);

            // Lưu tên file vào Room
            room.setRoomImg(imageUrl);

            System.out.println("Room: " + room.getRoomFloor() + ", " + room.getRoomNumber() + ", " + room.getRoomSize());
            System.out.println("Room fee: " + room.getRoomFee());
            System.out.println("Occupant: " + room.getRoomOccupant());
            System.out.println("VIP ID: " + room.getVipId());
            System.out.println("Payment Code: " + room.getPaymentCode());
            System.out.println("Image: " + room.getRoomImg());

            // 4. Gọi DAO để lưu vào DB
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
