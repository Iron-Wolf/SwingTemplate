package mainPack;

import dal.dao.HybernateUtil;
import dal.dao.PersonDao;
import dal.entity.Person;
import view.Fenetre;
import data.Model;

public class Main {

    public static void main(String args[]) {
        HybernateUtil util = new HybernateUtil();

        /*Person p = new Person();
        p.setFirstName("my name");

        PersonDao pdao = new PersonDao(util.getEntityManager());
        pdao.savePerson(p);
        for (Person pe :pdao.getPerson()) {
            System.out.println(pe.getFirstName() + " / " + pe.getId());
        }*/

        Model model = new Model();
        new Fenetre(model);
    }

}