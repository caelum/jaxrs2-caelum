package jaxrs.examples.client;

import javax.ws.rs.client.ExtensionFactory;
import javax.ws.rs.client.Invocation;

public class WebdavFactory implements ExtensionFactory<Webdav> {

	public Webdav wrap(Invocation invocation) {
		return new Webdav(invocation);
	}

}
