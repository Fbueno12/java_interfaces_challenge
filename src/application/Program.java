package application;

import java.util.Scanner;

import application.utils.parseLocalDate;
import model.entities.Contract;
import model.entities.Installment;
import model.services.PaypalTaxService;
import model.services.ShareInstallmentsService;

public class Program {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter contract data");
		System.out.print("Number: ");
		String contractNumber = sc.nextLine();
		
		System.out.print("Date (dd/MM/yyyy): ");
		String contractDate = sc.nextLine();
		
		
		System.out.print("Contract value: ");
		String contractValue = sc.nextLine();
		
		System.out.print("Enter number of installments: ");
		String installments = sc.nextLine();
		
		System.out.println("Installments: ");
		
		Contract contract = new Contract(
				Integer.parseInt(contractNumber), 
				new parseLocalDate().execute(contractDate), 
				Double.parseDouble(contractValue));
		
		Installment[] installmentService = new ShareInstallmentsService(new PaypalTaxService()).execute(
				contract, 
				Integer.parseInt(installments));
		
		for (int i = 0; i < installmentService.length; i++) {
			System.out.println(installmentService[i].getDueDateFormatted() + " - " +installmentService[i].getAmount());
		}
		
		sc.close();
	}
	
}
