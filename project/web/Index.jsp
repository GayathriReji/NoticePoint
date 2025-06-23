<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>College Notice Board</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
    <style>
       body {
    background: url('images/college.webp') no-repeat center center fixed;
    background-size: cover;
    color: black;
}

        .overlay {
            background: rgba(255, 255, 255, 0.8);
            min-height: 100vh;
            padding: 20px;
        }
        .card {
            border-radius: 15px;
            transition: 0.3s;
        }
        .card:hover {
            transform: scale(1.03);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        .notice-list li {
            background: rgba(255, 255, 255, 0.9);
            border: none;
            color: black;
        }
    </style>
</head>
<body>
    <div class="overlay">
        <div class="container mt-5">
            <div class="text-center mb-4">
                <h1 class="display-4">📢 College Notice Board</h1>
                <p class="lead">Stay updated with the latest news and announcements.</p>
            </div>
            
            <!-- Notices Section -->
            <div class="card shadow-lg bg-light text-dark mb-4">
                <div class="card-header bg-primary text-white text-center">
                    <h4>Latest Notices</h4>
                </div>
                <div class="card-body">
                    <ul class="list-group list-group-flush notice-list">
                        <li class="list-group-item">📅 Exam schedule announced for Semester 2 <span class="badge badge-dark float-right">March 30, 2025</span></li>
                        <li class="list-group-item">🏆 Annual Sports Meet Registration Open <span class="badge badge-dark float-right">March 28, 2025</span></li>
                        <li class="list-group-item">📢 Holiday declared on April 1st <span class="badge badge-dark float-right">March 25, 2025</span></li>
                        <li class="list-group-item">🧠 Workshop on AI & ML <span class="badge badge-dark float-right">March 20, 2025</span></li>
                    </ul>
                </div>
            </div>
            
            <!-- Login Section -->
            <div class="row">
                <div class="col-md-6">
                    <div class="card shadow-lg text-center bg-light text-dark">
                        <div class="card-body">
                            <h5 class="card-title">👨‍🎓 Student Login</h5>
                            <p class="card-text">Access notices and updates.</p>
                            <a href="Login.jsp" class="btn btn-primary btn-lg">Login</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card shadow-lg text-center bg-light text-dark">
                        <div class="card-body">
                            <h5 class="card-title">🛠️ Admin Login</h5>
                            <p class="card-text">Manage notices and announcements.</p>
                            <a href="ALogin.jsp" class="btn btn-dark btn-lg">Login</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
