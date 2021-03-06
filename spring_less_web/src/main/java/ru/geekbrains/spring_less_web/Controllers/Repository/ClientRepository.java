package ru.geekbrains.spring_less_web.Controllers.Repository;

import org.springframework.stereotype.Component;
import ru.geekbrains.spring_less_web.Controllers.Model.Client;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ClientRepository {

    private List<Client> clientList;

    @PostConstruct
    public void init(){
        clientList = new ArrayList<>(Arrays.asList(
                new Client(1l, "Bob"),
                new Client(2l, "John"),
                new Client(3l, "Michail")
        ));

    }

    public List<Client> getAllClientList(){
        return Collections.unmodifiableList(clientList);
    }

    public Client findById(Long id){
        return clientList.stream().filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("Client no found"));
    }

}
