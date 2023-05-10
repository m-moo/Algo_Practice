import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public String[] solution(String[] files) {
        
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                /* 파일명 head, number, tail 분리 */
                String[] splitted1 = splitFile(o1);
                String[] splitted2 = splitFile(o2);

                /* head 비교 */
                int headCompare = splitted1[0].compareToIgnoreCase(splitted2[0]);

                /* number 비교 */
                if(headCompare == 0) {
                    int num1 = Integer.parseInt(splitted1[1]);
                    int num2 = Integer.parseInt(splitted2[1]);

                    return num1 - num2;
                }
                return headCompare;
            }
        });
        
        return files;
    }
    
    public String[] splitFile(String file) {
        Pattern pattern = Pattern.compile("(\\D+)(\\d{1,5})(.*)");
        Matcher matcher = pattern.matcher(file);

        if(matcher.matches())
            return new String[]{matcher.group(1), matcher.group(2),matcher.group(3)};

        return new String[]{};
    }
}