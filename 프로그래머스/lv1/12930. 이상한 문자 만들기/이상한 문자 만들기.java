class Solution {
    public String solution(String s) {
        String[] words = s.split(" ",-1);
        
        StringBuffer sb = new StringBuffer();
        for(int i=0;i< words.length;i++) {
            String w = words[i];
            if(!w.equals("")) {
                for(int j=0;j<w.length();j++) {
                    String c = Character.toString(w.charAt(j));
                    
                    if(j%2==0) c=c.toUpperCase();
                    else c=c.toLowerCase();
                    sb.append(c);
                }
                sb.append(" ");
            }else{
                sb.append(" ");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        
        return sb.toString();
    }
}