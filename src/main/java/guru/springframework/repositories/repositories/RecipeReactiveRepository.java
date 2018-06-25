package guru.springframework.repositories.repositories;

import guru.springframework.domain.Recipe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Created by Maciej on 25/06/2018
 */
public interface RecipeReactiveRepository extends ReactiveMongoRepository<Recipe, String> {
}
