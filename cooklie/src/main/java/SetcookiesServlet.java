import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SetcookiesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        Cookie usernameCookie = new Cookie("username","java");
        //设置Cookie的生命周期
        usernameCookie.setMaxAge(60);
        //告诉用户存储C哦OkIE信
        response.addCookie(usernameCookie);


        //告诉用户cookies被保存了
        PrintWriter writer = response.getWriter();
        writer.println("<h1>Cookie保存成功！</h1>");
    }
}
