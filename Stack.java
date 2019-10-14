import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack {
  private int maxSize;
  private int sp;
  List<Object> list= new ArrayList<>();

  public static void main(String[] args){
    Stack s=new Stack(5);
    s.push("sss");
    s.pop();
    s.push(44);
    s.pop();
    s.push(2.1);
    s.push(true);
    s.push("1");
    s.push(2);

    for(int i=0;i<3;i++)
    {
      System.out.println(s.pop());
    }

    s.push(5);
    s.push(6);
    s.push(7);
    s.push(8);
    s.push(9);

    s.initiate();

  
  }

  public Stack(int maxSize){
    this.maxSize=maxSize;
    this.sp=0;
  }

  public void push(Object item){
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

  public Object pop(){
    try{
      if(this.sp==0){
        throw new RuntimeException("�X�^�b�N����ł��B");
      }
      this.sp--;
      Object item=list.get(this.sp);
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
