package javax.ws.rs.client;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.HttpResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.UriBuilder;

public class DelegateInvocation implements Invocation {

	public HttpResponse invoke() throws InvocationException {
		return wrapped.invoke();
	}

	public <T> T invoke(Class<T> responseType) throws InvocationException {
		return wrapped.invoke(responseType);
	}

	public <T> T invoke(GenericType<T> responseType) throws InvocationException {
		return wrapped.invoke(responseType);
	}

	public Future<HttpResponse> queue() {
		return wrapped.queue();
	}

	public <T> Future<T> queue(Class<T> responseType) {
		return wrapped.queue(responseType);
	}

	public <T> Future<T> queue(GenericType<T> responseType) {
		return wrapped.queue(responseType);
	}

	public <T> Future<T> queue(InvocationCallback<T> callback) {
		return wrapped.queue(callback);
	}

	public Map<String, Object> getProperties() {
		return wrapped.getProperties();
	}

	public List<String> getHeader(String name) {
		return wrapped.getHeader(name);
	}

	public URI getBaseUri() {
		return wrapped.getBaseUri();
	}

	public UriBuilder getBaseUriBuilder() {
		return wrapped.getBaseUriBuilder();
	}

	public Object getProperty(String name) {
		return wrapped.getProperty(name);
	}

	public MultivaluedMap<String, Object> getHeaders() {
		return wrapped.getHeaders();
	}

	public URI getUri() {
		return wrapped.getUri();
	}

	public Set<String> getFeatures() {
		return wrapped.getFeatures();
	}

	public UriBuilder getUriAsBuilder() {
		return wrapped.getUriAsBuilder();
	}

	public List<MediaType> getAcceptableMediaTypes() {
		return wrapped.getAcceptableMediaTypes();
	}

	public URI getAbsolutePath() {
		return wrapped.getAbsolutePath();
	}

	public boolean isEnabled(String featureName) {
		return wrapped.isEnabled(featureName);
	}

	public List<Locale> getAcceptableLanguages() {
		return wrapped.getAcceptableLanguages();
	}

	public UriBuilder getAbsolutePathBuilder() {
		return wrapped.getAbsolutePathBuilder();
	}

	public Set<Class<?>> getProviderClasses() {
		return wrapped.getProviderClasses();
	}

	public MediaType getMediaType() {
		return wrapped.getMediaType();
	}

	public String getPath() {
		return wrapped.getPath();
	}

	public Locale getLanguage() {
		return wrapped.getLanguage();
	}

	public String getPath(boolean decode) {
		return wrapped.getPath(decode);
	}

	public Set<Object> getProviderSingletons() {
		return wrapped.getProviderSingletons();
	}

	public Map<String, Cookie> getCookies() {
		return wrapped.getCookies();
	}

	public List<PathSegment> getPathSegments() {
		return wrapped.getPathSegments();
	}

	public Invocation register(Class<?> providerClass) {
		return wrapped.register(providerClass);
	}

	public List<PathSegment> getPathSegments(boolean decode) {
		return wrapped.getPathSegments(decode);
	}

	public Invocation register(Object provider) {
		return wrapped.register(provider);
	}

	public MultivaluedMap<String, String> getQueryParameters() {
		return wrapped.getQueryParameters();
	}

	public Invocation property(String name, Object value) {
		return wrapped.property(name, value);
	}

	public MultivaluedMap<String, String> getQueryParameters(boolean decode) {
		return wrapped.getQueryParameters(decode);
	}

	public Invocation enable(String featureName) {
		return wrapped.enable(featureName);
	}

	public Invocation disable(String featureName) {
		return wrapped.disable(featureName);
	}

	public String getHeaderValue(String name) {
		return wrapped.getHeaderValue(name);
	}

	public Invocation properties(Map<String, Object> properties) {
		return wrapped.properties(properties);
	}

	public MultivaluedMap<String, String> getCookieNameValueMap() {
		return wrapped.getCookieNameValueMap();
	}

	public Object getEntity() {
		return wrapped.getEntity();
	}

	public <T> T getEntity(Class<T> type) throws WebApplicationException {
		return wrapped.getEntity(type);
	}

	public <T> T getEntity(Class<T> type, Type genericType,
			Annotation[] annotations) throws WebApplicationException {
		return wrapped.getEntity(type, genericType, annotations);
	}

	public String getMethod() {
		return wrapped.getMethod();
	}

	public List<String> getRequestHeader(String name) {
		return wrapped.getRequestHeader(name);
	}

	public MultivaluedMap<String, String> getRequestHeaders() {
		return wrapped.getRequestHeaders();
	}

	public Invocation pathParam(String name, Object value)
			throws IllegalArgumentException {
		return wrapped.pathParam(name, value);
	}

	public Invocation pathParams(MultivaluedMap<String, Object> parameters)
			throws IllegalArgumentException {
		return wrapped.pathParams(parameters);
	}

	public Invocation formParam(String name, Object value)
			throws IllegalArgumentException {
		return wrapped.formParam(name, value);
	}

	public Invocation formParams(MultivaluedMap<String, Object> parameters)
			throws IllegalArgumentException {
		return wrapped.formParams(parameters);
	}

	public Invocation matrixParam(String name, Object... values)
			throws IllegalArgumentException {
		return wrapped.matrixParam(name, values);
	}

	public Invocation queryParam(String name, Object value)
			throws IllegalArgumentException {
		return wrapped.queryParam(name, value);
	}

	public Invocation queryParams(MultivaluedMap<String, Object> parameters)
			throws IllegalArgumentException {
		return wrapped.queryParams(parameters);
	}

	public Invocation redirect(String uri) {
		return wrapped.redirect(uri);
	}

	public Invocation redirect(URI uri) {
		return wrapped.redirect(uri);
	}

	public Invocation redirect(UriBuilder uri) {
		return wrapped.redirect(uri);
	}

	public Invocation accept(MediaType... types) {
		return wrapped.accept(types);
	}

	public Invocation accept(String... types) {
		return wrapped.accept(types);
	}

	public Invocation acceptLanguage(Locale... locales) {
		return wrapped.acceptLanguage(locales);
	}

	public Invocation acceptLanguage(String... locales) {
		return wrapped.acceptLanguage(locales);
	}

	public Invocation cookie(Cookie cookie) {
		return wrapped.cookie(cookie);
	}

	public Invocation entity(Object entity) {
		return wrapped.entity(entity);
	}

	public Invocation entity(Object entity, MediaType type) {
		return wrapped.entity(entity, type);
	}

	public Invocation entity(Object entity, String type) {
		return wrapped.entity(entity, type);
	}

	public Invocation header(String name, Object value) {
		return wrapped.header(name, value);
	}

	public Invocation method(String httpMethod) {
		return wrapped.method(httpMethod);
	}

	protected final Invocation wrapped;

	public DelegateInvocation(Invocation wrapper) {
		this.wrapped = wrapper;
	}

}
