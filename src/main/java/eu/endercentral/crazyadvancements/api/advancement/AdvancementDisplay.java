package eu.endercentral.crazyadvancements.api.advancement;

import eu.endercentral.crazyadvancements.implementation.JSONMessage;
import eu.endercentral.crazyadvancements.implementation.advancement.CrazyAdvancement;
import eu.endercentral.crazyadvancements.implementation.advancement.CrazyAdvancementDisplay;
import eu.endercentral.crazyadvancements.implementation.advancement.CrazyAdvancementFrame;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

/**
 * @author sarhatabaot
 */
public interface AdvancementDisplay {
	/**
	 * @return Icon {@link ItemStack}
	 */
	ItemStack getIcon();
	/**
	 * @return Title {@link JSONMessage}
	 */
	JSONMessage getTitle();
	/**
	 * @return Description {@link JSONMessage}
	 */
	JSONMessage getDescription();

	/**
	 * @return {@link CrazyAdvancementFrame}
	 */
	CrazyAdvancementFrame getFrame();

	/**
	 * @return true if toasts will be shown
	 */
	boolean isToastShown();

	/**
	 * @return true if messages will be displayed in chat
	 */
	boolean isAnnouncedToChat();

	/**
	 * @return Background texture path
	 */
	@Nullable
	String getBackgroundTexture();

	/**
	 * Sets the background texture
	 * @param backgroundTexture Background Texture path
	 */
	void setBackgroundTexture(@Nullable String backgroundTexture);

	/**
	 * Gets the relative X coordinate
	 * @return relative X coordinate
	 */
	float getX();

	/**
	 * Gets the relative y coordinate
	 * @return relative y coordinate
	 */
	float getY();

	/**
	 * Gets the absolute x coordinate
	 * @return absolute x coordinate
	 */
	float generateX();

	/**
	 * Gets the absolute y coordinate
	 * @return absolute y coordinate
	 */
	float generateY();

	float getTabWidth();
	float getTabHeight();

	/**
	 * Gets the {@link AdvancementVisibility}
	 * @return when an advancement is visible
	 */
	AdvancementVisibility getVisibility();

	/**
	 * @param player Player to check
	 * @param advancement Advancement to check (because {@link CrazyAdvancementDisplay} is not bound to one advancement)
	 * @return true if it should be currently visible
	 */
	boolean isVisible(Player player, Advancement advancement);

	/**
	 * @return the advancement that marks the origin of the coordinates
	 */
	Advancement getPositionOrigin();

	/**
	 * Changes the Icon
	 * @param icon New Icon Material to display
	 */
	void setIcon(Material icon);

	/**
	 * Changes the Icon
	 * @param icon New Icon to display
	 */
	void setIcon(ItemStack icon);

	/**
	 * Changes the Title
	 * @param title New title {@link JSONMessage}
	 */
	void setTitle(JSONMessage title);

	/**
	 * Changes the Title
	 * @param title New Title {@link String}
	 */
	void setTitle(String title);

	/**
	 * Changes the Description
	 * @param description New title {@link JSONMessage}
	 */
	void setDescription(JSONMessage description);

	/**
	 * Changes the Description
	 * @param description New Title {@link String}
	 */
	void setDescription(String description);

	/**
	 * Changes the Frame
	 * @param frame New Frame
	 */
	void setFrame(CrazyAdvancementFrame frame);

	/**
	 * Changes if toasts should be shown
	 * @param showToast
	 */
	void setShowToast(boolean showToast);

	/**
	 * Changes if chat messages should be displayed
	 * @param announceChat
	 */
	void setAnnounceChat(boolean announceChat);

	/**
	 * Changes the visibility
	 * @param visibility New Visibility
	 */
	void setVisibility(AdvancementVisibility visibility);

	/**
	 * Changes the relative coordinates
	 * @param x relative x coordinate
	 * @param y relative y coordinate
	 */
	void setCoordinates(float x, float y);

	/**
	 * Changes the relative x coordinate
	 * @param x relative x coordinate
	 */
	 void setX(float x);

	/**
	 * Changes the relative y coordinate
	 * @param y relative y coordinate
	 */
	void setY(float y);

	void setTabHeight(float tabHeight);

	void setTabWidth(float tabWidth);

	/**
	 * Changes the advancement that marks the origin of the coordinates
	 * @param positionOrigin New position origin
	 */
	void setPositionOrigin(Advancement positionOrigin);

}
