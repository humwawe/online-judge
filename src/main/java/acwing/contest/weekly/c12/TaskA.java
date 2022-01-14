package acwing.contest.weekly.c12;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        Set<Integer> set = new HashSet<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (set.contains(a[i])) {
                continue;
            }
            set.add(a[i]);
            list.addFirst(a[i]);
        }
        out.println(list.size());
        for (int i = 0; i < list.size() - 1; i++) {
            out.print(list.get(i) + " ");
        }
        out.println(list.get(list.size() - 1));
    }
}
