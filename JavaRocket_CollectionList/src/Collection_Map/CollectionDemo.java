package Collection_Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/11
 * @Time: 19:52
 */
public class CollectionDemo {
    public static void main(String[] args) {
        //<String>-->表示泛型，泛型的类型不能为简单类型
        Collection<String> arrayList = new ArrayList<>();
        System.out.println(arrayList.size());
        System.out.println(arrayList.isEmpty());
        arrayList.add("X");
        arrayList.add("A");
        arrayList.add("T");
        arrayList.add("U");
        System.out.println(arrayList.size());
        System.out.println(arrayList.isEmpty());
        //
        Object[] o = arrayList.toArray();
        System.out.println(Arrays.toString(o));
    }
}
