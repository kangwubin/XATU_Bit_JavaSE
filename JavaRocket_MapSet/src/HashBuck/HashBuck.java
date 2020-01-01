package HashBuck;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/5
 * @Time: 10:04
 */
public class HashBuck {
    static class Node {
        public int key;
        public int value;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.value = val;
        }
    }

    public Node[] array;
    public int usedSize;

    public HashBuck() {
        this.array = new Node[10];
        this.usedSize = 0;
    }

    //put
    public void put(int key, int val) {
        int index = key % array.length;
        for (Node cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key == key) {
                cur.value = val;
                return;
            }
        }
        //头插法
        Node node = new Node(key, val);
        node.next = array[index];
        array[index] = node;
        this.usedSize++;
        if (loadFactor() >= 0.75) {
            resize();
        }
    }

    /*面试问题：
     * 1.哈希表的扩容规则：以2倍的方式扩容；并且要重新映射；
     * 2.哈希表的底层初始值是16个桶.*/
    public void resize() {
        Node[] newArray = new Node[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            Node curNext;
            for (Node cur = array[i]; cur != null; cur = curNext) {
                curNext = cur.next;
                //重新映射到新的数组中
                int index = cur.key % newArray.length;
                //头插法
                cur.next = newArray[index];
                newArray[index] = cur;
            }
        }
        array = newArray;
    }

    public int get(int key) {
        int index = key % array.length;
        for (Node cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key == key) {
                return cur.value;
            }
        }
        return -1;
    }

    //计算负载因子
    private double loadFactor() {
        return this.usedSize * 1.0 / array.length;
    }
}
