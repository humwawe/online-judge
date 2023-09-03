package leetcode.b112;

import java.util.List;
import java.util.TreeMap;

/**
 * @author hum
 */
public class C3 {
  public long maxSum(List<Integer> nums, int m, int k) {
    int n = nums.size();
    long[] sum = new long[n + 1];
    for (int i = 0; i < n; i++) {
      sum[i + 1] = sum[i] + nums.get(i);
    }
    MultiSet<Integer> multiSet = new MultiSet<>();
    long res = 0;
    for (int i = 0; i < n; i++) {
      multiSet.addOne(nums.get(i));
      if (i >= k) {
        multiSet.removeOne(nums.get(i - k));

      }
      if (i >= k - 1 && multiSet.size() >= m) {
        res = Math.max(res, sum[i + 1] - sum[i + 1 - k]);
      }
    }
    return res;
  }

  class MultiSet<T> extends TreeMap<T, Long> {
    public MultiSet() {
      super();
    }

    public MultiSet(List<T> list) {
      super();
      for (T e : list) {
        this.addOne(e);
      }
    }

    public long count(Object elm) {
      return getOrDefault(elm, 0L);
    }

    public void add(T elm, long amount) {
      if (!this.containsKey(elm)) {
        put(elm, amount);
      } else {
        replace(elm, get(elm) + amount);
      }
      if (this.count(elm) == 0) {
        this.remove(elm);
      }
    }

    public void addOne(T elm) {
      this.add(elm, 1);
    }

    public void removeOne(T elm) {
      this.add(elm, -1);
    }

    public void removeAll(T elm) {
      this.add(elm, -this.count(elm));
    }

  }
}