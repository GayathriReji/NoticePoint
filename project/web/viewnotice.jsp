<%@ page import="java.sql.*" %>
<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean class="Database.ConnectionClass" id="con"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
    <title>Department Notices - College Notice Board</title>

    <!-- Bootstrap, FontAwesome, Google Fonts -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">

    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #74ebd5, #acb6e5);
            min-height: 100vh;
        }

        .navbar {
            background-color: rgba(0, 0, 0, 0.85);
        }

        .navbar-brand, .navbar-nav .nav-link {
            color: #fff !important;
        }

        .content-card {
            background: #fff;
            border-radius: 15px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.1);
            padding: 30px;
            margin-top: 50px;
            transition: transform 0.3s;
        }

        .content-card:hover {
            transform: translateY(-5px);
        }

        .content-heading {
            font-weight: 600;
            margin-bottom: 25px;
            color: #333;
        }

        .notice-card {
            background-color: #f9f9fb;
            border-left: 5px solid #007bff;
            border-radius: 10px;
            margin-bottom: 20px;
            padding: 20px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
        }

        .notice-title {
            font-size: 1.25rem;
            font-weight: bold;
            color: #0056b3;
        }

        .notice-description {
            margin-top: 10px;
            color: #555;
        }

        .notice-date {
            text-align: right;
            color: #888;
            font-size: 0.9rem;
        }

        .alert {
            border-radius: 10px;
        }
    </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg">
        <div class="container">
            <a class="navbar-brand" href="#"><i class="fas fa-bullhorn"></i> NoticePoint</a>
            <div class="ml-auto">
                <a href="Sdashboard.jsp" class="nav-link d-inline text-white"><i class="fas fa-home"></i> Home</a>
                <a href="viewnotice.jsp" class="nav-link d-inline text-white"><i class="fas fa-bullhorn"></i> Notices</a>
                <a href="viewexam.jsp" class="nav-link d-inline text-white"><i class="fas fa-file-alt"></i> Exam</a>
                <a href="myprofile.jsp" class="nav-link d-inline text-white"><i class="fas fa-user"></i> Profile</a>
                <a href="logout.jsp" class="btn btn-outline-light ml-2"><i class="fas fa-sign-out-alt"></i> Logout</a>
            </div>
        </div>
    </nav>

<!-- Main Content -->
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-10">
            <div class="content-card">
                <h4 class="text-center content-heading"><i class="fas fa-bullhorn"></i> Department Notices</h4>

<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);

    String admissionNo = (String) session.getAttribute("user");

    if (admissionNo == null) {
%>
        <div class="alert alert-warning text-center">
            <i class="fas fa-exclamation-circle"></i> You are not logged in. 
            <a href="Login.jsp" class="btn btn-sm btn-primary ml-2">Login</a>
        </div>
<%
    } else {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = con.getConnection();

            String deptQuery = "SELECT s.dept_code, d.dept_name FROM stureg s JOIN department d ON s.dept_code = d.dept_code WHERE s.admission_no = ? AND s.status = 'active'";
            ps = connection.prepareStatement(deptQuery);
            ps.setString(1, admissionNo);
            rs = ps.executeQuery();

            String deptCode = null;
            String deptName = null;

            if (rs.next()) {
                deptCode = rs.getString("dept_code");
                deptName = rs.getString("dept_name");
            }

            if (deptCode != null) {
%>
                <div class="alert alert-info text-center mb-4">
                    <strong>Showing notices for:</strong> <%= deptName %>
                </div>
<%
                rs.close();
                ps.close();

                String noticeQuery = "SELECT title, description, created_at FROM notices WHERE dept_code = ? AND status = 0 ORDER BY created_at DESC";
                ps = connection.prepareStatement(noticeQuery);
                ps.setString(1, deptCode);
                rs = ps.executeQuery();

                if (!rs.isBeforeFirst()) {
%>
                    <div class="alert alert-secondary text-center">No active notices found.</div>
<%
                } else {
                    while (rs.next()) {
%>
                        <div class="notice-card">
                            <div class="notice-title"><i class="fas fa-circle text-primary mr-2"></i> <%= rs.getString("title") %></div>
                            <div class="notice-description"><%= rs.getString("description") %></div>
                            <div class="notice-date"><i class="far fa-clock"></i> <%= rs.getTimestamp("created_at") %></div>
                        </div>
<%
                    }
                }
            } else {
%>
                <div class="alert alert-danger text-center">Department not found. Please contact admin.</div>
<%
            }

        } catch (Exception e) {
%>
            <div class="alert alert-danger text-center">Error: <%= e.getMessage() %></div>
<%
        } finally {
            if (rs != null) try { rs.close(); } catch (Exception e) {}
            if (ps != null) try { ps.close(); } catch (Exception e) {}
        }
    }
%>

            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>

</body>
</html>
