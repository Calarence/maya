package com.appleieye.maya.dal.test;

import com.appleieye.maya.dal.book.Book;
import com.appleieye.maya.dal.mapper.BookMapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: wujianjun
 * @date: 2018-04-13
 * @description:
 */

public class BookTest {

    @Test
    public void testSingleMapper() throws Exception{
        String springXML = "ctx-maya-dal.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(springXML);

        BookMapper bookMapper = (BookMapper) applicationContext.getBean("bookMapper");  //单mapper要引用id
        Book book = new Book();
        book.setName("test");
        book.setAuthor("zhangsan");
        System.out.println(bookMapper.insertBook(book));


    }
}
