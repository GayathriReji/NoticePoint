<%@ page import="java.sql.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<% String admin = (String) session.getAttribute("admin");
           if (admin == null) {
               response.sendRedirect("alogin.jsp");
           } %>

<!DOCTYPE html>
<html>

    <head>
        <title>Admin Dashboard - Notice Point</title>
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

            .dashboard-container {
                margin-left: 270px;
                margin-top: 80px;
                background: rgba(255, 255, 255, 0.95);
                padding: 30px;
                border-radius: 10px;
                min-height: 80vh;
                box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
            }

            .card {
                border: none;
                border-radius: 10px;
                transition: all 0.3s ease;
                height: 100%;
                display: flex;
                flex-direction: column;
                justify-content: space-between;
            }

            .card:hover {
                transform: scale(1.02);
                box-shadow: 0 10px 20px rgba(0, 0, 0, 0.15);
            }

            .card-body {
                flex-grow: 1;
            }

            .row.equal-height {
                display: flex;
                flex-wrap: wrap;
            }

            .row.equal-height>div {
                display: flex;
                flex-direction: column;
            }

            h3,
            h5 {}

            .dropdown-menu a:hover {
                background-color: #f1f1f1;
                color: #1abc9c !important;
            }
        </style>
    </head>

    <body>

        <!-- Header -->
        <!-- Header -->
        <div class="header d-flex justify-content-between align-items-center">
            <div class="d-flex align-items-center">
                <h5 class="mb-0"><i class="bi bi-mortarboard-fill"></i> &nbsp;NoticePoint - Admin</h5>
                <nav class="ml-4 d-flex align-items-center">
                    <a href="Adashboard.jsp"><i class="bi bi-house-fill"></i> Home</a>

                    <!-- Manage Notices -->
                    <div class="btn-group ml-3">
                        <button class="btn btn-sm text-light dropdown-toggle bg-transparent border-0"
                                type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="bi bi-megaphone-fill"></i> Manage Notices
                        </button>
                        <div class="dropdown-menu bg-white shadow-sm rounded">
                            <a class="dropdown-item text-dark" href="notices.jsp"><i
                                    class="bi bi-plus-circle-fill"></i> Add Notices</a>
                            <a class="dropdown-item text-dark" href="view_a_notice.jsp"><i
                                    class="bi bi-eye-fill"></i> View Notices</a>
                        </div>
                    </div>

                    <!-- Manage Students -->
                    <div class="btn-group ml-3">
                        <button class="btn btn-sm text-light dropdown-toggle bg-transparent border-0"
                                type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="bi bi-person-plus-fill"></i> Manage Students
                        </button>
                        <div class="dropdown-menu bg-white shadow-sm rounded">
                            <a class="dropdown-item text-dark" href="students.jsp"><i
                                    class="bi bi-plus-circle-fill"></i> Add Students</a>
                            <a class="dropdown-item text-dark" href="viewstudent.jsp"><i
                                    class="bi bi-eye-fill"></i> View Students</a>
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
           <!-- <a href="timetable.jsp"><i class="bi bi-person-plus-fill"></i> Add Timetable</a>
            <a href="viewstudent.jsp"><i class="bi bi-people-fill"></i> View Students</a>-->
            <a href="alogout.jsp"><i class="bi bi-box-arrow-right"></i> Logout</a>
        </div>

        <!-- Main Dashboard Content -->
        <div class="dashboard-container">
            <h3 class="text-center mb-4"><i class="bi bi-grid-1x2-fill"></i> Welcome to the Admin Dashboard</h3>
            <p>This is your central hub for managing departments, notices, and students. Use the sidebar to
                navigate.</p>

            <!-- Notice Panels with Equal Height -->
            <div class="row equal-height mt-4">
                <% Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
                    String query = "SELECT title, description FROM notices WHERE status=0 ORDER BY created_at DESC LIMIT 4";
                    PreparedStatement ps = con.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();
                            while (rs.next()) {%>
                <div class="col-md-6 mb-4 d-flex">
                    <div class="card shadow-sm w-100">
                        <div class="card-body">
                            <h5 class="card-title text-primary">
                                <%= rs.getString("title")%>
                            </h5>
                            <p class="card-text text-muted">
                                <%= rs.getString("description")%>
                            </p>
                        </div>
                    </div>
                </div>
                <% }
                                con.close();%>
            </div>
        </div>

        <!-- JS for Bootstrap dropdowns -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
    </body>

</html>