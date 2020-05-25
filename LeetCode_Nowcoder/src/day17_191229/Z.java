package day17_191229;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/29
 * @Time: 21:34
 */
//输出结果：YXYZ
class X {
    Y y = new Y();

    public X() {
        System.out.print("X");
    }
}

class Y {
    public Y() {
        System.out.print("Y");
    }
}

public class Z extends X {
    Y y = new Y();

    public Z() {
        System.out.print("Z");
    }

    public static void main(String[] args) {
        new Z();
    }
}
