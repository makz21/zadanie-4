package pl.weeia.makz.zadanie4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.weeia.makz.zadanie4.SearchUtils;
import pl.weeia.makz.zadanie4.VCardUtils;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class SearchController {

    private SearchUtils searchUtils = new SearchUtils();
    private VCardUtils vCardUtils = new VCardUtils();

    @GetMapping("/search")
    public String searchUser(@RequestParam( name = "name", required = true) String name, final Model model){
        model.addAttribute("users",searchUtils.getUsers(name));
        return "search";
    }

    @GetMapping("/generateVCard")
    public void generateVCard(@RequestParam(value = "firstName") String firstName,@RequestParam(value = "lastName") String lastName,
                              HttpServletResponse response){
        vCardUtils.responseWithVCardFile(firstName, lastName, response);
    }
}

