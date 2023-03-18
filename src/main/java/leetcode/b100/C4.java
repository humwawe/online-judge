package leetcode.b100;

/**
 * @author hum
 */
public class C4 {
  public long repairCars(int[] ranks, int cars) {
    long l = 1;
    long r = (long) 1e14;

    while (l < r) {
      long mid = l + r >> 1;

      long all = 0;
      for (int rank : ranks) {
        long cnt = (long) Math.sqrt(mid / rank);
        if (rank * (cnt + 1) * (cnt + 1) <= mid) {
          cnt = cnt + 1;
        }
        all += cnt;
      }
      if (all >= cars) {
        r = mid;
      } else {
        l = mid + 1;
      }

    }

    return l;
  }
}
