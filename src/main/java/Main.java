import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        String nuevoNom="";
        String nuevoApell="";
        String nuevoNum="";
        String nuevaEmp="";
        String nuevoMail="";
        boolean loop=true;
        int eleccionUser=0;
        String eliminado="";
        
        ArrayList <Contacto> contactos = new ArrayList<Contacto>();
        Scanner scanner = new Scanner(System.in);
        
        
        contactos.add(new Contacto("Carlos", "Olmos" ,"346 xxx 2425", "Olimpo","ricar0421.reyes@gmail.com"));
        contactos.add(new Contacto("Isaac ", "Saucedo","449 xxx 0069", "Olimpo","210686@utags.edu.mx"));
        contactos.add(new Contacto("Ricardo ", "Lopez","449 540 3154", "Olimpo","olmostiti.perez@gmail.com"));
        contactos.add(new Contacto("Jose ","Balderas" ,"449 xxx xxxx", "CEH","edleritter313@gmail.com"));

        
        while (loop==true){
            System.out.println("""
                               ----------------Lista de contactos---------------
                               1-Consultar la lista  2-Añadir un     3-Eliminar
                               actual de contactos     contacto       contacto
                               
                                    4- editar         99- salir del sistema
                                      contacto  
                               """);
            eleccionUser=scanner.nextInt();
            switch (eleccionUser){
                case 1:
                    //for each para ahorrar memoria
                        for (Contacto i: contactos) {
                        System.out.println("---------------+---------------");
                        System.out.println(i.toString());
                        }
                    break;
                case 2:
                    //agregar contacto
                    System.out.println("Ingrese el nombre: ");
                    scanner.nextLine();
                    nuevoNom = scanner.nextLine();
                    
                    System.out.println("Ingrese el apellido");
                    nuevoApell = scanner.nextLine();
        
                    System.out.println("Ingrese el numero: ");
                    nuevoNum=scanner.nextLine();
        
                    System.out.println("Ingresa asociacion &/o empresa: ");
                    nuevaEmp=scanner.nextLine();
                    
                    System.out.println("Ingrese el correoo electronico: ");
                    nuevoMail=scanner.nextLine();
                    
                    contactos.add(new Contacto(nuevoNom, nuevoApell,nuevoNum, nuevaEmp,nuevoMail));
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del contacto que quieres eleminiar");
                    scanner.nextLine();
                    eliminado = scanner.nextLine();
                    for(Contacto contacto : contactos) {
                        if(contacto.getNombre().equals(eliminado)) {
                            contactos.remove(contacto);
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Ingresa el nombre del contacto para editar: ");
                    scanner.nextLine();
                    nuevoNom = scanner.nextLine();
                    for (Contacto i: contactos) {
                        if (i.getNombre().equals(nuevoNom)) {
                            System.out.println("""
                                       elija el dato que quiera editar: 
                                       1- Nombre            2-Apellifo 
                                       
                                       
                                       3- Numero        4-Asociacion / Empresa
                                               5- correo electronico
                                       """);
                            eleccionUser=scanner.nextInt();
                            scanner.nextLine();
                    
                            if (eleccionUser==1) {
                                System.out.println("Ingrese el nuevo nombre: ");
                                scanner.nextLine();
                                    nuevoNom = scanner.nextLine();
                                    i.setNombre(nuevoNom);
                            }else if(eleccionUser==2){
                                System.out.println("ingrese el nuevo apellido: ");
                                scanner.nextLine();
                                nuevoApell = scanner.nextLine();
                                i.setNombre(nuevoApell);
                            }else if(eleccionUser==3){
                                System.out.println("Ingrese el nuevo nuemro: ");
                                scanner.nextLine();
                                nuevoNum = scanner.nextLine();
                                i.setTelefono(nuevoNum);
                            }else if(eleccionUser==4){
                                System.out.println("Ingrese la nueva asociacion: ");
                                scanner.nextLine();
                                nuevaEmp = scanner.nextLine();
                                i.setEmpresaAsociacion(nuevaEmp);
                            }else if(eleccionUser==5){
                                System.out.println("Ingrese el nuevo correo: ");
                                scanner.nextLine();
                                nuevoMail= scanner.nextLine();
                                i.setCorreo(nuevoMail);
                            }else{
                                System.out.println("intente de nuveo... ");
                            }
                        }
                    }
                    break;
                case 99:
                    loop=false;
                    System.out.println("Saliendo de la aplicacion....");
                    System.out.println("Adios!...");
                    break;
                default:
                    loop=false;
                    System.out.println("Saliendo de la aplicacion....");
                    System.out.println("Adios!...");
                    break;
            }
        }
    }
}