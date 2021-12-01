package controlador;
import java.util.Date;
import Modelo.Entrada;
import BD.Conexion;
import Modelo.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author @author Pía Trujillo / José Ignacio Gutiérrez
 */
public class Registro {

    private String alias;
    
    public boolean agregar(Entrada entrada){
        Date date;
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            date = entrada.getFuncion();
            
            String query = "INSERT INTO entrada(titulo, alias, funcion, cantidadEntrada, precio, disponible) VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, entrada.getTitulo());
            stmt.setString(2, entrada.getAlias());
            stmt.setDate(3, new java.sql.Date(date.getTime()));
            stmt.setInt(4, entrada.getCantidadEntrada());
            stmt.setInt(5, entrada.getPrecio());
            stmt.setBoolean(6, entrada.isDisponible());
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
            
        } 
        catch (SQLException e) {
            System.out.println("Error SQL al agregar película" + e.getMessage());
            return false;
        } 
        catch (Exception e) {
            System.out.println("Error al agregar película (EXCEPTION)"  + e.getMessage());
            return false;
        }
    }    
        
    public boolean actualizar(Entrada entrada){
        
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "UPDATE entrada SET titulo = ?, funcion = ?, cantidadEntrada = ?, precio = ?, disponible = ? WHERE alias = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, entrada.getTitulo());
            stmt.setDate(2, new java.sql.Date(entrada.getFuncion().getTime()));
            stmt.setInt(3, entrada.getCantidadEntrada());
            stmt.setInt(4, entrada.getPrecio());
            stmt.setBoolean(5, entrada.isDisponible());
            stmt.setString(6, entrada.getAlias());
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
            
        } 
        catch (SQLException e) {
            System.out.println("Error SQL al actualizar película" + e.getMessage());
            return false;
        } 
        catch (Exception e) {
            System.out.println("Error al actualizar película (EXCEPTION)"  + e.getMessage());
            return false;
        }
    }
  
    public boolean actualizarCompra(Compra compra){
        
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "UPDATE entrada SET cantidadEntrada = ? WHERE alias = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setInt(1, compra.getCantidadEntrada());
            stmt.setString(2, compra.getAlias());
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
            
        } 
        catch (SQLException e) {
            System.out.println("Error SQL al ejecutar compra" + e.getMessage());
            return false;
        } 
        catch (Exception e) {
            System.out.println("Error al ejecutar compra (EXCEPTION)"  + e.getMessage());
            return false;
        }
    }    
    
    public boolean eliminar(String Alias){

        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
            
            String query = "DELETE FROM entrada WHERE alias = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, alias); //REVISAR <------------------------------------------------------
            
            stmt.executeUpdate();
            stmt.close();
            cnx.close();
            
            return true;
            
        } 
        catch (SQLException e) {
            System.out.println("Error SQL al eliminar película" + e.getMessage());
            return false;
        } 
        catch (Exception e) {
            System.out.println("Error al eliminar película (EXCEPTION)"  + e.getMessage());
            return false;
        }
        
    }
    
    public Entrada buscarPorAlias(String alias){
        
        Entrada entrada = new Entrada();
        
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
                        
            String query = "SELECT titulo, alias, funcion, cantidadEntrada, precio, disponible FROM entrada WHERE alias = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(2, alias);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                entrada.setTitulo(rs.getString("titulo"));
                entrada.setAlias(rs.getString("alias"));
                entrada.setFuncion(rs.getDate("funcion"));
                entrada.setCantidadEntrada(rs.getInt("cantidadEntrada"));
                entrada.setPrecio(rs.getInt("precio"));
                entrada.setDisponible(rs.getBoolean("disponible"));
                
            }
            rs.close();
            stmt.close();
            cnx.close();
            
        } catch (SQLException e) {
            System.out.println("Error SQL al buscar película: " + e.getMessage());
            
        } catch(Exception e){
            System.out.println("Error al buscar película (EXCEPTION): " + e.getMessage());
            
        }
        return entrada;
    }
    
    public List<Entrada> buscarTodos(){
        
        List<Entrada> lista = new ArrayList<>();
        
        try {
            Conexion con = new Conexion();
            Connection cnx = con.obtenerConexion();
                        
            String query = "SELECT titulo, alias, funcion, cantidadEntrada, precio, disponible FROM entrada";
            PreparedStatement stmt = cnx.prepareStatement(query);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Entrada entrada = new Entrada();
                entrada.setTitulo(rs.getString("titulo"));
                entrada.setAlias(rs.getString("alias"));
                entrada.setFuncion(rs.getDate("funcion"));
                entrada.setCantidadEntrada(rs.getInt("cantidadEntrada"));
                entrada.setPrecio(rs.getInt("precio"));
                entrada.setDisponible(rs.getBoolean("disponible"));
                
                lista.add(entrada);
                
            }
            rs.close();
            stmt.close();
            cnx.close();
            
        } catch (SQLException e) {
            System.out.println("Error SQL al buscar película: " + e.getMessage());
            
        } catch(Exception e){
            System.out.println("Error al buscar película (EXCEPTION): " + e.getMessage());
            
        }
        return lista;
        
    }
    
    public boolean buscarPelicula(List<Entrada> lista, String alias){
        for (Entrada entrada : lista){
            if (entrada.getAlias().equals(alias)) {
                return true;
            }  
        }
        return false;
    }
    
}