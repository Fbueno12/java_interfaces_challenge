package application.utils;

import java.time.LocalDate;

public class parseLocalDate {
	public LocalDate execute(String stringDate) {
		int[] aux = new int[3];
		
		String[] numbers = stringDate.split("/");
				
		for (int i = 0; i < numbers.length; i++) {
			aux[i] = Integer.parseInt(numbers[i]);
		}
		return LocalDate.of(aux[2], aux[1], aux[0]);	
	}
}
