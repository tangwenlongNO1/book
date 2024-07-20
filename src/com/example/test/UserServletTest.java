package com.example.test;

import java.lang.reflect.Method;

public class UserServletTest {

	public void login() {
		System.out.println("login方法被调用了");
	}

	public void regist() {
		System.out.println("regist方法被调用了");
	}

	public void updateuser() {
		System.out.println("updateuser方法被调用了");
	}

	public void updatepassword() {
		System.out.println("updatepassword方法被调用了");
	}

	public static void main(String[] args) {

		String action = "updateuser";
		try {
			Method method = UserServletTest.class.getDeclaredMethod(action);
			System.out.println(method);

			method.invoke(new UserServletTest());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
