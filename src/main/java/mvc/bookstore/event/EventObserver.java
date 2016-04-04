/*
 * Copyright 2016 Rajmahendra Hegde <rajmahendra@gmail.com>.
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
package mvc.bookstore.event;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.mvc.event.AfterControllerEvent;
import javax.mvc.event.AfterProcessViewEvent;
import javax.mvc.event.BeforeControllerEvent;
import javax.mvc.event.BeforeProcessViewEvent;
import javax.mvc.event.ControllerRedirectEvent;

/**
 *
 * @author Rajmahendra Hegde <rajmahendra@gmail.com>
 */

@ApplicationScoped
public class EventObserver {
    
    private void printMessage(String message) {
        System.out.println("EVENT TRIGGER : " + message);
    }
    

    public void beforeControllerEvent(@Observes BeforeControllerEvent event) {
      printMessage("beforeControllerEvent - " + event.getUriInfo().getPath());
    }

    public void afterControllerEvent(@Observes AfterControllerEvent event) {
       printMessage("afterControllerEvent - " + event.getUriInfo().getPath());
    }

    public void beforeProcessViewEvent(@Observes BeforeProcessViewEvent event) {
        printMessage("beforeProcessViewEvent - " + event.getView() + " " + event.getEngine().getName());
    }

    public void afterProcessViewEvent(@Observes AfterProcessViewEvent event) {
        printMessage("afterProcessViewEvent - " + event.getView() + " " + event.getEngine().getName());
    }
    
    public void controllerRedirectEvent(@Observes ControllerRedirectEvent event) {
        printMessage("controllerRedirectEvent - " + event.getLocation());
    }
    
}
