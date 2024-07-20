package com.example.service.impl;

import com.example.dao.BookDao;
import com.example.dao.impl.BookDaoImpl;
import com.example.pojo.Book;
import com.example.pojo.Page;
import com.example.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookdao = new BookDaoImpl();

    @Override
    public int addBook(Book book) {
        // TODO Auto-generated method stub
        return bookdao.addBook(book);
    }

    @Override
    public int updateBook(Book book) {
        // TODO Auto-generated method stub
        return bookdao.updateBook(book);
    }

    @Override
    public int deleteBookById(Integer id) {
        // TODO Auto-generated method stub
        return bookdao.deleteBookById(id);
    }

    @Override
    public Book queryBookById(Integer id) {
        // TODO Auto-generated method stub
        return bookdao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        // TODO Auto-generated method stub
        return bookdao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        // TODO Auto-generated method stub
        Page<Book> page = new Page<Book>();


        page.setPageSize(pageSize);

        Integer pageTotalCount = bookdao.queryforpagetotalcount();
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = pageTotalCount / pageSize;

        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }

        page.setPageTotal(pageTotal);


        page.setPageNo(pageNo);
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> items = bookdao.queryforitems(begin, pageSize);
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<Book>();


        page.setPageSize(pageSize);

        Integer pageTotalCount = bookdao.queryforpagetotalcountbyprice(min, max);
        page.setPageTotalCount(pageTotalCount);

        Integer pageTotal = pageTotalCount / pageSize;

        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }

        page.setPageTotal(pageTotal);


        page.setPageNo(pageNo);
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> items = bookdao.queryforitemsbyprice(begin, pageSize, min, max);
        page.setItems(items);

        return page;
    }

}
