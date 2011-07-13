package javax.ws.rs2.acceptance;

import java.io.File;
import java.util.List;

import javax.ws.rs2.Consumes;
import javax.ws.rs2.Get;
import javax.ws.rs2.Path;
import javax.ws.rs2.Result;
import javax.ws.rs2.Serializer;

// default, but explicitly setting it
@Path("/client")
public class ClientController {
	
	private final Clients clients;
	private final Result result;

	public ClientController(Clients clients, Result result) {
		this.clients = clients;
		this.result = result;
	}
	
	// default, but just leaving explicitly
	@Get("/list")
	public List<Client> list() {
		return clients.all();
	}

	// variations
	@Path("/{id}")
	@Get
	public Client find(Long id) {
		return clients.find(id);
	}
	
	public Client findAndSerializeLinksWithoutBreakingLayers(Long id) {
		Client client = clients.find(id);
		Serializer<Client> serializer = result.use(entity()).from(client);
		serializer.link("self").to(this).find(id);
		return serializer.parse();
	}
	
	// File, InputStream and similars = download
	@Path("/{id}.image")
	public File thumbnail(Long id) {
		return clients.find(id).getThumbnail();
	}
	
	@Consumes // consumes an http entity
	public void create(Client newClient) {
		
	}

	// toUpdate parameters => this object
	// default or due to configuration (see Routes)
	public void update(Client toUpdate) {
		result.redirectTo(this).find(toUpdate.getId());
	}

}
