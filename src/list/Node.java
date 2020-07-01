package list;

/**
 * DataStructure
 * 链表节点
 *
 * @author : stc
 * @date : 2020-06-25 23:04
 **/
public class Node<T> {

    Node<T> next; //next域
    T data;  //data域

    public Node(T data){
        this.data = data;
        next = null;
    }

    public String toString(){
        return this.data.toString();
    }


}
