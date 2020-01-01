package HashBuck;

import java.util.Objects;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/12/5
 * @Time: 20:55
 */
class Person {
    String id;//学号

    public Person(String id) {
        this.id = id;
    }

    /*面试问题：
     * 1.为什么要重写hashCode和equals？---自定义引用类型比较相等。*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

class HashBuck2<K, V> {
    static class Node<K, V> {
        K key;
        V val;
        Node<K, V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node<K, V>[] array;

    public HashBuck2() {
        this.array = (Node<K, V>[]) new Node[8];
    }

    public void push(K key, V val) {
        int hash = key.hashCode();
        int index = hash % array.length;

    }
}

public class TestPerson {
    public static void main(String[] args) {
//        HashBuck2<Person, String> hashBuck2 = new HashBuck2<>();
        Person person1 = new Person("160601");
        Person person2 = new Person("160601");
        System.out.println(person1.hashCode());//重写hashCode和equals后才是相同的。---1454181963
        System.out.println(person2.hashCode());//1454181963
    }
}
