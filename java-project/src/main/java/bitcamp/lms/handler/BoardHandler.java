package bitcamp.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.domain.Board;

public class BoardHandler {
  final static int LENGTH = 100;

  static Scanner keyboard = new Scanner(System.in);
 
  static Board[] boards = new Board[LENGTH];
  static int boardIdx = 0;
  
  
  public static void addBoard() {
    Board board = new Board();
    
    System.out.print("번호? ");
    board.no = Integer.parseInt(keyboard.nextLine());
    
    System.out.print("내용? ");
    board.contents = keyboard.nextLine();
    
    board.createdDate = new Date(System.currentTimeMillis()); 
    
    board.viewCount = 0;
    
    boards[boardIdx] = board;
    boardIdx++;
    
    System.out.println("저장하였습니다.");
  }//addBoard
  
  public static void listBoard() {
    for (int j = 0; j < boardIdx; j++) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          boards[j].no, boards[j].contents, boards[j].createdDate, boards[j].viewCount);
    }
  }//listBoard
  
  
  
  
  
}//BoardHandler
