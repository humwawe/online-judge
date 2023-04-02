package leetcode.b101;

/**
 * @author hum
 */
public class C1 {
  public int minNumber(int[] nums1, int[] nums2) {
    int res = 100;
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length; j++) {
        res = Math.min(res, nums1[i] * 10 + nums2[j]);
        res = Math.min(res, nums2[j] * 10 + nums1[i]);
        if (nums1[i] == nums2[j]) {
          res = Math.min(res, nums1[i]);
        }
      }
    }
    return res;
  }
}
