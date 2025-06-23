<%@page import="java.sql.*"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="javax.servlet.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="Database.ConnectionClass" id="con"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
    <title>Student Dashboard</title>
    
    <!-- Bootstrap + FontAwesome + Google Fonts -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #74ebd5 0%, #acb6e5 100%);
            min-height: 100vh;
            margin: 0;
        }

        .navbar {
            background-color: rgba(0,0,0,0.85);
        }

        .navbar-brand, .navbar-nav .nav-link {
            color: white !important;
        }

        .dashboard-container {
            padding: 40px 20px;
        }

        .card {
            border: none;
            border-radius: 15px;
            transition: transform 0.3s ease-in-out;
            box-shadow: 0 8px 20px rgba(0,0,0,0.1);
        }

        .card:hover {
            transform: translateY(-5px);
        }

        .card-body i {
            font-size: 2.5rem;
            color: #4e73df;
        }

        .welcome-text {
            color: #333;
            margin-bottom: 30px;
        }

        .footer {
            text-align: center;
            color: #fff;
            padding: 10px;
            font-size: 14px;
        }

        @media (max-width: 768px) {
            .card-body i {
                font-size: 2rem;
            }
        }
    </style>
</head>
<body>

<%
    String admissionNo = (String) session.getAttribute("user");
    String studentName = "Student";

    if (admissionNo != null) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = con.getConnection();
            String sql = "SELECT name FROM stureg WHERE admission_no = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, admissionNo);
            rs = ps.executeQuery();

            if (rs.next()) {
                studentName = rs.getString("name");
            }

        } catch (Exception e) {
            // You may log the error here
        } finally {
            if (rs != null) try { rs.close(); } catch (Exception e) {}
            if (ps != null) try { ps.close(); } catch (Exception e) {}
        }
    }
%>

<!-- Top Navigation Bar -->
<nav class="navbar navbar-expand-lg">
    <div class="container">
        <a class="navbar-brand" href="#"><i class="fas fa-bullhorn"></i> Notice Point</a>
        <div class="ml-auto">
            <a href="logout.jsp" class="btn btn-outline-light"><i class="fas fa-sign-out-alt"></i> Logout</a>
        </div>
    </div>
</nav>

<!-- Dashboard Content -->
<div class="container dashboard-container">
    <h3 class="text-center welcome-text">
        Welcome, <%= studentName %>!
    </h3>

    <div class="row text-center justify-content-center">
        <!-- View Notices -->
        <div class="col-md-6 col-lg-3 mb-4">
            <div class="card p-4">
                <div class="card-body">
                    <i class="fas fa-bullhorn mb-2"></i>
                    <h5 class="card-title">Notices</h5>
                    <a href="viewnotice.jsp" class="btn btn-sm btn-outline-primary">View</a>
                </div>
            </div>
        </div>

        <!-- View Exams -->
        <div class="col-md-6 col-lg-3 mb-4">
            <div class="card p-4">
                <div class="card-body">
                    <i class="fas fa-file-alt mb-2"></i>
                    <h5 class="card-title">Exams</h5>
                    <a href="viewexam.jsp" class="btn btn-sm btn-outline-primary">Check</a>
                </div>
            </div>
        </div>

        <!-- My Profile -->
        <div class="col-md-6 col-lg-3 mb-4">
            <div class="card p-4">
                <div class="card-body">
                    <i class="fas fa-user mb-2"></i>
                    <h5 class="card-title">My Profile</h5>
                    <a href="myprofile.jsp" class="btn btn-sm btn-outline-primary">View</a>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-lg-3 mb-4">
    <div class="card p-4">
        <div class="card-body text-center">
            <i class="fas fa-edit mb-2 fa-2x"></i>
            <h5 class="card-title">Edit Profile</h5>
            <a href="editprofile.jsp" class="btn btn-sm btn-outline-primary">Edit</a>
        </div>
    </div>
</div>

    </div>
</div>

<!-- Footer -->
<div class="footer">
    &copy; <%= java.time.Year.now() %> College Notice Board. All rights reserved.
</div>

<!-- Bootstrap Scripts -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>

</body>
</html>
