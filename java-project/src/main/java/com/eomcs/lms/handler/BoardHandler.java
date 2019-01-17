package com.eomcs.lms.handler;

import java.sql.Date;

import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {

  static final int LENGTH = 10;

  Scanner keyboard;
  BoardList list;  

  Board[] boards = new Board[LENGTH];
  int boardIdx = 0;

  public BoardHandler(Scanner keyboard){
    this.keyboard = keyboard;
    this.list = new BoardList(20);
  }
 
  
  public void listBoard() {
    for (int j = 0; j < this.boardIdx; j++) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          this.boards[j].getNo(), this.boards[j].getContents()
          , this.boards[j].getCreatedDate(), this.boards[j].getViewCount());
    }
  } 
  

  public void addBoard() {
    
    Board board = new Board();
    
    System.out.print("번호? ");
    board.setNo(Integer.parseInt(this.keyboard.nextLine()));

    System.out.print("내용? ");
    board.setContents(this.keyboard.nextLine());

    board.setCreatedDate(new Date(System.currentTimeMillis()));

    board.setViewCount(0);

    this.boards[boardIdx] = board;
    this.boardIdx++;

    
    System.out.println("저장하였습니다.");
  }

}
