package acwing.contest.weekly.c35;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class TaskB {
    List<Long> a = new ArrayList<>();
    List<Character> b = new ArrayList<>();
    long res = (long) (1e15 + 5);

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        for (int i = 0; i < 4; i++) {
            a.add(in.nextLong());
        }

        for (int i = 1; i <= 3; i++) {
            b.add(in.nextCharacter());
        }
        dfs(a, b);
        out.println(res);
    }

    private void dfs(List<Long> a, List<Character> b) {
        if (b.size() == 1) {
            if (b.get(0) == '*') {
                res = Math.min(res, a.get(0) * a.get(1));
            } else {
                res = Math.min(res, a.get(0) + a.get(1));
            }
        }
        int size = a.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                List<Long> na = new ArrayList<>();
                for (int k = 0; k < size; k++) {
                    if (k != i && k != j) {
                        na.add(a.get(k));
                    }
                }
                List<Character> nb = new ArrayList<>();
                for (int k = 1; k < b.size(); k++) {
                    nb.add(b.get(k));
                }
                if (b.get(0) == '*') {
                    na.add(a.get(i) * a.get(j));
                } else {
                    na.add(a.get(i) + a.get(j));
                }
                dfs(na, nb);
            }
        }
    }


}
