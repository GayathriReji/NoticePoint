<%@ page import="java.sql.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%
    String admin = (String) session.getAttribute("admin");
    if (admin == null) {
        response.sendRedirect("alogin.jsp");
    }

    String deptCodeEdit = "";
    String deptNameEdit = "";
    boolean isEdit = false;

    if ("edit".equals(request.getParameter("action"))) {
        isEdit = true;
        deptCodeEdit = request.getParameter("code");
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
            String sql = "SELECT dept_name FROM department WHERE dept_code = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, deptCodeEdit);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                deptNameEdit = rs.getString("dept_name");
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Department - NoticePoint</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>
<div class="container mt-5">
    <h3 class="text-center mb-4">🏫 <%= isEdit ? "Edit" : "Add" %> Department</h3>
    <form method="post" action="add_dept.jsp">
        <div class="form-group">
            <label>Department Code</label>
            <input type="text" name="dept_code" class="form-control" value="<%= deptCodeEdit %>" <%= isEdit ? "readonly" : "" %> required>
        </div>
        <div class="form-group">
            <label>Department Name</label>
            <input type="text" name="dept_name" class="form-control" value="<%= deptNameEdit %>" required>
        </div>
        <button type="submit" name="action" value="<%= isEdit ? "update" : "add" %>" class="btn btn-<%= isEdit ? "primary" : "success" %> btn-block">
            <%= isEdit ? "Update Department" : "Add Department" %>
        </button>
    </form>

    <h5 class="mt-5 text-center font-weight-bold">📋 Existing Departments</h5>
    <table class="table table-striped mt-3">
        <thead class="thead-dark">
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
                Connection con = null;
                try {
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
                    String query = "SELECT dept_code, dept_name FROM department WHERE status = 0 ORDER BY dept_name ASC";
                    PreparedStatement ps = con.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        String code = rs.getString("dept_code");
                        String name = rs.getString("dept_name");
            %>
            <tr>
                <td><%= code %></td>
                <td><%= name %></td>
                <td>
                    <a href="add_dept.jsp?action=edit&code=<%= code %>" class="btn btn-sm btn-primary">Edit</a>
                    <a href="add_dept.jsp?action=delete&code=<%= code %>" class="btn btn-sm btn-danger"
                       onclick="return confirm('Are you sure you want to delete this department?');">Delete</a>
                </td>
            </tr>
            <%
                    }
                    rs.close();
                    ps.close();
                } catch (Exception e) {
                    out.println("<tr><td colspan='3' class='text-danger'>Error: " + e.getMessage() + "</td></tr>");
                    e.printStackTrace();
                } finally {
                    if (con != null) try { con.close(); } catch (Exception e) { e.printStackTrace(); }
                }
            %>
        </tbody>
    </table>
</div>

<%
    String action = request.getParameter("action");
    if (action != null) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");

            if ("add".equals(action)) {
                String code = request.getParameter("dept_code").trim();
                String name = request.getParameter("dept_name").trim();
                String sql = "INSERT INTO department (dept_code, dept_name, status) VALUES (?, ?, 0)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, code);
                ps.setString(2, name);
                ps.executeUpdate();
                response.sendRedirect("add_dept.jsp");

            } else if ("update".equals(action)) {
                String code = request.getParameter("dept_code").trim();
                String name = request.getParameter("dept_name").trim();
                String sql = "UPDATE department SET dept_name = ? WHERE dept_code = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, code);
                ps.executeUpdate();
                response.sendRedirect("add_dept.jsp");

            } else if ("delete".equals(action)) {
                String code = request.getParameter("code").trim();
                String sql = "UPDATE department SET status = 1 WHERE dept_code = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, code);
                ps.executeUpdate();
                response.sendRedirect("add_dept.jsp");
            }

        } catch (Exception e) {
            out.println("<script>alert('Error: " + e.getMessage() + "');</script>");
            e.printStackTrace();
        } finally {
            if (conn != null) try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
        }
    }
%>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
