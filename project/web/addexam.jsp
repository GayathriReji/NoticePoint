<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String admin = (String) session.getAttribute("admin");
    if (admin == null) {
        response.sendRedirect("alogin.jsp");
        return;
    }

    String editId = request.getParameter("edit");
    String title = "", dept_code = "", date = "", time = "", venue = "";
    boolean isEdit = false;

    if (editId != null) {
        isEdit = true;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM exam WHERE id = ?");
            ps.setString(1, editId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                title = rs.getString("title");
                dept_code = rs.getString("dept_code");
                date = rs.getString("date");
                time = rs.getString("time");
                venue = rs.getString("venue");
            }
            con.close();
        } catch (Exception e) {
            out.println("<div class='alert alert-danger'>Error loading exam: " + e.getMessage() + "</div>");
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title><%= isEdit ? "Edit Exam" : "Add Exam" %> - NoticePoint</title>
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
    <h3 class="text-center mb-4"><%= isEdit ? "✏️ Edit Exam" : "📘 Add New Exam" %></h3>
    <form method="post" action="addexam.jsp<%= isEdit ? "?edit=" + editId : "" %>">
        <div class="form-group">
            <label>Exam Title</label>
            <input type="text" name="title" class="form-control" value="<%= title %>" required>
        </div>
        <div class="form-group">
            <label>Department</label>
            <select name="dept_code" class="form-control" required>
                <option value="" disabled <%= dept_code.equals("") ? "selected" : "" %>>--Select--</option>
                <% 
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
                        String query = "SELECT dept_code, dept_name FROM department WHERE status = 0";
                        PreparedStatement ps = con.prepareStatement(query);
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                            String code = rs.getString("dept_code");
                            String name = rs.getString("dept_name");
                %>
                <option value="<%= code %>" <%= code.equals(dept_code) ? "selected" : "" %>><%= name %></option>
                <% 
                        }
                        con.close();
                    } catch (Exception e) {
                        out.println("<option>Error loading department</option>");
                    }
                %>
            </select>
        </div>
        <div class="form-group">
            <label>Date</label>
            <input type="date" name="date" class="form-control" value="<%= date %>" required>
        </div>
        <div class="form-group">
            <label>Time</label>
            <input type="text" name="time" class="form-control" value="<%= time %>" required>
        </div>
        <div class="form-group">
            <label>Venue</label>
            <input type="text" name="venue" class="form-control" value="<%= venue %>" required>
        </div>
        <button type="submit" class="btn btn-primary mt-3"><%= isEdit ? "Update" : "Add" %> Exam</button>
    </form>

    <%
        if (request.getMethod().equalsIgnoreCase("POST")) {
            String t = request.getParameter("title");
            String d = request.getParameter("dept_code");
            String dt = request.getParameter("date");
            String tm = request.getParameter("time");
            String v = request.getParameter("venue");

            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
                PreparedStatement ps;

                if (isEdit) {
                    String sql = "UPDATE exam SET title=?, dept_code=?, date=?, time=?, venue=? WHERE id=?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, t);
                    ps.setString(2, d);
                    ps.setString(3, dt);
                    ps.setString(4, tm);
                    ps.setString(5, v);
                    ps.setString(6, editId);
                } else {
                    String sql = "INSERT INTO exam (title, dept_code, date, time, venue) VALUES (?, ?, ?, ?, ?)";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, t);
                    ps.setString(2, d);
                    ps.setString(3, dt);
                    ps.setString(4, tm);
                    ps.setString(5, v);
                }

                ps.executeUpdate();
                con.close();
    %>
                <div class="alert alert-success mt-3">
                    ✅ Exam <%= isEdit ? "updated" : "added" %> successfully!
                </div>
    <%
            } catch (Exception e) {
    %>
                <div class="alert alert-danger mt-3">❌ Error: <%= e.getMessage() %></div>
    <%
            }
        }
    %>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
