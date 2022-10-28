package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CTicTacToe {
  char[][] s = new char[3][3];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        s[i][j] = in.nextCharacter();
      }
    }
    int sumA, sumB;
    sumA = sumB = 0;
    for (int i = 0; i < 3; ++i) {
      for (int j = 0; j < 3; ++j) {
        sumA += (s[i][j] == 'X' ? 1 : 0);
        sumB += s[i][j] == '0' ? 1 : 0;
      }
    }
    boolean flagA = win('X');
    boolean flagB = win('0');
    if (!(sumA == sumB || sumA == sumB + 1) || flagA && flagB || flagB && sumA > sumB || flagA && sumA == sumB) {
      out.println("illegal");
    } else if (flagA) {
      out.println("the first player won");
    } else if (flagB) {
      out.println("the second player won");
    } else if (sumA + sumB == 9) {
      out.println("draw");
    } else if (sumA == sumB) {
      out.println("first");
    } else if (sumA == sumB + 1) {
      out.println("second");
    }

  }

  boolean win(char c) {
    for (int i = 0; i < 3; ++i) {
      int cnt = 0;
      for (int j = 0; j < 3; ++j) {
        cnt += (s[i][j] == c ? 1 : 0);
      }
      if (cnt == 3) {
        return true;
      }
    }
    for (int i = 0; i < 3; ++i) {
      int cnt = 0;
      for (int j = 0; j < 3; ++j) {
        cnt += s[j][i] == c ? 1 : 0;
      }
      if (cnt == 3) {
        return true;
      }
    }
    int cnt = 0;
    for (int i = 0; i < 3; ++i) {
      cnt += (s[i][i] == c ? 1 : 0);
    }
    if (cnt == 3) {
      return true;
    }
    cnt = 0;
    for (int i = 0; i < 3; ++i) {
      cnt += (s[i][2 - i] == c ? 1 : 0);
    }
    return cnt == 3;
  }
}
