package com.zhoubo.util;

public class TestClass {
	
		
	
	public static void main(String[] args) {
		String str = "bo";
		int a = 10;
		
		TestClass t = new TestClass();
		int b = a + 1;
		t.test1(b);
		System.out.println("test 1 a = " + a) ;
		
		
		System.out.println("main a  = " + a);
		User user = new User();
		user.setAge(24);
		//user.setName("zhou");
		t.t2(user);
		System.out.println("main user = " + user  );
		
	}
	
	public void test1(int a ){
		a = a + 1;
		System.out.println("test 1 a = " + a) ;
		
	}
	public void t2(User user){
		//user = new User();
		//user.setName("guoguo");
		user.setAge(19);
		System.out.println("t2 user =" + user);
	}

}
