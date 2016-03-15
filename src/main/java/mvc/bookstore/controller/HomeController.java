/*
 * Copyright 2015 Rajmahendra Hegde.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mvc.bookstore.controller;

import javax.mvc.Viewable;
import javax.mvc.annotation.Controller;
import javax.mvc.annotation.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * 
 *
 * @author Rajmahendra Hegde <rajmahendra@gmail.com>
 */
@Controller
@Path("home")
public class HomeController {

    @GET
    public String home() {
        return "index.xhtml";
    }

    @GET
    @Path("aboutus")
    @View("aboutus.xhtml")
    public void aboutus() {
    }

    @GET
    @Path("faq")
    public Response faq() {
        return Response.status(Response.Status.OK).entity("/faq.xhtml").build();
    }

    @GET
    @Path("contactus")
    public Viewable contactus() {
        return new Viewable("contactus.xhtml");
    }

}
