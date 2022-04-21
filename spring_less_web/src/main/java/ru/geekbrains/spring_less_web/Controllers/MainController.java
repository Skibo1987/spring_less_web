package ru.geekbrains.spring_less_web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.geekbrains.spring_less_web.Controllers.Model.Client;
import ru.geekbrains.spring_less_web.Controllers.Model.Product;
import ru.geekbrains.spring_less_web.Controllers.Repository.ClientRepository;
import ru.geekbrains.spring_less_web.Controllers.Repository.ProductRepository;

@Controller
public class MainController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/client/{id}")
    public String getTest(Model model, @PathVariable Long id){
        Client client = clientRepository.findById(id);
        model.addAttribute("human", client);
        return "client_page";
    }
    @GetMapping("/product/{id}")
    public String getTest1(Model model1, @PathVariable Long id){
        Product product = productRepository.findById(id);
        model1.addAttribute("name_product", product);
        return "product_page";
    }

    @GetMapping("/client/all")
    public String getTest(Model model){
        model.addAttribute("humans", clientRepository.getAllClientList());
        return "client_info_page";
    }

    @GetMapping("/product/all")
    public String getTest1(Model model1){
        model1.addAttribute("name_products", productRepository.getAllProductList());
        return "product_info_page";
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
