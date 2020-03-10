package eu.endercentral.crazyadvancements.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import eu.endercentral.crazyadvancements.implementation.advancement.CrazyAdvancement;
import eu.endercentral.crazyadvancements.implementation.manager.CrazyAdvancementManager;

public class AdvancementGrantEvent extends Event {
	
	public static final HandlerList handlers = new HandlerList();
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
	
	private final CrazyAdvancementManager manager;
	private final CrazyAdvancement advancement;
	private final Player player;
	private boolean displayMessage;
	
	public AdvancementGrantEvent(CrazyAdvancementManager manager, CrazyAdvancement advancement, Player player, boolean displayMessage) {
		this.manager = manager;
		this.advancement = advancement;
		this.player = player;
		this.displayMessage = displayMessage;
	}
	
	/**
	 * 
	 * @return The Manager this event has been fired from
	 */
	public CrazyAdvancementManager getManager() {
		return manager;
	}
	
	/**
	 * 
	 * @return The Advancement that has been granted
	 */
	public CrazyAdvancement getAdvancement() {
		return advancement;
	}
	
	/**
	 * 
	 * @return Reciever
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * 
	 * @return true if a message will be displayed
	 */
	public boolean isDisplayMessage() {
		return displayMessage;
	}
	
	/**
	 * Sets if a message will be displayed
	 * 
	 * @param displayMessage
	 */
	public void setDisplayMessage(boolean displayMessage) {
		this.displayMessage = displayMessage;
	}
	
	
	
}