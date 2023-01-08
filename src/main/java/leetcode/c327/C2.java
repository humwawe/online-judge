package leetcode.c327;

import java.util.PriorityQueue;

/**
 * @author hum
 */
public class C2 {
  public long maxKelements(int[] nums, int k) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> y - x);
    for (int num : nums) {
      priorityQueue.add(num);
    }
    long res = 0;
    for (int i = 0; i < k; i++) {
      Integer poll = priorityQueue.poll();
      res += poll;
      priorityQueue.add((poll + 2) / 3);
    }
    return res;
  }
}
