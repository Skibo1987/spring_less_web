package ru.geekbrains.spring_less_web.Controllers.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_less_web.Controllers.Model.Client;
import ru.geekbrains.spring_less_web.Controllers.Repository.ClientRepository;

@Service
public class ClientServise {

    @Autowired
    private ClientRepository repository;

    public void changeScore(Long id, Integer score) {
        Client client = repository.findById(id);
        client.setScore(client.getScore() + score);
        //repository.save

    }
}
