
package vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import modelo.Empresa;


public class EmpresaTableModel implements TableModel {

    private List<Empresa> empresa = new ArrayList<Empresa>();
    private List<TableModelListener> listeners = new ArrayList<TableModelListener>();

    public List<Empresa> getContactos() {
        return empresa;
    }

    public void setEmpresa(List<Empresa> empresa) {
        this.empresa = empresa;
        fireContentsChanged();
    }

    public Empresa getRow(int indexRow){
        return empresa.get(indexRow);
    }
    public int getRowCount() {
        return empresa.size();
    }

    public int getColumnCount() {
        return 3; //tres valores a mostrar
    }

    public String getColumnName(int columnIndex) {
        String name = null;
        switch (columnIndex) {
            case 0:
                name = "Cif";
                break;
            case 1:
                name = "Nombre";
                break;
            case 2:
                name = "Domicilio";
                break;
        }
        return name;
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class; //Todos los valores de contacto son un String
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; //No permito editar celdas
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Empresa empresas = empresa.get(rowIndex);
        String value = null;
        switch (columnIndex) {
            case 0:
                value = empresas.getCIF();
                break;
            case 1:
                value = empresas.getNombre();
                break;
            case 2:
                value = empresas.getDomicilio();
                break;
        }
        return value;

    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addTableModelListener(TableModelListener l) {   //relacionado con el patron observador, puedo añadir
        listeners.add(l);
    }

    public void removeTableModelListener(TableModelListener l) {   //relacionado con el patron observador, puedo eliminer
        listeners.remove(l);
    }

     protected void fireContentsChanged() {   //esta es la que notifica a los observadores
        
         TableModelEvent event = new TableModelEvent(this, 0, this.getRowCount()-1, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
        for (TableModelListener listener : listeners) {
            listener.tableChanged(event);
        }
    }
}
