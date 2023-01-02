package leetcode.c326;

/**
 * @author hum
 */
public class C3 {

  public int minimumPartition(String s, int k) {
    int len = String.valueOf(k).length();
    if (len == 1) {
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) - '0' > k) {
          return -1;
        }
      }
      return s.length();
    }
    int res = 0;
    for (int i = 0; i < s.length(); ) {
      int j = Math.min(i + len, s.length());
      res++;
      if (Integer.parseInt(s.substring(i, j)) <= k) {
        i = j;
      } else {
        i = j - 1;
      }
      System.out.println(i);
    }
    return res;
  }

}
