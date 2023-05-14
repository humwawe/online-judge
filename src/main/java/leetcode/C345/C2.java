package leetcode.C345;

/**
 * @author hum
 */
public class C2 {
  public boolean doesValidArrayExist(int[] derived) {
    int n = derived.length;
    int[] a = new int[n];
    a[0] = 0;
    for (int i = 1; i < n; i++) {
      a[i] = derived[i - 1] ^ a[i - 1];
    }
    if ((a[n - 1] ^ a[0]) == derived[n - 1]) {
      return true;
    }
    a[0] = 1;
    for (int i = 1; i < n; i++) {
      a[i] = derived[i - 1] ^ a[i - 1];
    }
    if ((a[n - 1] ^ a[0]) == derived[n - 1]) {
      return true;
    }
    return false;
  }
}
