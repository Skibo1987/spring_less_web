package ru.geekbrains.spring_less_web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.geekbrains.spring_less_web.Controllers.Model.Client;
import ru.geekbrains.spring_less_web.Controllers.Repository.ClientRepository;

@Controller
public class MainController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/test2")
    public String getTest(Model model){
        Client client = clientRepository.findById(2L);
        model.addAttribute("human", client);
        return "index";
    }

    //http://localhost/app/add
    @GetMapping("/add")
    @ResponseBody
    public String add() {
        return "hello";
    }

    //http://localhost/app/sum
//    @GetMapping("/test")
//    @ResponseBody
//    public String sum(@RequestParam(name = "param", required = false) String a, @RequestParam("param1") String b) {
//        return a + b;
//    }

    //http://localhost/app/sum
    @GetMapping("/sum")
    @ResponseBody
    public int sum(@RequestParam(name = "param") int a, @RequestParam("param1") int b) {
        return a + b;
    }

    //http://localhost/app/client/2
    @GetMapping("/client/{id}/info")
    @ResponseBody
    public String findClientById(@PathVariable Long id) {
        return "Client #" + id;
    }

    //http://localhost/app/div
//    @GetMapping("/div")
//    @ResponseBody
//    public String div() {
//        return "div";
//    }

}
