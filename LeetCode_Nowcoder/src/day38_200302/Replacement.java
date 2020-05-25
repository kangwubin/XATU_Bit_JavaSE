package day38_200302;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/5
 * @Time: 0:23
 */
public class Replacement {
    public String replaceSpace(String iniString, int length) {
        String newIniString = iniString.replaceAll(" ", "%20");
        for (int i = 0; i < newIniString.length(); i++) {
            length = newIniString.length();
        }
        return newIniString;
    }
}
