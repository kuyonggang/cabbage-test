package socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 类名称：NIOClient<br>
 * 类描述：<br>
 * 创建时间：2020年03月03日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public class NIOClient {
    private static final int DEFAULT_PORT = 1234;
    public static void main(String[] args) throws IOException {
        //创建SocketChannel实例
        SocketChannel socketChannel = SocketChannel.open();
        //创建选择器实例
        Selector selector = Selector.open();
        //将SocketChannel设为非阻塞
        socketChannel.configureBlocking(false);
        //将connect设为非阻塞，则无论connect是否发生都会立即返回
        if(!socketChannel.connect(new InetSocketAddress("127.0.0.1",DEFAULT_PORT))){
            //服务端还未连接上，对connect事件进行监听，将socketChannel注册到选择器上
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }
        int num;
        while((num = selector.select(1000))>0){
            System.out.println("select返回"+num);
            //获取注册到选择器上的事件
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while(iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();
                //可连接事件完成
                if(key.isValid() && key.isConnectable()){
                    SocketChannel sc = (SocketChannel) key.channel();
                    key.cancel();
                    //若连接未完成，结束该用户连接
                    if(!sc.finishConnect()){
                        System.exit(1);
                    }
                    //连接完成，创建发送数据的缓冲区
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    buffer.put("hello".getBytes());
                    buffer.flip();
                    //给服务端发消息
                    socketChannel.write(buffer);
                    System.out.println("给服务端发消息完成");
                }
            }
        }
        //关闭
        selector.close();
        socketChannel.close();
        System.out.println("客户端关闭");
    }

}
