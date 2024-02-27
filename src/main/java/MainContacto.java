import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;

public class MainContacto {
    public static void main(String[] args) {
        ArrayList<Contacto> contactos = new ArrayList<>();

        contactos.add(new Contacto("Carlos", "Olmos" ,"346 xxx 2425", "Olimpo","ricar0421.reyes@gmail.com"));
        contactos.add(new Contacto("Isaac ", "Saucedo","449 xxx 0069", "Olimpo","210686@utags.edu.mx"));
        contactos.add(new Contacto("Ricardo ", "Lopez","449 540 3154", "Olimpo","olmostiti.perez@gmail.com"));
        contactos.add(new Contacto("Jose ","Balderas" ,"449 xxx xxxx", "CEH","edleritter313@gmail.com"));

        boolean loop = true;

        while (loop) {
            String[] options = {"Consultar lista", "Añadir contacto", "Eliminar contacto", "Editar contacto", "Salir del sistema"};

            int leccion = JOptionPane.showOptionDialog(
                    null,
                    "Selecciona una opción:",
                    "Gestión de Contactos",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            switch (leccion) {
                case 0: // Consultar lista
                    StringBuilder contactList = new StringBuilder();
                    for (Contacto i : contactos) {
                        contactList.append("---------------+---------------\n")
                                .append(i.toString())
                                .append("\n");
                    }
                    JOptionPane.showMessageDialog(null, contactList.toString(), "Lista de Contactos", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 1: // Añadir contacto
                    JPanel addPanel = new JPanel(new GridLayout(5, 2));
                    addPanel.add(new JLabel("Nombre:"));
                    JTextField nombreField = new JTextField();
                    addPanel.add(nombreField);
                    addPanel.add(new JLabel("Apellido:"));
                    JTextField apellidoField = new JTextField();
                    addPanel.add(apellidoField);
                    addPanel.add(new JLabel("Número:"));
                    JTextField numeroField = new JTextField();
                    addPanel.add(numeroField);
                    addPanel.add(new JLabel("Asociación/Empresa:"));
                    JTextField empresaField = new JTextField();
                    addPanel.add(empresaField);
                    addPanel.add(new JLabel("Correo Electrónico:"));
                    JTextField correoField = new JTextField();
                    addPanel.add(correoField);

                    int result = JOptionPane.showConfirmDialog(null, addPanel, "Añadir Contacto",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (result == JOptionPane.OK_OPTION) {
                        contactos.add(new Contacto(
                                nombreField.getText(),
                                apellidoField.getText(),
                                numeroField.getText(),
                                empresaField.getText(),
                                correoField.getText()
                        ));
                    }
                    break;
                case 2: // Eliminar contacto
                    String eliminado = JOptionPane.showInputDialog("Ingrese el nombre del contacto que quieres eliminar");
                    for (Contacto contacto : contactos) {
                        if (contacto.getNombre().equals(eliminado)) {
                            contactos.remove(contacto);
                            break;
                        }
                    }
                    break;
                case 3: // Editar contacto
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
                case 4: // Salir del sistema
                    loop = false;
                    JOptionPane.showMessageDialog(null, "Saliendo de la aplicación...\nAdiós!", "Salida", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    loop = false;
                    JOptionPane.showMessageDialog(null, "Opción no válida\nSaliendo de la aplicación...\nAdiós!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
