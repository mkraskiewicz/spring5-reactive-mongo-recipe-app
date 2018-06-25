package guru.springframework.repositories.reactive;

import guru.springframework.domain.Category;
import guru.springframework.repositories.Reactive.CategoryReactiveRepository;
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
public class CategoryReactiveRepositoryTest {

    public static final String FOO = "bar";

    @Autowired
    CategoryReactiveRepository categoryReactiveRepository;

    @Before
    public void setUp(){
        categoryReactiveRepository.deleteAll().block();
    }

    @Test
    public void testSavingCategory(){

        Category category = new Category();
        category.setDescription(FOO);

        categoryReactiveRepository.save(category).block();

        Long count = categoryReactiveRepository.count().block();

        assertEquals(Long.valueOf("1"), count);
    }

    @Test
    public void testFindByDescription(){

        Category category = new Category();
        category.setDescription(FOO);

        categoryReactiveRepository.save(category).block();

        Category foundUOM = categoryReactiveRepository.findByDescription(FOO).block();

        assertEquals(FOO, foundUOM.getDescription());
    }
}
