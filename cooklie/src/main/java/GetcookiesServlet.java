import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetcookiesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        //得到Cookie
        request.getCookies();
        Cookie[] cookies = request.getCookies();
        PrintWriter writer = response.getWriter();
        for(Cookie cookie : cookies){
            writer.println(String.format("<h1>Cookie name:%s,Cookie value:%s</h1>",cookie.getName(),cookie.getValue()));
        }
    }
}
