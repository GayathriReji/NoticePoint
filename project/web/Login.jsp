<!DOCTYPE html>
<html>
<head>
    <title>Login - College Notice Board</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background: url('background.jpg') no-repeat center center fixed;
            background-size: cover;
        }
        .login-container {
            background: rgba(255, 255, 255, 0.9);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            margin-top: 100px;
        }
    </style>
</head>
<body>
    <div class="container d-flex justify-content-center">
        <div class="col-md-4 login-container">
            <h3 class="text-center">Login</h3>
            <form method="post">
                <div class="form-group">
                    <label>Admission No</label>
                    <input type="text" name="admission_no" class="form-control" placeholder="Enter your admission number" required>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" name="password" class="form-control" placeholder="Enter your password" required>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Login</button>
                <p class="text-center mt-3">
                    <a href="#">Forgot Password?</a>
                </p>
                <p class="text-center mt-3">
                    <a href="Index.jsp" class="btn btn-secondary btn-block">Back to Home</a>
                </p>
            </form>
            
            <%@page import="java.sql.*"%>
            <%@page import="javax.servlet.http.*"%>
            <%@page import="javax.servlet.*"%>
            <%@page contentType="text/html" pageEncoding="UTF-8"%>
            <jsp:useBean class="Database.ConnectionClass" id="con"></jsp:useBean>
            
            <%
                String admissionNo = request.getParameter("admission_no");
                String password = request.getParameter("password");
            
                if (admissionNo != null && password != null) {
                    String query = "SELECT * FROM stureg WHERE admission_no = ? AND password = ?";
                    try {
                        PreparedStatement ps = con.getConnection().prepareStatement(query);
                        ps.setString(1, admissionNo);
                        ps.setString(2, password);
                        ResultSet rs = ps.executeQuery();
            
                        if (rs.next()) {
                            session.setAttribute("user", admissionNo);
                            response.sendRedirect("Sdashboard.jsp");
                        } else {
            %>
                            <script>
                                alert("You are not registered yet! Please sign up.");
                                window.location.href = "Login.jsp";
                            </script>
            <%
                        }
                    } catch (Exception e) {
                        out.println("Database error: " + e.getMessage());
                    }
                }
            %>
        </div>
    </div>
</body>
</html>
