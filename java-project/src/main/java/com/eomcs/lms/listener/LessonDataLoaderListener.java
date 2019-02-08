package com.eomcs.lms.listener;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.eomcs.lms.context.ApplicationListener;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;

// 애플리케이션의 상태를 보고 받고 싶다면
// ApplicationListener 규칙에 따라 클래스를 작성해야 한다.
public class LessonDataLoaderListener implements ApplicationListener {
  @Override
  public void startApplication(Map<String, Object> context) {
    System.out.println("애플리케이션이 시작될 때 준비 작업을 수행한다.");
    
    try(ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
            new FileInputStream("lesson2.data")))) {

      int len = in.readInt();

      context.put("lessonList", in.readObject());

    } catch (Exception e) {
      System.out.println("수업 데이터를 읽는 중 오류 발생: " + e.toString());
      context.put("lessonList", new ArrayList<Lesson>());
    } 
  }

  @Override
  public void endApplication(Map<String, Object> context) {
    System.out.println("애플리케이션이 종료될 때 마무리 작업을 수행한다.");
    try(  ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("lesson2.data")));){

      out.writeObject(context.get("lessonList"));


    } catch (IOException e) {
      System.out.println("수업 데이터를 읽는 중 오류 발생: " + e.toString());
    }
  }

}
