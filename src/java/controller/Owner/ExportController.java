//package controller.Owner;
//
//import dao.RenterDAO;
//import dao.UserDAO;
//import model.RenterList;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.List;
//
//@WebServlet("/exportRenters")
//public class ExportController extends HttpServlet {
//
//    private static final long serialVersionUID = 1L;
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        UserDAO userDAO = new UserDAO();
//        String email = (String) session.getAttribute("email");
//        String password = (String) session.getAttribute("password");
//        int userRole = userDAO.getUserRoleByEmailAndPassword(email, password);
//        if (userRole != 2) {
//            request.setAttribute("error", "You have to login first!!!");
//            request.getRequestDispatcher("login.jsp").forward(request, response);
//            return;
//        }
//        
//        
//        RenterDAO renterDAO = new RenterDAO();
//        List<RenterList> renters = renterDAO.getAllRentersExcel();
//
//        Workbook workbook = new XSSFWorkbook();
//        Sheet sheet = workbook.createSheet("Renters");
//
//        Row headerRow = sheet.createRow(0);
//        Cell headerCell1 = headerRow.createCell(0);
//        headerCell1.setCellValue("Renter Name");
//        Cell headerCell2 = headerRow.createCell(1);
//        headerCell2.setCellValue("Room Number");
//        Cell headerCell3 = headerRow.createCell(2);
//        headerCell3.setCellValue("Room Floor");
//        Cell headerCell4 = headerRow.createCell(3);
//        headerCell4.setCellValue("Department");
//        Cell headerCell5 = headerRow.createCell(4);
//        headerCell5.setCellValue("Service Fee");
//        Cell headerCell6 = headerRow.createCell(5);
//        headerCell6.setCellValue("Electric Number");
//        Cell headerCell7 = headerRow.createCell(6);
//        headerCell7.setCellValue("Water Number");
//        Cell headerCell8 = headerRow.createCell(7);
//        headerCell8.setCellValue("Other Fee");
//        Cell headerCell9 = headerRow.createCell(8);
//        headerCell9.setCellValue("Penalty Fee");
//
//        int rowNum = 1;
//        for (RenterList renter : renters) {
//            Row row = sheet.createRow(rowNum++);
//            Cell cell1 = row.createCell(0);
//            cell1.setCellValue(renter.getUserName());
//            Cell cell2 = row.createCell(1);
//            cell2.setCellValue(renter.getRoomNumber());
//            Cell cell3 = row.createCell(2);
//            cell3.setCellValue(renter.getRoomFloor());
//            Cell cell4 = row.createCell(3);
//            cell4.setCellValue(renter.getDepartment());
//        }
//
//        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//        response.setHeader("Content-Disposition", "attachment; filename=renters.xlsx");
//
//        try (OutputStream out = response.getOutputStream()) {
//            workbook.write(out);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            workbook.close();
//        }
//    }
//}
