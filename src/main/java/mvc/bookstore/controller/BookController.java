/*
 * Copyright 2016 rhegde.
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

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.mvc.annotation.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import mvc.bookstore.entities.Book;
import mvc.bookstore.facade.BookFacade;

/**
 *
 * @author rhegde
 */
@Controller
@Path("book")
public class BookController {
    
    @Inject
    BookFacade bFacade;
    
    @Inject
    Models model;
    
     @GET
     @View("book/index.xhtml")
    public void index() {
       List<Book> list =  bFacade.retrieveAll();
       System.out.println("BOOKS = " + list.size());
       model.put("books", list);
    }
    
}
