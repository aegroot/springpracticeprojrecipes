package com.example.alex.domain.recipe;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recipe")
public class RecipeController {

    @Autowired
    RecipeRepository repository;

    @GetMapping("getAll")
    public List<Recipe> findAll(){
        return repository.findAll();
    }

    @GetMapping("recipes")
    public String sampleGet(){return "hello recipes";}

    @GetMapping("seed")
    public String seed(){


        if (repository.count()==0){
        repository.save(new Recipe(99998L,"nom","the nommiest nommies ever nommed"));
        repository.save(new Recipe(99999L,"yummy","your cooking is great!"));

        return "seeded";
        }
        return "not seeded";
    }
}
