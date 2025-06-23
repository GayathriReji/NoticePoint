<%@page import="java.sql.ResultSet"%>
<jsp:useBean class="Database.ConnectionClass" id="con"></jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Student Registration - College Notice Board</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background: url('background.jpg') no-repeat center center fixed;
            background-size: cover;
        }
        .registration-container {
            background: rgba(255, 255, 255, 0.9);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            margin-top: 50px;
        }
    </style>
</head>
<body>
    <div class="container d-flex justify-content-center">
        <div class="col-md-6 registration-container">
            <h3 class="text-center">Student Registration</h3>
            <form method="post">
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" name="name" class="form-control" placeholder="Enter your full name" required>
                </div>
                <div class="form-group">
                    <label>Admission No</label>
                    <input type="text" name="admission_no" class="form-control" placeholder="Enter your admission number" required>
                </div>
                <div class="form-group">
                    <label>Address</label>
                    <input type="text" name="address" class="form-control" placeholder="Enter your address" required>
                </div>
                <div class="form-group">
                    <label>Course</label>
                    <input type="text" name="course" class="form-control" placeholder="Enter your course" required>
                </div>
                <div class="form-group">
                    <label>Year of Study</label>
                    <input type="number" name="year" class="form-control" placeholder="Enter your year of study" required>
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input type="email" name="email" class="form-control" placeholder="Enter your email" required>
                </div>

                <div class="form-group">
                    <label>Phone Number</label>
                    <input type="text" name="phone" class="form-control" placeholder="Enter your phone number" required>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" name="password" class="form-control" placeholder="Enter a strong password" required>
                </div>
                <button type="submit" class="btn btn-success btn-block">Register</button>
                <p class="text-center mt-3">
                    <a href="Login.jsp" class="btn btn-secondary btn-block">Back to Login</a>
                </p>
            </form>
            
            <%@page import="java.sql.*"%>
            <%@page import="javax.servlet.http.*"%>
            <%@page import="javax.servlet.*"%>
           
            
            <%
                if (request.getParameter("name") != null) {
                    String name = request.getParameter("name");
                    String admissionNo = request.getParameter("admission_no");
                    String address = request.getParameter("address");
                    String course = request.getParameter("course");
                    String year = request.getParameter("year");
                    String phone = request.getParameter("phone");
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    
                    String query = "INSERT INTO stureg (name, admission_no, address, course, year_of_study, phone,email, password) VALUES (?, ?, ?, ?, ?,?, ?, ?)";
                    try {
                        PreparedStatement ps = con.getConnection().prepareStatement(query);
                        ps.setString(1, name);
                        ps.setString(2, admissionNo);
                        ps.setString(3, address);
                        ps.setString(4, course);
                        ps.setInt(5, Integer.parseInt(year));
                        ps.setString(6, phone);
                        ps.setString(7, email);
                        ps.setString(8, password);
                        
                        int result = ps.executeUpdate();
                        if (result > 0) {
            %>
                            <script>
                                alert("Registration Successful!");
                                window.location.href = "Login.jsp";
                            </script>
            <%
                        } else {
            %>
                            <script>
                                alert("Registration Failed! Please try again.");
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
