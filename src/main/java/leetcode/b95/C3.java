package leetcode.b95;

/**
 * @author hum
 */
public class C3 {
  public int xorBeauty(int[] nums) {
    int res = 0;
    for (int i = 0; i < 31; i++) {
      int x = 0;
      for (int num : nums) {
        if ((num >> i & 1) == 1) {
          x ^= 1;
        }
      }
      if (x == 1) {
        res |= 1 << i;
      }
    }
    return res;
  }
}
