package List20191112;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description:一个List存放整形数据，对其进行排序。
 *
 * @author: KangWuBin
 * @Date: 2019/11/12
 * @Time: 10:55
 */
public class ListInteger {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(101);
        integerList.add(102);
        integerList.add(98);
        integerList.add(96);
        integerList.add(100);
        System.out.println("------排序前-----");
        for (Integer integer_val : integerList) {
            System.out.print(integer_val + " ");
        }

        System.out.println("------排序后-----");
        Collections.sort(integerList);//Collections操作集合的工具类
        for (Integer integer_val : integerList) {
            System.out.print(integer_val + " ");
        }
    }
}
