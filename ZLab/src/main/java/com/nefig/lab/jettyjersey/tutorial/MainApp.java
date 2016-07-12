package com.nefig.lab.jettyjersey.tutorial;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class MainApp {

	public static void main(String[] args) throws Exception {
		MainApp app = new  MainApp();
		app.startServerUsingOption2();

	}

	private void startServerUsingOption2() throws Exception, InterruptedException {
		ResourceConfig config = new ResourceConfig();
		config.packages("com.nefig.lab.jettyjersey.tutorial");
		ServletHolder servlet = new ServletHolder(new ServletContainer(config));

		Server server = new Server(8080);
		ServletContextHandler context = new ServletContextHandler(server, "/*");
		context.addServlet(servlet, "/*");

		try {
			server.start();
			server.join();
		} finally {
			server.destroy();
		}
	}

	public void startServerUsingOption1() throws Exception {
		ServletContextHandler context = new ServletContextHandler(
				ServletContextHandler.SESSIONS);
		context.setContextPath("/");

		Server jettyServer = new Server(8080);
		jettyServer.setHandler(context);

		ServletHolder jerseyServlet = context.addServlet(
				org.glassfish.jersey.servlet.ServletContainer.class, "/*");
		jerseyServlet.setInitOrder(0);

		// Tells the Jersey Servlet which REST service/class to load.
		jerseyServlet.setInitParameter(
				"jersey.config.server.provider.classnames", 
				Resource.class.getCanonicalName());

		try {
			jettyServer.start();
			jettyServer.join();
		} finally {
			jettyServer.destroy();
		}
	}

}
