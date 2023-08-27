package leetcode.c360;

/**
 * @author hum
 */
public class C1 {
  public int furthestDistanceFromOrigin(String moves) {
    int res = 0;
    int cnt = 0;
    for (int i = 0; i < moves.length(); i++) {
      if (moves.charAt(i) == 'L') {
        res++;
      } else if (moves.charAt(i) == 'R') {
        res--;
      } else {
        cnt++;
      }
    }
    return Math.max(Math.abs(res + cnt), Math.abs(res - cnt));
  }
}
