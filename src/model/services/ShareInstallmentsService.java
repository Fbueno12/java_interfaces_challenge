package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ShareInstallmentsService {
	private TaxService taxService;
	
	public ShareInstallmentsService(TaxService taxService) {
		this.taxService = taxService;
	}
	
	public Installment[] execute(Contract contract, int installments) {
		LocalDate dueDate = contract.getDate();
		
		Installment[] aux = new Installment[installments];
		
		double installmentValue = contract.getTotalValue() / installments;

		for (int i = 0; i < installments; i++) {
			aux[i] = new Installment(dueDate.plusMonths(i), taxService.tax(installmentValue, i));
		}
		
		return aux;
	}
}
