package leetcode.c331;

import java.util.PriorityQueue;

/**
 * @author hum
 */
public class C1 {
  public long pickGifts(int[] gifts, int k) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> y - x);
    for (int gift : gifts) {
      priorityQueue.add(gift);
    }
    for (int i = 0; i < k; i++) {
      Integer poll = priorityQueue.poll();
      priorityQueue.add((int) Math.sqrt(poll));
    }
    long sum = 0;
    while (!priorityQueue.isEmpty()) {
      sum += priorityQueue.poll();
    }
    return sum;
  }
}
