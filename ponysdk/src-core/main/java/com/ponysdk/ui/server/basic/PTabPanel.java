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

package com.ponysdk.ui.server.basic;

import com.ponysdk.core.instruction.Update;
import com.ponysdk.core.stm.Txn;
import com.ponysdk.ui.server.basic.event.HasPAnimation;
import com.ponysdk.ui.terminal.Dictionnary.PROPERTY;
import com.ponysdk.ui.terminal.WidgetType;

/**
 * A panel that represents a tabbed set of pages, each of which contains another widget. Its child widgets are
 * shown as the user selects the various tabs associated with them. The tabs can contain arbitrary HTML.
 * <p>
 * This widget will <em>only</em> work in quirks mode. If your application is in Standards Mode, use
 * {@link PTabLayoutPanel} instead.
 * </p>
 * <h3>CSS Style Rules</h3>
 * <ul class='css'>
 * <li>.gwt-TabPanel { the tab panel itself }</li>
 * <li>.gwt-TabPanelBottom { the bottom section of the tab panel (the deck containing the widget) }</li>
 * </ul>
 * 
 * @see PTabLayoutPanel
 */
public class PTabPanel extends PTabLayoutPanel implements HasPAnimation {

    private boolean animationEnabled = false;

    @Override
    protected WidgetType getWidgetType() {
        return WidgetType.TAB_PANEL;
    }

    @Override
    public boolean isAnimationEnabled() {
        return animationEnabled;
    }

    @Override
    public void setAnimationEnabled(final boolean animationEnabled) {
        this.animationEnabled = animationEnabled;
        final Update update = new Update(ID);
        update.put(PROPERTY.ANIMATION, animationEnabled);
        Txn.get().getTxnContext().save(update);
    }

}
