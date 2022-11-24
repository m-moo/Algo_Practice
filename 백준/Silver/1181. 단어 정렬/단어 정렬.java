import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        ArrayList<String> lst = new ArrayList<>();
        for(int i=0;i<n;i++){
            lst.add(bf.readLine());
        }
        HashSet<String> hs = new HashSet<>(lst);
        ArrayList<String> arr = new ArrayList<>(hs);
        arr.sort((o1,o2)-> {
            if(o1.length()==o2.length()){
                return o1.compareTo(o2);
            }
            return o1.length()-o2.length();
        });
        StringBuilder sb = new StringBuilder();
        for(String con:arr){
            sb.append(con+"\n");
        }
        System.out.println(sb);
    }
}
