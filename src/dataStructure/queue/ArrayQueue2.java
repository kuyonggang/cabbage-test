package dataStructure.queue;

import java.util.Arrays;

public class ArrayQueue2 {

    private String[] items;

    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue2(String[] items){
        this.items = items;
        n = items.length;
    }

    public boolean enQueue(String e){
        if(tail == n){
            //整个队列都已经满了
            if(head == 0){
                return Boolean.FALSE;
            }
            //数据搬移
            for(int i=head;i<tail;i++){
                items[i-head] = items[i];
            }
            //搬移完成后重新设置head和tail
            tail -= head;
            head = 0;
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
        String[] test = new String[5];
        ArrayQueue2 arrayQueue = new ArrayQueue2(test);
        for(int i = 0;i<test.length;i++){
            if(i == 3){
                // 输出第一个元素：23，队头指针后移1位
                System.out.println(arrayQueue.deQueue());
            }
            arrayQueue.enQueue((23+i)+"");
        }
        System.out.println(Arrays.asList(test));
        //输出第二个元素：24
        System.out.println(arrayQueue.deQueue());
    }
}
