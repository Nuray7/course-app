package az.edu.itbrains.course.services.impls;

import az.edu.itbrains.course.dtos.ContactMessageDto;
import az.edu.itbrains.course.services.ContactService;

import java.util.List;

public class ContactServiceImpl implements ContactService {
    @Override
    public void sendmassage(ContactMessageDto messageDto) {

    }

    @Override
    public List<ContactMessageDto> getAllMessages() {
        return List.of();
    }

    @Override
    public void deleteMessage(Long id) {

    }
}
