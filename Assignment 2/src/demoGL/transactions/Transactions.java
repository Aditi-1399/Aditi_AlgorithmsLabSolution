package demoGL.transactions;
import java.util.Scanner;

public class Transactions {

	public static void main(String[] args) {
		System.out.println("Enter the size of transaction array :");
		Scanner scr = new Scanner(System.in);
		int num = scr.nextInt();
		int transaction[]= new int[num];
		for (int i =0 ; i<num ; i++) {
			System.out.println("Enter transaction "+(i+1));
			transaction[i]=scr.nextInt();
		}
		System.out.println("Enter the number of targets :");
		int targets = scr.nextInt();
		for(int j=0 ; j<targets ; j++) {
			System.out.println("Enter target value "+ (j+1));
			int targetValue = scr.nextInt();
			int sum =0;
			for(int k =0 ; k<num ; k++) {
				sum = sum + transaction[k];
				if(sum>=targetValue) {
					System.out.println("Target is achieved after " + (k+1) + " transactions");
					break;
			}
			}
			if (sum < targetValue)
				System.out.println("Target is not achieved.");
		}
	}

}
