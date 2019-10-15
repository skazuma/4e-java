import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack<T> {
  private int maxSize;
  private int sp;
  List<T> list= new ArrayList<>();

  public static void main(String[] args){
    Stack<String> s=new Stack<String>(5);
    s.push("sss");
    s.pop();
    s.push("r");
    s.pop();
    s.push("ff");
    s.push("m");
    s.push("1");
    s.push("55");

    for(int i=0;i<6;i++)
    {
      System.out.println(s.pop());
    }

    s.initiate();

    Stack<Integer> s1=new Stack<Integer>(5);
    for(int i=0;i<5;i++){
      s1.push(i);
    }
    for(int i=0;i<6;i++)
    {
      System.out.println(s1.pop());
    }


  }

  public Stack(int maxSize){
    this.maxSize=maxSize;
    this.sp=0;
  }

  public void push(T item){
    try{
      if(this.sp==maxSize){
        throw new RuntimeException("�X�^�b�N�����t�ł��B");
      }
      list.add(item);
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
      T item=list.get(this.sp);
      list.remove(this.sp);
      return item;
    } catch(Exception e){
      System.out.println("��O���������܂����B");
      System.out.println(e);

      return null;
    }
  }

  public void initiate(){
    while(this.sp>0){
      sp--;
      list.remove(sp);
    }
  }
}
