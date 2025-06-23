<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Login - College Notice Board</title>
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
            <h3 class="text-center">Admin Login</h3>
            <form method="post">
                <div class="form-group">
                    <label>Email</label>
                    <input type="email" name="email" class="form-control" placeholder="Enter admin email" required>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" name="password" class="form-control" placeholder="Enter admin password" required>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Login</button>
                <p class="text-center mt-3">
                    <a href="Index.jsp" class="btn btn-secondary btn-block">Back to Home</a>
                </p>
            </form>

            <% 
                String email = request.getParameter("email");
                String password = request.getParameter("password");

                if (email != null && password != null) {
                    if (email.equals("admin@gmail.com") && password.equals("admin@123")) {
                        session.setAttribute("admin", "Admin");
                        response.sendRedirect("Adashboard.jsp");
                    } else {
            %>
                        <script>
                            alert("Invalid Admin Credentials!");
                            window.location.href = "ALogin.jsp";
                        </script>
            <%
                    }
                }
            %>
        </div>
    </div>
</body>
</html>
