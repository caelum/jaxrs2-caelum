package javax.ws.rs2;

import javax.ws.rs2.acceptance.Client;

public interface Serializer<T> {

	LinkBuilder link(String uri);

	T parse();

}
