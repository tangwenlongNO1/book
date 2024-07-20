package com.example.dao;

import com.example.pojo.Book;

import java.util.List;

public interface BookDao {

	/**
	 * 查询书籍通过id
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
	 * 添加书籍
	 * @param book
	 * @return
	 */
	int addBook(Book book);

	/**
	 * 删除书籍
	 * @param id
	 * @return
	 */
	int deleteBookById(Integer id);

	/**
	 * 更新书籍
	 * @param book
	 * @return
	 */
	int updateBook(Book book);

	/**
	 * 查询记录总数
	 * @return
	 */
	Integer queryforpagetotalcount();

	/**
	 * 根据页码查询书籍
	 * @param begin
	 * @param pageSize
	 * @return
	 */
	List<Book> queryforitems(int begin, int pageSize);

	/**
	 * 根据价格区间查询记录总数
	 * @param min
	 * @param max
	 * @return
	 */
    Integer queryforpagetotalcountbyprice(int min, int max);

	/**
	 * 根据价格区间查询书籍
	 * @param begin
	 * @param pageSize
	 * @param min
	 * @param max
	 * @return
	 */
	List<Book> queryforitemsbyprice(int begin, int pageSize, int min, int max);
}
