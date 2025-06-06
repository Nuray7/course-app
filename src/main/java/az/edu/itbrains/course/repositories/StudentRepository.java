package az.edu.itbrains.course.repositories;

import az.edu.itbrains.course.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {


    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findByEmail(String email);

    @Query("SELECT s FROM Student s WHERE s.isNew = true ORDER BY s.id DESC")
    List<Student> getNewStudents();
}
