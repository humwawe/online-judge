package leetcode.c331;

/**
 * @author hum
 */
public class C3 {
  int[] nums;
  int k;

  public int minCapability(int[] nums, int k) {
    this.nums = nums;
    this.k = k;
    int l = 1;
    int r = (int) 1e9;
    while (l < r) {
      int mid = l + r >> 1;
      if (check(mid)) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }

  private boolean check(int mid) {
    int len = nums.length;
    int c = 0;
    int last = -2;
    for (int i = 0; i < len; i++) {
      if (nums[i] <= mid && i != last + 1) {
        c++;
        last = i;
      }
    }
    return c >= k;
  }
}
