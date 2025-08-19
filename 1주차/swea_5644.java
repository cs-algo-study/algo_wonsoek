import java.io.IOException;
import java.util.*;
import java.io.*;

public class Solution {

    static int[] dx = {0, 0, 1, 0, -1};
    static int[] dy = {0, -1, 0, 1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <=T; testCase++){
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int[] moverA = new int[M];
            int[] moverB = new int[M];
            int[][] aps = new int[A][4];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++){
                moverA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for( int i = 0; i < M; i++){
                moverB[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 0; i<A;i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<4;j++){
                    aps[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = run(M,A,moverA,moverB,aps);
            System.out.println("#"+testCase+" "+answer);
        }

    }

    private static int run(int M, int A, int[] moverA, int[] moverB, int[][] aps){
        int result = 0;

        int ax = 1, ay = 1;
        int bx = 10, by = 10;

        Arrays.sort(aps, (a,b)->b[3]-a[3]);


        for (int i = 0; i <= M; i++) {
            List<Integer> aList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();

            for (int j = 0; j < A; j++) {
                if (isCoverage(ax, ay, aps[j])) aList.add(j);
                if (isCoverage(bx, by, aps[j])) bList.add(j);
            }

            int maxCharge = 0;
            for (int a : aList) {
                for (int b : bList) {
                    if (a == b) {
                        maxCharge = Math.max(maxCharge, aps[a][3]);
                    } else {
                        maxCharge = Math.max(maxCharge, aps[a][3] + aps[b][3]);
                    }
                }
            }

            if (aList.isEmpty() && !bList.isEmpty()) {
                for (int b : bList) {
                    maxCharge = Math.max(maxCharge, aps[b][3]);
                }
            }
            if (!aList.isEmpty() && bList.isEmpty()) {
                for (int a : aList) {
                    maxCharge = Math.max(maxCharge, aps[a][3]);
                }
            }

            result += maxCharge;

            if (i == M) break;
            ax += dx[moverA[i]];
            ay += dy[moverA[i]];
            bx += dx[moverB[i]];
            by += dy[moverB[i]];
        }

        return result;
    }

    private static boolean isCoverage(int x, int y, int[] ap){
        int length = Math.abs(x-ap[0])+Math.abs(y-ap[1]);
        return length <= ap[2];
    }
}
