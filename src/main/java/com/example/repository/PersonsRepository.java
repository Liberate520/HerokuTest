package com.example.repository;

import java.util.List;

import com.example.Entity.Persons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PersonsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createPerson(String name){
        return jdbcTemplate.update("INSERT INTO \"Persons\" (\"NAME\") VALUES(?)", name);
    }

    public int updatePerson(Persons person){
        return jdbcTemplate.update("UPDATE \"Persons\" SET \"NAME\" = ? WHERE \"ID\" = ?", person.getName(), person.getId());
    }

    public int deletePerson(Integer id){
        return jdbcTemplate.update("DELETE FROM \"Persons\" WHERE \"ID\" = ?",id);
    }

    public Persons getPerson(Integer id){
        return jdbcTemplate.queryForObject("SELECT * FROM \"Persons\" WHERE \"ID\"=?", new PersonsMapper(), id);
    }

    public List<Persons> getPersons(){
        return jdbcTemplate.query("SELECT * FROM \"Persons\"", new PersonsMapper());
    }
}
