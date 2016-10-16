//@author island

package algorithms;

import java.util.Random;

public class Sorting {
	static int SIZE = 999;
	static int[] list = new int[SIZE];
	static Random rand = new Random();

	public static void main(String[] args) {
		randomInt();
		showList();
		System.out.println("after sorted, list become: ");
		// bubbleSort();
		// insertSort();
		// selectionSort();
		quickSort(0, SIZE - 1);
		showList();
	}

	static void randomInt() {
		System.out.println("\nGenerating a random list...");
		for (int i = 0; i < list.length; i++) {
			list[i] = rand.nextInt(SIZE);
		}
		System.out.println("done!");
	}

	static void showList() {
		for (int i = 0; i < list.length; i++) {
			if (i % 50 == 0) {
				System.out.println();
			}
			System.out.printf("%0" + getNumDig(SIZE) + "d ", list[i]);
		}
		System.out.println();
	}

	static int getNumDig(int n) {
		int i = 0;
		while (n != 0) {
			n /= 10;
			i++;
		}
		return i;
	}

	static void bubbleSort() {
		System.out.println("\nbubbleSort running...");
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list.length - i - 1; j++) {
				if (list[j] > list[j + 1]) {
					int temp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
				}
			}
		}
	}

	static void insertSort() {
		System.out.println("\ninsert sort running...");
		for (int i = 1; i < list.length; i++) {
			if (list[i] < list[i - 1]) {
				int j = i - 1;
				int temp = list[i];
				list[i] = list[i - 1];
				while (j >= 0 && temp < list[j]) {
					list[j + 1] = list[j];
					j--;
				}
				list[j + 1] = temp;
			}
		}
	}

	static void selectionSort() {
		System.out.println("\nselection sort running...");
		for (int i = 0; i < list.length; i++) {
			int key = findMinKey(i);
			int temp = list[key];
			list[key] = list[i];
			list[i] = temp;
		}
	}

	static int findMinKey(int head) {
		int key = head;
		int min = list[key];
		for (int i = head; i < list.length; ++i) {
			if (list[i] < min) {
				min = list[i];
				key = i;
			}
		}
		return key;
	}

	static void shellSort() {

	}

	static void quickSort(int low, int high) {
		// System.out.println("quick sort running...");
		if (low < high) {
			int privotLoc = partition(low, high);
			quickSort(low, privotLoc - 1);
			quickSort(privotLoc + 1, high);
		}
	}

	private static int partition(int low, int high) {
		int privotKey = list[low];
		while (low < high) {
			while (low < high && list[high] >= privotKey) {
				high--;
			}
			swap(low, high);

			while (low < high && list[low] <= privotKey) {
				low++;
			}
			swap(low, high);
		}
		return low;
	}

	private static void swap(int x, int y) {
		int temp = list[x];
		list[x] = list[y];
		list[y] = temp;
	}
}
