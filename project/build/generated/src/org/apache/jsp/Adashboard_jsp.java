package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class Adashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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
        response.sendRedirect("Adashboard.jsp");
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Admin Dashboard - College Notice Board</title>\n");
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
      out.write("    <!-- Sidebar -->\n");
      out.write("  <div class=\"sidebar\">\n");
      out.write("    <a href=\"Adashboard.jsp\">🏠 Dashboard</a>\n");
      out.write("    <a href=\"add_dept.jsp\">🏛️ Add Department</a>\n");
      out.write("    <a href=\"notices.jsp\">📢 Manage Notices</a>\n");
      out.write("    <a href=\"students.jsp\">🎓 Manage Students</a>\n");
      out.write("    <a href=\"alogout.jsp\">🚪 Logout</a>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("    \n");
      out.write("    <div class=\"container d-flex justify-content-center\">\n");
      out.write("        <div class=\"col-md-8 dashboard-container\">\n");
      out.write("            <h3 class=\"text-center\">Admin Dashboard</h3>\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");
 
                if (request.getParameter("title") != null) {
                    String title = request.getParameter("title");
                    String description = request.getParameter("description");

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
                    String query = "INSERT INTO notices (title, description) VALUES (?, ?)";
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setString(1, title);
                    ps.setString(2, description);
                    ps.executeUpdate();
                    con.close();
            
      out.write("\n");
      out.write("                <script>\n");
      out.write("                    alert(\"Notice Posted Successfully!\");\n");
      out.write("                    window.location.href = \"Adashboard.jsp\";\n");
      out.write("                </script>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("            <h5 class=\"mt-4 text-center font-weight-bold\">📜 Existing Notices</h5>\n");
      out.write("<div class=\"row\">\n");
      out.write("    ");

        Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
        String query2 = "SELECT title, description FROM notices ORDER BY created_at DESC";
        PreparedStatement ps2 = con2.prepareStatement(query2);
        ResultSet rs2 = ps2.executeQuery();
        while (rs2.next()) {
    
      out.write("\n");
      out.write("    <div class=\"col-md-6\">\n");
      out.write("        <div class=\"card shadow-sm mb-3\">\n");
      out.write("            <div class=\"card-body\">\n");
      out.write("                <h6 class=\"card-title font-weight-bold text-primary\">");
      out.print( rs2.getString("title") );
      out.write("</h6>\n");
      out.write("                <p class=\"card-text text-muted\">");
      out.print( rs2.getString("description") );
      out.write("</p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    ");
 } con2.close(); 
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>");
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
