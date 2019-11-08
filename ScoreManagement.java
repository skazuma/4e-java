import java.io.*;
import java.util.*;
public class ScoreManagement{
  double total = 0.0;
  int max = 0;
  int min = 100;
  double ave = 0.0;
  double med = 0.0;

  void calcData(Integer[] array){
    int size = array.length;
    int[] score;

    score = new int[size];
    for(int i=0; i<size; i++){
      score[i]=array[i];
    }
    calcMax(score);
    calcMin(score);
    calcAverage(score);
    calcMedian(score);
  }
  private void calcMax(int[] score){
    for(int i=0; i<score.length; i++){
      if(score[i]>max){
        max=score[i];
      }
    }
  }
  private void calcMin(int[] score){
    for(int i=0; i<score.length; i++){
      if(score[i]<min){
        min=score[i];
      }
    }
  }
  private void calcAverage(int[] score){
    for(int i=0; i<score.length; i++){
      total = total+score[i];
    }
    ave=total/score.length;
  }
  private void sort(int[] score){
    for(int i=0; i<score.length; i++){
      for(int j=i+1; j<score.length; j++){
        if(score[i]>score[j]){
          int tmp=score[i];
          score[i]=score[j];
          score[j]=tmp;
        }
      }
    }
  }
  private void calcMedian(int[] score){
    sort(score);
    if(score.length % 2 == 1){
      med=(double)(score[score.length/2]);
    }
    else{
      med=(score[score.length/2]+score[(score.length/2)-1])/2.0;
    }
  }
  public int getMax(){
    return max;
  }
  public int getMin(){
    return min;
  }
  public double getAverage(){
    return ave;
  }
  public double getMedian(){
    return med;
  }
}
