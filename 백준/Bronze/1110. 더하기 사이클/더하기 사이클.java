import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		String result = "result";
		
		int i=0;
		while(!str.equals(result)) {
			int frt=0;
			int bck=0;
			if(Integer.parseInt(i==0?str:result)<10) {
				frt = 0;
				bck = Integer.parseInt(i==0?str:result);
			}else {
				frt = Integer.parseInt((i==0?str:result).substring(0,1));
				bck = Integer.parseInt((i==0?str:result).substring(1,2));
			}
			int plus = frt+bck;
			if(bck==0) {
				result = (plus<10?Integer.toString(plus):Integer.toString(plus).substring(1,2));
			}else {
				result = Integer.toString(bck)+
						(plus<10?Integer.toString(plus):Integer.toString(plus).substring(1,2));
			}
			i++;
		}
		bw.write(i+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
}
