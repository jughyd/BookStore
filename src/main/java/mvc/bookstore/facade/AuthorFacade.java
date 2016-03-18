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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mvc.bookstore.controller.vo.AuthorVO;
import mvc.bookstore.entities.Author;

/**
 *
 * @author rhegde
 */
public class AuthorFacade extends AbstractFacade<Author, AuthorVO> {


    public AuthorFacade() {
        super(Author.class);
    }

    @Override
    protected AuthorVO toVO(Author entity) {
        AuthorVO vo = new AuthorVO();
        vo.setId(entity.getId());
        vo.setFirstName(entity.getFirstName());
        vo.setLastName(entity.getLastName());
        return vo;
    } 

    @Override
    protected Author toEntity(AuthorVO vo) {
        Author entity = new Author();
        entity.setId(vo.getId());
        entity.setFirstName(vo.getFirstName());
        entity.setLastName(vo.getLastName());
        return entity;
    }

}
