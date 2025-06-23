package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public final class registration_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      Database.ConnectionClass con = null;
      synchronized (_jspx_page_context) {
        con = (Database.ConnectionClass) _jspx_page_context.getAttribute("con", PageContext.PAGE_SCOPE);
        if (con == null){
          con = new Database.ConnectionClass();
          _jspx_page_context.setAttribute("con", con, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Student Registration - College Notice Board</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            background: url('background.jpg') no-repeat center center fixed;\n");
      out.write("            background-size: cover;\n");
      out.write("        }\n");
      out.write("        .registration-container {\n");
      out.write("            background: rgba(255, 255, 255, 0.9);\n");
      out.write("            padding: 30px;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);\n");
      out.write("            margin-top: 50px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container d-flex justify-content-center\">\n");
      out.write("        <div class=\"col-md-6 registration-container\">\n");
      out.write("            <h3 class=\"text-center\">Student Registration</h3>\n");
      out.write("            <form method=\"post\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Name</label>\n");
      out.write("                    <input type=\"text\" name=\"name\" class=\"form-control\" placeholder=\"Enter your full name\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Admission No</label>\n");
      out.write("                    <input type=\"text\" name=\"admission_no\" class=\"form-control\" placeholder=\"Enter your admission number\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Address</label>\n");
      out.write("                    <input type=\"text\" name=\"address\" class=\"form-control\" placeholder=\"Enter your address\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Course</label>\n");
      out.write("                    <input type=\"text\" name=\"course\" class=\"form-control\" placeholder=\"Enter your course\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Year of Study</label>\n");
      out.write("                    <input type=\"number\" name=\"year\" class=\"form-control\" placeholder=\"Enter your year of study\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Email</label>\n");
      out.write("                    <input type=\"email\" name=\"email\" class=\"form-control\" placeholder=\"Enter your email\" required>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Phone Number</label>\n");
      out.write("                    <input type=\"text\" name=\"phone\" class=\"form-control\" placeholder=\"Enter your phone number\" required>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Password</label>\n");
      out.write("                    <input type=\"password\" name=\"password\" class=\"form-control\" placeholder=\"Enter a strong password\" required>\n");
      out.write("                </div>\n");
      out.write("                <button type=\"submit\" class=\"btn btn-success btn-block\">Register</button>\n");
      out.write("                <p class=\"text-center mt-3\">\n");
      out.write("                    <a href=\"Login.jsp\" class=\"btn btn-secondary btn-block\">Back to Login</a>\n");
      out.write("                </p>\n");
      out.write("            </form>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("           \n");
      out.write("            \n");
      out.write("            ");

                if (request.getParameter("name") != null) {
                    String name = request.getParameter("name");
                    String admissionNo = request.getParameter("admission_no");
                    String address = request.getParameter("address");
                    String course = request.getParameter("course");
                    String year = request.getParameter("year");
                    String phone = request.getParameter("phone");
                    String email = request.getParameter("email");
                    String password = request.getParameter("password");
                    
                    String query = "INSERT INTO stureg (name, admission_no, address, course, year_of_study, phone,email, password) VALUES (?, ?, ?, ?, ?,?, ?, ?)";
                    try {
                        PreparedStatement ps = con.getConnection().prepareStatement(query);
                        ps.setString(1, name);
                        ps.setString(2, admissionNo);
                        ps.setString(3, address);
                        ps.setString(4, course);
                        ps.setInt(5, Integer.parseInt(year));
                        ps.setString(6, phone);
                        ps.setString(7, email);
                        ps.setString(8, password);
                        
                        int result = ps.executeUpdate();
                        if (result > 0) {
            
      out.write("\n");
      out.write("                            <script>\n");
      out.write("                                alert(\"Registration Successful!\");\n");
      out.write("                                window.location.href = \"Login.jsp\";\n");
      out.write("                            </script>\n");
      out.write("            ");

                        } else {
            
      out.write("\n");
      out.write("                            <script>\n");
      out.write("                                alert(\"Registration Failed! Please try again.\");\n");
      out.write("                            </script>\n");
      out.write("            ");

                        }
                    } catch (Exception e) {
                        out.println("Database error: " + e.getMessage());
                    }
                }
            
      out.write("\n");
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
