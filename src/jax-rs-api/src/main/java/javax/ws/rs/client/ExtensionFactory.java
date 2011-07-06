package javax.ws.rs.client;

public interface ExtensionFactory<T extends Invocation> {
	
	T wrap(Invocation invocation);

}
