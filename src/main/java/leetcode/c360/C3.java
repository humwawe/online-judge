package leetcode.c360;

import java.util.List;

/**
 * @author hum
 */
public class C3 {

  public int minOperations(List<Integer> nums, int target) {
    long sum = 0;
    int[] cnt = new int[32];
    for (Integer num : nums) {
      sum += num;
      cnt[Integer.numberOfTrailingZeros(num)]++;
    }
    if (sum < target) {
      return -1;
    }
    if (sum == target) {
      return 0;
    }
    int j = 0;
    int res = 0;
    for (int i = 0; i < 31; i++) {
      if ((target >> i & 1) == 1) {
        while (j < i) {
          cnt[j + 1] += cnt[j] / 2;
          j++;
        }
        if (cnt[i] == 0) {
          for (int k = i + 1; k < 31; k++) {
            if (cnt[k] > 0) {
              res += k - i;
              cnt[k] -= 1;
              for (int l = i + 1; l < k; l++) {
                cnt[l] += 1;
              }
              break;
            }
          }
        } else {
          cnt[i]--;
        }
      }
    }
    return res;
  }
}



