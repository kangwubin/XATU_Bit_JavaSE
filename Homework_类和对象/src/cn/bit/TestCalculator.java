package cn.bit;

public class TestCalculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        double res1=calculator.sum(40,500);
        double res2=calculator.sub(40,500);
        double res3=calculator.mul(40,500);
        double res4=calculator.div(147,5);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
//        Calculator calculator = new Calculator();
//        System.out.println("请输入数字：1代表加，2代表减，3代表乘，4代表除");
//        Scanner sc=new Scanner(System.in);
//       while (true){
//           int input=sc.nextInt();
//           int x=sc.nextInt();
//           int y=sc.nextInt();
//            switch (input){
//                case 1:
//                    System.out.println("加法运算");
//                    calculator.sum(x,y);
//                    break;
//                case 2:
//                    System.out.println("减法运算");
//                    calculator.sub(x,y);
//                    break;
//                case 3:
//                    System.out.println("乘法运算");
//                    calculator.mul(x,y);
//                    break;
//                case 4:
//                    System.out.println("除法运算");
//                    calculator.div(x,y);
//                    break;
//                default:
//                    System.out.println("输入有误");
//                    break;
//            }
//        }
    }
}
