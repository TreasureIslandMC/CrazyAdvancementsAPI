package eu.endercentral.crazyadvancements.api;

import eu.endercentral.crazyadvancements.api.manager.AdvancementManager;
import eu.endercentral.crazyadvancements.implementation.NameKey;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public abstract class AdvancementPlugin extends JavaPlugin {
	/**
	 * Creates a new instance of an advancement manager
	 * @param players All players that should be in the new manager from the start, can be changed at any time
	 * @return the generated advancement manager
	 */
	public abstract AdvancementManager getNewAdvancementManager(Player... players);

	/**
	 * Clears the active tab
	 * @param player The player whose Tab should be cleared
	 */
	public abstract void clearActiveTab(Player player);
	/**
	 * Sets the active tab
	 * @param player The player whose Tab should be changed
	 * @param rootAdvancement The name of the tab to change to
	 */
	public abstract void setActiveTab(Player player, String rootAdvancement);

	/**
	 * Sets the active tab
	 *
	 * @param player The player whose Tab should be changed
	 * @param rootAdvancement The name of the tab to change to
	 */
	public abstract void setActiveTab(Player player, NameKey rootAdvancement);

	public abstract void setActiveTab(Player player, NameKey rootAdvancement, boolean update);

	/**
	 * @param player Player to check
	 * @return The active Tab
	 */
	public abstract NameKey getActiveTab(Player player);

	/**
	 * @return <b>true</b> if advancement messages should be shown by default<br><b>false</b> if all advancement messages will be hidden
	 */
	public abstract boolean isAnnounceAdvancementMessages();

	/**
	 * Changes if advancement messages should be shown by default
	 * @param announceAdvancementMessages
	 */
	public abstract void setAnnounceAdvancementMessages(boolean announceAdvancementMessages);

	/**
	 * @return <b>true</b> if Player Progress is saved by their UUID<br><b>false</b> if Player Progress is saved by their Name (not recommended)<br><b>Saving and Loading Progress via UUID will might not work as expected with this Setting!!<b>
	 */
	public abstract boolean isUseUUID();

}
