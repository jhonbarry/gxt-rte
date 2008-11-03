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

import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.Timer;
import org.iverein.gxt.rte.client.widget.toolbar.EditorToolBar;

/**
 * Rich Text Editor Widget.
 *
 * @author pavel.jbanov
 * @autor peter.quiel
 */
public class RteEditor extends ContentPanel {

    private EditorWYSIWYG wysiwyg;
    private EditorControler controler;

    // internal status
    private boolean initialized = false;

    private EditorToolBar editorToolBar;

    /**
     * This temp storage is used to store html if the editor has not been initilized
     */
    private String tmpHTMLStorage = null;

    private boolean inDesignMode = true;



    public RteEditor() {
        controler = new EditorControler(this);
        wysiwyg = new EditorWYSIWYG(controler);
        setLayout(new FitLayout());
        add(wysiwyg);
    }


    /**
     * @return HTML
     */
    public String getHTML() {
        return getEditorWYSIWYG().getHTML();
    }


    /**
     * set editor HTML.
     *
     * @param html HTML
     */
    public void setHTML(String html) {
        getEditorWYSIWYG().setHTML(html);
    }


    /**
     * Returns the current @see EditorToolBar
     * @return
     */
    public EditorToolBar getEditorToolBar() {
        return editorToolBar;
    }

    /**
     * Sets the editor tool bar
     * @param editorToolBar
     */
    public void setEditorToolBar(EditorToolBar editorToolBar) {
        this.editorToolBar = editorToolBar;
        this.setTopComponent(this.editorToolBar);
    }

    /**
     * Retruns the controller of this editor.
     *
     * @return
     */
    public EditorControler getController() {
        return controler;
    }


    /**
     * Toggles the view between source mode and wysiwig mode
     */
    protected void toggleView() {
        if (!this.inDesignMode) {
            this.switchToDesignMode();
        } else {
            this.switchToSourceMode();
        }
    }

    /**
     * Changes the mode of the edtor from source code mode to design mode / wysiwig mode
     */
    protected void switchToDesignMode() {
        if (!this.inDesignMode) {
            editorToolBar.switchToDesignMode();
            wysiwyg.switchToDesignMode();
            this.inDesignMode = true;
        }
    }


    /**
     * Changes the mode of the editor from desgin mode / wysiwig mode to source code mode.
     */
    protected void switchToSourceMode() {
        if (this.inDesignMode) {
            editorToolBar.switchToSourceMode();
            wysiwyg.switchToSourceMode();
            this.inDesignMode = false;
        }
    }

    /**
     * @return editor WYSIWYG widget
     */
    protected EditorWYSIWYG getEditorWYSIWYG() {
        return wysiwyg;
    }

}
