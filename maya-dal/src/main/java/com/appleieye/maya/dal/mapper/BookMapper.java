package com.appleieye.maya.dal.mapper;

import com.alipay.zdal.client.dispatcher.EXECUTE_PLAN;
import com.appleieye.maya.dal.book.Book;

import java.util.List;

public interface BookMapper {

    int insertBook(Book book) throws Exception;

    int deleteBook(Integer id) throws Exception;

    int updateBook(Book book) throws Exception;

    Book selectBookById(Integer id) throws Exception;

    List<Book> selectAllBook() throws Exception;

}
