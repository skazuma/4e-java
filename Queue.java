import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Queue {
  private int size;
  private int maxSize;
  private int sp;
  List<Object> list=new ArrayList<>();

  public static void main(String[] args){
    Queue q=new Queue(5);
    q.enqueue("sss");
    q.enqueue(44);
    q.enqueue(2.1);
    q.enqueue(true);
    q.enqueue("1");
    q.enqueue(2);

    for(int i=0;i<5;i++)
    {
      System.out.println(q.dequeue());
    }
  }

  public Queue(int maxSize){
    this.size=0;
    this.maxSize=maxSize;
    this.sp=0;
  }

  public void enqueue(Object item){
    try{
      if(this.size==maxSize){
        throw new RuntimeException("キューが満杯です。");
      }
      list.add(item);
      this.size++;
    } catch(Exception e){
      System.out.println("例外が発生しました。");
      System.out.println(e);
    }
  }

  public Object dequeue(){
    try{
      if(this.size==0){
        throw new RuntimeException("キューが空です。");
      }
      Object item=list.get(this.sp);
      list.remove(this.sp);
      this.sp=(this.sp+1) % this.maxSize;
      this.size--;
      return item;
    } catch(Exception e){
      System.out.println("例外が発生しました。");
      System.out.println(e);

      return null;
    }
  }
}
