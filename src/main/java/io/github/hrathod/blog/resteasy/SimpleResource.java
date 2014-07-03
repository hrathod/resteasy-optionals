package io.github.hrathod.blog.resteasy;

import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/simple")
public class SimpleResource {

	private final SimpleDao dao = new SimpleDao();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{id}")
	public Optional<SimpleModel> get (@PathParam("id") String id) {
		return this.dao.get(id);
	}

}
