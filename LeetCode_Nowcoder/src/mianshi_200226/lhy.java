package mianshi_200226;

import java.util.*;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/2/27
 * @Time: 19:33
 */
class Composition extends ArrayList<Integer> {
    @Override
    public boolean equals(Object other) {
        Composition comp = (Composition) other;
        Collections.sort(this);
        Collections.sort(comp);
        if (this.isEmpty() || comp.isEmpty() || this.size() != comp.size())
            return false;
        for (int i = 0; i < this.size(); i++)
            if (this.get(i) != comp.get(i))
                return false;
        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}

public class lhy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(toStr(calc(n)));
    }

    public static Set<Composition> calc(int n) {
        Set<Composition> possibility = new HashSet<Composition>();
        Composition composition = new Composition();
        switch (n) {
            case 1:
                composition.add(1);
                possibility.add(composition);
                return possibility;
            case 2:
                composition.add(1);
                composition.add(1);
                possibility.add(composition);
                return possibility;
            default:
                for (int i = 1; i <= n / 2; i++) {
                    composition = new Composition();
                    composition.add(i);
                    composition.add(n - i);
                    possibility.add(composition);
                    if (i <= n - i) {
                        Set<Composition> partial_pos = calc(n - i);
                        for (Composition pos : partial_pos) {
                            pos.add(i);
                            possibility.add(pos);
                        }
                    }
                }
                return possibility;
        }

    }

    public static String toStr(Set<Composition> possibility) {
        String str = "total : " + possibility.size() + "\n";
        for (Composition pos : possibility)
            str += toStr(pos);
        return str;
    }

    public static String toStr(Composition composition) {
        String str = composition.get(0) + "";
        for (int i = 1; i < composition.size(); i++)
            str += (" + " + composition.get(i));
        str += "\n";
        return str;
    }
}
