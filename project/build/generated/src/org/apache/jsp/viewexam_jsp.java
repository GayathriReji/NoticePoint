package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class viewexam_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Exam Timetable</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            background-color: #f4f6f9;\n");
      out.write("            font-family: 'Segoe UI', sans-serif;\n");
      out.write("        }\n");
      out.write("        .container {\n");
      out.write("            margin-top: 80px;\n");
      out.write("            padding: 30px;\n");
      out.write("            background: white;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 0 10px rgba(0,0,0,0.1);\n");
      out.write("        }\n");
      out.write("        h3 {\n");
      out.write("            text-align: center;\n");
      out.write("            margin-bottom: 30px;\n");
      out.write("            color: #34495e;\n");
      out.write("        }\n");
      out.write("        table {\n");
      out.write("            width: 100%;\n");
      out.write("        }\n");
      out.write("        .btn-download {\n");
      out.write("            float: right;\n");
      out.write("            margin-bottom: 15px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div class=\"container\" id=\"timetable-content\">\n");
      out.write("    <h3><i class=\"bi bi-calendar3\"></i> Exam Timetable</h3>\n");
      out.write("\n");
      out.write("    <button class=\"btn btn-primary btn-download\" onclick=\"downloadPDF()\">Download as PDF</button>\n");
      out.write("\n");
      out.write("    <table class=\"table table-bordered table-hover mt-4\">\n");
      out.write("        <thead class=\"thead-dark\">\n");
      out.write("            <tr>\n");
      out.write("                <th>#</th>\n");
      out.write("                <th>Exam Name</th>\n");
      out.write("                <th>Date</th>\n");
      out.write("                <th>Time</th>\n");
      out.write("            </tr>\n");
      out.write("        </thead>\n");
      out.write("        <tbody>\n");
      out.write("            ");

                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board", "root", "");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM exams ORDER BY exam_date ASC");
                    int count = 1;
                    while (rs.next()) {
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print( count++ );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( rs.getString("exam_name") );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( rs.getString("exam_date") );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( rs.getString("exam_time") );
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                    }
                    con.close();
                } catch (Exception e) {
                    out.println("Error: " + e.getMessage());
                }
            
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- jsPDF library for PDF generation -->\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.1/jspdf.umd.min.js\"></script>\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/html2canvas/1.4.1/html2canvas.min.js\"></script>\n");
      out.write("<script>\n");
      out.write("    async function downloadPDF() {\n");
      out.write("        const { jsPDF } = window.jspdf;\n");
      out.write("        const timetable = document.getElementById(\"timetable-content\");\n");
      out.write("\n");
      out.write("        html2canvas(timetable).then(canvas => {\n");
      out.write("            const imgData = canvas.toDataURL('image/png');\n");
      out.write("            const pdf = new jsPDF('p', 'pt', 'a4');\n");
      out.write("            const imgProps= pdf.getImageProperties(imgData);\n");
      out.write("            const pdfWidth = pdf.internal.pageSize.getWidth();\n");
      out.write("            const pdfHeight = (imgProps.height * pdfWidth) / imgProps.width;\n");
      out.write("            pdf.addImage(imgData, 'PNG', 0, 0, pdfWidth, pdfHeight);\n");
      out.write("            pdf.save(\"exam_timetable.pdf\");\n");
      out.write("        });\n");
      out.write("    }\n");
      out.write("</script>\n");
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
