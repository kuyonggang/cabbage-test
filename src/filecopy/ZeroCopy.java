/**
 * 
 */
package filecopy;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * 类名称：ZeroCopy<br>
 * 类描述：使用场景一般是：
 * 较大，读写较慢，追求速度
 * 内存不足，不能加载太大数据
 * 带宽不够，即存在其他程序或线程存在大量的IO操作，导致带宽本来就小
 * 以上都建立在不需要进行数据文件操作的情况下，如果既需要这样的速度，也需要进行数据操作怎么办？
 * 那么使用NIO的直接内存！<br>
 * 创建时间：2020年1月15日下午5:31:33<br>
 *
 * @author YoungerKu
 * @version	1.0.0
*/
public class ZeroCopy {

    public static void main(String[] args) throws IOException {
        File file = new File("D:/a.png");
        @SuppressWarnings("resource")
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        FileChannel fileChannel = raf.getChannel();
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("", 1234));
        // 直接使用了transferTo()进行通道间的数据传输
        fileChannel.transferTo(0, fileChannel.size(), socketChannel);
    }
}
