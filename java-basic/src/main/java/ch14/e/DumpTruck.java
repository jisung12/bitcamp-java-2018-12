package ch14.e;

public class DumpTruck extends Truck{
  
  boolean dump; // 적재 무게
  
  @Override
  public void run() {
    System.out.println("꽈당 달린다");
  }
  
}
