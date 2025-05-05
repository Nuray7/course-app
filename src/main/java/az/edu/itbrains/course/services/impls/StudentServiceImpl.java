package az.edu.itbrains.course.services.impls;

import az.edu.itbrains.course.dtos.StudentCreateDto;
import az.edu.itbrains.course.dtos.StudentDto;
import az.edu.itbrains.course.services.StudentService;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<StudentDto> getAllStudents() {
        return List.of();
    }

    @Override
    public void registerStudent(StudentCreateDto studentDto) {

    }

    @Override
    public Optional<StudentDto> getStudentByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public void deleteStudent(Long id) {

    }
}
