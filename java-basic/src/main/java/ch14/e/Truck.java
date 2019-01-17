package ch14.e;

public class Truck extends Car{
  
  int weight; // 적재 무게
  
  @Override
  public void run() {
    System.out.println("덜컹 달린다");
  }
  
}
