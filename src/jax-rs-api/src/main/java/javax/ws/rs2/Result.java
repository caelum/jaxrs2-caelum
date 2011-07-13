package javax.ws.rs2;

public interface Result {

	<T> T redirectTo(T controller);
	<T> T redirectTo(Class<T> type);

}
