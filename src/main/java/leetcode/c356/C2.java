package leetcode.c356;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class C2 {
  public int countCompleteSubarrays(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    int cnt = set.size();

    int n = nums.length;
    int res = 0;
    for (int i = 0; i < n; i++) {
      Set<Integer> s = new HashSet<>();
      for (int j = i; j < n; j++) {
        s.add(nums[j]);
        if (s.size() == cnt) {
          res++;
        }
      }
    }
    return res;
  }
}
