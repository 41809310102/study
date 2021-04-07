import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class CalcServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        int succ= -1;//验证是不是成功
        String fail = "";//验证是不是失败
        int sum =0;
        String num1 = request.getParameter("number1");
        String num2 = request.getParameter("number2");
        if(num1!=null&&num2!=null&&!equals("")&&!equals("")){
             sum= Integer.parseInt(num1)+Integer.parseInt(num2);
             succ=1;
        }else{
            fail = "请求失败！";
        }
            //{"succ":%d,"fail":"%s","sum":%d}
        PrintWriter writer = response.getWriter();
        writer.println(String.format("{\"succ\":%d,\"fail\":\"%s\",\"sum\":%d}",succ,fail,sum));
    }
}
