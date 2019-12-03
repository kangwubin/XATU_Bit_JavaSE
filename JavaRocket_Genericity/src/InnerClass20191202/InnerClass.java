package InnerClass20191202;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/3
 * @Time: 16:29
 */
class OuterClass {
    public int data1 = 16;
    public static int data2 = 18;

    /*
     * 实例内部类---问题：
     * 1.如何拿到实例内部类的对象？
     * 2.在实例内部类当中，是否可以定义static的数据成员？
     *   可以，但是必须用static final修饰 -》实例内部类的成员必须是在编译时期确定的！
     * 3.内部类可以访问外部类的所有数据成员，包括私有的。
     * 4.实例内部类是否有额外的开销？有额外的开销，包含了外部类的this。
     * 解释：InnerClass是OuterClass 的 成员。
     * OuterClass.this->拿到外部类的对象的引用。
     * 5.内部类生成的class文件：外部类名$内部类名--(OuterClass $ InnerClass).*/
    class InnerClass {
        public int data3 = 100;
        public static final int data4 = 200;
        public int data1 = 10000;

        public InnerClass() {
        }

        public void func() {
            System.out.println("InnerClass::func()");
            System.out.println("data1: " + this.data1);//10000
            System.out.println("data2: " + data2);//18
            System.out.println("data3: " + data3);//100
            System.out.println("data4: " + data4);//200
            System.out.println("out-data1: " + OuterClass.this.data1);//16
        }
    }
}

public class InnerClass {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        /*访问实例内部类的对象：
         *外部类名.实例内部类名  变量   =  外部类对象的引用.new 内部类对象*/
        OuterClass.InnerClass in = outerClass.new InnerClass();
        in.func();
    }
}
