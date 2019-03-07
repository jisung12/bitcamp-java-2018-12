// 조인 데이터 다루기 - join 사용 후
package ch26.h;

import java.io.InputStream;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test02 {

  public static void main(String[] args) throws Exception {
    
    InputStream inputStream = Resources.getResourceAsStream(
        "ch26/h/mybatis-config.xml");
    SqlSessionFactory sqlSessionFactory =
      new SqlSessionFactoryBuilder().build(inputStream);
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
 
    Scanner keyboard = new Scanner(System.in);
    System.out.print("게시물 번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    keyboard.close();
    
    // 조인을 사용하지 않고 자식 테이블의 데이터를 조회하려면 
    // 다음과 같이 여러 번 SQL을 실행해야 한다.
    //
    Board board = sqlSession.selectOne("board.selectBoardWtihAttachFile", no);
    System.out.println(board);
    
    for (AttachFile f : board.getAttachFiles()) {
      System.out.println("  => " + f);
    }
    System.out.println("-------------------------------");
    
  }

}






