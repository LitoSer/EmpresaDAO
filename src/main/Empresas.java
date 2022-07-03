/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controlador.EmpresaController;
import controlador.EmpresaControllerImpl;
import java.util.ArrayList;
import java.util.List;
import modelo.EmpresaModel;
import modelo.EmpresaModelImpl;
import vista.EmpresaView;
import vista.EmpresaViewImpl;


public class Empresas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         EmpresaModel model = new EmpresaModelImpl();
         List<EmpresaView> views= new ArrayList<EmpresaView>();        
         EmpresaView view1 = new EmpresaViewImpl();
         views.add(view1);
        

        EmpresaController controller = new EmpresaControllerImpl();
        
        controller.setup(model, views);
        controller.start();
    }
    
}
