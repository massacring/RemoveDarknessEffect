package net.massacring.templatemod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(RemoveDarknessEffect.MOD_ID)
@Mod.EventBusSubscriber(Dist.CLIENT)
public class RemoveDarknessEffect {
    public static final String MOD_ID = "removedarknesseffect";

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        LocalPlayer player = Minecraft.getInstance().player;

        if (player == null) return;

        boolean hasDarkness = player.getEffect(MobEffects.DARKNESS) != null;

        if (!hasDarkness) return;

        player.removeEffect(MobEffects.DARKNESS);
    }
}
