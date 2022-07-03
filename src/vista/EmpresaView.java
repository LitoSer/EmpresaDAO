package vista;

import controlador.EmpresaController;
import modelo.EmpresaModel;


public interface EmpresaView {

    EmpresaController getController();

    void setController(EmpresaController controller);

    EmpresaModel getModel();

    void setModel(EmpresaModel model);

    void dataModelChanged();

    void display();

}
