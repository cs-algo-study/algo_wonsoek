import java.util.*;

class Element{
    String city;
    int time;
}

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0){
            return cities.length*5;
        }
        
        for(int i = 0; i< cities.length; i++){
            cities[i] = cities[i].toUpperCase();
        }
        
        
        String[] lru = new String[cacheSize];
        int e = 0;
        lru[0] = cities[0];
        answer+=5;
        
        for(int i= 1; i< cities.length;i++){
            boolean cacheHit = false;
            
            for(int j = 0; j<=e ; j++){
                if(cities[i].equals(lru[j])){
                    for(int k = j; k<e; k++){
                        lru[k] = lru[k+1];
                    }
                    lru[e] = cities[i];
                    cacheHit = true;
                    answer++;
                    break;
                }
            }
            
            if(!cacheHit){
                e++;
                if(e == cacheSize){
                    for(int j=0;j<cacheSize-1; j++){
                        lru[j] = lru[j+1];
                    }
                    lru[cacheSize-1] = cities[i];
                    e--;
                }
                else{
                    lru[e] = cities[i];
                }
                answer+=5;
            }
        }
        
        return answer;
    }
    
}