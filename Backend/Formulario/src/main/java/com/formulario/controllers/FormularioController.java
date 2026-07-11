package com.formulario.controllers;

import com.formulario.dao.FormularioDAO;
import com.formulario.modelos.Formulario;
import io.javalin.Javalin;

public class FormularioController {
    private static final FormularioDAO dao = new FormularioDAO();

    public static void registrarRutas(Javalin app) {

        // Crear
        app.post("/api/formulario", ctx -> {
            Formulario f = ctx.bodyAsClass(Formulario.class);

            if (f.getNombre() == null || f.getCorreo() == null || f.getTelefono() == null || f.getPreparatoria() == null) {
                ctx.status(400).json("Nombre, correo, telefono y preparatoria son obligatorios");
                return;
            }

            boolean ok = dao.insertar(f);
            if (ok) {
                ctx.status(201).json("Registro guardado correctamente");
            } else {
                ctx.status(500).json("Error al guardar el registro");
            }
        });

        // Listar todos
        app.get("/api/formulario", ctx -> {
            ctx.json(dao.listarTodos());
        });

        // Buscar por id
        app.get("/api/formulario/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            Formulario f = dao.buscarPorId(id);
            if (f != null) {
                ctx.json(f);
            } else {
                ctx.status(404).json("No encontrado");
            }
        });

        // Eliminar
        app.delete("/api/formulario/{id}", ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            boolean ok = dao.eliminar(id);
            if (ok) {
                ctx.status(200).json("Eliminado correctamente");
            } else {
                ctx.status(404).json("No encontrado");
            }
        });
    }
}