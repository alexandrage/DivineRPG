package net.divinerpg.client;

import net.divinerpg.api.container.ContainerDivineMerchant;
import net.divinerpg.api.entity.tileentity.TileEntityInfiniteFurnace;
import net.divinerpg.api.entity.tileentity.TileEntityModFurnace;
import net.divinerpg.api.entity.tileentity.container.ContainerInfiniteFurnace;
import net.divinerpg.blocks.arcana.container.ContainerExtractor;
import net.divinerpg.blocks.vanilla.container.ContainerAltarCorruption;
import net.divinerpg.blocks.vethea.container.ContainerInfusionTable;
import net.divinerpg.blocks.vethea.container.tile_entity.TileEntityInfusionTable;
import net.divinerpg.client.render.gui.GuiAltarCorruption;
import net.divinerpg.client.render.gui.GuiCoalstoneFurnace;
import net.divinerpg.client.render.gui.GuiDatticon;
import net.divinerpg.client.render.gui.GuiDemonFurnace;
import net.divinerpg.client.render.gui.GuiExtractor;
import net.divinerpg.client.render.gui.GuiGreenlightFurnace;
import net.divinerpg.client.render.gui.GuiHunger;
import net.divinerpg.client.render.gui.GuiInfusionTable;
import net.divinerpg.client.render.gui.GuiJackOMan;
import net.divinerpg.client.render.gui.GuiLeorna;
import net.divinerpg.client.render.gui.GuiMerchent;
import net.divinerpg.client.render.gui.GuiMerik;
import net.divinerpg.client.render.gui.GuiMoltenFurnace;
import net.divinerpg.client.render.gui.GuiMoonlightFurnace;
import net.divinerpg.client.render.gui.GuiOceanfireFurnace;
import net.divinerpg.client.render.gui.GuiTinker;
import net.divinerpg.client.render.gui.GuiVatticus;
import net.divinerpg.client.render.gui.GuiWhitefireFurnace;
import net.divinerpg.client.render.gui.GuiZelus;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	public static int guiID = 0;
	public static int twilightFurnace = guiID++, infusionTable = guiID++, hunger = guiID++, coalstone = guiID++, tinker = guiID++, merchent = guiID++, jackOMan = guiID++, zelus = guiID++, vatticus = guiID++,
			leorna = guiID++, captainMerik = guiID++, datticon = guiID++, extractor = guiID++ , greenlight = guiID++, oceanfire = guiID++, molten = guiID++, whitefire = guiID++, moonlight = guiID++, demon = guiID++, altar = guiID++;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		if(ID == infusionTable)
			return new ContainerInfusionTable(player.inventory, (TileEntityInfusionTable)entity);
		if(ID == merchent || ID == tinker || ID == zelus || ID == hunger || ID == jackOMan || ID == vatticus || ID == leorna || ID == datticon || ID == captainMerik)
			return new ContainerDivineMerchant(player.inventory, (IMerchant)getEntityByID(x, world), world);
		if(ID == extractor)
			return new ContainerExtractor(player.inventory, (TileEntityModFurnace)entity);
		if(ID == greenlight || ID == oceanfire || ID == molten || ID == whitefire || ID == moonlight || ID == demon || ID == coalstone)
			return new ContainerInfiniteFurnace(player.inventory, (TileEntityInfiniteFurnace)entity);
		if(ID == altar)
			return new ContainerAltarCorruption(player.inventory, world, x, y, z);
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		if(ID == infusionTable)
			return new GuiInfusionTable(new ContainerInfusionTable(player.inventory, (TileEntityInfusionTable)entity));
		if(ID == coalstone)
			return new GuiCoalstoneFurnace(player.inventory, (TileEntityInfiniteFurnace)entity);
		if(ID == jackOMan)
			return new GuiJackOMan(new ContainerDivineMerchant(player.inventory, (IMerchant)getEntityByID(x, world), world), (IMerchant)getEntityByID(x, world));
		if(ID == merchent)
			return new GuiMerchent(new ContainerDivineMerchant(player.inventory, (IMerchant)getEntityByID(x, world), world), (IMerchant)getEntityByID(x, world));
		if(ID == tinker)
			return new GuiTinker(new ContainerDivineMerchant(player.inventory, (IMerchant)getEntityByID(x, world), world), (IMerchant)getEntityByID(x, world));
		if(ID == zelus)
			return new GuiZelus(new ContainerDivineMerchant(player.inventory, (IMerchant)getEntityByID(x, world), world), (IMerchant)getEntityByID(x, world));
		if(ID == vatticus)
			return new GuiVatticus(new ContainerDivineMerchant(player.inventory, (IMerchant)getEntityByID(x, world), world), (IMerchant)getEntityByID(x, world));
		if(ID == leorna)
			return new GuiLeorna(new ContainerDivineMerchant(player.inventory, (IMerchant)getEntityByID(x, world), world), (IMerchant)getEntityByID(x, world));
		if(ID == datticon)
			return new GuiDatticon(new ContainerDivineMerchant(player.inventory, (IMerchant)getEntityByID(x, world), world), (IMerchant)getEntityByID(x, world));
		if(ID == captainMerik)
			return new GuiMerik(new ContainerDivineMerchant(player.inventory, (IMerchant)getEntityByID(x, world), world), (IMerchant)getEntityByID(x, world));
		if(ID == hunger)
			return new GuiHunger(new ContainerDivineMerchant(player.inventory, (IMerchant)getEntityByID(x, world), world), (IMerchant)getEntityByID(x, world));
		if(ID == extractor)
			return new GuiExtractor(player.inventory, (TileEntityModFurnace)entity);
		if(ID == greenlight)
			return new GuiGreenlightFurnace(player.inventory, (TileEntityInfiniteFurnace)entity);
		if(ID == oceanfire)
			return new GuiOceanfireFurnace(player.inventory, (TileEntityInfiniteFurnace)entity);
		if(ID == molten)
			return new GuiMoltenFurnace(player.inventory, (TileEntityInfiniteFurnace)entity);
		if(ID == whitefire)
			return new GuiWhitefireFurnace(player.inventory, (TileEntityInfiniteFurnace)entity);
		if(ID == moonlight)
			return new GuiMoonlightFurnace(player.inventory, (TileEntityInfiniteFurnace)entity);
		if(ID == demon)
			return new GuiDemonFurnace(player.inventory, (TileEntityInfiniteFurnace)entity);
		if(ID == altar)
			return new GuiAltarCorruption(player.inventory, world, x, y, z);
		return null;
	}

	private Entity getEntityByID(int entityID, World world) {
		for(int i = 0; i < world.loadedEntityList.size(); i++) {
			if(((Entity)world.loadedEntityList.get(i)).getEntityId() == entityID) {
				return ((Entity)world.loadedEntityList.get(i));
			}
		}
		return null;
	}
}