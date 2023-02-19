package leetcode.c333;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class C2 {

  Map<Integer, Integer> memo = new HashMap<>();

  public int minOperations(int n) {
    return dfs(n);
  }

  private int dfs(int x) {
    if ((x & (x - 1)) == 0) {
      return 1;
    }
    if (memo.containsKey(x)) {
      return memo.get(x);
    }
    int lb = Integer.lowestOneBit(x);
    System.out.println(lb);

    int res = Math.min(dfs(x + lb), dfs(x - lb)) + 1;
    memo.put(x, res);
    return res;
  }
}
