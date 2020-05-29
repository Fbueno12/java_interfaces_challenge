package model.services;

public class PaypalTaxService implements TaxService{

	@Override
	public double tax(double amount, int actualInstallment) {
		actualInstallment++;
		double percent = actualInstallment > 9 
				? Double.parseDouble("0." + actualInstallment) 
				: Double.parseDouble("0.0" + actualInstallment);
				
		double installmentTax = amount + (amount * percent);
		
		return installmentTax + (installmentTax * 0.02);
	}

}
