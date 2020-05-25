package 完美世界笔试;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/17
 * @Time: 20:16
 */
public class Price {
    int max = 0;
    int tmp = 0;
    int tmp_pri = 0;

    void maxPrice(int n, int bag, int[] weight, int[] pri, int count) {
        if (count >= n) {
            return;
        }
        if (tmp + weight[count] <= bag) {
            tmp += weight[count];
            tmp_pri += pri[count];
            System.out.println(tmp_pri);
        }
        if (tmp == bag) {
            if (max < pri[count]) {
                max = pri[count];
                tmp -= weight[count];
                tmp_pri -= pri[count];
                return;
            }
            for (int i = count + 1; i < n; i++) {
                maxPrice(n, bag, weight, pri, i);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4,bag = 15;
        int[] weight ={5,3,4,6,};
      /*  Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String str = scanner.nextLine();
            StringBuilder str1 = new StringBuilder(str);
            str1.append(scanner.nextLine());
        }*/

    }
}
