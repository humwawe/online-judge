package acwing.contest.weekly.c18;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskA {

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int a = in.nextInt();
            if (set.contains(a)) {
                continue;
            }
            set.add(a);
            list.add(i);
        }
        if (list.size() >= k) {
            out.println("YES");
            for (int i = 0; i < k; i++) {
                out.print(list.get(i) + " ");
            }
        } else {
            out.println("NO");
        }
    }

}
