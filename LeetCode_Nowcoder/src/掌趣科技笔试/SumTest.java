package 掌趣科技笔试;

public class SumTest {
    //找出 差别最小的差值
    private static void func(int[] array, int toFind) {
        //初始指针指向左右 初始值指向左右的数字
        int left = 0, right = array.length - 1;
        int resLeft = array[0], resRight = array[array.length - 1];
        //初始化最小差值
        int mid = Math.abs(resLeft + resRight - toFind);
        //分别向左右遍历整个数组
        while (left < array.length && right >= 0) {
            int curSum = array[left] + array[right];
            //如果差别更小---更新左右数字
            if (Math.abs(curSum - toFind) < mid) {
                resLeft = array[left];
                resRight = array[right];
            }
            if (curSum == toFind) {
                break;
            } else if (curSum < toFind) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(resLeft + ":" + resRight);
    }

    public static void main(String[] args) {
        int array[] = {1, 3, 6, 8, 14, 23, 56, 99, 122, 178};
        SumTest.func(array, 107);
    }
}
