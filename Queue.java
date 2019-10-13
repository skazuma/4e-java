public class Queue<T> {
  private int size;
  private int maxSize;
  private T data[];
  private int sp;

  public Queue(int maxSize){
    this.size=0;
    this.maxSize=maxSize;
    this.data=(T[])new Object[maxSize];
    this.sp=0;
  }

  public void enqueue(T item){
    try{
      if(this.size==maxSize){
        throw new RuntimeException("�L���[�����t�ł��B");
      }
      this.data[(this.sp+this.size) % this.maxSize]=item;
      this.size++;
    } catch(Exception e){
      System.out.println("��O���������܂����B");
      System.out.println(e);
    }
  }

  public T dequeue(){
    try{
      if(this.size==0){
        throw new RuntimeException("�L���[����ł��B");
      }
      T item=this.data[this.sp];
      this.sp=(this.sp+1) % this.maxSize;
      this.size--;
      return item;
    } catch(Exception e){
      System.out.println("��O���������܂����B");
      System.out.println(e);

      return null;
    }
  }
}
