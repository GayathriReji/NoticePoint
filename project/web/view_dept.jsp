<%@ page import="java.sql.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%
    String admin = (String) session.getAttribute("admin");
    if (admin == null) {
        response.sendRedirect("alogin.jsp");
    }

    // Delete
    String deleteCode = request.getParameter("delete_dept_code");
    if (deleteCode != null && !deleteCode.trim().equals("")) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
            PreparedStatement ps = con.prepareStatement("UPDATE department SET status = 1 WHERE dept_code = ?");
            ps.setString(1, deleteCode);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            out.println("<script>alert('Error deleting department: " + e.getMessage() + "');</script>");
        }
    }

    // Edit
    String editCode = request.getParameter("edit_dept_code");
    String editName = request.getParameter("edit_dept_name");
    if (editCode != null && editName != null && !editCode.trim().equals("") && !editName.trim().equals("")) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
            PreparedStatement ps = con.prepareStatement("UPDATE department SET dept_name = ? WHERE dept_code = ?");
            ps.setString(1, editName);
            ps.setString(2, editCode);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            out.println("<script>alert('Error updating department: " + e.getMessage() + "');</script>");
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>View Departments - NoticePoint</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
        }
        .header nav a {
            color: white;
            margin-right: 15px;
            text-decoration: none;
            font-weight: 500;
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
        }
        .sidebar a {
            padding: 12px 20px;
            text-decoration: none;
            font-size: 17px;
            color: #ecf0f1;
            display: block;
        }
        .sidebar a:hover {
            background: #34495e;
            color: #f1c40f;
            padding-left: 30px;
        }
        .content {
            margin-left: 270px;
            padding: 30px;
            padding-top: 90px;
            background: rgba(255,255,255,0.95);
            min-height: 100vh;
        }
        .card-deck .card {
            border-left: 5px solid #1abc9c;
            transition: 0.3s;
        }
        .card-deck .card:hover {
            background-color: #eefaf7;
            transform: scale(1.02);
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
    <a href="view_dept.jsp"><i class="bi bi-eye-fill"></i> View Department</a>
    <a href="addexam.jsp"><i class="bi bi-megaphone-fill"></i> Add Exam</a>
    <a href="view_a_exam.jsp"><i class="bi bi-files"></i> View Exam</a>
    <a href="alogout.jsp"><i class="bi bi-box-arrow-right"></i> Logout</a>
</div>

<!-- Content -->
<div class="content">
    <h3 class="text-center mb-4"><i class="bi bi-building"></i> Department List</h3>

    <div class="row">
        <%
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM department WHERE status = 0 ORDER BY dept_name ASC");

                while (rs.next()) {
        %>
        <div class="col-md-6 mb-4">
            <div class="card shadow-sm">
                <div class="card-body">
                    <h5 class="card-title"><%= rs.getString("dept_name") %></h5>
                    <p class="card-text"><strong>Code:</strong> <%= rs.getString("dept_code") %></p>
                    <div class="d-flex justify-content-end">
                        <!-- Edit Button -->
                        <button class="btn btn-sm btn-warning mr-2 edit-btn"
                            data-toggle="modal"
                            data-target="#editDeptModal"
                            data-code="<%= rs.getString("dept_code") %>"
                            data-name="<%= rs.getString("dept_name") %>">
                            <i class="bi bi-pencil-fill"></i> Edit
                        </button>

                        <!-- Delete Button -->
                        <form method="post" action="view_dept.jsp" class="d-inline">
                            <input type="hidden" name="delete_dept_code" value="<%= rs.getString("dept_code") %>">
                            <button type="submit" class="btn btn-sm btn-danger"
                                    onclick="return confirm('Are you sure to delete this department?');">
                                <i class="bi bi-trash-fill"></i> Delete
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <%
                }
                con.close();
            } catch (Exception e) {
        %>
        <div class="col-12 text-danger">❌ Error: <%= e.getMessage() %></div>
        <% } %>
    </div>
</div>

<!-- Edit Modal -->
<div class="modal fade" id="editDeptModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <form method="post" action="view_dept.jsp" class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Edit Department</h5>
                <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
            </div>
            <div class="modal-body">
                <input type="hidden" name="edit_dept_code" id="editDeptCode">
                <div class="form-group">
                    <label>Department Name</label>
                    <input type="text" name="edit_dept_name" id="editDeptName" class="form-control" required>
                </div>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-success">💾 Save Changes</button>
            </div>
        </form>
    </div>
</div>

<!-- Fill Modal with Existing Values -->
<script>
    $(document).on("click", ".edit-btn", function () {
        $("#editDeptCode").val($(this).data("code"));
        $("#editDeptName").val($(this).data("name"));
    });
</script>

</body>
</html>
