package io.banna.rl;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class SteelBarDropSoundPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(SteelBarDropSoundPlugin.class);
		RuneLite.main(args);
	}
}