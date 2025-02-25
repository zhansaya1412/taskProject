package kz.bitlab.techorda2025.thirdProject.repositories;

import jakarta.transaction.Transactional;
import kz.bitlab.techorda2025.thirdProject.db.Task;
import kz.bitlab.techorda2025.thirdProject.db.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByNameContainsIgnoreCase(String name);

    List<Task> findAllByNameContainsIgnoreCaseAndUser(String name, Users user);

    List<Task> findAllByUser(Users user);

//    List<Task> findAllByCompleted();
}
