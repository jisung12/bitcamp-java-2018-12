// 연습 - 게시물 목록 조회
package ch25.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BoardDetailApp {

  // 다음과 같이 게시물을 조회하는 프로그램을 작성하라!
  //-----------------------------------------
  // 번호? 1
  // 제목 : aaa
  // 내용 : aaaaa
  // 등록일 : 2019-1-1
  // 조회수 : 2
  //
  // 번호? 100
  // 해당 번호의 게시물이 존재하지 않습니다.
  //------------------------------------------
  static Scanner keyboard = new Scanner(System.in);
  
  public static void main(String[] args) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      try (Statement stmt = con.createStatement()) {

        System.out.print("번호? ");
        int no = Integer.parseInt(keyboard.nextLine());
        
        try(ResultSet rs = stmt.executeQuery(
            "select title, contents from  x_board where board_id="+no+"")) {
          
          rs.next();
          System.out.printf("제목: %s\n", rs.getString("title"));
          System.out.printf("내용: %s\n", rs.getString("contents"));
          
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
