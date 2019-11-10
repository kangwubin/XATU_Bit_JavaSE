package cn.xatu;
//3. 打印 1 - 100 之间所有的素数
public class Test3 {
    public static void main(String[] args){
        int i,j;
        for (i = 1;i <= 100;i++){
            for (j = 2;j <= i - 1;j++){
                if (i % j == 0){
                    break;
                }
                if (j == i){
                    System.out.print(i);
                }
            }
        }
    }
}
