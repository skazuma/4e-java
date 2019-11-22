import java.io.*;
import java.util.*;
public class EvaluateMapRelation{
  void evaluate(String strA, String strB){
    Map<String, Integer> mapA = new HashMap<>();
    Map<String, Integer> mapB = new HashMap<>();
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
                if(mapA.containsKey(word)){
                  int count = mapA.get(word)+1;
                  mapA.put(word, count);
                }
                else{
                  mapA.put(word,1);
                }
              }
              else{
                if(mapB.containsKey(word)){
                  int count = mapB.get(word)+1;
                  mapB.put(word, count);
                }
                else{
                  mapB.put(word,1);
                }
              }
            }
          }

          str = br.readLine();
        }
      }catch(IOException error){System.out.println("ƒGƒ‰[”­¶");}
    }
    Set<String> setA = mapA.keySet();
    Set<String> setB = mapB.keySet();
    Iterator<String> iterA = setA.iterator();
    Iterator<String> iterB = setB.iterator();
    double sizeA = 0.0;
    double sizeB = 0.0;
    double innerProduct = 0.0;
    while(iterA.hasNext()){
      String key = iterA.next();
      sizeA += (double)(Math.pow(mapA.get(key),2));
      if(mapB.containsKey(key)){
        innerProduct += (double)(mapA.get(key)*mapB.get(key));
      }
    }
    sizeA = Math.sqrt(sizeA);
    while(iterB.hasNext()){
      String key = iterB.next();
      sizeB += (double)(Math.pow(mapB.get(key),2));
    }
    sizeB = Math.sqrt(sizeB);
    double cosine = innerProduct/(sizeA*sizeB);
    System.out.println("Cosine—ÞŽ—“x:"+cosine);
  }

  public static void main(String[] args){
    EvaluateMapRelation emr = new EvaluateMapRelation();

    emr.evaluate("Batman.txt", "Joker.txt");

  }
}
