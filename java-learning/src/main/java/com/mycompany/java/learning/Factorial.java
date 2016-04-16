
class Factorial {


	
  int factR (int n) {
		int result;
		if ( n == 1) return 1;
		
		result = factR(n-1)*n;
		System.out.println("int result " + result);
		return result;
	}

	
	int factI (int n) {
		int t, result;
		
		result = 1;
		for(t=1; t <= n; t++) result *=t;
		return result;
	}
}
class Recursion {
	
	public static void main (String args[]) {
		
		Factorial f = new Factorial();
		
		System.out.println("Factorial is using Recursive method ");
		System.out.println("Factorial of 3 is " + f.factR(3));
		System.out.println("Factorial of 4 is " + f.factR(4));
		System.out.println("Factorial of 5 is " + f.factR(5));
		
		System.out.println();
		
		System.out.println("Factorial is using Interactive method ");
		System.out.println("Factorial of 3 is " + f.factI(3));
		System.out.println("Factorial of 4 is " + f.factI(4));
		System.out.println("Factorial of 5 is " + f.factI(5));
		
		
	}
}