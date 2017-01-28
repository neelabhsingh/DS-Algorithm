package hackerrank.matrix;
import java.util.Scanner;

/**
 * Created by neelabhsingh on 24/01/17.
 */
public class VolleyballMatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(volleyball(a, b));
    }
    static int volleyball(int a, int b) {
        int c;
        if (b > a) {
            c = b;
            b = a;
            a = c;
        }
        if ((a < 25 && b < 25) || a - b < 2) {
            return 0;
        } else if (a < 25 || b < 25) {
            int p = (int)Math.pow(10, 9) + 7;
            return nCrModP(a + b - 1, b, p);
        } else {
            if (a - b == 2) {
                int p = (int)Math.pow(10, 9) + 7;
                a = a - 24;
                b = b - 24;
                int x = nCrModP(48, 24, p) * aPowerXmodP(2, b, p);
                x = x % p;
                return x;

            } else {
                return 0;
            }
        }

    }
    public static int aPowerXmodP(int a, int x, int p) {
        int res = 1;
        while (x > 0) {
            if (x % 2 != 0)
                res = (res * a) % p;
            a = (a * a) % p;
            x = x / 2;
        }
        return res;
    }

    public static int modInverse(int a, int p) {
        return aPowerXmodP(a, p - 2, p);
    }

    public static int nCrModP(int n, int r, int p) {
        int num = 1, denom = 1;
        num = modFact(n, p);
        denom = (modFact(n - r, p) * modFact(r, p)) % p;
        return (num * modInverse(denom, p)) % p;
    }

    public static int modFact(int n, int p) {
        int res = 1;
        while (n > 0) {
            for (int i = 1, m = n % p; i <= m; i++)
                res = (res * i) % p;
            if ((n /= p) % 2 > 0)
                res = p - res;
        }
        return res;
    }
}
