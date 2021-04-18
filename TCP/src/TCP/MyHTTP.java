package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 自定义 HTTP 服务器
 * 根据 uri 内容返回不同的信息
 * 如果 uri 里面包含了 404，给浏览器输出“未找到此页面”
 * 如果 uri 里面包含了 200，返回一个“你好，世界！”
 */
public class MyHTTP {
    // 端口号
    private static final int port = 9004;

    public static void main(String[] args) throws IOException {
        // 1.创建一个 TCP 服务器
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("服务器已启动~");

        // 2.等待客户端连接
        Socket socket = serverSocket.accept();

        // 3.构建读、写对象
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(socket.getOutputStream()))
        ) {
            // 4.得到客户端信息
            // 得到首行信息
            String firstLine = reader.readLine();
            String[] firstLineArr = firstLine.split(" ");
            // 方法类型
            String method = firstLineArr[0];
            // uri
            String uri = firstLineArr[1];
            // http 版本号
            String httpVersion = firstLineArr[2];
            System.out.println(String.format("首行信息 -> 方法类型：%s,URI：%s,HTTP版本号：%s",
                    method, uri, httpVersion));
            // 5.构建返回内容
            String content = "";
            if (uri.contains("404")) {
                content = "<h1>没有找到此页面</h1>";
            } else if (uri.contains("200")) {
                content = "<h1>你好，世界</h1>";
            }
            while (true) {
                // 6.内容输出
                // 输出首行信息
                if(httpVersion!=null) {
                    writer.write(String.format("%s 200 ok", httpVersion) + "\n");
                    // 输出 head
                    writer.write("Content-Type: text/html;charset=utf-8\n");
                    writer.write("Content-Length: " + content.getBytes().length + "\n");
                    // 输出空行
                    writer.write("\n");
                    writer.write(content);
                    writer.flush();
                }
            }
        }
    }
}