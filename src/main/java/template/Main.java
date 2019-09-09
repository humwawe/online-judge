package template;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @author hum
 */
public class Main {
    private static final boolean DEBUG = true;
    private static Scanner sc;

    private static void init() {
        try {
            if (DEBUG) {
                sc = new Scanner(new FileInputStream("C:\\Users\\hum\\IdeaProjects\\online-judge\\src\\main\\java\\template\\in.txt"));
            } else {
                sc = new Scanner(new BufferedInputStream(System.in));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        init();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            System.out.println(s);
        }
    }
}
