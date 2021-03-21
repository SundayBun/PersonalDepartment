package contact.entity;

public class ContactDAOFactory {
//здесь выбираем хранилище
    public static ContactDAO getContactDAO(){
        return new ContactSimpleDAO();
    }
}
