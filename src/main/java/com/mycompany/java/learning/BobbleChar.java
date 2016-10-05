
public class BobbleChar {

	

	public static void main (String args[]) {
		
		String chars [] = { "Afv", "fwF", "Zfvs", "ARVR", "FWEFS", "ZFfz", "Zeqoi", "ooxX", "OXou", "Uxw" };
		int a,b;
		String t;
		int size;
		size = 10;
		System.out.print("Original array is: ");
		for (int i=0; i < chars.length; i++ ) {
			System.out.print(" " + chars[i]);
			//System.out.print();
		}
		for (a=1; a < chars.length; a++) {
			for (b=chars.length - 1; b >= a; b--) {
				if (chars[b-1].length() > chars[b].length()) {
					t = chars[b-1];
					chars[b-1] = chars[b];
					chars[b] = t;
					int index = t.indexOf("A");
				}
					
			}
		}
		System.out.println();
		System.out.print("Sorted array is: ");
		for ( int i=0; i< size; i++) {
			System.out.print(" " + chars[i]);
			//System.out.println("IndexOfChar " + );
			
		}
		
	}
	
	
}
