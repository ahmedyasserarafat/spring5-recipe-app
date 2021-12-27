package guru.springframework.controllers;

import guru.springframework.domain.Category;
import guru.springframework.domain.Difficulty;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import guru.springframework.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * Created by jt on 6/1/17.
 */
@Controller
public class IndexController {

    private final RecipeService recipeService;
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeRepository recipeRepository;

    public IndexController(RecipeService recipeService, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository,RecipeRepository recipeRepository) {
        this.recipeService = recipeService;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository=recipeRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat Id is: " + categoryOptional.get().getId());
        System.out.println("UOM ID is: " + unitOfMeasureOptional.get().getId());
        //System.out.println(categoryRepository.findCategoryByDescription("Mexican"));
       // System.out.println(categoryRepository.findCategoryByDescription("Mexican").get(0).getRecipes().stream().findFirst().get());

      /*  System.out.println(recipeRepository.count());
        System.out.println(recipeRepository.existsById(1L));*/
       // System.out.println(recipeRepository.countRecipesByPrepTimeIsNotNull());
       // System.out.println(recipeRepository.countDistinctByCategories_DescriptionIsNotNullAllIgnoreCase());
       // System.out.println(recipeRepository.findRecipeByDescriptionContains("Perfect Guacamole"));
       // System.out.println(recipeRepository.findByDescriptionAndNotes_RecipeNotesContains("Perfect Guacamole","One classic Mexican guacamole"));
        System.out.println(recipeRepository.getByDifficultyWithPrepTime(Difficulty.EASY,10).get());
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
