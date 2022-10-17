package com.example.mintic.bike.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mintic.bike.model.Category;
import com.example.mintic.bike.repository.RepositoryCategory;

@Service
public class ServiceCategory {
    
    @Autowired
    private RepositoryCategory repositoryCategory;

    
    public List<Category> getAll() {
        return repositoryCategory.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return repositoryCategory.getCategory(id);
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return repositoryCategory.save(category);
        } else {
            Optional<Category> category1 = repositoryCategory.getCategory(category.getId());
            if (category1.isEmpty()) {
                return repositoryCategory.save(category);
            } else {
                return category;
            }
        }
    }

    // Con optional se requiere get() porque es algo asi como
    // un arraylist con un elemento. Puede que lo tenga o no 
    // Y por tanto con el get() se extrae el elemento de Category
    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>g= repositoryCategory.getCategory(category.getId());
            if(!g.isEmpty()){
                if(category.getDescription()!=null){                    
                    g.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                return repositoryCategory.save(g.get());
            }
        }
        return category;
    }

    //getCategory(id) devuelve un optional de Category
    //.map es uan funcion de Optional
    // category es un parametro de funcion que recibe el objeto de quien lo llama
    // se llama la funcion de repositorioCategory delete enviandole el objeto a borrar
    // el orElse es de la funcion map ( cuando no encuentra objeto para hacer map, osea getCategory(id)
    // no devolvio nada)
    public boolean deleteCategory(int id){
        Boolean d= getCategory(id).map(category -> {
                                                        repositoryCategory.delete(category);
                                                        return true;
                                                    }
                                      ).orElse(false);
        return d;
    }

}
