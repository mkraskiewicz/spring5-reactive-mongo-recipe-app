package guru.springframework.repositories.reactive;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.Reactive.RecipeReactiveRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maciej on 25/06/2018
 */
@RunWith(SpringRunner.class)
@DataMongoTest
public class RecipeReactiveRepositoryTest {

    @Autowired
    RecipeReactiveRepository recipeReactiveRepository;

    @Before
    public void setUp(){
        recipeReactiveRepository.deleteAll().block();
    }

    @Test
    public void testSavingRecipe(){

        Recipe recipe = new Recipe();
        recipe.setDescription("Chicken soup");
        recipeReactiveRepository.save(recipe).block();

        Long recipeCount = recipeReactiveRepository.count().block().longValue();
        assertEquals(Long.valueOf("1"), recipeCount);

    }
}
