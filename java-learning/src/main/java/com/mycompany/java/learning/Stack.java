
class Stack {

	 	private char q[];
	    private int putloc, getloc;
	    
	    Stack (int size) {
	        q = new char[size + 1];
	        putloc = getloc = 0;
	    }
	    void put (char ch) {
	        // поместить на один элемент выше
	        if (putloc == q.length - 1) {
	            System.out.println(" - Queue is full ");
	            return;
	        }
	        putloc++;
	        q[putloc] = ch;
	    }
	    char get() {
	        // вернуть один элемент последний
	        if (getloc == putloc ) {
	            System.out.println(" - Queue is empty ");
	            return (char) 0;
	            }
	            getloc++ ;
	            return q[getloc];
	        
	    }
}
class StackMan {
	public static void main (String args[]) {
		Stack bigQ = new Stack(100);
		Stack smallQ = new Stack(4);
        
        char ch;
        int i;
        
        for (i = 0; i < 26; i++) {
            bigQ.put((char)('A' + i));
            
            
        }
        System.out.print("Context of bigQ : " );
        for (i=0; i< 26; i++) {
                ch = bigQ.get();
                
                if ( ch != (char) 0) System.out.print((ch));
            }
            System.out.println("\n");
        
        System.out.println("Using smallQ to getnerate erros ");
        
        for(i = 0; i < 5; i++) {
            System.out.print("Attempt to store " + (char) ('Z' - i));
            smallQ.put((char)('Z' - i));
            System.out.println();
        }
        System.out.print("Context of smallQ :");
        for (i =0; i < 5; i++) {
            ch = smallQ.get();
            if (ch != (char) 0 ) System.out.print(ch);
        }
        
    }
}
