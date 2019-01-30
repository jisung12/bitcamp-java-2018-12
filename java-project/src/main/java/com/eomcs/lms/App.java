package com.eomcs.lms;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.Command;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LessonDeleteCommand;
import com.eomcs.lms.handler.LessonDetailCommand;
import com.eomcs.lms.handler.LessonListCommand;
import com.eomcs.lms.handler.LessonUpdateCommand;
import com.eomcs.lms.handler.MemberAddCommand;
import com.eomcs.lms.handler.MemberDeleteCommand;
import com.eomcs.lms.handler.MemberDetailCommand;
import com.eomcs.lms.handler.MemberListCommand;
import com.eomcs.lms.handler.MemberUpdateCommand;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  static Stack<String> commandHistory = new Stack<>();
  static Queue<String> commandHistory2 = new LinkedList<>();
  static ArrayList<Lesson> lessonList = new ArrayList<>();
  static ArrayList<Board> boardList = new ArrayList<>();
  static ArrayList<Member> memberList = new ArrayList<>();

  public static void main(String[] args) {

    // 데이터 로딩
    loadLessonData();
    loadBoardData();
    loadMemberData();

    HashMap<String, Command> commandMap = new HashMap<>();

    commandMap.put("/board/add", new BoardAddCommand(keyboard, boardList));
    commandMap.put("/board/list", new BoardListCommand(keyboard, boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(keyboard, boardList));
    commandMap.put("/board/update", new BoardUpdateCommand(keyboard, boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(keyboard, boardList));

    commandMap.put("/lesson/add", new LessonAddCommand(keyboard, lessonList));
    commandMap.put("/lesson/list", new LessonListCommand(keyboard, lessonList));
    commandMap.put("/lesson/detail", new LessonDetailCommand(keyboard, lessonList));
    commandMap.put("/lesson/update", new LessonUpdateCommand(keyboard, lessonList));
    commandMap.put("/lesson/delete", new LessonDeleteCommand(keyboard, lessonList));

    commandMap.put("/member/add", new MemberAddCommand(keyboard, memberList));
    commandMap.put("/member/list", new MemberListCommand(keyboard, memberList));
    commandMap.put("/member/detail", new MemberDetailCommand(keyboard, memberList));
    commandMap.put("/member/update", new MemberUpdateCommand(keyboard, memberList));
    commandMap.put("/member/delete", new MemberDeleteCommand(keyboard, memberList));


    //  BoardAddCommand boardAddCommand = new BoardAddCommand(keyboard, boardList);
    //  BoardListCommand boardListCommand = new BoardListCommand(keyboard, boardList);


    while (true) {
      String command = prompt();

      // 사용자가 입력한 명령을 스택에 보관한다.
      commandHistory.push(command);

      // 사용자가 입력한 명령을 큐에 보관한다.
      commandHistory2.offer(command);

      Command commandHandler = commandMap.get(command);

      if (commandHandler != null) {
        try {
          commandHandler.execute();
        } catch (Exception e) {
          e.printStackTrace();
          // 예외가 발생하면 다음 문장을 실행한다.
          // 그리고 계속 프로그램을 실행한다.
          System.out.printf("작업중 오류 발생 : %s\n", e.toString());
        }

      } else if (command.equals("quit")) {
        quit();
        break;

      } else if (command.equals("history")) {
        printCommandHistory();

      } else if (command.equals("history2")) {
        printCommandHistory2();

      }   else {
        Command commandHandler2 = commandMap.get(command);

        if(commandHandler2 == null)
          System.out.println("실행할 수 없는 명령입니다.");
      }

      System.out.println(); 
    }

    keyboard.close();
  }


  @SuppressWarnings("unchecked")
  private static void printCommandHistory() {
    Stack<String> temp = (Stack<String>) commandHistory.clone();

    while (temp.size() > 0) {
      System.out.println(temp.pop());
    }

  }


  @SuppressWarnings("unchecked")
  private static void printCommandHistory2() {
    Queue<String> temp = (Queue<String>) ((LinkedList<String>) commandHistory2).clone();

    while (temp.size() > 0) {
      System.out.println(temp.poll());
    }
  }


  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }

  private static void quit() {
    saveLessonData();
    saveBoardData();
    saveMemberData();
    System.out.println("안녕!");
  }

  //////////////////////////////////////////////////////////////////////////////////////
  private static void loadMemberData() {
    try(FileReader in = new FileReader("member.csv");
        Scanner in2 = new Scanner(in)) {

      while(true) {
        memberList.add(Member.valueOf(in2.nextLine()));
      } 
    } catch (FileNotFoundException e) {
      e.printStackTrace();

    } catch (IOException e1) {
      e1.printStackTrace();

    } catch (NoSuchElementException e) {
      System.out.println("Member 데이터 로딩 완료!");
    }
  }//loadMemberData

  private static void saveMemberData() {
    try (FileWriter out = new FileWriter("member.csv");) {
      for(Member member : memberList) {
        out.write(String.format("%s,%s,%s,%s,%s,%s", 
            member.getNo(),
            member.getName(),
            member.getEmail(),
            member.getPassword(),
            member.getPhoto(),
            member.getTel()
            ));}
    } catch (IOException e) {
      e.printStackTrace();
    }
  }//saveMemberData
  
  private static void loadBoardData() {
    try(FileReader in = new FileReader("board.csv");
        Scanner in2 = new Scanner(in)) {
      while(true) {
        boardList.add(Board.valueOf(in2.nextLine()));
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e1) {
      e1.printStackTrace();
    }catch (NoSuchElementException e) {
      System.out.println("Board 데이터 로딩 완료!");
    }
  }//loadBoardData

  private static void saveBoardData() {
    try(FileWriter out = new FileWriter("board.csv");){
      for(Board board : boardList)   {
        out.write(String.format("%s,%s\n",
            board.getNo(),
            board.getContents()));
      } 
    } catch (IOException e) {
      e.printStackTrace();
    }
  }//saveBoardData

  private static void loadLessonData() {
    try(FileReader in = new FileReader("lesson.csv");
        Scanner in2 = new Scanner(in)) {
      while(true) {
        // String line = in2.nextLine(); ㄱ// 번호,제목,내용,시작일,종료일,총강의시간,일강의시간
        // lessonList.add(Lesson.valueOf(line));
        lessonList.add(Lesson.valueOf(in2.nextLine()));
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();

    } catch (IOException e1) {
      e1.printStackTrace();

    } catch (NoSuchElementException e) {
      System.out.println("Lesson 데이터 로딩 완료!");
    }
  }//loadLessonData

  private static void saveLessonData() {
    try(FileWriter out = new FileWriter("lesson.csv");) {
      for(Lesson lesson : lessonList) {
        out.write(String.format("%s,%s,%s,%s,%s,%d,%d\n", 
            lesson.getNo(),
            lesson.getTitle(),
            lesson.getContents(),
            lesson.getStartDate(),
            lesson.getEndDate(),
            lesson.getTotalHours(),
            lesson.getDayHours()));
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }//saveLessonData

}//App
