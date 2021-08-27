package net.tutorialsbykaupenjoe.tutorialmod.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.tutorialsbykaupenjoe.tutorialmod.TutorialMod;

public class ReturnHomeCommand {
    public ReturnHomeCommand(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("home").then(Commands.literal("return").executes((command) -> {
            return returnHome(command.getSource());
        })));
    }

    private int returnHome(CommandSource source) throws CommandSyntaxException {
        ServerPlayerEntity player = source.asPlayer();
        boolean hasHomepos = player.getPersistentData().getIntArray(TutorialMod.MOD_ID + "homepos").length != 0;

        if(hasHomepos) {
            int[] playerPos = player.getPersistentData().getIntArray(TutorialMod.MOD_ID + "homepos");
            player.setPositionAndUpdate(playerPos[0], playerPos[1], playerPos[2]);

            source.sendFeedback(new StringTextComponent("Player returned Home!"), true);
            return 1;
        } else {
            source.sendFeedback(new StringTextComponent("No Home Position has been set!"), true);
            return -1;
        }
    }
}
