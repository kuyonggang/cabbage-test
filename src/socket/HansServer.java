/**
 *
 */
package socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * 类名称：HansServer<br>
 * 类描述：<br>
 * 创建时间：2020年2月27日下午6:28:09<br>
 *
 * @author Administrator
 * @version	1.0.0
 */
public class HansServer {

    // 用于检测所有Channel状态的Selector
    private Selector selector = null;

    public void init() throws IOException {
        selector = Selector.open();
        // 通过open方法来打开一个未绑定的ServerSocketChannel实例
        ServerSocketChannel server = ServerSocketChannel.open();
        InetSocketAddress isa = new InetSocketAddress("127.0.0.1", 30000);
        // 将该ServerSocketChannel绑定到指定IP地址
        server.socket().bind(isa);
        // 设置ServerSocket以非阻塞方式工作
        server.configureBlocking(false);
        // 将server注册到指定Selector对象
        server.register(selector, SelectionKey.OP_ACCEPT);
        while (selector.select() > 0) {
            // 依次处理selector上的每个已选择的SelectionKey
            for (SelectionKey sk : selector.selectedKeys()) {
                // 从selector上的已选择Key集中删除正在处理的SelectionKey
                selector.selectedKeys().remove(sk);
                // 如果sk对应的通道包含客户端的连接请求
                if (sk.isAcceptable()) {
                    // 调用accept方法接受连接，产生服务器端对应的SocketChannel
                    ServerSocketChannel ssc =(ServerSocketChannel) sk.channel();
                    SocketChannel sc = ssc.accept();
                    //                    SocketChannel sc = server.accept();
                    // 设置采用非阻塞模式
                    sc.configureBlocking(false);
                    // 将该SocketChannel也注册到selector
                    sc.register(selector, SelectionKey.OP_READ);
                }
                // 如果sk对应的通道有数据需要读取
                if (sk.isReadable()) {
                    // 获取该SelectionKey对应的Channel，该Channel中有可读的数据
                    SocketChannel sc = (SocketChannel) sk.channel();
                    // 定义准备执行读取数据的ByteBuffer
                    ByteBuffer buff = ByteBuffer.allocate(1024);
                    String content = "";
                    byte[] receData =new byte[0];
                    byte[] temp =new byte[1];
                    // 开始读取数据
                    try {
                        while(sc.read(buff)> 0){
                            sc.read(buff);
                            buff.flip();
                            int limit = buff.limit();
                            temp =new byte[limit];
                            buff.get(temp,0,limit);
                            byte[] and = new byte[temp.length+receData.length];
                            System.arraycopy(receData, 0, and, 0, receData.length);
                            System.arraycopy(temp, 0, and, receData.length, temp.length);
                            receData=and;

                            buff.clear();
                        }
                        content += StandardCharsets.UTF_8.decode(ByteBuffer.wrap(receData));
                        if(sc.read(buff)  == -1){
                            System.out.println("断开..."
                                    + sc.socket().getRemoteSocketAddress());
                            sk.cancel();
                            if (sk.channel() != null) {
                                sk.channel().close();
                                sc.close();
                            }
                        }else{
                            // 打印从该sk对应的Channel里读取到的数据
                            System.out.println("=====接收到客户端数据：" + content);
                            if (content.length() > 0) {
                                sc.write(StandardCharsets.UTF_8.encode("服务端发送："+content+"---已收到！！！"));
                            }
                        }
                    } catch (IOException ex) {
                        // 如果捕捉到该sk对应的Channel出现了异常，即表明该Channel
                        // 对应的Client出现了问题，所以从Selector中取消sk的注册
                        // 从Selector中删除指定的SelectionKey
                        sk.cancel();
                        if (sk.channel() != null) {
                            sk.channel().close();
                            sc.close();
                        }
                    }
                    // 如果content的长度大于0，即聊天信息不为空
                    //                    if (content.length() > 0) {
                    ////                        // 遍历该selector里注册的所有SelectKey
                    ////                        for (SelectionKey key : selector.keys()) {
                    ////                            // 获取该key对应的Channel
                    ////                            Channel targetChannel = key.channel();
                    ////                            // 如果该channel是SocketChannel对象
                    ////                            if (targetChannel instanceof SocketChannel) {
                    ////                                // 将读到的内容写入该Channel中
                    ////                                SocketChannel dest = (SocketChannel) targetChannel;
                    ////                                dest.write(StandardCharsets.UTF_8.encode("服务端发送："+content+"---已收到！！！"));
                    ////                            }
                    ////                        }
                    //                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new HansServer().init();
    }
}
