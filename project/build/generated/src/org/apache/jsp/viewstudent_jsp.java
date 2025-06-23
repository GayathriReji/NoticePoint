package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class viewstudent_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>View Students - College Notice Board</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            background: url('background.jpg') no-repeat center center fixed;\n");
      out.write("            background-size: cover;\n");
      out.write("        }\n");
      out.write("        .sidebar {\n");
      out.write("            height: 100vh;\n");
      out.write("            width: 250px;\n");
      out.write("            position: fixed;\n");
      out.write("            top: 0;\n");
      out.write("            left: 0;\n");
      out.write("            background: #343a40;\n");
      out.write("            padding-top: 20px;\n");
      out.write("        }\n");
      out.write("        .sidebar a {\n");
      out.write("            padding: 10px;\n");
      out.write("            text-decoration: none;\n");
      out.write("            font-size: 18px;\n");
      out.write("            color: white;\n");
      out.write("            display: block;\n");
      out.write("        }\n");
      out.write("        .sidebar a:hover {\n");
      out.write("            background: #495057;\n");
      out.write("        }\n");
      out.write("        .dashboard-container {\n");
      out.write("            margin-left: 270px;\n");
      out.write("            background: rgba(255, 255, 255, 0.9);\n");
      out.write("            padding: 30px;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);\n");
      out.write("            margin-top: 50px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"sidebar\">\n");
      out.write("        <a href=\"Adashboard.jsp\">🏠 Dashboard</a>\n");
      out.write("        <a href=\"add_dept.jsp\">🏛️ Add Department</a>\n");
      out.write("        <a href=\"notices.jsp\">📢 Manage Notices</a>\n");
      out.write("        <a href=\"students.jsp\">🎓 Manage Students</a>\n");
      out.write("        <a href=\"alogout.jsp\">🚪 Logout</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"dashboard-container\">\n");
      out.write("        <h3 class=\"text-center\">🎓 Active Students</h3>\n");
      out.write("        <ul class=\"list-group\">\n");
      out.write("            ");
 
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
                    String query = "SELECT s.stu_id, s.name, s.email, d.dept_name, s.year_of_study, s.admission_no FROM stureg s JOIN department d ON s.dept_code = d.dept_code WHERE s.status = 0 ORDER BY s.name ASC";
                    PreparedStatement ps = con.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
            
      out.write("\n");
      out.write("            <li class=\"list-group-item\">\n");
      out.write("                <h6>");
      out.print( rs.getString("name") );
      out.write(' ');
      out.write('(');
      out.print( rs.getString("admission_no") );
      out.write(")</h6>\n");
      out.write("                <p>Email: ");
      out.print( rs.getString("email") );
      out.write(" | Department: ");
      out.print( rs.getString("dept_name") );
      out.write(" | Year: ");
      out.print( rs.getInt("year_of_study") );
      out.write("</p>\n");
      out.write("                <form method=\"post\" action=\"deactivateStudent.jsp\" class=\"d-inline\">\n");
      out.write("                    <input type=\"hidden\" name=\"stu_id\" value=\"");
      out.print( rs.getInt("stu_id") );
      out.write("\">\n");
      out.write("                    <button type=\"submit\" name=\"action\" value=\"deactivate\" class=\"btn btn-danger btn-sm btn-action\">Deactivate</button>\n");
      out.write("                </form>\n");
      out.write("            </li>\n");
      out.write("            ");
 
                    }
                    con.close();
                } catch (Exception e) {
                    out.println("<li class='list-group-item text-danger'>Error fetching students: " + e.getMessage() + "</li>");
                }
            
      out.write("\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
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
