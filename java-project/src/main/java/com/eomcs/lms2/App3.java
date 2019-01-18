package com.eomcs.lms2;
import java.util.Date;
import java.util.Scanner;

 public class App3 {

    public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);

      int LENGTH = 10;
      int no[] = new int[LENGTH];
      String contents[] = new String[LENGTH];
      Date createdDate[] = new Date[LENGTH];
      int i = 0;
      
      while(i<LENGTH) {
      System.out.print("번호? ");
      no[i] = Integer.parseInt(keyboard.nextLine());
      
      System.out.print("내용? ");
      contents[i] = keyboard.nextLine();
      
      createdDate[i] = new Date(System.currentTimeMillis()); 
      
      i++;
      
      System.out.println("계속하시겠습니까?(Y/n)");
      String str = keyboard.nextLine();
      
      if(!str.equalsIgnoreCase("y") && !str.equals("")) {
        System.out.println("종료");
        break;
      } else { 
        continue;
      }
      }//while
      
      keyboard.close();
      
      System.out.println(); // 빈 줄 출력
      
      for(int j=0;j<i;j++) {
      System.out.printf("번호: %d\n", no[j]);
      System.out.printf("내용: %s\n", contents[j]);
      System.out.printf("작성일: %s\n", createdDate[j]);
      }
    }
  }
