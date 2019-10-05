import tg.*;

public class Star31 {
    public static void main(String[] args){
        int n = 5;
        int k = 3;
        int size = 100;
        TurtleFrame f;
        f =  new TurtleFrame();
        Turtle m = new Turtle();
        f.add(m);
        for(int i = 0; i < n; i++){
            m.fd(size); m.rt(k * 360.0 / n);
        }
    }
}
