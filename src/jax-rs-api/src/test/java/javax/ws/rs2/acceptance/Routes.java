package javax.ws.rs2.acceptance;

import static javax.ws.rs2.Parameters.param;

import javax.ws.rs2.Router;

public class Routes implements RouteConfiguration {
	
	public void configure(Router router) {
		
		router.at("/clients/finder").does(ClientController.class).find(null);
		
		// here you can locate your resources and implement any CoC
		// or customize someone's else CoC
		// ...
		
		// using the default for a non-automatically registered component
		router.at("/clients").register(ClientController.class);
		
		// if you don't want to support parameter reading
		router.at("/clients/finder").does(ClientController.class).update(param("toUpdate").as(Client.class)); 
		
	}

}
