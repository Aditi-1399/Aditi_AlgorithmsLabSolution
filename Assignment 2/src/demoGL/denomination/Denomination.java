package demoGL.denomination;
import java.util.Scanner;

public class Denomination {

	public static void merge(int arr[], int left, int mid, int right) {
		// Find sizes of two sub arrays to be merged
		int n1 = mid - left + 1;
		int n2 = right - mid;

		/* Create temporary arrays */
		int leftArray[] = new int[n1];
		int rightArray[] = new int[n2];

		/* Copy data to temporary arrays */
		for (int i = 0; i < n1; ++i)
			leftArray[i] = arr[left + i];
		for (int j = 0; j < n2; ++j)
			rightArray[j] = arr[mid + 1 + j];

		/* Merge the temporary arrays */

		// Initial indexes of first and second sub-arrays
		int i = 0, j = 0;

		// Initial index of merged sub-array array
		int k = left;
		while (i < n1 && j < n2) {
			if (leftArray[i] >= rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}

	public static void sort(int[] denominations, int left, int right) {
		if (left < right) {
			// Find the middle point
			int mid = (left + right) / 2;

			// Sort first and second halves
			sort(denominations, left, mid);
			sort(denominations, mid + 1, right);

			// Merge the sorted halves
			merge(denominations, left, mid, right);
		}
	}


	public static void main(String[] args) {
		System.out.println("Enter the number of denominations :");
		Scanner scr = new Scanner(System.in);
		int num = scr.nextInt();
		int denominations[]= new int[num];
		for (int i =0 ; i<num ; i++) {
			System.out.println("Enter denomination "+(i+1));
			denominations[i]=scr.nextInt();
		}
		sort(denominations,0,denominations.length-1);
		System.out.println("Enter amount to be payed :");
		int amount = scr.nextInt();
		for(int i=0 ; i<denominations.length; i++) {
			if(amount>denominations[i]) {
				int notes = amount/denominations[i];
				System.out.println(denominations[i]+" : "+ notes);
				amount=amount%denominations[i];
			}
		}
		if (amount > 0)
			System.out.println("The exact amount cannot be payed remaining amount is  "+amount);
	}

}
