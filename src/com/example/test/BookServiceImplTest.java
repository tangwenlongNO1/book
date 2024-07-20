package com.example.test;

import com.example.pojo.Book;
import com.example.pojo.Page;
import com.example.service.BookService;
import com.example.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

public class BookServiceImplTest {

	private BookService bookservice = new BookServiceImpl();

	@Test
	public void addbook() {
		bookservice.addBook(new Book(null, "太难么", new BigDecimal(999.9), "佚名", 10, 0, null));
	}

	@Test
	public void updatebook() {
		bookservice.updateBook(new Book(21, "一点都不难", new BigDecimal(88.88), "李鹏", 1000, 10, null));
	}

	@Test
	public void queryBookById() {
		System.out.println(bookservice.queryBookById(23));
	}

	@Test
	public void queryBooks() {
		bookservice.queryBooks().forEach(System.out::println);
	}

	@Test
	public void deleteBookById() {
		System.out.println("已删除" + bookservice.deleteBookById(23) + "行");
	}

	@Test
	public void page() {
		// TODO Auto-generated method stub
		System.out.println(bookservice.page(1, Page.PAGE_SIZE));
	}

	@Test
	public void pagebyprice() {
		// TODO Auto-generated method stub
		System.out.println(bookservice.pageByPrice(1, Page.PAGE_SIZE, 10, 100));
	}

}
