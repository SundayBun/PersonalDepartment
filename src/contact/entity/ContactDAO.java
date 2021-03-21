package contact.entity;

import java.util.List;

/**
        * Интерфейс для определения функций хранлиза данных о контактах
        */

public interface ContactDAO {

    public Long addContact(Contact contact);

    public void updateContact(Contact contact);

    public void deleteContact(Long contactId);

    public Contact getContact(Long contactId);

    public List<Contact> findContacts();
}
