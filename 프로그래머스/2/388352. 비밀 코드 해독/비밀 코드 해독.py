def solution(n, q, ans):
    answer = 0
    def backtrack(start, path):        
        if len(path) == 5:
            if is_valid(path):
                nonlocal answer
                answer += 1
            return
            
        for i in range(start, n + 1):
            path.append(i)
            backtrack(i + 1, path)
            path.pop()
            
    def is_valid(comb):
        comb_set = set(comb)
        for i in range(len(q)):
            q_set = set(q[i])
            if len(comb_set & q_set) != ans[i]:
                return False
        return True
    
    backtrack(1, [])
    
    return answer