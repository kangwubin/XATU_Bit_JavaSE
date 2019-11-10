package cn.xatu;

public class LinkedListTest {
    public static void main(String[] args) {
       testAddFirst();
       testAddLast();
       testAddIndex();
       testContains();
    }

    public static void testAddFirst(){
        SingleLinkedList list=new SingleLinkedList();
        System.out.println("测试头插！");
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.display();
    }

    public static void testAddLast(){
        SingleLinkedList list=new SingleLinkedList();
        System.out.println("测试尾插！");
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.display();
    }

    public static void testAddIndex(){
        SingleLinkedList list=new SingleLinkedList();
        System.out.println("测试任意位置插入！");
        System.out.println("插入之前的数据：");
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.display();
        System.out.println("在任意位置插入之后的数据为：");
        list.addIndex(0,6);
        list.addIndex(2,7);
        list.addIndex(5,8);
        list.display();
    }

    public static void testContains(){
        SingleLinkedList list=new SingleLinkedList();
        System.out.println("测试查找元素是否存在！");
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.display();
        System.out.println("预期结果是：true，"+"实际结果是："+list.contains(3));
    }

}
