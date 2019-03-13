// reflection API - 메서드의 상세정보 꺼내기
package ch27.b;


public class Test08 {

  public static void main(String[] args) throws Exception {

    Class<?> clazz = String.class;

    Class<?>[] interfaces = clazz.getInterfaces();
    for (Class<?> c : interfaces) {
      System.out.println(c.getName());
    }
  }

}





