package dataStructure.queue;

/**
 * 实现基本的队列功能，队列空间利用不充分
 * 更为完善的demo可以参考ArrayQueue2
 */
public class ArrayQueue {

    private String[] items;

    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(String[] items){
        this.items = items;
        n = items.length;
    }

    public boolean enQueue(String e){
        if(tail == n){
            return Boolean.FALSE;
        }
        items[tail] = e;
        tail++;
        return Boolean.TRUE;
    }

    public String deQueue(){
        if(head == tail){
            return null;
        }
        String ret = items[head];
        head++;
        return ret;
    }

    public static void main(String[] args) {
        String[] test = new String[10];
        ArrayQueue arrayQueue = new ArrayQueue(test);
        arrayQueue.enQueue("23");
        System.out.println(arrayQueue.deQueue());
    }
}
