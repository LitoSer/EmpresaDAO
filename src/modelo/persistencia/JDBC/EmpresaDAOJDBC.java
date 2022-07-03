
package modelo.persistencia.JDBC;

import java.sql.*;
import java.util.*;
import modelo.Empresa;
import modelo.EmpresaImpl;
import modelo.persistencia.EmpresaDAO;



public class EmpresaDAOJDBC implements EmpresaDAO {

    @Override
    public void create(Empresa empresa) {
        String sql = "insert into empresa(cif,nombre,domicilio) values (?,?,?)";
        try{
            PreparedStatement stm = Persistencia.createConnection().prepareStatement(sql);
            stm.setString(1, empresa.getCIF());
            stm.setString(2, empresa.getNombre());
            stm.setString(3, empresa.getDomicilio());
            
            stm.execute();
            
        }catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
            
        }
    


    @Override
    public void delete(Empresa empresa) {
      String sql="delete FROM empresa where cif=?";
        
        try{
          PreparedStatement stmt=Persistencia.createConnection().prepareStatement(sql);
          stmt.setString(1, empresa.getCIF());
          stmt.executeUpdate();
      
      }  catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
    }
    }

    @Override
    public void update(Empresa empresa) {
        String sql="update empresa set nombre=?, domicilio=? where cif LIKE ?";
       try{
           PreparedStatement stm=Persistencia.createConnection().prepareStatement(sql);
           
           stm.setString(1, empresa.getNombre());
           stm.setString(2, empresa.getDomicilio());
           stm.setString(3, empresa.getCIF());
           
           stm.executeUpdate();
       
       }catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    @Override
    public Empresa read(String pk) {
       Empresa c=null;
       try {
           Statement stmt=Persistencia.createConnection().createStatement();
           ResultSet res=stmt.executeQuery("SELECT * FROM empresa where cif=" +pk);
           String CIF,nombre,domicilio;
           if(res.next()){
               CIF=res.getString("cif");
               nombre=res.getString("nombre");
               domicilio=res.getString("domicilio");
               c=new EmpresaImpl(CIF, nombre, domicilio);
           }     
         }catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return c;
       
    }
    

    @Override
    public List<Empresa> list() {
         List<Empresa> empresa = new ArrayList<Empresa>();

        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM empresa ");
            String CIF, nombre, domicilio;
            while (res.next()) {

                CIF = res.getString("cif");
                nombre = res.getString("nombre");
                domicilio = res.getString("domicilio");
                empresa.add(new EmpresaImpl(CIF,nombre,domicilio));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return empresa;
    }
    
    }
    

