import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int caseCnt = sc.nextInt();

        while(caseCnt --> 0) {
            String pattern = sc.next();
            int arrLen = sc.nextInt();
            String arr = sc.next();
            ac(arr, pattern);
        }
    }

    public static void ac(String arrStr, String pattern) {
        arrStr = arrStr.replaceAll("[\\[\\]]", "");
        Deque<String> deque;
        if(arrStr.length() == 0) {
            deque = new ArrayDeque<>();
        }else {
            String[] arr = arrStr.split(",");
            deque = new ArrayDeque<>(Arrays.asList(arr));
        }
        boolean isReversed = false;

        for(int i=0;i<pattern.length();i++) {
            char p = pattern.charAt(i);
            if(p == 'R') {
                isReversed = !isReversed;
            }else {
                if(deque.isEmpty()) {
                    System.out.println("error");
                    return;
                }
                if(isReversed) {
                    deque.pollLast();
                } else {
                    deque.pollFirst();
                }
            }
        }

        StringBuilder sb = new StringBuilder("[");
        while(!deque.isEmpty()) {
            sb.append(isReversed ? deque.pollLast() : deque.pollFirst());
            if(!deque.isEmpty()) sb.append(",");
        }
        sb.append("]");
        System.out.println(sb);
    }
}