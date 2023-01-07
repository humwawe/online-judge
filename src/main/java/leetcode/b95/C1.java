package leetcode.b95;

/**
 * @author hum
 */
public class C1 {
  public String categorizeBox(int length, int width, int height, int mass) {
    long v = (long) length * width * height;
    int x = (int) 1e4;
    int y = (int) 1e9;
    boolean b = false;
    boolean h = false;
    if (length >= x || width >= x || height >= x || mass >= x || v >= y) {
      b = true;
    }
    if (mass >= 100) {
      h = true;
    }
    if (b && h) {
      return "Both";
    }
    if (!b & !h) {
      return "Neither";
    }
    if (b) {
      return "Bulky";
    }
    if (h) {
      return "Heavy";
    }
    return "";
  }
}
