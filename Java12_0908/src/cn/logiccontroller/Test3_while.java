package cn.logiccontroller;

public class Test3_while {
    public static void main(String[] args){
        int n=1;
        int result=0;
        while (n<=100){
            result +=n;
            n++;
        }
        System.out.println(result);
    }
}
