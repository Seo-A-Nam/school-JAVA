package bank_account2;
import java.util.Scanner;

import bank_account2.Account;

public class AccountTest {

	public static void main(String[] args) {
		Account account1 = new Account(50.00);
		Account account2 = new Account(0.00);
		System.out.printf("account1 balance : $%.2f\n", account1.getBalance() );
		System.out.printf("account2 balance : $%.2f\n", account2.getBalance() );
		try (Scanner input = new Scanner(System.in)) {
			double depositAmount;
			
			System.out.print("\nEnter debit amount for account1: ");
			depositAmount = input.nextDouble();
			System.out.printf("\nsubtracting %.2f to account1 balance\n",depositAmount);
			if( depositAmount > account1.getBalance()) {
				System.out.printf("Debit amount exceeded account balance.");
			}
			else {
				account1.credit(depositAmount);
			}
			System.out.printf("account1 balance : $%.2f\n", account1.getBalance() );
			System.out.printf("account2 balance : $%.2f\n", account2.getBalance() );
			
			
			System.out.print("\nEnter debit amount for account2: ");
			depositAmount = input.nextDouble();
			if( depositAmount > account2.getBalance()) {
				System.out.printf("Debit amount exceeded account balance.\n");
			}
			else {
				account2.credit(depositAmount);
			}
		}
		System.out.printf("account1 balance: $%.2f\n", account1.getBalance() );
		System.out.printf("account2 balance: $%.2f\n", account2.getBalance() );
		
	}

	}
	