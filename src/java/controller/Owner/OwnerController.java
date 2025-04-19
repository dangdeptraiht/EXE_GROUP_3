package controller.Owner;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import dao.RenterDAO;
import dao.RequestDAO;
import java.lang.reflect.Type;
import dao.RoomDAO;
import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import jakarta.servlet.http.Part;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Base64;
import model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@WebServlet(name = "OwnerController", urlPatterns = {"/OwnerController"})
@MultipartConfig
public class OwnerController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String service = request.getParameter("service");
        HttpSession session = request.getSession();
        UserDAO userDAO = new UserDAO();
        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");
        int userRole = userDAO.getUserRoleByEmailAndPassword(email, password);
        if (userRole != 2) {
            request.setAttribute("error", "You have to login first!!!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
                        
        if (service == null) {
            service = "OwnerHome";
        }
        request.setAttribute("service", service);

        if (service.equals("OwnerHome")) {
            OwnerHome(request, response);
        } else if (service.equals("pagingRoom")) {
            listRoom(request, response);
        } else if (service.equals("ownerProfile")) {
            getOwnerProfile(request, response, 0);
        } else if (service.equals("editOwnerProfile")) {
            getOwnerProfile(request, response, 1);
        } else if (service.equals("updateOwnerProfile")) {
            updateOwnerProfile(request, response);
        } else if (service.equals("updateAvatar")) {
            updateAvatar(request, response);
        } else if (service.equals("roomDetail")) {
            roomDetail(request, response, 0);
        } else if (service.equals("editRoom")) {
            roomDetail(request, response, 1);
        } else if (service.equals("deleteItem")) {
            deleteItem(request, response);
        } else if (service.equals("addItem")) {
            addItem(request, response);
        } else if (service.equals("updateRoomDetail")) {
            updateRoomDetail(request, response);
        } else if (service.equals("updateRoomItem")) {
            updateRoomItem(request, response);
        } else if (service.equals("listrequest")) {
            requestList(request, response, 0);
        } else if (service.equals("changereqstatus")) {
            requestList(request, response, 1);
        } else if (service.equals("updateRoomStatus")) {
            updateRoomStatus(request, response);
        } else if (service.equals("setUnderRepair")) {
            setUnderRepair(request, response);
        }
    }

    private void OwnerHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Owner/OwnerHome.jsp").forward(request, response);
    }

    private void listRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();
        int index = Integer.parseInt(request.getParameter("index"));

        List<Rooms> rooms = dao.pagingRoom(index, 1);
        List<Rooms> allRooms = dao.getRooms();
        int totalRoom = dao.getTotalRoom();
        int totalPage = totalRoom / 6;
        if (totalRoom % 6 != 0) {
            totalPage++;
        }

        request.setAttribute("totalPage", totalPage);
        request.setAttribute("index", index);
        request.setAttribute("rooms", rooms);
        request.setAttribute("allRooms", allRooms);

        request.getRequestDispatcher("Owner/rooms.jsp").forward(request, response);
    }

    private void roomDetail(HttpServletRequest request, HttpServletResponse response, int flag) throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();
        RenterDAO daoRenter = new RenterDAO();
        HttpSession session = request.getSession();
        int roomID = Integer.parseInt(request.getParameter("roomID"));
        RoomDetailSe roomDetail = dao.getRoomDetail(roomID);
        List<String> listNameRenter = daoRenter.getRenterName(roomID);
        request.setAttribute("roomDetail", roomDetail);
        request.setAttribute("listNameRenter", listNameRenter);
        session.setAttribute("roomID", roomID);

        if (flag == 0) {
            request.getRequestDispatcher("Owner/roomDetail.jsp").forward(request, response);
        } else if (flag == 1) {
            List<String> listItemNames = dao.getItemName();
            String[] listItem = listItemNames.toArray(new String[0]);
            request.setAttribute("listItem", listItem);
            request.getRequestDispatcher("Owner/editRoom.jsp").forward(request, response);
        }
    }

    private void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();
        int roomID = Integer.parseInt(request.getParameter("roomID"));
        int itemID = Integer.parseInt(request.getParameter("itemID"));
        int remove = dao.deleteRoomItem(roomID, itemID);
        request.getRequestDispatcher("OwnerController?service=editRoom").forward(request, response);
    }

    private void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();
        String itemName = request.getParameter("itemName");
        int roomID = Integer.parseInt(request.getParameter("roomID"));
        int quantity = Integer.parseInt(request.getParameter("quantity").trim());
        int itemID = dao.getItemIDOrQuantityByItemName(itemName, 0, 0);
        RoomDetailSe roomDetail = dao.getRoomDetail(roomID);

        String[] listItemName = roomDetail.getItemName();
        for (String string : listItemName) {
            if (string.equalsIgnoreCase(itemName)) {
                int newQuantity = dao.getItemIDOrQuantityByItemName(itemName, 1, roomID) + quantity;
                int updateQuantity = dao.updateItemQuantity(roomID, itemID, newQuantity);
                request.getRequestDispatcher("OwnerController?service=editRoom").forward(request, response);
                return;
            }
        }
        int addItem = dao.addRoomItem(roomID, itemID, quantity);
        request.getRequestDispatcher("OwnerController?service=editRoom").forward(request, response);
    }

    private void getOwnerProfile(HttpServletRequest request, HttpServletResponse response, int flag) throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();
        User ownerProfile = dao.getOwnerProfileByID(15);
        request.setAttribute("ownerProfile", ownerProfile);
        if (flag == 0) {
            request.getRequestDispatcher("Owner/ownerProfile.jsp").forward(request, response);
        } else if (flag == 1) {
            request.getRequestDispatcher("Owner/formOwnerProfile.jsp").forward(request, response);
        }
    }

    private void updateAvatar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();
        Part photo = request.getPart("img");
        byte[] avatar_raw = convertInputStreamToByteArray(photo.getInputStream());
        String avatar = Base64.getEncoder().encodeToString(avatar_raw);
        int updateAvatar = dao.updateAvatar(new User(15, avatar));
        request.getRequestDispatcher("OwnerController?service=editOwnerProfile").forward(request, response);
    }

    private void updateRoomDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();
        List<Rooms> listRoom = dao.getRooms();
        int roomID = Integer.parseInt(request.getParameter("roomID"));
        RoomDetailSe roomDetail = dao.getRoomDetail(roomID);
        int currentRoomNumber = roomDetail.getRoomNumber();
        double roomFee = 0;
        int roomNumber = 0;

        try {
            roomNumber = Integer.parseInt(request.getParameter("roomNumber").trim());
            if (roomNumber <= 0) {
                request.setAttribute("error", "Invalid room number");
                request.getRequestDispatcher("OwnerController?service=editRoom&roomID=" + roomID).forward(request, response);
                return;
            }
            if (!dao.isExistRoomNumber(roomNumber)) {
                if (roomNumber != dao.getCurrentRoomNumber(roomID)) {
                    request.setAttribute("error", "Room number is exist!!!");
                    request.getRequestDispatcher("OwnerController?service=editRoom&roomID=" + roomID).forward(request, response);
                    return;
                }
            }

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid room number");
            request.getRequestDispatcher("OwnerController?service=editRoom&roomID=" + roomID).forward(request, response);
            return;
        }

        try {
            roomFee = Double.parseDouble(request.getParameter("roomFee").trim());
            if (roomFee <= 0) {
                request.setAttribute("error", "Room Fee have to great than 0!!!");
                request.getRequestDispatcher("OwnerController?service=editRoom&roomID=" + roomID).forward(request, response);
                return;
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid room fee");
            request.getRequestDispatcher("OwnerController?service=editRoom&roomID=" + roomID).forward(request, response);
            return;
        }

        Part photo = request.getPart("roomImg");
        String contentType = photo.getContentType();
        byte[] roomImg_raw = null;
        String roomImg = null;
        if (!contentType.equals("image/jpeg")) {
            request.setAttribute("error", "Invalid room image");
            request.getRequestDispatcher("OwnerController?service=editRoom&roomID=" + roomID).forward(request, response);
            return;
        } else {
            roomImg_raw = convertInputStreamToByteArray(photo.getInputStream());
            roomImg = Base64.getEncoder().encodeToString(roomImg_raw);
        }

        int updateRoomDetail = dao.updateRoomDetail(roomID, roomFee, roomImg, roomNumber);
        request.getRequestDispatcher("OwnerController?service=roomDetail").forward(request, response);
    }

    private void updateOwnerProfile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();

        boolean hasError = false;
        String fullName = request.getParameter("fullName").trim();
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        if (fullName == null || fullName.isEmpty() || fullName.isBlank() || fullName.trim().isEmpty()) {
            hasError = true;
        } else if (phone == null || phone.length() != 10 || !phone.startsWith("0") || !phone.matches("[0-9]+")) {
            hasError = true;
        } else if (address == null || address.isEmpty() || address.isBlank()) {
            hasError = true;
        }

        if (hasError) {
            request.setAttribute("error", "Invalid input information. Please check again.");
            request.getRequestDispatcher("OwnerController?service=ownerProfile").forward(request, response);
        } else {
            int update = dao.updateOwnerProfile(new User(15, fullName, gender, dob, address, phone));

            request.getRequestDispatcher("OwnerController?service=ownerProfile").forward(request, response);
        }
    }

    private void updateRoomItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();
        HttpSession session = request.getSession();
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        String json = sb.toString();
        System.out.println("Received JSON: " + json);
        int roomID_raw = (int) session.getAttribute("roomID");

        try {
            if (!json.isEmpty()) {
                JSONParser parser = new JSONParser();
                JSONArray jsonArray = (JSONArray) parser.parse(json);

                for (Object obj : jsonArray) {
                    JSONObject jsonObject = (JSONObject) obj;
                    String itemIDStr = (String) jsonObject.get("itemID");
                    String itemName = (String) jsonObject.get("itemName");
                    String quantityStr = (String) jsonObject.get("quantity");
                    String roomIDStr = (String) jsonObject.get("roomID");

                    int itemID = Integer.parseInt(itemIDStr);
                    int quantity = Integer.parseInt(quantityStr);
                    int roomID = Integer.parseInt(roomIDStr);
                    if (quantity == 0) {
                        dao.deleteRoomItem(roomID, itemID);
                    } else {
                        dao.updateItemQuantity(roomID, itemID, quantity);
                    }

                }
            } else {
                System.out.println("Received empty JSON.");
            }

            response.sendRedirect("OwnerController?service=roomDetail&roomID=" + roomID_raw);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public byte[] convertInputStreamToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096]; // Sử dụng một buffer có kích thước lớn hơn cho hiệu suất tốt hơn
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        return outputStream.toByteArray();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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

    private void requestList(HttpServletRequest request, HttpServletResponse response, int flag) throws ServletException, IOException {
    RequestDAO requestDAO = new RequestDAO();
    
    if (flag == 0) {
        // Get the list of all requests
        List<RequestList> requests = requestDAO.getAllRequest();
        // Store the list in the request scope
        request.setAttribute("requests", requests);
        // Forward to the JSP page
        request.getRequestDispatcher("Owner/OwnerRequest.jsp").forward(request, response);
    } else if (flag == 1) {
        // REQUEST STATUS UPDATE
        String rawRequestId = request.getParameter("requestId");
        String status = request.getParameter("status");

        if (rawRequestId != null && status != null && (status.equals("Accepted") || status.equals("Denied"))) {
            try {
                int requestId = Integer.parseInt(rawRequestId);
                // Fetch the current request
                RequestList currentRequest = requestDAO.getRequestByID(requestId);

                if (currentRequest != null && "Pending".equals(currentRequest.getResStatus())) {
                    // Update the request status
                    boolean updateSuccess = requestDAO.updateRequestStatus(status, requestId);

                    if (updateSuccess) {
                        // Set success message
                       // request.getSession().setAttribute("message", "Request status updated successfully.");
                    } else {
                        // Set failure message
                        //request.getSession().setAttribute("message", "Failed to update request status.");
                    }
                } else {
                    // Set message if request was already updated
                   // request.getSession().setAttribute("message", "Request has already been updated or does not exist.");
                }
            } catch (NumberFormatException e) {
                // Handle invalid request ID format
               // request.getSession().setAttribute("message", "Invalid request ID format.");
            }
        } else {
            // Set message if status is invalid
          //  request.getSession().setAttribute("message", "Invalid status provided.");
        }

        // Redirect back to the list page
         request.getRequestDispatcher("OwnerController?service=listrequest").forward(request, response);
    }
}

    private void updateRoomStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();
        int roomID = Integer.parseInt(request.getParameter("roomID"));
        int roomStatus = Integer.parseInt(request.getParameter("roomStatus"));
        int roomOccupant = Integer.parseInt(request.getParameter("roomOccupant"));

        if (roomOccupant > 0) {
            request.setAttribute("error", "There is someone renting a room!!!");
            request.getRequestDispatcher("OwnerController?service=editRoom&roomID=" + roomID).forward(request, response);
            return;
        }
        if (roomStatus == 2) {
            int update = dao.updateRoomStatus(roomID, 1); // cap nhat dang sua thanh san sang cho thue
        } else if (roomStatus == 1) {
            int update = dao.updateRoomStatus(roomID, 2); // cap nhat san sang cho thue thanh dang sua
        }

        request.getRequestDispatcher("OwnerController?service=editRoom&roomID=" + roomID).forward(request, response);
    }

    private void setUnderRepair(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();
        int roomID = Integer.parseInt(request.getParameter("roomID"));
        int roomStatus = Integer.parseInt(request.getParameter("roomStatus"));
        int updateRoomStatus = Integer.parseInt(request.getParameter("updateRoomStatus"));

        if (roomStatus == 2) {
            if (updateRoomStatus == 0) {
                int update = dao.updateRoomStatus(roomID, 0);
            }
        } else if (roomStatus == 0) {
            if (updateRoomStatus == 2) {
                int update = dao.updateRoomStatus(roomID, 2);
            }
        }
        request.setAttribute("error", "Update status successfully!!!");
        request.getRequestDispatcher("OwnerController?service=editRoom&roomID=" + roomID).forward(request, response);
    }

}
