package basics;
import java.util.Arrays;
public class practice_array {
	
	public static void main(String args[]) {
	int a[] = new int[5];
	a[0] = 1;
	a[1] = 12;
	a[2] = 22;
	a[3] = 78;
	a[4] = 67;
	
	 
	for(int i =0;i<a.length;i++) {
		System.out.println(a[i]);
	}

	int b[][] = {{1, 2, 3}, {3, 4, 5}};
	for (int i = 0; i < b.length; i++) {
	    for (int j = 0; j < b[i].length; j++) {
	        System.out.print(b[i][j] + " ");
	    }
	    System.out.println();
	}
	}
}