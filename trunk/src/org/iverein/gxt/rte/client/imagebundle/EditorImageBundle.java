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

package org.iverein.gxt.rte.client.imagebundle;

import com.google.gwt.user.client.ui.ImageBundle;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

/**
 *
 * This image bundle provides all images for the rich text editor
 *
 * @author: Peter Quiel <peter.quiel@iverein-networks.de>
 * Date: 31.10.2008
 * Time: 15:17:43
 */
public interface EditorImageBundle  extends ImageBundle {

    /**
     * @return button image, switch to html source code
     */
    AbstractImagePrototype html();

    /**
     * @return button image, switch from html sourcde to wysiwig mode
     */
    AbstractImagePrototype page_white_text();

    /**
     * @return button image for the remove formatting button
     */
    AbstractImagePrototype page_white_delete();

    /**
     * @return button image, for text bold button
     */
    AbstractImagePrototype text_bold();


    /**
     * @return button image for the text italic button
     */
    AbstractImagePrototype text_italic();


    /**
     * @return button image for the text underline button
     */
    AbstractImagePrototype text_underline();


    /**
     * @return button image for the text subscript button
     */
    AbstractImagePrototype text_subscript();


    /**
     * @return button image for the text superscript button
     */
    AbstractImagePrototype text_superscript();


    /**
     * @return button imag for the text align left button
     */
    AbstractImagePrototype text_align_left();


    /**
     * @return button image for the text align right button
     */
    AbstractImagePrototype text_align_right();


    /**
     * @return button image for the text align center button
     */
    AbstractImagePrototype text_align_center();


    /**
     * @return button image for the button text justify button
     */
    AbstractImagePrototype text_align_justify();


    /**
     * @return button image for the button list bullets button
     */
    AbstractImagePrototype text_list_bullets ();


    /**
     * @return button image for the button list numbers
     */
    AbstractImagePrototype text_list_numbers();


    /**
     * @return button image for the add link button
     */
    AbstractImagePrototype link();


    /**
     * @return button image for the remove link button
     */
    AbstractImagePrototype link_break();


    /**
     * @TODO: implement the link edit button 
     * @return button image for the edit link button.
     */
    AbstractImagePrototype link_edit();


    /**
     * @return button image for all accept buttons
     */
    AbstractImagePrototype accept();

    /**
     * @return button image for all cancel buttons
     */
    AbstractImagePrototype cancel();


    /**
     * @return h1 image for the select text style list
     */
    AbstractImagePrototype text_heading_1();

    /**
     * @return h1 image for the select text style list
     */
    AbstractImagePrototype text_heading_2();

    /**
     * @return h2 image for the select text style list
     */                                                                      
    AbstractImagePrototype text_heading_3();

    /**
     * @return h3 image for the select text style list
     */
    AbstractImagePrototype text_heading_4();

    /**
     * @return h4 image for the select text style list
     */
    AbstractImagePrototype text_heading_5();

    /**
     * @return h5 image for the select text style list
     */
    AbstractImagePrototype text_heading_6();


    /**
     * @return button image to select background color
     */
    AbstractImagePrototype palette();


    /**
     * @return button image to select foreground image 
     */
    AbstractImagePrototype script_palette();

    /**
     * @return button image to redo
     */
    AbstractImagePrototype arrow_redo();

    /**
     * @return button image to undo
     */
    AbstractImagePrototype arrow_undo();

    /**
     * @return button image to insert an im
     */
    AbstractImagePrototype image_add();


}
