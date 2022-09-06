package com.ssd.esprithub.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ssd.esprithub.entity.Cours;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursRepository extends JpaRepository<Cours,Long>{

}
