
package modelo;


public class EmpresaImpl implements Empresa{
    private String cif;
    private String nombre;
    private String domicilio;

    public EmpresaImpl(String cif) {
        this(cif,null,null);
    }

    public EmpresaImpl(String cif, String nombre, String domicilio) {
        this.cif = cif;
        this.nombre = nombre;
        this.domicilio = domicilio;
    }
    
    

    @Override
    public String getCIF() {
       return cif;
    }

    @Override
    public String getNombre() {
      return nombre;
    }

    @Override
    public String getDomicilio() {
      return domicilio;     
    }

    @Override
    public void setCIF(String cif) {
      this.cif=cif;  
    }

    @Override
    public void setNombre(String Nombre) {
       this.nombre=nombre;
    }

    @Override
    public void setDomicilio(String Domicilio) {
      this.domicilio=domicilio;    
    }
}
