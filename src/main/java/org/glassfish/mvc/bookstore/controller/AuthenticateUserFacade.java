/*
 * Copyright 2016 rohit.
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
package org.glassfish.mvc.bookstore.controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.glassfish.mvc.bookstore.security.AuthenticateUser;

/**
 *
 * @author rohit
 */
@Stateless
public class AuthenticateUserFacade extends AbstractFacade<AuthenticateUser> {

    @PersistenceContext(unitName = "org.glassfish.mvc.bookstore_MVCBookStore_war_1.0.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuthenticateUserFacade() {
        super(AuthenticateUser.class);
    }
    
}
