package javax.ws.rs2;



public interface Route {

	<T> T does(Class<T> type);

	/**
	 * Registers all public methods from this controller
	 */
	<T> void register(Class<T> type);

}
