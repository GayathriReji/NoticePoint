<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String admin = (String) session.getAttribute("admin");
    if (admin == null) {
        response.sendRedirect("alogin.jsp");
        return;
    }

    // Handle deletion
    String deleteId = request.getParameter("delete");
    if (deleteId != null) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
            PreparedStatement ps = con.prepareStatement("UPDATE exam SET status = 1 WHERE id = ?");
            ps.setString(1, deleteId);
            ps.executeUpdate();
            con.close();
            request.setAttribute("deleted", true);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>View Exams - NoticePoint</title>
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
        .header h5 {
            margin: 0;
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
        .exam-card {
            border-left: 5px solid #1abc9c;
            background-color: #f9f9f9;
            transition: 0.3s;
        }
        .exam-card:hover {
            background-color: #eefaf7;
            transform: scale(1.01);
        }
    </style>
</head>
<body>

<!-- Header -->
<div class="header d-flex justify-content-between align-items-center">
    <div class="d-flex align-items-center">
        <h5 class="mb-0"><i class="bi bi-mortarboard-fill"></i> &nbsp;NoticePoint - Admin</h5>
        <nav class="ml-4 d-flex align-items-center">
            <a href="Adashboard.jsp"><i class="bi bi-house-fill"></i> Home</a>
            <div class="btn-group ml-3">
                <button class="btn btn-sm text-light dropdown-toggle bg-transparent border-0" data-toggle="dropdown">
                    <i class="bi bi-megaphone-fill"></i> Manage Notices
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="notices.jsp"><i class="bi bi-plus-circle-fill"></i> Add Notices</a>
                    <a class="dropdown-item" href="view_a_notice.jsp"><i class="bi bi-eye-fill"></i> View Notices</a>
                </div>
            </div>
            <div class="btn-group ml-3">
                <button class="btn btn-sm text-light dropdown-toggle bg-transparent border-0" data-toggle="dropdown">
                    <i class="bi bi-person-plus-fill"></i> Manage Students
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="students.jsp"><i class="bi bi-plus-circle-fill"></i> Add Students</a>
                    <a class="dropdown-item" href="viewstudent.jsp"><i class="bi bi-eye-fill"></i> View Students</a>
                </div>
            </div>
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
    <a href="view_a_exam.jsp"><i class="bi bi-files"></i> View Exam</a>
    <a href="alogout.jsp"><i class="bi bi-box-arrow-right"></i> Logout</a>
</div>

<!-- Main Content -->
<div class="main-content">
    <h3 class="text-center mb-4"><i class="bi bi-list-ul"></i> View All Exams</h3>

    <% if (request.getAttribute("deleted") != null) { %>
        <div class="alert alert-success">✅ Exam deleted successfully!</div>
    <% } else if (request.getAttribute("error") != null) { %>
        <div class="alert alert-danger">❌ Error: <%= request.getAttribute("error") %></div>
    <% } %>

    <div class="row">
        <%
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT e.*, d.dept_name FROM exam e JOIN department d ON e.dept_code = d.dept_code WHERE e.status = 0");

                while (rs.next()) {
        %>
        <div class="col-md-6 mb-4">
            <div class="card exam-card shadow-sm">
                <div class="card-body">
                    <h5 class="card-title"><%= rs.getString("title") %></h5>
                    <p class="mb-1"><strong>Department:</strong> <span class="badge badge-info"><%= rs.getString("dept_name") %></span></p>
                    <p class="mb-1"><strong>Date:</strong> <%= rs.getString("date") %></p>
                    <p class="mb-1"><strong>Time:</strong> <%= rs.getString("time") %></p>
                    <p class="mb-2"><strong>Venue:</strong> <i class="bi bi-geo-alt-fill"></i> <%= rs.getString("venue") %></p>
                    <div class="d-flex justify-content-end">
                        <a href="addexam.jsp?edit=<%= rs.getString("id") %>" class="btn btn-sm btn-warning mr-2">
                            <i class="bi bi-pencil-fill"></i> Edit
                        </a>
                        <a href="view_a_exam.jsp?delete=<%= rs.getString("id") %>" class="btn btn-sm btn-danger" 
                           onclick="return confirm('Are you sure you want to delete this exam?')">
                            <i class="bi bi-trash-fill"></i> Delete
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <%
                }
                con.close();
            } catch (Exception e) {
        %>
        <div class="col-12 text-danger">❌ Error loading exams: <%= e.getMessage() %></div>
        <% } %>
    </div>
</div>

<!-- Scripts -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
