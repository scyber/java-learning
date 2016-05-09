package com.mycompany.java.learning;
class StackFullException extends Exception {
    int size;

    StackFullException(int s) { size = s; }



    public String toString()    {
        return "\n Stack is full. Maximum size is " + size;
    }
}
// Исключение, указывающее на опустошение очереди,
class StackEmptyException extends Exception {
    public String toString()    {
        return "\n Stack is empty.";
    }
}
class Stack  {

	 	private char q[];
	    private int putloc, getloc;
	    
	    Stack (int size) {
	        q = new char[size + 1];
	        putloc = getloc = 0;
	    }
	    void put (char ch) throws StackFullException {
	        // ��������� �� ���� ������� ����
	        if (putloc == q.length - 1) {
	            //System.out.println(" - Queue is full ");
                throw new StackFullException( putloc);
                //return;
	        }

	        putloc++;
	        q[putloc] = ch;
	    }
	    char get() throws StackEmptyException {
	        // ������� ���� ������� ���������
	        if (getloc == putloc ) {
	            //System.out.println(" - Queue is empty ");
                throw new StackEmptyException();
	            //return (char) 0;
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
            try {
                for (i = 0; i < 26; i++) {
                    bigQ.put((char)('A' + i));
                }
            } catch (StackFullException ex) {
               // ex.printStackTrace();
            }


        System.out.print("Context of big Q : " );
        try {
            for (i=0; i< 26; i++) {
                ch = bigQ.get();

                if ( ch != (char) 0) System.out.print((ch));
            }
            System.out.println("\n");
        }catch (StackEmptyException ex ) {
           // ex.printStackTrace();
        }


        //System.out.println("Using small Q to getnerate erros ");
        try {
            for (i = 0; i < 5; i++) {
                System.out.print("Attempt to store " + (char) ('Z' - i));
                smallQ.put((char) ('Z' - i));
                System.out.println();
            }
        } catch ( StackFullException ex) {
           // ex.printStackTrace();
        }

        System.out.print("Context of small Q :");
        try {
            for (i =0; i < 5; i++) {
                ch = smallQ.get();
                if (ch != (char) 0 ) System.out.print(ch);
            }
        }catch ( StackEmptyException ex ) {
           // ex.printStackTrace();
        }

        
    }
}
