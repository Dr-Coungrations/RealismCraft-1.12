package com.lg.realism.Config;

import scala.Int;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigManager
{
   public static Configuration config;
   public static Property randomList;
   public static int xTextTempBody;
   public static int yTextTempBody;
   public static int powerThirst;
   public static boolean thirstDebug;
   public static boolean debugGeneration;
   public static boolean enableFirstGenerator;
   public static boolean enableTwoGenerator;
   public static boolean enableThirdGenerator;

   public static void register(FMLPreInitializationEvent e) {
       config = new Configuration(e.getSuggestedConfigurationFile());
       config.load();
       xTextTempBody = config.getInt("xTextTempBody", "Customization", 190, Int.MinValue(), Int.MaxValue(), I18n.format("config.xTextTempBody"), "config.xTextTempBody.name");
       yTextTempBody = config.getInt("yTextTempBody", "Customization", 20, Int.MinValue(),  Int.MaxValue(), I18n.format("config.yTextTempBody"), "config.yTextTempBody.name");
       
       powerThirst = config.getInt("powerThirst", "Thirst", 240, 50, 72000, I18n.format("config.powerThirst"), "config.powerThirst.name");
       thirstDebug = config.getBoolean("thirstDebug", "Debug", false, I18n.format("config.thirstDebug"), "config.thirstDebug.name");
       debugGeneration = config.getBoolean("debugGeneration", "Debug", false, I18n.format("config.debugGeneration"), "config.debugGeneration.name");
       enableFirstGenerator = config.getBoolean("enableFirstGenerator", "Customization", true, I18n.format("config.enableFirstGenerator"), "config.enableFirstGenerator.name");
       enableTwoGenerator = config.getBoolean("enableTwoGenerator", "Customization", true, I18n.format("config.enableTwoGenerator"), "config.enableTwoGenerator.name");
       enableThirdGenerator = config.getBoolean("enableThirdGenerator", "Customization", true, I18n.format("config.enableThirdGenerator"), "config.enableThirdGenerator.name");
       config.save();
   }
}