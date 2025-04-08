package nivel1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainNivel1todoslosEjercicios {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//---------Ejercicio1------------------
		List<String> originalStringSet = Arrays.asList("Moreno", "Antiguo", "Locura", "Uno", "Filtros", "Liviana", "Andalucia"
				+ "Lingam", "Yonni", "ItAcademy");

		List<String> filteredStringsConteiningO = filterStringsContainingO(originalStringSet);
		System.out.println("\nExercise 1: Given a list print only strings containing the letter 'o'");
		filteredStringsConteiningO.forEach(System.out::println);

		//---------Ejercicio2------------------
		List<String> filteredStringsOandMoreThan5 = filterStringsContainingOAndMoreThan5Letters(originalStringSet);
		System.out.println("\nExercise 2: Strings containing 'o' and more than 5 letters: ");
		filteredStringsOandMoreThan5.forEach(System.out::println);

		//---------Ejercicio3------------------
		List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June",
				"July", "August", "September", "October", "November", "December");
		System.out.println("\nExercise 3: Print the months in the list with a Lambda: ");
		months.forEach(month -> System.out.println(month));

		//---------Ejercicio4------------------
		System.out.println("\nExercise 4: Print the months in the list with method reference: ");
		months.forEach(System.out::println);

		//---------Ejercicio5------------------
		PiValue pi = () -> 3.141516;
		System.out.println("\nExercise 5: the value of Pi is = " + pi.getPiValue());

		//---------Ejercicio6------------------
		List<Object> mixedObjectsList = Arrays.asList("Pato", "Perro", "Sindicato", 10, 50, 2000, "Puerros", 300, 90);
		List<String> sortedListOfStrings = new ArrayList<>();
		for (Object object : mixedObjectsList) {
			if (object instanceof String) {						
				sortedListOfStrings.add((String) object);
			}
		}
		sortedListOfStrings.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		System.out.println("\nExercise 6: string list organized by ascendently length: " + sortedListOfStrings);

		//---------Ejercicio7------------------
		System.out.println("\nExercise 7: strings list descendently arranged by length: "
				+ sortedListOfStrings.reversed());               
		
		//---------Ejercicio8------------------
		ReverserInterface reverser = input -> new StringBuilder(input).reverse().toString();
		String modified = reverser.reverse("Paralelepipedo"); 
		System.out.println("\nExercise 8: use of the Reverser interface when the word 'Paralelepipedo' is passed: "
				+ modified);

		//------------Metodos-----------------------
	}
    public static List<String> filterStringsContainingO(List<String> strings) {
        return strings.stream()
                      .filter(string -> string.contains("o"))
                      .collect(Collectors.toList());
    }

    public static List<String> filterStringsContainingOAndMoreThan5Letters(List<String> strings) {
        return strings.stream()
                      .filter(string -> string.contains("o") && string.length() > 5)
                      .collect(Collectors.toList());
    }
    
}
