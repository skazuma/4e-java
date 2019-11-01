import tg.*;
import static javafx.scene.paint.Color.*;

class DrawPolygon extends Turtle implements Drawable2{
  public void draw(double x, double y, double n, int color){
    double a = Math.random()*360;
    double r = Math.random()*100;
    double d = (90*(n-2)/n);
    if(color==0){
      setColor(RED);
    }
    else if(color==2){
      setColor(BLUE);
    }
    else{
      setColor(YELLOW);
    }
    up();
    moveTo(x,y,a);
    fd(r);
    down();
    rt(180-d);
    for(int i=0; i<n; i++){
      fd(Math.cos(d*Math.PI/180)*r*2);
      rt(360/n);
    }
    double s = calcArea(n,r);
    display(s,r,x,y);
  }
  public double calcArea(double n, double r){
    double d = (90*(n-2)/n);
    double s = n*r*Math.sin(d*Math.PI/180)*Math.cos(d*Math.PI/180);
    return s;
  }
  public void display(double s, double r, double x, double y){
    System.out.println("ŠOÚ‰~‚Ì–ÊÏF"+s+", ŠOÚ‰~‚Ì”¼ŒaF"+r+", ŠOÚ‰~‚Ì’†SÀ•WF("+x+","+y+")");
  }
  public static void main(String args[]){
    TurtleFrame f = new TurtleFrame();
    DrawPolygon[] dp = new DrawPolygon[20];
    for(int i=0;i<dp.length;i++){
      double x = Math.random()*400;
      double y = Math.random()*400;
      double n =(int)(Math.random()*8+3);
      int color = (int)(Math.random()*3);
      dp[i] = new DrawPolygon();
      dp[i].speed(1);
      f.add((Turtle)dp[i]);
      dp[i].draw(x,y,n,color);
    }
  }

}
