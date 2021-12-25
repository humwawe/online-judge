package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class CEhabAndPrefixMEXs {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = new int[n + 1];
        boolean[] vis = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
            vis[a[i]] = true;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                list.add(i);
            }
        }
        int j = 0;
        for (int i = 1; i <= n; i++) {
            if (a[i] == a[i - 1]) {
                out.print(list.get(j++) + " ");
            } else {
                out.println(a[i - 1] + " ");
            }
        }
    }
}
