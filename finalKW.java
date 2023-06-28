public class finalKW {

  public static void main(String[] args) {
    
  }

  public final class A {
    public void print() {
      System.out.println("A");
    }
  }

  // public class B extends A { // error: cannot inherit from final A
  //   public void print() {
  //     System.out.println("B");
  //   }
  // }

  public class C {
    public final void print() {
      System.out.println("C");
    }
  }

  public class D extends C {
    // public void print() { // error: print() in D cannot override print() in C
    //   System.out.println("D");
    // }
  }
}
