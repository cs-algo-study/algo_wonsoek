import java.util.*;
import java.io.*;
 
class Solution
{
    static int[] parent;
     
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            parent = new int[n+1];
            for(int i = 0; i<=n;i++) parent[i] = i;
             
             
            for(int i = 0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a,b);
            }
            int result = 0;
            Set<Integer> set = new HashSet<>();
            for(int i = 1; i<=n; i++){
                set.add(find(i));
            }
            System.out.println("#"+t+ " "+set.size());
        }                      
    }
     
    public static int find(int n){
        if(parent[n] == n) return n;
        n = find(parent[n]);
        return n;
    }
     
    public static void union(int a , int b){
        int pa = find(a);
        int pb = find(b);
        if(pa<pb) parent[pa] = pb;
        else parent[pb] = pa;
    }
}
