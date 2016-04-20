
public class Books {

	
	String author;
	String nameBook;
	int number;
	static int numbers = 0;
	Books () {
		number = ++numbers;
	}
	
	Books (String author, String nambeBook) {
		this();
		this.author = author;
		this.nameBook = nameBook;
	}
	public static void main (String args[]) {
		
		Books myLikeBook = new Books();
		myLikeBook.author = "Берн Страструп";
		myLikeBook.nameBook = "Язык программирования С++";
	
		Books myBook = new Books ("Аккуратов", "Знакомьтесь Java");
	
	}
}
