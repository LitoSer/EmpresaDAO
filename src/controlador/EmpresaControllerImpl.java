
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Empresa;
import modelo.EmpresaImpl;
import modelo.EmpresaModel;
import vista.EmpresaView;


public class EmpresaControllerImpl implements EmpresaController {

    private EmpresaModel model;
    private List<EmpresaView> views=new ArrayList<EmpresaView>();
    
      
    public void setup(EmpresaModel model, List<EmpresaView> view) {
        
        setModel(model);
        addView(view);
        model.setController(this);
        }

    @Override
    public void start() {
        for(EmpresaView view:views){
            view.display();
        }
    }

    public void addView(EmpresaView view) {
       view.setModel(model);
       view.setController(this);
       views.add(view);
    }
    public void addView(List<EmpresaView> views) {
       for(EmpresaView view:views){
           addView(view);
       }
    }

    public void deleteView(EmpresaView view) {
        views.remove(view);
    }

    @Override
    public EmpresaModel getModel() {
        return model;
    }

    @Override
    public void setModel(EmpresaModel model) {
      this.model=model;
    }

    @Override
    public void nuevoEmpresaGesture(String cif, String nombre, String domicilio) {
        Empresa empresa=new EmpresaImpl(cif);
        empresa.setNombre(nombre);
        empresa.setDomicilio(domicilio);
        this.model.nuevaEmpresa(empresa);
        
    }

    @Override
    public void borraEmpresaGesture(String cif) {
        Empresa empresa=new EmpresaImpl(cif);
        this.model.borrarEmpresa(empresa);
    }

    @Override
    public void actualizaEmpresaGesture(String cif, String nombre, String domicilio) {
        Empresa empresa=new EmpresaImpl(cif);
        empresa.setNombre(nombre);
        empresa.setDomicilio(domicilio);
        this.model.actualizaEmpresa(empresa);
    }

    @Override
    public void fireDataModelChanged() {
        for(EmpresaView view:views){
            view.dataModelChanged();
        }
    }

    
}
