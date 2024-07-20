package com.example.dao.impl;

import com.example.dao.BookDao;
import com.example.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {

	@Override
	public Book queryBookById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgpath from t_book where id=?";
		return queryForOne(Book.class, sql, id);
	}

	@Override
	public List<Book> queryBooks() {
		// TODO Auto-generated method stub
		String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgpath from t_book";
		return queryForList(Book.class, sql);
	}

	@Override
	public int addBook(Book book) {
		// TODO Auto-generated method stub
		String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`)values(?,?,?,?,?,?)";
		return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(),
				book.getImg_path());

	}

	@Override
	public int deleteBookById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from t_book where id = ?";
		return update(sql, id);
	}

	@Override
	public int updateBook(Book book) {
		// TODO Auto-generated method stub
		String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id=?";
		return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(),
				book.getImg_path(), book.getId());

	}

	@Override
	public Integer queryforpagetotalcount() {
		// TODO Auto-generated method stub

		String sql = "select count(*) from t_book";
		Number number = (Number) queryForSingle(sql);
		return number.intValue();
	}

	@Override
	public List<Book> queryforitems(int begin, int pageSize) {
		// TODO Auto-generated method stub
		String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgpath from t_book limit ?,?";
		return queryForList(Book.class, sql, begin, pageSize);
	}

	@Override
	public Integer queryforpagetotalcountbyprice(int min, int max) {
		String sql = "select count(*) from t_book where price between ? and ?";
		Number number = (Number) queryForSingle(sql, min, max);
		return number.intValue();
	}

	@Override
	public List<Book> queryforitemsbyprice(int begin, int pageSize, int min, int max) {
		String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgpath from t_book where price between ? and ? order by price limit ?,?";
		return queryForList(Book.class, sql, min, max, begin, pageSize);
	}

}
