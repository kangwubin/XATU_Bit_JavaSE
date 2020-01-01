package UseMapSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/1/1
 * @Time: 22:53
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        //add---添加元素，但重复元素不会被添加成功;
        hashSet.add("Hello");
        //重复元素
        hashSet.add("Hello");
        hashSet.add("XATU");
        hashSet.add("Hello");
        hashSet.add("java");
        System.out.println(hashSet);
        //使用迭代器遍历集合
        /* Iterator是一个特殊的类，Iterable是一个接口，表示可迭代的；
         * 必须要针对一个可迭代的对象(实现Iterable接口的对象)才能使用迭代器来遍历；
         * for-each：可迭代对象才能使用 (for-each)*/
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
