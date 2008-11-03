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
import org.iverein.gxt.rte.client.i18n.EditorMessagesAccess;

public abstract class EditorUtilsImpl {
    public abstract void saveSelection(Element oIframe);

    public abstract void restoreSelection(Element oIframe);

    public abstract void enableDesignMode(Element oIframe);

    // Editing stuff

    public abstract void doRemoveFormat(Element oIframe);

    public abstract void doUndo(Element oIframe);

    public abstract void doRedo(Element oIframe);

    public abstract void doBold(Element oIframe);

    public abstract void doItalic(Element oIframe);

    public abstract void doUnderline(Element oIframe);

    public abstract void doSubscript(Element oIframe);

    public abstract void doSuperscript(Element oIframe);

    public abstract void doJustifyLeft(Element oIframe);

    public abstract void doJustifyCenter(Element oIframe);

    public abstract void doJustifyRight(Element oIframe);

    public abstract void doJustifyFull(Element oIframe);

    public abstract void doInsertOrderedList(Element oIframe);

    public abstract void doInsertUnorderedList(Element oIframe);

    public abstract void doUnLink(Element oIframe);

    public abstract void doCreateLink(Element oIframe, String url);

    public abstract void doInsertImage(Element oIframe, String url);

    public abstract void doForeColor(Element oIframe, String color);

    public abstract void doBackgroundColor(Element oIframe, String color);

    public abstract void doFontStyle(Element oIframe, String style);

    public abstract void doFontSize(Element oIframe, String size);


    /**
     * Exec Midas command.
     *
     * @param oIframe target IFrame
     * @param command Midas command
     * @param ui      show browser native UI
     * @param value   command value
     */
    protected static native void execCommand(Element oIframe, String command,
                                             boolean ui, String value) /*-{
      oIframe.contentWindow.document.execCommand(command, ui, value);
    }-*/;


    /**
     * Focus target IFrame.
     *
     * @param oIframe target IFrame.
     */
    public static native void doFocus(Element oIframe) /*-{
      oIframe.contentWindow.focus();
    }-*/;

    /**
     * Blur target IFrame.
     *
     * @param oIframe target IFrame.
     */
    protected static native void doBlur(Element oIframe)/*-{
      if (@com.extjs.gxt.ui.client.GXT::isIE ||
          @com.extjs.gxt.ui.client.GXT::isGecko) {
        oIframe.contentWindow.blur();
      } else {
        oIframe.blur();
      }
    }-*/;


    /**
     * JavaScript parseInt style Integer parser.
     *
     * @param s to-parse string.
     * @return pasrsed integer value
     */
    public static native int parseInt(String s) /*-{
      return parseInt(s);
    }-*/;

    /**
     *
     * @return supported FontStyle values.
     */
    public String[][] getSupportedFormats() {
      return new String[][]{
          {EditorMessagesAccess.getEditorMessages().fontStyleNormal(), "<P>"},
          {EditorMessagesAccess.getEditorMessages().fontStyleHeadingOne(), "<H1>"},
          {EditorMessagesAccess.getEditorMessages().fontStyleHeadingTwo(), "<H2>"},
          {EditorMessagesAccess.getEditorMessages().fontStyleHeadingThree(), "<H3>"},
          {EditorMessagesAccess.getEditorMessages().fontStyleHeadingFour(), "<H4>"},
          {EditorMessagesAccess.getEditorMessages().fontStyleHeadingFive(), "<H5>"},
          {EditorMessagesAccess.getEditorMessages().fontStyleHeadingSix(), "<H6>"},
          {EditorMessagesAccess.getEditorMessages().fontStylePre(), "<PRE>"}
        };
    }
}