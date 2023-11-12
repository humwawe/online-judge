package leetcode.c371;

/**
 * @author hum
 */
public class C3 {
  public int minOperations(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int a = nums1[n - 1];
    int b = nums2[n - 1];
    int cnt = 0;
    for (int i = 0; i < n - 1; i++) {
      if (nums1[i] <= a && nums2[i] <= b) {
        continue;
      }
      if (nums2[i] <= a && nums1[i] <= b) {
        cnt++;
        continue;
      }
      cnt = n + 1;
      break;
    }

    int res = cnt;

    b = nums1[n - 1];
    a = nums2[n - 1];
    cnt = 1;
    for (int i = 0; i < n - 1; i++) {
      if (nums1[i] <= a && nums2[i] <= b) {
        continue;
      }
      if (nums2[i] <= a && nums1[i] <= b) {
        cnt++;
        continue;
      }
      cnt = n + 1;
      break;
    }
    res = Math.min(res, cnt);
    if (res <= n - 1) {
      return res;
    }
    return -1;
  }
}
