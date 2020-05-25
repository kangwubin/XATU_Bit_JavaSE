package day26_200109;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * Description:实现一个简易的投票选举；
 *
 * @author: KangWuBin
 * @Date: 2020/1/9
 * @Time: 21:25
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //输入的候选人数
            int n = scanner.nextInt();
            String[] strings = new String[n];
            //将输入的候选人数存入map中
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                //输入字符串
                String tmp = scanner.next();
                hashMap.put(tmp, 0);
                strings[i] = tmp;
            }
            int m = scanner.nextInt();
            Set<String> keys = hashMap.keySet();
            int count = 0;
            for (int i = 0; i < m; i++) {
                String tick = scanner.next();
                if (keys.contains(tick)) {
                    hashMap.put(tick, hashMap.get(tick) + 1);//为什么要+1呢？
                } else {
                    count++;
                }
            }
            for (String k : strings) {
                System.out.println(k + " : " + hashMap.get(k));
            }
            System.out.println("Invalid : " + count);
        }
    }
}
