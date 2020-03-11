/**
 *
 */
package socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 类名称：HansClient<br>
 * 类描述：不工作的时候还有收入，才能晚上安然的休息；不然你将工作到死。<br>
 * 创建时间：2020年2月27日下午6:29:03<br>
 *
 * @author Administrator
 * @version	1.0.0
 */
public class HansClient {
    // 定义检测SocketChannel的Selector对象
    private Selector selector = null;
    // 客户端SocketChannel
    private SocketChannel sc = null;

    public void init() throws IOException {
        selector = Selector.open();
        InetSocketAddress isa = new InetSocketAddress("127.0.0.1", 30000);
        // 调用open静态方法创建连接到指定主机的SocketChannel
        sc = SocketChannel.open(isa);
        // 设置该sc以非阻塞方式工作
        sc.configureBlocking(false);
        // 将SocketChannel对象注册到指定Selector
        sc.register(selector, SelectionKey.OP_READ);
        // 创建键盘输入流
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            // 读取键盘输入
            String line = scan.nextLine();
            int SendRes = new HansClient().S_SendData(sc);
            System.out.println(String.format("发送数据%s 字节数值%s",line,SendRes));
            new HansClient().S_ResData(selector);
        }
        // 启动读取服务器端数据的线程
        //        new ClientThread().start();


        sc.close();
        selector.close();
    }

    public int S_SendData(SocketChannel sc ){
        int sendRes =0;
        String line = "6*7";
        // 将键盘输入的内容输出到SocketChannel中
        try {
            sendRes = sc.write(StandardCharsets.UTF_8.encode(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sendRes;
    }
    public void S_ResData(Selector sele){
        try {
            while (sele.select() > 0) {
                // 遍历每个有可用IO操作Channel对应的SelectionKey
                for (SelectionKey sk : sele.selectedKeys()) {
                    // 删除正在处理的SelectionKey
                    sele.selectedKeys().remove(sk);
                    // 如果该SelectionKey对应的Channel中有可读的数据
                    if (sk.isReadable()) {
                        // 使用NIO读取Channel中的数据
                        SocketChannel sc = (SocketChannel) sk.channel();
                        ByteBuffer buff = ByteBuffer.allocate(5);
                        String content = "";
                        byte[] receData =new byte[0];
                        byte[] temp =new byte[1];
                        while(sc.read(buff)> 0){
                            sc.read(buff);
                            temp = buff.array();
                            byte[] and = new byte[temp.length+receData.length];
                            System.arraycopy(receData, 0, and, 0, receData.length);
                            System.arraycopy(temp, 0, and, receData.length, temp.length);
                            receData=and;
//                            buff.flip();
                            buff.clear();
                        }
                        content += StandardCharsets.UTF_8.decode(ByteBuffer.wrap(receData));
                        // 打印输出读取的内容
                        System.out.println("聊天信息：" + content);
                        break;
                    }
                }
                break;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new HansClient().init();
    }

}