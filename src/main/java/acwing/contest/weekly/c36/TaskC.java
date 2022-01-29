package acwing.contest.weekly.c36;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
    int n;
    String s;
    int a, b;
    int[] sumX;
    int[] sumY;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        s = in.nextString();
        a = in.nextInt();
        b = in.nextInt();
        sumX = new int[n + 1];
        sumY = new int[n + 1];
        int l = 0;
        int r = n;
        if (n < Math.abs(a) + Math.abs(b) || (n - Math.abs(a) - Math.abs(b)) % 2 != 0) {
            out.println("-1");
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sumX[i + 1] = sumX[i];
            sumY[i + 1] = sumY[i];
            if (c == 'U') {
                sumY[i + 1]++;
            } else if (c == 'D') {
                sumY[i + 1]--;
            } else if (c == 'L') {
                sumX[i + 1]--;
            } else {
                sumX[i + 1]++;
            }
        }

        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        out.println(l);
    }

    private boolean check(int mid) {
        for (int i = 0; i + mid - 1 < n; i++) {
            int j = i + mid - 1;
            int x = sumX[i];
            x += sumX[n] - sumX[j + 1];
            int y = sumY[i];
            y += sumY[n] - sumY[j + 1];
            if (Math.abs(x - a) + Math.abs(y - b) <= mid && (mid - Math.abs(x - a) - Math.abs(y - b)) % 2 == 0) {
                return true;
            }
        }
        return false;
    }
}
