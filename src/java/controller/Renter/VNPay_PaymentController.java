package controller.Renter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utility.VNPayConfig;

@WebServlet(name = "VNPay_PaymentController", urlPatterns = {"/VNPay_PaymentController"})
public class VNPay_PaymentController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        String amount = request.getParameter("amount");
        
         
        int flag = Integer.parseInt(request.getParameter("flag"));
        int id = 0; // id payment
        if (flag == 0) { // add balance
            id = Integer.parseInt(request.getParameter("id"));
            double money_convert = Double.parseDouble(amount);
            session.setAttribute("money", money_convert);
            session.setAttribute("idPayment", id);
            session.setAttribute("flag", 0);
        } else { // rent room
            int userID = Integer.parseInt(request.getParameter("userID"));
            int roomID_BookRoom = Integer.parseInt(request.getParameter("roomID"));
            session.setAttribute("roomID_BookRoom", roomID_BookRoom);
            session.setAttribute("userID", userID);
            session.setAttribute("flag", 1);
            amount = amount.replace("k VND", "").replace(",", "").trim();
        }

        String vnp_TxnRef = VNPayConfig.getRandomNumber(8);
        String vnp_IpAddr = VNPayConfig.getIpAddress(request);
        String vnp_CreateDate = VNPayConfig.getCurrentDate();
        String vnp_ExpireDate = VNPayConfig.getExpireDate(15);

        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", "2.1.0");
        vnp_Params.put("vnp_Command", "pay");
        vnp_Params.put("vnp_TmnCode", VNPayConfig.vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(Integer.parseInt(amount) * 100000));
        vnp_Params.put("vnp_CurrCode", "VND");
//        vnp_Params.put("vnp_BankCode", "MBBank");
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang");
        vnp_Params.put("vnp_OrderType", "billpayment");
        vnp_Params.put("vnp_Locale", "vn");
        vnp_Params.put("vnp_ReturnUrl", VNPayConfig.vnp_ReturnUrl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        String queryUrl = null;
        try {
            queryUrl = VNPayConfig.hashAllFields(vnp_Params);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(VNPay_PaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        String paymentUrl = VNPayConfig.vnp_Url + "?" + queryUrl;

        response.sendRedirect(paymentUrl);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
