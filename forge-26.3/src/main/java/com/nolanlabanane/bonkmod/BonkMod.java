package com.nolanlabanane.bonkmod;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod(BonkMod.MOD_ID)
public final class BonkMod {
    public static final String MOD_ID = "bonkmod";
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final RegistryObject<Item> BONK_HAMMER = ITEMS.register("bonk_hammer", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<CreativeModeTab> BONK_TAB = CREATIVE_TABS.register("bonk", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.bonkmod.bonk"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> BONK_HAMMER.get().getDefaultInstance())
            .displayItems((parameters, output) -> output.accept(BONK_HAMMER.get()))
            .build());

    public BonkMod(FMLJavaModLoadingContext context) {
        var modBusGroup = context.getModBusGroup();
        ITEMS.register(modBusGroup);
        CREATIVE_TABS.register(modBusGroup);
    }
}
