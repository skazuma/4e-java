import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Queue<T> {
  private int size;
  private int maxSize;
  List<T> list=new ArrayList<>();

  public static void main(String[] args){
    Queue<Integer> q=new Queue<Integer>(5);
    q.enqueue(2);
    q.enqueue(44);
    q.dequeue();
    q.enqueue(23);
    q.enqueue(5);
    q.enqueue(4);
    q.enqueue(2);

    for(int i=0;i<6;i++)
    {
      System.out.println(q.dequeue());
    }
    System.out.println("初期化検証");

    for(int i=0;i<5;i++){
      q.enqueue(i);
      System.out.println(-i);
    }
    System.out.println(q.dequeue());
    q.initiate();
    System.out.println(q.dequeue());

  }

  public Queue(int maxSize){
    this.size=0;
    this.maxSize=maxSize;
  }

  public void enqueue(T item){
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

  public T dequeue(){
    try{
      if(this.size==0){
        throw new RuntimeException("キューが空です。");
      }
      T item=list.get(0);
      list.remove(0);
      this.size--;
      return item;
    } catch(Exception e){
      System.out.println("例外が発生しました。");
      System.out.println(e);

      return null;
    }
  }

  public void initialize(){
    while(this.size>0){
      list.remove(0);
      this.size--;
    }
  }
}
