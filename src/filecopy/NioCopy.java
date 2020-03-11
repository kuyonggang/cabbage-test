/**
 * 
 */
package filecopy;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 类名称：NioCopy<br>
 * 类描述：首先，它的作用位置处于传统IO（BIO）与零拷贝之间，为何这么说？
 * IO，可以把磁盘的文件经过内核空间，读到JVM空间，然后进行各种操作，最后再写到磁盘或是发送到网络，效率较慢但支持数据文件操作。
 * 零拷贝则是直接在内核空间完成文件读取并转到磁盘（或发送到网络）。由于它没有读取文件数据到JVM这一环，因此程序无法操作该文件数据，尽管效率很高！
 * 而直接内存则介于两者之间，效率一般且可操作文件数据。直接内存（mmap技术）将文件直接映射到内核空间的内存，返回==一个操作地址（address）==，
 * 它解决了文件数据需要拷贝到JVM才能进行操作的窘境。而是直接在内核空间直接进行操作，省去了内核空间拷贝到用户空间这一步操作。
 * NIO的直接内存是由==MappedByteBuffer==实现的。核心即是map()方法，该方法把文件映射到内存中，获得内存地址addr，
 * 然后通过这个addr构造MappedByteBuffer类，以暴露各种文件操作API。
 * 
 * 由于MappedByteBuffer申请的是堆外内存，因此不受Minor GC控制，只能在发生Full GC时才能被回收。
 * 而==DirectByteBuffer==改善了这一情况，它是MappedByteBuffer类的子类，同时它实现了DirectBuffer接口，维护一个Cleaner对象来完成内存回收。
 * 因此它既可以通过Full GC来回收内存，也可以调用clean()方法来进行回收。
 * 另外，直接内存的大小可通过jvm参数来设置：-XX:MaxDirectMemorySize。
 * NIO的MappedByteBuffer还有一个兄弟叫做HeapByteBuffer。顾名思义，它用来在堆中申请内存，本质是一个数组。由于它位于堆中，因此可受GC管控，易于回收。
 * 参考:
 * https://blog.csdn.net/localhost01/article/details/83422888
 * https://blog.csdn.net/cringkong/article/details/80274148<br>
 * 创建时间：2020年2月16日下午10:49:25<br>
 *
 * @author Administrator
 * @version	1.0.0
 */
public class NioCopy {

    public static void main(String[] args) throws IOException {
        File file = new File("test.zip");
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        FileChannel fileChannel = raf.getChannel();
        MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
    }

}
