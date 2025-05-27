package az.edu.itbrains.course.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    private String category;

    private String imageUrl;

    private boolean isNew;

    private boolean isPopular;
    private Double durationInHours;



    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;



}
