package az.edu.itbrains.course.repositories;


import az.edu.itbrains.course.models.Course;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CourseRepository extends JpaRepository<Course, Long> {

        List<Course> findByIsNewTrue(Pageable pageable);
        //
        List<Course> findByIsPopularTrue(Pageable pageable);
        List<Course> findByCategoryIgnoreCase(String category);


    @Query("SELECT c FROM Course c WHERE c.isNew = true ORDER BY c.id DESC")
    List<Course> getNewCourses(Pageable pageable);


    @Query("SELECT c FROM Course c WHERE c.isPopular = true ORDER BY c.id DESC")
    List<Course> getPopularCourses(Pageable pageable);


    @Query("SELECT c FROM Course c ORDER BY c.id DESC")
    List<Course> getAllCourses();


    @Query("SELECT c FROM Course c WHERE c.category = ?1 ORDER BY c.id DESC")
    List<Course> getCoursesByCategory(String category);
}

