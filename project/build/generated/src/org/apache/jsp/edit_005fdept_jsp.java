package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class edit_005fdept_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Add Department - College Notice Board</title>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"container mt-5\">\n");
      out.write("    <h3 class=\"text-center mb-4\">🏫 ");
      out.print( isEdit ? "Edit" : "Add" );
      out.write(" Department</h3>\n");
      out.write("    <form method=\"post\" action=\"add_dept.jsp\">\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label>Department Code</label>\n");
      out.write("            <input type=\"text\" name=\"dept_code\" class=\"form-control\" value=\"");
      out.print( deptCodeEdit );
      out.write('"');
      out.write(' ');
      out.print( isEdit ? "readonly" : "" );
      out.write(" required>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label>Department Name</label>\n");
      out.write("            <input type=\"text\" name=\"dept_name\" class=\"form-control\" value=\"");
      out.print( deptNameEdit );
      out.write("\" required>\n");
      out.write("        </div>\n");
      out.write("        <button type=\"submit\" name=\"action\" value=\"");
      out.print( isEdit ? "update" : "add" );
      out.write("\" class=\"btn btn-");
      out.print( isEdit ? "primary" : "success" );
      out.write(" btn-block\">\n");
      out.write("            ");
      out.print( isEdit ? "Update Department" : "Add Department" );
      out.write("\n");
      out.write("        </button>\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("    <h5 class=\"mt-5 text-center font-weight-bold\">📋 Existing Departments</h5>\n");
      out.write("    <table class=\"table table-striped mt-3\">\n");
      out.write("        <thead class=\"thead-dark\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Code</th>\n");
      out.write("                <th>Name</th>\n");
      out.write("                <th>Actions</th>\n");
      out.write("            </tr>\n");
      out.write("        </thead>\n");
      out.write("        <tbody>\n");
      out.write("            ");

                Connection con = null;
                try {
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
                    String query = "SELECT dept_code, dept_name FROM department WHERE status1 = 0 ORDER BY dept_name ASC";
                    PreparedStatement ps = con.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        String code = rs.getString("dept_code");
                        String name = rs.getString("dept_name");
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print( code );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( name );
      out.write("</td>\n");
      out.write("                <td>\n");
      out.write("                    <a href=\"add_dept.jsp?action=edit&code=");
      out.print( code );
      out.write("\" class=\"btn btn-sm btn-primary\">Edit</a>\n");
      out.write("                    <a href=\"add_dept.jsp?action=delete&code=");
      out.print( code );
      out.write("\" class=\"btn btn-sm btn-danger\"\n");
      out.write("                       onclick=\"return confirm('Are you sure you want to delete this department?');\">Delete</a>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                    }
                    rs.close();
                    ps.close();
                } catch (Exception e) {
                    out.println("<tr><td colspan='3' class='text-danger'>Error: " + e.getMessage() + "</td></tr>");
                    e.printStackTrace();
                } finally {
                    if (con != null) try { con.close(); } catch (Exception e) { e.printStackTrace(); }
                }
            
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("</div>\n");
      out.write("\n");

    String action = request.getParameter("action");
    if (action != null) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");

            if ("add".equals(action)) {
                String code = request.getParameter("dept_code").trim();
                String name = request.getParameter("dept_name").trim();
                String sql = "INSERT INTO department (dept_code, dept_name, status1) VALUES (?, ?, 0)";
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
                String sql = "UPDATE department SET status1 = 1 WHERE dept_code = ?";
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

      out.write("\n");
      out.write("\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js\"></script>\n");
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
