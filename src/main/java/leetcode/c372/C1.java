package leetcode.c372;

/**
 * @author hum
 */
public class C1 {
  public int findMinimumOperations(String s1, String s2, String s3) {
    int n1 = s1.length();
    int n2 = s2.length();
    int n3 = s3.length();
    for (int i = Math.min(n1, Math.min(n2, n3)); i > 0; i--) {
      String t1 = s1.substring(0, i);
      String t2 = s2.substring(0, i);
      String t3 = s3.substring(0, i);
      if (t1.equals(t2) && t2.equals(t3)) {
        return n1 - i + n2 - i + n3 - i;
      }
    }
    return -1;
  }
}
