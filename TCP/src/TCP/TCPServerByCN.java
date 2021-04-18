package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerByCN {

    //
    private  static  final int port = 9003;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("已启动服务器");
        Socket socket = serverSocket.accept();
        System.out.println(String.format("客户端，ip:%s,port:%s",socket.getInetAddress().getHostAddress(),socket.getPort()));

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader reader = new BufferedReader( new InputStreamReader(socket.getInputStream())))
        {
            while (true) {
                String en = reader.readLine();
                if(en!=null||en.equals("")) {
                    String cn = processData(en);
                    writer.write(cn + "\n");
                    writer.flush();
                }
            }

        }


    }
//英译汉方法
    private static String processData(String en) {
        String cn = "";
        switch (en){
            case"hello":
                cn="你好";
                break;
            case"dog":
                cn="狗";
                break;
            case"cat":
                cn="猫";
                break;
            case"java":
                cn="java语言";
                break;
            default:
                cn="未知";
                break;
        }
        return cn;
    }

    //英译汉方法boss
    //爬虫；添加到数据库
    //通过Tcp服务器端实现费用和展示
    //
}
