package modelo.tienda;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import modelo.vo.CDVO;

public class MailSender {

    public void enviarConGMail(String destinatario, Collection<Seleccion> collection) {
        // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el
        // remitente también.
        String asunto = "Confirmación de Compra.";
        String cuerpo = this.construirTicket(collection);

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // El servidor SMTP de Google
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        //props.put("mail.debug", "true");  //Activar si se quiere que se vea en el fichero log la salida detallada
        props.put("mail.smtp.starttls.enable", "true"); // Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); // El puerto SMTP seguro de Google
        props.put("mail.smtp.auth", "true"); // Usar autenticación mediante usuario y clave

        Session session = Session.getDefaultInstance(props);

        String correo = "tiendacdsdawa@gmail.com";
        String contrasenha = "Contrasenha1"; //

        MimeMessage message = new MimeMessage(session);

        System.out.println("\n\n\n\n\n\t--------------------------------------------------\n\n\tENVIANDO CORREO DESDE "+correo+" para "+destinatario);



        try {
            message.setFrom(new InternetAddress(correo));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario)); // anera
            message.setSubject(asunto);
            message.setText(cuerpo);

            Transport transport = session.getTransport("smtp");
            transport.connect(correo, contrasenha);
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            transport.close();
        } catch (final MessagingException me) {
            me.printStackTrace(); // Si se produce un error
            System.out.println("EXCEPCION EN ENVIO DE EMAIL: " + me.getMessage());
        }
    }

    private String construirTicket(Collection<Seleccion> items) {
        String ticket = new String();

        ticket = "Muchas gracias por su compra en CDTien \n" + " Sus porductos comprados son: \n"
                + "--------------------------------------------\n" + "\tNombre\tArtista\tPrecio\tCantidad\n"
                + "--------------------------------------------\n";

        for (Seleccion aux : items) {
            ticket += "\t" + aux.getCd().getTitulo() + "\t" + aux.getCd().getArtista() + "\t" + aux.getCd().getPrecio()
                    + "\t" + aux.getCantidad()+"\n";
        }

        return ticket;
    }
}
