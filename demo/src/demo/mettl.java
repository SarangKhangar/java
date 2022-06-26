package demo;

import java.util.Scanner;

public class mettl {

	public static void main(String[] args) {
	        Scanner sc  =  new Scanner(System.in);
	        String str = sc.nextLine();
	        char[] arr = new char[str.length()];
	        System.out.println(arr);
	        sc.close();
	        char i='I';
	        char e='E';
	        char a='A';
	        char o='O';
	        char u='U';
	        int cnt=0;
	         for(int j=0;j<str.length();j++){
	            arr[i]=str.charAt(i);
	        }
	        System.out.println(arr);
	        for(int j=0;j<str.length();j++){
	            if(arr[i] == i){ 
	                cnt++;
	            }
	            if(arr[i] == e){ 
	                cnt++;
	            }
	            if(arr[i] == a){ 
	                cnt++;
	            }
	            if(arr[i] == o){ 
	                cnt++;
	            }
	            if(arr[i] == u){ 
	                cnt++;
	            }
	            if(arr[i] >=0){ 
	                cnt++;
	            }

	            System.out.println(cnt);
	        }
	    }
	}


