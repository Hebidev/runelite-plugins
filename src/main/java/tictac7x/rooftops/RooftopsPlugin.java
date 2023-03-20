package tictac7x.rooftops;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.GroundObjectSpawned;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.ItemDespawned;
import net.runelite.api.events.ItemSpawned;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.StatChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

@Slf4j
@PluginDescriptor(
	name = "Rooftop Agility Improved",
	description = "Improved clickboxes for rooftop agility courses",
	tags = { "roof", "rooftop", "agility", "mark", "grace", "graceful" }
)
public class RooftopsPlugin extends Plugin {
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlays;

	@Inject
	private RooftopsConfig config;

	private RooftopsCourseManager course_manager;

	private RooftopsOverlay overlay_rooftops;

//	private RooftopsOverylayDebug overlay_debug;

//	private Courses courses;

	@Provides
	RooftopsConfig provideConfig(ConfigManager configManager) {
		return configManager.getConfig(RooftopsConfig.class);
	}

	@Override
	protected void startUp() {
		course_manager = new RooftopsCourseManager(client);
//		courses = new Courses(config, client);
		overlay_rooftops = new RooftopsOverlay(client, config, course_manager);
//		overlay_debug = new RooftopsOverylayDebug(client, config, courses);

		overlays.add(overlay_rooftops);
//		overlays.add(overlay_debug);
	}

	@Override
	protected void shutDown() {
		overlays.remove(overlay_rooftops);
//		overlays.remove(overlay_debug);
	}

	@Subscribe
	public void onGameObjectSpawned(final GameObjectSpawned event) {
		course_manager.onTileObjectSpawned(event.getGameObject());
	}

	@Subscribe
	public void onGroundObjectSpawned(final GroundObjectSpawned event) {
		course_manager.onTileObjectSpawned(event.getGroundObject());
	}

	@Subscribe
	public void onDecorativeObjectSpawned(final DecorativeObjectSpawned event) {
		course_manager.onTileObjectSpawned(event.getDecorativeObject());
	}

	@Subscribe
	public void onItemSpawned(final ItemSpawned event) {
		course_manager.onItemSpawned(event);
	}

	@Subscribe
	public void onItemDespawned(final ItemDespawned event) {
		course_manager.onItemDespawned(event);
	}

	@Subscribe
	public void onChatMessage(final ChatMessage event) {
		course_manager.onChatMessage(event);
	}

	@Subscribe
	public void onMenuOptionClicked(final MenuOptionClicked event) {
		course_manager.onMenuOptionClicked(event);
	}

	@Subscribe
	public void onStatChanged(final StatChanged event) {
		course_manager.onStatChanged(event);
	}

	@Subscribe
	public void onHitsplatApplied(final HitsplatApplied event) {
		course_manager.onHitsplatApplied(event);
	}

	@Subscribe
	public void onGameTick(final GameTick gametick) {
		course_manager.onGameTick(gametick);
	}

	@Subscribe
	public void onGameStateChanged(final GameStateChanged event) {
		course_manager.onGameStateChanged(event);
//		courses.onGameStateChanged(event);
	}
}
