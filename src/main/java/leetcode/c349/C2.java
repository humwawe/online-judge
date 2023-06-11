package leetcode.c349;

/**
 * @author hum
 */
public class C2 {
  public String smallestString(String s) {
    char[] res = s.toCharArray();
    int n = s.length();
    if (s.charAt(0) != 'a') {
      int j = -1;
      while (j + 1 < n && res[j + 1] != 'a') {
        res[j + 1] = (char) (res[j + 1] - 1);
        j++;
      }
      return new String(res);
    }
    int j = -1;
    while (j + 1 < n && res[j + 1] == 'a') {
      j++;
    }

    if (j == n - 1) {
      res[n - 1] = 'z';
      return new String(res);
    }

    while (j + 1 < n && res[j + 1] != 'a') {
      res[j + 1] = (char) (res[j + 1] - 1);
      j++;
    }
    return new String(res);
  }
}
