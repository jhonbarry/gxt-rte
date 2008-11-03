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

package org.iverein.gxt.rte.client.i18n;

import com.google.gwt.core.client.GWT;

/**
 * Helper class to grant easy access to @see EditorMessages
 *
 * @author: Peter Quiel <peter.quiel@iverein-networks.de>
 * Date: 30.10.2008
 * Time: 13:52:17
 */
public class EditorMessagesAccess {

    private static EditorMessages editorMessages;

    /**
     * Returns an implementation of @see EditorMessages 
     * @return
     */
    public static EditorMessages getEditorMessages() {
        if(editorMessages == null){
            editorMessages = GWT.create(EditorMessages.class);
        }
        return editorMessages;
    }

    /**
     * Protecting this class from being initiated
     */
    private EditorMessagesAccess(){}
}