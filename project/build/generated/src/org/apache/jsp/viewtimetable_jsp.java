package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class viewtimetable_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>View Timetable - College Notice Board</title>\n");
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
      out.write("        table {\n");
      out.write("            background-color: white;\n");
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
      out.write("    <a href=\"viewtimetable.jsp\"><i class=\"bi bi-table\"></i> View Timetable</a>\n");
      out.write("    <a href=\"alogout.jsp\"><i class=\"bi bi-box-arrow-right\"></i> Logout</a>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Main Content -->\n");
      out.write("<div class=\"main-content\">\n");
      out.write("    <h3 class=\"text-center mb-4\">📄 Exam Timetable</h3>\n");
      out.write("\n");
      out.write("    <div class=\"table-responsive\">\n");
      out.write("        <table class=\"table table-bordered table-hover\">\n");
      out.write("            <thead class=\"thead-dark\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>#</th>\n");
      out.write("                    <th>Department</th>\n");
      out.write("                    <th>Exam</th>\n");
      out.write("                    <th>Subject</th>\n");
      out.write("                    <th>Date</th>\n");
      out.write("                    <th>Time</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");

                    int count = 0;
                    try {
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM timetable ORDER BY exam_date");

                        while (rs.next()) {
                            count++;
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( count );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getString("dept_code") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getString("exam") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getString("subject") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getString("exam_date") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getString("exam_time") );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                        }
                        conn.close();
                    } catch (Exception e) {
                        out.println("<tr><td colspan='6'>Error: " + e.getMessage() + "</td></tr>");
                        e.printStackTrace();
                    }
                
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Scripts -->\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
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
