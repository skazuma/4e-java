import tg.*;

public class HomeworkS1 {
  public static void main(String[] args){
    int n = 5;
    int k = 3;
    int size = 100;
    if(args.length==0){
      TurtleFrame f;
      f =  new TurtleFrame();
      Turtle m = new Turtle();
      f.add(m);
      for(int i = 0; i < n; i++){
          m.fd(size); m.rt(k * 360.0 / n);
      }
    }
    else{
      TurtleFrame f;
      f =  new TurtleFrame();
      HTurtle m = new HTurtle();
      f.add(m);
      for(int i = 0; i < n; i++){
          m.fd(size);
          m.polygon(6,50); 
          m.rt(k * 360.0 / n);
      }
    }
  }
}
