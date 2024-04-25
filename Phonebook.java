import java.util.*; //importeren van java.util
import java.io.*; //importeren van java.io

public class Phonebook {
	Vector <Person> people;
	int n; //class variable omdat het niet in de methode zelf mocht voor recursie
	
	public Phonebook(String file) {
		people = new Vector <Person> ();
		read(file);
	}
	
	public void read (String file) {//begin functie inlezen bestand
		try {//try catch voor fouten
	      File bestandnaam = new File(file); //bestandsnaam doorgeven
	      Scanner lezer = new Scanner(bestandnaam); //scanner voor het inlezen van het bestand
	      while (lezer.hasNextLine()) {//while loop om door alle regels in het bestand te gaan
	        String data = lezer.nextLine(); //volgende line in het bestand  
	        StringTokenizer st = new StringTokenizer(data, ",");//naam los van de nummers maken in tokenizer
	        Person L = new Person(st.nextToken(), st.nextToken());//object L aanmaken en de naam en het nummer erin invoegen 
	        people.add(L); //naam toevoegen aan vector
	      }
	      lezer.close();
	    } catch (Exception error) {// als er een fout gevonden is
	      System.out.println("Fout gevonden.");
	      error.printStackTrace();
	    }
	}
	
	public String toString() {
		String allesin1 = ""; //lege string die gevuld wordt met de namen en nummers
		for (Person L: people) {//loop om door alle people te gaan
			 //printen van name en number in de vector die onderdeel zijn van class Person
			allesin1 = allesin1 + L.name + " " + L.number + "\n";
			}
		return allesin1; //returnen van de string met alles erin	
	}
	
	public String number(String name) {
		for (Person L: people) {//loop om door alle people te gaan
			if (name.equals(L.name)) {
				return L.name + " " + L.number;
			}
		}
		return "Geen overeenkomsten gevonden."; //als er geen overeenkomsten zijn
			
		
	}
	
public void sort(){
		n = people.size();
		people = sort(people);//eerste aanroep recursie
		
		
	}
	private Vector <Person> sort (Vector <Person> tosort) {

		//Bubblesort base case
		if (n == 1) {
			return tosort;
		}//body
		int count = 0; //zodat de recursie niet onnodig in wordt gegaan
		for (int i = 0; i < n-1; i++) {
			Person P = tosort.get(i); //haalt huidige in de vector op
			Person L = tosort.get(i+1); // haalt de volgende in de vector op
			String s2 = P.name; //zet type person om in string name
			String s1 = L.name; //zet type person om in string name
			if (isSmaller(s1, s2)) { //isSmaller om te vergelijken of s1 kleiner is dan s2			   
                tosort.set(i, L); // draait de namen om
                tosort.set(i + 1, P);
                count = count +1;
			}
		}
		if (count == 0) {
			return tosort;
		}
		n = n-1;
		return sort(tosort);// recursie
	}
	private boolean isSmaller (String s1, String s2) {
	// returns true if s1 <s2 alphabetically

		boolean builtdifferent = false; //boolean voor de while loop
		boolean iskleiner = false; //boolean voor als s1 kleiner is dan s2 dus s2 bovenaan moet zijn
		int i = 0;//teller om de letters te vergelijken op pos i in de string
		while (!builtdifferent) {//while loop die doorgaat tot er een verschil is tussen de 2 strings
			if (s1.toLowerCase().charAt(i) != s2.toLowerCase().charAt(i)) {
				if ((int)s1.toLowerCase().charAt(i) < (int)s2.toLowerCase().charAt(i)) {// hoe lager getal hoe eerder alfabet
					iskleiner = true; //als s1 kleiner is dan s2
				}
				builtdifferent = true; //voor het eindigen van de while loop
				
			}else {
				i++; //om door te gaan naar het volgende character van de string
			}
		}
		return iskleiner;
	
	}
}
