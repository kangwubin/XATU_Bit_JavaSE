package day41_200306;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/7
 * @Time: 19:56
 */
public class Main2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] str_char = str.split(";");
            int x = 0;
            int y = 0;
            for (int i = 0; i < str_char.length; i++) {
                if (str_char[i].length() < 2)
                    continue;
                String reg = "^\\d+$";
                String move_type = str_char[i].substring(0, 1);
                String move_dis = str_char[i].substring(1, str_char[i].length());
                if (move_dis.matches(reg)) {
                    int move_num = Integer.parseInt(move_dis);
                    switch (move_type) {
                        case "W":
                            y += move_num;
                            break;
                        case "A":
                            x -= move_num;
                            break;
                        case "S":
                            y -= move_num;
                            break;
                        case "D":
                            x += move_num;
                            break;
                    }
                } else {
                    continue;
                }
            }
            System.out.println(x + "," + y);

        }
    }
}
