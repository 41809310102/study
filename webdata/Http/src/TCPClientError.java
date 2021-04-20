import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPClientError {

    public  static  final  String ip = "127.0.0.1";
    public  static  final int port=9005;
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(ip,port);

        //发送消息；
        String msg="hello java";
       //的到反手对象；

        try(OutputStream outputStream = socket.getOutputStream()){
            for(int i =0;i<10;i++){
                //发送消息
                outputStream.write(msg.getBytes());
              outputStream.flush();
            }
        }
    }
}
