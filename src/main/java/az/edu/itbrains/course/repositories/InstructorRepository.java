package az.edu.itbrains.course.repositories;


import az.edu.itbrains.course.models.Instructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    @Query("SELECT i FROM Instructor i ORDER BY i.id DESC")
    List<Instructor> getLatestInstructors(Pageable pageable);
}
