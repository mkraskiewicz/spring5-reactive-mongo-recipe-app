package guru.springframework.services;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.converters.UnitOfMeasureToUnitOfMeasureCommand;

import guru.springframework.repositories.repositories.UnitOfMeasureReactiveRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by jt on 6/28/17.
 */
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public UnitOfMeasureServiceImpl(UnitOfMeasureReactiveRepository unitOfMeasureRepository, UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureReactiveRepository = unitOfMeasureRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    public Flux<UnitOfMeasureCommand> listAllUoms() {

        return unitOfMeasureReactiveRepository.findAll().map(unitOfMeasureToUnitOfMeasureCommand::convert);
//        return StreamSupport.stream(unitOfMeasureReactiveRepository.findAll()
//                .spliterator(), false)
//                .map(unitOfMeasureToUnitOfMeasureCommand::convert)
//                .collect(Collectors.toSet());
    }
}
