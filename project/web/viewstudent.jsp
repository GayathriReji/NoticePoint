<%@ page import="java.sql.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%
    String admin = (String) session.getAttribute("admin");
    if (admin == null) {
        response.sendRedirect("alogin.jsp");
    }

    // Handle deactivation
    if ("POST".equalsIgnoreCase(request.getMethod()) && "deactivate".equals(request.getParameter("action"))) {
        int stu_id = Integer.parseInt(request.getParameter("stu_id"));
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
            PreparedStatement ps = con.prepareStatement("UPDATE stureg SET status = 1 WHERE stu_id = ?");
            ps.setInt(1, stu_id);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            out.println("<script>alert('Error: " + e.getMessage() + "');</script>");
        }
        response.sendRedirect("viewstudent.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>View Students - NoticePoint</title>
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
        .content {
            margin-left: 270px;
            padding: 30px;
            padding-top: 90px;
            background: rgba(255,255,255,0.95);
            min-height: 100vh;
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
                <button class="btn btn-sm text-light dropdown-toggle bg-transparent border-0" type="button" data-toggle="dropdown">
                    <i class="bi bi-megaphone-fill"></i> Manage Notices
                </button>
                <div class="dropdown-menu bg-white shadow-sm rounded">
                    <a class="dropdown-item text-dark" href="notices.jsp"><i class="bi bi-plus-circle-fill"></i> Add Notices</a>
                    <a class="dropdown-item text-dark" href="view_a_notice.jsp"><i class="bi bi-eye-fill"></i> View Notices</a>
                </div>
            </div>
            <div class="btn-group ml-3">
                <button class="btn btn-sm text-light dropdown-toggle bg-transparent border-0" type="button" data-toggle="dropdown">
                    <i class="bi bi-person-plus-fill"></i> Manage Students
                </button>
                <div class="dropdown-menu bg-white shadow-sm rounded">
                    <a class="dropdown-item text-dark" href="students.jsp"><i class="bi bi-plus-circle-fill"></i> Add Students</a>
                    <a class="dropdown-item text-dark" href="viewstudent.jsp"><i class="bi bi-eye-fill"></i> View Students</a>
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
<div class="content">
    <h3 class="text-center mb-4"><i class="bi bi-people-fill"></i> Active Students</h3>
    <ul class="list-group">
        <%
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
                String query = "SELECT s.stu_id, s.name, s.email, s.address, d.dept_name, s.year_of_study, s.admission_no FROM stureg s JOIN department d ON s.dept_code = d.dept_code WHERE s.status = 0 ORDER BY s.name ASC";
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
        %>
        <li class="list-group-item">
            <h6><%= rs.getString("name") %> (<%= rs.getString("admission_no") %>)</h6>
            <p>Email: <%= rs.getString("email") %> | Address: <%= rs.getString("address") %> | Department: <%= rs.getString("dept_name") %> | Year: <%= rs.getInt("year_of_study") %></p>

            <!-- Edit Button -->
            <button class="btn btn-primary btn-sm edit-btn" data-toggle="modal" data-target="#editStudentModal"
                data-id="<%= rs.getInt("stu_id") %>"
                data-name="<%= rs.getString("name") %>"
                data-email="<%= rs.getString("email") %>"
                data-address="<%= rs.getString("address") %>"
                data-admission="<%= rs.getString("admission_no") %>"
                data-year="<%= rs.getInt("year_of_study") %>">✏️ Edit</button>

            <!-- Deactivate Button -->
            <form method="post" class="d-inline" onsubmit="return confirm('Are you sure you want to deactivate this student?');">
                <input type="hidden" name="stu_id" value="<%= rs.getInt("stu_id") %>">
                <button type="submit" name="action" value="deactivate" class="btn btn-danger btn-sm">Deactivate</button>
            </form>
        </li>
        <% 
                }
                con.close();
            } catch (Exception e) {
                out.println("<li class='list-group-item text-danger'>Error fetching students: " + e.getMessage() + "</li>");
            }
        %>
    </ul>
</div>

<!-- Edit Modal -->
<div class="modal fade" id="editStudentModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <form method="post" action="updatestudents.jsp" class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Edit Student</h5>
                <button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
            </div>
            <div class="modal-body">
                <input type="hidden" name="stu_id" id="editStuId">
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" name="name" id="editName" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input type="email" name="email" id="editEmail" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Address</label>
                    <input type="text" name="address" id="editAddress" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Admission No</label>
                    <input type="text" name="admission_no" id="editAdmissionNo" class="form-control" required>
                </div>
                <div class="form-group">
                    <label>Year of Study</label>
                    <input type="number" name="year_of_study" id="editYear" class="form-control" required>
                </div>
            </div>
            <div class="modal-footer">
                <button type="submit" name="action" value="update" class="btn btn-success">💾 Save Changes</button>
            </div>
        </form>
    </div>
</div>

<script>
    $(document).on("click", ".edit-btn", function () {
        $("#editStuId").val($(this).data("id"));
        $("#editName").val($(this).data("name"));
        $("#editEmail").val($(this).data("email"));
        $("#editAddress").val($(this).data("address"));
        $("#editAdmissionNo").val($(this).data("admission"));
        $("#editYear").val($(this).data("year"));
    });
</script>

</body>
</html>
