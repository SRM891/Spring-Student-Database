package StudentData.StudentData.repository;

import StudentData.StudentData.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    public boolean existsByName(String name);
}
