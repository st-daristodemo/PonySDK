/*
 * Copyright (c) 2011 PonySDK
 *  Owners:
 *  Luciano Broussal  <luciano.broussal AT gmail.com>
 *	Mathieu Barbier   <mathieu.barbier AT gmail.com>
 *	Nicolas Ciaravola <nicolas.ciaravola.pro AT gmail.com>
 *  
 *  WebSite:
 *  http://code.google.com/p/pony-sdk/
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

package com.ponysdk.ui.terminal.ui;

import com.google.gwt.user.client.ui.DisclosurePanel;
import com.ponysdk.ui.terminal.Property;
import com.ponysdk.ui.terminal.PropertyKey;
import com.ponysdk.ui.terminal.UIService;
import com.ponysdk.ui.terminal.instruction.Create;

public class PTDisclosurePanel extends PTWidget {

    @Override
    public void create(final Create create, final UIService uiService) {
        final Property mainProperty = create.getMainProperty();

        final String openImg = mainProperty.getStringProperty(PropertyKey.DISCLOSURE_PANEL_OPEN_IMG);
        final String closeImg = mainProperty.getStringProperty(PropertyKey.DISCLOSURE_PANEL_CLOSE_IMG);
        final String headerText = mainProperty.getValue();

        PImageResource openImageResource = new PImageResource(openImg, 16, 16);
        PImageResource closeImageResource = new PImageResource(closeImg, 16, 16);

        init(create, uiService, new DisclosurePanel(openImageResource, closeImageResource, headerText));
    }

}