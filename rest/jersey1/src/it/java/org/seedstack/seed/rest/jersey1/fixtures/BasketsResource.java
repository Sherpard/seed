/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.seed.rest.jersey1.fixtures;

import org.seedstack.seed.rest.Rel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("baskets")
public class BasketsResource {
    public static final String REL_BASKET = "basket";

    @GET
    @Produces("application/hal+json")
    @Path("/{id}")
    @Rel(REL_BASKET)
    public Response getWarehouse(@PathParam("id") String basketId) {
        return Response.ok().build();
    }
}
