package Collection_Map;

/**
 * Description:Integer的面试题
 *
 * @author: KangWuBin
 * @Date: 2019/11/12
 * @Time: 19:16
 */
public class TestDemoInteger {
    public static void main4(String[] args) {
        Integer a = 157;
        Integer b = 157;
        System.out.println(a == b);//false
        Integer a1 = 127;
        Integer b1 = 127;
        System.out.println(a1 == b1);//true
        Integer a2 = -128;
        Integer b2 = -128;
        System.out.println(a2 == b2);//true
        Integer a3 = -129;
        Integer b3 = -129;
        System.out.println(a3 == b3);//false
    }

    public static void main(String[] args) {
        int a = 10;
        Integer i = Integer.valueOf(a);//手动装箱
        System.out.println(i);

        Integer integer = new Integer(a);//手动拆箱
        int n = integer.intValue();
        System.out.println(n);
        double d = integer.doubleValue();
        System.out.println(d);
    }

    public static void main1(String[] args) {
        //int a = 10;
        Integer i = 10;//自动装箱->Integer.valueOf
        System.out.println(i);
        int a = i;//自动拆箱  intValue
        System.out.println(a);
    }
}
