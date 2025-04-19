package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ReqType;
import model.Request;
import model.RequestList;

public class RequestDAO extends DBContext {

    public List<ReqType> getAllReqType() {
        List<ReqType> requestTypes = new ArrayList<>();
        String sql = "SELECT * FROM requestType "; // Adjust based on your table structure
        try (
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery()
        ) {
            while (rs.next()) {
                int id = rs.getInt("reqTypeId");
                String name = rs.getString("typeName");
                requestTypes.add(new ReqType(id, name));
            }
        } catch (SQLException e) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, "Failed to fetch request types", e);
        }
        return requestTypes;
    }

    public List<RequestList> getReqListByID(int userID) {
        List<RequestList> requests = new ArrayList<>();
        String sql = "SELECT DISTINCT  u.userID, u.userName, r.requestID, r.title, r.description, rt.typeName, r.createAt, r.resStatus "
                + "FROM request r "
                + "JOIN [user] u ON r.userID = u.userID "
                + "JOIN requestType rt ON r.requestType = rt.reqTypeID "
                + "WHERE u.userID = ? ORDER BY requestID DESC";
        try (
            PreparedStatement st = connection.prepareStatement(sql)
        ) {
            st.setInt(1, userID);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                                       
                    int requestID = rs.getInt("requestID");
                    int uID = rs.getInt("userID");
                    String userName = rs.getString("userName");
                    String title = rs.getString("title");
                    String description = rs.getString("description");
                    String typeName = rs.getString("typeName");
                    String createAt = rs.getString("createAt");
                    String resStatus = rs.getString("resStatus");

                    RequestList request = new RequestList(requestID, uID, userName, title, description, typeName, createAt, resStatus);
                    requests.add(request);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, "Failed to fetch requests", e);
        }
        return requests;
    }
          public void updateAbandonedRequests() {
        String sql = "UPDATE request SET resStatus = 'Abandoned' WHERE resStatus = 'Pending' AND CreateAt < ?";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date7DaysAgo = sdf.format(new Date(System.currentTimeMillis() - 7L * 24 * 60 * 60 * 1000)); // 7 days ago

        try (
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, date7DaysAgo);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<RequestList> getAllRequest() {
    List<RequestList> requests = new ArrayList<>();
    String sql = "SELECT u.userID, u.userName, r.requestID, r.title, r.description, rt.typeName, r.createAt, r.resStatus "
               + "FROM request r "
               + "JOIN [user] u ON r.userID = u.userID "
               + "JOIN requestType rt ON r.requestType = rt.reqTypeID ORDER BY requestID DESC";
    
    try (PreparedStatement st = connection.prepareStatement(sql);
         ResultSet rs = st.executeQuery()) {
        
        while (rs.next()) {
            int requestID = rs.getInt("requestID");
            int uID = rs.getInt("userID");
            String userName = rs.getString("userName");
            String title = rs.getString("title");
            String description = rs.getString("description");
            String typeName = rs.getString("typeName");
            String createAt = rs.getString("createAt");
            String resStatus = rs.getString("resStatus");

            RequestList request = new RequestList(requestID, uID, userName, title, description, typeName, createAt, resStatus);
            requests.add(request);
        }
    } catch (SQLException e) {
        Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, "Failed to fetch all requests", e);
    }
    
    return requests;
}


    public boolean insertRequest(int userID, int requestType, String title, String description, String createAt, String resStatus) {
        String sql = "INSERT INTO request (userID, requestType, title, description, createAt, resStatus) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userID);
            ps.setInt(2, requestType);
            ps.setString(3, title);
            ps.setString(4, description);
            ps.setString(5, createAt);
            ps.setString(6, resStatus);

            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, "Failed to insert request", e);
            return false;
        }
    }

    public boolean updateRequest(int requestID, int renterID, int requestType, String title, String description, String createAt, String resStatus) {
        String sql = "UPDATE request SET userID = ?, requestType = ?, title = ?, description = ?, createAt = ?, resStatus = ? WHERE requestID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, renterID);
            ps.setInt(2, requestType);
            ps.setString(3, title);
            ps.setString(4, description);
            ps.setString(5, createAt);
            ps.setString(6, resStatus);
            ps.setInt(7, requestID);

            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, "Failed to update request", e);
            return false;
        }
    }

    public boolean deleteRequest(int requestID) {
        String sql = "DELETE FROM request WHERE requestID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, requestID);

            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, "Failed to delete request", e);
            return false;
        }
    }
    
      public int countPendingRequests(int userID) {
        String sql = "SELECT COUNT(*) FROM request WHERE userID = ? AND resStatus = 'Pending'";
        int count = 0;

        try (
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    count = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

      public List<RequestList> getReqListByID(int userID, int offset, int pageSize) {
    List<RequestList> requests = new ArrayList<>();
    String sql = "SELECT u.userName, r.title, r.description, rt.typeName, r.createAt, r.resStatus "
            + "FROM request r "
            + "JOIN [user] u ON r.userID = u.userID "
            + "JOIN requestType rt ON r.requestType = rt.reqTypeID "
            + "WHERE r.userID =? "
            + "ORDER BY r.createAt DESC "
            + "OFFSET? ROWS "
            + "FETCH NEXT? ROWS ONLY";
    try (
        PreparedStatement st = connection.prepareStatement(sql)
    ) {
        st.setInt(1, userID);
        st.setInt(2, offset);
        st.setInt(3, pageSize);
        try (ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                String userName = rs.getString("userName");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String typeName = rs.getString("typeName");
                String createAt = rs.getString("createAt");
                String resStatus = rs.getString("resStatus");

                RequestList request = new RequestList(userName, title, description, typeName, createAt, resStatus);
                requests.add(request);
            }
        }
    } catch (SQLException e) {
        Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, "Failed to fetch requests by user ID", e);
    }
    return requests;
}
      
    public RequestList getRequestByReqID(int requestID) {
        RequestList request = null;
        String sql = "SELECT u.userName, r.title, r.description, rt.typeName, r.createAt, r.resStatus "
                + "FROM request r "
                + "JOIN [user] u ON r.userID = u.userID "
                + "JOIN requestType rt ON r.requestType = rt.reqTypeID "
                + "WHERE r.requestID = ?";
        try (
            PreparedStatement st = connection.prepareStatement(sql)
        ) {
            st.setInt(1, requestID);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    String userName = rs.getString("userName");
                    String title = rs.getString("title");
                    String description = rs.getString("description");
                    String typeName = rs.getString("typeName");
                    String createAt = rs.getString("createAt");
                    String resStatus = rs.getString("resStatus");

                    request = new RequestList(userName, title, description, typeName, createAt, resStatus);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, "Failed to fetch request by ID", e);
        }
        return request;
    }
     public boolean updateRequestStatus(String status, int requestId) {
        String sql = "UPDATE request SET resStatus = ? WHERE requestID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, requestId);
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, "Failed to update request status", e);
        }
        return false;
    }

        public static void main(String[] args) {
        // Create an instance of RequestDAO
        RequestDAO requestDAO = new RequestDAO();

        // Print the status of requests before updating
        System.out.println("Before updating abandoned requests:");
        printRequests(requestDAO);

        // Update abandoned requests
        requestDAO.updateAbandonedRequests();

        // Print the status of requests after updating
        System.out.println("After updating abandoned requests:");
        printRequests(requestDAO);
    }

    private static void printRequests(RequestDAO requestDAO) {

        System.out.println("Requests:");
        requestDAO.getAllRequest().forEach(request -> {
            System.out.println("ID: " + request.getRequestID()+ ", Status: " + request.getResStatus() + ", Created At: " + request.getCreateAt());
        });
    }
    
    public RequestList getRequestByID(int requestID) {
        RequestList request = null;
        String sql = "SELECT u.userName, r.title, r.description, rt.typeName, r.createAt, r.resStatus "
                + "FROM request r "
                + "JOIN [user] u ON r.userID = u.userID "
                + "JOIN requestType rt ON r.requestType = rt.reqTypeID "
                + "WHERE r.requestID = ?";
        try (
            PreparedStatement st = connection.prepareStatement(sql)
        ) {
            st.setInt(1, requestID);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    String userName = rs.getString("userName");
                    String title = rs.getString("title");
                    String description = rs.getString("description");
                    String typeName = rs.getString("typeName");
                    String createAt = rs.getString("createAt");
                    String resStatus = rs.getString("resStatus");

                    request = new RequestList(userName, title, description, typeName, createAt, resStatus);
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, "Failed to fetch request by ID", e);
        }
        return request;
    }
}
     
//    public static void main(String[] args) {
//    // Example usage to test updateRequest method
//        RequestDAO requestDAO = new RequestDAO();
//        
//        // Fetch all requests
//        List<RequestList> list = requestDAO.getAllRequest();
//        
//        // Print all requests to verify fetching
//        System.out.println("Current requests:");
//        for (RequestList request : list) {
//            System.out.println(request);
//        }
//
//    }
//    public static void main(String[] args) {
//        // Example usage to test updateRequest method
//        RequestDAO requestDAO = new RequestDAO();
//
//        // Example values (replace with your actual test values)
//        int requestID = 309;
//        int renterID = 1;
//        int requestType = 1;
//        String title = "BCD";
//        String description = "BCD";
//        String createAt = "2024-06-15 10:00:00"; // Example timestamp
//        String resStatus = "Pending"; // Example status
//
//        boolean updateSuccess = requestDAO.updateRequest(requestID, renterID, requestType, title, description, createAt, resStatus);
//
//        if (updateSuccess) {
//            System.out.println("Request updated successfully.");
//        } else {
//            System.out.println("Failed to update request.");
//        }
//    }



   

