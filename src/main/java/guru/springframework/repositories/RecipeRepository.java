package guru.springframework.repositories;

import guru.springframework.domain.Category;
import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by jt on 6/13/17.
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    Long countRecipesByPrepTimeIsNotNull();

    Long countDistinctByCategories_DescriptionIsNotNullAllIgnoreCase();

    List<Recipe> findByDescriptionAndNotes_RecipeNotesContains(String description, String recipeNotes);

    List<Recipe> findRecipeByDescriptionContains(String description);

    @Query("select r from Recipe r where r.difficulty = ?1 and r.prepTime >= ?2")
    Optional<Recipe> getByDifficultyWithPrepTime(Difficulty difficulty, Integer prepTime);



}
