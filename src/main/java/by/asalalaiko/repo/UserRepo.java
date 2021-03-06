package by.asalalaiko.repo;

import by.asalalaiko.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByLogin(String login);

    User findByActionCode(String code);
}
