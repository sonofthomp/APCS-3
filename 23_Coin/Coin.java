/***
 *  class Coin
 *  by Clyde "Thluffy" Sinclair
 *  SKELETON
 ***/

public class Coin {

  //attributes aka instance vars
  private double value;
  private String upFace;
  private String name;
  private int flipCtr;
  private int headsCtr;
  private int tailsCtr;
  private double bias;

  /***
   *  Coin() -- default constuctor
   *  precond:
   *  postcond:
   ***/
  public Coin() {
    bias = 0.5;
    upFace = "heads";
  }

  /***
      Coin(String) -- overloaded constructor
      precond: input is one of
      "penny",
      "nickel",
      "dime",
      "quarter",
      "half dollar",
      "dollar"
      postcond:
  ***/
  public Coin(String s) {
    name = s;
    upFace = "heads";
  }

  /***
      Coin(String,String) --
      precond:
      postcond:
  ***/
  public Coin(String s, String nowFace) {
    name = s;
    upFace = nowFace;
  }

  // Accessors...
  // ----------------------------
  public String getUpFace() {
    return upFace;
  }

  public int getFlipCtr() {
    return flipCtr;
  }

  public double getValue() {
    return value;
  }

  public int getHeadsCtr() {
    return headsCtr;
  }

  public int getTailsCtr() {
    return tailsCtr;
  }
  // ----------------------------

  /***
   * assignValue() -- set a Coin's monetary value based on its name
   * precond:  input String is a valid coin name ("penny", "nickel", etc.)
   * postcond: instvar value gets appropriate value
   * Returns value assigned.
   ***/
  private double assignValue(String s) {
    if (s == "penny") {
      value = 0.01;
      return value;
    } else if (s == "nickel") {
      value = 0.05;
      return value;
    } else if (s == "dime") {
      value = 0.10;
      return value;
    } else if (s == "quarter") {
      value = 0.25;
      return value;
    } else if (s == "half dollar") {
      value = 0.50;
      return value;
    } else if (s == "dollar") {
      value = 1.0;
      return value;
    } else {
      System.out.println("Enter valid coin name in lowercase");
      return 999999;
    }
  }

  /***
      reset() -- initialize a Coin
      precond:  s is "heads" or "tails", 0.0 <= d <= 1.0
      postcond: Coin's attribs reset to starting vals
  ***/
  public void reset(String s, double d) {
    if ((s == "heads" || s == "tails") && (d >= 0.0 && d <= 1.0)) {
      upFace = "";
      bias = 0.5;
    } else {
      System.out.println("Preconditions not satisfied.");
    }
  }

  /***
   * String flip() -- simulates a Coin flip
   * precond:  bias is a double on interval [0.0,1.0]
   * (1.0 indicates always heads, 0.0 always tails)
   * postcond: upFace updated to reflect result of flip.
   * flipCtr incremented by 1.
   * Either headsCtr or tailsCtr incremented by 1, as approp.
   * Returns "heads" or "tails"
   ***/
  public String flip() {
    flipCtr += 1;
    bias = Math.random();
    double flipProb = Math.random();
    if (flipProb < bias) {
      upFace = "heads";
      headsCtr += 1;
      return "heads";
    } else {
      upFace = "tails";
      tailsCtr += 1;
      return "tails";
    }
  }

  /***
   * boolean equals(Coin) -- checks to see if 2 coins have same face up
   * precond: other is not null
   * postcond: Returns true if both coins showing heads
   * or both showing tails. False otherwise.
   ***/
  public boolean equals(Coin other) {
    if (other == null) {
      System.out.println("Param object does not exist");
      return false;
    } else {
      if (other.upFace == "tails" && upFace == "tails" || other.upFace == "heads" && upFace == "heads") {
        return true;
      } else {
        return false;
      }
    }
  }

  /***
   * String toString() -- overrides toString() provided by Java
   * precond: n/a
   * postcond: Return String comprised of name and current face
   ***/
  public String toString() {
    String retStr = name + " -- " + upFace;
    return retStr;
  }

} //end class
