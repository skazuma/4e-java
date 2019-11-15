import java.io.*;
import java.util.*;
public class EvaluateSetRelation{
  void evaluate(String[] inFile){
    Set<String> listH = new HashSet<String>();

    //Scanner[] sc = new Scanner[inFile.length];
    String separator = "(\\s+?|\\.|,)";
    for(int i=0; i<inFile.length; i++){
      try(BufferedReader br = new BufferedReader(new FileReader(inFile[i]));){
        String str = br.readLine();
        listH.clear();
        while(str != null){
          String[] words = str.split(separator);
          for(String word : words){
            if(!word.isEmpty()){
              listH.add(word);
            }
          }
          /*
          sc[i] = new Scanner(str);
          sc[i].useDelimiter(" ");
          while(sc[i].hasNext()){
            listH.add(sc[i].next());
          }
          */
          str = br.readLine();
        }
        //sc[i].close();
      }catch(IOException error){System.out.println("ƒGƒ‰[”­¶");}
      System.out.println(listH);
    }
  }

  public static void main(String[] args){
    String inFile[];
    inFile = new String[2];
    inFile[0] = "Batman1.txt";
    inFile[1] = "Joker1.txt";
    EvaluateSetRelation esr = new EvaluateSetRelation();

    esr.evaluate(inFile);

  }
}
