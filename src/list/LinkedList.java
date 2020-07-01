package list;

/**
 * DataStructure
 * 链表的实现与相关算法
 *
 * @author : stc
 * @date : 2020-06-25 23:03
 **/
public class LinkedList<E> {
    private Node<E> head;  //链表表头
    private int size;  //链表长度

    public LinkedList(){
        head = new Node<E>(null);
        size = 0;
    }
    public Node<E> getHead(){
        return head;
    }

    /*
    尾部插入元素
     */

    public boolean addTail(E data){
        Node addNode = new Node(data);
        Node pointer = getHead();
        for (int i =0;i<size;i++){
            pointer = pointer.next;
        }
        if (pointer.next == null){
        pointer.next = addNode;
        size++;
        return true;
        }
        else
            return false;
    }

    /*
    头部插入元素
     */
    public boolean addHead(E data){
        Node addNode = new Node(data);
        Node pointer = getHead();
        if (pointer.next == null){
            pointer.next = addNode;
            size++;
            return true;
        }
        else {
            addNode.next = pointer.next;
            pointer.next = addNode;
            size++;
            return true;
        }
    }
    /*
    返回下标元素
     */
    public Node<E> index(int index){
        if (index>size || index<0){
            throw new RuntimeException("下标越界啦！");
        }
        Node pointer = getHead().next;
        for(int i =0;i<index;i++){
            pointer = pointer.next;
        }
        return pointer;
    }

    /*
    判空
     */
    public boolean isEmpty(){
        return (this.head.next==null);
    }

    /*
    链表输出
     */
    public void print(){
        Node pointer = getHead().next;
        while (pointer!=null){
            System.out.print(pointer.data+" ");
            pointer = pointer.next;
        }
        System.out.println();
    }

    /*
    链表长度
     */
    public int size(){
        return size;
    }

    /*
    删除指定下标元素
     */
    public E remove(int index){
        if (index>size-1 || index<0){
            throw new RuntimeException("下标越界啦！");
        }
        Node pointer = getHead();
        for (int i = 0 ; i<index;i++){
            pointer = pointer.next;
        }
        Node<E> temp = pointer.next;
        pointer.next = temp.next;
        temp.next = null;

        size--;
        return temp.data;
    }

    /*
    删除链表重复节点
    时间复杂度O(n^2)
     */
    public void removeDuplicateNodes(){
        Node<E> pointerOuter = getHead().next;
        Node<E> pointerInner;
        while (pointerOuter.next!=null){  //外层控制本层循环用来确定本层循环和谁相等
            pointerInner = pointerOuter;
            while (pointerInner!=null && pointerInner.next!=null){//内层循环控制和外层之后的数据进行比较，相同的删除
                if (pointerOuter.data.equals(pointerInner.next.data)) {
                    Node<E> duplicateNode = pointerInner.next;
                    pointerInner.next = duplicateNode.next;
                    duplicateNode.next=null;
                    size--;
                }
                pointerInner = pointerInner.next;
            }
            pointerOuter = pointerOuter.next;
        }
    }
    /*
    找出倒数第K个元素
     */
    public Node<E> getEndK(int k){// 一个指针先走k-1步 这样两个指针中间的步数差就是size-k+1也就是倒数第K个了
        if (k>size || k<=0){
            throw new RuntimeException("下标越界啦！");
        }
        Node<E> pointerPre = getHead().next;
        Node<E> pointerPost = getHead().next;
        for (int i = 1 ;i<k;i++){
            pointerPre = pointerPre.next;
        }

        while(pointerPre.next!=null){
            pointerPre = pointerPre.next;
            pointerPost = pointerPost.next;
        }
        return pointerPost;
    }

    /*
    反转链表
    等于说用了个头插法
     */

    public void reverseLinkedList(){
        Node<E> pointer = getHead().next;
        Node<E> revList = null;
        while (pointer!=null){
            Node<E> next = pointer.next;
            pointer.next = revList;
            revList = pointer;
            pointer = next;
        }
        head.next = revList;
    }

    /*
    从尾到头输出链表
    递归
     */
    public void reversePrint(Node<E> head) {
        if (head.next != null) {
            reversePrint(head.next);
        }
        if (head.data != null) {
            System.out.print(head.data + " ");
        }
    }

    /*
    寻找链表的中间节点
    一个走2步一个走1步
     */
    public void printMiddleNode(){
        Node<E> fastPointer = getHead().next;
        Node<E> slowPointer = getHead().next;
        if (getHead().next == null){
            throw new RuntimeException("空链表！");
        }

        while (fastPointer!=null &&fastPointer.next!=null && fastPointer.next.next!=null ){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        System.out.println(slowPointer.data);  //奇数个元素 打印最中间的
        if (fastPointer.next != null){ // 如果快指针没指到最后一个元素就退出循环说明是偶数个元素 再打印出第二个中间元素
            System.out.println(slowPointer.next.data);
        }
    }
    /*
    判断单链表是否有环
     */
    public boolean hasLoop(){
        Node<E> fastPointer = getHead().next;
        Node<E> slowPointer = getHead().next;
        if (getHead().next == null){
            throw new RuntimeException("空链表！");
        }
        while (fastPointer!=null &&fastPointer.next!=null && fastPointer.next.next!=null ){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        if (slowPointer==fastPointer){
            return true;
        }
        else {
            return false;
        }

    }



}
