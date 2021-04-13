package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * 统一接口处理类
 */
public class ResultJSONUtils {

    /**
     * 给前端输出 json 数据
     */
    public static void write(HttpServletResponse response,
                             HashMap<String, Object> data) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        writer.println(mapper.writeValueAsString(data));
    }

}
