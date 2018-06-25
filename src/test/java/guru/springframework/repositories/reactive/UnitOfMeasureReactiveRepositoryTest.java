package guru.springframework.repositories.reactive;

import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.repositories.UnitOfMeasureReactiveRepository;
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
public class UnitOfMeasureReactiveRepositoryTest {

    public static final String EACH = "each";
    @Autowired
    UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepository;

    @Before
    public void setUp(){
        unitOfMeasureReactiveRepository.deleteAll().block();
    }

    @Test
    public void testSavingUOM(){
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setDescription(EACH);

        unitOfMeasureReactiveRepository.save(uom).block();

        Long count = unitOfMeasureReactiveRepository.count().block();

        assertEquals(Long.valueOf("1"), count);
    }

    @Test
    public void testFindByDescription(){
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setDescription(EACH);

        unitOfMeasureReactiveRepository.save(uom).block();

        UnitOfMeasure foundUOM = unitOfMeasureReactiveRepository.findByDescription(EACH).block();

        assertEquals(EACH, foundUOM.getDescription());
    }
}
