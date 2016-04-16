
public class MiddleAr {

	static double SourceValues[] = {1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static double MidArResult;
	
	
	static void calcMidAr (double[] sourceValues2) {
		MidArResult = 0;
		for ( double row : SourceValues ) {
			MidArResult = MidArResult + row;
		}
		MidArResult = MidArResult / SourceValues.length;
	}
	public static void main (String args[]) {
		calcMidAr (SourceValues);
		System.out.println(" Middle Average value = " + MidArResult );
	}
}
