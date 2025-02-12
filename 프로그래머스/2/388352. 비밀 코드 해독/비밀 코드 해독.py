from itertools import combinations

def solution(n, q, ans):
    answer = 0
            
    def is_valid(comb):
        comb_set = set(comb)
        for i in range(len(q)):
            q_set = set(q[i])
            if len(comb_set & q_set) != ans[i]:
                return False
        return True
    
    all_combinations = list(combinations(range(1, n+1), 5))
    
    for comb in all_combinations:
        if is_valid(comb):
            answer += 1
        
    return answer