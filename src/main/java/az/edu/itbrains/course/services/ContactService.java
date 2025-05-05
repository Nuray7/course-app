package az.edu.itbrains.course.services;

import az.edu.itbrains.course.dtos.ContactMessageDto;

import java.util.List;

public interface ContactService {
    void sendmassage(ContactMessageDto messageDto);
    List<ContactMessageDto> getAllMessages();
    void deleteMessage(Long id);
}