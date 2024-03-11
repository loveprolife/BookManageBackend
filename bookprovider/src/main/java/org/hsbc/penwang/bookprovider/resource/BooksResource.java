package org.hsbc.penwang.bookprovider.resource;

import org.hsbc.penwang.bookprovider.mapper.BooksMapper;
import org.hsbc.penwang.bookprovider.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksResource {

    private final BooksMapper booksMapper;

    public BooksResource(BooksMapper booksMapper){
        this.booksMapper = booksMapper;
    }

    @GetMapping("/insert")
    public ResponseResult insert(String name, String author, String publicationyear, String ISBN){
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setPublicationyear(publicationyear);
        book.setISBN(ISBN);
        booksMapper.insert(book);
        ResponseResult responseResult = new ResponseResult();
        responseResult.status = "ok";
        return responseResult;
    }

    @GetMapping("/delete")
    public ResponseResult delete(int bookId){
        booksMapper.delete(bookId);
        ResponseResult responseResult = new ResponseResult();
        responseResult.status = "ok";
        return responseResult;
    }

    @GetMapping("/update")
    public ResponseResult update(int bookId, String name, String author, String publicationyear, String ISBN){
        Book book = new Book();
        book.setId(bookId);
        book.setName(name);
        book.setAuthor(author);
        book.setPublicationyear(publicationyear);
        book.setISBN(ISBN);
        booksMapper.update(book);
        ResponseResult responseResult = new ResponseResult();
        responseResult.status = "ok";
        return responseResult;
    }

    @GetMapping("/getBookById")
    public ResponseResult getBookById(int bookId){
        Book book = booksMapper.getBookById(bookId);
        ResponseResult responseResult = new ResponseResult();
        responseResult.status = "ok";
        responseResult.book = book;
        return responseResult;
    }

    @GetMapping("/getList")
    public ResponseResult getList(int pageNum, int pageSize){
        int totalBooks = booksMapper.getCount();
        int start = (pageNum - 1) * pageSize;
        int totalPage = (totalBooks / pageSize) == 0 ? totalBooks / pageSize : (int) Math.floor((double) (totalBooks / pageSize)) + 1;
        List<Book> books = booksMapper.getAllBooks(start, pageSize);
        ResponseResult listResult = new ResponseResult();
        listResult.status = "ok";
        listResult.totalPage = totalPage;
        listResult.totalBooks = totalBooks;
        listResult.books = books;
        return listResult;
    }

    public static class ResponseResult{
        public String status;
        public int totalPage;
        public int totalBooks;
        public Book book;
        public List<Book> books;
    }
}
