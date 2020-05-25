package 山大地纬笔试;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/17
 * @Time: 21:22
 */
public class Demo4 {
    public static void main(String[] args) {
        int arr[] = {2, 8, 6, 4};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j + 1] = arr[j];
//                    arr[j] = temp;
                }
            }
        }
        for (int k = 0; k < arr.length; k++) {
            System.out.println(arr[k]);
        }
    }
}
