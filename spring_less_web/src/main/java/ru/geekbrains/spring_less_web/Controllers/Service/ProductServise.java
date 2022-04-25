package ru.geekbrains.spring_less_web.Controllers.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_less_web.Controllers.Model.Client;
import ru.geekbrains.spring_less_web.Controllers.Model.Product;
import ru.geekbrains.spring_less_web.Controllers.Repository.ClientRepository;
import ru.geekbrains.spring_less_web.Controllers.Repository.ProductRepository;

@Service
public class ProductServise {
    @Autowired
    private ProductRepository repositoryProduct;

    public void changeCostProd(Long id, Integer cost) {
        Product product = repositoryProduct.findById(id);
        product.setCost(product.getCost() + cost);
        //repository.save

    }
}
