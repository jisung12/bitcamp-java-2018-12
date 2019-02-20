// 연습 - 게시물 목록 등록
package ch25.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class BoardInsertApp {

  // 다음과 같이 게시물을 등록하는 프로그램을 작성하라!
  //-----------------------------------------
  // 제목? aaa
  // 내용? bbb
  // 등록하시겠습니까?(Y/n)
  // 등록하였습니다.
  //-----------------------------------------

  static Scanner keyboard = new Scanner(System.in);
  
  public static void main(String[] args) {

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (Statement stmt = con.createStatement()) {
          
          System.out.print("제목? ");
          String title = keyboard.nextLine();
          System.out.print("내용? ");
          String contents = keyboard.nextLine();


        stmt.executeUpdate("insert into x_board(title, contents)" 
            + "values('" +title+"','" +contents+ "')");

        System.out.println("입력 성공");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
