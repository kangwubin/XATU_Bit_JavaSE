package 携程笔试0401;

import java.util.*;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/4/1
 * @Time: 20:35
 */
public class Main3 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "surprise");
        map.put(2, "happy");
        map.put(3, "ctrip");
        map.put(4, "travel");
        map.put(5, "wellcome");
        map.put(6, "student");
        map.put(7, "system");
        map.put(8, "program");
        map.put(9, "editor");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                if (input.equals(map.get(entry))) {
                    break;
                } else if (input.equals("hipp")) {
                    System.out.println("happy");
                }
            }
        }
    }
}
