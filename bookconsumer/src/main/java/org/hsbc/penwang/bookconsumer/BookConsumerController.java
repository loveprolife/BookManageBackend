package org.hsbc.penwang.bookconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BookConsumerController {

    @Autowired
    private RestTemplate resttemplate;

    @RequestMapping("/insert")
    public String insert(String name, String author, String publicationyear, String ISBN){
        String url = "http://bookprovider/books/insert?name="+name+"&author="+author+"&publicationyear="+publicationyear+"&ISBN="+ISBN;
        return resttemplate.getForObject(url, String.class);
    }

    @RequestMapping("/delete")
    public String delete(Integer bookId){
        String url = "http://bookprovider/books/delete?bookId=" + bookId;
        return resttemplate.getForObject(url, String.class);
    }

    @RequestMapping("/update")
    public String update(Integer bookId, String name, String author, String publicationyear, String ISBN){
        String url = "http://bookprovider/books/update?bookId="+bookId+"&name="+name+"&author="+author+"&publicationyear="+publicationyear+"&ISBN="+ISBN;
        return resttemplate.getForObject(url, String.class);
    }

    @RequestMapping("/getBookById")
    public String getBookById(Integer bookId){
        String url = "http://bookprovider/books/getBookById?bookId=" + bookId;
        return resttemplate.getForObject(url, String.class);
    }

    @RequestMapping("/getList")
    public String getList(Integer pageNum, Integer pageSize){
        String url = "http://bookprovider/books/getList?pageNum=" + pageNum + "&pageSize=" + pageSize;
        return resttemplate.getForObject(url, String.class);
    }
}
