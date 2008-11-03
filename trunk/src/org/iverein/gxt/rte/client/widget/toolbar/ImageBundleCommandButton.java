/**
 * Copyright 2008 Peter Quiel.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied.
 *
 * See the License for the specific language governing permissions and limitations under the License.
 *
 */

package org.iverein.gxt.rte.client.widget.toolbar;

import org.iverein.gxt.rte.client.widget.ImageBundleButton;
import org.iverein.gxt.rte.client.widget.toolbar.EditorCommand;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.extjs.gxt.ui.client.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.BaseEvent;

/**
 * 
 *
 * @author: Peter Quiel <peter.quiel@iverein-networks.de>
 * Date: 31.10.2008
 * Time: 17:25:30
 */
public class ImageBundleCommandButton extends ImageBundleButton {

    
    public ImageBundleCommandButton(AbstractImagePrototype imagePrototype, final EditorCommand command) {
        super(imagePrototype);
        this.addListener(Events.Select, new Listener(){

            public void handleEvent(BaseEvent event) {
                command.exec(null);
            }
        });
    }
}
