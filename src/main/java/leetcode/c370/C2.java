package leetcode.c370;

/**
 * @author hum
 */
public class C2 {
  public int findChampion(int n, int[][] edges) {
    int[] dep = new int[n];
    for (int[] edge : edges) {
      dep[edge[1]]++;
    }
    int cnt = 0;
    int res = -1;
    for (int i = 0; i < n; i++) {
      if (dep[i] == 0) {
        cnt++;
        res = i;
      }
    }
    if (cnt == 1) {
      return res;
    }
    return -1;
  }
}
