package pac;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        System.out.println("Iniciando configuración hibernate...");

        //Configuramos el hibernate
        final StandardServiceRegistry registro = new StandardServiceRegistryBuilder().configure().build();
        final SessionFactory factory = new MetadataSources(registro).buildMetadata().buildSessionFactory();

        //Configuration cfg = new Configuration().configure();
        //SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());

        System.out.println("Abriendo conexión a BD...");

        //Abrimos la conexión a la base de datos
        final Session session = factory.openSession();
        //Session session = sessionFactory.openSession();

        System.out.println("Conexión abierta a BD...");

        session.beginTransaction();
        //Transaction tx = session.beginTransaction();

        //Insertamos los datos del modulo en la tabla modulos
        Modulo modulo = new Modulo("Programacion B", "M03B");
        Modulo modulo2 = new Modulo("Acceso a Datos", "M06");
        Modulo modulo3 = new Modulo("Desarrollo de aplicaciones moviles", "M08");
        Modulo modulo4 = new Modulo("Servicios y procesos", "M09");

        //Imprimimos por pantalla el toString que nos pide la PAC
        System.out.println(modulo.toString());
        System.out.println(modulo2.toString());
        System.out.println(modulo3.toString());
        System.out.println(modulo4.toString());

        //Guardamos los datos en la tabla modulos en la base de datos
        session.save(modulo);
        session.save(modulo2);
        session.save(modulo3);
        session.save(modulo4);

        Set<Modulo> modulos = new HashSet<Modulo>();
        modulos.add(modulo);
        modulos.add(modulo2);
        modulos.add(modulo3);
        modulos.add(modulo4);

        Set<Modulo> modulos2 = new HashSet<Modulo>();
        modulos2.add(modulo);
        modulos2.add(modulo2);
        modulos2.add(modulo4);

        Set<Modulo> modulos3 = new HashSet<Modulo>();
        modulos3.add(modulo3);
        modulos3.add(modulo4);

        Set<Modulo> modulos4 = new HashSet<Modulo>();
        modulos4.add(modulo2);
        modulos4.add(modulo3);
        modulos4.add(modulo4);

        //Insertamos los datos de los alumnos en la tabla alumnos
		/*Alumno alumno = new Alumno("Juan", "Espaniola", 26, "Hombre");
		Alumno alumno2 = new Alumno("Pedro", "Andorrana", 21, "Hombre");
		Alumno alumno3 = new Alumno("Marta", "Espaniola", 19, "Mujer");
		Alumno alumno4 = new Alumno("Carla", "Francesa", 35, "Mujer");*/

        Alumno alumno = new Alumno();
        alumno.setNombre("Juan");
        alumno.setNacionalidad("Espaniola");
        alumno.setEdad(26);
        alumno.setSexo("Hombre");
        alumno.setModulos(modulos);

        Alumno alumno2 = new Alumno();
        alumno2.setNombre("Pedro");
        alumno2.setNacionalidad("Andorrana");
        alumno2.setEdad(21);
        alumno2.setSexo("Hombre");
        alumno2.setModulos(modulos2);

        Alumno alumno3 = new Alumno();
        alumno3.setNombre("Marta");
        alumno3.setNacionalidad("Espaniola");
        alumno3.setEdad(19);
        alumno3.setSexo("Mujer");
        alumno3.setModulos(modulos3);

        Alumno alumno4 = new Alumno();
        alumno4.setNombre("Carla");
        alumno4.setNacionalidad("Francesa");
        alumno4.setEdad(35);
        alumno4.setSexo("Mujer");
        alumno4.setModulos(modulos4);

        //Imprimimos por pantalla el toString que nos pide la PAC
        System.out.println(alumno.toString());
        System.out.println(alumno2.toString());
        System.out.println(alumno3.toString());
        System.out.println(alumno4.toString());

        //Guardamos los datos en la tabla alumnos en la base de datos
        session.save(alumno);
        session.save(alumno2);
        session.save(alumno3);
        session.save(alumno4);

        //Insertamos los datos del profesor en la tabla profesores
        Profesor profesor = new Profesor("Alvaro", "Hombre");

        //Imprimimos por pantalla el toString que nos pide la PAC
        System.out.println(profesor.toString());

        //Guardamos los datos en la tabla profesores en la base de datos
        session.save(profesor);

        session.getTransaction().commit();
        //tx.commit();

        System.out.println("Cerrando conexión a BD...");

        //Cerramos la conexión a la base de datos
        session.close();
        //sessionFactory.close();

        System.out.println("Conexión terminada a BD...");

    }

}
