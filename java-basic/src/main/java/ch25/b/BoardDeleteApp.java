// 연습 - 게시물 삭제
package ch25.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BoardDeleteApp {

  // 다음과 같이 게시물을 삭제하는 프로그램을 작성하라!
  //-----------------------------------------
  // 번호? 1
  //
  // 삭제하였습니다.
  // (또는)
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
            "delete from x_board where board_id ="+no+"")) {
          System.out.println("삭제완료");
          
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
