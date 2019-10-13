public class Stack<T> {
  private int maxSize;
  private T data[];
  private int sp;

  public Stack(int maxSize){
    this.maxSize=maxSize;
    this.data=(T[])new Object[maxSize];
    this.sp=0;
  }

  public void push(T item){
    try{
      if(this.sp==maxSize){
        throw new RuntimeException("�X�^�b�N�����t�ł��B");
      }
      this.data[this.sp]=item;
      this.sp++;
    } catch(Exception e){
      System.out.println("��O���������܂����B");
      System.out.println(e);
    }
  }

  public T pop(){
    try{
      if(this.sp==0){
        throw new RuntimeException("�X�^�b�N����ł��B");
      }
      this.sp--;
      return this.data[this.sp];
    } catch(Exception e){
      System.out.println("��O���������܂����B");
      System.out.println(e);

      return null;
    }
  }
}
