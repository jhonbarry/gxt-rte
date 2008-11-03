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

package org.iverein.gxt.rte.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.Timer;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.Events;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Listener;
import org.iverein.gxt.rte.client.editor.RteEditorFactory;
import org.iverein.gxt.rte.client.editor.RteEditor;

/**
 * Example to demonstrate the rich text editor.
 *
 * @author: Peter Quiel <peter.quiel@iverein-networks.de>
 * Date: 30.10.2008
 * Time: 13:14:27
 */
public class GxtRteExample implements EntryPoint {


    private static final String content = "<table class=\"columns\" style=\"clear: left;\">\n" +
            "  <tbody>\n" +
            "    <tr>\n" +
            "      <td>\n" +
            "        <a href=\"overview.html\">\n" +
            "          <img src=\"http://code.google.com/webtoolkit/images/learnmore.gif\" style=\"float: left; margin-left: 50px; border: 0;\" height=\"48\" width=\"48\" />\n" +
            "        </a>\n" +
            "\n" +
            "        <div style=\"margin-left: 112px; margin-bottom: 10px;\">\n" +
            "          <div style=\"margin-top: 15px; font-size: 120%; font-weight: bold;\"><a href=\"overview.html\">Learn More</a></div>\n" +
            "          <div style=\"padding-top: 5px; line-height: 125%;\">\n" +
            "            Learn how Google Web Toolkit works, the features it offers, and how you can quickly develop performance AJAX applications across all major browsers.\n" +
            "          </div>\n" +
            "        </div>\n" +
            "      </td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "\n" +
            "      <td>\n" +
            "        <a href=\"gettingstarted.html\">\n" +
            "          <img src=\"http://code.google.com/webtoolkit/images/getstarted.gif\" style=\"float: left; margin-left: 50px; padding-top: 8px; border: 0;\" height=\"48\" width=\"48\" />\n" +
            "        </a>\n" +
            "        <div style=\"margin-left: 112px; margin-bottom: 10px;\">\n" +
            "          <div style=\"margin-top: 15px; font-size: 120%; font-weight: bold;\"><a href=\"gettingstarted.html\">Get Started</a></div>\n" +
            "          <div style=\"padding-top: 5px; line-height: 125%;\">\n" +
            "            Get started using Google Web Toolkit. Walk through the installation and first steps needed to get a GWT application up and running. From there, work through the fundamentals of GWT development with an in-depth GWT tutorial.\n" +
            "          </div>\n" +
            "\n" +
            "        </div>\n" +
            "      </td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "      <td>\n" +
            "        <a href=\"/docreader/#p=google-web-toolkit-doc-1-5\">\n" +
            "          <img src=\"http://code.google.com/webtoolkit/images/docs.gif\" style=\"float: left; margin-left: 50px; border: 0\" height=\"48\" width=\"48\" />\n" +
            "        </a>\n" +
            "        <div style=\"margin-left: 112px;\">\n" +
            "\n" +
            "          <div style=\"margin-top: 15px; font-size: 120%; font-weight: bold;\"><a href=\"/docreader/#p=google-web-toolkit-doc-1-5\">Read the Docs</a></div>\n" +
            "          <div style=\"padding-top: 5px; line-height: 125%;\">\n" +
            "            Everything you need to know about how to use Google Web Toolkit. \n" +
            "          </div>\n" +
            "        </div>\n" +
            "      </td>\n" +
            "    </tr>\n" +
            "     <tr>\n" +
            "      <td>\n" +
            "\n" +
            "        <a href=\"makinggwtbetter.html\">\n" +
            "          <img src=\"http://code.google.com/webtoolkit/images/community.gif\" style=\"float: left; margin-left: 50px; border: 0\" height=\"48\" width=\"48\" />\n" +
            "        </a>\n" +
            "        <div style=\"margin-left: 112px;\">\n" +
            "          <div style=\"margin-top: 15px; font-size: 120%; font-weight: bold;\">\n" +
            "            <a href=\"makinggwtbetter.html\">Join the Community</a>\n" +
            "          </div>\n" +
            "          <div style=\"padding-top: 5px; line-height: 125%;\">\n" +
            "\n" +
            "           Google Web Toolkit is an open source project with an active community building additional libraries and tools. Join the <a href=\"http://groups.google.com/group/Google-Web-Toolkit\">GWT developer forum</a> to find out what people are up to. If you're interested in building from source, or contributing ideas or modifications to the project, check out the <a href=\"makinggwtbetter.html\">contributors guide</a>.\n" +
            "          </div>\n" +
            "        </div>\n" +
            "      </td>\n" +
            "    </tr>\n" +
            "  </tbody>\n" +
            "</table>\n" +
            "";

    
    public void onModuleLoad() {

        TabPanel folder = new TabPanel();
        folder.setWidth(750);
        folder.setAutoHeight(true);


        final RteEditor emptyEditor = RteEditorFactory.instance().createDefault();
        emptyEditor.setWidth(750);
        emptyEditor.setHeight(500);
        TabItem rteTab = new TabItem("Empty Editor");
        rteTab.add(emptyEditor);
        folder.add(rteTab);

        final TabItem previewTab = new TabItem("First Preview Tab");
        previewTab.addListener(Events.Select, new Listener<ComponentEvent>() {
            public void handleEvent(ComponentEvent be) {
                previewTab.removeAll();
                previewTab.addText(emptyEditor.getHTML());
                previewTab.layout();
            }
        });
        folder.add(previewTab);


        final RteEditor prefilledEditor = RteEditorFactory.instance().createDefault();
        prefilledEditor.setWidth(750);
        prefilledEditor.setHeight(500);
        prefilledEditor.setHTML(content);
        TabItem prefilledRteTab = new TabItem("Test Content Editor");
        prefilledRteTab.add(prefilledEditor);
        folder.add(prefilledRteTab);

        final TabItem prefilledPreviewTab = new TabItem("Second Preview Tab");
        prefilledPreviewTab.addListener(Events.Select, new Listener<ComponentEvent>() {
            public void handleEvent(ComponentEvent be) {
                prefilledPreviewTab.removeAll();
                prefilledPreviewTab.addText(prefilledEditor.getHTML());
                prefilledPreviewTab.layout();
            }
        });
        folder.add(prefilledPreviewTab);
        RootPanel.get("editorSlot").add(folder);
    }
}
