package gregtech.loaders.postload;

import bloodasp.galacticgreg.GT_Worldgenerator_Space;
import cpw.mods.fml.common.Loader;
import gregtech.GT_Mod;
import gregtech.api.GregTech_API;
import gregtech.api.enums.ConfigCategories;
import gregtech.api.enums.Materials;
import gregtech.api.util.GT_Log;
import gregtech.common.GT_Worldgen_GT_Ore_Layer;
import gregtech.common.GT_Worldgen_GT_Ore_SmallPieces;
import gregtech.common.GT_Worldgen_Stone;
import gregtech.common.GT_Worldgenerator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class GT_Worldgenloader
        implements Runnable {
    public void run() {

        new GT_Worldgenerator();

        new GT_Worldgen_Stone("overworld.stone.blackgranite.tiny", true, GregTech_API.sBlockGranites, 0, 0, 1, 75, 5, 0, 180, null, false);
        new GT_Worldgen_Stone("overworld.stone.blackgranite.small", true, GregTech_API.sBlockGranites, 0, 0, 1, 100, 10, 0, 180, null, false);
        new GT_Worldgen_Stone("overworld.stone.blackgranite.medium", true, GregTech_API.sBlockGranites, 0, 0, 1, 200, 10, 0, 180, null, false);
        new GT_Worldgen_Stone("overworld.stone.blackgranite.large", true, GregTech_API.sBlockGranites, 0, 0, 1, 300, 70, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.blackgranite.huge", true, GregTech_API.sBlockGranites, 0, 0, 1, 400, 150, 0, 120, null, false);

        new GT_Worldgen_Stone("overworld.stone.redgranite.tiny", true, GregTech_API.sBlockGranites, 8, 0, 1, 75, 5, 0, 180, null, false);
        new GT_Worldgen_Stone("overworld.stone.redgranite.small", true, GregTech_API.sBlockGranites, 8, 0, 1, 100, 10, 0, 180, null, false);
        new GT_Worldgen_Stone("overworld.stone.redgranite.medium", true, GregTech_API.sBlockGranites, 8, 0, 1, 200, 10, 0, 180, null, false);
        new GT_Worldgen_Stone("overworld.stone.redgranite.large", true, GregTech_API.sBlockGranites, 8, 0, 1, 300, 70, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.redgranite.huge", true, GregTech_API.sBlockGranites, 8, 0, 1, 400, 150, 0, 120, null, false);

        new GT_Worldgen_Stone("overworld.stone.marble.tiny", true, GregTech_API.sBlockStones, 0, 0, 1, 75, 5, 0, 180, null, false);
        new GT_Worldgen_Stone("overworld.stone.marble.small", true, GregTech_API.sBlockStones, 0, 0, 1, 100, 10, 0, 180, null, false);
        new GT_Worldgen_Stone("overworld.stone.marble.medium", true, GregTech_API.sBlockStones, 0, 0, 1, 200, 10, 0, 180, null, false);
        new GT_Worldgen_Stone("overworld.stone.marble.large", true, GregTech_API.sBlockStones, 0, 0, 1, 300, 70, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.marble.huge", true, GregTech_API.sBlockStones, 0, 0, 1, 400, 150, 0, 120, null, false);

        new GT_Worldgen_Stone("overworld.stone.basalt.tiny", true, GregTech_API.sBlockStones, 8, 0, 1, 75, 5, 0, 180, null, false);
        new GT_Worldgen_Stone("overworld.stone.basalt.small", true, GregTech_API.sBlockStones, 8, 0, 1, 100, 10, 0, 180, null, false);
        new GT_Worldgen_Stone("overworld.stone.basalt.medium", true, GregTech_API.sBlockStones, 8, 0, 1, 200, 10, 0, 180, null, false);
        new GT_Worldgen_Stone("overworld.stone.basalt.large", true, GregTech_API.sBlockStones, 8, 0, 1, 300, 70, 0, 120, null, false);
        new GT_Worldgen_Stone("overworld.stone.basalt.huge", true, GregTech_API.sBlockStones, 8, 0, 1, 400, 150, 0, 120, null, false);

        new GT_Worldgen_Stone("nether.stone.blackgranite.tiny", false, GregTech_API.sBlockGranites, 0, -1, 1, 50, 45, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.blackgranite.small", false, GregTech_API.sBlockGranites, 0, -1, 1, 100, 60, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.blackgranite.medium", false, GregTech_API.sBlockGranites, 0, -1, 1, 200, 80, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.blackgranite.large", false, GregTech_API.sBlockGranites, 0, -1, 1, 300, 70, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.blackgranite.huge", false, GregTech_API.sBlockGranites, 0, -1, 1, 400, 150, 0, 120, null, false);

        new GT_Worldgen_Stone("nether.stone.redgranite.tiny", false, GregTech_API.sBlockGranites, 8, -1, 1, 50, 45, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.redgranite.small", false, GregTech_API.sBlockGranites, 8, -1, 1, 100, 60, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.redgranite.medium", false, GregTech_API.sBlockGranites, 8, -1, 1, 200, 80, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.redgranite.large", false, GregTech_API.sBlockGranites, 8, -1, 1, 300, 70, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.redgranite.huge", false, GregTech_API.sBlockGranites, 8, -1, 1, 400, 150, 0, 120, null, false);

        new GT_Worldgen_Stone("nether.stone.marble.tiny", false, GregTech_API.sBlockStones, 0, -1, 1, 50, 45, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.marble.small", false, GregTech_API.sBlockStones, 0, -1, 1, 100, 60, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.marble.medium", false, GregTech_API.sBlockStones, 0, -1, 1, 200, 80, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.marble.large", false, GregTech_API.sBlockStones, 0, -1, 1, 300, 70, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.marble.huge", false, GregTech_API.sBlockStones, 0, -1, 1, 400, 150, 0, 120, null, false);

        new GT_Worldgen_Stone("nether.stone.basalt.tiny", false, GregTech_API.sBlockStones, 8, -1, 1, 50, 45, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.basalt.small", false, GregTech_API.sBlockStones, 8, -1, 1, 100, 60, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.basalt.medium", false, GregTech_API.sBlockStones, 8, -1, 1, 200, 80, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.basalt.large", false, GregTech_API.sBlockStones, 8, -1, 1, 300, 70, 0, 120, null, false);
        new GT_Worldgen_Stone("nether.stone.basalt.huge", false, GregTech_API.sBlockStones, 8, -1, 1, 400, 150, 0, 120, null, false);

        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.copper", true, 60, 160, 32, true, true, true, Materials.Copper);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.tin", true, 60, 160, 32, true, true, true, Materials.Tin);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.bismuth", true, 80, 120, 8, false, true, false, Materials.Bismuth);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.coal", true, 60, 100, 24, true, false, false, Materials.Coal);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.iron", true, 40, 80, 16, true, true, true, Materials.Iron);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.lead", true, 40, 80, 16, false, true, true, Materials.Lead);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.zinc", true, 30, 60, 12, true, true, true, Materials.Zinc);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.gold", true, 20, 60, 8, true, true, true, Materials.Gold);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.silver", true, 20, 60, 8, true, true, true, Materials.Silver);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.nickel", true, 20, 40, 8, true, true, true, Materials.Nickel);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.lapis", true, 20, 40, 4, true, false, false, Materials.Lapis);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.diamond", true, 5, 10, 2, true, true, false, Materials.Diamond);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.emerald", true, 5, 250, 1, false, true, false, Materials.Emerald);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.ruby", true, 5, 250, 1, false, true, false, Materials.Ruby);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.sapphire", true, 5, 250, 1, false, true, false, Materials.Sapphire);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.greensapphire", true, 5, 250, 1, false, true, false, Materials.GreenSapphire);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.olivine", true, 5, 250, 1, false, true, false, Materials.Olivine);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.topaz", true, 5, 250, 1, false, true, false, Materials.Topaz);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.tanzanite", true, 5, 250, 1, false, true, false, Materials.Tanzanite);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.amethyst", true, 5, 250, 1, false, true, false, Materials.Amethyst);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.opal", true, 5, 250, 1, false, true, false, Materials.Opal);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.bluetopaz", true, 5, 250, 1, false, true, false, Materials.BlueTopaz);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.garnetred", true, 5, 250, 1, false, true, false, Materials.GarnetRed);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.garnetyellow", true, 5, 250, 1, false, true, false, Materials.GarnetYellow);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.redstone", true, 5, 25, 8, true, true, false, Materials.Redstone);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.platinum", true, 20, 80, 8, false, false, true, Materials.Platinum);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.iridium", true, 20, 40, 8, false, false, true, Materials.Iridium);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.netherquartz", true, 30, 120, 64, false, true, false, Materials.NetherQuartz);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.saltpeter", true, 10, 60, 8, false, true, false, Materials.Saltpeter);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.sulfur_n", true, 10, 60, 32, false, true, false, Materials.Sulfur);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.sulfur_o", true, 5, 15, 8, false, false, false, Materials.Sulfur);

        //IMPACT Worldgen
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.osmium",true,10,30,8,false, false, false, Materials.Osmium);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.titanium",true,10,180,32,false, false, false, Materials.Titanium);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.meteoriciron",true,50,70,8,false, false, false, Materials.MeteoricIron);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.neutronium",true,5,15,8,false, false, false, Materials.Neutronium);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.chromite",true,20,40,8,false, false, false, Materials.Chromite);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.tungstate",true,20,40,8,false, false, false, Materials.Tungstate);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.naquadah",true,5,25,8,false, false, false, Materials.Naquadah);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.quantium",true,5,25,6,false, false, false, Materials.Quantium);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.mithril",true,5,25,6,false, false, false, Materials.Mithril);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.ledox",true,40,60,4,false, false, false, Materials.Ledox);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.oriharukon",true,20,40,6,false, false, false, Materials.Oriharukon);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.draconium",true,5,15,4,false, false, false, Materials.Draconium);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.awdraconium",true,5,15,2,false, false, false, Materials.DraconiumAwakened);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.desh",true,10,30,6,false, false, false, Materials.Desh);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.deepiron",true,5,40,8,false, false, false, Materials.DeepIron);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.graphite",true,20,120,8,false, false, false, Materials.Graphite);
        new GT_Worldgen_GT_Ore_SmallPieces("ore.small.forcicium",true,20,120,8,false, false, false, Materials.Forcicium);

        new GT_Worldgen_GT_Ore_Layer("ore.mix.naquadah", true, 10, 90, 30, 3, 32, false, false, false, Materials.Naquadah, Materials.Naquadah, Materials.Naquadah, Materials.NaquadahEnriched);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.lignite", true, 80, 210, 160, 5, 32, true, false, false, Materials.Lignite, Materials.Lignite, Materials.Lignite, Materials.Coal);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.coal", true, 30, 80, 80, 5, 32, true, false, false, Materials.Coal, Materials.Coal, Materials.Coal, Materials.Lignite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.magnetite", true, 60, 180, 160, 2, 32, true, false, false, Materials.Magnetite, Materials.Magnetite, Materials.Iron, Materials.VanadiumMagnetite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.gold", true, 30, 60, 160, 2, 32, true, false, true, Materials.Magnetite, Materials.Magnetite, Materials.VanadiumMagnetite, Materials.Gold);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.iron", true, 10, 40, 120, 2, 24, true, true, false, Materials.BrownLimonite, Materials.YellowLimonite, Materials.BandedIron, Materials.Malachite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.cassiterite", true, 60, 220, 50, 3, 24, true, false, true, Materials.Tin, Materials.Tin, Materials.Cassiterite, Materials.Tin);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.tetrahedrite", true, 80, 120, 70, 2, 24, false, true, true, Materials.Tetrahedrite, Materials.Tetrahedrite, Materials.Copper, Materials.Stibnite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.netherquartz", true, 40, 80, 80, 4, 24, false, true, false, Materials.NetherQuartz, Materials.NetherQuartz, Materials.NetherQuartz, Materials.Quartzite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.sulfur", true, 5, 20, 100, 3, 24, false, true, false, Materials.Sulfur, Materials.Sulfur, Materials.Pyrite, Materials.Sphalerite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.copper", true, 5, 60, 80, 2, 24, true, true, true, Materials.Chalcopyrite, Materials.Iron, Materials.Pyrite, Materials.Copper);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.bauxite", true, 10, 80, 80, 2, 24, false, false, false, Materials.Bauxite, Materials.Ilmenite, Materials.Aluminium, Materials.Ilmenite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.salts", true, 50, 70, 50, 2, 24, true, false, false, Materials.RockSalt, Materials.Salt, Materials.Lepidolite, Materials.Spodumene);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.redstone", true, 5, 40, 60, 2, 24, true, true, false, Materials.Redstone, Materials.Redstone, Materials.Ruby, Materials.Cinnabar);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.soapstone", true, 20, 50, 40, 2, 16, true, false, false, Materials.Soapstone, Materials.Talc, Materials.Glauconite, Materials.Pentlandite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.nickel", true, 10, 40, 40, 2, 16, true, false, true, Materials.Garnierite, Materials.Nickel, Materials.Cobaltite, Materials.Pentlandite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.platinum", true, 40, 50, 5, 2, 16, false, false, true, Materials.Cooperite, Materials.Palladium, Materials.Platinum, Materials.Iridium);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.pitchblende", true, 30, 60, 40, 2, 16, false, false, false, Materials.Pitchblende, Materials.Pitchblende, Materials.Uraninite, Materials.Uraninite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.monazite", true, 20, 40, 30, 2, 16, false, false, false, Materials.Bastnasite, Materials.Bastnasite, Materials.Monazite, Materials.Neodymium);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.molybdenum", true, 20, 50, 5, 2, 16, false, true, true, Materials.Wulfenite, Materials.Molybdenite, Materials.Molybdenum, Materials.Powellite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.tungstate", true, 20, 60, 10, 2, 16, false, false, true, Materials.Scheelite, Materials.Scheelite, Materials.Tungstate, Materials.Lithium);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.sapphire", true, 10, 40, 60, 2, 16, false, false, false, Materials.Almandine, Materials.Pyrope, Materials.Sapphire, Materials.GreenSapphire);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.manganese", true, 20, 30, 20, 2, 16, true, true, false, Materials.Grossular, Materials.Spessartine, Materials.Pyrolusite, Materials.Tantalite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.quartz", true, 80, 120, 30, 2, 16, true, true, false, Materials.Quartzite, Materials.Barite, Materials.CertusQuartz, Materials.CertusQuartz);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.diamond", true, 5, 20, 40, 1, 16, true, false, false, Materials.Graphite, Materials.Graphite, Materials.Diamond, Materials.Coal);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.olivine", true, 10, 40, 60, 2, 16, false, false, false, Materials.Bentonite, Materials.Magnesite, Materials.Olivine, Materials.Glauconite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.apatite", true, 40, 60, 60, 2, 16, true, false, false, Materials.Apatite, Materials.Apatite, Materials.Phosphorus, Materials.Pyrochlore);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.galena", true, 5, 45, 40, 4, 16, true, false, false, Materials.Galena, Materials.Galena, Materials.Silver, Materials.Lead);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.lapis", true, 20, 50, 40, 4, 16, true, false, false, Materials.Lazurite, Materials.Sodalite, Materials.Lapis, Materials.Calcite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.beryllium", true, 5, 30, 30, 2, 16, false, true, true, Materials.Beryllium, Materials.Beryllium, Materials.Emerald, Materials.Thorium);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.uranium", true, 20, 30, 20, 2, 16, false, false, false, Materials.Uraninite, Materials.Uraninite, Materials.Uranium, Materials.Uranium);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.oilsand", true, 50, 80, 40, 5, 16, true, false, false, Materials.Oilsands, Materials.Oilsands, Materials.Aluminium, Materials.Oilsands);

        //IMPACT Worldgen
        new GT_Worldgen_GT_Ore_Layer("ore.mix.platinumchrome", true, 5, 30, 10, 2, 16, false, false, false, Materials.Platinum, Materials.Chromite, Materials.Cooperite, Materials.Palladium);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.iridiumplatinum", true, 15, 40, 10, 2, 16, false, false, false, Materials.Nickel, Materials.Iridium, Materials.Palladium, Materials.Platinum);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.osmium", true, 5, 30, 10, 2, 16, false, false, false, Materials.Nickel, Materials.Osmium, Materials.Iridium, Materials.Nickel);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.desh", true, 5, 40, 30, 2, 16, false, false, false, Materials.Desh, Materials.Desh, Materials.Scheelite, Materials.Tungstate);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.uraniumeuropium", true, 10, 30, 60, 2, 24, false, false, false, Materials.Thorium, Materials.Europium, Materials.Plutonium241, Materials.Uranium235);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.antimonygiant", true, 50, 150, 100, 6, 32, false, false, false, Materials.Stibnite, Materials.Tantalite, Materials.Stibnite, Materials.Tantalite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.mithril", true, 20, 40, 40, 1, 24, false, false, false, Materials.Mithril, Materials.GarnetRed, Materials.GarnetYellow, Materials.Electrotine);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.orichalcum", true, 30, 60, 40, 2, 16, false, false, false, Materials.Orichalcum, Materials.Tanzanite, Materials.Opal, Materials.BlueTopaz);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.naqlatigon", true, 5, 15, 40, 4, 16, false, false, false, Materials.Naqlatigon, Materials.Naquadah, Materials.Pyrolusite, Materials.Ilmenite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.ledox", true, 20, 40, 20, 6, 28, false, false, false, Materials.CassiteriteSand, Materials.Ledox, Materials.Palladium, Materials.Zinc);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.coppertin", true, 80, 200, 80, 3, 24, true, false, false, Materials.Chalcopyrite, Materials.Vermiculite, Materials.Cassiterite, Materials.Alunite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.titaniumchrome", true, 10, 70, 16, 2, 16, false, false, false, Materials.Ilmenite, Materials.Chromite, Materials.Uvarovite, Materials.Perlite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.mineralsand", true, 50, 60, 80, 3, 24, true, false, false, Materials.BasalticMineralSand, Materials.GraniticMineralSand, Materials.FullersEarth, Materials.Gypsum);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.osmirinigon", true, 30, 40, 20, 2, 12, false, false, false, Materials.Cooperite, Materials.Osmirinigon, Materials.Chromite, Materials.MeteoricIron);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.infinitycatalyst", true, 35, 45, 20, 4, 24, false, false, false, Materials.MysteriousCrystal, Materials.Diamond, Materials.InfinityCatalyst, Materials.MysteriousCrystal);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.pu244u238giant", true, 60, 70, 100, 4, 12, false, false, false, Materials.Plutonium, Materials.Uranium, Materials.Plutonium, Materials.Uranium);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.tungstenirons", true, 5, 25, 16, 2, 16, false, false, false, Materials.Tungsten, Materials.Silicon, Materials.DeepIron, Materials.Andradite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.neutronium", true, 5, 30, 10, 2, 16, false, false, false, Materials.Neutronium, Materials.Adamantium, Materials.Naquadah, Materials.Titanium);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.europium", true, 30, 60, 40, 2, 16, false, false, false, Materials.Orichalcum, Materials.Tanzanite, Materials.Europium, Materials.MeteoricIron);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.quantium", true, 5, 25, 30,3, 24, false, false, false, Materials.Quantium, Materials.CosmicNeutronium, Materials.Tantalite, Materials.Desh);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.blackplutonium", true, 5, 25, 40, 2, 24, false, false, false, Materials.BlackPlutonium, Materials.GarnetRed, Materials.GarnetYellow, Materials.Infuscolium);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.garnettin", true, 50, 60, 80, 3, 24, true, false, false, Materials.CassiteriteSand, Materials.GarnetSand, Materials.Asbestos, Materials.Diatomite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.kaolinitezeolite", true, 50, 70, 60, 4, 16, true, false, false, Materials.Kaolinite, Materials.Zeolite, Materials.FullersEarth, Materials.GlauconiteSand);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.mica", true, 20, 40, 20, 2, 16, true, false, false, Materials.Kyanite, Materials.Mica, Materials.Cassiterite, Materials.Pollucite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.dolomite", true, 150, 200, 40, 4, 24, true, false, false, Materials.Dolomite, Materials.Wollastonite, Materials.Trona, Materials.Andradite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.quantiumeuropium", true, 5, 25, 30,2, 16, false, false, false, Materials.Desh, Materials.Europium, Materials.Quantium, Materials.Tantalite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.ledoxchrome", true, 20, 50, 60,6, 24, false, false, false, Materials.MeteoricIron, Materials.Ledox, Materials.Chromite, Materials.MeteoricIron);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.ilmenitetungstate", true, 5, 15, 10,10, 32, false, false, false, Materials.Tantalite, Materials.Ilmenite, Materials.Tungstate, Materials.Pyrolusite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.vanadiumgold", true, 10, 50, 60, 2, 24, false, false, false, Materials.Vanadium, Materials.Magnetite, Materials.Gold, Materials.Chrome);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.heavypentele", true, 40, 60, 60, 5, 32, false, false, false, Materials.Arsenic, Materials.Bismuth, Materials.Antimony, Materials.Antimony);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.europacore", true, 5, 15, 5, 2, 16, false, false, false, Materials.Chrome, Materials.Tungsten, Materials.Molybdenum, Materials.Manganese);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.pu241u235giant", true, 65, 75, 50, 10, 32, false, false, false, Materials.Plutonium241, Materials.Uranium235, Materials.Plutonium241, Materials.Uranium235);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.cassiteritearsenicgiant", true, 55, 65, 50, 10, 32, false, false, false, Materials.Cassiterite, Materials.Arsenic, Materials.Cassiterite, Materials.Arsenic);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.certusquartzgiant", true, 45, 55, 50, 10, 32, false, false, false, Materials.CertusQuartz, Materials.Quartzite, Materials.CertusQuartz, Materials.Quartzite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.chromegiant", true, 70, 80, 50, 10, 32, false, false, false, Materials.Chrome, Materials.Vanadium, Materials.Chrome, Materials.Vanadium);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.chrometitangiant", true, 165, 175, 50, 10, 32, false, false, false, Materials.Chromite, Materials.Titanium, Materials.Chromite, Materials.Titanium);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.cobaltboraxgiant", true, 170, 180, 100, 10, 32, false, false, false, Materials.Cobalt, Materials.Borax, Materials.Cobalt, Materials.Borax);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.copperantimonygiant", true, 180, 190, 100, 10, 32, false, false, false, Materials.Copper, Materials.Antimony, Materials.Copper, Materials.Antimony);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.diamondgiant", true, 195, 205, 100, 10, 32, false, false, false, Materials.Diamond, Materials.Bentonite, Materials.Diamond, Materials.Bentonite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.draconiumscheelitegiant", true, 140, 150, 100, 10, 32, false, false, false, Materials.Scheelite, Materials.Draconium, Materials.Scheelite, Materials.Draconium);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.enrichednaquadahgiant", true, 10, 20, 100, 10, 32, false, false, false, Materials.NaquadahEnriched, Materials.Neutronium, Materials.NaquadahEnriched, Materials.Neutronium);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.forcicium", true, 50, 100, 20, 6, 8, false, false, false, Materials.Uranium, Materials.Plutonium, Materials.Forcicium, Materials.Monazite);
        new GT_Worldgen_GT_Ore_Layer("ore.mix.lapotron", true, 5, 15, 16,2, 16, false, false, false, Materials.MysteriousCrystal, Materials.Mytryl, Materials.Amethyst, Materials.Lapotron);

        /*int i = 0;
        for (int j = GregTech_API.sWorldgenFile.get("worldgen", "AmountOfCustomSmallOreSlots", 16); i < j; i++) {
        	new GT_Worldgen_GT_Ore_SmallPieces("ore.small.custom." + (i < 10 ? "0" : "") + i, false, 0, 0, 0, false, false, false, Materials._NULL);
        }

        i = 0;
        for (int j = GregTech_API.sWorldgenFile.get("worldgen", "AmountOfCustomLargeVeinSlots", 16); i < j; i++) {
        	new GT_Worldgen_GT_Ore_Layer("ore.mix.custom." + (i < 10 ? "0" : "") + i, false, 0, 0, 0, 0, 0, false, false, false, Materials._NULL, Materials._NULL, Materials._NULL, Materials._NULL);
        }*/

        //DO NOT DELETE V THIS V - this is needed so that gregtech generates its Ore Layer's first (the ones up there), which can then be transformed into "GT_Worldgen_GT_Ore_Layer_Space". Also Reflexion is slow.
        try {
            Class clazz = Class.forName("bloodasp.galacticgreg.WorldGenGaGT");
            Constructor constructor=clazz.getConstructor();
            Method method=clazz.getMethod("run");
            method.invoke(constructor.newInstance());
            GT_Log.out.println("Started Galactic Greg ore gen code");
            //this function calls Galactic Greg and enables its generation.
        }catch (Exception e){
            GT_Log.err.println("Unable to start Galactic Greg ore gen code");
            e.printStackTrace(GT_Log.err);
        }

    }
}
