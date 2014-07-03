package io.github.hrathod.blog.resteasy;

public class SimpleModel {
	private final String data;

	SimpleModel(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return this.data;
	}
}
