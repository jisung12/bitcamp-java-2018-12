package design_pattern.command.after;

import java.util.HashMap;
import java.util.Scanner;

public class Test01 {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    

    while(true) {
      System.out.print("명령>");
      String input = keyboard.nextLine();
      
      // Command 패턴
      // 명령어를 처리하는 각 메서드를 클래스로 정의한 후 사용한다. 
      // 일관된 사용을 위해 인터페이스로 호출 규칙을 정의한다.
      // 나중에 명령어가 추가되면 그 명령어를 처리할 클래스를 추가하면 된다.
      HashMap<String, Command> commandMap = new HashMap<>();
      commandMap.put("/board/add", new BoardAddCommand());
      commandMap.put("/board/delete", new BoardDeleteCommand());
      commandMap.put("/board/update", new BoardUpdateCommand());
      commandMap.put("/board/detail", new BoardDetailCommand());
      commandMap.put("/board/list", new BoardListCommand());
      
      commandMap.put("/member/add", new MemberAddCommand());
      commandMap.put("/member/delete", new MemberDeleteCommand());
      commandMap.put("/member/update", new MemberUpdateCommand());
      commandMap.put("/member/detail", new MemberDetailCommand());
      commandMap.put("/member/list", new MemberListCommand());
      
      commandMap.put("/hello", new HelloCommand());
      
      // 사용자가 입력한 명령어를 가지고 그 명령을 처리할 객체를 찾는다.
      Command command = commandMap.get(input);
      if(command != null) {
        // 명령어 사용 규칙에 따라 메서드를 호출한다.
        command.execute();
      }
//      if("/board/add".equals(input)) {
//        handler.addBoard();
//      } else if("/board/delete".equals(input)) {
//        handler.deleteBoard();
//      } else if("/board/update".equals(input)) {
//        handler.deleteBoard();
//      } else if("/board/detail".equals(input)) {
//        handler.deleteBoard();
//      } else if("/board/list".equals(input)) {
//        handler.deleteBoard();
//      } else if("/member/add".equals(input)) {
//        handler.addMember();
//      } else if("/member/delete".equals(input)) {
//        handler.deleteMember();
//      } else if("/member/update".equals(input)) {
//        handler.updateMember();
//      } else if("/member/detail".equals(input)) {
//        handler.detailMember();
//      } else if("/member/list".equals(input)) {
//        handler.listMember();
//      } else 
      else if ("quit".equals(input)) {
        System.out.println("처리할 수 없는 명령입니다.");
        break;
      } 
       System.out.println();
    }//while
    keyboard.close();
  
  }//main

}//test01
