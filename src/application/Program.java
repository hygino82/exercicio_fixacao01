package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		System.out.print("Enter account data\n");
		System.out.print("Number: ");
		int number = sc.nextInt();
		sc.nextLine();//limpa buffer
		System.out.print("Holder: ");
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();
		
		Account acc = new Account(number, holder, balance, withdrawLimit);
		
		System.out.print("\nEnter amount for withdraw: ");
		double amount = sc.nextDouble();
		
		try {
			acc.withdraw(amount);
			System.out.println("New balance: " + String.format("%.2f", acc.getBalance()));
		}
		catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		
		
		sc.close();
	}

}
