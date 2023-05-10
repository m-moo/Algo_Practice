import java.util.LinkedList;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        LinkedList<Character> skillLink = new LinkedList<>();
        for(int i=0;i<skill.length();i++) {
            skillLink.add(i,skill.charAt(i));
        }

        for(int i=0;i<skill_trees.length;i++) {
            int cnt = 0;
            int treeLen = skill_trees[i].length();
            int j = 0;
            for(;j<treeLen;j++) {
                char c = skill_trees[i].charAt(j);

                if(skillLink.contains(c)) {
                    if(skillLink.get(cnt) != c) break;
                    cnt++;
                }
            }
            if(j == treeLen) answer++;
        }
        
        return answer;
    }
}