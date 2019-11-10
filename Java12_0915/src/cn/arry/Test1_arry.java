package cn.arry;
/*引用不支持指针运算，数组是低配的指针；数组、类都是引用类型
//Java：String是不能被修改的
//C：null为空指针，空指针表示地址为0的指针；Java：null表示空引用
//对于null进行内存访问，会出现空指针异常
数组的二次赋值：
--int[] arr={9,5,2,7};
--arr=new int[]{1,2,3,4,5,6};
JVM垃圾回收机制：
jvm stack:存的是局部变量，引用、方法的调用关系（调用栈），内存的生命周期与代码块有关
Heap:new 出来的东西在堆里，垃圾回收机制，核心就是围绕堆上的内存展开的。堆上内存的生命周期与代码块无关
*/
public class Test1_arry {
    public static void main(String[] args){
        int[] arr={1,2,3};
        printArry(arr);
        func(arr);
        System.out.println("arr[0]="+arr[0]);
    }
        //参数传数组类型
        //在函数内部修改数组内容, 函数外部也发生改变.
        //此时数组名 arr 是一个 "引用" . 当传参的时候, 是按照引用传参.
        //总结: 所谓的 "引用" 本质上只是存了一个地址. Java 将数组设定成引用类型, 这样的话后续进行数组参数传参,
        // 其实只是将数组的地址传入到函数形参中. 这样可以避免对整个数组的拷贝(数组可能比较长, 那么拷贝开销就会很大)
    public static void func(int[] a) {
        a[0] = 10;
        System.out.println("a[0]="+a[0]);
    }
        //打印数组内容
    public static void printArry(int[] a) {
        for (int x:a) {
            System.out.println(x);
        }
    }
}
