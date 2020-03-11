package socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类名称：NIOServerPool<br>
 * 类描述：<br>
 * 创建时间：2020年03月03日<br>
 *
 * @author kuyonggang
 * @version 1.0.0
 */
public class NIOServerPool {

    /**
     * 利用线程池实现NIO服务端
     * 主线程用于接收请求，交给子线程进行IO操作
     * @param args
     */
    private ServerSocketChannel server;
    private Selector selector;
    ExecutorService executor = Executors.newCachedThreadPool();
    public static void main(String[] args) throws IOException {
        int port = 1234;
        NIOServerPool server = new NIOServerPool();
        server.bind(port);
        server.start();
    }
    //绑定端口
    public void bind(int port) throws IOException {
        server = ServerSocketChannel.open();
        selector = Selector.open();
        server.bind(new InetSocketAddress(port));
        server.configureBlocking(false);
        server.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务端启动");
    }
    //选择器轮询并安排子线程进行操作
    public void start() throws IOException {
        while(selector.select()>0){
            Iterator<SelectionKey> itr = selector.selectedKeys().iterator();
            while(itr.hasNext()){
                SelectionKey key = itr.next();
                itr.remove();
                if(key.isValid() && key.isAcceptable()){
                    ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                    SocketChannel sc = ssc.accept();
                    System.out.println("客户端已上线");
                    ThreadTask task = new ThreadTask(sc);
                    executor.submit(task);
                }
            }
        }
        server.close();
        selector.close();
        executor.shutdown();

    }
    class ThreadTask implements Runnable{
        //子类选择器
        Selector selector = Selector.open();
        //缓冲区
        ByteBuffer byteBuffer ;
        ThreadTask(SocketChannel channel) throws IOException {
            channel.configureBlocking(false);
            channel.register(selector,SelectionKey.OP_READ);
            byteBuffer = ByteBuffer.allocate(1024);
            SocketAddress address = channel.getRemoteAddress();
            System.out.println("线程"+Thread.currentThread().getName()+"处理"+address+"的用户请求");
        }
        @Override
        public void run() {
            try {
                while(selector.select()>0){
                    Iterator<SelectionKey> itr = selector.selectedKeys().iterator();
                    while(itr.hasNext()){
                        SelectionKey key = itr.next();
                        itr.remove();
                        if(key.isValid() && key.isReadable()){
                            SocketChannel socket = (SocketChannel) key.channel();
                            SocketAddress address = socket.getRemoteAddress();
                            StringBuffer sBuffer = new StringBuffer();
                            while(socket.read(byteBuffer)>0){
                                byteBuffer.flip();
                                int count = byteBuffer.remaining();
                                sBuffer.append(new String(byteBuffer.array()),0,count);
                                byteBuffer.clear();
                            }
                            String msg = sBuffer.toString();
                            if("".equals(msg)){
                                continue;
                            }
                            if(msg.equals("exit")){
                                socket.close();
                                key.cancel();
                                System.out.println(address+"下线");
                                return;
                            }
                            System.out.println("客户端"+address+"发送消息");
                            byteBuffer.clear();
                            byteBuffer.put("server ack/n".getBytes());
                            byteBuffer.flip();
                            socket.write(byteBuffer);
                            byteBuffer.clear();
                        }
                    }

                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
