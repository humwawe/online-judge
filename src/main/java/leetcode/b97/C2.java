package leetcode.b97;

/**
 * @author hum
 */
public class C2 {
  public int maxCount(int[] banned, int n, int maxSum) {
    int N = (int) (1e4 + 5);
    boolean[] vis = new boolean[N];
    for (int i : banned) {
      vis[i] = true;
    }
    long sum = 0;
    int c = 0;
    for (int i = 1; i <= n; i++) {
      if (vis[i]) {
        continue;
      }
      if (sum + i <= maxSum) {
        sum += i;
        c++;
      } else {
        break;
      }
    }
    return c;
  }
}
