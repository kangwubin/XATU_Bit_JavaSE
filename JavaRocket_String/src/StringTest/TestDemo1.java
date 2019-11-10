package StringTest;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/6 16:12
 */
public class TestDemo1 {
    //字符串的不可变
    public static void main(String[] args) {
        String str = "hello" ;
        System.out.println(Integer.toHexString(str.hashCode()));
        str = str + " world" ;
        System.out.println(Integer.toHexString(str.hashCode()));
        str += "!!!" ;
        System.out.println(Integer.toHexString(str.hashCode()));
        System.out.println(str);

        String str2 = "hello";
        System.out.println(str2.equals(str));
    }

    //String intern(): native   C/C++
    public static void main5(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello").intern();
        str2 = str2.intern();
        System.out.println(str1 == str2);   //true
    }

    //字符串赋值的过程
    public static void main4(String[] args) {
        String str1 = "KWB";
        String str2 = str1;
        System.out.println(str1);//KWB
        System.out.println(str2);//KWB
        str1 = "SY";
        System.out.println(str1);//SY
        System.out.println(str2);//KWB
    }

    //字符串判断相等  ==     equals
    public static void main3(String[] args) {
        String str1 = "KWBSY";
        String str2 = new String("KWBSY");
        System.out.println(str1.equals(str2));//true
        System.out.println(str1 == str2);//false

        String str3 = new String("KWBSY");
        System.out.println(str2 == str3);//false

        //如果两个字符串常量直接拼接+ 那么在编译期间就处理为拼接的结果
        String str4 = "KWB" + "SY";  //KWBSY   final int a = 66;
        System.out.println(str1 == str4);   //true

        String str5 = "KWB" + new String("SY"); //运行时才会产生KWBSY
        System.out.println(str5);
        System.out.println(str1 == str5); //false
        System.out.println(str1.equals(str5));  //true

        String str6 = "KWB";
        String str7 = "SY";
        String str8 = str6 + str7;//str6与str7是变量，在运行时才会知道其值。
        System.out.println(str1 == str8);   //false
        System.out.println(str1.equals(str8));  //true

        String str9 = str6 + "SY";//str6是变量，在运行时才会知道其值
        System.out.println(str1 == str9);  //false

        String str10 = "hello" + 10;//"hello10";在编译期间就已经处理为拼接的结果
        String str11 = "hello10";
        System.out.println(str10 == str11); //true
    }

    //字符串在内存当中的存储
    public static void main2(String[] args) {
        String str1 = "KWBSY";
        String str2 = new String("KWBSY");
        System.out.println(str1 == str2);   //false
        System.out.println(str1.equals(str2));  //true
        String str3 = "KWBSY";
        System.out.println(str1 == str3);   //true
        System.out.println(str1.equals(str3));  //true

//        String str3 = str1;
//        System.out.println(str1);
//        System.out.println(str3);
    }

    //字符串的创建
    public static void main1(String[] args) {
        //String创建字符串
        String str = "KWBSY";   //直接赋值
        System.out.println(str);
        String str2 = new String("KWBSY");
        System.out.println(str2);
        //字符数组类型的创建
        char[] chars = {'K', 'W', 'B', 'S', 'Y'};
        String str3 = new String(chars);
        System.out.println(str3);
        //字节数组类型的创建
        byte[] bytes = {97, 98, 99, 100};
        String str4 = new String(bytes);
        System.out.println(str4);
    }
}
