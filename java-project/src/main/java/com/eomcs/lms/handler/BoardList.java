package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Board;

import java.util.Arrays;


public class BoardList {
  static final int a = 10;
  Board[] list;
  int size = 0;

  public BoardList() {
    list  = new Board[a];  
  }

  public BoardList(int x) {
    if (x > a)
      list = new Board[x];
    else
      list = new Board[a];
  }

  public Board[] toArray() {
    return Arrays.copyOf(list, size);
  }

  public void add(Board board) {
    if (size >= list.length) {
      int oldc = list.length;
      int newc = oldc + (oldc >> 1);
      list = Arrays.copyOf(list, newc);
    }

    list[size++] = board;
  }
}

