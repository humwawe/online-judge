package leetcode.b95;

/**
 * @author hum
 */
public class C2 {
  int v;
  int k;
  int idx = 0;
  int last = 0;

  public C2(int value, int k) {
    this.v = value;
    this.k = k;
  }

  public boolean consec(int num) {
    idx++;
    if (num != v) {
      last = idx;
    }
    if (idx - last >= k) {
      return true;
    }
    return false;
  }
}
