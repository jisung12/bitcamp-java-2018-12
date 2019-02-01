// 문자 데이터 읽기
package ch22.d;

import java.io.FileWriter;

public class Test03_1 {

  public static void main(String[] args) {

    // FileReader
    // => 문자 단위로 데이터를 읽는 일을 한다.

    try (FileWriter out = new FileWriter("data.txt")) {

      out.write("ABC가각간0123#!?");

    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("출력완료");
  }

}
