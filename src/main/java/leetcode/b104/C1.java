package leetcode.b104;

/**
 * @author hum
 */
public class C1 {
  public int countSeniors(String[] details) {
    int res = 0;
    for (String detail : details) {
      int x = Integer.parseInt(detail.substring(11, 13));
      if (x > 60) {
        res++;
      }
    }
    return res;
  }
}
