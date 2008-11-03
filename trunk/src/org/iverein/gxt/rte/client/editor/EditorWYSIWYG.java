/*
 * Copyright 2006 Pavel Jbanov.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.iverein.gxt.rte.client.editor;

import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.google.gwt.user.client.Element;

public class EditorWYSIWYG extends LayoutContainer {

    private EditorIframe frame;
    private EditorControler controler;

    /**
     * TextArea for html source code editing
     */
    private TextArea textArea;

    protected EditorWYSIWYG(EditorControler controler) {
        this.controler = controler;

        frame = new EditorIframe(controler);
        textArea = new TextArea();
        add(frame);
        setLayout(new FitLayout() );
    }


    /**
     * Sets html to the textarea and the iframe
     *
     * @param html
     */
    protected void setHTML(String html) {
        if(textArea.isAttached()){
            textArea.setValue(html);
        } else {
            frame.setHTML(html);
        }
    }


    /**
     * Fetches html from the iframe and returns it
     *
     * @return
     */
    protected String getHTML() {
        if(textArea.isAttached()){
            return textArea.getValue();
        } else {
            return frame.getHTML();
        } 
    }


    /**
     * Returns the iframe
     *
     * @return
     */
    protected Element getFrameElement() {
        return frame.getElement();
    }

    protected EditorIframe getFrame() {
        return frame;
    }

    /**
     * Switches to design Mode
     * The iframe will be attached and the text area will be detached
     */
    protected void switchToDesignMode() {
        String newHtml = textArea.getValue();
        remove(textArea);
        add(frame);
        layout();
        setHTML(newHtml);
    }


    /**
     * Switches to source code mode
     * The iframe will be detached and the text area will be attached
     */
    protected void switchToSourceMode() {
        textArea.setValue(getHTML());
        remove(frame);
        add(textArea);
        layout();
    }

    /**
     * The edit mode of the iframe has to enabled every time the iframe is rendered.
     */
    @Override
    public boolean layout(){
        boolean result = super.layout();
        if(frame.isAttached()){
            frame.enableDesignMode();
        }
        return result;
    }
}
