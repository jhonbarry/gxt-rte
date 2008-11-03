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

import org.iverein.gxt.rte.client.editor.EditorControler;
import org.iverein.gxt.rte.client.widget.toolbar.EditorCommand;
import org.iverein.gxt.rte.client.widget.toolbar.SimpleComandComboBox;
import org.iverein.gxt.rte.client.widget.toolbar.SimpleComboBoxModel;

import java.util.ArrayList;


/**
 *
 * @author: Peter Quiel <peter.quiel@iverein-networks.de>
 * Date: 31.10.2008
 * Time: 15:14:57
 */


public class FontStyleButton extends SimpleComandComboBox {


    EditorControler controler;


    public FontStyleButton(EditorControler c) {
        this.controler = c;
        String[][] formats = controler.getSupportedFormats();
        ArrayList<SimpleComboBoxModel> list = new ArrayList<SimpleComboBoxModel>();
        setWidth(100);
        for (int i = 0; i < formats.length; i++) {
          list.add (new SimpleComboBoxModel(formats[i][1], formats[i][0]));
        }
        setModel(list);
        setEditorCommand( new EditorCommand(){
            public void exec(String[] params) {
                controler.doFocus();
                controler.doFontStyle(params[0]);
            }
        });
    }
}
