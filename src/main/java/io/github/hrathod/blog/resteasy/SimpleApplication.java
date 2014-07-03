package io.github.hrathod.blog.resteasy;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class SimpleApplication extends Application {

	private final Set<Object> singletons = new HashSet<>();

	public SimpleApplication () {
		this.singletons.add(new SimpleResource());
		this.singletons.add(new OptionalFilter());
	}

	@Override
	public Set<Object> getSingletons() {
		return this.singletons;
	}
}
