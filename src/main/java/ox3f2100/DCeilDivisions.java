package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class DCeilDivisions {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int tmp = n;
        List<int[]> res = new ArrayList<>();
        for (int i = n - 1; i > 2; i--) {
            if (tmp / i >= i) {
                tmp = (tmp + i - 1) / i;
                res.add(new int[]{n, i});
            }
            res.add(new int[]{i, n});
        }
        while (tmp >= 2) {
            tmp = (tmp + 1) / 2;
            res.add(new int[]{n, 2});
        }
        out.println(res.size());
        for (int[] r : res) {
            out.println(r[0], r[1]);
        }
    }
}
