package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

//    // do formatowania gdy nie ma Jacksona
//    @GetMapping("/hello")
//    public String hello(){
//        return "{hello: World}";
//    }

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
    // akcja wyświetlająca daną książkę po przekazanym id
    @RequestMapping("/showBook/{id}")
    public Book showBookById(@PathVariable long id){

        return memoryBookService.getBookId(id);
    }

    // akcja dodająca książkę do listy
    @PostMapping("/addBook")
    public void addBook(@RequestBody Book book){

        memoryBookService.addBook(book);
    }

}
