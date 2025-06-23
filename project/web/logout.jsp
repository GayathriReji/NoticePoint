<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Invalidate the session to log out the user
    if (session != null) {
        session.invalidate();
    }
    // Redirect to login page
    response.sendRedirect("Index.jsp");
%>
