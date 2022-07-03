
package controlador;

import java.util.List;
import modelo.EmpresaModel;
import vista.EmpresaView;


public interface EmpresaController {
    public void setup(EmpresaModel Model,List<EmpresaView> view); //Enlazamos la vista y modelo
    void start(); //lanza aplicacion
    
    void addView(EmpresaView view);
    void deleteView(EmpresaView view);
    public EmpresaModel getModel();
    public void setModel(EmpresaModel model);
    
    public void nuevoEmpresaGesture(String Cif,String nombre,String domicilio);
    public void borraEmpresaGesture(String CIF);
    public void actualizaEmpresaGesture(String Cif,String nombre,String domicilio);
    
    public void fireDataModelChanged();
    
}
