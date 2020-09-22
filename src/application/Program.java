package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

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
		System.out.print("\nEnter amount for withdraw: ");
		double amount = sc.nextDouble();
		Account acc = new Account(number, holder, balance, withdrawLimit);
		
		
		if (amount > withdrawLimit) {
			System.out.println("Withdraw error: The amount exceeds withdraw limit");
		}
		else if (amount > balance) {
			System.out.println("Withdraw error: Not enough balance");
		}
		else {
			acc.withdraw(amount);
			System.out.printf("New Balance: %.2f\n", acc.getBalance());
		}
		
		
		sc.close();
	}

}
