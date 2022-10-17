package com.example.mintic.bike.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mintic.bike.model.Client;
import com.example.mintic.bike.repository.RepositoryClient;

@Service
public class ServiceClient {
    
    @Autowired
    private RepositoryClient repositoryClient;

    
    public List<Client> getAll() {
        return repositoryClient.getAll();
    }

    public Optional<Client> getClient(int id) {
        return repositoryClient.getClient(id);
    }

    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return repositoryClient.save(client);
        } else {
            Optional<Client> client1 = repositoryClient.getClient(client.getIdClient());
            if (client1.isEmpty()) {
                return repositoryClient.save(client);
            } else {
                return client;
            }
        }
    }


    
    // Con optional se requiere get() porque es algo asi como
    // un arraylist con un elemento. Puede que lo tenga o no 
    // Y por tanto con el get() se extrae el elemento de Client
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> e= repositoryClient.getClient(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                repositoryClient.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }


  
    public boolean deleteClient(int clientId) {
        boolean flag=false;
        Optional<Client> c = repositoryClient.getClient(clientId);
        if(c.isPresent()){
            repositoryClient.delete(c.get());
            flag=true;
        }
        return flag;
    }

    
    
      // getClient(id) devuelve un optional de Client
    //.map es uan funcion de Optional
    // Client es un parametro de funcion que recibe el objeto de quien lo llama
    // se llama la funcion de repositorioClient delete enviandole el objeto a borrar
    // el orElse es de la funcion map ( cuando no encuentra objeto para hacer map, osea getClient(id)
    // no devolvio nada)
    // public boolean deleteClient(int clientId) {
    //     Boolean aBoolean = getClient(clientId).map(client -> {
    //         repositoryClient.delete(client);
    //         return true;
    //     }).orElse(false);
    //     return aBoolean;
    // }
}
