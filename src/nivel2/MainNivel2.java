package nivel2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainNivel2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//---------Ejercicio1------------------
		List<String> names =  new ArrayList<String>();
		names = Arrays.asList("Noelia", "Ana", "Carlos", "Liz", "Barbara", "Ale", "Lia", "Aina");
		System.out.println(namesOf3LettersThatStartWithA(names) + "\n"); 
		
		//---------Ejercicio2------------------
		List<Integer> numbers =  new ArrayList<Integer>();
		numbers = Arrays.asList(3, 5, 7, 10, 20, 30);
		System.out.println(integerBasedString(numbers) + "\n"); //ejercicio2
		List<OperationInterface> operations = new ArrayList<OperationInterface>();
		
		//---------Ejercicio3------------------
		OperationInterface adding = (a,b) -> a + b;
		OperationInterface substract = (a,b) -> a - b;
		OperationInterface divide = (a,b) -> a / b;
		OperationInterface multiply = (a,b) -> a * b;
		System.out.println("Adding :" + adding.operation(20, 2)
						+ "\nSubstracting: " + substract.operation(20, 2)
						+ "\nDividing: " + divide.operation(20, 2)
						+"\nMultiplying: " + multiply.operation(20, 2)); 
		
		//---------Ejercicio4------------------
		List<String> list = Arrays.asList("apple", "123", "banana", "42", "cherry", "elephant", "dog", "3.14");

        //----------Ordenar alfabéticamente por el primer carácter
        List<String> sortedByFirstChar = list.stream()
                .sorted((s1, s2) -> Character.compare(s1.charAt(0), s2.charAt(0)))
                .collect(Collectors.toList());
        System.out.println("Ordenadas por el primer carácter: " + sortedByFirstChar);

        //----------------Cadenas que contienen una "e" primero, el resto después
        List<String> sortedByE = list.stream()
                .sorted((s1, s2) -> {
                    if (s1.contains("e") && !s2.contains("e")) {
                        return -1;
                    } else if (!s1.contains("e") && s2.contains("e")) {
                        return 1;
                    } else {
                        return 0;
                    }
                })
                .collect(Collectors.toList());
        System.out.println("Cadenas con 'e' primero: " + sortedByE);

        //----------Modificar elementos que contienen 'a' por '4'
        List<String> modifiedList = list.stream()
                .map(s -> s.contains("a") ? s.replace('a', '4') : s) 
                .collect(Collectors.toList());
        System.out.println("Lista con 'a' reemplazadas por '4': " + modifiedList);

        //----------Mostrar sólo elementos numéricos
        List<String> numericElements = list.stream()
                .filter(s -> s.matches("-?\\d+(\\.\\d+)?"))
                .collect(Collectors.toList());
        System.out.println("Elementos numéricos: " + numericElements);

	}
	
	public static List<String> namesOf3LettersThatStartWithA (List<String> list) {
		return list.stream()
				.filter(name -> name.startsWith("A") && name.length() == 3)
				.collect(Collectors.toList());
	}
	public static String integerBasedString (List<Integer> list) {
		return list.stream()
				.map(num -> (num % 2 == 0 ? "e" : "o") + num)
                .collect(Collectors.joining(", "));		   
		}
	
}
/*
 * 
 * 
 * 
 * 
 * 
 * 
 * */
