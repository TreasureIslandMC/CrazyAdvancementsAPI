package eu.endercentral.crazyadvancements.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import eu.endercentral.crazyadvancements.implementation.advancement.CrazyAdvancement;
import eu.endercentral.crazyadvancements.implementation.manager.CrazyAdvancementManager;

public class AdvancementRevokeEvent extends Event {
	
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
	
	public AdvancementRevokeEvent(CrazyAdvancementManager advancementManager_v2, CrazyAdvancement advancement, Player player) {
		this.manager = advancementManager_v2;
		this.advancement = advancement;
		this.player = player;
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
	 * @return The Advancement that has been revoked
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
	
	
	
	
}