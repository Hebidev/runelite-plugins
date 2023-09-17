package tictac7x.charges.infoboxes;

import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.client.Notifier;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import tictac7x.charges.ChargedItemInfoBox;
import tictac7x.charges.ChargesImprovedConfig;
import tictac7x.charges.storage.ChargesItem;
import tictac7x.charges.storage.Storage;
import tictac7x.charges.triggers.TriggerChatMessage;
import tictac7x.charges.triggers.TriggerItem;

public class H_CircletOfWater extends ChargedItemInfoBox {
    public H_CircletOfWater(
        final Client client,
        final ClientThread client_thread,
        final ConfigManager configs,
        final ItemManager items,
        final InfoBoxManager infoboxes,
        final ChatMessageManager chat_messages,
        final Notifier notifier,
        final ChargesImprovedConfig config,
        final Storage storage,
        final Plugin plugin
    ) {
        super(ChargesItem.CIRCLET_OF_WATER, ItemID.CIRCLET_OF_WATER, client, client_thread, configs, items, infoboxes, chat_messages, notifier, config, storage, plugin);
        this.config_key = ChargesImprovedConfig.circlet_of_water;
        this.triggers_items = new TriggerItem[]{
            new TriggerItem(ItemID.CIRCLET_OF_WATER_UNCHARGED).fixedCharges(0),
            new TriggerItem(ItemID.CIRCLET_OF_WATER)
        };
        this.triggers_chat_messages = new TriggerChatMessage[]{
                new TriggerChatMessage("Your circlet protects you from the desert heat.").decreaseCharges(1),
                new TriggerChatMessage("Your circlet has (?<charges>.+) charges? left."),
                new TriggerChatMessage("You add (?<charges>.+) charges? to your circlet.$"),
                new TriggerChatMessage("You add .+ charges? to your circlet. It now has (?<charges>.+) charges?."),
        };
    }
}
