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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.faces.FacesException;
import javax.annotation.Resource;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import org.glassfish.mvc.bookstore.controller.util.JsfUtil;
import org.glassfish.mvc.bookstore.controller.util.PagingInfo;
import org.glassfish.mvc.bookstore.security.AuthenticateUser;

/**
 *
 * @author rohit
 */
public class AuthenticateUserController {

    public AuthenticateUserController() {
        pagingInfo = new PagingInfo();
        converter = new AuthenticateUserConverter();
    }
    private AuthenticateUser authenticateUser = null;
    private List<AuthenticateUser> authenticateUserItems = null;
    private AuthenticateUserFacade jpaController = null;
    private AuthenticateUserConverter converter = null;
    private PagingInfo pagingInfo = null;
    @Resource
    private UserTransaction utx = null;
    @PersistenceUnit(unitName = "org.glassfish.mvc.bookstore_MVCBookStore_war_1.0.0-SNAPSHOTPU")
    private EntityManagerFactory emf = null;

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(getJpaController().count());
        }
        return pagingInfo;
    }

    public AuthenticateUserFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (AuthenticateUserFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "authenticateUserJpa");
        }
        return jpaController;
    }

    public SelectItem[] getAuthenticateUserItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getAuthenticateUserItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public AuthenticateUser getAuthenticateUser() {
        if (authenticateUser == null) {
            authenticateUser = (AuthenticateUser) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentAuthenticateUser", converter, null);
        }
        if (authenticateUser == null) {
            authenticateUser = new AuthenticateUser();
        }
        return authenticateUser;
    }

    public String listSetup() {
        reset(true);
        return "authenticateUser_list";
    }

    public String createSetup() {
        reset(false);
        authenticateUser = new AuthenticateUser();
        return "authenticateUser_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(authenticateUser);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("AuthenticateUser was successfully created.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return listSetup();
    }

    public String detailSetup() {
        return scalarSetup("authenticateUser_detail");
    }

    public String editSetup() {
        return scalarSetup("authenticateUser_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        authenticateUser = (AuthenticateUser) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentAuthenticateUser", converter, null);
        if (authenticateUser == null) {
            String requestAuthenticateUserString = JsfUtil.getRequestParameter("jsfcrud.currentAuthenticateUser");
            JsfUtil.addErrorMessage("The authenticateUser with id " + requestAuthenticateUserString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String authenticateUserString = converter.getAsString(FacesContext.getCurrentInstance(), null, authenticateUser);
        String currentAuthenticateUserString = JsfUtil.getRequestParameter("jsfcrud.currentAuthenticateUser");
        if (authenticateUserString == null || authenticateUserString.length() == 0 || !authenticateUserString.equals(currentAuthenticateUserString)) {
            String outcome = editSetup();
            if ("authenticateUser_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit authenticateUser. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(authenticateUser);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("AuthenticateUser was successfully updated.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return detailSetup();
    }

    public String remove() {
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentAuthenticateUser");
        Long id = new Long(idAsString);
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().remove(getJpaController().find(id));
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("AuthenticateUser was successfully deleted.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return relatedOrListOutcome();
    }

    private String relatedOrListOutcome() {
        String relatedControllerOutcome = relatedControllerOutcome();
       // if ((ERROR)) {
       //     return relatedControllerOutcome;
       // }
        return listSetup();
    }

    public List<AuthenticateUser> getAuthenticateUserItems() {
        if (authenticateUserItems == null) {
            getPagingInfo();
            authenticateUserItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return authenticateUserItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "authenticateUser_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "authenticateUser_list";
    }

    private String relatedControllerOutcome() {
        String relatedControllerString = JsfUtil.getRequestParameter("jsfcrud.relatedController");
        String relatedControllerTypeString = JsfUtil.getRequestParameter("jsfcrud.relatedControllerType");
        if (relatedControllerString != null && relatedControllerTypeString != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Object relatedController = context.getApplication().getELResolver().getValue(context.getELContext(), null, relatedControllerString);
            try {
                Class<?> relatedControllerType = Class.forName(relatedControllerTypeString);
                Method detailSetupMethod = relatedControllerType.getMethod("detailSetup");
                return (String) detailSetupMethod.invoke(relatedController);
            } catch (ClassNotFoundException e) {
                throw new FacesException(e);
            } catch (NoSuchMethodException e) {
                throw new FacesException(e);
            } catch (IllegalAccessException e) {
                throw new FacesException(e);
            } catch (InvocationTargetException e) {
                throw new FacesException(e);
            }
        }
        return null;
    }

    private void reset(boolean resetFirstItem) {
        authenticateUser = null;
        authenticateUserItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        AuthenticateUser newAuthenticateUser = new AuthenticateUser();
        String newAuthenticateUserString = converter.getAsString(FacesContext.getCurrentInstance(), null, newAuthenticateUser);
        String authenticateUserString = converter.getAsString(FacesContext.getCurrentInstance(), null, authenticateUser);
        if (!newAuthenticateUserString.equals(authenticateUserString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
