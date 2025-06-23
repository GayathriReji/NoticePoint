<%@ page import="java.sql.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%
    String admin = (String) session.getAttribute("admin");
    if (admin == null) {
        response.sendRedirect("alogin.jsp");
        return;
    }

    // Handle deletion
    String deleteId = request.getParameter("delete_id");
    String deptRedirect = request.getParameter("dept_code");
    if (deleteId != null && deptRedirect != null) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
            PreparedStatement ps = con.prepareStatement("UPDATE notices SET status = 1 WHERE id = ?");
            ps.setInt(1, Integer.parseInt(deleteId));
            ps.executeUpdate();
            con.close();
            response.sendRedirect("view_a_notice.jsp?dept_code=" + deptRedirect);
            return;
        } catch (Exception e) {
            out.println("Error deleting notice: " + e.getMessage());
        }
    }

    // Handle update
    if ("POST".equalsIgnoreCase(request.getMethod()) && request.getParameter("update_id") != null) {
        int updateId = Integer.parseInt(request.getParameter("update_id"));
        String newTitle = request.getParameter("title");
        String newDesc = request.getParameter("description");
        String deptCodePost = request.getParameter("dept_code");

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
            PreparedStatement ps = con.prepareStatement("UPDATE notices SET title=?, description=? WHERE id=?");
            ps.setString(1, newTitle);
            ps.setString(2, newDesc);
            ps.setInt(3, updateId);
            ps.executeUpdate();
            con.close();
            response.sendRedirect("view_a_notice.jsp?dept_code=" + deptCodePost);
            return;
        } catch (Exception e) {
            out.println("Error updating notice: " + e.getMessage());
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>View Department Notices - NoticePoint</title>
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
    <h3 class="text-center mb-4"><i class="bi bi-eye-fill"></i> View Department-wise Notices</h3>

    <form method="get" class="form-inline justify-content-center mb-4">
        <label class="mr-2 font-weight-bold">Select Department:</label>
        <select name="dept_code" class="form-control mr-2" required>
            <option value="">-- Select --</option>
            <%
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
                    PreparedStatement ps = con.prepareStatement("SELECT dept_code, dept_name FROM department");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        String deptCode = rs.getString("dept_code");
                        String selected = request.getParameter("dept_code") != null &&
                                          request.getParameter("dept_code").equals(deptCode) ? "selected" : "";
            %>
            <option value="<%= deptCode %>" <%= selected %>><%= rs.getString("dept_name") %></option>
            <%
                    }
                    con.close();
                } catch (Exception e) {
                    out.println("<option disabled>Error loading departments</option>");
                }
            %>
        </select>
        <button type="submit" class="btn btn-primary">Show Notices</button>
    </form>

    <ul class="list-group">
        <%
            String dept_code = request.getParameter("dept_code");
            String editId = request.getParameter("edit_id");

            if (dept_code != null && !dept_code.isEmpty()) {
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
                    String query = "SELECT n.id, n.title, n.description, n.created_at, d.dept_name " +
                                   "FROM notices n JOIN department d ON n.dept_code = d.dept_code " +
                                   "WHERE n.status = 0 AND n.dept_code = ? ORDER BY n.created_at DESC";
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setString(1, dept_code);
                    ResultSet rs = ps.executeQuery();
                    boolean found = false;

                    while (rs.next()) {
                        found = true;
                        int noticeId = rs.getInt("id");
                        String title = rs.getString("title");
                        String desc = rs.getString("description");
        %>
        <li class="list-group-item">
            <% if (editId != null && editId.equals(String.valueOf(noticeId))) { %>
                <form method="post">
                    <input type="hidden" name="update_id" value="<%= noticeId %>">
                    <input type="hidden" name="dept_code" value="<%= dept_code %>">
                    <input type="text" name="title" value="<%= title %>" class="form-control mb-2" required>
                    <textarea name="description" class="form-control mb-2" rows="3" required><%= desc %></textarea>
                    <button type="submit" class="btn btn-success btn-sm">Update</button>
                    <a href="view_a_notice.jsp?dept_code=<%= dept_code %>" class="btn btn-secondary btn-sm">Cancel</a>
                </form>
            <% } else { %>
                <h6><%= title %></h6>
                <p><%= desc %></p>
                <small class="text-muted">🏛️ Department: <%= rs.getString("dept_name") %></small><br>
                <small class="text-muted">🗓️ Posted on: <%= rs.getTimestamp("created_at") %></small>
                <div class="mt-2">
                    <a href="view_a_notice.jsp?dept_code=<%= dept_code %>&edit_id=<%= noticeId %>" class="btn btn-warning btn-sm mr-2">
                        <i class="bi bi-pencil-square"></i> Edit
                    </a>
                    <a href="view_a_notice.jsp?dept_code=<%= dept_code %>&delete_id=<%= noticeId %>"
                       onclick="return confirm('Are you sure you want to delete this notice?')"
                       class="btn btn-danger btn-sm">
                        <i class="bi bi-trash-fill"></i> Delete
                    </a>
                </div>
            <% } %>
        </li>
        <%
                    }
                    if (!found) {
                        out.println("<li class='list-group-item text-warning'>No notices available for this department.</li>");
                    }
                    con.close();
                } catch (Exception e) {
                    out.println("<li class='list-group-item text-danger'>Error fetching notices: " + e.getMessage() + "</li>");
                }
            } else {
                out.println("<li class='list-group-item text-info'>Please select a department to view notices.</li>");
            }
        %>
    </ul>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
