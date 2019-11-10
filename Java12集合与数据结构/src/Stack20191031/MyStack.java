package Stack20191031;

public class MyStack {
    private int[] array = new int[100];
    private int size = 0;

    //1.入栈
    public void push(int x) {
        array[size] = x;
        size++;
    }

    //2.出栈
    public Integer pop() {
        if (size == 0) {
            return null;
        }
        int ret = array[size - 1];
        size--;
        return ret;
    }

    //3.取栈顶元素
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return array[size - 1];
    }

    //4.判断是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //5.获取栈的长度
    public int size() {
        return size;
    }
}
