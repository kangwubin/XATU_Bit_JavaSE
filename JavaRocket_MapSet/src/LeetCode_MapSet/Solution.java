package LeetCode_MapSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:map与set的基础面试题
 *
 * @author: KangWuBin
 * @Date: 2019/12/3
 * @Time: 9:40
 */
public class Solution {
    /*1.给定一个非空整数数组，除了某个元素只出现一次以外，
     *其余每个元素均出现两次。找出那个只出现了一次的元素。*/
    //使用异或
    public int singleNumber1(int[] nums) {
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp ^= nums[i];
        }
        System.out.println(tmp);
        return tmp;
    }

    //使用集合
    public int singleNumber2(int[] nums) {
        //set的核心操作：判定key是否存在(集合)，key不能重复 .
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }

    /* 3.给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
     * S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     * 输入: J = "aA", S = "aAAbbbb";输出: 3;
     * 输入: J = "z", S = "ZZ";输出: 0;
     */
    public int numJewelsInStones(String J, String S) {
        // 1. 创建一个 Set 来保存所有的宝石
        Set<Character> set = new HashSet<>();
        // 2. 遍历 J , 把所有的宝石加入到 Set 中.
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        // 3. 遍历 S, 取出每个字符, 看看是不是宝石;
        //   如果是宝石, 就 count += 1
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
