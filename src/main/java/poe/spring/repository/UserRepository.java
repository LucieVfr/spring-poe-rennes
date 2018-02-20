package poe.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import poe.spring.domain.User;

@Repository // Permet d'acceder à la base de donnée
public interface UserRepository extends CrudRepository<User, Long> {


}