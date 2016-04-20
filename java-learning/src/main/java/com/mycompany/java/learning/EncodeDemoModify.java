
public class EncodeDemoModify {
    
    public static void main (String args[]){
        String msg = "This is a text for I like Java";
        String encmsg = "";
        String decmsg = "";
        char decCh = 0 ;
        char encCh = 0;
        
        int key = 88;
        String codeKey = "CoDeRsTrDw fdg fgd fgdf edsfwefdsdf";
        char codeChars[] = codeKey.toCharArray();
        
        System.out.print("Original message : ");
        System.out.print(msg);
        System.out.println();
        
        for (int i = 0; i < msg.length(); i++) {
        	//int codeKeyIndex = codeKey.length();
        	for ( int j = 0; j < codeKey.length(); j++ ) {
        		
        		encCh = (char) (msg.charAt(i) ^ codeKey.charAt(j));
        	}
        	encmsg = encmsg + (char) encCh;
        }
        System.out.print("Encoded message:  ");
        System.out.print(encmsg);
        System.out.println();
    
    
    for (int i = 0; i < msg.length(); i++ ) {
    	
    	for ( int j = 0; j < codeKey.length(); j++ ) {
    		
    		decCh = (char) (encmsg.charAt(i) ^ codeKey.charAt(j));
    	}
    	decmsg = decmsg + (char)decCh;
    }
        System.out.print("Decoded message : ");
        System.out.print(decmsg);
        System.out.println();
    }
    
}