// 추상 팩토리 패턴 - 팩토리 객체를 추상화 시키는 방식. 다양한 팩토리로 대체할 수 있다.
package design_pattern.abstract_factory;

import java.util.Scanner;
import design_pattern.template_method.UnitFactory;


public class Test01 {
  public static void main(String[] args) {
    // 설계
    // UnitFactory 인터페이스 : 공장 객체의 사용 규칙을 정의
    // TerranUnitFactory 클래스 : UnitFactory 구현 클래스. 테란족에 맞춰서 유닛 생성.
    // ProtossUnitFactory 클래스 : UnitFactory 구현 클래스. 프로토스족에 맞춰서 유닛 생성.
    // ZergUnitFactory 클래스 : UnitFactory 구현 클래스. 저그족에 맞춰서 유닛 생성.

    Scanner keyboard = new Scanner(System.in);
    int type;
    do {
      System.out.print("종족을 선택하시오?(1:테란, 2:프로토스, 3:저그)");
      type = keyboard.nextInt();
      if(type > 0 && type < 4) {
        break;
      }
      System.out.println("번호가 맞지 않습니다.");
    } while (true);
    keyboard.close();

    design_pattern.abstract_factory.UnitFactory unitFactory = null;

    switch (type) {
      case 1 : 
        System.out.println("테란을 선택하셨습니다.");
        unitFactory = new TerranUnitFactory();
        break;
      case 2 : 
        System.out.println("프로토스를 선택하셨습니다.");
        unitFactory = new ProtossUnitFactory();
        break;
      default : 
        System.out.println("저그를 선택하셨습니다.");
        unitFactory = new ZergUnitFactory();
        break;
    }

    // 식당 짓기
    Unit u1 = unitFactory.createUnit(UnitFactory.RESTAURANT);
    System.out.println("---------------------------------");
    // 훈련소 짓기
    Unit u2 = unitFactory.createUnit(UnitFactory.TRAINING_CENTER);
    System.out.println("---------------------------------");
  }
}
