package io.github.hrathod.blog.resteasy;

import java.util.Optional;

/**
 * @author hrathod
 */
public class SimpleDao {
	public Optional<SimpleModel> get (String id) {
		Optional<SimpleModel> model;
		if ("test".equals(id)) {
			model = Optional.of(new SimpleModel("test model"));
		} else {
			model = Optional.empty();
		}
		return model;
	}
}
