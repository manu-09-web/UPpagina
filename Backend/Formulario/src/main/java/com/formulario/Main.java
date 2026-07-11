package com.formulario;

import com.formulario.controllers.FormularioController;
import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableCors(cors -> {
                cors.addRule(it -> it.anyHost());
            });
        }).start(7000);

        app.get("/", ctx -> ctx.result("Servidor de Formulario corriendo..."));
        FormularioController.registrarRutas(app);

        System.out.println("Servidor corriendo en http://localhost:7000");
    }
}