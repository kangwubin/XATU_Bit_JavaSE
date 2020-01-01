package UseMapSet;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/1/1
 * @Time: 22:22
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Hello");
        //当key重复时，后面的key所对应的value会把前面的key的value覆盖；
        map.put(1, "World");
        map.put(2, "java");
        map.put(3, "XATU");
        System.out.println(map);    // {1=World, 2=java, 3=XATU}
        //根据key获得value
        System.out.println(map.get(2));
        //根据key查找value，找不到会返回null
        System.out.println(map.get(18));    // null
        // map.getOrDefault()---返回key对应的value，key 不存在，返回默认值
        //判断是否包含key
        System.out.println(map.containsKey(1));
        //判断是否包含value
        System.out.println(map.containsValue("java"));
        //删除key对应的映射关系
        System.out.println(map.remove(1,"Hello"));
        //打印所有的Key---keySet()
        for (Integer key : map.keySet()) {
            System.out.println(key);    //1,2,3
        }
        //打印所有的value---map.values()
        for (String value : map.values()) {
            System.out.println(value);  //World,java,XATU
        }
        //按 key-value 映射关系打印;Entry是静态内部类；
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}