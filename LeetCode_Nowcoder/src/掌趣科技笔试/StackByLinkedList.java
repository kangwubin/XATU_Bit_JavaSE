package 掌趣科技笔试;

public class StackByLinkedList {
    //头节点
    public Node firstHead;

    public void insert(Object data) {
        Node node = new Node();
        node.setData(data);
        if (firstHead == null) {
            node.nextNode = null;
        } else {
            node.nextNode = firstHead;
        }
        firstHead = node; //新加入的节点为head节点
    }


    public Object find(Object data) {
        if (firstHead == null) {
            throw new NullPointerException("链表为空");
        }
        Node temp = firstHead;
        while (temp != null) {
            if (temp.data.equals(data)) {
                return temp.data;
            }
            temp = temp.nextNode;
        }
        return null;
    }

    public void remove(Object data) {
        if (firstHead == null) {
            throw new NullPointerException("链表为空");
        }
        if (firstHead.data.equals(data)) {//如果刚好是第一个节点
            //指针直接指向第二个节点
            firstHead = firstHead.nextNode;
        } else {
            //当前结点为下一个节点
            Node curr = firstHead.nextNode;
            //前一个节点
            Node pre = firstHead;
            while (curr != null) {
                if (curr.data.equals(data)) { //如果就是当前结点
                    pre.nextNode = curr.nextNode;
                    return;
                } else {
                    pre = curr;
                    curr = curr.nextNode;
                }
            }
        }
    }

    //定义链表中的节点
    public class Node {
        //下一个节点
        private Node nextNode;
        //存放的数据
        private Object data;

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }
}

