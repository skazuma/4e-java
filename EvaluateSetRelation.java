import java.io.*;
import java.util.*;
public class EvaluateSetRelation{
  void evaluate(String strA, String strB){
    Set<String> setA = new HashSet<String>();
    Set<String> setB = new HashSet<String>();
    String inFile[];
    inFile = new String[2];
    inFile[0] = strA;
    inFile[1] = strB;

    String separator = "(\\s+?|\\.|\\(|\\)|,|;)";

    for(int i=0; i<inFile.length; i++){
      try(BufferedReader br = new BufferedReader(new FileReader(inFile[i]));){
        String str = br.readLine();
        while(str != null){
          String[] words = str.split(separator);
          for(String word : words){
            if(!word.isEmpty()){
              if(i==0){
                setA.add(word);
              }
              else{
                setB.add(word);
              }
            }
          }

          str = br.readLine();
        }
      }catch(IOException error){System.out.println("ÉGÉâÅ[î≠ê∂");}
    }
    Set<String> intersection = new HashSet<String>(setA);
    Set<String> union = new HashSet<String>(setA);
    intersection.retainAll(setB);
    union.addAll(setB);
    double jaccard = (double)intersection.size()/union.size();
    System.out.println("JaccardåWêî:"+jaccard);
  }

  public static void main(String[] args){
    EvaluateSetRelation esr = new EvaluateSetRelation();

    esr.evaluate("Batman.txt", "Joker.txt");

  }
}
