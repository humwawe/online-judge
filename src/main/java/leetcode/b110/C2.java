package leetcode.b110;

/**
 * @author hum
 */
public class C2 {
  public ListNode insertGreatestCommonDivisors(ListNode head) {

    ListNode pre = head;
    while (pre != null && pre.next != null) {

      int g = gcd(pre.val, pre.next.val);

      ListNode tmp = new ListNode(g, pre.next);
      pre.next = tmp;

      pre = pre.next.next;
    }
    return head;
  }

  private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }


  class ListNode {
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
