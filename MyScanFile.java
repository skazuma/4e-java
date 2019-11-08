import java.io.*;
import java.util.*;
public class MyScanFile{
  void dataRead(String[] inFile, String[] outFile){
    String s;
    ArrayList<Integer> subject = new ArrayList<Integer>();
    Scanner[] sc = new Scanner[inFile.length];
    ScoreManagement[] sm = new ScoreManagement[inFile.length];
    FileWriter[] fw = new FileWriter[outFile.length];
    PrintWriter[] pw = new PrintWriter[outFile.length];
    for(int i=0; i<outFile.length; i++){
      try(BufferedReader din = new BufferedReader(new FileReader(inFile[i]));){
        if((s=din.readLine()) != null){
          sc[i] = new Scanner(s);
          sc[i].useDelimiter(",");
          subject.clear();
          while(sc[i].hasNextInt()){
            subject.add(sc[i].nextInt());
          }
          sc[i].close();
        }
      }catch(IOException error){System.out.println("ƒGƒ‰[”­¶");}
      Integer[] array = subject.toArray(new Integer[subject.size()]);
      sm[i] = new ScoreManagement();
      sm[i].calcData(array);
      try{
        fw[i] = new FileWriter(outFile[i]);
        pw[i] = new PrintWriter(new BufferedWriter(fw[i]));
        pw[i].print(sm[i].getMax());
        pw[i].print(",");
        pw[i].print(sm[i].getMin());
        pw[i].print(",");
        pw[i].print(sm[i].getAverage());
        pw[i].print(",");
        pw[i].print(sm[i].getMedian());
        pw[i].close();
      }catch(IOException error){
        error.printStackTrace();
      }
    }


  }

  public static void main(String[] args){
    String inFile[];
    inFile = new String[2];
    String outFile[];
    outFile = new String[2];
    inFile[0] = "math.txt";
    outFile[0] = "math_result.txt";
    inFile[1] = "english.txt";
    outFile[1] = "english_result.txt";
    MyScanFile r = new MyScanFile();

    for(int i=0; i<inFile.length; i++){
      try{
        FileWriter file = new FileWriter(inFile[i]);
        PrintWriter pw = new PrintWriter(new BufferedWriter(file));
        for(int j=0; j<100; j++){
          int value = (int)(Math.random()*101);
          pw.print(value);
          pw.print(",");
        }
        pw.println();
        pw.close();
      }catch(IOException error){
        error.printStackTrace();
      }
    }

    r.dataRead(inFile,outFile);

  }
}
