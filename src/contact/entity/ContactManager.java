package contact.entity;

import java.util.List;

public class ContactManager {
    private ContactDAO dao;

    public ContactManager(){
        dao=ContactDAOFactory.getContactDAO();
    }

    public Long addContact(Contact contact){
        return dao.addContact(contact);
    }

    public void updateContact(Contact contact){
        dao.updateContact(contact);
    }

    public void deleteContact(Long contactID){
        dao.deleteContact(contactID);
    }

    public Contact getContact(Long contactID){
        return dao.getContact(contactID);
    }

    public List<Contact> findContacts(){
        return dao.findContacts();
    }
}
