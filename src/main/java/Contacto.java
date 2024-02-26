
public class Contacto {
    String nombre;
    String apellido;
    String telefono;
    String empresaAsociacion;
    String correo;

    public Contacto(String nombre, String apellido, String telefono, String empresaAsociacion, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.empresaAsociacion = empresaAsociacion;
        this.correo = correo;
    }
    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmpresaAsociacion() {
        return empresaAsociacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmpresaAsociacion(String empresaAsociacion) {
        this.empresaAsociacion = empresaAsociacion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
    @Override
    public String toString() {
        return "nombre: " + nombre +"\nApellido: "+apellido+ "\ntelefono: " + telefono + "\nempresa/asociacion: " + empresaAsociacion + "\ncorreo: " + correo;
    }  
}
