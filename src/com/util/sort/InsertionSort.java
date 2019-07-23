package com.util.sort;

import java.util.Scanner;

public class InsertionSort {
	public static void main(String[] args) {
		int i, j, k, key;
		int[] a = new int[5];
		j = -1;

		Scanner scanner = new Scanner(System.in);
		do {
			j++;
			System.out.print(j + "번째 배열값을 입력하세요 >> ");
			a[j] = Integer.parseInt(scanner.nextLine());
		} while (j < 4);
		scanner.close();

		for (i = 1; i <= 4; i++) {
			key = a[i];
			for (k = i - 1; k >= 0; k--) {
				if (a[k] > key)
					a[k + 1] = a[k];
				else
					break;
			}
			System.out.println(k + ", "+ key);
			a[k + 1] = key;
		}
		for (i = 0; i <= 4; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
