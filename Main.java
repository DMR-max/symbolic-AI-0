import java.util.*;

public class Main {
	


	public static void main(String[] args) {
		String naam = ""; //string naam voor zoekop.nextline()
		System.out.println("Hello"); // hello printen
		Phonebook database = new Phonebook ("phonebook.txt"); // nieuwe phonebook aanmaken
		System.out.println(database.toString()); //printen van vector
		Scanner zoekop = new Scanner(System.in);  // Creeren van een scanner voor inlezen
		System.out.println("Geef een naam om het nummer te zoeken: ");
		naam = zoekop.nextLine();  // lees wat is ingevuld voor nummer zoeken
		zoekop.close();//afsluiten van de scanner
		System.out.println(database.number(naam) + "\n"); // geef naam met het correcte nummer weer
		database.sort(); //start sorteren
		System.out.println(database.toString()); //print de gesorteerde vector

	}

}
