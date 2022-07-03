
package vista;

import controlador.EmpresaController;
import modelo.Empresa;
import modelo.EmpresaModel;



public class EmpresaViewImpl extends javax.swing.JFrame implements EmpresaView{
    //Atributos del MVC
    private EmpresaModel model;
    private EmpresaController controller;

    //Atributos propios de Swing
    private EmpresaTableModel tableModel;
    private JPanelContacto panelContacto;


    /** Creates new form VentanaPrincipal */
    public EmpresaViewImpl() {
        tableModel=new EmpresaTableModel();
        initComponents();
        
        this.panelContacto=new JPanelContacto(this);
        this.jPanelDown.add(this.panelContacto);

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDown = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableContactos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Contactos");

        jPanelDown.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelDown.setLayout(new javax.swing.BoxLayout(jPanelDown, javax.swing.BoxLayout.LINE_AXIS));

        jTableContactos.setModel(tableModel);
        jTableContactos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableContactosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableContactos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelDown, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jPanelDown, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        //esto hace que yo al clikar sobre una linea de la tabla me garge los valores
    private void jTableContactosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableContactosMouseClicked
        // TODO add your handling code here: 
        EmpresaTableModel ctm=(EmpresaTableModel)this.jTableContactos.getModel();
        Empresa empresas=ctm.getRow(this.jTableContactos.getSelectedRow());
        panelContacto.setEmpresa(empresas);
    }//GEN-LAST:event_jTableContactosMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpresaViewImpl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelDown;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableContactos;
    // End of variables declaration//GEN-END:variables

    public EmpresaController getController() {
        return controller;
    }

    public void setController(EmpresaController controller) {
        this.controller=controller;
    }

    public EmpresaModel getModel() {
        return model;
    }

    public void setModel(EmpresaModel model) {
        this.model=model;
    }

    public void dataModelChanged() {
        refresh();
    }

    public void display() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
                refresh();
            }
        });
    }
    protected void refresh() {
        tableModel.setEmpresa(getModel().obtenerEmpresas());//cambia el modelo de JTable(TableModel) por medio de una clase que hemos creado (EmpresaTableModel)
    }

    protected void fireNuevoEmpresaGesture(String cif, String nombre, String domicilio) {
        getController().nuevoEmpresaGesture(cif,nombre,domicilio);
    }

    protected void fireActualizaEmpresaGesture(String cif, String nombre, String domicilio) {
        getController().actualizaEmpresaGesture(cif,nombre,domicilio);
    }

    protected void fireBorraEmpresaGesture(String cif) {
        getController().borraEmpresaGesture(cif);
    }

    

}
