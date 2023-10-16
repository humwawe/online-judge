package leetcode.c366;

import java.util.Collections;
import java.util.List;

/**
 * @author hum
 */
public class C2 {
  public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
    Collections.sort(processorTime);
    tasks.sort((x, y) -> y - x);
    int res = 0;
    for (int i = 0; i < tasks.size(); i++) {
      res = Math.max(res, processorTime.get(i / 4) + tasks.get(i));
    }
    return res;
  }
}
