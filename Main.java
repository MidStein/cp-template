import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;

import java.util.*;

public class Main {
    static final File ip = new File("input.txt");
    static final File op = new File("output.txt");
    static InputReader in;

    static {
        try {
            System.setOut(new PrintStream(op));
            System.setIn(new FileInputStream(ip));
        } catch (Exception e) {
        }

        in = new InputReader(System.in);
    }

    static void solve() {
        
    }

    public static void main(String[] args) throws FileNotFoundException {
        int t = in.readInt();
        int t1 = 1;
        while (t1 <= t) {
            solve();
            System.out.println();
            t1++;
        }
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }

    static class Aid {
        @SafeVarargs
        static <T> void println(T... varargs) {
            print(varargs);
            System.out.println();
        }
        @SafeVarargs
        static <T> void print(T... varargs) {
            for (T arg : varargs) {
                System.out.print(arg + " ");
            }
        }

        static void printMatrix(int[][] mat, int rows, int cols) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(mat[i][j]);
                }
                System.out.println();
            }
        }
    
        static void getRandomSequence(int length, int max) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                int randNum = (int) Math.floor(Math.random() * max) + 1;
                if (!list.contains(randNum)) {
                    list.add(randNum);
                } else {
                    i--;
                }
            }
    
            System.out.println("Unsorted:");
            System.out.println(list);
    
            Collections.sort(list);
            System.out.println("Sorted:");
            System.out.println(list);
        }
    }
    
    static class Pair {
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }

        static class SortByFirst implements Comparator<Pair> {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.first - p2.first;
            }
        }
    }
    static class Triplet {
        int first;
        int second;
        int third;

        public Triplet(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ", " + third + ")";
        }

        static class SortByFirst implements Comparator<Triplet> {
            @Override
            public int compare(Triplet t1, Triplet t2) {
                return t1.first - t2.first;
            }
        }
    }
}

