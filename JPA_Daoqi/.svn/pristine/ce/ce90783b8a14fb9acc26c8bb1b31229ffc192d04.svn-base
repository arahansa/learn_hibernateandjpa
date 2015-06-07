package jpatest.util;

/**
 * This class stores some context information in the current request thread.
 * It may be initialized by a Servlet filter in a web container or 
 * an EJB interceptor in an EJB container. Make sure to pass the user name to
 * the initRequestContext() method.
 */
public class RequestContext {

	// user name associated with the current request.
	private String userName;
	
	// A Thread Local instance to store the request context 
	private static ThreadLocalton localton = new ThreadLocalton();

    // Inner class storing thread local copy of request context.
	private static class ThreadLocalton extends ThreadLocal<Object> {
		protected synchronized Object initialValue() {
			RequestContext context = new RequestContext();
			return context;
		}
	}

	private RequestContext() {
	}

	/**
	 * Returns the instance associated with the current thread. The instance
	 * should have been initialized by calling the method initRequestContext().
	 */
	public static RequestContext getLocalInstance() {
		RequestContext context = (RequestContext) localton.get();
		return context;
	}

	/**
	 * Initialize the request context with user name. This method may be called
	 * by a Servlet filter or an EJB interceptor.
	 */
	public void initRequestContext(String userName) {
		this.userName = userName;
	}

	/**
	 * Clears all request context info. Must be called at end of request
	 * processing to guarantee information is not shared between requests.
	 */
	public void clearRequestContext() {
		this.userName = null;
	}

	public String getUserName() {
		return this.userName;
	}
}