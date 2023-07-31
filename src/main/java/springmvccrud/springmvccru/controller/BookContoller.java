package springmvccrud.springmvccru.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import springmvccrud.springmvccru.domain.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

    @Controller
    public class BookContoller {
        List<Book> bookList = new ArrayList<>();

        {
            bookList.add(new Book(1, "Java", 2000, "Education"));
            bookList.add(new Book(2, "SQL", 2050, "Education"));
            bookList.add(new Book(3, "HTML", 2500, "Education"));
            bookList.add(new Book(4, "Python", 2600, "Education"));
        }

        @GetMapping("/")
        public String getBooks(Model model) {
            model.addAttribute("books", bookList);
            return "books";
        }

        @GetMapping("/addbook")
        public String showAddBookForm() {
            return "addbook";
        }

        @PostMapping("/books")
        public String addBook(@ModelAttribute("book") Book book) {
            bookList.add(book);
            return "redirect:/";
        }

        @GetMapping("/updatebook/{id}")
        public String showUpdateBookForm(@PathVariable int id, Model model) {
            Book foundBook = null;

            for (Book book : bookList) {
                if (book.getBookId() == (id)) {
                    model.addAttribute("book", book);
                    break;
                }
            }


            return "updatebook";
        }

        @PostMapping("/modifybook")
        public String modifyBook(Book b) {
            for (int i = 0; i < bookList.size(); i++) {
                Book b1 = bookList.get(i);
                if (b1.getBookId() == b.getBookId()) {
                    bookList.set(i, b);
                }
            }

            return "redirect:/";
        }
        @GetMapping("/deletebook/{id}")
        public String deleteBook( @PathVariable int id) {

            Iterator<Book> itr=bookList.iterator();
            while (itr.hasNext()){
                Book b=itr.next();
                if(b.getBookId()==id){
                    itr.remove();
                }

            }



            return "redirect:/";
        }



}
