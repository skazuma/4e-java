import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Queue2 {
  private int size;
  private int maxSize;
  List<Object> list=new ArrayList<>();

  public static void main(String[] args){
    Queue2 q=new Queue2(5);
    q.enqueue("sss");
    q.enqueue(44);
    q.dequeue();
    q.enqueue(2.1);
    q.enqueue(true);
    q.enqueue("1");
    q.enqueue(2);

    for(int i=0;i<6;i++)
    {
      System.out.println(q.dequeue());
    }
    System.out.println("����������");

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

  public void enqueue(Object item){
    try{
      if(this.size==maxSize){
        throw new RuntimeException("�L���[�����t�ł��B");
      }
      list.add(item);
      this.size++;
    } catch(Exception e){
      System.out.println("���O���������܂����B");
      System.out.println(e);
    }
  }

  public Object dequeue(){
    try{
      if(this.size==0){
        throw new RuntimeException("�L���[�����ł��B");
      }
      Object item=list.get(0);
      list.remove(0);
      this.size--;
      return item;
    } catch(Exception e){
      System.out.println("���O���������܂����B");
      System.out.println(e);

      return null;
    }
  }

  public void initiate(){
    while(this.size>0){
      list.remove(0);
      this.size--;
    }
  }
}
