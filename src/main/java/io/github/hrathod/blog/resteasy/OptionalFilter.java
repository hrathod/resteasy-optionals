package io.github.hrathod.blog.resteasy;

import java.io.IOException;
import java.util.Optional;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.annotations.interception.ServerInterceptor;

@Provider
@ServerInterceptor
public class OptionalFilter implements ContainerResponseFilter {
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		Object entity = responseContext.getEntity();
		if (Optional.class.isAssignableFrom(entity.getClass())) {
			Optional<?> optional = (Optional<?>) entity;
			if (optional.isPresent()) {
				responseContext.setEntity(optional.get());
			} else {
				responseContext.setEntity(null);
				responseContext.setStatus(Response.Status.NO_CONTENT.getStatusCode());
			}
		}
	}
}
