package com.formulario.dao;

import com.formulario.modelos.Formulario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FormularioDAO {

    public boolean insertar(Formulario f) {
        String sql = "INSERT INTO FORMULARIO (Nombre, Correo, Telefono, Preparatoria, Dudas) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, f.getNombre());
            ps.setString(2, f.getCorreo());
            ps.setString(3, f.getTelefono());
            ps.setString(4, f.getPreparatoria());
            ps.setString(5, f.getDudas());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Formulario> listarTodos() {
        List<Formulario> lista = new ArrayList<>();
        String sql = "SELECT * FROM FORMULARIO ORDER BY FechaRegistro DESC";
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Formulario f = new Formulario();
                f.setIdFormulario(rs.getInt("idFormulario"));
                f.setNombre(rs.getString("Nombre"));
                f.setCorreo(rs.getString("Correo"));
                f.setTelefono(rs.getString("Telefono"));
                f.setPreparatoria(rs.getString("Preparatoria"));
                f.setDudas(rs.getString("Dudas"));
                lista.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Formulario buscarPorId(int id) {
        String sql = "SELECT * FROM FORMULARIO WHERE idFormulario = ?";
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Formulario f = new Formulario();
                f.setIdFormulario(rs.getInt("idFormulario"));
                f.setNombre(rs.getString("Nombre"));
                f.setCorreo(rs.getString("Correo"));
                f.setTelefono(rs.getString("Telefono"));
                f.setPreparatoria(rs.getString("Preparatoria"));
                f.setDudas(rs.getString("Dudas"));
                return f;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM FORMULARIO WHERE idFormulario = ?";
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}