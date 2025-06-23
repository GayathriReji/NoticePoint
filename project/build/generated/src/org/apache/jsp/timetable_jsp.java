package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class timetable_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');

    String admin = (String) session.getAttribute("admin");
    if (admin == null) {
        response.sendRedirect("alogin.jsp");
        return;
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Add Timetable - College Notice Board</title>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\n");
      out.write("    <!-- Bootstrap & Icons -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css\">\n");
      out.write("\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            background: url('background.jpg') no-repeat center center fixed;\n");
      out.write("            background-size: cover;\n");
      out.write("        }\n");
      out.write("        .overlay {\n");
      out.write("            background: rgba(255, 255, 255, 0.95);\n");
      out.write("            min-height: 100vh;\n");
      out.write("        }\n");
      out.write("        .header {\n");
      out.write("            height: 56px;\n");
      out.write("            width: 100%;\n");
      out.write("            position: fixed;\n");
      out.write("            top: 0;\n");
      out.write("            left: 0;\n");
      out.write("            background: #1abc9c;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            color: white;\n");
      out.write("            z-index: 1000;\n");
      out.write("            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);\n");
      out.write("        }\n");
      out.write("        .header nav a {\n");
      out.write("            color: white;\n");
      out.write("            margin-right: 15px;\n");
      out.write("            text-decoration: none;\n");
      out.write("            font-weight: 500;\n");
      out.write("            transition: 0.3s;\n");
      out.write("        }\n");
      out.write("        .header nav a:hover {\n");
      out.write("            color: #f1c40f;\n");
      out.write("        }\n");
      out.write("        .sidebar {\n");
      out.write("            height: 100vh;\n");
      out.write("            width: 250px;\n");
      out.write("            position: fixed;\n");
      out.write("            top: 56px;\n");
      out.write("            left: 0;\n");
      out.write("            background: #2c3e50;\n");
      out.write("            padding-top: 20px;\n");
      out.write("            z-index: 999;\n");
      out.write("        }\n");
      out.write("        .sidebar a {\n");
      out.write("            padding: 12px 20px;\n");
      out.write("            text-decoration: none;\n");
      out.write("            font-size: 17px;\n");
      out.write("            color: #ecf0f1;\n");
      out.write("            display: block;\n");
      out.write("            transition: background 0.3s, padding-left 0.3s;\n");
      out.write("        }\n");
      out.write("        .sidebar a:hover {\n");
      out.write("            background: #34495e;\n");
      out.write("            color: #f1c40f;\n");
      out.write("            padding-left: 30px;\n");
      out.write("        }\n");
      out.write("        .main-content {\n");
      out.write("            margin-left: 270px;\n");
      out.write("            margin-top: 80px;\n");
      out.write("            background: rgba(255, 255, 255, 0.95);\n");
      out.write("            padding: 30px;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            min-height: 80vh;\n");
      out.write("            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<!-- Header -->\n");
      out.write("<div class=\"header d-flex justify-content-between align-items-center\">\n");
      out.write("    <div class=\"d-flex align-items-center\">\n");
      out.write("        <h5 class=\"mb-0\"><i class=\"bi bi-mortarboard-fill\"></i> &nbsp;College Notice Board - Admin</h5>\n");
      out.write("        <nav class=\"ml-4 d-flex align-items-center\">\n");
      out.write("            <a href=\"Adashboard.jsp\"><i class=\"bi bi-house-fill\"></i> Home</a>\n");
      out.write("        </nav>\n");
      out.write("    </div>\n");
      out.write("    <span><i class=\"bi bi-person-circle\"></i> Admin</span>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Sidebar -->\n");
      out.write("<div class=\"sidebar\">\n");
      out.write("    <a href=\"Adashboard.jsp\"><i class=\"bi bi-speedometer2\"></i> Dashboard</a>\n");
      out.write("    <a href=\"add_dept.jsp\"><i class=\"bi bi-building\"></i> Add Department</a>\n");
      out.write("    <a href=\"view_dept.jsp\"><i class=\"bi bi-building\"></i> View Department</a>\n");
      out.write("    <a href=\"addexam.jsp\"><i class=\"bi bi-megaphone-fill\"></i> Add Exam</a>\n");
      out.write("    <a href=\"addtimetable.jsp\"><i class=\"bi bi-calendar3\"></i> Add Timetable</a>\n");
      out.write("    <a href=\"alogout.jsp\"><i class=\"bi bi-box-arrow-right\"></i> Logout</a>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Main Content -->\n");
      out.write("<div class=\"main-content\">\n");
      out.write("    <h3 class=\"text-center mb-4\">📅 Add Exam Timetable</h3>\n");
      out.write("\n");
      out.write("    ");

        String success = request.getParameter("success");
        if ("true".equals(success)) {
    
      out.write("\n");
      out.write("        <div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\">\n");
      out.write("            ✅ Timetable added successfully!\n");
      out.write("            <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\n");
      out.write("                <span aria-hidden=\"true\">&times;</span>\n");
      out.write("            </button>\n");
      out.write("        </div>\n");
      out.write("    ");

        }
    
      out.write("\n");
      out.write("\n");
      out.write("    <form method=\"post\" action=\"addtimetable.jsp\">\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label>Department</label>\n");
      out.write("            <input type=\"text\" name=\"dept\" class=\"form-control\" required>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label>Exam Name</label>\n");
      out.write("            <input type=\"text\" name=\"exam\" class=\"form-control\" required>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label>Subject</label>\n");
      out.write("            <input type=\"text\" name=\"subject\" class=\"form-control\" required>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label>Date</label>\n");
      out.write("            <input type=\"date\" name=\"exam_date\" class=\"form-control\" required>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label>Time</label>\n");
      out.write("            <input type=\"text\" name=\"exam_time\" class=\"form-control\" placeholder=\"e.g. 9:30 AM - 12:30 PM\" required>\n");
      out.write("        </div>\n");
      out.write("        <button type=\"submit\" name=\"action\" value=\"add\" class=\"btn btn-success btn-block\">Add Timetable</button>\n");
      out.write("    </form>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Scripts -->\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<!-- Backend Logic -->\n");

    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String action = request.getParameter("action");
        if ("add".equals(action)) {
            String dept = request.getParameter("dept");
            String exam = request.getParameter("exam");
            String subject = request.getParameter("subject");
            String exam_date = request.getParameter("exam_date");
            String exam_time = request.getParameter("exam_time");

            Connection conn = null;
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
                String sql = "INSERT INTO timetable (department, exam, subject, exam_date, exam_time) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, dept);
                ps.setString(2, exam);
                ps.setString(3, subject);
                ps.setString(4, exam_date);
                ps.setString(5, exam_time);
                ps.executeUpdate();

                response.sendRedirect("addtimetable.jsp?success=true");
            } catch (Exception e) {
                out.println("<script>alert('Error: " + e.getMessage() + "');</script>");
                e.printStackTrace();
            } finally {
                if (conn != null) try { conn.close(); } catch (Exception e) { e.printStackTrace(); }
            }
        }
    }

      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
