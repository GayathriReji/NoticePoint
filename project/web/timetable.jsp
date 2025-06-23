<%@ page import="java.sql.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%
    String admin = (String) session.getAttribute("admin");
    if (admin == null) {
        response.sendRedirect("alogin.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Add Timetable - College Notice Board</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap & Icons -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

    <style>
        body {
            background: url('background.jpg') no-repeat center center fixed;
            background-size: cover;
        }
        .overlay {
            background: rgba(255, 255, 255, 0.95);
            min-height: 100vh;
        }
        .header {
            height: 56px;
            width: 100%;
            position: fixed;
            top: 0;
            left: 0;
            background: #1abc9c;
            padding: 10px 20px;
            color: white;
            z-index: 1000;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .header nav a {
            color: white;
            margin-right: 15px;
            text-decoration: none;
            font-weight: 500;
            transition: 0.3s;
        }
        .header nav a:hover {
            color: #f1c40f;
        }
        .sidebar {
            height: 100vh;
            width: 250px;
            position: fixed;
            top: 56px;
            left: 0;
            background: #2c3e50;
            padding-top: 20px;
            z-index: 999;
        }
        .sidebar a {
            padding: 12px 20px;
            text-decoration: none;
            font-size: 17px;
            color: #ecf0f1;
            display: block;
            transition: background 0.3s, padding-left 0.3s;
        }
        .sidebar a:hover {
            background: #34495e;
            color: #f1c40f;
            padding-left: 30px;
        }
        .main-content {
            margin-left: 270px;
            margin-top: 80px;
            background: rgba(255, 255, 255, 0.95);
            padding: 30px;
            border-radius: 10px;
            min-height: 80vh;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
        }
    </style>
</head>

<body>
<!-- Header -->
<div class="header d-flex justify-content-between align-items-center">
    <div class="d-flex align-items-center">
        <h5 class="mb-0"><i class="bi bi-mortarboard-fill"></i> &nbsp;College Notice Board - Admin</h5>
        <nav class="ml-4 d-flex align-items-center">
            <a href="Adashboard.jsp"><i class="bi bi-house-fill"></i> Home</a>
        </nav>
    </div>
    <span><i class="bi bi-person-circle"></i> Admin</span>
</div>

<!-- Sidebar -->
<div class="sidebar">
    <a href="Adashboard.jsp"><i class="bi bi-speedometer2"></i> Dashboard</a>
    <a href="add_dept.jsp"><i class="bi bi-building"></i> Add Department</a>
    <a href="view_dept.jsp"><i class="bi bi-building"></i> View Department</a>
    <a href="addexam.jsp"><i class="bi bi-megaphone-fill"></i> Add Exam</a>
    <a href="timetable.jsp"><i class="bi bi-calendar3"></i> Add Timetable</a>
    <a href="alogout.jsp"><i class="bi bi-box-arrow-right"></i> Logout</a>
</div>

<!-- Main Content -->
<div class="main-content">
    <h3 class="text-center mb-4">📅 Add Exam Timetable</h3>

    <% String success = request.getParameter("success");
       if ("true".equals(success)) {
    %>
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        ✅ Timetable added successfully!
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    <% } %>

    <form method="post" action="timetable.jsp">
        <div class="form-group">
            <label>Department</label>
            <select name="dept" class="form-control" required>
                <option value="">-- Select Department --</option>
                <%
                    try {
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT dept_code, dept_name FROM department WHERE status=0");
                        while (rs.next()) {
                            String code = rs.getString("dept_code");
                            String name = rs.getString("dept_name");
                %>
                            <option value="<%= code %>"><%= code %> - <%= name %></option>
                <%
                        }
                        conn.close();
                    } catch (Exception e) {
                        out.println("<option>Error loading departments</option>");
                        e.printStackTrace();
                    }
                %>
            </select>
        </div>

        <div class="form-group">
            <label>Exam Name</label>
            <input type="text" name="exam" class="form-control" required>
        </div>

        <div class="form-group">
            <label>Subject</label>
            <input type="text" name="subject" class="form-control" required>
        </div>

        <div class="form-group">
            <label>Date</label>
            <input type="date" name="exam_date" class="form-control" required>
        </div>

        <div class="form-group">
            <label>Time</label>
            <input type="text" name="exam_time" class="form-control" placeholder="e.g. 9:30 AM - 12:30 PM" required>
        </div>

        <button type="submit" name="action" value="add" class="btn btn-success btn-block">Add Timetable</button>
    </form>
</div>

<!-- Scripts -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>

<!-- Backend Logic -->
<%
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            String dept = request.getParameter("dept");
            String exam = request.getParameter("exam");
            String subject = request.getParameter("subject");
            String exam_date = request.getParameter("exam_date");
            String exam_time = request.getParameter("exam_time");

            Connection conn = null;
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
                String sql = "INSERT INTO timetable (dept_code, exam, subject, exam_date, exam_time) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, dept);
                ps.setString(2, exam);
                ps.setString(3, subject);
                ps.setString(4, exam_date);
                ps.setString(5, exam_time);
                ps.executeUpdate();

                response.sendRedirect("timetable.jsp?success=true");
            } catch (Exception e) {
                out.println("<script>alert('Error: " + e.getMessage() + "');</script>");
                e.printStackTrace();
            } finally {
                if (conn != null) try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
            }
        }
    }
%>
