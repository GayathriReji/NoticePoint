package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class notices_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Database.ConnectionClass con = null;
      synchronized (_jspx_page_context) {
        con = (Database.ConnectionClass) _jspx_page_context.getAttribute("con", PageContext.PAGE_SCOPE);
        if (con == null){
          con = new Database.ConnectionClass();
          _jspx_page_context.setAttribute("con", con, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      out.write('\n');

    if (request.getParameter("btnsubmit") != null) {
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        String insertQuery = "INSERT INTO notices (title, description) VALUES (?, ?)";
        try {
            Connection connection = con.getConnection();
            PreparedStatement ps = connection.prepareStatement(insertQuery);
            ps.setString(1, title);
            ps.setString(2, description);

            int result = ps.executeUpdate();
            if (result > 0) {

      out.write("\n");
      out.write("                <script>\n");
      out.write("                    alert(\"Notice added successfully!\");\n");
      out.write("                    window.location = \"admin_dashboard.jsp\";\n");
      out.write("                </script>\n");

            } else {
                out.println("<p class='text-danger text-center'>Failed to add notice!</p>");
            }
            ps.close();
        } catch (Exception e) {
            out.println("<p class='text-danger text-center'>Database error: " + e.getMessage() + "</p>");
        }
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Add Notice</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("</head>\n");
      out.write("<body class=\"bg-light\">\n");
      out.write("    <div class=\"container mt-5\">\n");
      out.write("        <div class=\"row justify-content-center\">\n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("                <div class=\"card p-4 shadow\" style=\"border-radius: 10px;\">\n");
      out.write("                    <h3 class=\"text-center\">Add Notice</h3>\n");
      out.write("                    <form method=\"post\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Title</label>\n");
      out.write("                            <input type=\"text\" name=\"title\" class=\"form-control\" placeholder=\"Enter notice title\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label>Description</label>\n");
      out.write("                            <textarea name=\"description\" class=\"form-control\" placeholder=\"Enter notice description\" required></textarea>\n");
      out.write("                        </div>\n");
      out.write("                        <button type=\"submit\" name=\"btnsubmit\" class=\"btn btn-primary btn-block\">Submit Notice</button>\n");
      out.write("                        <a href=\"admin_dashboard.jsp\" class=\"btn btn-secondary btn-block\">Back to Dashboard</a>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
