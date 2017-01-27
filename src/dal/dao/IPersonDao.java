package dal.dao;


import dal.entity.Person;
import java.util.List;

public interface IPersonDao {
    List<Person> getPerson();
    void savePerson(Person user);
}
