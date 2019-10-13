public class StackTest1 {
  public static void main(String[] args){
    Stack1 s=new Stack1(5);
    s.push("sss");
    s.push(44);
    s.push(2.1);
    s.push(true);
    s.push("1");
    s.push(2);

    for(int i=0;i<6;i++)
    {
      System.out.println(s.pop());
    }
  }
}
