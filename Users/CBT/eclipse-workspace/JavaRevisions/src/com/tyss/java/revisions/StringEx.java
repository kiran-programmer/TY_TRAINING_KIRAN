package com.tyss.java.revisions;

public class StringEx {
	
	public static void main(String[] args) {
		
		String s="hello";
		
		String s1=new String("hello world");
		System.out.println(s.hashCode());
		
		System.out.println(s.equals(s1));
		System.out.println(s1.hashCode());
		
		System.out.println(s==s1);
		
		
		
	}

}
