import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    private List<Integer> candidateKeys = new ArrayList<>();

    
    public int solution(String[][] relation) {
        int attrCnt = relation[0].length;
        for(int key=1;key<(1 << attrCnt);key++) { // 속성의 모든 경우의 수를 탐색
            // 유일성과 최소성 만족 검사
            if(isUnique(key,relation) && isMinimal(key)) 
                candidateKeys.add(key); 
        }

        return candidateKeys.size();
    }
    public boolean isUnique(int key, String[][] relation) {
        HashSet<String> seenTuples = new HashSet<>();
        for(String[] tuple:relation) {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<tuple.length;i++) {
                // key의 패턴에 맞는 튜플을 조합
                if((key & (1 << i)) != 0) sb.append(tuple[i]);
            }
            // 이미 있는 튜플 조합이라면 유일성 불만족
            if(!seenTuples.add(sb.toString())) return false;
        }
        return true;
    }

    public boolean isMinimal(int key) {
        for(int candidateKey:candidateKeys) {
            // 이미 존재하는 후보키가 일부분에 속한다면 최소성 불만족
            if((key & candidateKey) == candidateKey) return false;
        }
        return true;
    }
}