package az.edu.itbrains.course.services;



import az.edu.itbrains.course.dtos.StudentCreateDto;
import az.edu.itbrains.course.dtos.StudentDto;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentDto> getAllStudents();

    void registerStudent(StudentCreateDto studentDto);

    Optional<StudentDto> getStudentByEmail(String email);

    void deleteStudent(Long id);
}

