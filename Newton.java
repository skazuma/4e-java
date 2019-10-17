public class Newton{
  public static double newton(double x){
    double a=0.615468;
    double fx;
    for(int i=0;;i++){
      x=x-((0.5-x+0.2*Math.sin(x))/(-1+0.2*Math.cos(x)));
      if(Math.abs(x-a)<0.000001){
        break;
      }
    }
    fx=0.5-x+0.2*Math.sin(x);
    System.out.println("x="+x);
    return fx;
  }
}
