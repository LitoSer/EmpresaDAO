
package modelo.persistencia;

import java.util.List;
import modelo.Empresa;


public interface EmpresaDAO {   //operaciones DAO

    public void create(Empresa empresa);

    public void delete(Empresa empresa);

    public void update(Empresa empresa);

    public Empresa read(String pk);

    List<Empresa> list();
}
