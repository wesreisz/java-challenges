package com.wesleyreisz.challenges.simpleservice;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final int PORT = 8888;
    public static void main( String[] args )
    {
        System.out.println( "Starting Server" );
        ResourceConfig config = new ResourceConfig();
        config.packages("com.wesleyreisz.challenges.simpleservice");
        ServletHolder servlet = new ServletHolder(new ServletContainer(config));
        servlet.setInitParameter("jersey.config.server.provider.classnames","org.glassfish.jersey.moxy.json.MoxyJsonFeature");

        //routing servlets
        Server server = new Server(PORT);

        ServletContextHandler context = new ServletContextHandler(server, "/*");
        context.addServlet(servlet, "/*");

        //start the server
        try {
            server.start();
            server.join();
            System.out.println(String.format("Server Running at http://localhost: %d",PORT));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            server.destroy();
        }

    }
}
