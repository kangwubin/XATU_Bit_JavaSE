package NowCoder_String;

import java.util.Scanner;

/**
 * Description:输入一个字符串，求出该字符串包含的字符集合;
 * 输入：每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。
 * 输出：每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。
 * 示例;输入:abcqweracb------输出:abcqwer
 *
 * @author: KangWuBin
 * @Date: 2019/11/18
 * @Time: 16:32
 */
public class StringContains {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNext()) {
            String str = scanner.next();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);//将字符串转化为字符
//                System.out.print(ch);
                //刚开始stringBuilder是空的，会添加元素，到添加以后，如果再添加，
                // 出现包含的元素，就不会把元素插入到StringBuilder里面了
                if (!stringBuilder.toString().contains(ch + "")) {
                    stringBuilder.append(ch);
                }
                System.out.println(stringBuilder.toString());
            }
        }
    }
}
