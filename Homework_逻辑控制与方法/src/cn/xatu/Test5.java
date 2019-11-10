package cn.xatu;
//5. 输出乘法口诀表
public class Test5 {
    public static void main(String[] args){
        System.out.println("乘法口诀表：");
        int i,j;
        for (i=1;i<10;i++){
            for (j=1;j<=i;j++){
                    System.out.print(j+"*"+i+"="+j*i+"\t");
                }
            System.out.println();
            }
        }
    }

