package org.hsbc.penwang.bookprovider.mapper;

import org.apache.ibatis.annotations.*;
import org.hsbc.penwang.bookprovider.model.Book;

import java.util.List;

@Mapper
public interface BooksMapper {

    @Insert("insert into book (name, author, publicationyear, ISBN) values (#{name}, #{author}, #{publicationyear}, #{ISBN})")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    void insert(Book book);

    @Delete("DELETE FROM book WHERE id=#{bookId}")
    void delete(int bookId);

    @Update("UPDATE book SET name=#{name}, author=#{author}, publicationyear=#{publicationyear}, ISBN=#{ISBN} where id=#{id}")
    void update(Book book);

    @Select("select count(*) as total from book")
    int getCount();

    @Select("select * from book where id=#{bookId}")
    Book getBookById(int bookId);

    @Select("select * from book order by id desc limit #{start}, #{pageSize}")
    List<Book> getAllBooks(int start, int pageSize);
}
