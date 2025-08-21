import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int N = queue1.length;
        long s1 = 0;
        long s2 = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int i = 0; i< N; i++){
            s1+=queue1[i];
            s2+=queue2[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        
        if((s1+s2)%2==1) return -1;
        
        long half = (s1+s2)/2;
        int cnt = 0;
        
        while(true){
            if(s1==s2) return cnt;
            if(s1>s2){
                int tmp = q1.poll();
                s2+=tmp;
                s1-=tmp;
                q2.add(tmp);
            }
            else if(s1<s2){
                int tmp = q2.poll();
                s2-=tmp;
                s1+=tmp;
                q1.add(tmp);
            }
            cnt++;
            if(cnt == N*3) return -1;
        }
    }
}
