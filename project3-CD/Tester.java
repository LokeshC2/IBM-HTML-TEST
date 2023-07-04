package project4;

import java.util.Vector;

public class Tester {
  public static void main(String[] args) {
    CD cd = new CD();
    cd.setId(3);
    cd.setName("CD Name");
    cd.setPrice(352.5);
    InternationalCD icd = new InternationalCD();
    icd.setId(4);
    icd.setName("International CD Name");
    icd.setPrice(352.5);
    icd.setLanguage("English");
  
    SpecialCD scd = new SpecialCD();
    scd.setId(5);
    scd.setName("Special CD Name");
    scd.setPrice(352.5);
    scd.setSpecialFeature("Special Feature");

    Vector<CD> cdList = new Vector<CD>();
    cdList.add(cd);
    cdList.add(icd);
    cdList.add(scd);

    for (CD c : cdList) {
      c.getCdDetails();
      System.out.println("----------\n");
    }
  }
}
