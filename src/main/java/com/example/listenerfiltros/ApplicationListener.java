package com.example.listenerfiltros;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class ApplicationListener implements ServletContextListener, ServletRequestListener, HttpSessionListener {
    private ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("ServletContextInitialized");
        servletContext = sce.getServletContext();
        servletContext.setAttribute("msg", "Hello from app");
        //Este se llama cuando se inicializa el contexto de la aplicacion web (Una sola vez en la inicialización de la app)
        // Ej: configurar recursos compartidos, inicializar conexiones a bases de datos, etc.
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        servletContext.log("Starting request");
        sre.getServletRequest().setAttribute("msg", "Saving a value for request");
        //Se llama cada que se realiza una solicitud del cliente
        //Ej: para realizar cualquier inicialización necesaria para una solicitud específica,
        //como configurar atributos de solicitud, preparar recursos necesarios para procesar la solicitud, etc.
    }
}
