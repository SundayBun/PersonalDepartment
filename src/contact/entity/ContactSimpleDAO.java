package contact.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//ContactSimpleDAO реализует интерфейс ContactDAO и это дает нам возможность «смоделировать» хранилище
public class ContactSimpleDAO implements ContactDAO{

    private final List<Contact> contacts=new ArrayList<>();

    @Override
    public Long addContact(Contact contact) {
        Long id=generateContactID();
        contact.setContactID(id);
        contacts.add(contact);
        return id;
    }

    @Override
    public void updateContact(Contact contact) {
        Contact oldContact = getContact(contact.getContactID());
        if(oldContact!=null){
            oldContact.setFirstName(contact.getFirstName());
            oldContact.setLastName(contact.getLastName());
            oldContact.setPhone(contact.getPhone());
            oldContact.setEmail(contact.getEmail());
        }

    }

    @Override
    public void deleteContact(Long contactId) {
        for(Iterator<Contact> it= contacts.iterator();it.hasNext();){
            Contact cnt=it.next();
            if(cnt.getContactID().equals(contactId)){
                it.remove();
            }
        }
    }

    @Override
    public Contact getContact(Long contactId) {
        for(Contact contact:contacts){
            if (contact.getContactID().equals(contactId)){
                return contact;
            }
        }
        return null;
    }

    @Override
    public List<Contact> findContacts() {
        return contacts;
    }

    private Long generateContactID(){
        Long contactID=Math.round(Math.random()*1000+System.currentTimeMillis());
        while (getContact(contactID)!=null){
            contactID=Math.round(Math.random()*1000+System.currentTimeMillis());
        }
        return contactID;
    }
}
