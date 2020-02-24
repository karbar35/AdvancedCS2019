import java.util.Arrays;

public class MergeWithoutRecursion {
	public static void merge(int[] arr, int l, int m, int r) 
    { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
        System.out.println("m " + m + " " + "l " + l + "r " + r);

        System.out.println("n1 " + n1 + " " + "n2 " + n2);
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + j + 1]; 
 	  
        int i = 0, j = 0; 
  
        int k = l; 
        while (i < n1 && j < n2-1) { 
            if (L[i] <= R[j]) { 
                arr[k] = L[i]; 
                i++; 
            } 
            else{ 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
        while (i < n1-1) { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
        while (j < n2-1) { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 

	public static void mergeSort(int[] arr) {
		for(int subarraySize = 2; subarraySize < arr.length/4; subarraySize*=2) {
			int numOfSubarrays = arr.length / subarraySize;
			
			for(int i = 0; i < arr.length; i+=subarraySize) {
				merge(arr, i, (i+i+subarraySize)/2, i + subarraySize);
				 
			}
		}
		
	}
	
	public static void swap(int[] arr, int x1, int x2) {
		int temp = arr[x1];
		arr[x1] = arr[x2];
		arr[x2] = temp;
	}

	public static void main(String[] args) {
		int[] test = new int[100];
		for(int i = 0; i < 100; i++) {
			test[i] = (int) (Math.random() * 1000);
		}
		
		System.out.println(Arrays.toString(test));
		
		mergeSort(test);
		
		System.out.println(Arrays.toString(test));
	}
}
