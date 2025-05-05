package az.edu.itbrains.course.repositories;

import az.edu.itbrains.course.models.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {

    @Query("SELECT m FROM ContactMessage m ORDER BY m.sentAt DESC")
    List<ContactMessage> getAllMessages();
}
