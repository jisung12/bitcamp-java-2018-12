package ch13.b;

import ch13.Score;

// 계산 결과에 영향을 미치는 필드에도 getter/setter를 적용한다.

public class Score2 extends Score{
  
  // 기존의 Score클래스를 상속받는다.
  // => 상속을 받는다는 것은 기존 클래스의 기능을 이용 할 권한을 획득한다는 의미.
  private int music;
  private int art;


  public void setMusic(int music) {
    if (music >= 0 && music <= 100) // 유효한 점수인 경우에만 저장한다.
      this.music = music;
      this.compute2(); // 유효한 값이라면 다시 합계와 평균을 계산한다.
  }

  public int getMusic() {
    return this.music;
  }
//////// music /////////
  
  public void setArt(int art) {
    if (art >= 0 && art <= 100) // 유효한 점수인 경우에만 저장한다.
      this.art = art;
      this.compute2(); // 유효한 값이라면 다시 합계와 평균을 계산한다.
  }

  public int getArt() {
    return this.art;
  }
//////// art /////////
  
 private void compute2() {
   // 기존 계산 메서드를 호출해서 일단 국, 영, 수 세 과목의 합계와 평균을 계산한다.
   this.compute();
   
   this.sum += this.music + this.art;
   this.aver = this.sum / 5f;
 }
 
 
}//Score2
