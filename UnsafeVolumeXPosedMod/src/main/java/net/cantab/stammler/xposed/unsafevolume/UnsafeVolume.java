package net.cantab.stammler.xposed.unsafevolume;

/**
 * Unsafe Volume Xposed Mod
 *
 * This little programme disables the Safe Media Volume popup, which Google has to implement due to
 * EU regulations. It uses the Xposed framework to hook into the Zygote initialisation to set the
 * parameter config_safe_media_volume_enabled to false.
 *
 * A nice extension would be to actually modify this program so that one can alter any configuration
 * parameter from the config.xml file. It could provide an interface where one can add parameters
 * and the values one would like to assign to them. Then during startup the programme would apply
 * the values.
 *
 *
 * This tiny programme is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * This programme is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a gazillion times.
 * If not, see http://www.gnu.org/licenses/.
 *
 * Created on 6/20/13 by Sebastian Stammler (stammler@cantab.net).
 */

import android.content.res.XResources;

import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XposedBridge;

public class UnsafeVolume implements IXposedHookZygoteInit {
    @Override
    public void initZygote(IXposedHookZygoteInit.StartupParam startupParam) throws Throwable {
        XResources.setSystemWideReplacement("android", "bool", "config_safe_media_volume_enabled", false);
        XposedBridge.log("Safe media volume disabled!");
    }
}
