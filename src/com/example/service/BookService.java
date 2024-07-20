package com.example.service;

import com.example.pojo.Book;
import com.example.pojo.Page;

import java.util.List;

public interface BookService {

	/**
	 * 添加书籍
	 * @param book
	 * @return
	 */
	int addBook(Book book);

	/**
	 * 更新书籍
	 * @param book
	 * @return
	 */
	int updateBook(Book book);


	/**
	 * 删除书籍
	 * @param id
	 * @return
	 */
	int deleteBookById(Integer id);

	/**
	 * 根据id查询书籍
	 * @param id
	 * @return
	 */
	Book queryBookById(Integer id);

	/**
	 * 查询书籍
	 * @return
	 */
	List<Book> queryBooks();

	/**
	 * 分页实现
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Page<Book> page(int pageNo, int pageSize);

	/**
	 * 根据区间分页
	 * @param pageNo
	 * @param pageSize
	 * @param min
	 * @param max
	 * @return
	 */
    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
