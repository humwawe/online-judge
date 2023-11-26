package leetcode.c373;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class C3 {
  int[] nums;

  public int[] lexicographicallySmallestArray(int[] nums, int limit) {
    int n = nums.length;
    this.nums = nums;
    DJSet djSet = new DJSet(n);
    Integer[] idx = new Integer[n];
    Arrays.setAll(idx, e -> e);
    Arrays.sort(idx, Comparator.comparingInt(x -> nums[x]));
    for (int i = 1; i < n; i++) {
      if (nums[idx[i]] - nums[idx[i - 1]] <= limit) {
        djSet.unite(idx[i], idx[i - 1]);
      }
    }
    PriorityQueue<Integer>[] prs = djSet.toBucket();
    int[] res = new int[n];
    for (int i = 0; i < n; i++) {
      res[i] = prs[djSet.root(i)].poll();
    }
    return res;
  }


  class DJSet {
    // 负数表示集合的大小，正数表示属于这个集合的代表元素
    public int[] upper;
    private final int[] prev;

    public DJSet(int n) {
      upper = new int[n];
      prev = new int[n];
      for (int i = 0; i < n; i++) {
        upper[i] = -1;
        prev[i] = i - 1;
      }
    }

    public int root(int x) {
      return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
    }

    public boolean equiv(int x, int y) {
      return root(x) == root(y);
    }

    public boolean unite(int x, int y) {
      x = root(x);
      y = root(y);
      // 按集合大小合并，否则优先合并到x
      if (x != y) {
        if (upper[y] < upper[x]) {
          int d = x;
          x = y;
          y = d;
        }
        upper[x] += upper[y];
        upper[y] = x;
      }
      return x == y;
    }


    public PriorityQueue<Integer>[] toBucket() {
      int n = upper.length;
      PriorityQueue<Integer>[] prs = new PriorityQueue[n];
      Arrays.setAll(prs, e -> new PriorityQueue<>());
      int[] rp = new int[n];

      for (int i = 0; i < n; i++) {
        int r = root(i);
        prs[r].add(nums[i]);
      }
      return prs;
    }

  }
}
