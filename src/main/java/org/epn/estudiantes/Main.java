package org.epn.estudiantes;

import org.epn.estudiantes.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        System.out.println("Aplicación PortalEstudiantilEPN iniciada.");

        // Obtener la SessionFactory y abrir una sesión de Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            // Aquí podrías realizar alguna operación como insertar una entidad, para asegurarte de que Hibernate esté trabajando
            System.out.println("Iniciando transacción con Hibernate...");

            // Si quieres forzar la creación de tablas, puedes realizar una operación en alguna entidad:
            // Usuario usuario = new Usuario();
            // usuario.setNombre("John Doe");
            // session.save(usuario);

            // Confirmar la transacción (opcional si solo deseas crear las tablas)
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) transaction.rollback();
        } finally {
            session.close();
        }

        // Cerrar la SessionFactory al finalizar
        HibernateUtil.shutdown();
    }
}
