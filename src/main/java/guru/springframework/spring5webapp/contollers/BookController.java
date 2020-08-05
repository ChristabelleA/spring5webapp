package guru.springframework.spring5webapp.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    @RequestMapping("/books")
    public String getBooks(Model model){

        return "books";
    }
}
