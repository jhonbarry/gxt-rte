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

package org.iverein.gxt.rte.client.editor.browserdep;


import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Timer;

public abstract class EditorUtilsImplCommon extends EditorUtilsImpl {


    public void enableDesignMode(final Element oIframe) {
        _enableDesignMode(oIframe);
    }

    private native void _enableDesignMode(Element oIframe) /*-{
        var oDoc = oIframe.contentWindow || oIframe.contentDocument;
        if (!oDoc) {
          $wnd.alert("bug _enableDesignMode");
        }
        if (oDoc.document) {
          oDoc = oDoc.document;
        }
        oDoc.designMode = 'On';
   }-*/;

    public void doRemoveFormat(Element oIframe) {
        execCommand(oIframe, "RemoveFormat", false, null);
    }

    public void doUndo(Element oIframe) {
        execCommand(oIframe, "Undo", false, null);
    }

    public void doRedo(Element oIframe) {
        execCommand(oIframe, "Redo", false, null);
    }

    public void doBold(Element oIframe) {
        execCommand(oIframe, "Bold", false, null);
    }

    public void doItalic(Element oIframe) {
        execCommand(oIframe, "Italic", false, null);
    }

    public void doUnderline(Element oIframe) {
        execCommand(oIframe, "Underline", false, null);
    }

    public void doSubscript(Element oIframe) {
        execCommand(oIframe, "Subscript", false, null);
    }

    public void doSuperscript(Element oIframe) {
        execCommand(oIframe, "Superscript", false, null);
    }

    public void doJustifyLeft(Element oIframe) {
        execCommand(oIframe, "JustifyLeft", false, null);
    }

    public void doJustifyRight(Element oIframe) {
        execCommand(oIframe, "JustifyRight", false, null);
    }

    public void doJustifyCenter(Element oIframe) {
        execCommand(oIframe, "JustifyCenter", false, null);
    }

    public void doJustifyFull(Element oIframe) {
        execCommand(oIframe, "JustifyFull", false, null);
    }

    public void doInsertOrderedList(Element oIframe) {
        execCommand(oIframe, "InsertOrderedList", false, null);
    }

    public void doInsertUnorderedList(Element oIframe) {
        execCommand(oIframe, "InsertUnorderedList", false, null);
    }

    public void doUnLink(Element oIframe) {
        execCommand(oIframe, "UnLink", false, null);
    }


    public void doCreateLink(Element oIframe, String url) {
        restoreSelection(oIframe);
        execCommand(oIframe, "CreateLink", false, url);
    }

    public void doInsertImage(Element oIframe, String url) {
        restoreSelection(oIframe);
        execCommand(oIframe, "InsertImage", false, url);
    }

    public void doForeColor(Element oIframe, String color) {
        execCommand(oIframe, "ForeColor", false, color);
    }

    /**
     * overridden by IE impl
     */
    public void doBackgroundColor(Element oIframe, String color) {
        execCommand(oIframe, "hilitecolor", false, color);
    }

    public void doFontSize(Element oIframe, String size) {
        restoreSelection(oIframe);
        execCommand(oIframe, "FontSize", false, size);
    }

    public void doFontStyle(Element oIframe, String style) {
        restoreSelection(oIframe);
        execCommand(oIframe, "FormatBlock", false, style);
    }
}
