package io.banna.rl;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Steel Bar Drop Sound"
)
public class SteelBarDropSoundPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private SteelBarDropSoundConfig config;

	@Inject
	SoundEngine soundEngine;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Steel Bar Drop Sound started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Steel Bar Drop Sound stopped!");
	}

	@Subscribe
	public void onMenuOptionClicked(final MenuOptionClicked event) {
		Widget widget = event.getWidget();
		if (widget != null) {
			String menuOption = event.getMenuOption();
			if ("Drop".equals(menuOption)) {
				if (widget.getItemId() == 2353) {
					soundEngine.playClip();
				}
			}
		}
	}

	@Provides
	SteelBarDropSoundConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(SteelBarDropSoundConfig.class);
	}
}
