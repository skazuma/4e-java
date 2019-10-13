public class QueueTest1 {
  public static void main(String[] args){
    Queue1 q=new Queue1(5);
    q.enqueue("sss");
    q.enqueue(44);
    q.enqueue(2.1);
    q.enqueue(true);
    q.enqueue("1");
    q.enqueue(2);

    for(int i=0;i<6;i++)
    {
      System.out.println(q.dequeue());
    }
  }
}
