<%-- 
    Document   : sendEmail.jsp
    Created on : Jun 2, 2025, 1:35:12 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="sendemail" method="post">
            <label>Email người nhận:</label><br>
            <input type="email" name="to" required><br><br>

            <label>Loại email:</label><br>
            <select name="action" required>
                <option value="feedback">Gửi phản hồi</option>
                <option value="vip-confirm">Xác nhận tin VIP</option>
                <option value="request-success">Thuê phòng thành công</option>
                <option value="host-register">Đăng ký làm chủ trọ thành công</option>
            </select><br><br>

            <button type="submit">Gửi Email</button>
        </form>


    </body>
</html>
