package dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import model.Rooms;
import java.lang.System.Logger;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Vector;
import model.RoomDetailSe;
import model.User;
import model.*;

public class RoomDAO extends DBContext {

    public List<Rooms> getRooms() {
        List<Rooms> rooms = new ArrayList<>();
        String query = "SELECT * FROM room";

        try (PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int roomID = rs.getInt("roomID");
                int roomFloor = rs.getInt("roomFloor");
                int roomNumber = rs.getInt("roomNumber");
                int roomSize = rs.getInt("roomSize");
                BigDecimal roomFee = rs.getBigDecimal("roomFee");
                String roomImg = rs.getString("roomImg");
                int roomStatus = rs.getInt("roomStatus");
                int roomOccupant = rs.getInt("roomOccupant");
                String rooomDepartment = rs.getString("roomDepartment");

                Rooms room = new Rooms(roomID, roomFloor, roomNumber, roomSize, roomImg, roomFee, roomStatus, roomOccupant, rooomDepartment);
                rooms.add(room);
            }
        } catch (SQLException e) {
        }
        return rooms;
    }
    
    public List<Rooms> getRoomsAvailable() {
        List<Rooms> rooms = new ArrayList<>();
        String query = "SELECT * FROM room where roomStatus = 1";

        try (PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int roomID = rs.getInt("roomID");
                int roomFloor = rs.getInt("roomFloor");
                int roomNumber = rs.getInt("roomNumber");
                int roomSize = rs.getInt("roomSize");
                BigDecimal roomFee = rs.getBigDecimal("roomFee");
                String roomImg = rs.getString("roomImg");
                int roomStatus = rs.getInt("roomStatus");
                int roomOccupant = rs.getInt("roomOccupant");
                String rooomDepartment = rs.getString("roomDepartment");

                Rooms room = new Rooms(roomID, roomFloor, roomNumber, roomSize, roomImg, roomFee, roomStatus, roomOccupant, rooomDepartment);
                rooms.add(room);
            }
        } catch (SQLException e) {
        }
        return rooms;
    }

    public Room findById(int id) {
        String query = "SELECT * FROM room where roomID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int roomID = rs.getInt("roomID");
                int roomFloor = rs.getInt("roomFloor");
                int roomNumber = rs.getInt("roomNumber");
                int roomSize = rs.getInt("roomSize");
                String roomImg = rs.getString("roomImg");

                Room room = new Room(roomID, roomFloor, roomNumber, roomSize, roomImg, 0);
                return room;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Rooms> pagingRoom(int index, int flag) {
        List<Rooms> rooms = new ArrayList<>();
        String query = null;
        if (flag == 0) {
            query = "select * from room\n"
                    + "where roomStatus = 1\n"
                    + "order by roomID\n"
                    + "OFFSET ? ROWS FETCH NEXT 6 ROWS only";
        } else if (flag == 1) {
            query = "select * from room\n"
                    + "order by roomID\n"
                    + "OFFSET ? ROWS FETCH NEXT 6 ROWS only";
        }
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, (index - 1) * 6);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int roomID = rs.getInt("roomID");
                int roomFloor = rs.getInt("roomFloor");
                int roomNumber = rs.getInt("roomNumber");
                int roomSize = rs.getInt("roomSize");
                BigDecimal roomFee = rs.getBigDecimal("roomFee");
                String roomImg = rs.getString("roomImg");
                int roomStatus = rs.getInt("roomStatus");
                int roomOccupant = rs.getInt("roomOccupant");
                String roomDepartment = rs.getString("roomDepartment");

                Rooms room = new Rooms(roomID, roomFloor, roomNumber, roomSize, roomImg, roomFee, roomStatus, roomOccupant, roomDepartment);
                rooms.add(room);
            }
        } catch (SQLException e) {
        }
        return rooms;
    }

    public List<String> getItemName() {
        List<String> itemNames = new ArrayList<>();
        String query = "SELECT itemName FROM item";

        try (PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String itemName = rs.getString("itemName");

                itemNames.add(itemName);
            }
        } catch (SQLException e) {

        }

        return itemNames;
    }

    public int cancleRoom(int renterID, int roomID) {
        int result = 0;

        String deleteRenterQuery = "DELETE FROM renter WHERE renterID = ?";
        String updateRoomQuery = "UPDATE room SET roomOccupant = roomOccupant - 1 WHERE roomID = ?";
        String updateRoomStatusQuery = "UPDATE room SET roomStatus = 1 WHERE roomID = ?";

        try {

            connection.setAutoCommit(false);

            try (PreparedStatement deletePs = connection.prepareStatement(deleteRenterQuery)) {
                deletePs.setInt(1, renterID);
                result = deletePs.executeUpdate();
            }

            try (PreparedStatement updatePs = connection.prepareStatement(updateRoomQuery)) {
                updatePs.setInt(1, roomID);
                result += updatePs.executeUpdate();
            }
            
            try (PreparedStatement updateStatusPs = connection.prepareStatement(updateRoomStatusQuery)) {
                updateStatusPs.setInt(1, roomID);
                result += updateStatusPs.executeUpdate();
            }

            connection.commit();
        } catch (SQLException e) {

            try {
                connection.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
            result = 0;
        } finally {

            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public int getItemIDOrQuantityByItemName(String itemName, int flag, int roomID) {
        int raw = 0;
        if (flag == 0) {
            String query = "SELECT itemID FROM item WHERE itemName = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, itemName);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        raw = rs.getInt("itemID");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (flag == 1) {
            String query1 = "select quantity from roomItem ri\n"
                    + "  join item i \n"
                    + "  on ri.itemID = i.itemID\n"
                    + "  where itemName = ? and roomID = ?";
            try (PreparedStatement ps = connection.prepareStatement(query1)) {
                ps.setString(1, itemName);
                ps.setInt(2, roomID);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        raw = rs.getInt("quantity");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return raw;
    }

    public User getOwnerProfileByID(int userID) {
        String query = "select u.userName, u.userGender, u.userBirth, u.userAddress, u.userPhone, a.userMail, u.userAvatar from account a join [user] u on u.userID = a.userID \n"
                + "  where a.userRole = 2 and u.userID = " + userID;
        User ownerProfile = null;

        try (PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                String userName = rs.getString("userName");
                String userGender = rs.getString("userGender");
                String userBirth = rs.getString("userBirth");
                String userAddress = rs.getString("userAddress");
                String userPhone = rs.getString("userPhone");
                String email = rs.getString("userMail");
                String userAvatar = rs.getString("userAvatar");
                ownerProfile = new User(userName, userGender, userBirth, userAddress, userPhone, email, userAvatar);
            }
        } catch (SQLException e) {

        }

        return ownerProfile;
    }

    public int updateOwnerProfile(User ownerProfile) {
        int n = 0;
        String sql = "UPDATE [dbo].[user]\n"
                + "   SET [userName] = ?\n"
                + "      ,[userGender] = ?\n"
                + "      ,[userBirth] = ?\n"
                + "      ,[userAddress] = ?\n"
                + "      ,[userPhone] = ?      \n"
                + " WHERE userID = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, ownerProfile.getUserName());
            pre.setString(2, ownerProfile.getUserGender());
            pre.setString(3, ownerProfile.getUserBirth());
            pre.setString(4, ownerProfile.getUserAddress());
            pre.setString(5, ownerProfile.getUserPhone());
            pre.setInt(6, ownerProfile.getUserID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {

        }

        return n;
    }

    public int updateAvatar(User ownerProfile) {
        int n = 0;
        String sql = "UPDATE [dbo].[user]\n"
                + "   SET [userAvatar] = ?\n"
                + " WHERE userID = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, ownerProfile.getUserAvatar());
            pre.setInt(2, ownerProfile.getUserID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {

        }
        return n;
    }

    public RoomDetailSe getRoomDetail(int roomid) {
        String query = "select r.roomID, r.roomFloor, r.roomNumber, r.roomSize, r.roomFee, r.roomImg, \n"
                + "i.itemName, i.itemImg, ri.quantity, ri.itemID, r.roomOccupant, r.roomStatus\n"
                + "from room r\n"
                + "left join roomItem ri on r.roomID = ri.roomID \n"
                + "left join item i on ri.itemID = i.itemID \n"
                + "where r.roomID = ?";

        RoomDetailSe roomDetail = null;
        List<String> itemNames = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();
        List<Integer> itemIDs = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, roomid);
            try (ResultSet rs = ps.executeQuery()) {
                boolean roomDetailSet = false;
                while (rs.next()) {
                    if (!roomDetailSet) {
                        int roomID = rs.getInt("roomID");
                        int roomNumber = rs.getInt("roomNumber");
                        int roomFloor = rs.getInt("roomFloor");
                        int roomSize = rs.getInt("roomSize");
                        double roomFee = rs.getDouble("roomFee");
                        String roomImg = rs.getString("roomImg");
                        int roomOccupant = rs.getInt("roomOccupant");
                        int roomStatus = rs.getInt("roomStatus");
                        roomDetail = new RoomDetailSe(roomID, roomNumber, roomSize, roomFloor,
                                roomImg, null, null, null, roomFee, null, roomOccupant, roomStatus);
                        roomDetailSet = true;
                    }

                    int itemID = rs.getInt("itemID");
                    if (!rs.wasNull()) {
                        String itemName = rs.getString("itemName");
                        itemNames.add(itemName);

                        int quantity = rs.getInt("quantity");
                        quantities.add(quantity);

                        itemIDs.add(itemID);
                    }
                }

                if (roomDetail != null) {
                    roomDetail.setItemName(itemNames.toArray(new String[0]));
                    roomDetail.setQuantity(quantities.stream().mapToInt(i -> i).toArray());
                    roomDetail.setItemID(itemIDs.stream().mapToInt(i -> i).toArray());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roomDetail;
    }

    public int deleteRoomItem(int roomID, int itemID) {
        String query = "DELETE FROM roomItem WHERE roomID = ? AND itemID = ?";
        int n = 0;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, roomID);
            ps.setInt(2, itemID);

            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    public int addRoomItem(int roomID, int itemID, int quantity) {
        String query = "INSERT INTO [dbo].[roomItem]\n"
                + "           ([roomID]\n"
                + "           ,[itemID]\n"
                + "           ,[quantity])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        int n = 0;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, roomID);
            ps.setInt(2, itemID);
            ps.setInt(3, quantity);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    public int updateItemQuantity(int roomID, int itemID, int quantity) {
        String query = "UPDATE roomItem SET quantity = ? WHERE roomID = ? AND itemID = ?";
        int n = 0;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, quantity);
            ps.setInt(2, roomID);
            ps.setInt(3, itemID);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    public int updateRoomDetail(int roomID, double roomFee, String roomImg, int roomNumber) {
        String query = "UPDATE [dbo].[room]\n"
                + "   SET [roomNumber] = ?\n"
                + "      ,[roomFee] = ?\n"
                + "      ,[roomImg] = ?\n"
                + " WHERE roomID = ?";
        int n = 0;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, roomNumber);
            ps.setDouble(2, roomFee);
            ps.setString(3, roomImg);
            ps.setInt(4, roomID);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    public boolean isExistRoomNumber(int roomNumber) {
        String query = "select * from room where roomNumber = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, roomNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public int getTotalRoom() {
        String query = "select count(*) from room where roomStatus = 1";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int getCurrentRoomNumber(int roomID) {
        String query = "select roomNumber from room where roomID = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, roomID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int updateRoomStatus(int roomID, int roomStatus) {
        String query = "Update room set roomStatus = ? where roomID = ?";
        int n = 0;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, roomStatus);
            ps.setInt(2, roomID);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }
    
    public int updateRoomOccupant(int roomID) {
        String query = "Update room set roomOccupant += 1  where roomID = ?";
        int n = 0;
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, roomID);
            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM Room";

        try (Connection conn = connection; PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Room room = new Room();
                room.setRoomID(rs.getInt("roomID"));
                room.setRoomFloor(rs.getInt("roomFloor"));
                room.setRoomNumber(rs.getInt("roomNumber"));
                room.setRoomSize(rs.getInt("roomSize"));
                room.setRoomFee(rs.getBigDecimal("roomFee"));

                room.setRoomImg(rs.getString("roomImg"));

                rooms.add(room);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rooms;
    }

    public List<RoomItem> getRoomDetails(String roomId) {
        List<RoomItem> roomItems = new ArrayList<>();

        String sql = "select ri.itemID,i.itemName,i.itemImg,ri.quantity from roomItem ri join item i on ri.itemID = i.itemID where ri.roomID = ? ";

        try {
            java.sql.Connection conn = connection;
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, roomId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RoomItem roomItem = new RoomItem();

                roomItem.setItemID(rs.getInt("itemID"));
                roomItem.setQuantity(rs.getInt("quantity"));
                roomItem.setItemName(rs.getString("itemName"));
                roomItem.setItemImg(rs.getString("itemImg"));

                roomItems.add(roomItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return roomItems;
    }

    public Room getRoomDetailByID(int id) {
        String sql = "SELECT \n"
                + "    r.roomID,\n"
                + "    r.roomFloor,\n"
                + "    r.roomNumber,\n"
                + "    r.roomSize,\n"
                + "    r.roomFee,\n"
                + "    r.roomImg,\n"
                + "    r.roomOccupant,\n"
                + "    COUNT(re.renterID) AS total\n"
                + "FROM \n"
                + "    Room r\n"
                + "LEFT JOIN \n"
                + "    Renter re ON r.roomID = re.roomID\n"
                + "WHERE \n"
                + "    r.roomID = ?\n"
                + "GROUP BY \n"
                + "    r.roomID, r.roomFloor, r.roomNumber, r.roomSize, r.roomFee, r.roomImg, r.roomOccupant";

        Room room = null;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int roomID = rs.getInt("roomID");
                    int roomFloor = rs.getInt("roomFloor");
                    int roomNumber = rs.getInt("roomNumber");
                    int roomSize = rs.getInt("roomSize");
                    BigDecimal roomFee = rs.getBigDecimal("roomFee");
                    String roomImg = rs.getString("roomImg");
                    int total = rs.getInt("total");
                    int roomOccupant = rs.getInt("roomOccupant");
                    room = new Room(roomID, roomFloor, roomNumber, roomSize, roomImg, roomFee, total, roomOccupant);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving room details: " + e.getMessage());
            e.printStackTrace();
        }
        return room;
    }
    
    public Rooms getRoomByID(int id) {
        String sql = "SELECT \n"
                + "    r.roomID,\n"
                + "    r.roomFloor,\n"
                + "    r.roomNumber,\n"
                + "    r.roomSize,\n"
                + "    r.roomFee,\n"
                + "    r.roomImg,\n"
                + "    r.roomOccupant\n"
                + "    COUNT(re.renterID) AS total\n"
                + "FROM \n"
                + "    Room r\n"
                + "LEFT JOIN \n"
                + "    Renter re ON r.roomID = re.roomID\n"
                + "WHERE \n"
                + "    r.roomID = ?\n"
                + "GROUP BY \n"
                + "    r.roomID, r.roomFloor, r.roomNumber, r.roomSize, r.roomFee, r.roomImg";

        Rooms room = null;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int roomID = rs.getInt("roomID");
                    int roomFloor = rs.getInt("roomFloor");
                    int roomNumber = rs.getInt("roomNumber");
                    int roomSize = rs.getInt("roomSize");
                    BigDecimal roomFee = rs.getBigDecimal("roomFee");
                    String roomImg = rs.getString("roomImg");
                    int roomOccupant = rs.getInt("roomOccupant");
                    int total = rs.getInt("total");
                    room = new Rooms(roomID, roomFloor, roomNumber, roomSize, roomFee, roomImg, roomOccupant);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving room details: " + e.getMessage());
            e.printStackTrace();
        }
        return room;
    }
    public Room getRoomDetailByNumber(int roomNumber) {
    String sql = "SELECT \n"
            + "    r.roomID,\n"
            + "    r.roomFloor,\n"
            + "    r.roomNumber,\n"
            + "    r.roomSize,\n"
            + "    r.roomFee,\n"
            + "    r.roomImg,\n"
            + "    r.roomOccupant,\n"
            + "    COUNT(re.renterID) AS total\n"
            + "FROM \n"
            + "    Room r\n"
            + "LEFT JOIN \n"
            + "    Renter re ON r.roomID = re.roomID\n"
            + "WHERE \n"
            + "    r.roomNumber = ?\n"
            + "GROUP BY \n"
            + "    r.roomID, r.roomFloor, r.roomNumber, r.roomSize, r.roomFee, r.roomImg, r.roomOccupant";

    Room room = null;
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, roomNumber);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int roomID = rs.getInt("roomID");
                int roomFloor = rs.getInt("roomFloor");
                int roomNum = rs.getInt("roomNumber"); // Changed variable name to avoid conflict
                int roomSize = rs.getInt("roomSize");
                BigDecimal roomFee = rs.getBigDecimal("roomFee");
                String roomImg = rs.getString("roomImg");
                int total = rs.getInt("total");
                int roomOccupant = rs.getInt("roomOccupant");
                room = new Room(roomID, roomFloor, roomNum, roomSize, roomImg, roomFee, total, roomOccupant);
            }
        }
    } catch (SQLException e) {
        System.out.println("Error retrieving room details: " + e.getMessage());
        e.printStackTrace();
    }
    return room;
}

//      public static void main(String[] args) {
//        RoomDAO dao = new RoomDAO();
//        int testRoomID = 1; // Replace with a valid room ID for testing
//        Room room = dao.getRoomDetailByID(testRoomID);
//        if (room != null) {
//            System.out.println("Room ID: " + room.getRoomID());
//            System.out.println("Room Floor: " + room.getRoomFloor());
//            System.out.println("Room Number: " + room.getRoomNumber());
//            System.out.println("Room Size: " + room.getRoomSize());
//            System.out.println("Room Fee: " + room.getRoomFee());
//            System.out.println("Room Image: " + room.getRoomImg());
//            System.out.println("Total Renters: " + room.getTotal());
//        } else {
//            System.out.println("No room found with ID: " + testRoomID);
//        }
//    }
//          public static void main(String[] args) {
//        RoomDAO dao = new RoomDAO();
//        List<Rooms> pagingRoom = dao.pagingRoom(1, 1);
//        for (Rooms rooms : pagingRoom) {
//            System.out.println(rooms.getRoomID());
//        }
//    }
    public static void main(String[] args) {
        RoomDAO dao = new RoomDAO();
        List<Rooms> get = dao.getRooms();
        
        for (Rooms rooms : get) {
            System.out.println(rooms.getRoomDepartment());
        }
    }
}
