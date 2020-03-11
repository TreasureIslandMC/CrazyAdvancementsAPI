package eu.endercentral.crazyadvancements.implementation.advancement;


import eu.endercentral.crazyadvancements.api.advancement.Advancement;
import eu.endercentral.crazyadvancements.api.advancement.AdvancementDisplay;
import eu.endercentral.crazyadvancements.api.advancement.AdvancementVisibility;
import eu.endercentral.crazyadvancements.implementation.CrazyAdvancements;
import eu.endercentral.crazyadvancements.implementation.JSONMessage;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.Nullable;

public class CrazyAdvancementDisplay implements AdvancementDisplay {
	private CrazyAdvancements plugin = CrazyAdvancements.getInstance();

	@SerializedName("icon")
	private Material iconID;
	private transient ItemStack icon;
	private JSONMessage title, description;
	private CrazyAdvancementFrame frame;
	private boolean showToast;
	private boolean announceChat;
	private transient AdvancementVisibility vis;
	private String backgroundTexture;
	private float x = 0, y = 0, tabWidth = 0, tabHeight = 0;
	private transient CrazyAdvancement positionOrigin;
	
	@SerializedName("visibility")
	public String visibilityIdentifier = "VANILLA";
	
	//Material Constructors
	
	/**
	 * 
	 * @param icon Icon {@link Material}
	 * @param title Title {@link JSONMessage}
	 * @param description Description {@link JSONMessage}
	 * @param frame {@link CrazyAdvancementFrame}
	 * @param showToast Should toast messages be shown
	 * @param announceChat Should advancements be announced in chat
	 * @param visibility When an advancement is visible
	 */
	public CrazyAdvancementDisplay(Material icon, JSONMessage title, JSONMessage description, CrazyAdvancementFrame frame, boolean showToast, boolean announceChat, AdvancementVisibility visibility) {
		this.icon = new ItemStack(icon);
		this.iconID = icon;
		this.title = title;
		this.description = description;
		this.frame = frame;
		this.showToast = showToast;
		this.announceChat = announceChat;
		setVisibility(visibility);
	}
	
	/**
	 * 
	 * @param icon Icon {@link Material}
	 * @param title Title {@link String}
	 * @param description Description {@link String}
	 * @param frame {@link CrazyAdvancementFrame}
	 * @param showToast Should toast messages be shown
	 * @param announceChat Should advancements be announced in chat
	 * @param visibility When an advancement is visible
	 */
	public CrazyAdvancementDisplay(Material icon, String title, String description, CrazyAdvancementFrame frame, boolean showToast, boolean announceChat, AdvancementVisibility visibility) {
		this.icon = new ItemStack(icon);
		this.iconID = icon;
		if(title.contains("§")) title += "§a";
		this.title = new JSONMessage("{\"text\":\"" + title.replaceAll("\"", "\\\"") + "\"}");
		this.description = new JSONMessage("{\"text\":\"" + description.replaceAll("\"", "\\\"") + "\"}");
		this.frame = frame;
		this.showToast = showToast;
		this.announceChat = announceChat;
		setVisibility(visibility);
	}
	
	/**
	 * 
	 * @param icon Icon {@link Material}
	 * @param title Title {@link JSONMessage}
	 * @param description Description {@link JSONMessage}
	 * @param frame {@link CrazyAdvancementFrame}
	 * @param backgroundTexture Background texture path
	 * @param showToast Should toast messages be shown
	 * @param announceChat Should advancements be announced in chat
	 * @param visibility When an advancement is visible
	 */
	public CrazyAdvancementDisplay(Material icon, JSONMessage title, JSONMessage description, CrazyAdvancementFrame frame, String backgroundTexture, boolean showToast, boolean announceChat, AdvancementVisibility visibility) {
		this.icon = new ItemStack(icon);
		this.iconID = icon;
		this.title = title;
		this.description = description;
		this.frame = frame;
		this.backgroundTexture = backgroundTexture;
		this.showToast = showToast;
		this.announceChat = announceChat;
		setVisibility(visibility);
	}
	
	/**
	 * 
	 * @param icon Icon {@link Material}
	 * @param title Title {@link String}
	 * @param description Description {@link String}
	 * @param frame {@link CrazyAdvancementFrame}
	 * @param backgroundTexture Background texture path
	 * @param showToast Should toast messages be shown
	 * @param announceChat Should advancements be announced in chat
	 * @param visibility When an advancement is visible
	 */
	public CrazyAdvancementDisplay(Material icon, String title, String description, CrazyAdvancementFrame frame, String backgroundTexture, boolean showToast, boolean announceChat, AdvancementVisibility visibility) {
		this.icon = new ItemStack(icon);
		this.iconID = icon;
		if(title.contains("§")) title += "§a";
		this.title = new JSONMessage("{\"text\":\"" + title.replaceAll("\"", "\\\"") + "\"}");
		this.description = new JSONMessage("{\"text\":\"" + description.replaceAll("\"", "\\\"") + "\"}");
		this.frame = frame;
		this.backgroundTexture = backgroundTexture;
		this.showToast = showToast;
		this.announceChat = announceChat;
		setVisibility(visibility);
	}
	
	//ItemStack constructors
	
	/**
	 * 
	 * @param icon Icon {@link ItemStack}
	 * @param title Title {@link JSONMessage}
	 * @param description Description {@link JSONMessage}
	 * @param frame {@link CrazyAdvancementFrame}
	 * @param showToast Should toast messages be shown
	 * @param announceChat Should advancements be announced in chat
	 * @param visibility When an advancement is visible
	 */
	public CrazyAdvancementDisplay(ItemStack icon, JSONMessage title, JSONMessage description, CrazyAdvancementFrame frame, boolean showToast, boolean announceChat, AdvancementVisibility visibility) {
		this.icon = icon;
		this.iconID = icon.getType();
		this.title = title;
		this.description = description;
		this.frame = frame;
		this.showToast = showToast;
		this.announceChat = announceChat;
		setVisibility(visibility);
	}
	
	/**
	 * 
	 * @param icon Icon {@link ItemStack}
	 * @param title Title {@link String}
	 * @param description Description {@link String}
	 * @param frame {@link CrazyAdvancementFrame}
	 * @param showToast Should toast messages be shown
	 * @param announceChat Should advancements be announced in chat
	 * @param visibility When an advancement is visible
	 */
	public CrazyAdvancementDisplay(ItemStack icon, String title, String description, CrazyAdvancementFrame frame, boolean showToast, boolean announceChat, AdvancementVisibility visibility) {
		this.icon = icon;
		this.iconID = icon.getType();
		if(title.contains("§")) title += "§a";
		this.title = new JSONMessage("{\"text\":\"" + title.replaceAll("\"", "\\\"") + "\"}");
		this.description = new JSONMessage("{\"text\":\"" + description.replaceAll("\"", "\\\"") + "\"}");
		this.frame = frame;
		this.showToast = showToast;
		this.announceChat = announceChat;
		setVisibility(visibility);
	}
	
	/**
	 * 
	 * @param icon Icon {@link ItemStack}
	 * @param title Title {@link JSONMessage}
	 * @param description Description {@link JSONMessage}
	 * @param frame {@link CrazyAdvancementFrame}
	 * @param backgroundTexture Background texture path
	 * @param showToast Should toast messages be shown
	 * @param announceChat Should advancements be announced in chat
	 * @param visibility When an advancement is visible
	 */
	public CrazyAdvancementDisplay(ItemStack icon, JSONMessage title, JSONMessage description, CrazyAdvancementFrame frame, String backgroundTexture, boolean showToast, boolean announceChat, AdvancementVisibility visibility) {
		this.icon = icon;
		this.iconID = icon.getType();
		this.title = title;
		this.description = description;
		this.frame = frame;
		this.backgroundTexture = backgroundTexture;
		this.showToast = showToast;
		this.announceChat = announceChat;
		setVisibility(visibility);
	}
	
	/**
	 * 
	 * @param icon Icon {@link ItemStack}
	 * @param title Title {@link String}
	 * @param description Description {@link String}
	 * @param frame {@link CrazyAdvancementFrame}
	 * @param backgroundTexture Background texture path
	 * @param showToast Should toast messages be shown
	 * @param announceChat Should advancements be announced in chat
	 * @param visibility When an advancement is visible
	 */
	public CrazyAdvancementDisplay(ItemStack icon, String title, String description, CrazyAdvancementFrame frame, String backgroundTexture, boolean showToast, boolean announceChat, AdvancementVisibility visibility) {
		this.icon = icon;
		this.iconID = icon.getType();
		if(title.contains("§")) title += "§a";
		this.title = new JSONMessage("{\"text\":\"" + title.replaceAll("\"", "\\\"") + "\"}");
		this.description = new JSONMessage("{\"text\":\"" + description.replaceAll("\"", "\\\"") + "\"}");
		this.frame = frame;
		this.backgroundTexture = backgroundTexture;
		this.showToast = showToast;
		this.announceChat = announceChat;
		setVisibility(visibility);
	}

	/**
	 * @return Icon {@link ItemStack}
	 */
	@Override
	public ItemStack getIcon() {
		if(icon == null && iconID != null) icon = new ItemStack(iconID);
		return icon;
	}
	
	/**
	 * @return Title {@link JSONMessage}
	 */
	@Override
	public JSONMessage getTitle() {
		return title;
	}
	
	/**
	 * @return Description {@link JSONMessage}
	 */
	@Override
	public JSONMessage getDescription() {
		return description;
	}
	
	/**
	 * @return {@link CrazyAdvancementFrame}
	 */
	@Override
	public CrazyAdvancementFrame getFrame() {
		return frame;
	}
	
	/**
	 * @return true if toasts will be shown
	 */
	@Override
	public boolean isToastShown() {
		return showToast;
	}
	
	/**
	 * @return true if messages will be displayed in chat
	 */
	@Override
	public boolean isAnnouncedToChat() {
		return announceChat && plugin.isAnnounceAdvancementMessages();
	}
	
	/**
	 * @return Background texture path
	 */
	@Nullable
	@Override
	public String getBackgroundTexture() {
		return backgroundTexture;
	}
	
	/**
	 * Sets the background texture
	 * @param backgroundTexture Background Texture path
	 */
	@Override
	public void setBackgroundTexture(@Nullable String backgroundTexture) {
		this.backgroundTexture = backgroundTexture;
	}
	
	/**
	 * Gets the relative X coordinate
	 * @return relative X coordinate
	 */
	@Override
	public float getX() {
		return x;
	}
	
	/**
	 * Gets the relative y coordinate
	 * @return relative y coordinate
	 */
	@Override
	public float getY() {
		return y;
	}
	
	/**
	 * Gets the absolute x coordinate
	 * @return absolute x coordinate
	 */
	@Override
	public float generateX() {
		if(getPositionOrigin() == null) {
			return x;
		} else {
			return getPositionOrigin().getDisplay().generateX() + x;
		}
	}
	
	/**
	 * Gets the absolute y coordinate
	 * @return absolute y coordinate
	 */
	@Override
	public float generateY() {
		if(getPositionOrigin() == null) {
			return y;
		} else {
			return getPositionOrigin().getDisplay().generateY() + y;
		}
	}

	@Override
	public float getTabWidth() {
		return tabWidth;
	}

	@Override
	public float getTabHeight() {
		return tabHeight;
	}
	
	/**
	 * Gets the {@link AdvancementVisibility}
	 * @return when an advancement is visible
	 */
	@Override
	public AdvancementVisibility getVisibility() {
		return vis != null ? vis : AdvancementVisibility.VANILLA;
	}
	
	/**
	 * 
	 * @param player Player to check
	 * @param advancement Advancement to check (because {@link CrazyAdvancementDisplay} is not bound to one advancement)
	 * @return true if it should be currently visible
	 */
	@Override
	public boolean isVisible(Player player, Advancement advancement) {
		AdvancementVisibility visibility = getVisibility();
		return visibility.isVisible(player, advancement) || advancement.isGranted(player) || (visibility.isAlwaysVisibleWhenAdvancementAfterIsVisible() && advancement.isAnythingGrantedAfter(player));
	}
	
	/**
	 * @return the advancement that marks the origin of the coordinates
	 */
	@Override
	public CrazyAdvancement getPositionOrigin() {
		return positionOrigin;
	}

	/**
	 * Changes the Icon
	 * @param icon New Icon Material to display
	 */
	@Override
	public void setIcon(Material icon) {
		this.icon = new ItemStack(icon);
		this.iconID = icon;
	}
	
	/**
	 * Changes the Icon
	 * @param icon New Icon to display
	 */
	@Override
	public void setIcon(ItemStack icon) {
		this.icon = icon;
		this.iconID = icon.getType();
	}
	
	/**
	 * Changes the Title
	 * @param title New title {@link JSONMessage}
	 */
	@Override
	public void setTitle(JSONMessage title) {
		this.title = title;
	}
	
	/**
	 * Changes the Title
	 * @param title New Title {@link String}
	 */
	@Override
	public void setTitle(String title) {
		if(title.contains("§")) title += "§a";
		this.title = new JSONMessage("{\"text\":\"" + title.replaceAll("\"", "\\\"") + "\"}");
	}
	
	/**
	 * Changes the Description
	 * @param description New title {@link JSONMessage}
	 */
	@Override
	public void setDescription(JSONMessage description) {
		this.description = description;
	}
	
	/**
	 * Changes the Description
	 * @param description New Title {@link String}
	 */
	@Override
	public void setDescription(String description) {
		this.description = new JSONMessage("{\"text\":\"" + description.replaceAll("\"", "\\\"") + "\"}");
	}
	
	/**
	 * Changes the Frame
	 * @param frame New Frame
	 */
	@Override
	public void setFrame(CrazyAdvancementFrame frame) {
		this.frame = frame;
	}
	
	/**
	 * Changes if toasts should be shown
	 * @param showToast
	 */
	@Override
	public void setShowToast(boolean showToast) {
		this.showToast = showToast;
	}
	
	/**
	 * Changes if chat messages should be displayed
	 * @param announceChat
	 */
	@Override
	public void setAnnounceChat(boolean announceChat) {
		this.announceChat = announceChat;
	}
	
	/**
	 * Changes the visibility
	 * @param visibility New Visibility
	 */
	@Override
	public void setVisibility(AdvancementVisibility visibility) {
		this.vis = visibility;
		this.visibilityIdentifier = getVisibility().getName();
	}
	
	/**
	 * Changes the relative coordinates
	 * @param x relative x coordinate
	 * @param y relative y coordinate
	 */
	@Override
	public void setCoordinates(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Changes the relative x coordinate
	 * @param x relative x coordinate
	 */
	@Override
	public void setX(float x) {
		this.x = x;
	}
	
	/**
	 * Changes the relative y coordinate
	 * @param y relative y coordinate
	 */
	@Override
	public void setY(float y) {
		this.y = y;
	}

	@Override
	public void setTabHeight(float tabHeight) {
		this.tabHeight = tabHeight;
	}

	@Override
	public void setTabWidth(float tabWidth) {
		this.tabWidth = tabWidth;
	}
	
	/**
	 * Changes the advancement that marks the origin of the coordinates
	 * @param positionOrigin New position origin
	 */
	@Override
	public void setPositionOrigin(Advancement positionOrigin) {
		this.positionOrigin = (CrazyAdvancement) positionOrigin;
	}

}