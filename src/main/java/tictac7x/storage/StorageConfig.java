package tictac7x.storage;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup(StorageConfig.group)
public interface StorageConfig extends Config {
	String group = "tictac7x-storage";

	@ConfigSection(
		name = "Inventory",
		description = "Inventory overlay",
		position = 1
	) String inventory = "inventory";

		@ConfigItem(
			keyName = "inventory",
			name = "inventory",
			description = "inventory",
			section = inventory,
			position = 1,
			hidden = true
		) default String getInventory() { return ""; }

		@ConfigItem(
			keyName = "inventory_show",
			name = "Show inventory overlay",
			description = "Show overlay of inventory items.",
			section = inventory,
			position = 2
		) default boolean showInventory() { return true; }

		@ConfigItem(
			keyName = "inventory_whitelist",
			name = "whitelist",
			description = "Names of items to show in the inventory overlay.",
			section = inventory,
			position = 3,
			hidden = true
		) default String getInventoryWhitelist() { return ""; }

		@ConfigItem(
			keyName = "inventory_blacklist",
			name = "blacklist",
			description = "Names of items to hide from the inventory overlay.",
			section = inventory,
			position = 4
		) default String getInventoryBlacklist() { return ""; }

	@ConfigSection(
		name = "Bank",
		description = "Bank overlay",
		position = 2
	) String bank = "bank";

		@ConfigItem(
			keyName = "bank",
			name = "bank",
			description = "bank",
			section = bank,
			position = 1,
			hidden = true
		) default String getBank() { return ""; }

		@ConfigItem(
			keyName = "bank_show",
			name = "Show bank overlay",
			description = "Show overlay of bank items.",
			section = bank,
			position = 2
		) default boolean showBank() { return true; }

		@ConfigItem(
			keyName = "bank_whitelist",
			name = "Bank whitelist",
			description = "Names of items to show in the bank overlay.",
			section = bank,
			position = 3
		) default String getBankWhitelist() { return ""; }

		@ConfigItem(
			keyName = "bank_blacklist",
			name = "Bank blacklist",
			description = "Names of items to hide from the bank overlay.",
			section = bank,
			position = 4
		) default String getBankBlacklist() { return ""; }
}
