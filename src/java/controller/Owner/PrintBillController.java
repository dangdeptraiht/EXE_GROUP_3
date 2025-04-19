/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Owner;

import dao.BillDAO;
import dao.RoomDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import model.Bill;
import model.Room;

/**
 *
 * @author DAT
 */
@WebServlet(name = "PrintBillController", urlPatterns = {"/printBill"})
public class PrintBillController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String raw_id = request.getParameter("id");
        int id = Integer.parseInt(raw_id);
        BillDAO dbBill = new BillDAO();
        Bill bill = dbBill.getBillBybillID(id);
        RoomDAO dbRoom = new RoomDAO();
        Room room = dbRoom.findById(bill.getRoomID());
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            double total = bill.getRoomFee()+bill.getElectric()+bill.getService()
                    +bill.getService()+bill.getPenMoney()+bill.getOther();
            String billContent = "<html>"
                    + "<head>"
                    + "<title>Bill</title>"
                    + "<script type='text/javascript'>"
                    + "function printBill() {"
                    + "    window.print();"
                    + "}"
                    + "</script>"
                    + "</head>"
                    + "<body onload='printBill()'>"
                    + "<h1>Bill</h1>"
                    + "<p>Room Number: " + room.getRoomNumber() + "</p>"
                    + "<p>Room Fee: " + bill.getRoomFee() + "</p>"
                    + "<p>Water: " + bill.getWater() + "</p>"
                    + "<p>Electric : " + bill.getElectric() + "</p>"
                    + "<p>Service : " + bill.getService() + "</p>"
                    + "<p>Penalty money: " + bill.getPenMoney() + "</p>"
                    + "<p>Other money: " + bill.getOther() + "</p>"
                    + "<p>Join Date :" + bill.getCreateAt() + "</p>"
                    + "<p>Pay Date :" + bill.getPayAt() + "</p>"
                    + "<p>Deadline payment :" + bill.getDeadline() + "</p>"
                    + "<h3>Total :" + total + "</h3>"
                    + "</html>";

            out.println(billContent);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
