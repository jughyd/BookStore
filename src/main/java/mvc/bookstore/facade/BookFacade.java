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
package mvc.bookstore.facade;

import mvc.bookstore.controller.vo.AuthorVO;
import mvc.bookstore.controller.vo.BookVO;
import mvc.bookstore.controller.vo.PublisherVO;
import mvc.bookstore.entities.Author;
import mvc.bookstore.entities.Book;
import mvc.bookstore.entities.Publisher;

/**
 *
 * @author rhegde
 */
public class BookFacade extends AbstractFacade<Book, BookVO> {
    
    public BookFacade() {
        super(Book.class);
    }
    
    @Override
    protected BookVO toVO(Book entity) {
        BookVO vo = new BookVO();
        vo.setId(entity.getId());
        vo.setBookName(entity.getBookName());
        vo.setPrice(entity.getPrice());
        vo.setStock(entity.getStock());
        
        Publisher pub = entity.getPublisher();
        PublisherVO pubVo = new PublisherVO();
        
        pubVo.setId(pub.getId());
        pubVo.setName(pub.getName());
        vo.setPublisher(pubVo);
        
        Author author = entity.getAuthor();
        AuthorVO authorVo = new AuthorVO();
        authorVo.setId(author.getId());
        authorVo.setFirstName(author.getFirstName());
        authorVo.setLastName(author.getLastName());
        vo.setAuthor(authorVo);
        
        
        return vo;
    }
    
    //TODO: Map other entities of the Books like toVO method.
    @Override
    protected Book toEntity(BookVO vo) {
        Book entity = new Book();
        entity.setId(vo.getId());
        entity.setBookName(vo.getBookName());
        return entity;
    }
    
}
