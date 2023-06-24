package leetcode.b107;

/**
 * @author hum
 */
public class C1 {
  public int maximumNumberOfStringPairs(String[] words) {
    int n = words.length;
    int res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (words[i].equals(new StringBuilder(words[j]).reverse().toString())) {
          res++;
        }
      }
    }
    return res;
  }
}
