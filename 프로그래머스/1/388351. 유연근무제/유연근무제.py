def solution(schedules, timelogs, startday):
    answer = len(schedules)
    
    def calc_goal_time(time):
        time += 10
        minutes = (time % 100) // 10 * 10
        if minutes >= 60:
            time += 40
        return time
    
    for i in range(len(schedules)):
        start_day = startday
        goal = calc_goal_time(schedules[i])
        
        for get_t in timelogs[i]:
            day = start_day % 7
            start_day += 1
            
            if day == 6 or day == 0:
                continue

            if goal < get_t:
                answer -= 1
                break
    
    return answer