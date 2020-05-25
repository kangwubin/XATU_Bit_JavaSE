package 小米笔试0321;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/21
 * @Time: 18:29
 */
public class Main1 {
    public static class Singleton1 {
        //饿汉
        private static Singleton1 instance = new Singleton1();

        private Singleton1() {
        }

        public static Singleton1 getInstance() {
            return instance;
        }
    }

    //懒汉
    public static class Singleton2 {
        private volatile static Singleton2 instance = null;

        private Singleton2() {
        }

        public static synchronized Singleton2 getInstance() {
            if (null == instance) {
                instance = new Singleton2();
            }
            return instance;
        }
    }
}
