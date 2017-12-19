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
   
   public static int timeOneSec;
   public static int timeOneMin;
   public static int timeOneHour;
   public static int timeOneDay;
   public static int timeOneMonth;
   public static int timeOneSeason;
   public static int timeOneYear;

   public static void register(FMLPreInitializationEvent e) {
       config = new Configuration(e.getSuggestedConfigurationFile());
       config.load();
       timeOneSec = config.getInt("timeOneSec", "Time Ticker", 20, Int.MinValue(), Int.MinValue(), I18n.format("config.timeOneSec"), "config.timeOneSec.name");
       timeOneMin = config.getInt("timeOneMin", "Time Ticker", 1200, Int.MinValue(), Int.MinValue(), I18n.format("config.timeOneMin"), "config.timeOneMin.name");
       timeOneHour = config.getInt("timeOneHour", "Time Ticker", 72000, Int.MinValue(), Int.MinValue(), I18n.format("config.timeOneHour"), "config.timeOneHour.name");
       timeOneDay = config.getInt("timeOneDay", "Time Ticker", 1728000, Int.MinValue(), Int.MinValue(), I18n.format("config.timeOneDay"), "config.timeOneDay.name");
       timeOneMonth = config.getInt("timeOneMonth", "Time Ticker", 51840000, Int.MinValue(), Int.MinValue(), I18n.format("config.timeOneMonth"), "config.timeOneMonth.name");
       timeOneSeason = config.getInt("timeOneSeason", "Time Ticker", 155520000, Int.MinValue(), Int.MinValue(), I18n.format("config.timeOneSeason"), "config.timeOneSeason.name");
       timeOneYear = config.getInt("timeOneYear", "Time Ticker", 622080000, Int.MinValue(), Int.MinValue(), I18n.format("config.timeOneYear"), "config.timeOneYear.name");
       
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