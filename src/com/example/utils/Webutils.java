package com.example.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class Webutils {

	/**
	 * 把参数注入到bean
	 * 
	 * @author Jason Tom
	 * @param <T>
	 * @param value
	 * @param bean
	 * @return bean
	 */
	public static <T> T copyparamtobean(Map value, T bean) {
		try {
			// User user = new User();
			// System.out.println("注入之前：" + bean);
			// 注入Bean
			BeanUtils.populate(bean, value);
			// System.out.println("注入之后：" + bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}

	/**
	 * 
	 * @param strint 字符
	 * @param defaultvalue 默认值
	 * @return
	 */
	public static int parseInt(String strint, int defaultvalue) {

		try {
			return Integer.parseInt(strint);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return defaultvalue;
	}
}
