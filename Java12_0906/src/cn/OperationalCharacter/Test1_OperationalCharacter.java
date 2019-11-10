package cn.OperationalCharacter;

public class Test1_OperationalCharacter {
    public static void main(String[] args){
        //int / int 结果还是 int, 需要使用 double 来计算
        //0 不能作为除数
        //% 表示取余, 不仅仅可以对 int 求模, 也能对 double 来求模
        //增量赋值运算符 += -= *= /= %=
        int a=10;
        a +=1;  //等价于：a=a+1
        System.out.println(a);

        //自增/自减运算符 ++ --
        //1. 如果不取自增运算的表达式的返回值, 则前置自增和后置自增没有区别.
        //2. 如果取表达式的返回值, 则前置自增的返回值是自增之后的值, 后置自增的返回值是自增之前的值
        int a1 = 10;
        int b1 = ++a1;
        System.out.println(b1);
        int c1 = a1++;
        System.out.println(c1);

        //关系运算符返回的都是boolean类型的值

        //逻辑运算符 &&  ||  !
        //逻辑与 &&   规则: 两个操作数都为 true, 结果为 true, 否则结果为 false.
        //逻辑或 ||   规则: 两个操作数都为 false, 结果为 false, 否则结果为 true
        //逻辑非 !    规则: 操作数为 true, 结果为 false; 操作数为 false, 结果为 true(这是个单目运算符, 只有一个操作数).
        int a2=10;
        int b2=20;
        int c2=30;
        System.out.println(a2<b2 && b2<c2);
        System.out.println(a2>b2 || b2>c2);

        //短路求值
        //1. 对于 && , 如果左侧表达式值为 false, 则表达式的整体的值一定是 false, 无需计算右侧表达式.
        //2. 对于 ||, 如果左侧表达式值为 true, 则表达式的整体的值一定是 true, 无需计算右侧表达式.
        System.out.println(10 > 20 && 10 / 0==0);
        System.out.println(10 < 20 || 10 / 0==0);

        //& 和 | 如果操作数为 boolean 的时候, 也表示逻辑运算. 但是和 && 以及 || 相比, 它们不支持短路求值.
          //System.out.println(10 > 20 & 10 / 0==0);
          //System.out.println(10 < 20 | 10 / 0==0);

        //位运算符
        //按位与 &: 如果两个二进制位都是 1, 则结果为 1, 否则结果为 0.(同1为1)
        //按位或 |: 如果两个二进制位都是 0, 则结果为 0, 否则结果为 1.（同0为0）
        //按位异或 ^: 如果两个数字的二进制位相同, 则结果为 0, 相异则结果为 1.（相同为0，相异为1）
        //注意: 当 & 和 | 的操作数为整数(int, short, long, byte) 的时候, 表示按位运算, 当操作数为 boolean 的时候, 表示逻辑运算.
        //注意:
        //1. 0x 前缀的数字为 十六进制 数字. 十六进制可以看成是二进制的简化表示方式. 一个十六进制数字对应 4 个二进制位.
        //2. 0xf 表示 10 进制的 15, 也就是二进制的 1111
        //3. printf 能够格式化输出内容, %x 表示按照十六进制输出.
        //4. \n 表示换行符
        int a3=10;
        int b3=20;
        System.out.println(a3 & b3);
        System.out.println(a3 | b3);
        System.out.println(a3 ^ b3);

        //左移 <<: 最左侧位不要了, 最右侧补 0.
        int a4 = 0x10;
        System.out.printf("%x\n", a4 << 1);
        //右移 >>: 最右侧位不要了, 最左侧补符号位(正数补0, 负数补1)
        int a5 = 0x10;
        System.out.printf("%x\n", a5 >> 1);
        //无符号右移 >>>: 最右侧位不要了, 最左侧补 0.
        //注意:
        //1. 左移 1 位, 相当于原数字 * 2. 左移 N 位, 相当于原数字 * 2 的N次方.
        //2. 右移 1 位, 相当于原数字 / 2. 右移 N 位, 相当于原数字 / 2 的N次方.
        //3. 由于计算机计算移位效率高于计算乘除, 当某个代码正好乘除 2 的N次方的时候可以用移位运算代替.
        //4. 移动负数位或者移位位数过大都没有意义.

        //条件运算符
        //条件运算符只有一个:表达式1 ? 表达式2 : 表达式3
        //当表达式1的值为true时, 整个表达式的值为表达式2的值; 当表达式1的值为false时, 整个表达式的值为表达式3的值.
        int a6=10;
        int a7=20;
        int max=a6 > a7 ? a6 : a7;
        System.out.println(max);
    }
}
