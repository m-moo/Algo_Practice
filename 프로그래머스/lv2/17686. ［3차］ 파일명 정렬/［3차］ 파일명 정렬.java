import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public String[] solution(String[] files) {
        Pattern p = Pattern.compile("(\\D+)(\\d{1,5})");

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Matcher m1 = p.matcher(o1.toLowerCase());
                Matcher m2 = p.matcher(o2.toLowerCase());
                m1.find();
                m2.find();
                
                if(m1.group(1).equals(m2.group(1))) {
                    return Integer.parseInt(m1.group(2)) - Integer.parseInt(m2.group(2));
                }
                return m1.group(1).compareTo(m2.group(1));   
            }
        });
        
        return files;
    }
}