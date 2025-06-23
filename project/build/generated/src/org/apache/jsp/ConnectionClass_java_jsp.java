package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ConnectionClass_java_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("/*\n");
      out.write(" * To change this license header, choose License Headers in Project Properties.\n");
      out.write(" * To change this template file, choose Tools | Templates\n");
      out.write(" * and open the template in the editor.\n");
      out.write(" */\n");
      out.write("\n");
      out.write("package DB;\n");
      out.write("\n");
      out.write("import java.sql.*;\n");
      out.write("\n");
      out.write("/**\n");
      out.write(" *\n");
      out.write(" * @author Nandu\n");
      out.write(" */\n");
      out.write("public class ConnectionClass {\n");
      out.write("    Connection con = null;\n");
      out.write("    Statement st = null;\n");
      out.write("    ResultSet rs = null;\n");
      out.write("\n");
      out.write("    public ConnectionClass() {\n");
      out.write("        try {\n");
      out.write("            Class.forName(\"com.mysql.jdbc.Driver\");\n");
      out.write("            con = DriverManager.getConnection(\"jdbc:mysql://localhost:3306/notice_board\", \"root\",null);\n");
      out.write("\n");
      out.write("        } catch (Exception ex) {\n");
      out.write("            System.out.println(ex);\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    public boolean executeCommand(String str) { //INSERT,DELETE,UPDATE\n");
      out.write("        boolean bol = false;\n");
      out.write("        try {\n");
      out.write("\n");
      out.write("            st = con.createStatement();\n");
      out.write("            st.executeUpdate(str);\n");
      out.write("            bol = true;\n");
      out.write("\n");
      out.write("        } catch (Exception ex) {\n");
      out.write("            System.out.println(ex);\n");
      out.write("        }\n");
      out.write("        return bol;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("\n");
      out.write("    public ResultSet selectCommand(String selQry) {//SELECT\n");
      out.write("        try {\n");
      out.write("            st = con.createStatement();\n");
      out.write("            rs = st.executeQuery(selQry);\n");
      out.write("        } catch (Exception ex) {\n");
      out.write("            System.out.println(ex);\n");
      out.write("        }\n");
      out.write("        return rs;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    public Connection getConnection() {\n");
      out.write("    return con;\n");
      out.write("}\n");
      out.write("\n");
      out.write("}");
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
