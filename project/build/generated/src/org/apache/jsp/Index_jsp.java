package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>College Notice Board</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("    <style>\n");
      out.write("       body {\n");
      out.write("    background: url('images/college.webp') no-repeat center center fixed;\n");
      out.write("    background-size: cover;\n");
      out.write("    color: black;\n");
      out.write("}\n");
      out.write("\n");
      out.write("        .overlay {\n");
      out.write("            background: rgba(255, 255, 255, 0.8);\n");
      out.write("            min-height: 100vh;\n");
      out.write("            padding: 20px;\n");
      out.write("        }\n");
      out.write("        .card {\n");
      out.write("            border-radius: 15px;\n");
      out.write("            transition: 0.3s;\n");
      out.write("        }\n");
      out.write("        .card:hover {\n");
      out.write("            transform: scale(1.03);\n");
      out.write("            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);\n");
      out.write("        }\n");
      out.write("        .notice-list li {\n");
      out.write("            background: rgba(255, 255, 255, 0.9);\n");
      out.write("            border: none;\n");
      out.write("            color: black;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"overlay\">\n");
      out.write("        <div class=\"container mt-5\">\n");
      out.write("            <div class=\"text-center mb-4\">\n");
      out.write("                <h1 class=\"display-4\">📢 College Notice Board</h1>\n");
      out.write("                <p class=\"lead\">Stay updated with the latest news and announcements.</p>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <!-- Notices Section -->\n");
      out.write("            <div class=\"card shadow-lg bg-light text-dark mb-4\">\n");
      out.write("                <div class=\"card-header bg-primary text-white text-center\">\n");
      out.write("                    <h4>Latest Notices</h4>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <ul class=\"list-group list-group-flush notice-list\">\n");
      out.write("                        <li class=\"list-group-item\">📅 Exam schedule announced for Semester 2 <span class=\"badge badge-dark float-right\">March 30, 2025</span></li>\n");
      out.write("                        <li class=\"list-group-item\">🏆 Annual Sports Meet Registration Open <span class=\"badge badge-dark float-right\">March 28, 2025</span></li>\n");
      out.write("                        <li class=\"list-group-item\">📢 Holiday declared on April 1st <span class=\"badge badge-dark float-right\">March 25, 2025</span></li>\n");
      out.write("                        <li class=\"list-group-item\">🧠 Workshop on AI & ML <span class=\"badge badge-dark float-right\">March 20, 2025</span></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            <!-- Login Section -->\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                    <div class=\"card shadow-lg text-center bg-light text-dark\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <h5 class=\"card-title\">👨‍🎓 Student Login</h5>\n");
      out.write("                            <p class=\"card-text\">Access notices and updates.</p>\n");
      out.write("                            <a href=\"Login.jsp\" class=\"btn btn-primary btn-lg\">Login</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                    <div class=\"card shadow-lg text-center bg-light text-dark\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <h5 class=\"card-title\">🛠️ Admin Login</h5>\n");
      out.write("                            <p class=\"card-text\">Manage notices and announcements.</p>\n");
      out.write("                            <a href=\"ALogin.jsp\" class=\"btn btn-dark btn-lg\">Login</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
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
