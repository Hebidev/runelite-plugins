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

public class U_BoneCrusher extends ChargedItemInfoBox {
    public U_BoneCrusher(
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
        super(ChargesItem.BONE_CRUSHER, ItemID.BONECRUSHER, client, client_thread, configs, items, infoboxes, chat_messages, notifier, config, storage, plugin);
        this.config_key = ChargesImprovedConfig.bone_crusher;
        this.triggers_items = new TriggerItem[]{
            new TriggerItem(ItemID.BONECRUSHER),
            new TriggerItem(ItemID.BONECRUSHER_NECKLACE)
        };
        this.triggers_chat_messages = new TriggerChatMessage[]{
            new TriggerChatMessage("The bonecrusher( necklace)? has one charge.").fixedCharges(1),
            new TriggerChatMessage("The bonecrusher( necklace)? has no charges.").fixedCharges(0),
            new TriggerChatMessage("You remove all the charges from the bonecrusher( necklace)?.").fixedCharges(0),
            new TriggerChatMessage("Your bonecrusher( necklace)? has run out of charges.").fixedCharges(0).notification(),
            new TriggerChatMessage("(The|Your) bonecrusher( necklace)? has (?<charges>.+) charges?( left)?."),
        };
    }
}
