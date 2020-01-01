package HashBuck;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/5
 * @Time: 20:50
 */
public class Test {
    public static void main(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.put(1,66);
        hashBuck.put(11,88);
        hashBuck.put(4,400);
        hashBuck.put(26,900);
        hashBuck.put(21,8888);
        int ret = hashBuck.get(21);
        System.out.println(ret);
    }
}
