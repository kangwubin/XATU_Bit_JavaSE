package cn.SeqList;


import java.util.Arrays;

class MyArrayList {
        //属性
        private int[] elem;
        private int usedSize;
        private final int CAPACITY = 10;
        public MyArrayList() {
            this.elem = new int[CAPACITY];
            this.usedSize = 0;
        }

        // 打印顺序表
        public void display() {
            for (int i = 0; i < this.usedSize; i++) {
                System.out.print(this.elem[i] + " ");
            }
            System.out.println();
        }

        //判断是否满了
        private boolean isFull() {
            if(this.usedSize == this.elem.length) {
                return true;
            }
            return false;
//            return this.usedSize == this.elem.length;
        }

        // 在 pos 位置新增元素
        public void add(int pos, int data) {
            //判断合法性
            if (pos < 0 || pos > usedSize){
                return;
            }
            if(isFull()) {
                //扩容
                this.elem = Arrays.copyOf(this.elem,this.elem.length * 2);
            }
            //1、移动元素
            for (int i = usedSize - 1; i >= pos;i--) {
                this.elem[i + 1] = this.elem[i];
            }
            //2、插入
            this.elem[pos] = data;
            this.usedSize++;
        }

        // 判定是否包含某个元素
        public boolean contains(int toFind) {
            for (int i = 0; i < this.usedSize; i++) {
                if (this.elem[i] == toFind){
                    return true;
                }
            }
            return false;
        }

        // 查找某个元素对应的位置
        public int search(int toFind) {
            for (int i = 0; i < this.usedSize; i++) {
                if (this.elem[i] == toFind){
                    return i;
                }
            }
            return -1;
        }

        // 获取 pos 位置的元素
        public int getPos(int pos) {
            if (pos < 0 || pos > this.usedSize){
                return -1;
            }
            return this.elem[pos];
        }

        // 给 pos 位置的元素设为 value
        public void setPos(int pos, int value) {

        }

        //删除第一次出现的关键字key
        public void remove(int toRemove) {
            //1.找到是否有要删除的元素
            int pos = search(toRemove);
            if (pos == -1){
                return;
            }
            if (pos == this.usedSize - 1){
                this.usedSize--;
                return;     //代表方法的结束
            }
            //2.从后往前赋值操作
            for (int i = pos; i < usedSize - 1; i++) {
                this.elem[i] = this.elem[i + 1];
            }
            usedSize--;
        }

        // 获取顺序表有效长度
        public int size() {
            return this.usedSize;
        }

        // 清空顺序表
        public void clear() {
            this.usedSize = 0;
        }
    }

