class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";

        // "#"을 처리하는 부분
        m = m.replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f").replaceAll("G#", "g").replaceAll("A#", "a");

        int maxSongLen = 0;
        for(int i=0;i<musicinfos.length;i++) {
            String[] info = musicinfos[i].split(",");
            String[] start = info[0].split(":");
            String[] end = info[1].split(":");
            String melody = info[3].replaceAll("C#", "c").replaceAll("D#", "d").replaceAll("F#", "f").replaceAll("G#", "g").replaceAll("A#", "a");

            int songLen = ((Integer.parseInt(end[0])-Integer.parseInt(start[0]))*60)
                    + (Integer.parseInt(end[1])-Integer.parseInt(start[1]));

           StringBuilder sb = new StringBuilder();
            for(int j=0;j<songLen;j++) {
                sb.append(melody.charAt(j%melody.length()));
            }

            if(sb.toString().contains(m)) {
                if(songLen > maxSongLen) {
                    answer = info[2];
                    maxSongLen = songLen;
                }
            }
        }
        return answer.isEmpty()?"(None)":answer;
    }
}