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

import net.auroris.ColorPicker.client.ColorPicker;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.Events;

/**
 * This Dialog uses the color picker from auroris to select a colour.
 *
 * <p>
 * Demo:
 * @link http://www.auroris.net/gwt/colorpicker/
 * </p>
 *
 * <p>
 * Documentation:
 * @link http://code.google.com/p/auroris/wiki/ColorPicker
 * </p>
 * User: Peter Quiel <peter.quiel@iverein-networks.de>
 * Date: 30.10.2008
 * Time: 13:05:13
 */
public class ColourPickerDialog extends Dialog {

    ColorPicker colourPicker;

    Listener listener;

    public ColourPickerDialog(){
        super();
        this.colourPicker = new ColorPicker();
        this.setLayout(new FitLayout() );
        this.add(colourPicker);
        this.setButtons(OKCANCEL);
        this.setHideOnButtonClick(true);
        this.setWidth(420);
    }

    /**
     * Returns the selected colour as hex value
     *
     * @return color as hex 000000-FFFFFF
     */
    public String getColour(){
        return this.colourPicker.getHexColor();
    }

    /**
     * @param hex from 000000-FFFFFF
     */
    public void setColor(String hex){
        try {
            this.colourPicker.setHex(hex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addColourSelectedListener(Listener listener){
        this.getButtonBar().getButtonById("ok").addListener(Events.Select, listener);
    }
}

