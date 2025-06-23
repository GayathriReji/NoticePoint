<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.*"%>
<%@page import="javax.servlet.*"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Student - NoticePoint</title>
</head>
<body>
    <%
        if ("update".equals(request.getParameter("action"))) {
            int stuId = Integer.parseInt(request.getParameter("stu_id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String admissionNo = request.getParameter("admission_no");
            int year = Integer.parseInt(request.getParameter("year_of_study"));

            try {
                // Update student details in the database
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
                String query = "UPDATE stureg SET name=?, email=?, address=?, admission_no=?, year_of_study=? WHERE stu_id=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, address);
                ps.setString(4, admissionNo);
                ps.setInt(5, year);
                ps.setInt(6, stuId);
                int rowsUpdated = ps.executeUpdate();
                
                if (rowsUpdated > 0) {
                    out.println("<script>alert('Student updated successfully!'); window.location='viewstudent.jsp';</script>");
                } else {
                    out.println("<script>alert('Update failed!'); window.location='viewstudent.jsp';</script>");
                }
                con.close();
            } catch (SQLException e) {
                out.println("<script>alert('Error: " + e.getMessage() + "'); window.location='viewstudent.jsp';</script>");
            }
        }
    %>
</body>
</html>
