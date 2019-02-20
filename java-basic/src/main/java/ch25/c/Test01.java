// Statement와 SQL 삽입 공격
package ch25.c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Test01 {

  static Scanner keyboard = new Scanner(System.in);
  
  public static void main(String[] args) {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      
      System.out.print("번호? ");
      int no = Integer.parseInt(keyboard.nextLine());
      
      System.out.print("제목? ");
      String title = keyboard.nextLine();
      
      System.out.print("내용? ");
      String contents = keyboard.nextLine();
      
      try (Statement stmt = con.createStatement()) {
        
        // SQL 삽입 공격
        // => 입력 문자열에 SQL 명령을 삽입하여 프로그램의 의도와 다르게 데이터를 조작하는 행위.
        // => 사용자가 입력한 값을 가지고 SQL 문장을 만들 때 이런 문제가 발생한다.
        // => 예를 들어 이 예제를 실행할 때 다음과 같이 입력해 보라!
        // 번호? 1
        // 제목? okok
        // 내용? test', view_count = 300, created_date = '2019-3-3
        
        stmt.executeUpdate("update x_board set title = '"+title+"' where board_id="+no);
        stmt.executeUpdate("update x_board set contents = '"+contents+"' where board_id="+no);
        System.out.println("입력 완료");
        // 위에서 사용자가 입력한 값을 가지고 SQL 문장을 만들면 다음과 같다.
        // update x_board set title = 'okok', 
        // contents = 'test', view_count = 300, created_date = '2019-3-3' 
        // where board_id = 1
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
