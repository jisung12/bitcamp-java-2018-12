package ch29.i.sub4;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ch29.i.BlackBox;

@Component
public class Sub4Car {
  private String maker;
  private String model;
  private int cc;
  private int valve;
  private boolean auto;
  private Date createdDate;
  @Autowired private BlackBox blackBox;
  
  public Sub4Car() {
    System.out.println("Car()");
  }
  
  @Override
  public String toString() {
    return "Car [maker=" + maker + ", model=" + model + ", cc=" + cc + ", valve=" + valve
        + ", auto=" + auto + ", createdDate=" + createdDate + ", blackBox=" + blackBox + "]";
  }

  public String getMaker() {
    return maker;
  }
  public void setMaker(String maker) {
    this.maker = maker;
  }
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }
  public int getCc() {
    return cc;
  }
  public void setCc(int cc) {
    this.cc = cc;
  }
  public int getValve() {
    return valve;
  }
  public void setValve(int valve) {
    this.valve = valve;
  }
  public boolean isAuto() {
    return auto;
  }
  public void setAuto(boolean auto) {
    this.auto = auto;
  }
  public Date getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
}







