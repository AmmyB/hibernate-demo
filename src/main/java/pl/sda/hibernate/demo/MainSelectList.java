package pl.sda.hibernate.demo;

import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class MainSelectList {

    public static void main(String[] args) {
// wywołaj try-with-resources który zamknie sesję automatycznie po opuszczeniu try
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            TypedQuery<Student> zapytanie = session.createQuery("from Student", Student.class);
            List<Student> listaWszystkichStudentow = zapytanie.getResultList();

            for (Student student : listaWszystkichStudentow){
                System.out.println(student);
            }

        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch
                System.err.println("Błąd bazy: " + ioe);
        }
    }
}
