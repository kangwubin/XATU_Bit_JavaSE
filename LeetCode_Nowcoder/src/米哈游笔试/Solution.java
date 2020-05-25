package 米哈游笔试;


/**
 * Description:不想交的线
 *
 * @author: KangWuBin
 * @Date: 2020/3/13
 * @Time: 19:23
 */
public class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        // write code here
        int len1 = A.length;
        int len2 = B.length;
        int[][] array = new int[len1+1][len2+1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (A[i] == B[j]) {
                    array[i + 1][j + 1] = array[i][j] + 1;
                } else {
                    array[i + 1][j + 1] = Math.max(array[i + 1][j], array[i][j + 1]);
                }
            }
        }
        return array[len1][len2];
    }
}
