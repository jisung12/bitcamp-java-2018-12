package ch13.a;

// 계산 결과에 영향을 미치는 필드에도 getter/setter를 적용한다.

public class Score2 {
  
  private String name;
  private int kor;
  private int eng;
  private int math;
  private int music;
  private int art;
  private int sum;
  private float aver;


  public int getKor() {
    return this.kor;
  }

  
  public void setKor(int kor) {
    if (kor >= 0 && kor <= 100) // 유효한 점수인 경우에만 저장한다.
      this.kor = kor;
      this.compute(); // 유효한 값이라면 다시 합계와 평균을 계산한다.
  }
//////// kor /////////
  
  
  public int getEng() {
    return this.eng;
  }

  public void setEng(int eng) {
    if (eng >= 0 && eng <= 100) // 유효한 점수인 경우에만 저장한다.
      this.eng = eng;
      this.compute();   // 유효한 값이라면 다시 합계와 평균을 계산한다.
  }
//////// eng/////////
  
  
  
  public int getMath() {
    return this.math;
  }

  public void setMath(int math) {
    if (math >= 0 && math <= 100) // 유효한 점수인 경우에만 저장한다.
      this.math = math;
      this.compute();   // 유효한 값이라면 다시 합계와 평균을 계산한다.
  }
//////// math/////////
  
  
  
  public void setMusic(int music) {
    if (music >= 0 && music <= 100) // 유효한 점수인 경우에만 저장한다.
      this.music = music;
      this.compute(); // 유효한 값이라면 다시 합계와 평균을 계산한다.
  }

  public int getMusic() {
    return this.music;
  }
//////// music /////////
  
  
  
  public void setArt(int art) {
    if (art >= 0 && art <= 100) // 유효한 점수인 경우에만 저장한다.
      this.art = art;
      this.compute(); // 유효한 값이라면 다시 합계와 평균을 계산한다.
  }

  public int getArt() {
    return this.art;
  }
//////// art /////////
  
  
 public String getName() {
   return this.name;
 }
 
 public void setName(String name) {
   // 이렇게 유효성을 검사하지 않더라도 setter를 그냥 만들어라.
   this.name = name;
 }
//////// name /////////
 
 
 
  public int getSum() {
    return this.sum;
  }

  public float getAver() {
    return this.aver;
  }


  private void compute() {
    this.sum = this.kor + this.eng + this.math + this.music + this.art;
    this.aver = this.sum / 5f;
  }

 

}
