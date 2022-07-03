
package modelo;

import controlador.EmpresaController;
import java.util.List;


public interface EmpresaModel {
      public EmpresaController getController();
      public void setController(EmpresaController controller);
      
      public void nuevaEmpresa(Empresa empresa);
      public void borrarEmpresa(Empresa empresa);
      public void actualizaEmpresa(Empresa empresa);
      public Empresa obtenerEmpresa(String CIF);
      List<Empresa> obtenerEmpresas();
             
}
