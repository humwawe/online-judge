package acwing.contest.weekly.c33;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class TaskC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = in.nextString();
            if (!map.containsKey(name)) {
                map.put(name, new HashSet<>());
            }
            int k = in.nextInt();
            for (int j = 0; j < k; j++) {
                map.get(name).add(in.nextString());
            }
        }

        out.println(map.size());
        for (String name : map.keySet()) {
            out.print(name + " ");
            Set<String> tmp = new HashSet<>();
            Set<String> set = map.get(name);
            List<String> list = new ArrayList<>(set);
            f:
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                for (int j = 0; j < list.size(); j++) {
                    if (i == j) {
                        continue;
                    }
                    String s1 = list.get(j);
                    if (s1.endsWith(s)) {
                        continue f;
                    }
                }
                tmp.add(s);

            }
            out.print(tmp.size());
            for (String s : tmp) {
                out.print(" " + s);
            }
            out.println();
        }

    }
}
