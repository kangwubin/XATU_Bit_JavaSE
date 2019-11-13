package Collection_Map;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/12
 * @Time: 19:54
 */

import java.util.Arrays;

/**
 * 泛型类   泛型方法
 * <T>--> T:->占位符-》当前类是泛型类
 */
class MyArrayList2<T> {
    public T[] elem;
    public int usedSize;

    public MyArrayList2() {
        //this.elem = new T[10];
        //坑：不能new一个泛型类型的数组
        this.elem = (T[]) new Object[10];
        this.usedSize = 0;
    }

    public void add(T data) {
        this.elem[this.usedSize] = data;
        this.usedSize++;
    }

    public T getPos(int pos) {
        return this.elem[pos];
    }

    @Override
    public String toString() {
        return "MyArrayList2{" +
                "elem=" + Arrays.toString(elem) +
                ", usedSize=" + usedSize +
                '}';
    }
}

/**
 * 泛型的意义：
 * 1、自动进行类型的检查:注意-》并不是进行类型的替换
 * 只是拿着你给的类型  进行检查
 * 2、自动进行类型的强制类型转换
 * 泛型到底是怎么编译的？
 * 擦除机制-》擦除成什么了？->Object
 * 泛型  不参与类型的组成
 * 坑：
 * 1、new T[]
 * 2、简单类型 不能作为泛型的参数
 */
public class TestDemo3 {
    public static void main(String[] args) {
        MyArrayList2<String> myArrayList2 = new MyArrayList2<>();
        myArrayList2.add("KWB");
        System.out.println(myArrayList2);
        MyArrayList2<Integer> myArrayList4 = new MyArrayList2<>();
        myArrayList4.add(10);
        MyArrayList2<Character> myArrayList5 = new MyArrayList2<>();
    }

    public static void main1(String[] args) {
        // MyArrayList2<String>--表示只能添加String类型
        MyArrayList2<String> myArrayList2 = new MyArrayList2<>();
        myArrayList2.add("KWB");
        myArrayList2.add("java");
        String str = myArrayList2.getPos(1);
        System.out.println(str);//java
    }
}
