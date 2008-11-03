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

import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.Events;
import org.iverein.gxt.rte.client.editor.EditorControler;
import org.iverein.gxt.rte.client.i18n.EditorMessagesAccess;
import org.iverein.gxt.rte.client.widget.ImageBundleButton;
import org.iverein.gxt.rte.client.imagebundle.EditorImageBundleAccess;


/**
 *
 * @author: Peter Quiel <peter.quiel@iverein-networks.de>
 * Date: 31.10.2008
 * Time: 15:14:57
 */

public class ForegroundColorButton extends ImageBundleButton implements Listener {

    private EditorControler controler;
    private ColourPickerDialog fgPicker;

    public ForegroundColorButton(EditorControler c) {
        this.controler = c;
        setImagePrototype(EditorImageBundleAccess.getEditorImageBundle().palette());

        this.fgPicker = new ColourPickerDialog();
        this.fgPicker.cancelText = EditorMessagesAccess.getEditorMessages().cancel();
        this.fgPicker.okText = EditorMessagesAccess.getEditorMessages().ok();
        this.fgPicker.setHeading(EditorMessagesAccess.getEditorMessages().foregroundTitle());
        this.fgPicker.addColourSelectedListener( new Listener (){

            public void handleEvent(BaseEvent event) {
                String rgb = fgPicker.getColour();
                controler.restoreSelection();
                controler.doForeColor(rgb);
                controler.doFocus();
            }
        });
        addListener(Events.Select,  this);
    }

    public void handleEvent(BaseEvent event) {
        controler.saveSelection();
        fgPicker.show();
    }
}
