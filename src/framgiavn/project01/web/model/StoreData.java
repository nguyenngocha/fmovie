package framgiavn.project01.web.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
  public static void main(String[] args) {

    //creating configuration object
    Configuration cfg=new Configuration();
    cfg.configure("framgiavn/project01/web/model/Hibernate.cfg.xml");//populates the data of the configuration file

    //creating seession factory object
    SessionFactory factory=cfg.buildSessionFactory();

    //creating session object
    Session session=factory.openSession();

    //creating transaction object
    Transaction t=session.beginTransaction();
    User admin = new User();
    admin.setEmail("admin@gmail.com");
    admin.setName("admin");
    admin.setPassword("123456");
    admin.setRoles(1);
    session.persist(admin);

    t.commit();//transaction is committed
    session.close();

    System.out.println("successfully saved");
  }
}
