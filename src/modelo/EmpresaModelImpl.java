
package modelo;

import controlador.EmpresaController;
import java.util.List;
import modelo.persistencia.EmpresaDAO;
import modelo.persistencia.JDBC.EmpresaDAOJDBC;


public class EmpresaModelImpl implements EmpresaModel {
      private EmpresaController controller;
    @Override
    public EmpresaController getController() {
        return controller;
    }

    public void setController(EmpresaController controller) {
        this.controller=controller;
    }

    @Override
    public void nuevaEmpresa(Empresa empresa) {
      EmpresaDAO dao=obtenerimplementacionEmpresa();
      dao.create(empresa);
      fireModelChanged();
    }

    @Override
    public void borrarEmpresa(Empresa empresa) {
       EmpresaDAO dao=obtenerimplementacionEmpresa();
       dao.delete(empresa);
       fireModelChanged();
    }

    @Override
    public void actualizaEmpresa(Empresa empresa) {
       EmpresaDAO dao=obtenerimplementacionEmpresa();
       dao.update(empresa);
       fireModelChanged();
    }

    @Override
    public Empresa obtenerEmpresa(String cif) {
      EmpresaDAO dao=obtenerimplementacionEmpresa();
      return dao.read(cif);
    }
    public List<Empresa> obtenerEmpresas() {
        EmpresaDAO dao=obtenerimplementacionEmpresa();
        return dao.list();
    }

    
    
    public EmpresaDAOJDBC obtenerimplementacionEmpresa(){
        return new EmpresaDAOJDBC();
    }
    
    
    public void fireModelChanged(){
        getController().fireDataModelChanged();
        
    }

    

    
    
}
