package stack;

/**
 * DataStructure
 * 栈的结点
 *
 * @author : stc
 * @date : 2020-06-26 17:02
 **/
public class Node<T> {

    Node<T> next;
    T data;


    public Node(T data){
        this.data = data;
        this.next = null;
    }

    public String toString(){
        return this.data.toString();
    }

}

