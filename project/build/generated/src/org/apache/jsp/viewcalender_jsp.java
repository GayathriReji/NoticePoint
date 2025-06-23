package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class viewcalender_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Exam Calendar - College Notice Board</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/fullcalendar@5.11.3/main.min.css\">\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/fullcalendar@5.11.3/main.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/@fullcalendar/interaction@5.11.3/main.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/fullcalendar@5.11.3/locales-all.min.js\"></script>\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n");
      out.write("    \n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            background: url('background.jpg') no-repeat center center fixed;\n");
      out.write("            background-size: cover;\n");
      out.write("        }\n");
      out.write("        .container {\n");
      out.write("            margin-top: 20px;\n");
      out.write("            background: rgba(255, 255, 255, 0.9);\n");
      out.write("            padding: 20px;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);\n");
      out.write("            max-width: 700px;\n");
      out.write("        }\n");
      out.write("        #calendar {\n");
      out.write("            max-width: 100%;\n");
      out.write("            margin: auto;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n");
      out.write("        <a class=\"navbar-brand\" href=\"#\"><i class=\"fas fa-graduation-cap\"></i> College Notice Board</a>\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNav\">\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("        </button>\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n");
      out.write("            <ul class=\"navbar-nav ml-auto\">\n");
      out.write("                <li class=\"nav-item\"><a class=\"nav-link\" href=\"dashboard.jsp\"><i class=\"fas fa-home\"></i> Home</a></li>\n");
      out.write("                <li class=\"nav-item\"><a class=\"nav-link\" href=\"view_notices.jsp\"><i class=\"fas fa-bullhorn\"></i> Notices</a></li>\n");
      out.write("                <li class=\"nav-item\"><a class=\"nav-link\" href=\"exam_calendar.jsp\"><i class=\"fas fa-calendar\"></i> Exam Calendar</a></li>\n");
      out.write("                <li class=\"nav-item\"><a class=\"nav-link\" href=\"logout.jsp\"><i class=\"fas fa-sign-out-alt\"></i> Logout</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h3 class=\"text-center\"><i class=\"fas fa-calendar-alt\"></i> Exam Schedule</h3>\n");
      out.write("        <div id=\"calendar\"></div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"modal fade\" id=\"examModal\" tabindex=\"-1\" role=\"dialog\">\n");
      out.write("        <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <h5 class=\"modal-title\">Add/Edit Exam</h5>\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                        <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                    </button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <form id=\"examForm\" action=\"examcalender.jsp\" method=\"POST\">\n");
      out.write("                        <input type=\"hidden\" id=\"examId\" name=\"examId\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"examName\">Exam Name:</label>\n");
      out.write("                            <input type=\"text\" id=\"examName\" name=\"examName\" class=\"form-control\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"examDate\">Exam Date:</label>\n");
      out.write("                            <input type=\"text\" id=\"examDate\" name=\"examDate\" class=\"form-control\" readonly>\n");
      out.write("                        </div>\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-primary btn-block\">Save Exam</button>\n");
      out.write("                        <button type=\"button\" id=\"deleteExam\" class=\"btn btn-danger btn-block\" style=\"display: none;\">Delete Exam</button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        document.addEventListener('DOMContentLoaded', function () {\n");
      out.write("            let calendarEl = document.getElementById('calendar');\n");
      out.write("            let calendar = new FullCalendar.Calendar(calendarEl, {\n");
      out.write("                initialView: 'dayGridMonth',\n");
      out.write("                selectable: true,\n");
      out.write("                editable: true,\n");
      out.write("                locale: 'en',\n");
      out.write("                events: [\n");
      out.write("                    ");
 
                        try {
                            Connection connection = con.getConnection();
                            String query = "SELECT id, exam_name, exam_date FROM exams";
                            PreparedStatement ps = connection.prepareStatement(query);
                            ResultSet rs = ps.executeQuery();
                            while (rs.next()) {
                    
      out.write("\n");
      out.write("                        {\n");
      out.write("                            id: \"");
      out.print( rs.getInt("id") );
      out.write("\",\n");
      out.write("                            title: \"");
      out.print( rs.getString("exam_name") );
      out.write("\",\n");
      out.write("                            start: \"");
      out.print( rs.getString("exam_date") );
      out.write("\"\n");
      out.write("                        },\n");
      out.write("                    ");
 
                            }
                            rs.close();
                            ps.close();
                        } catch (Exception e) {
                            out.println("Database error: " + e.getMessage());
                        }
                    
      out.write("\n");
      out.write("                ],\n");
      out.write("                dateClick: function (info) {\n");
      out.write("                    $('#examId').val('');\n");
      out.write("                    $('#examName').val('');\n");
      out.write("                    $('#examDate').val(info.dateStr);\n");
      out.write("                    $('#deleteExam').hide();\n");
      out.write("                    $('#examModal').modal('show');\n");
      out.write("                },\n");
      out.write("                eventClick: function (info) {\n");
      out.write("                    $('#examId').val(info.event.id);\n");
      out.write("                    $('#examName').val(info.event.title);\n");
      out.write("                    $('#examDate').val(info.event.start.toISOString().split('T')[0]);\n");
      out.write("                    $('#deleteExam').show().off('click').on('click', function () {\n");
      out.write("                        if (confirm('Are you sure you want to delete this exam?')) {\n");
      out.write("                            window.location.href = 'viewcalender.jsp?id=' + info.event.id;\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                    $('#examModal').modal('show');\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("            calendar.render();\n");
      out.write("        });\n");
      out.write("    </script>\n");
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
