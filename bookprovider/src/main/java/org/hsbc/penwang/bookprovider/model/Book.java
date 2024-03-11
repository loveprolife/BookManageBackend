package org.hsbc.penwang.bookprovider.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class Book {
    private Integer id;
    private String name;
    private String author;
    private String publicationyear;
    private String ISBN;
}
