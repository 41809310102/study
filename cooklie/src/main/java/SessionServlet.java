

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doGet(request,response);
    }
//session和Cookie的区别
    /*
    * 1.session和cookie的存储机制是不一样的,cookie是浏览器端实现的会话保持，而sessions是服务器中实现的对话
    * 2.session是没有内存限制的，而cookie是有存储限制的，一般是4K
    * 3.session安全性高（每次访问都有一个密钥，也就是session id），不能被篡改，而cookie信息是会被长篡改的
    * */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        PrintWriter writer = response.getWriter();
        if(name!=null && pwd!=null&&name.equals("root")&& pwd.equals("root")){
            HttpSession session = request.getSession();
            String sessionId = session.getId();
            writer.println("<h1>欢迎登录<h1>");
            writer.println(String.format("<h3>ID；%s</h3>",sessionId));

        }else{

            writer.println();
        }
    }
}
