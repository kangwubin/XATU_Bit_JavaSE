package StringTest;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Description:字符、字节与字符串的基本操作
 *
 * @author: KangWuBin
 * @Date: 2019/11/7 17:45
 */
public class TestDemo2 {
    //String与StringBuffer之间的转换
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("KWBSY");
        String s = stringBuffer.toString();
        System.out.println(s);//KWBSY
    }

    public static void main8(String[] args) {
        String str = "KWBSY";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        System.out.println(stringBuffer);//KWBSY
    }

    public static void main7(String[] args) {
        String str = "hello";
        String str2 = "abc";
        String str3 = str + str2;
        System.out.println(str3);//helloabc
        //对String str3 = str + str2的优化操作：
        StringBuilder sb = new StringBuilder();
        sb = sb.append(str).append(str2);
        String str4 = sb.toString();
        System.out.println(str4);//helloabc
    }

    //StringBUffer与StringBuilder的append()用于拼接字符串
    public static void main6(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("abcdef");//StringBuilder适用于单线程
        System.out.println(stringBuilder);//abcdef
        stringBuilder = stringBuilder.append("ghk");
        System.out.println(stringBuilder);//abcdefghk
        StringBuffer stringBuffer = new StringBuffer("KWB");//StringBuffer适用于多线程
        stringBuffer.append("SY");
        System.out.println(stringBuffer);//KWBSY
    }

    //字符串常用方法---拆分与替换
    public static void main5(String[] args) {
        String s = "abcdef";
        String s1 = s.concat("kwb");//concat--字符串拼接，等同于"+",不入池
        System.out.println(s1);//abcdefkwb

        int[] array = {6, 8, 16};
        int len = array.length;//对于数组：length是属性
        System.out.println(len);//3
        int len2 = s.length();//对于字符串，length()是方法
        System.out.println(len2);//6

        String s2 = s.toUpperCase();//转换为大写
        System.out.println(s2);//ABCDEF
        String s3 = s2.toLowerCase();//转换为小写
        System.out.println(s3);//abcdef

        String s4 = s.trim();//返回一个字符串，其值为此字符串，并删除任何前导和尾随空格
        System.out.println(s4);

        String s5 = s.substring(2);//全部截取完毕
        System.out.println(s5);//cdef
        String s6 = s.substring(2, 4);//[2,4)
        System.out.println(s6);//cd

        String str = "192.168*1.1";
        String[] strings = str.split("\\*");//字符串的拆分方法
        System.out.println(Arrays.toString(strings));//[192.168, 1.1]

        String str1 = "#abc def#h ok#pli";
        String[] strings1 = str1.split(" ", 4);//拆分完成以后是多个字符串,limit:最多拆分个数
        System.out.println(Arrays.toString(strings1));//[#abc, def#h, ok#pli]

        String str2 = "#abc def#h ok#pli"; //以特定方式截取
        String[] strings2 = str2.split(" ");
        System.out.println(Arrays.toString(strings2));//[#abc, def#h, ok#pli]
        for (int i = 0; i < strings2.length; i++) {
            String[] strings3 = strings2[i].split("#");
            System.out.println(Arrays.toString(strings3));//[, abc];[def, h];[ok, pli]
        }
    }

    //字符串常用方法---查找与替换
    public static void main4(String[] args) {
        String str = "helloworld";
        boolean flg = str.contains("he");//contains:检查是否包含---true
        System.out.println(flg);
        //indexOf:从头开始查找指定字符串的位置，查到了返回位置的开始索引，如果查不到返回-1
        int index = str.indexOf("wor", 4);//5
        System.out.println(index);
        //lastIndexOf:从后往前找到第一个要找的字符串的下标;下标：从0号位置开始
        int index2 = str.lastIndexOf("l", 9);//8
        System.out.println(index2);
        //从指定位置开始判断，是否以指定字符串开头
        // 是否已参数开头的字符串;下标是包含的
        boolean flg2 = str.startsWith("ow", 4);
        System.out.println(flg2);//true
        //判断是否已指定字符串结尾
        boolean flg3 = str.endsWith("world");
        System.out.println(flg3);//true
        //将所有的第一个参数的字符 替换为第二个参数
        String string = str.replace('l', '6');
        System.out.println(string);//he66owor6d
        String string2 = str.replaceAll("ll", "**");
        System.out.println(string2);//he**oworld
        String string3 = str.replaceFirst("l", "##");
        System.out.println(string3);//he##loworld

    }

    //equals与compareTo方法
    public static void main3(String[] args) {
        String str1 = "abcdef";
        String str2 = "abfdef";
        System.out.println(str1.equals(str2));//false
        System.out.println(str1.equalsIgnoreCase(str2));//false
        /**
         * 如果对应位置相同一直往后走
         * 找到不一样的字符 进行比较
         * str1和str2
         * str1 > str2  >0
         * str1 < str2  <0
         * str1 == str2 =0
         */
        System.out.println(str1.compareTo(str2));//-3
    }

    //字节与字符串
    public static void main2(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = {97, 98, 99, 100, 101};
        System.out.println(Arrays.toString(bytes));//[97, 98, 99, 100, 101]
        //从偏移量1的位置开始的length个字节来构造字符串
        String string = new String(bytes, 1, 3);//bcd
        System.out.println(string);
        //字符串转字节
        String string1 = "abcdef";
        byte[] bytes1 = string1.getBytes();
        System.out.println(Arrays.toString(bytes1));//[97, 98, 99, 100, 101, 102]
        String string2 = "康";
        byte[] bytes2 = string2.getBytes("unicode");
        System.out.println(Arrays.toString(bytes2));//[-2, -1, 94, -73]
    }

    //字符数组和字符串之间的转换
    public static void main1(String[] args) {
        char[] value = {'a', 'b', 'c', 'd', 'e'};
        String str = new String(value);
        System.out.println(str);
        //offset:偏移量;从偏移量offset位置开始的count个字符来构造字符串
        String str2 = new String(value, 1, 4);//bcde
        System.out.println(str2);
        String str3 = "abcdef";
        //charAt输出指定下标的字符
        System.out.println(str3.charAt(3));//d
        //字符串-》数组
        char[] chars = str3.toCharArray();
        System.out.println(Arrays.toString(chars));//[a, b, c, d, e, f]
    }
}
