package com.zqh.day07;

public class Test {

	
	public static void process1() {
		int N = 1000;
		int a = 0;
		for(int i = 0 ; i < N;i++) {
			a = 2+5; //7
			a = 4*7; //28
			a = 6*8; //48
		}
		System.out.println(a);
		
		
	}
	
	
	public static void process2() {
		int N = 1000;
		int a = 0;
		for(int i = 0 ; i < N;i++) {
			a = 3 | 6;  //101 | 110 :111=7
			a = 3 & 4;  //011 & 100 =000
			a = 4 ^ 785; //100 ^ 1100010001=785
		}
	}
	
	
	
	
	public static void main(String[] args) {

		process2();
		System.out.println((4 ^ 785));
		/*int a = 10;
		int b = 11;
		
		a = a^b;
		b = a^b;
		a = a^b; // a^b^a =b        a=1 b=10  异或 1010 ^ 0001 = 1011
		
		System.out.println(a);
		System.out.println(b);*/
		
		
		
	}
	
}
