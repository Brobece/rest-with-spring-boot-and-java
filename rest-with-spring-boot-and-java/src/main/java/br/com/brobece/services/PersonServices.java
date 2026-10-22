package br.com.brobece.services;

import br.com.brobece.controllers.PersonController;
import br.com.brobece.data.dto.PersonDTO;
import br.com.brobece.exception.RequiredObjectIsNullException;
import br.com.brobece.exception.ResourceNotFoundException;
import static br.com.brobece.mapper.ObjectMapper.parseListObject;
import static br.com.brobece.mapper.ObjectMapper.parseObject;

//import br.com.brobece.mapper.custom.PersonMapper;
import br.com.brobece.model.Person;
import br.com.brobece.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
        var people =  parseListObject(repository.findAll(), PersonDTO.class);

        people.forEach(this::addHateOASLinks);
        return people;
    }

    public PersonDTO findById(Long id) {
        logger.info("Finding one Person!");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var dto = parseObject(entity, PersonDTO.class);
        addHateOASLinks(dto);

        return dto;
    }


    public PersonDTO create(PersonDTO person) {
        if (person == null) throw new RequiredObjectIsNullException();

        logger.info("Creating one person!");

        var entity = parseObject(person, Person.class);

        var dto = parseObject(repository.save(entity), PersonDTO.class);

        addHateOASLinks(dto);
        return dto;
    }


    public PersonDTO update(PersonDTO person) {
        if (person == null) throw new RequiredObjectIsNullException();

        //entity é o que ja esta no banco
        //person é o que vc vai pegar e jogar no entity
        logger.info("Updating one person!");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No Record Found For This ID "));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var dto =  parseObject(repository.save(entity), PersonDTO.class);
        addHateOASLinks(dto);
        return dto;
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");
        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Record Found For This ID "));
        repository.delete(entity);
    }

    private void addHateOASLinks(PersonDTO dto) {
        dto.add(linkTo(methodOn(PersonController.class).findById(dto.getId())).withSelfRel().withType("GET"));

        dto.add(linkTo(methodOn(PersonController.class).findAll()).withRel("findAll").withType("GET"));

        dto.add(linkTo(methodOn(PersonController.class).createPerson(dto)).withRel("create").withType("POST"));

        dto.add(linkTo(methodOn(PersonController.class).updatePerson(dto)).withRel("update").withType("PUT"));

        dto.add(linkTo(methodOn(PersonController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
    }
}