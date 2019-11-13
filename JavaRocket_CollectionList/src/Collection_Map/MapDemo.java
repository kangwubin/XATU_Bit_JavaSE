package Collection_Map;


import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/11
 * @Time: 20:02
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        map.put("首都", "北京");
        map.put("魔都", "上海");
        map.put("古都", "西安");
        map.put("花都", "杭州");
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        String str = map.get("古都");
        System.out.println(str);
        boolean flg = map.containsKey("魔都");
        System.out.println(flg);
        flg = map.containsValue("西安");
        System.out.println(flg);
    }
}
