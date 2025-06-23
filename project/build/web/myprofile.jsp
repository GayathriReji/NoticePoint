<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="Database.ConnectionClass" id="con"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
    <title>My Profile - College Notice Board</title>

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

        .profile-card {
            background: #fff;
            border-radius: 15px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.1);
            padding: 30px;
            margin-top: 50px;
            transition: transform 0.3s;
        }

        .profile-card:hover {
            transform: translateY(-5px);
        }

        .profile-heading {
            font-weight: 600;
            margin-bottom: 25px;
            color: #333;
        }

        .profile-label {
            font-weight: 500;
            color: #555;
        }

        .btn-primary {
            background-color: #4e73df;
            border-color: #4e73df;
        }

        .alert-success {
            margin-top: 20px;
        }

        .footer {
            text-align: center;
            padding: 15px;
            font-size: 14px;
            color: white;
        }
    </style>
</head>
<body>

    <!-- Navigation -->
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

    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="profile-card">
                    <h4 class="text-center profile-heading"><i class="fas fa-user-circle"></i> My Profile</h4>

                    <%
                        String success = request.getParameter("success");
                        if ("1".equals(success)) {
                    %>
                        <div class="alert alert-success text-center" role="alert">
                            Profile updated successfully!
                        </div>
                    <% }

                        String admissionNo = (String) session.getAttribute("user");
                        if (admissionNo == null) {
                            response.sendRedirect("Login.jsp");
                            return;
                        }

                        Connection connection = con.getConnection();
                        String query = "SELECT s.name, s.admission_no, s.email, d.dept_name, s.year_of_study " +
                                       "FROM stureg s JOIN department d ON s.dept_code = d.dept_code WHERE s.admission_no = ?";
                        PreparedStatement ps = connection.prepareStatement(query);
                        ps.setString(1, admissionNo);
                        ResultSet rs = ps.executeQuery();

                        if (rs.next()) {
                    %>
                        <p><span class="profile-label">Name:</span> <%= rs.getString("name") %></p>
                        <p><span class="profile-label">Admission No:</span> <%= rs.getString("admission_no") %></p>
                        <p><span class="profile-label">Email:</span> <%= rs.getString("email") %></p>
                        <p><span class="profile-label">Department:</span> <%= rs.getString("dept_name") %></p>
                        <p><span class="profile-label">Year of Study:</span> <%= rs.getString("year_of_study") %></p>

                        <div class="text-center mt-4">
                            <a href="editprofile.jsp" class="btn btn-primary"><i class="fas fa-edit"></i> Edit Profile</a>
                        </div>
                    <% } %>
                </div>
            </div>
        </div>
    </div>

    <!-- Footer -->
    

    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>

</body>
</html>
