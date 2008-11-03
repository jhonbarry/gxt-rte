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


package org.iverein.gxt.rte.client.editor;

import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import org.iverein.gxt.rte.client.widget.toolbar.EditorToolBar;
import org.iverein.gxt.rte.client.widget.toolbar.EditorToolbarWidgetsFactory;
import org.iverein.gxt.rte.client.editor.RteEditor;

/**
 *
 *
 *
 * @author: Peter Quiel <peter.quiel@iverein-networks.de>
 * Date: 20.08.2008
 * Time: 19:57:23
 */
public class RteEditorFactory {

    private static RteEditorFactory instance;

    public static RteEditorFactory instance(){
        if(instance == null){
            instance = new RteEditorFactory();
        }
        return instance;
    }

    private RteEditorFactory(){}

    public RteEditor createDefault(){
        RteEditor rteEditor = new RteEditor();
        rteEditor.setEditorToolBar( createDefaultToolBar(rteEditor) );
        rteEditor.setHeaderVisible(false);
        rteEditor.setLayout(new FitLayout());
        return rteEditor;
    }


    public EditorToolBar createDefaultToolBar(RteEditor rteEditor) {

        EditorToolbarWidgetsFactory toolbarWidgetsFactory = new EditorToolbarWidgetsFactory(rteEditor.getController());
        EditorToolBar editorToolBar = new EditorToolBar();

        editorToolBar.addWidget(toolbarWidgetsFactory.getShowSourceWidget(), EditorToolBar.WidgetPostion.DesignModeFirstRow);

        editorToolBar.addSeparator( EditorToolBar.WidgetPostion.DesignModeFirstRow);

        editorToolBar.addWidget(toolbarWidgetsFactory.getRemoveFormattingWidget(), EditorToolBar.WidgetPostion.DesignModeFirstRow);

        editorToolBar.addSeparator( EditorToolBar.WidgetPostion.DesignModeFirstRow);

        editorToolBar.addWidget(toolbarWidgetsFactory.getUndoWidget(), EditorToolBar.WidgetPostion.DesignModeFirstRow);
        editorToolBar.addWidget(toolbarWidgetsFactory.getRedoWidget(), EditorToolBar.WidgetPostion.DesignModeFirstRow);

        editorToolBar.addSeparator( EditorToolBar.WidgetPostion.DesignModeFirstRow);

        editorToolBar.addWidget(toolbarWidgetsFactory.getBoldWidget(), EditorToolBar.WidgetPostion.DesignModeFirstRow);
        editorToolBar.addWidget(toolbarWidgetsFactory.getItalicWidget(), EditorToolBar.WidgetPostion.DesignModeFirstRow);
        editorToolBar.addWidget(toolbarWidgetsFactory.getUnderlineWidget(), EditorToolBar.WidgetPostion.DesignModeFirstRow);

        editorToolBar.addSeparator( EditorToolBar.WidgetPostion.DesignModeFirstRow);

        editorToolBar.addWidget(toolbarWidgetsFactory.getSubscriptWidget(), EditorToolBar.WidgetPostion.DesignModeFirstRow);
        editorToolBar.addWidget(toolbarWidgetsFactory.getSuperscriptWidget(), EditorToolBar.WidgetPostion.DesignModeFirstRow);

        editorToolBar.addSeparator( EditorToolBar.WidgetPostion.DesignModeFirstRow);

        editorToolBar.addWidget(toolbarWidgetsFactory.getJustifyLeftWidget(), EditorToolBar.WidgetPostion.DesignModeFirstRow);
        editorToolBar.addWidget(toolbarWidgetsFactory.getJustifyCenterWidget(), EditorToolBar.WidgetPostion.DesignModeFirstRow);
        editorToolBar.addWidget(toolbarWidgetsFactory.getJustifyRightWidget(), EditorToolBar.WidgetPostion.DesignModeFirstRow);
        editorToolBar.addWidget(toolbarWidgetsFactory.getJustifyFullWidget(), EditorToolBar.WidgetPostion.DesignModeFirstRow);

        editorToolBar.addSeparator( EditorToolBar.WidgetPostion.DesignModeFirstRow);

        editorToolBar.addWidget(toolbarWidgetsFactory.getOrderedListWidget(), EditorToolBar.WidgetPostion.DesignModeFirstRow);
        editorToolBar.addWidget(toolbarWidgetsFactory.getUnorderedListWidget(), EditorToolBar.WidgetPostion.DesignModeFirstRow);

        editorToolBar.addSeparator( EditorToolBar.WidgetPostion.DesignModeFirstRow);

        editorToolBar.addWidget(toolbarWidgetsFactory.getLinkWidget(), EditorToolBar.WidgetPostion.DesignModeFirstRow);
        editorToolBar.addWidget(toolbarWidgetsFactory.getUnlinkWidget(), EditorToolBar.WidgetPostion.DesignModeFirstRow);
        editorToolBar.addWidget(toolbarWidgetsFactory.getInsertImageWidget(), EditorToolBar.WidgetPostion.DesignModeFirstRow);

        editorToolBar.addSeparator( EditorToolBar.WidgetPostion.DesignModeFirstRow);

        editorToolBar.addWidget(toolbarWidgetsFactory.getForegroundColorWidget(), EditorToolBar.WidgetPostion.DesignModeFirstRow);
        editorToolBar.addWidget(toolbarWidgetsFactory.getBackgroundColorWidget(), EditorToolBar.WidgetPostion.DesignModeFirstRow);

        editorToolBar.addWidget(toolbarWidgetsFactory.getFontStyleWidget(), EditorToolBar.WidgetPostion.DesignModeSecondRow);
        editorToolBar.addWidget(toolbarWidgetsFactory.getFontSizeWidget(),  EditorToolBar.WidgetPostion.DesignModeSecondRow);

        editorToolBar.addWidget(toolbarWidgetsFactory.getBackToRichTextWidget(),  EditorToolBar.WidgetPostion.SourceModeFirstRow);
        return editorToolBar;
    }
}
