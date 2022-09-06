package com.ssd.esprithub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssd.esprithub.entity.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

}
