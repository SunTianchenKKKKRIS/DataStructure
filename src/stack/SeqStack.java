package stack;

/**
 * DataStructure
 * 顺序栈
 *
 * @author : stc
 * @date : 2020-06-26 17:04
 **/
public class SeqStack {

    private Object[] stack;
    private int top;//栈顶指针
    private int maxsize;//最大容量

    public SeqStack(){
        this(10);//默认构造一个大小为10 的栈
    }

    public SeqStack(int maxsize){
        this.stack = new Object[maxsize];
        this.top = -1;
        this.maxsize = maxsize;
    }

    /*
    判空
     */
    public boolean isEmpty(){
        return this.top==-1;
    }

    /*
    弹栈
     */
    public Object pop(){
        if (this.top==-1){
            throw new RuntimeException("这是个空栈！");
        }
        Object element = this.stack[this.top];
        this.stack[this.top--] = null;
        return element;
    }

    /*
    入栈
     */
    public void push(Object element){
        if (this.top+1 == this.maxsize){
            throw new RuntimeException("这个栈满啦！");
        }
        this.stack[++this.top] = element;
    }

    /*
    打印栈
     */

    public void print(){
        for(int i = this.top;i>=0;i--){
            System.out.print(this.stack[i]+ " ");
        }
    }

}


