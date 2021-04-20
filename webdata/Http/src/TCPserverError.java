import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPserverError {
public  static  final  int port = 9005;
public  static   final int leng = 1024;
    public static  void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        System.out.println("服务器已经打开！");
        System.out.println(String.format("已经有客户端链接了，IP：%s,port:%s",socket.getInetAddress().getHostAddress(),socket.getPort()));
    try(InputStream inputStream = socket.getInputStream()){
        while(true){
            byte[] bytes = new byte[leng];
            int result = inputStream.read(bytes,0,leng);
            if(result>0){
                String msg = new String( bytes);
                System.out.println("收到客户端消息："+msg+",");
            }
        }


    }
 /* try(BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
      while (true){

          String msg = reader.readLine();
          if(msg!=null||msg.equals("")){
              System.out.println("收到客户端消息："+msg+",");
          }
      }
  }*/

    }
}
