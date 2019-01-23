package design_pattern.abstract_factory;

public class Restaurant extends Unit {

  @Override
  public void prepare() {
    System.out.println(this.name + " : 땅을 고른다.");
  }

  @Override
  public void construct() {
     System.out.println(this.name + " :조립 판넬을 세운다.");
  }

  @Override
  public void install() {
    System.out.println(this.name + " :내부 배선과 창을 붙인다.");
  }

  @Override
  public void interior() {
     System.out.println(this.name + " :식탁과 의자를 배치한다.");
  }
  
}
