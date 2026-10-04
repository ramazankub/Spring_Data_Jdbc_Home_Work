package ru.easyum.repository;

import org.springframework.data.repository.CrudRepository;
import ru.easyum.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}