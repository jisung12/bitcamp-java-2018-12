package com.eomcs.lms2;
import java.sql.Date;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    int LENGTH = 10;
    int[] no = new int[LENGTH];
    String[] title = new String[LENGTH];
    String[] contents = new String[LENGTH];
    Date[] startDate = new Date[LENGTH];
    Date[] endDate = new Date[LENGTH];
    int[] totalHours = new int[LENGTH];
    int[] dayHours = new int[LENGTH];

   
    Scanner keyboard = new Scanner(System.in);
 
    int i = 0;
    while(i<LENGTH) {

        System.out.print("번호? ");
        no[i] = Integer.parseInt(keyboard.nextLine());

        System.out.print("수업명? ");
        title[i] = keyboard.nextLine();

        System.out.print("설명? ");
        contents[i] = keyboard.nextLine();

        System.out.print("시작일? ");
        startDate[i] = Date.valueOf(keyboard.nextLine());

        System.out.print("종료일? ");
        endDate[i] = Date.valueOf(keyboard.nextLine());

        System.out.print("총수업시간? ");
        totalHours[i] = Integer.parseInt(keyboard.nextLine());

        System.out.print("일수업시간? ");
        dayHours[i] = Integer.parseInt(keyboard.nextLine());
      
        i++;
        
        System.out.println("계속하시겠습니까(y/n");
         String str = keyboard.nextLine();
        if(!str.equalsIgnoreCase("y") && !str.equals("")) {
          break;
        }
        else continue;
    }//while
     keyboard.close();
     
        System.out.println(); // 빈 줄 출력

        for(int j=0;j<i;j++) {
        System.out.printf("번호: %d\n", no[j]);
        System.out.printf("수업명: %s\n", title[j]);
        System.out.printf("설명: %s\n", contents[j]);
        System.out.printf("기간: %s ~ %s\n", startDate[j], endDate[j]);
        System.out.printf("총수업시간: %d 시간\n", totalHours[j]);
        System.out.printf("일수업시간: %d 시간\n", dayHours[j]);
        System.out.println();
        }
     
    }//main
  }//App

