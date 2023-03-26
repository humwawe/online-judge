package leetcode.c338;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class C1 {
  public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < numOnes; i++) {
      list.add(1);
    }
    for (int i = 0; i < numZeros; i++) {
      list.add(0);
    }
    for (int i = 0; i < numNegOnes; i++) {
      list.add(-1);
    }
    int res = 0;
    for (int i = 0; i < k; i++) {
      res += list.get(i);
    }
    return res;
  }
}
