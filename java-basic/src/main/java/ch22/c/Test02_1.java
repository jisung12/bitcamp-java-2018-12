// 버퍼 사용 - 사용 후 
// 
package ch22.c;

import java.io.FileOutputStream;

public class Test02_1 {

  public static void main(String[] args) {

    FileOutputStream out = null;
    
    try {
       out = new FileOutputStream("data.bin");

      System.out.println("데이터 쓰는중 ...");

      long start = System.currentTimeMillis();

      for (int i = 0; i<100000; i++) {
        out.write(0x55);
      }
      
      


      long end = System.currentTimeMillis();
      System.out.println("--------------------------");
      System.out.printf("시간 : %d\n", end - start);
      
      out.close();

    } catch (Exception e) {
      e.printStackTrace();
    
    } finally {
     try {out.close();} catch (Exception e) {}
    }

    System.out.println("출력 완료");

  }

}
