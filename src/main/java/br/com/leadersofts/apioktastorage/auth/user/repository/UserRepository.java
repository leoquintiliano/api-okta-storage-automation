package br.com.leadersofts.apioktastorage.auth.user.repository;

import br.com.leadersofts.apioktastorage.auth.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User,Long> {

    UserDetails findByLogin(String login);

}
