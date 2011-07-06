package jaxrs.examples.client;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientFactory;
import javax.ws.rs.core.HttpResponse;

import org.junit.Test;

public class MethodExtensionTest {
	
	/**
	 * An extension provider would provide a cute static method like this
	 * so its invocation looks more fluent. 
	 * @return
	 */
	public static WebdavFactory webdav() {
		return new WebdavFactory(); 
	}
	
	@Test
	public void shouldBeCapableOfSupportingNewVerbs() {
        Client client = ClientFactory.newClient();
        HttpResponse response = client.request("http://www.google.com/").with(webdav()).propfind();
        assertEquals(200, response.getStatusCode());
	}

}
