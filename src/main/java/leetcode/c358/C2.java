package leetcode.c358;

import java.math.BigInteger;

/**
 * @author hum
 */
public class C2 {
  public ListNode doubleIt(ListNode head) {
    ListNode tmp = head;
    StringBuilder sb = new StringBuilder();
    while (tmp != null) {
      sb.append(tmp.val);
      tmp = tmp.next;
    }

    BigInteger bigInteger = new BigInteger(sb.toString());
    BigInteger multiply = bigInteger.multiply(new BigInteger("2"));
    String s = multiply.toString();
    int n = s.length();
    tmp = new ListNode(s.charAt(0) - '0');
    ListNode res = tmp;
    for (int i = 1; i < n; i++) {
      tmp.next = new ListNode(s.charAt(i) - '0');
      tmp = tmp.next;
    }
    return res;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
