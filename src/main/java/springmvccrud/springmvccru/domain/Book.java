package springmvccrud.springmvccru.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Book {
    private int bookId;
    private String bookName;
        private double bookPrice;
        private String bookCategory;
    }

