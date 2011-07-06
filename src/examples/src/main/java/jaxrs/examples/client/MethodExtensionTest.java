package jaxrs.examples.client;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientFactory;
import javax.ws.rs.client.DelegateInvocation;
import javax.ws.rs.client.ExtensionFactory;
import javax.ws.rs.client.Invocation;
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


	class TypeSafedWithBody extends DelegateInvocation{
		private Object entity;
		public TypeSafedWithBody(Invocation wrapper, Object entity) {
			super(wrapper);
			this.entity = entity;
		}
		public HttpResponse postChecked() {
			// do everything
			return wrapped.invoke();
		}
	}

	class TypeSafeEntity implements ExtensionFactory<TypeSafedWithBody>{
		private final Object entity;

		public TypeSafeEntity(Object entity) {
			this.entity = entity;
		}

		public TypeSafedWithBody wrap(Invocation invocation) {
			return new TypeSafedWithBody(invocation, entity);
		}
	}

	public TypeSafeEntity entity(Object entity) {
		return new TypeSafeEntity(entity); 
	}

	@Test
	public void shouldBeCapableOfCompileTimeCheckingMissingMethods() {
		String myObject = "something that will be posted. any object as usual.";
		
        Client client = ClientFactory.newClient();
        HttpResponse response = client.request("http://www.google.com/").with(entity(myObject)).postChecked();
        assertEquals(200, response.getStatusCode());
	}


}
