package ch29.f;

import org.springframework.beans.factory.FactoryBean;

// 스프링 IoC 컨테이너의 규칙에 따라 팩토리 클래스 만들기
public class CarFactory3 implements FactoryBean<Car> {
  
  BlackBox blackBox;
  String model;
  
  public CarFactory3(BlackBox blackBox, String model) {
    this.blackBox = blackBox;
    this.model = model;
  }
  
  @Override
  public Class<?> getObjectType() {
    return Car.class;
  }
  
  @Override
  public Car getObject() throws Exception {
    Car c = new Car();
    c.setBlackBox(blackBox);
    
    switch (model) {
      case "tico":
        c.setMaker("쉐보레");
        c.setModel("티코2019");
        c.setCc(900);
        c.setValve(16);
        c.setAuto(true);
        break;
      case "sonata":
        c.setMaker("현대");
        c.setModel("소나타 골드");
        c.setCc(1980);
        c.setValve(16);
        c.setAuto(true);
        break;
      case "equus":
        c.setMaker("현대");
        c.setModel("에쿠스 수프림");
        c.setCc(3500);
        c.setValve(16);
        c.setAuto(true);
        break;
      default :
        c.setMaker("비트자동차");
        c.setModel("비트카트");
        c.setCc(1200);
        c.setValve(16);
        c.setAuto(true);
        break;
    }
    return c;
  }
}
