package 美团笔试;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/12
 * @Time: 19:39
 */
public class Main1 {
        private int count = 0; //

        /*	n:列数  a:两行数据   x，y：当前坐标 */
        private void nextStep(int n, char a[][], int x, int y) {
            if(y < 0 || y > n-1 || x < 0 || x > 1) //是否越界
                return;
            if(a[x][y] == '1') //如果是障碍物，回溯
                return;
            else if(a[0][1] == '.' && x == 1 && y == n-1) {	//到达终点，count+1
                count++;
                return;
            }
            nextStep(n, a, x, y+1); //向右移动
            nextStep(n, a, x-1, y+1); //向右上移动
            nextStep(n, a, x+1, y+1); //向右下移动
        }

        public int reachCount(int n, char nums[][]) {
            nextStep(n, nums, 0, 0);
            if (count==0){
                count=-1;
            }
            return count;
        }

        private void reset() {
            count = 0;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Main1 count = new Main1();
            while (scanner.hasNext()) {
                count.reset();
                int n = scanner.nextInt();
                scanner.nextLine();
                char num1[] = scanner.nextLine().toCharArray();
                char num2[] = scanner.nextLine().toCharArray();
                char num[][] = {num1, num2};
                System.out.println(count.reachCount(n, num));
            }
            scanner.close();
        }
    }
