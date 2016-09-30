
 abstract class ClassA {
	 public abstract void print();
	 public String getName (){
		 return Object.class.getName();
	 }
 }
 class ClassAB extends ClassA{
	 public void print(){
		 System.out.println("B");
	 }
 }
 class ClassC {
	 public static void main(String args[]) {
		 ClassAB cl = new ClassAB();
		 ClassA cl2 = (ClassA) new ClassAB();
		 System.out.print(cl2.getName());
	 }
 }