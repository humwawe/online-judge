package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class DMinimumEulerCycle {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        long l = in.nextLong();
        long r = in.nextLong();
        long sum = 0;
        int idx = 1;
        while (sum + Math.max(1, 2 * (n - idx)) < l) {
            sum += 2 * (n - idx);
            idx++;
        }
        l -= sum;
        r -= sum;
        List<Integer> list = new ArrayList<>();
        int cur = idx;
        for (int i = 0; i < r; i++) {
            if (idx == n) {
                list.add(1);
                break;
            }
            if (i % 2 == 0) {
                list.add(idx);
            } else {
                cur += 1;
                list.add(cur);
            }
            if (cur == n) {
                idx++;
                cur = idx;
            }
        }
        for (int i = (int) l - 1; i < r; i++) {
            out.print(list.get(i), "");
        }
        out.println();

    }
}
