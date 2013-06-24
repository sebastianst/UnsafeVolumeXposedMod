UnsafeVolumeXposedMod
=====================

This little programme disables the Safe Media Volume popup, which Google has to implement due to
EU regulations. It uses the Xposed framework to hook into the Zygote initialisation to set the
parameter config_safe_media_volume_enabled to false.

A nice extension would be to actually modify this program so that one can alter any configuration
parameter from the config.xml file. It could provide an interface where one can add parameters
and the values one would like to assign to them. Then during startup the programme would apply
the values.

A compiled APK can be downloaded from my [Bintray site](https://bintray.com/sebastianst/Android/UnsafeVolumeXposedMod).