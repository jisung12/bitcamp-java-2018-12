// reflection API - 메서드의 상세정보 꺼내기
package ch27.b;

import java.lang.reflect.Method;

public class Test06 {

  public static void main(String[] args) throws Exception {

    Class<?> clazz = C.class;

    Method[] methods = clazz.getMethods();
    for (Method m : methods) {
      System.out.printf("클래스명: %s\n", 
          m.getDeclaringClass().getSimpleName());
      System.out.printf("==> %s\n", m.getName());
    }
  }
}





