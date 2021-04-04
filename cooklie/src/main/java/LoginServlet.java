import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        String username = request.getParameter("number1");
        String pwd = request.getParameter("number2");
        PrintWriter writer = response.getWriter();
       if(username.equals("admin")&& pwd.equals("admin")){
           writer.println(String.format("<p>登录成功！</p>"));
       }else{
           writer.println(String.format("<p>用户名或密码错误！请重新登录</p>"));
       }

    }
}
