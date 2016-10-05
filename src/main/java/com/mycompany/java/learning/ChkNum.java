
class ChkNum {

	   boolean isEven(int x) {
		if ( (x%2) == 0) return true;
		else return false;
	}
	
}

class ParmDemo {
	public static void main (String args[]) {
		ChkNum e = new ChkNum();
		for ( int i = 1; i<= 10 ; i++ ) {
//			
//		if (e.isEven(10)) System.out.println(" 10 is even ");
//		if (e.isEven(9)) System.out.println(" 9 is even ");
//		if (e.isEven(8)) System.out.println(" 8 is even ");
//		if (e.isEven(7)) System.out.println("7 is even ");
//		
		if (e.isEven(i)) System.out.println( i + " is even ");
		}
	}
}