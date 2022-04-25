package ru.geekbrains.spring_less_web.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring_less_web.Controllers.Model.Client;
import ru.geekbrains.spring_less_web.Controllers.Model.Product;
import ru.geekbrains.spring_less_web.Controllers.Repository.ClientRepository;
import ru.geekbrains.spring_less_web.Controllers.Repository.ProductRepository;
import ru.geekbrains.spring_less_web.Controllers.Service.ClientServise;
import ru.geekbrains.spring_less_web.Controllers.Service.ProductServise;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientServise servise;

    @Autowired
    private ProductServise serviseProduct;

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
//    @ResponseBody
    public List<Client> getTest(){
        return clientRepository.getAllClientList();

    }

    @GetMapping("/product/all")
    public List<Product> getTest1(){
        return productRepository.getAllProductList();
    }

//    @GetMapping("/product/all")
//    public String getTest1(Model model1){
//        model1.addAttribute("name_products", productRepository.getAllProductList());
//        return "product_info_page";
//    }

    //http://localhost/app/find
    @GetMapping("/find")
//    @ResponseBody
    public Client add() {
        return clientRepository.findById(1L);
    }

    //http://localhost/app/sum
//    @GetMapping("/test")
//    @ResponseBody
//    public String sum(@RequestParam(name = "param", required = false) String a, @RequestParam("param1") String b) {
//        return a + b;
//    }

    //http://localhost/app/sum
    @GetMapping("/sum")
//    @ResponseBody
    public int sum(@RequestParam(name = "param") int a, @RequestParam("param1") int b) {
        return a + b;
    }

    //http://localhost/app/client/2
    @GetMapping("/client/{id}/info")
//    @ResponseBody
    public String findClientById(@PathVariable Long id) {
        return "Client #" + id;
    }

    //http://localhost/app/div
//    @GetMapping("/div")
//    @ResponseBody
//    public String div() {
//        return "div";
//    }

    @GetMapping("/client/change_score")
    public void changeScore(@RequestParam Long clientId,@RequestParam Integer delta){
    servise.changeScore(clientId, delta);
    }

    @GetMapping("/show_page")
    public String form(){
    return "simple_form";
    }

    @GetMapping("/product/change_cost")
    public void changeCost(@RequestParam Long productId,@RequestParam Integer delta){
        serviseProduct.changeCostProd(productId, delta);
    }
    @GetMapping("/show_page_prod")
    public String form1(){
        return "simple_form_prod";
    }

    @GetMapping("/remove_product")
    public void removeProduct(@RequestParam Product product){
        productRepository.removeProduct(product);
    }

    @PostMapping("/client/add")
//    @ResponseBody
    public void addclientPost(@RequestBody Client client){
        clientRepository.addClient(client);
    }




}
