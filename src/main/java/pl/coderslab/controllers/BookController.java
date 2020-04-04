package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    // tworzymy atrybut/pole klasy serwisowej
    private MemoryBookService memoryBookService;

    // tworzymy kontstuktor, przekazujemy jako parametr do konstruktora atrybut klasy serwisowej
    @Autowired
    public BookController(MemoryBookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){

        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }
    // akcja wyświetlająca listę książek
    @RequestMapping("/showList")
    public List<Book> showList(){

        return memoryBookService.getList();
    }

}
