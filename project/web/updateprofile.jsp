<%@page import="java.sql.*"%>
<%@page import="javax.servlet.http.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="Database.ConnectionClass" id="con"></jsp:useBean>

<%
    String admissionNo = request.getParameter("admission_no");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String deptCode = request.getParameter("dept_code");
    String yearOfStudy = request.getParameter("year_of_study");

    Connection connection = con.getConnection();
    
    try {
        String updateQuery = "UPDATE stureg SET name=?, email=?, dept_code=?, year_of_study=? WHERE admission_no=?";
        PreparedStatement ps = connection.prepareStatement(updateQuery);
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setInt(3, Integer.parseInt(deptCode));
        ps.setInt(4, Integer.parseInt(yearOfStudy));
        ps.setString(5, admissionNo);
        
        int rowsUpdated = ps.executeUpdate();
        
        if (rowsUpdated > 0) {
            response.sendRedirect("myprofile.jsp?success=1");
        } else {
            response.sendRedirect("editprofile.jsp?error=1");
        }
    } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("editprofile.jsp?error=1");
    }
%>
