/**
 * Copyright 2013-2019 Asakusa Framework Team.
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
package com.asakusafw.shafu.internal.ui.preferences;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.asakusafw.shafu.internal.ui.Activator;
import com.asakusafw.shafu.internal.ui.LogUtil;

/**
 * Represents an off-line mode property value.
 * @version 0.2.4
 */
public enum GradleNetworkMode implements GradleOption {

    /**
     * On-line mode.
     */
    ONLINE(Messages.GradleNetworkMode_onlineDescription, null, null),

    /**
     * Off-line mode.
     */
    OFFLINE(Messages.GradleNetworkMode_offlineDescription, null, "--offline"), //$NON-NLS-1$

    ;
    private final String description;

    private final String optionName;

    private final String longOptionName;

    private GradleNetworkMode(String description, String optionName, String longOptionName) {
        this.description = description;
        this.optionName = optionName;
        this.longOptionName = longOptionName;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getSymbol() {
        return this.name();
    }

    @Override
    public String getOptionName() {
        return optionName;
    }

    @Override
    public String getLongOptionName() {
        return longOptionName;
    }

    @Override
    public List<String> getArguments() {
        if (getLongOptionName() == null) {
            return Collections.emptyList();
        }
        return Collections.singletonList(getLongOptionName());
    }

    /**
     * Returns a constants for the target symbol.
     * @param symbol the target symbol
     * @return the corresponded constant, or {@link #ONLINE} if the target symbol is not supported
     */
    public static GradleNetworkMode fromSymbol(String symbol) {
        try {
            return GradleNetworkMode.valueOf(symbol);
        } catch (IllegalArgumentException e) {
            LogUtil.log(new Status(
                    IStatus.WARNING,
                    Activator.PLUGIN_ID,
                    MessageFormat.format(
                            "Symbol \"{1}\" is not defined in \"{0}\"", //$NON-NLS-1$
                            GradleLogLevel.class.getName(),
                            symbol)));
            return ONLINE;
        }
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
