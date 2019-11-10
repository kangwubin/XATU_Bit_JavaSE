package cn.xatu;
//9. 求出0～999之间的所有“水仙花数”并输出。
// (“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本身，如；153＝1＋5＋3?，则153是一个“水仙花数”。)
public class Test9 {
    public static void main(String[] args) {
        int num;
        for (num = 0;num < 1000;num++){
            int sum;
            int tmp = num;
            int a = tmp /100;     //求出百位
            int b = tmp % 100 /10;
            int c = tmp % 100 % 10;
            sum= a * a * a + b * b * b+ c * c * c;
            if (num == sum){
                System.out.println(sum);
            }
        }
    }
}
