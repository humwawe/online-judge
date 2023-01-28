package leetcode.b96;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class C3 {
  public long maxScore(int[] nums1, int[] nums2, int k) {
    int n = nums2.length;
    Integer[] idx = new Integer[n];
    for (int i = 0; i < n; i++) {
      idx[i] = i;
    }
    Arrays.sort(idx, (x, y) -> nums2[y] - nums2[x]);
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    long sum = 0;
    long res = 0;
    for (int i = 0; i < n; i++) {
      int j = idx[i];
      priorityQueue.add(nums1[j]);
      sum += nums1[j];
      if (priorityQueue.size() > k) {
        sum -= priorityQueue.poll();
      }
      if (priorityQueue.size() == k) {
        res = Math.max(res, sum * nums2[j]);
      }
    }
    return res;

  }
}
