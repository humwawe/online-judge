package leetcode.c331;

/**
 * @author hum
 */
public class C2 {
  public int[] vowelStrings(String[] words, int[][] queries) {
    int n = words.length;
    int[] sum = new int[n + 1];
    for (int i = 0; i < n; i++) {
      char c1 = words[i].charAt(0);
      char c2 = words[i].charAt(words[i].length() - 1);
      sum[i + 1] = sum[i];
      if (c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u') {
        if (c2 == 'a' || c2 == 'e' || c2 == 'i' || c2 == 'o' || c2 == 'u') {
          sum[i + 1] += 1;
        }
      }
    }

    int[] res = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int l = queries[i][0];
      int r = queries[i][1];
      res[i] = sum[r + 1] - sum[l];
    }
    return res;
  }
}
