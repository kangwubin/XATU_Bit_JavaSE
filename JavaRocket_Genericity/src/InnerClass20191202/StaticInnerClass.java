package InnerClass20191202;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/3
 * @Time: 16:57
 */
class OuterClass2 {
    public int data1 = 16;
    public static int data2 = 18;

    /**
     * 静态内部类-》static
     * 1.如何拿到静态内部类的实例对象？--将静态内部类看成外部类的静态成员.
     */
    static class InnerClass2 {
        public int data3 = 100;
        public static final int data4 = 200;
        public int data1 = 300;
        public OuterClass2 o = null;

        public InnerClass2() {
        }

        public InnerClass2(OuterClass2 out) {
            this.o = out;
        }

        public void func() {
            System.out.println("InnerClass2::func()");
            System.out.println("data3:" + data3);//100
            System.out.println("data4:" + data4);//200
            System.out.println("data1:" + data1);//300
            System.out.println("data2:" + data2);//18
            System.out.println("out-data1:" + OuterClass2.data2);//16
            //问题：静态内部类能否访问外部类的实例成员，不能直接访问;
            //System.out.println("outdata1: "+ OuterClass2.this.data1);---error
            /*间接访问的步骤：
             * 1. public InnerClass2(OuterClass2 out) {
             *    this.o = out;}
             * 2. public OuterClass2 o = null;
             * 3.OuterClass2 outerClass2 = new OuterClass2();
             *   OuterClass2.InnerClass2 innerClass2 = new OuterClass2.InnerClass2(outerClass2);
             * 4.System.out.println("out2-data1:" + o.data1);*/
            System.out.println("out2-data1:" + o.data1);//16
        }
    }

}

public class StaticInnerClass {
    public static void main(String[] args) {
        OuterClass2 outerClass2 = new OuterClass2();
        /*访问静态内部类对象：
         *外部类名.静态内部类名  in = new 外部类类名.内部类();*/
        OuterClass2.InnerClass2 innerClass2 = new OuterClass2.InnerClass2(outerClass2);
        innerClass2.func();
        int ret = OuterClass2.InnerClass2.data4;
//        System.out.println(ret);//200
    }
}
