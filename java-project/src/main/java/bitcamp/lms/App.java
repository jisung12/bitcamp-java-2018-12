package bitcamp.lms;

import java.sql.Date;

public class App {
  public static void main(String[] args) {
    java.util.Scanner keyboard = new java.util.Scanner(System.in);

    int[] number = new int[100];
    String[] subName = new String[100];
    String[] subCon = new String[100];
    Date[] startDate = new Date[100];
    Date[] endDate = new Date[100];
    int[] totalTime = new int[100];
    int[] dateTime = new int[100];

    int index = 0;

    while(index < 100) {
      System.out.print("번호? ");
      number[index] = Integer.parseInt(keyboard.nextLine()); 

      System.out.print("수업명? ");
      subName[index] = keyboard.nextLine();

      System.out.print("수업내용? ");
      subCon[index] = keyboard.nextLine();

      System.out.print("시작일? ");
      startDate[index] = Date.valueOf(keyboard.nextLine()); 

      System.out.print("종료일? ");
      endDate[index] =  Date.valueOf(keyboard.nextLine());

      System.out.print("총수업시간? ");
      totalTime[index] = Integer.parseInt(keyboard.nextLine());

      System.out.print("일수업시간? ");
      dateTime[index] = Integer.parseInt(keyboard.nextLine());

      index++;

      System.out.print("\n계속 입력하시겠습니까?(Y/n) \n");
      String input = keyboard.nextLine();

      if(!input.equalsIgnoreCase("y") && !input.equals("") )
        break;
    } //whlie1

    keyboard.close();  

    int count = 0;

    while(count < index) {
      System.out.printf("%d. %-20s, %s ~ %s, %4d\n",
          number[count],subName[count], startDate[count] ,endDate[count], totalTime[count]);
      count++;
    }



  }  
}