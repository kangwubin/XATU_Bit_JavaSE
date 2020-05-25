package 小米笔试0321;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/21
 * @Time: 18:40
 */
public class BinaryFind {
    public static int binarrySearch(int[] arcArray, int des) {
        int low = 0;
        int high = arcArray.length - 1;
//        int mid = (low + high) / 2;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
//            int mid = (low + high) / 2;
            if (des == arcArray[mid]) {
                return mid;
            } else if (des < arcArray[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
