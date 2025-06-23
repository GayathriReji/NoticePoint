package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public final class viewnotice_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
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

    if (session.getAttribute("id") == null) {
        response.sendRedirect("viewnotice.jsp"); // Redirect if not logged in
        return;
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Department Notices</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css\">\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            background: url('background.jpg') no-repeat center center fixed;\n");
      out.write("            background-size: cover;\n");
      out.write("        }\n");
      out.write("        .navbar {\n");
      out.write("            background-color: #343a40;\n");
      out.write("        }\n");
      out.write("        .navbar-brand, .navbar-nav .nav-link {\n");
      out.write("            color: white !important;\n");
      out.write("        }\n");
      out.write("        .notice-container {\n");
      out.write("            background: rgba(255, 255, 255, 0.9);\n");
      out.write("            padding: 30px;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);\n");
      out.write("            margin-top: 50px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-dark\">\n");
      out.write("        <a class=\"navbar-brand\" href=\"#\"><i class=\"fas fa-graduation-cap\"></i> College Notice Board</a>\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n");
      out.write("            <ul class=\"navbar-nav ml-auto\">\n");
      out.write("                <li class=\"nav-item\"><a class=\"nav-link\" href=\"Sdashboard.jsp\"><i class=\"fas fa-home\"></i> Home</a></li>\n");
      out.write("                <li class=\"nav-item\"><a class=\"nav-link\" href=\"viewnotice.jsp\"><i class=\"fas fa-bullhorn\"></i> Notices</a></li>\n");
      out.write("                <li class=\"nav-item\"><a class=\"nav-link\" href=\"myprofile.jsp\"><i class=\"fas fa-user\"></i> My Profile</a></li>\n");
      out.write("                <li class=\"nav-item\"><a class=\"nav-link\" href=\"logout.jsp\"><i class=\"fas fa-sign-out-alt\"></i> Logout</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("    \n");
      out.write("    <div class=\"container d-flex justify-content-center\">\n");
      out.write("        <div class=\"col-md-8 notice-container\">\n");
      out.write("            <h3 class=\"text-center mb-4\">Department Notices</h3>\n");
      out.write("            <ul class=\"list-group\">\n");
      out.write("                ");

                    Integer sturegId = (Integer) session.getAttribute("id");
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm a");

                    try {
                        Connection connection = con.getConnection();

                        String query = "SELECT n.title, n.description, n.created_at " +
                                       "FROM notices n " +
                                       "JOIN stureg s ON n.dept_code = s.dept_code " +
                                       "WHERE s.id = ? AND n.status = 0 " +
                                       "ORDER BY n.created_at DESC";

                        PreparedStatement ps = connection.prepareStatement(query);
                        ps.setInt(1, sturegId);
                        ResultSet rs = ps.executeQuery();

                        boolean found = false;
                        while (rs.next()) {
                            found = true;
                            String title = rs.getString("title");
                            String description = rs.getString("description");
                            Timestamp createdAt = rs.getTimestamp("created_at");

                            // Convert URLs in description to clickable links
                            String formattedDescription = description.replaceAll(
                                "(https?://\\S+)", 
                                "<a href='$1' target='_blank'>$1</a>"
                            );
                
      out.write("\n");
      out.write("                            <li class=\"list-group-item\">\n");
      out.write("                                <strong>");
      out.print( title );
      out.write("</strong><br>\n");
      out.write("                                ");
      out.print( formattedDescription );
      out.write("<br>\n");
      out.write("                                <small class=\"text-muted\">Posted on: ");
      out.print( sdf.format(createdAt) );
      out.write("</small>\n");
      out.write("                            </li>\n");
      out.write("                ");

                        }
                        if (!found) {
                
      out.write("\n");
      out.write("                            <li class=\"list-group-item text-center text-muted\">No notices found for your department.</li>\n");
      out.write("                ");

                        }
                        rs.close();
                        ps.close();
                    } catch (Exception e) {
                        out.println("<p class='text-danger text-center'>Database error: " + e.getMessage() + "</p>");
                    }
                
      out.write("\n");
      out.write("            </ul>\n");
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
