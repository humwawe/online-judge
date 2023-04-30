package leetcode.c343;

/**
 * @author hum
 */
public class C1 {
  public int isWinner(int[] player1, int[] player2) {

    int res1 = helper(player1);
    int res2 = helper(player2);

    if (res1 == res2) {
      return 0;
    }
    if (res1 > res2) {
      return 1;
    }
    return 2;
  }

  private int helper(int[] p) {
    int n = p.length;
    int res = 0;
    for (int i = 0; i < n; i++) {
      res += p[i];
      if (i - 1 >= 0 && p[i - 1] == 10 || i - 2 >= 0 && p[i - 2] == 10) {
        res += p[i];
      }
    }
    return res;
  }
}
