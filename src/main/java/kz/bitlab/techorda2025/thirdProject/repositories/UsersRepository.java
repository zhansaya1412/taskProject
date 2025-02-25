package kz.bitlab.techorda2025.thirdProject.repositories;

import jakarta.transaction.Transactional;
import kz.bitlab.techorda2025.thirdProject.db.Task;
import kz.bitlab.techorda2025.thirdProject.db.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users getUsersByEmail(String email);
}
