package day18_191230;

/**
 * Description:有一天，一位百万富翁遇到一个陌生人，陌生人找他谈一个换钱的计划，
 * 陌生人对百万富翁说：“我每天给你10万元，而你第一天只需给我1分钱，第二天我给你10万元，你给我2分钱，
 * 第三天我仍给你10万元，你给我4分钱，……。你每天给我的钱是前一天的2倍，直到满一个月（30天）为止”，
 * 百万富翁很高兴，欣然接受了这个契约。请编程计算在这一个月中陌生人总计给百万富翁多少钱，百万富翁总计给陌生人多少钱。
 *
 * @author: KangWuBin
 * @Date: 2019/12/30
 * @Time: 9:40
 */
public class Main2 {
    public static void main(String[] args) {
        //strange是陌生人，rich是有钱人，strange每天给rich 10万元，rich第一天给1分，第二天给2分
        int strange = 0;
        int rich = 0;
        strange = 10 * 30;
        //2^0=1; 2^1=2; 2^2=4; 2^3=8;
        rich = (int) (Math.pow(2, 30) - 1);//为什么第三天给4分钱呢？为什么(-1)呢？
        System.out.println(strange + " " + rich);
    }

    public static void main1(String[] args) {
        long sumRich = 0;
        long sumPoor = 0;
        for (int i = 1; i <= 30; i++) {
            sumRich = sumRich + 10;
            sumPoor = sumPoor + (long) Math.pow(2, i - 1);
        }
        System.out.println(sumRich + "万元  " + sumPoor + "分");
    }
}
