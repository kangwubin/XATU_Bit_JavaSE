package ArrayTest;

//二维数组每一行每一列均为递增，查找指定数字（第一次出现的）
public class ArraySecond {
    public static int[] fnid_val(int[][] arr, int row, int col, int num) {
        // 参数有效性检查
        if (arr == null || row < 0 || col < 0) {
            System.out.println("数据错误");
            return null;
        }
        int i = 0;  //i==row
        int j = col - 1;
        while (i < row && j >= 0) {
            if (arr[i][j] > num) {
                j--;
            } else if (arr[i][j] < num) {
                i++;
            } else {
                String ret = "[" + i + "]" + "[" + j + "]";
                System.out.println(ret);
                break;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        fnid_val(arr, 4, 4, 12);
    }
}
