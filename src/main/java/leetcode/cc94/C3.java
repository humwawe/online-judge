package leetcode.cc94;

/**
 * @author hum
 */
public class C3 {

  public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
    long l = 1;
    long r = (long) 1e12;
    long mul = (long) divisor1 * divisor2;
    while (l < r) {
      long mid = l + r >> 1;
      long c1 = mid / divisor1;
      long c2 = mid / divisor2;
      long c3 = mid / lcm(divisor1, divisor2);
      long ll = mid - c1;
      long rr = mid - c2;
      long mm = mid - (c1 + c2 - c3);
      if (check(ll, rr, mm, uniqueCnt1, uniqueCnt2)) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return (int) l;
  }

  private boolean check(long ll, long rr, long mm, int uniqueCnt1, int uniqueCnt2) {
    uniqueCnt1 -= (ll - mm);
    uniqueCnt2 -= (rr - mm);
    if (uniqueCnt1 <= 0 && uniqueCnt2 <= 0) {
      return true;
    }
    if (uniqueCnt1 <= 0) {
      return uniqueCnt2 <= mm;
    }

    if (uniqueCnt2 <= 0) {
      return uniqueCnt1 <= mm;
    }

    return uniqueCnt1 + uniqueCnt2 <= mm;

  }

  public long gcd(long a, long b) {
    return b != 0 ? gcd(b, a % b) : a;
  }

  public long lcm(long a, long b) {
    return a / gcd(a, b) * b;
  }
}
