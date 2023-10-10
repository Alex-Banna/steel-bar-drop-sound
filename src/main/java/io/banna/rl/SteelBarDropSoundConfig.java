package io.banna.rl;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("steelbardropsound")
public interface SteelBarDropSoundConfig extends Config
{
	@ConfigItem(
			keyName = "dropVolume",
			name = "Drop volume",
			description = "Adjust the volume of the bar drop noise",
			position = 0
	)
	default int dropVolume() {
		return 100;
	}
}
