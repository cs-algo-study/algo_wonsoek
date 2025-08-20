import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            int maxCheese = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxCheese = Math.max(maxCheese, map[i][j]);
                }
            }

            int answer = 1;

            for (int day = 1; day <= maxCheese; day++) {
                visited = new boolean[N][N];
                int count = 0;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (map[i][j] > day && !visited[i][j]) {
                            dfs(i, j, day);
                            count++;
                        }
                    }
                }

                answer = Math.max(answer, count);
            }

            System.out.println("#" + tc + " " + answer);
        }
    }

    static void dfs(int x, int y, int day) {
        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visited[nx][ny] && map[nx][ny] > day) {
                    dfs(nx, ny, day);
                }
            }
        }
    }
}
