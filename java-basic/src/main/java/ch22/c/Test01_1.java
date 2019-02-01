// 버퍼 사용 - 사용 전
// 
package ch22.c;

import java.io.FileInputStream;

public class Test01_1 {

  public static void main(String[] args) {

    try {
      FileInputStream in = new FileInputStream("data.txt");

      System.out.println("데이터 읽는중 ...");

      long start = System.currentTimeMillis();

      int b;
      while((b = in.read()) != -1) {    
        System.out.println(in.read());
      }
      //        if (++count % 1000 == 0)
      //          System.out.print(".");
      //        if(count % 20000 == 0){
      //          System.out.println();

      //  System.out.print(Integer.toHexString(b) + " ");


      long end = System.currentTimeMillis();
      System.out.println("--------------------------");
      System.out.printf("시간 : %d\n", end - start);
      
      in.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("출력 완료");

  }

}
