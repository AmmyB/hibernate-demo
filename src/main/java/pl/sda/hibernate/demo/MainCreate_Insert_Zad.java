package pl.sda.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MainCreate_Insert_Zad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            System.out.println("Podaj imie");
            String imie = scanner.nextLine();

            System.out.println("Podaj kierunek");
            String kierunek = scanner.nextLine();

            String indeks = null;
            do{
                System.out.println("Podaj numer indeksu (6 znaków): ");
                indeks = scanner.nextLine();
            } while (indeks.length() !=6);

            LocalDate dataUrodzenia = null;
            do{
                System.out.println("Podaj datę urodzenia:");
                String dataUr = scanner.nextLine();
                try{
                    dataUrodzenia = LocalDate.parse(dataUr);
                } catch ( DateTimeParseException dtpe){}
            } while (dataUrodzenia == null);

            Student student = Student.builder()
                    .dataUrodzenia(LocalDate.of(1990, 1, 3))
                    .kierunekNauczania("Informatyka")
                    .indeks("123123")
                    .imie("Paweł")
                    .build();




            session.persist(student);

            transaction.commit();

        } catch (Exception ioe) {
            // jeśli złapiemy błąd, to wywoła się catch

        }
    }
}
