package leetcode.b103;

/**
 * @author hum
 */
public class C2 {
  public int[] findThePrefixCommonArray(int[] a, int[] b) {
    int n = a.length;
    int[] res = new int[n];
    int[] cnt = new int[n + 1];
    for (int i = 0; i < n; i++) {
      cnt[a[i]]++;
      cnt[b[i]]++;
      int tmp = 0;
      for (int j = 1; j <= n; j++) {
        if (cnt[j] == 2) {
          tmp++;
        }
      }
      res[i] = tmp;
    }
    return res;
  }
}
