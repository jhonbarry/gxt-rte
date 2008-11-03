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

package org.iverein.gxt.rte.client.widget.toolbar.item;

import com.extjs.gxt.ui.client.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.BaseEvent;
import org.iverein.gxt.rte.client.editor.EditorControler;
import org.iverein.gxt.rte.client.widget.toolbar.EditorCommand;
import org.iverein.gxt.rte.client.widget.toolbar.SimpleComandPromptBox;
import org.iverein.gxt.rte.client.widget.ImageBundleButton;
import org.iverein.gxt.rte.client.i18n.EditorMessagesAccess;
import org.iverein.gxt.rte.client.imagebundle.EditorImageBundleAccess;


/**
 *
 * @author: Peter Quiel <peter.quiel@iverein-networks.de>
 * Date: 31.10.2008
 * Time: 15:14:57
 */
public class LinkButton extends ImageBundleButton implements Listener {


    private EditorControler controler;

    public LinkButton(EditorControler controler) {
        this.controler = controler;
        setImagePrototype(EditorImageBundleAccess.getEditorImageBundle().link());
        addListener(Events.Select, this);
    }

    public void handleEvent(BaseEvent event) {
        controler.saveSelection();
        new SimpleComandPromptBox(controler, new EditorCommand() {
            public void exec(String[] params) {
                controler.restoreSelection();
                controler.doCreateLink(params[0]);
            }
        }, EditorMessagesAccess.getEditorMessages().createLinkTitle(), EditorMessagesAccess.getEditorMessages().createLinkFieldDescription(), EditorMessagesAccess.getEditorMessages().createLinkButtonTitle()).show();
    }
}
