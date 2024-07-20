package com.example.test;

import com.example.dao.BookDao;
import com.example.dao.impl.BookDaoImpl;
import com.example.pojo.Book;
import com.example.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;

public class BookDaoImplTest {

	private BookDao bookDao = new BookDaoImpl();

	@Test
	public void addbook() {
		bookDao.addBook(new Book(null, "小K麦克斯", new BigDecimal(8888), "kk", 100, 0, null));
	}

	@Test
	public void updatebook() {
		bookDao.updateBook(new Book(21, "小K斯", new BigDecimal(8888), "kk", 100, 0, null));
	}

	@Test
	public void queryBookById() {
		System.out.println(bookDao.queryBookById(21));
	}

	@Test
	public void queryBooks() {
		bookDao.queryBooks().forEach(System.out::println);
	}

	@Test
	public void deleteBookById() {
		System.out.println("已删除" + bookDao.deleteBookById(22) + "行");
	}

	@Test
	public void queryforpagetotalcount() {
		// TODO Auto-generated method stub

		System.out.println(bookDao.queryforpagetotalcount());
	}

	@Test
	public void queryforpagetotalcountbyprice() {
		// TODO Auto-generated method stub

		System.out.println(bookDao.queryforpagetotalcountbyprice(10, 100));
	}
	@Test
	public void queryforitems() {
		// TODO Auto-generated method stub
		bookDao.queryforitems(0, Page.PAGE_SIZE).forEach(System.out::println);
	}

	@Test
	public void queryforitemsbyprice() {
		// TODO Auto-generated method stub
		bookDao.queryforitemsbyprice(0, Page.PAGE_SIZE, 10, 100).forEach(System.out::println);
	}
}
