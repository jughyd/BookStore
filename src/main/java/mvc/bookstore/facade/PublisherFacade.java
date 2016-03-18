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
import mvc.bookstore.controller.vo.PublisherVO;
import mvc.bookstore.entities.Publisher;

/**
 *
 * @author rhegde
 */
public class PublisherFacade extends AbstractFacade<Publisher,PublisherVO> {

    public PublisherFacade() {
        super(Publisher.class);
    }

    @Override
    protected PublisherVO toVO(Publisher entity) {
        PublisherVO vo = new PublisherVO();
        vo.setId(entity.getId());
        vo.setName(entity.getName());
        return vo;
    }

    @Override
    protected Publisher toEntity(PublisherVO vo) {
         Publisher entity = new Publisher();
        entity.setId(vo.getId());
        entity.setName(vo.getName());
        return entity;
    }

   

}
