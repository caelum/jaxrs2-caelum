package javax.ws.rs2.acceptance;

import java.util.List;

public interface Clients {

	Client find(Long id);

	List<Client> all();

}
