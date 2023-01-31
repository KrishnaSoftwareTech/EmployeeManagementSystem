package com.EmployeeManagmentSystem.Rest;

/**
 * @author krishnakumar
 *
 */
public class Test {

	public static void main(String[] args) {
		printDuplicates();
		 String rev="";
	     final String str="employee";
	     for(int i=str.length()-1;i>=0;i--){
	       rev=rev+str.charAt(i);
	     }
	     System.out.println("reverse : " + rev);
		}

	private static void printDuplicates() {
		int[] arr= {2,2,3,1,5,8,4,9,2,9,6,6,2,3};
		// for 
		int count = 0;
		for(int i=0;i<arr.length;i++) {
			// 0<8
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j])
					System.out.println(arr[j]);
					}
			}
	}

}

