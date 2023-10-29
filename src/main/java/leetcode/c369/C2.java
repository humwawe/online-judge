package leetcode.c369;

/**
 * @author hum
 */
public class C2 {
  public long minSum(int[] nums1, int[] nums2) {
    long sum1 = 0;
    int cnt1 = 0;
    for (int i = 0; i < nums1.length; i++) {
      sum1 += nums1[i];
      if (nums1[i] == 0) {
        cnt1++;
      }
    }

    long sum2 = 0;
    int cnt2 = 0;
    for (int i = 0; i < nums2.length; i++) {
      sum2 += nums2[i];
      if (nums2[i] == 0) {
        cnt2++;
      }
    }

    if (cnt1 == 0 && cnt2 == 0) {
      if (sum1 == sum2) {
        return sum1;
      }
      return -1;
    }

    if (cnt1 != 0 && cnt2 == 0) {
      if (sum2 >= sum1 + cnt1) {
        return sum2;
      }
      return -1;
    }

    if (cnt1 == 0 && cnt2 != 0) {
      if (sum1 >= sum2 + cnt2) {
        return sum1;
      }
      return -1;
    }

    return Math.max(sum1 + cnt1, sum2 + cnt2);
  }
}
