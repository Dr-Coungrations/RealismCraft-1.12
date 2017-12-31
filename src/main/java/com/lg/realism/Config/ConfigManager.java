package com.lg.realism.Config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import scala.Int;

public class ConfigManager
{
    public static Configuration config;
    public static int xTextTempBody, yTextTempBody, powerThirst;
    public static boolean thirstDebug, debugGeneration, enableFirstGenerator, enableTwoGenerator, enableThirdGenerator;
   
   public static int timeOneSec, timeOneMin, timeOneHour, timeOneDay, timeOneMonth, timeOneSeason, timeOneYear;

   public static void register(FMLPreInitializationEvent e)
   {
       config = new Configuration(e.getSuggestedConfigurationFile());
       config.load();
       timeOneSec = config.getInt("timeOneSec", "Time Ticker", 20, Int.MinValue(), Int.MaxValue(), "config.timeOneSec", "config.timeOneSec.name");
       timeOneMin = config.getInt("timeOneMin", "Time Ticker", 1200, Int.MinValue(), Int.MaxValue(), "config.timeOneMin", "config.timeOneMin.name");
       timeOneHour = config.getInt("timeOneHour", "Time Ticker", 72000, Int.MinValue(), Int.MaxValue(), "config.timeOneHour", "config.timeOneHour.name");
       timeOneDay = config.getInt("timeOneDay", "Time Ticker", 1728000, Int.MinValue(), Int.MaxValue(), "config.timeOneDay", "config.timeOneDay.name");
       timeOneMonth = config.getInt("timeOneMonth", "Time Ticker", 51840000, Int.MinValue(), Int.MaxValue(), "config.timeOneMonth", "config.timeOneMonth.name");
       timeOneSeason = config.getInt("timeOneSeason", "Time Ticker", 155520000, Int.MinValue(), Int.MaxValue(), "config.timeOneSeason", "config.timeOneSeason.name");
       timeOneYear = config.getInt("timeOneYear", "Time Ticker", 622080000, Int.MinValue(), Int.MaxValue(), "config.timeOneYear", "config.timeOneYear.name");
       
       xTextTempBody = config.getInt("xTextTempBody", "Customization", 190, Int.MinValue(), Int.MaxValue(), "config.xTextTempBody", "config.xTextTempBody.name");
       yTextTempBody = config.getInt("yTextTempBody", "Customization", 20, Int.MinValue(),  Int.MaxValue(), "config.yTextTempBody", "config.yTextTempBody.name");
       
       powerThirst = config.getInt("powerThirst", "Thirst", 240, 50, 72000, "config.powerThirst", "config.powerThirst.name");
       thirstDebug = config.getBoolean("thirstDebug", "Debug", false, "config.thirstDebug", "config.thirstDebug.name");
       debugGeneration = config.getBoolean("debugGeneration", "Debug", false, "config.debugGeneration", "config.debugGeneration.name");
       enableFirstGenerator = config.getBoolean("enableFirstGenerator", "Customization", true, "config.enableFirstGenerator", "config.enableFirstGenerator.name");
       enableTwoGenerator = config.getBoolean("enableTwoGenerator", "Customization", true, "config.enableTwoGenerator", "config.enableTwoGenerator.name");
       enableThirdGenerator = config.getBoolean("enableThirdGenerator", "Customization", true, "config.enableThirdGenerator", "config.enableThirdGenerator.name");
       config.save();
   }
}