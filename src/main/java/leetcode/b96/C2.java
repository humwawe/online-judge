package leetcode.b96;

/**
 * @author hum
 */
public class C2 {
  public long minOperations(int[] nums1, int[] nums2, int k) {
    int n = nums1.length;
    long sum1 = 0;
    long sum2 = 0;
    for (int i = 0; i < n; i++) {
      int x = nums1[i] - nums2[i];
      if (x == 0) {
        continue;
      }
      if (k == 0) {
        return -1;
      }
      if (x % k != 0) {
        return -1;
      }
      if (x > 0) {
        sum1 += x / k;
      } else {
        sum2 += -x / k;
      }
    }
    if (sum1 != sum2) {
      return -1;
    }
    return sum1;
  }
}
