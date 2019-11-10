package cn.xatu;
//节点类
class LinkedNode{
    public int data=0;
    public LinkedNode next=null;

    public LinkedNode(int data) {
        this.data = data;
    }
}

//链表类
public class SingleLinkedList {
    private LinkedNode  head=null;
    //头插法
    public void addFirst(int elem){
        //创建节点
        LinkedNode node = new LinkedNode(elem);
        //判断头节点是否为空
        if(this.head==null){
            this.head=node;
            return;
        }
        //如果不是空节点，就需要把新的节点放到链表的开始位置
        node.next=head;
        this.head=node;
        return;
    }

    //尾插
    public void addLast(int elem){
        //创建节点
        LinkedNode node=new LinkedNode(elem);
        //判断头节点是否为空
        if (this.head == null){
            this.head=node;
            return;
        }
        //头节点不为空，需要先找到最后一个元素
        //创建当前节点
        LinkedNode cur=this.head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next=node;
    }

    //任意位置插入,第一个数据节点为0号下标
    public  void  addIndex(int index,int elem){
        //创建节点
        LinkedNode node=new LinkedNode(elem);
        //进行合法校验，验证插入是否合法
        int len=size();
        if (index < 0 || index > len){
            return;
        }
        //处理头插
        if (index==0){
            addFirst(elem);
            return;
        }
        //处理尾插
        if (index==len){
            addLast(elem);
            return;
        }
        //插入到中间位置，当要插入到index位置时，需要找到index-1的位置
        //prev这个引用就对应index-1的位置
        LinkedNode prev=getIndexPos(index - 1);
//        prev.next=prev.next.next;
        node.next=prev.next;
        prev.next=node;
    }

    //get index位置
    private LinkedNode getIndexPos(int index){
        //cur指向当前头节点
        LinkedNode cur=this.head;
        //通过循环遍历index，更新cur
        for (int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur;
    }

    //获取链表的长度
    public int size(){
        int size=0;
        for (LinkedNode cur=this.head;cur != null;cur=cur.next){
            size++;
        }
        return size;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int toFind){
        for (LinkedNode cur=this.head;cur!=null;cur=cur.next){
            if (cur.data==toFind){
                return true;
            }
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int toRemove){
        //判断是否为空链表
        if (head==null){
            return;
        }
        //判断要删除的是否是头节点
        if (head.data==toRemove){
            this.head=this.head.next;
            return;
        }
        //删除中间节点，需要找到要删除节点的前一个元素
        LinkedNode prev=searchPrev(toRemove);
        prev.next=prev.next.next;
    }

    private LinkedNode searchPrev(int toRemove){
        //判断是否为空
        if (this.head==null){
            return null;
        }
        //从头开始循环遍历
        LinkedNode prev=this.head;
        while (prev.next != null){
            if (prev.next.data==toRemove){
                return prev;
            }
            prev=prev.next;
        }
        return null;  //表示没有找到
    }

    //打印链表中所有的元素
    public void display(){
        System.out.print("[");
        //循环遍历节点
        for (LinkedNode node=this.head;node!=null;node=node.next){
            System.out.print(node.data);
            //node.next不为空，就加上，
            if (node.next != null){
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

}