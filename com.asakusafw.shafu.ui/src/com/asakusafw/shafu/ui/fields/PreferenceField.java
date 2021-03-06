/**
 * Copyright 2013-2015 Asakusa Framework Team.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.asakusafw.shafu.ui.fields;

import org.eclipse.swt.widgets.Control;

/**
 * A preference field implementation.
 */
public abstract class PreferenceField extends BasicField implements IPreferenceField {

    /**
     * Creates a new instance.
     * @param key the preference key
     * @param control the target control
     */
    public PreferenceField(String key, Control control) {
        super(key, control);
    }
}
