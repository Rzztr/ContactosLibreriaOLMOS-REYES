import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MainContacto {
    public static void main(String[] args) {
        ArrayList<Contacto> contactos = new ArrayList<>();
        
        contactos.add(new Contacto("Carlos", "Olmos" ,"346 xxx 2425", "Olimpo","ricar0421.reyes@gmail.com"));
        contactos.add(new Contacto("Isaac ", "Saucedo","449 xxx 0069", "Olimpo","210686@utags.edu.mx"));
        contactos.add(new Contacto("Ricardo ", "Lopez","449 540 3154", "Olimpo","olmostiti.perez@gmail.com"));
        contactos.add(new Contacto("Jose ","Balderas" ,"449 xxx xxxx", "CEH","edleritter313@gmail.com"));

        boolean loop = true;

        while (loop) {
            String input = JOptionPane.showInputDialog("""
                    ----------------Lista de contactos---------------
                    1- Consultar la lista  2- Añadir un     3- Eliminar
                       actual de contactos     contacto       contacto
                    4- Editar contacto
                    99- Salir del sistema
                    """);

            try {
                int eleccionUser = Integer.parseInt(input);

                switch (eleccionUser) {
                    case 1:
                        // for each para ahorrar memoria
                        StringBuilder contactList = new StringBuilder();
                        for (Contacto i : contactos) {
                            contactList.append("---------------+---------------\n")
                                    .append(i.toString())
                                    .append("\n");
                        }
                        JOptionPane.showMessageDialog(null, contactList.toString(), "Lista de Contactos", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 2:
                        // agregar contacto
                        String nuevoNom = JOptionPane.showInputDialog("Ingrese el nombre:");
                        String nuevoApell = JOptionPane.showInputDialog("Ingrese el apellido:");
                        String nuevoNum = JOptionPane.showInputDialog("Ingrese el numero:");
                        String nuevaEmp = JOptionPane.showInputDialog("Ingresa asociacion &/o empresa:");
                        String nuevoMail = JOptionPane.showInputDialog("Ingrese el correo electronico:");

                        contactos.add(new Contacto(nuevoNom, nuevoApell, nuevoNum, nuevaEmp, nuevoMail));
                        break;
                    case 3:
                        String eliminado = JOptionPane.showInputDialog("Ingrese el nombre del contacto que quieres eliminar");
                        for (Contacto contacto : contactos) {
                            if (contacto.getNombre().equals(eliminado)) {
                                contactos.remove(contacto);
                                break;
                            }
                        }
                        break;
                    case 4:
                        String nombreEditar = JOptionPane.showInputDialog("Ingresa el nombre del contacto para editar:");
                        for (Contacto i : contactos) {
                            if (i.getNombre().equals(nombreEditar)) {
                                int eleccionEditar = Integer.parseInt(JOptionPane.showInputDialog("""
                                                Elija el dato que quiera editar: 
                                                1- Nombre            2- Apellido 
                                                3- Numero            4- Asociacion / Empresa
                                                5- Correo electronico
                                                """));

                                switch (eleccionEditar) {
                                    case 1:
                                        String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre:");
                                        i.setNombre(nuevoNombre);
                                        break;
                                    case 2:
                                        String nuevoApellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido:");
                                        i.setApellido(nuevoApellido);
                                        break;
                                    case 3:
                                        String nuevoNumero = JOptionPane.showInputDialog("Ingrese el nuevo numero:");
                                        i.setTelefono(nuevoNumero);
                                        break;
                                    case 4:
                                        String nuevaAsociacion = JOptionPane.showInputDialog("Ingrese la nueva asociacion:");
                                        i.setEmpresaAsociacion(nuevaAsociacion);
                                        break;
                                    case 5:
                                        String nuevoCorreo = JOptionPane.showInputDialog("Ingrese el nuevo correo:");
                                        i.setCorreo(nuevoCorreo);
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                        break;
                    case 99:
                        loop = false;
                        JOptionPane.showMessageDialog(null, "Saliendo de la aplicación...\nAdiós!", "Salida", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        loop = false;
                        JOptionPane.showMessageDialog(null, "Opción no válida\nSaliendo de la aplicación...\nAdiós!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
  
}
