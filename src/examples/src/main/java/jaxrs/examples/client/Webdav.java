package jaxrs.examples.client;

import javax.ws.rs.client.DelegateInvocation;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.HttpResponse;

public class Webdav extends DelegateInvocation{

	public Webdav(Invocation invocation) {
		super(invocation);
	}
	
	public HttpResponse propfind() {
		wrapped.method("PROPFIND");
		return null;
	}

}
