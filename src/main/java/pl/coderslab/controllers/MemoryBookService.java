package pl.coderslab.controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

@Service
public class MemoryBookService {

    private List<Book> list;

    public MemoryBookService(){
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }
    // pobiera listę książek
    public List<Book> getList(){
        return list;
    }
    // ustawia  listę książek
    public void setList(List<Book> list){
        this.list = list;
    }

    // metoda do pobrania książki po id
    public Book getBookId(long id){
//        for(Book book : list){
//            if(book.getId() == id) {
//                return book;
//            }
//        }
        return list.stream()
                .filter(s->s.getId() == id)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Brak id"));
    }

    // metoda dodająca siążkę do listy
    public void addBook(Book book){

        Random rand = new Random();
        long randNum = rand.nextLong();
        book.setId(randNum);
        list.add(book);
    }

    // metoda edytyjąca ksiażkę
    public void editListBooks(){

    }
    // metoda usuwająca ksiażkę
    public void removeBookById(){

    }


}
