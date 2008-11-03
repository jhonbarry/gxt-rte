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

import com.google.gwt.i18n.client.Messages;

/**
 * All texts constants are managend by this constant interface
 *
 *
 * @author: Peter Quiel <peter.quiel@iverein-networks.de>
 * Date: 30.10.2008
 * Time: 13:50:15
 */
public interface EditorMessages extends Messages {

    public String fontSize();

    public String foregroundTitle();

    public String backgroundTitle();

    public String createLinkTitle();

    public String createLinkFieldDescription();

    public String createLinkButtonTitle();


    public String insertImageTitle();

    public String insertImageFieldDescription();

    public String insertImageButtonTitle();

    public String style();

    public String cancel();

    public String ok();

    String fontStyleNormal();

    String fontStyleHeadingOne();

    String fontStyleHeadingTwo();

    String fontStyleHeadingThree();

    String fontStyleHeadingFour();

    String fontStyleHeadingFive();

    String fontStyleHeadingSix();

    String fontStylePre();
}
