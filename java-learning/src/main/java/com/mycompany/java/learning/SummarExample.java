
public class SummarExample {
	static int sum;
	private static int summarization;
	static int Summarization (int... v) {
		
		int var[] =v;
		sum = 0;
		for (int i = 0; i< var.length; i++) {		
		sum = sum + var[i] ;
		}
		return sum;
	
		}
	static String Summarization (String...s){
		String sum[] = s;
		String st = sum[0];
		
		
		return st;
	}
	
	public static void main (String agrs[]) {
		
		summarization = Summarization(1,2,3,4,5,6,7,8,9,10);
		System.out.println("Summarization of  1-10 " + summarization );
	}
}
