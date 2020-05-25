package day12_191223;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/23
 * @Time: 15:52
 */
public class Exchange {
    /* 请编写一个函数，函数内部不使用任何临时变量，直接交换两个数的值；
     * 给定一个int数组AB,其第零个元素和第一个元素为待交换的值，请返回交换后的数组；
     * 样例：输出[1,2];输出[2,1]*/
    public int[] exchangeAB1(int[] AB) {
        int tmp = AB[0];
        AB[0] = AB[1];
        AB[1] = tmp;
        return AB;
    }

    /* 采用异或的思想：面试：(++++++++)
     * java中一个数如果异或同一个数两次，那么得到的还是原来的数；*/
    public int[] exchangeAB2(int[] AB) {
        AB[0] = AB[0] ^ AB[1];
        AB[1] = AB[0] ^ AB[1];
        AB[0] = AB[0] ^ AB[1];
        return AB;
    }

}
