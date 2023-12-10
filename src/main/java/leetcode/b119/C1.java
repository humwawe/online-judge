package leetcode.b119;

/**
 * @author hum
 */
public class C1 {
  public int[] findIntersectionValues(int[] nums1, int[] nums2) {
    int[] res = new int[2];
    for (int i : nums1) {
      for (int j : nums2) {
        if (i == j) {
          res[0]++;
          break;
        }
      }
    }
    for (int i : nums2) {
      for (int j : nums1) {
        if (i == j) {
          res[1]++;
          break;
        }
      }
    }
    return res;

  }
}
