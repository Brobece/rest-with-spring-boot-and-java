package br.com.brobece.services;

import br.com.brobece.data.dto.PersonDTO;
import br.com.brobece.exception.ResourceNotFoundException;
import static br.com.brobece.mapper.ObjectMapper.parseListObject;
import static br.com.brobece.mapper.ObjectMapper.parseObject;

//import br.com.brobece.mapper.custom.PersonMapper;
import br.com.brobece.model.Person;
import br.com.brobece.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    private AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

//    @Autowired
//    PersonMapper converter;

    public List<PersonDTO> findAll() {
        logger.info("Finding all people!");
        return parseListObject(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding one Person!");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return parseObject(entity, PersonDTO.class);
    }


    public PersonDTO create(PersonDTO person) {
        logger.info("Creating one person!");

        var entity = parseObject(person, Person.class);

        return parseObject(repository.save(entity), PersonDTO.class);
    }


    public PersonDTO update(PersonDTO person) {
        //entity é o que ja esta no banco
        //person é o que vc vai pegar e jogar no entity
        logger.info("Updating one person!");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No Record Found For This ID "));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");
        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Record Found For This ID "));
        repository.delete(entity);
    }

}