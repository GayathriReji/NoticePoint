package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class view_005fa_005fexam_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    String action = request.getParameter("action");
    String idParam = request.getParameter("id");

    // Handle delete
    if ("delete".equals(action) && idParam != null) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "")) {
            PreparedStatement psDel = conn.prepareStatement("DELETE FROM exam WHERE id = ?");
            psDel.setInt(1, Integer.parseInt(idParam));
            psDel.executeUpdate();
            response.sendRedirect("view_exam.jsp");
        } catch (Exception e) {
            out.println("<script>alert('Error deleting exam: " + e.getMessage() + "');</script>");
        }
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>View Exams - Admin</title>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
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
      out.write("        .header h5 {\n");
      out.write("            margin: 0;\n");
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
      out.write("            padding: 30px;\n");
      out.write("            background: rgba(255, 255, 255, 0.95);\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);\n");
      out.write("        }\n");
      out.write("        .table thead {\n");
      out.write("            background-color: #1abc9c;\n");
      out.write("            color: white;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
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
      out.write("    <a href=\"addexam.jsp\"><i class=\"bi bi-plus-circle\"></i> Add Exam</a>\n");
      out.write("    <a href=\"alogout.jsp\"><i class=\"bi bi-box-arrow-right\"></i> Logout</a>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Main Content -->\n");
      out.write("<div class=\"main-content\">\n");
      out.write("    <h3 class=\"text-center mb-4\">📋 Exam List</h3>\n");
      out.write("\n");
      out.write("    <div class=\"table-responsive\">\n");
      out.write("        <table class=\"table table-bordered\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Title</th>\n");
      out.write("                    <th>Department</th>\n");
      out.write("                    <th>Date</th>\n");
      out.write("                    <th>Time</th>\n");
      out.write("                    <th>Venue</th>\n");
      out.write("                    <th>Timetable</th>\n");
      out.write("                    <th>Actions</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("            ");

                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "")) {
                    String sql = "SELECT e.*, d.dept_name FROM exam e JOIN department d ON e.dept_code = d.dept_code ORDER BY e.date DESC";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
            
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( rs.getString("title") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getString("dept_name") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getDate("date") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getString("time") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getString("venue") );
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
 if (rs.getString("timetable_file") != null && !rs.getString("timetable_file").isEmpty()) { 
      out.write("\n");
      out.write("                        <a href=\"");
      out.print( rs.getString("timetable_file") );
      out.write("\" target=\"_blank\">View</a>\n");
      out.write("                        ");
 } else { 
      out.write(" - ");
 } 
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <a href=\"addexam.jsp?action=edit&id=");
      out.print( rs.getInt("id") );
      out.write("\" class=\"btn btn-sm btn-primary\">Edit</a>\n");
      out.write("                        <a href=\"view_exam.jsp?action=delete&id=");
      out.print( rs.getInt("id") );
      out.write("\" onclick=\"return confirm('Are you sure you want to delete this exam?');\" class=\"btn btn-sm btn-danger\">Delete</a>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            ");

                    }
                    rs.close();
                    ps.close();
                } catch (Exception e) {
                    out.println("<tr><td colspan='7' class='text-danger'>Error: " + e.getMessage() + "</td></tr>");
                }
            
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
