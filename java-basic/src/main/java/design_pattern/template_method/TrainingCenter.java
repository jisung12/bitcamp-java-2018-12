package design_pattern.template_method;

public class TrainingCenter extends Unit {

  @Override
  public void prepare() {
    System.out.println("운동장을 고르고 숙소 건물 땅에 콘크리트 포장.");
  }

  @Override
  public void construct() {
     System.out.println("운동장에 잔디를 깔고 숙소 건물을 짓는다.");
  }

  @Override
  public void install() {
    System.out.println("운동장에 연설대 설치하고 숙소의 내부 배선과 창을 붙인다.");
  }

  @Override
  public void interior() {
     System.out.println("숙소 내부 침신을 꾸민다.");
  }
  
}
