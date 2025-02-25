package kz.bitlab.techorda2025.thirdProject.repositories;

import jakarta.transaction.Transactional;
import kz.bitlab.techorda2025.thirdProject.db.Category;
import kz.bitlab.techorda2025.thirdProject.db.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
