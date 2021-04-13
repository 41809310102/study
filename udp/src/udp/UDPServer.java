package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * UDP 服务器端
 */
public class UDPServer {
    // 端口号
    private static final int port = 9001;
    // 数据的最大值
    private static final int bleng = 1024;
    public static void main(String[] args) throws IOException {
        // 1.启动一个 UDP 服务器端(IP、端口号)
        DatagramSocket socket = new DatagramSocket(port);
        System.out.println("服务器已启动！");
        while (true){
            // 2.初始化数据包
            DatagramPacket clientPacket = new DatagramPacket(
                    new byte[bleng],
                    bleng
            );
            // 3.等待客户端的链接
            socket.receive(clientPacket);
            // 执行到此步骤，表示已经有客户端连接
            // 4.接收到客户端的信息
            String msg = new String(clientPacket.getData());
            System.out.println("接收到客户端的信息："+msg);
            // 给客户端一个相应
            String serMsg = "我收到了";
            // 发送消息
            DatagramPacket serPacket = new DatagramPacket(
                    serMsg.getBytes(),
                    serMsg.getBytes().length, // 注意是字节长度
                    clientPacket.getAddress(),
                    clientPacket.getPort()
            );
            socket.send(serPacket);
        }
    }
}