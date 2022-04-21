package ru.geekbrains.spring_less_web.Controllers.Repository;

import org.springframework.stereotype.Component;

import ru.geekbrains.spring_less_web.Controllers.Model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> productList;

    @PostConstruct
    public void init(){
        productList = new ArrayList<>(Arrays.asList(
                new Product(1l, "Milk", 80),
                new Product(2l, "Bread", 50),
                new Product(3l, "Coffe",200)
        ));
    }
    public List<Product> getAllProductList(){
        return Collections.unmodifiableList(productList);
    }
    public Product findById(Long id){
        return productList.stream().filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Product no found"));
    }
}
