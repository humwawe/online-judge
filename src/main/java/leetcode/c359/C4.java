package leetcode.c359;

import java.util.List;

/**
 * @author hum
 */
public class C4 {

  public int longestEqualSubarray(List<Integer> nums, int k) {
    int n = nums.size();
    int l = 1;
    int r = n;
    while (l < r) {
      int mid = l + r + 1 >> 1;
      if (check(nums, k, mid)) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }
    int[] cnt = new int[n + 1];
    int max = 0;
    for (int i = 0; i < l; i++) {
      cnt[nums.get(i)]++;
      max = Math.max(max, cnt[nums.get(i)]);
    }

    for (int i = l; i < n; i++) {
      cnt[nums.get(i - l)]--;
      cnt[nums.get(i)]++;
      max = Math.max(max, cnt[nums.get(i)]);
    }
    return max;
  }

  private boolean check(List<Integer> nums, int k, int mid) {
    int n = nums.size();
    int[] cnt = new int[n + 1];
    int max = 0;
    for (int i = 0; i < mid; i++) {
      cnt[nums.get(i)]++;
      max = Math.max(max, cnt[nums.get(i)]);
    }

    for (int i = mid; i < n; i++) {
      cnt[nums.get(i - mid)]--;
      cnt[nums.get(i)]++;
      max = Math.max(max, cnt[nums.get(i)]);
    }
    return max + k >= mid;

  }

}
