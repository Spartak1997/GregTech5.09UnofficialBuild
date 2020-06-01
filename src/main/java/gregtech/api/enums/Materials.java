package gregtech.api.enums;

import gregtech.GT_Mod;
import gregtech.api.GregTech_API;
import gregtech.api.interfaces.IColorModulationContainer;
import gregtech.api.interfaces.IMaterialHandler;
import gregtech.api.interfaces.ISubTagContainer;
import gregtech.api.objects.GT_FluidStack;
import gregtech.api.objects.MaterialStack;
import gregtech.api.util.GT_Log;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import gregtech.loaders.materialprocessing.ProcessingConfig;
import gregtech.loaders.materialprocessing.ProcessingModSupport;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import java.util.*;

import static gregtech.api.enums.GT_Values.M;
import static gregtech.api.enums.TextureSet.*;

public class Materials implements IColorModulationContainer, ISubTagContainer {

    private static Materials[] MATERIALS_ARRAY = new Materials[]{};
    private static final Map<String, Materials> MATERIALS_MAP = new LinkedHashMap<String, Materials>();
    public static final List<IMaterialHandler> mMaterialHandlers = new ArrayList<IMaterialHandler>();

    /**
     * This is for keeping compatibility with addons mods (Such as TinkersGregworks etc) that looped over the old materials enum
     */
    @Deprecated
    public static Collection<Materials> VALUES = new LinkedHashSet<Materials>();

    /**
     * This is the Default Material returned in case no Material has been found or a NullPointer has been inserted at a location where it shouldn't happen.
     */

    /**
     * Direct Elements
     */

    public static Materials _NULL, Aluminium, Americium, Antimony, Argon, Arsenic, Barium, Beryllium, Bismuth, Boron, Caesium, Calcium, Carbon, Cadmium, Cerium, Chlorine, Chrome, Cobalt, Copper, Deuterium,
            Empty, Europium, Fluorine, Gadolinium, Gallium, Gold, Hydrogen, Helium, Helium_3, Indium, Iridium, Iron, Lanthanum, Lead, Lithium, Lutetium, Magnesium,
            Manganese, Mercury, Molybdenum, Neodymium, Neutronium, Nickel, Niobium, Nitrogen, Osmium, Oxygen, Palladium, Phosphor, Platinum, Plutonium, Plutonium241, Potassium,
            Radon, Rubidium, Samarium, Silicon, Silver, Sodium, Strontium, Sulfur, Tantalum, Tellurium, Thorium, Tin, Titanium, Tritium, Tungsten, Uranium, Uranium235,
            Vanadium, Ytterbium, Yttrium, Zinc, Organic, AnyBronze, AnyCopper, AnyIron, AnyRubber, AnySyntheticRubber, Crystal, Quartz, Metal, Unknown, Cobblestone, BrickNether,
            Adamantium, Amber, Ammonium, Andesite, Ardite, Black, Blueschist, CertusQuartz,
            ConstructionFoam, Chert, CrystalFlux, Dacite, DarkIron, Desh, Draconic, Duranium, Eclogite,
            ElectrumFlux, Emery, Enderium, EnderiumBase, Epidote, Eximite, Fluorite, FoolsRuby, Forcicium, Forcillium, Gabbro, Glowstone, Gneiss, Graphite,
            Graphene, Greenschist, Greywacke, HSLA, Infuscolium,
            Jasper, Komatiite, Lava, Limestone, Magma, MeteoricIron,
            MeteoricSteel, Meteorite, Moonstone, Naquadah, NaquadahAlloy, NaquadahEnriched, Naquadria, Nether, NetherBrick, NetherQuartz, NetherStar,
            Oilsands, Orichalcum, Phoenixite, Quartzite, Rhyolite, Sand, Siltstone, Tar, Tartarite, Tritanium, UUAmplifier, UUMatter, Void, Flux,
            Endium, Fluix, PlatinumGroupSludge, Draconium, DraconiumAwakened, RedstoneAlloy,
            Soularium, DarkSteel, ConductiveIron, ElectricalSteel, EnergeticAlloy, VibrantAlloy, PulsatingIron, Primitive, Basic, Good, Advanced, Data, Elite, Master, Ultimate, Superconductor, Infinite, Bio, Energy,
            Nano, Piko, Quantum, Antimatter, BioFuel, Biomass, CharcoalByproducts, Cheese, Chili, Chocolate, Cluster, CoalFuel, Cocoa, Coffee, Ethanol, FermentedBiomass, FishOil, Fuel, Glue, Gunpowder, FryingOilHot,
            Honey, Leather, LimePure, Lubricant, McGuffium239, MeatRaw, MeatCooked, Milk, Mud, Oil, Paper, Peat, RareEarth, Red, Reinforced, SeedOil, SeedOilHemp, SeedOilLin, Stone, TNT,
            Vinegar, Wheat, WoodGas, WoodTar, WoodVinegar, Osmiridium, Sunnarium, Endstone, Netherrack, SoulSand, Methane, CarbonDioxide, NobleGases, Air, LiquidAir, Almandine, Andradite, AnnealedCopper,
            Asbestos, Ash, BandedIron, BatteryAlloy, BlueTopaz, Bone, Brass, Bronze, BrownLimonite, Calcite, Cassiterite, CassiteriteSand, Chalcopyrite, Charcoal, Chromite, ChromiumDioxide, Cinnabar, Water, Clay, Coal,
            Cobaltite, Cooperite, Cupronickel, DarkAsh, DeepIron, Diamond, Electrum, Emerald, Galena, Garnierite, Glyceryl, GreenSapphire, Grossular, HolyWater, Ice, Ilmenite, Rutile, Bauxite,
            Titaniumtetrachloride, Magnesiumchloride, Invar, Kanthal, Lazurite, Magnalium, Magnesite, Magnetite, Molybdenite, Nichrome, NiobiumTitanium, NitroCarbon, NitrogenDioxide,
            Obsidian, Phosphate, Plastic, Epoxid, Polydimethylsiloxane, Silicone, Polycaprolactam, Polytetrafluoroethylene, Powellite, Pyrite, Pyrolusite, Pyrope, RockSalt, Rubber, RawRubber, Ruby,
            Salt, Saltpeter, SaltWater, Sapphire, Scheelite, SiliconDioxide, Snow, Sodalite, SodiumPersulfate, SodiumSulfide, HydricSulfide, OilHeavy, OilMedium, OilLight, NatruralGas, SulfuricGas, Gas, SulfuricNaphtha,
            SulfuricLightFuel, SulfuricHeavyFuel, Naphtha, LightFuel, HeavyFuel, LPG, Chlorobenzene, DilutedHydrochloricAcid, Pyrochlore, GrowthMediumRaw, GrowthMediumSterilized, FerriteMixture, NickelZincFerrite, Massicot,
            ArsenicTrioxide, CobaltOxide, Zincite, AntimonyTrioxide, CupricOxide, Ferrosilite, Magnesia, Quicklime, Potash, SodaAsh, Brick, Fireclay, BioDiesel, NitrationMixture, Creosote, Glycerol, SodiumBisulfate,
            PolyphenyleneSulfide, Dichlorobenzene, Polystyrene, Styrene, Isoprene, Tetranitromethane, Ethenone, Ethane, Propane, Butane, Butene, Butadiene, RawStyreneButadieneRubber, StyreneButadieneRubber, Toluene,
            Epichlorohydrin, PolyvinylChloride, VinylChloride, SulfurDioxide, SulfurTrioxide, NitricAcid, Dimethylhydrazine, Chloramine, Dimethylamine, DinitrogenTetroxide, NitricOxide, Ammonia, Dimethyldichlorosilane,
            Chloromethane, PhosphorousPentoxide, Tetrafluoroethylene, HydrofluoricAcid, Chloroform, BisphenolA, AceticAcid, CalciumAcetateSolution, Acetone, Methanol, CarbonMonoxide, MetalMixture, Ethylene, Propene,
            VinylAcetate, PolyvinylAcetate, MethylAcetate, AllylChloride, HydrochloricAcid, HypochlorousAcid, SodiumHydroxide, Benzene, Phenol, Cumene, PhosphoricAcid, SolderingAlloy, GalliumArsenide, IndiumGalliumPhosphide,
            Spessartine, Sphalerite, StainlessSteel, Steel, Stibnite, SulfuricAcid, Tanzanite, Tetrahedrite, TinAlloy, Topaz, Tungstate, Ultimet, Uraninite, Uvarovite, VanadiumGallium, Wood, WroughtIron, Wulfenite, YellowLimonite,
            YttriumBariumCuprate, WoodSealed, Glass, BorosilicateGlass, Perlite, Borax, Lignite, Olivine, Opal, Amethyst, Redstone, Lapis, Blaze, EnderPearl, EnderEye, Flint, Diatomite,
            HydratedCoal, Apatite, Alumite, Manyullyn, Steeleaf, RoseGold, BlackBronze, BismuthBronze, BlackSteel, RedSteel, BlueSteel, DamascusSteel,
            TungstenSteel, NitroFuel, Mithril, RedAlloy, CobaltBrass, Phosphorus, Basalt, GarnetRed, GarnetYellow, Marble, Sugar, PotassiumFeldspar,
            Biotite, GraniteBlack, GraniteRed, VanadiumMagnetite, BasalticMineralSand, GraniticMineralSand, GarnetSand, Bastnasite, Pentlandite, Spodumene, Pollucite, Tantalite, Lepidolite,
            Glauconite, GlauconiteSand, Vermiculite, Bentonite, FullersEarth, Pitchblende, Monazite, Malachite, Mirabilite, Mica, Trona, Barite, Gypsum, Alunite, Dolomite, Wollastonite, Zeolite, Kyanite, Kaolinite, Talc,
            Soapstone, Concrete, IronMagnetic, SteelMagnetic, NeodymiumMagnetic, TungstenCarbide, VanadiumSteel, HSSG, HSSE, HSSS, DilutedSulfuricAcid, EpoxidFiberReinforced, PotassiumNitrade, ChromiumTrioxide,
            Nitrochlorobenzene, Dimethylbenzene, Potassiumdichromate, PhthalicAcid, Dichlorobenzidine, Diaminobenzidin, Diphenylisophthalate, Polybenzimidazole, NitrousOxide, AntiKnock, Octane, GasolineRaw, GasolineRegular,
            GasolinePremium, Oriharukon, MysteriousCrystal, EnrichedMysteriousCrystal, Pentacadmiummagnesiumhexaoxid, Titaniumonabariumdecacoppereikosaoxid, Uraniumtriplatinid, Vanadiumtriindinid,
            Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid, Tetranaquadahdiindiumhexaplatiumosminid, Longasssuperconductornameforuvwire, Longasssuperconductornameforuhvwire, Longasssuperconductornameforuevwire,
            SuperconductorMV, SuperconductorHV, SuperconductorEV, SuperconductorIV, SuperconductorLuV, SuperconductorZPM, SuperconductorUV, SuperconductorUEV, Diamericiumtitanium, Europiumoxide, EuropiumoxideMagnetic,
            FluidNaquadahFuel, EnrichedNaquadria, FluidEnrichedNaquadahFuel, FluidNaquadriaFuel, Quantium, InfinityCatalyst, Infinity, ReinforcedGlass, BioMediumRaw, BioMediumSterilized, Bacteria, BacterialSludge,
            EnrichedBacterialSludge, Mutagen, IronIIIChloride, Lapotron, Pollution, SluiceJuice, SluiceSand, AlienOrganic, BlackPlutonium, Ledox, CosmicNeutronium, Electrotine, BlueAlloy, AlienBiomass,
            FermentedAlienBiomass, PerroxSuperLight, PerroxLight, PerroxHeavy, PerroxSuperHeavy, PerroxSuperLightCracked, PerroxLightCracked, PerroxHeavyCracked, PerroxSuperHeavyCracked, PerroxGas, PerroxGasCoolant,
            PerroxHot, PerroxPolymer, SuperCoolant, Moon, Mars, Asteroid,

            //Impact
            Zirconium,Trinium, HastelloyC276, GumMetal, Titaniolum, Zamak, Duraluminium, Inconel690,
            Nitinol, Inconel792, TiBetaC, MaragingSteel250, Talonite, Grisium, Nitinol60, Kovar, Mangalloy, MaragingSteel300,
            Stellite, Zeron100, CinobiteA243, Lafium, HastelloyN, Potin, EglinSteel, Birmabright, CokeCoal, SodiumPotassium,
            Naqlatigon, Osmirinigon, Mytryl, EnrichedTartarite, DraconiumPlasma, DraconiumAwakenedPlasma, BT6, Pikyonium64B,

            //BartWorks
            RawRadox, RadoxSuperLight, RadoxLight, RadoxHeavy, RadoxSuperHeavy, Xenoxene, DelutedXenoxene, RadoxCracked, RadoxGas, RadoxPolymerHot, RadoxPolymer,

            //Depricated
            IridiumAndSodiumOxide, Palygorskite, Adamantine, Ashes, DarkAshes, Abyssal, Adamant, Americum, Beryl, BlackGranite, CalciumCarbonate,
            CrackedLightFuel, CrackedHeavyFuel, CreosoteOil, Chromium, Diesel, Enderpearl, Endereye, EyeOfEnder, Eyeofender, Flour, Meat, Garnet, Granite, Goethite, Kalium, Lapislazuli, LapisLazuli, Monazit, Natrium,
            Mythril, NitroDiesel, Naquadriah, Obby, Peridot, Phosphorite, Quarried, Quicksilver, QuickSilver, RedRock, RefinedIron, RedGranite, Sheldonite, Soulsand, Titan, Uran, Wolframite, Wolframium, Wolfram, Nikolite,

    EndStatic;

    public static void genMaterials() {
        _NULL = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "NULL", "NULL", 0, 0, 0, 0, false, false, 1, 1, 1, Dyes._NULL, Element._NULL);
        Aluminium = new Materials(19, TextureSet.SET_DULL, 10.0F, 128, 2, 1 | 2 | 8 | 32 | 128, 128, 200, 240, 0, "Aluminium", "Aluminium", 0, 0, 933, 1700, true, false, 3, 1, 1, Dyes.dyeLightBlue, Element.Al);
        Americium = new Materials(103, TextureSet.SET_METALLIC, 1.0F, 0, 3, 1 | 2 | 32, 200, 200, 200, 0, "Americium", "Americium", 0, 0, 1449, 0, false, false, 3, 1, 1, Dyes.dyeLightGray, Element.Am);
        Antimony = new Materials(58, TextureSet.SET_SHINY, 1.0F, 0, 2, 1 | 2 | 8 | 32, 220, 220, 240, 0, "Antimony", "Antimony", 0, 0, 903, 0, false, false, 2, 1, 1, Dyes.dyeLightGray, Element.Sb);
        Argon = new Materials(24, TextureSet.SET_FLUID, 1.0F, 0, 2, 16 | 32, 0, 255, 0, 240, "Argon", "Argon", 0, 0, 83, 0, false, true, 5, 1, 1, Dyes.dyeGreen, Element.Ar);
        Arsenic = new Materials(39, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 2 | 8 | 16 | 32, 255, 255, 255, 0, "Arsenic", "Arsenic", 0, 0, 1090, 0, false, false, 3, 1, 1, Dyes.dyeOrange, Element.As);
        Barium = new Materials(63, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 32, 255, 255, 255, 0, "Barium", "Barium", 0, 0, 1000, 0, false, false, 1, 1, 1, Dyes._NULL, Element.Ba);
        Beryllium = new Materials(8, TextureSet.SET_METALLIC, 14.0F, 64, 2, 1 | 2 | 8 | 32, 100, 180, 100, 0, "Beryllium", "Beryllium", 0, 0, 1560, 0, false, false, 6, 1, 1, Dyes.dyeGreen, Element.Be);
        Bismuth = new Materials(90, TextureSet.SET_METALLIC, 6.0F, 64, 1, 1 | 2 | 8 | 32 | 128, 100, 160, 160, 0, "Bismuth", "Bismuth", 0, 0, 544, 0, false, false, 2, 1, 1, Dyes.dyeCyan, Element.Bi);
        Boron = new Materials(9, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 32, 210, 250, 210, 0, "Boron", "Boron", 0, 0, 2349, 0, false, false, 1, 1, 1, Dyes.dyeWhite, Element.B);
        Caesium = new Materials(62, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 2 | 32, 255, 255, 255, 0, "Caesium", "Caesium", 0, 0, 301, 0, false, false, 4, 1, 1, Dyes._NULL, Element.Cs);
        Calcium = new Materials(26, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 32, 255, 245, 245, 0, "Calcium", "Calcium", 0, 0, 1115, 0, false, false, 4, 1, 1, Dyes.dyePink, Element.Ca);
        Carbon = new Materials(10, TextureSet.SET_DULL, 1.0F, 64, 2, 1 | 2 | 16 | 32 | 128, 20, 20, 20, 0, "Carbon", "Carbon", 0, 0, 3800, 0, false, false, 2, 1, 1, Dyes.dyeBlack, Element.C);
        Cadmium = new Materials(55, TextureSet.SET_SHINY, 1.0F, 0, 2, 1 | 32, 50, 50, 60, 0, "Cadmium", "Cadmium", 0, 0, 594, 0, false, false, 3, 1, 1, Dyes.dyeGray, Element.Cd);
        Cerium = new Materials(65, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 2 | 32, 255, 255, 255, 0, "Cerium", "Cerium", 0, 0, 1068, 1068, true, false, 4, 1, 1, Dyes._NULL, Element.Ce);
        Chlorine = new Materials(23, TextureSet.SET_FLUID, 1.0F, 0, 2, 16 | 32, 255, 255, 255, 0, "Chlorine", "Chlorine", 0, 0, 171, 0, false, false, 2, 1, 1, Dyes.dyeCyan, Element.Cl);
        Chrome = new Materials(30, TextureSet.SET_SHINY, 11.0F, 256, 3, 1 | 2 | 8 | 32 | 128, 255, 230, 230, 0, "Chrome", "Chrome", 0, 0, 2180, 1700, true, false, 5, 1, 1, Dyes.dyePink, Element.Cr);
        Cobalt = new Materials(33, TextureSet.SET_METALLIC, 8.0F, 512, 3, 1 | 2 | 32 | 64, 80, 80, 250, 0, "Cobalt", "Cobalt", 0, 0, 1768, 0, false, false, 3, 1, 1, Dyes.dyeBlue, Element.Co);
        Copper = new Materials(35, TextureSet.SET_SHINY, 1.0F, 0, 1, 1 | 2 | 8 | 32 | 128, 255, 100, 0, 0, "Copper", "Copper", 0, 0, 1357, 0, false, false, 3, 1, 1, Dyes.dyeOrange, Element.Cu);
        Deuterium = new Materials(2, TextureSet.SET_FLUID, 1.0F, 0, 2, 16 | 32, 255, 255, 0, 240, "Deuterium", "Deuterium", 0, 0, 14, 0, false, true, 10, 1, 1, Dyes.dyeYellow, Element.D);
        Empty = new Materials(0, TextureSet.SET_NONE, 1.0F, 0, 2, 256/*Only for Prefixes which need it*/, 255, 255, 255, 255, "Empty", "Empty", 0, 0, -1, 0, false, true, 1, 1, 1, Dyes._NULL, Element._NULL);
        Europium = new Materials(70, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 2 | 8 | 32, 255, 255, 255, 0, "Europium", "Europium", 0, 0, 3200, 5600, true, false, 4, 1, 1, Dyes._NULL, Element.Eu).disableAutoGeneratedBlastFurnaceRecipes();
        Fluorine = new Materials(14, TextureSet.SET_FLUID, 1.0F, 0, 2, 16 | 32, 255, 255, 255, 127, "Fluorine", "Fluorine", 0, 0, 53, 0, false, true, 2, 1, 1, Dyes.dyeGreen, Element.F);
        Gallium = new Materials(37, TextureSet.SET_SHINY, 1.0F, 64, 2, 1 | 2 | 32, 220, 220, 255, 0, "Gallium", "Gallium", 0, 0, 302, 0, false, false, 5, 1, 1, Dyes.dyeLightGray, Element.Ga);
        Gold = new Materials(86, TextureSet.SET_SHINY, 12.0F, 64, 2, 1 | 2 | 8 | 32 | 128, 255, 255, 30, 0, "Gold", "Gold", 0, 0, 1337, 0, false, false, 4, 1, 1, Dyes.dyeYellow, Element.Au);
        Hydrogen = new Materials(1, TextureSet.SET_FLUID, 1.0F, 0, 2, 16 | 32, 0, 0, 255, 240, "Hydrogen", "Hydrogen", 1, 20, 14, 0, false, true, 2, 1, 1, Dyes.dyeBlue, Element.H);
        Helium = new Materials(4, TextureSet.SET_FLUID, 1.0F, 0, 2, 16 | 32, 255, 255, 0, 240, "Helium", "Helium", 0, 0, 1, 0, false, true, 5, 1, 1, Dyes.dyeYellow, Element.He);
        Helium_3 = new Materials(5, TextureSet.SET_FLUID, 1.0F, 0, 2, 16 | 32, 255, 255, 0, 240, "Helium_3", "Helium-3", 0, 0, 1, 0, false, true, 10, 1, 1, Dyes.dyeYellow, Element.He_3);
        Indium = new Materials(56, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 2 | 32, 64, 0, 128, 0, "Indium", "Indium", 0, 0, 429, 0, false, false, 4, 1, 1, Dyes.dyeGray, Element.In);
        Iridium = new Materials(84, TextureSet.SET_DULL, 6.0F, 2560, 3, 1 | 2 | 8 | 32 | 64 | 128, 240, 240, 245, 0, "Iridium", "Iridium", 0, 0, 2719, 2719, true, false, 10, 1, 1, Dyes.dyeWhite, Element.Ir);
        Iron = new Materials(32, TextureSet.SET_METALLIC, 6.0F, 256, 2, 1 | 2 | 8 | 32 | 64 | 128, 200, 200, 200, 0, "Iron", "Iron", 0, 0, 1811, 0, false, false, 3, 1, 1, Dyes.dyeLightGray, Element.Fe);
        Lanthanum = new Materials(64, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 2 | 32, 255, 255, 255, 0, "Lanthanum", "Lanthanum", 0, 0, 1193, 1193, true, false, 4, 1, 1, Dyes._NULL, Element.La);
        Lead = new Materials(89, TextureSet.SET_DULL, 8.0F, 64, 1, 1 | 2 | 8 | 32 | 128, 140, 100, 140, 0, "Lead", "Lead", 0, 0, 600, 0, false, false, 3, 1, 1, Dyes.dyePurple, Element.Pb);
        Lithium = new Materials(6, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 2 | 8 | 32, 225, 220, 255, 0, "Lithium", "Lithium", 0, 0, 454, 0, false, false, 4, 1, 1, Dyes.dyeLightBlue, Element.Li);
        Lutetium = new Materials(78, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 2 | 32, 255, 255, 255, 0, "Lutetium", "Lutetium", 0, 0, 1925, 1925, true, false, 4, 1, 1, Dyes._NULL, Element.Lu);
        Magnesium = new Materials(18, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 2 | 32, 255, 200, 200, 0, "Magnesium", "Magnesium", 0, 0, 923, 0, false, false, 3, 1, 1, Dyes.dyePink, Element.Mg);
        Manganese = new Materials(31, TextureSet.SET_DULL, 7.0F, 512, 2, 1 | 2 | 8 | 32, 250, 250, 250, 0, "Manganese", "Manganese", 0, 0, 1519, 0, false, false, 3, 1, 1, Dyes.dyeWhite, Element.Mn);
        Mercury = new Materials(87, TextureSet.SET_SHINY, 1.0F, 0, 0, 16 | 32, 255, 220, 220, 0, "Mercury", "Mercury", 5, 32, 234, 0, false, false, 3, 1, 1, Dyes.dyeLightGray, Element.Hg);
        Molybdenum = new Materials(48, TextureSet.SET_SHINY, 7.0F, 512, 2, 1 | 2 | 8 | 32, 180, 180, 220, 0, "Molybdenum", "Molybdenum", 0, 0, 2896, 0, false, false, 1, 1, 1, Dyes.dyeBlue, Element.Mo);
        Neodymium = new Materials(67, TextureSet.SET_METALLIC, 7.0F, 512, 2, 1 | 2 | 8 | 32 | 128, 100, 100, 100, 0, "Neodymium", "Neodymium", 0, 0, 1297, 1297, true, false, 4, 1, 1, Dyes._NULL, Element.Nd);
        Neutronium = new Materials(129, TextureSet.SET_DULL, 24.0F, 655360, 6, 1 | 2 | 8 | 32 | 64 | 128, 250, 250, 250, 0, "Neutronium", "Neutronium", 0, 0, 10000, 10000, true, false, 20, 1, 1, Dyes.dyeWhite, Element.Nt).disableAutoGeneratedBlastFurnaceRecipes();
        Nickel = new Materials(34, TextureSet.SET_METALLIC, 6.0F, 64, 2, 1 | 2 | 8 | 32 | 128, 200, 200, 250, 0, "Nickel", "Nickel", 0, 0, 1728, 0, false, false, 4, 1, 1, Dyes.dyeLightBlue, Element.Ni);
        Niobium = new Materials(47, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 2 | 32, 190, 180, 200, 0, "Niobium", "Niobium", 0, 0, 2750, 2750, true, false, 5, 1, 1, Dyes._NULL, Element.Nb);
        Nitrogen = new Materials(12, TextureSet.SET_FLUID, 1.0F, 0, 2, 16 | 32, 0, 150, 200, 240, "Nitrogen", "Nitrogen", 0, 0, 63, 0, false, true, 2, 1, 1, Dyes.dyeCyan, Element.N);
        Osmium = new Materials(83, TextureSet.SET_METALLIC, 16.0F, 1280, 4, 1 | 2 | 8 | 32 | 64 | 128, 50, 50, 255, 0, "Osmium", "Osmium", 0, 0, 3306, 4500, true, false, 10, 1, 1, Dyes.dyeBlue, Element.Os);
        Oxygen = new Materials(13, TextureSet.SET_FLUID, 1.0F, 0, 2, 16 | 32, 0, 100, 200, 240, "Oxygen", "Oxygen", 0, 0, 54, 0, false, true, 1, 1, 1, Dyes.dyeWhite, Element.O);
        Palladium = new Materials(52, TextureSet.SET_SHINY, 8.0F, 512, 2, 1 | 2 | 8 | 32 | 128, 128, 128, 128, 0, "Palladium", "Palladium", 0, 0, 1828, 1828, true, false, 4, 1, 1, Dyes.dyeGray, Element.Pd);
        Phosphor = new Materials(21, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 32, 255, 255, 0, 0, "Phosphor", "Phosphor", 0, 0, 317, 0, false, false, 2, 1, 1, Dyes.dyeYellow, Element.P);
        Platinum = new Materials(85, TextureSet.SET_SHINY, 12.0F, 64, 2, 1 | 2 | 8 | 32 | 128, 255, 255, 200, 0, "Platinum", "Platinum", 0, 0, 2041, 0, false, false, 6, 1, 1, Dyes.dyeOrange, Element.Pt);
        Plutonium = new Materials(100, TextureSet.SET_METALLIC, 6.0F, 512, 3, 1 | 2 | 8 | 32, 240, 50, 50, 0, "Plutonium", "Plutonium 239", 0, 0, 912, 0, false, false, 6, 1, 1, Dyes.dyeLime, Element.Pu);
        Plutonium241 = new Materials(101, TextureSet.SET_SHINY, 6.0F, 512, 3, 1 | 2 | 32, 250, 70, 70, 0, "Plutonium241", "Plutonium 241", 0, 0, 912, 0, false, false, 6, 1, 1, Dyes.dyeLime, Element.Pu_241);
        Potassium = new Materials(25, TextureSet.SET_METALLIC, 1.0F, 0, 1, 1 | 2 | 32, 250, 250, 250, 0, "Potassium", "Potassium", 0, 0, 336, 0, false, false, 2, 1, 1, Dyes.dyeWhite, Element.K);
        Radon = new Materials(93, TextureSet.SET_FLUID, 1.0F, 0, 2, 16 | 32, 255, 0, 255, 240, "Radon", "Radon", 0, 0, 202, 0, false, true, 5, 1, 1, Dyes.dyePurple, Element.Rn);
        Rubidium = new Materials(-1/*43*/, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 2 | 32, 240, 30, 30, 0, "Rubidium", "Rubidium", 0, 0, 312, 0, false, false, 4, 1, 1, Dyes.dyeRed, Element.Rb);
        Silicon = new Materials(20, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 2 | 8 | 32, 60, 60, 80, 0, "Silicon", "Silicon", 0, 0, 1687, 1687, false, false, 1, 1, 1, Dyes.dyeBlack, Element.Si);
        Silver = new Materials(54, TextureSet.SET_SHINY, 10.0F, 64, 2, 1 | 2 | 8 | 32 | 128, 220, 220, 255, 0, "Silver", "Silver", 0, 0, 1234, 0, false, false, 3, 1, 1, Dyes.dyeLightGray, Element.Ag);
        Sodium = new Materials(17, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 32, 0, 0, 150, 0, "Sodium", "Sodium", 0, 0, 370, 0, false, false, 1, 1, 1, Dyes.dyeBlue, Element.Na);
        Strontium = new Materials(-1/*44*/, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 32, 200, 200, 200, 0, "Strontium", "Strontium", 0, 0, 1050, 0, false, false, 1, 1, 1, Dyes.dyeLightGray, Element.Sr);
        Sulfur = new Materials(22, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8 | 32, 200, 200, 0, 0, "Sulfur", "Sulfur", 0, 0, 388, 0, false, false, 2, 1, 1, Dyes.dyeYellow, Element.S);
        Tantalum = new Materials(80, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 2 | 32, 255, 255, 255, 0, "Tantalum", "Tantalum", 0, 0, 3290, 0, false, false, 4, 1, 1, Dyes._NULL, Element.Ta);
        Tellurium = new Materials(-1/*59*/, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 2 | 32, 255, 255, 255, 0, "Tellurium", "Tellurium", 0, 0, 722, 0, false, false, 4, 1, 1, Dyes.dyeGray, Element.Te);
        Thorium = new Materials(96, TextureSet.SET_SHINY, 6.0F, 512, 2, 1 | 2 | 8 | 32, 0, 30, 0, 0, "Thorium", "Thorium", 0, 0, 2115, 0, false, false, 4, 1, 1, Dyes.dyeBlack, Element.Th);
        Tin = new Materials(57, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 2 | 8 | 32 | 128, 220, 220, 220, 0, "Tin", "Tin", 0, 0, 505, 505, false, false, 3, 1, 1, Dyes.dyeWhite, Element.Sn);
        Titanium = new Materials(28, TextureSet.SET_METALLIC, 7.0F, 1600, 3, 1 | 2 | 8 | 32 | 64 | 128, 220, 160, 240, 0, "Titanium", "Titanium", 0, 0, 1941, 1940, true, false, 5, 1, 1, Dyes.dyePurple, Element.Ti);
        Tritium = new Materials(3, TextureSet.SET_METALLIC, 1.0F, 0, 2, 16 | 32, 255, 0, 0, 240, "Tritium", "Tritium", 0, 0, 14, 0, false, true, 10, 1, 1, Dyes.dyeRed, Element.T);
        Tungsten = new Materials(81, TextureSet.SET_METALLIC, 7.0F, 2560, 3, 1 | 2 | 8 | 32 | 64 | 128, 50, 50, 50, 0, "Tungsten", "Tungsten", 0, 0, 3695, 3000, true, false, 4, 1, 1, Dyes.dyeBlack, Element.W);
        Uranium = new Materials(98, TextureSet.SET_METALLIC, 6.0F, 512, 3, 1 | 2 | 8 | 32, 50, 240, 50, 0, "Uranium", "Uranium 238", 0, 0, 1405, 0, false, false, 4, 1, 1, Dyes.dyeGreen, Element.U);
        Uranium235 = new Materials(97, TextureSet.SET_SHINY, 6.0F, 512, 3, 1 | 2 | 8 | 32, 70, 250, 70, 0, "Uranium235", "Uranium 235", 0, 0, 1405, 0, false, false, 4, 1, 1, Dyes.dyeGreen, Element.U_235);
        Vanadium = new Materials(29, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 2 | 8 | 32, 50, 50, 50, 0, "Vanadium", "Vanadium", 0, 0, 2183, 2183, true, false, 2, 1, 1, Dyes.dyeBlack, Element.V);
        Ytterbium = new Materials(-1/*77*/, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 2 | 32, 255, 255, 255, 0, "Ytterbium", "Ytterbium", 0, 0, 1097, 1097, true, false, 4, 1, 1, Dyes._NULL, Element.Yb);
        Yttrium = new Materials(45, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 2 | 32, 220, 250, 220, 0, "Yttrium", "Yttrium", 0, 0, 1799, 1799, true, false, 4, 1, 1, Dyes._NULL, Element.Y);
        Zinc = new Materials(36, TextureSet.SET_METALLIC, 1.0F, 0, 1, 1 | 2 | 8 | 32, 250, 240, 240, 0, "Zinc", "Zinc", 0, 0, 692, 0, false, false, 2, 1, 1, Dyes.dyeWhite, Element.Zn);

        /**
         * The "Random Material" ones.
         */
        Organic = new Materials(-1, TextureSet.SET_LEAF, 1.0F, 0, 1, false, "Organic", "Organic");
        AnyBronze = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 3, false, "AnyBronze", "AnyBronze");
        AnyCopper = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 3, false, "AnyCopper", "AnyCopper");
        AnyIron = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 3, false, "AnyIron", "AnyIron");
        AnyRubber = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 3, false, "AnyRubber", "AnyRubber");
        AnySyntheticRubber = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 3, false, "AnySyntheticRubber", "AnySyntheticRubber");
        Crystal = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 3, false, "Crystal", "Crystal");
        Quartz = new Materials(-1, TextureSet.SET_QUARTZ, 1.0F, 0, 2, false, "Quartz", "Quartz");
        Metal = new Materials(-1, TextureSet.SET_METALLIC, 1.0F, 0, 2, false, "Metal", "Metal");
        Unknown = new Materials(-1, TextureSet.SET_DULL, 1.0F, 0, 2, false, "Unknown", "Unknown");
        Cobblestone = new Materials(-1, TextureSet.SET_DULL, 1.0F, 0, 1, false, "Cobblestone", "Cobblestone");
        BrickNether = new Materials(-1, TextureSet.SET_DULL, 1.0F, 0, 1, false, "BrickNether", "BrickNether");

        /**
         * The "I don't care" Section, everything I don't want to do anything with right now, is right here. Just to make the Material Finder shut up about them.
         * But I do see potential uses in some of these Materials.
         */
        Flux = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Flux", "Flux", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
        Endium = new Materials(770, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 2, 165, 220, 250, 0, "Endium", "Endium", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeYellow);
        Fluix = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1 | 4, 255, 255, 255, 0, "Fluix", "Fluix", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
        PlatinumGroupSludge = new Materials(241, TextureSet.SET_POWDER, 1.0F, 0, 2, 1, 0, 30, 0, 0, "PlatinumGroupSludge", "Platinum Group Sludge", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
        Draconium = new Materials(975, TextureSet.SET_SHINY, 20.0F, 32768, 7, 1 | 2 | 8 | 64 | 128, 122, 68, 176, 0, "Draconium", "Draconium", 0, 0, 5000, 7200, true, false, 3, 1, 1, Dyes.dyePink).disableAutoGeneratedBlastFurnaceRecipes();
        DraconiumAwakened = new Materials(976, TextureSet.SET_SHINY, 40.0F, 65536, 9, 1 | 2 | 8 | 64 | 128, 244, 78, 0, 0, "DraconiumAwakened", "Awakened Draconium", 0, 0, 9000, 10000, true, false, 3, 1, 1, Dyes.dyeOrange).disableAutoGeneratedBlastFurnaceRecipes();

        //EnderIO
        RedstoneAlloy = new Materials(365, TextureSet.SET_METALLIC, 3.0F, 128, 2, 1 | 2, 181, 51, 51, 0, "RedstoneAlloy", "Redstone Alloy", 0, 0, 671, 1000, true, false, 1, 1, 1, Dyes.dyeRed).disableAutoGeneratedBlastFurnaceRecipes();
        Soularium = new Materials(366, TextureSet.SET_METALLIC, 8.0F, 256, 2, 1 | 2, 65, 46, 29, 0, "Soularium", "Soularium", 0, 0, 800, 1000, true, false, 3, 1, 1, Dyes.dyeBrown).disableAutoGeneratedBlastFurnaceRecipes();
        DarkSteel = new Materials(364, TextureSet.SET_METALLIC, 8.0F, 512, 3, 1 | 2 | 64, 80, 70, 80, 0, "DarkSteel", "Dark Steel", 0, 0, -1, 1800, true, false, 3, 1, 1, Dyes.dyePurple).disableAutoGeneratedBlastFurnaceRecipes();
        ConductiveIron = new Materials(367, TextureSet.SET_METALLIC, 6.0F, 256, 3, 1 | 2, 217, 178, 171, 0, "ConductiveIron", "Conductive Iron", 0, 0, -1, 1200, true, false, 4, 1, 1, Dyes.dyeRed).disableAutoGeneratedBlastFurnaceRecipes();
        ElectricalSteel = new Materials(368, TextureSet.SET_METALLIC, 6.0F, 512, 2, 1 | 2 | 64, 185, 185, 185, 0, "ElectricalSteel", "Electrical Steel", 0, 0, 1811, 1000, true, false, 4, 1, 1, Dyes.dyeGray).disableAutoGeneratedBlastFurnaceRecipes();
        EnergeticAlloy = new Materials(369, TextureSet.SET_METALLIC, 12.0F, 1024, 3, 1 | 2, 255, 170, 81, 0, "EnergeticAlloy", "Energetic Alloy", 0, 0, -1, 2200, true, false, 3, 1, 1, Dyes.dyeOrange).disableAutoGeneratedBlastFurnaceRecipes();
        VibrantAlloy = new Materials(378, TextureSet.SET_METALLIC, 18.0F, 4048, 4, 1 | 2 | 64, 157, 188, 53, 0, "VibrantAlloy", "Vibrant Alloy", 0, 0, 3300, 3300, true, false, 4, 1, 1, Dyes.dyeLime).disableAutoGeneratedBlastFurnaceRecipes();
        PulsatingIron = new Materials(379, TextureSet.SET_METALLIC, 6.0F, 256, 3, 1 | 2, 128, 246, 155, 0, "PulsatingIron", "Pulsating Iron", 0, 0, -1, 1800, true, false, 4, 1, 1, Dyes.dyeLime).disableAutoGeneratedBlastFurnaceRecipes();

        /**
         * Unknown Material Components. Dead End Section.
         */
        Adamantium = new Materials(319, TextureSet.SET_SHINY, 10.0F, 8192, 8, 1 | 2 | 8 | 64 | 128, 255, 255, 255, 0, "Adamantium", "Adamantium", 0, 0, 7200, 10800, true, false, 1, 1, 1, Dyes.dyeLightGray).disableAutoGeneratedBlastFurnaceRecipes();
        Amber = new Materials(514, TextureSet.SET_RUBY, 4.0F, 128, 2, 1 | 4 | 8, 255, 128, 0, 127, "Amber", "Amber", 5, 3, -1, 0, false, true, 1, 1, 1, Dyes.dyeOrange);
        Ammonium = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Ammonium", "Ammonium", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
        Andesite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Andesite", "Andesite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
        Ardite = new Materials(-1, TextureSet.SET_NONE, 6.0F, 64, 2, 1 | 2 | 8, 255, 0, 0, 0, "Ardite", "Ardite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
        Black = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 0, 0, 0, 0, 0, "Black", "Black", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeBlack);
        Blueschist = new Materials(-1/*852*/, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Blueschist", "Blueschist", 0, 0, -1, 0, false, false, 0, 1, 1, Dyes.dyeLightBlue);
        CertusQuartz = new Materials(516, TextureSet.SET_QUARTZ, 5.0F, 32, 1, 1 | 4 | 8, 210, 210, 230, 0, "CertusQuartz", "Certus Quartz", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeLightGray);
        ConstructionFoam = new Materials(854, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 16 | 128, 128, 128, 128, 0, "ConstructionFoam", "Construction Foam", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGray);
        Chert = new Materials(-1/*857*/, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Chert", "Chert", 0, 0, -1, 0, false, false, 0, 1, 1, Dyes._NULL);
        CrystalFlux = new Materials(-1, TextureSet.SET_QUARTZ, 1.0F, 0, 3, 1 | 4, 100, 50, 100, 0, "CrystalFlux", "Flux Crystal", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
        Dacite = new Materials(-1/*859*/, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Dacite", "Dacite", 0, 0, -1, 0, false, false, 0, 1, 1, Dyes.dyeLightGray);
        DarkIron = new Materials(342, TextureSet.SET_DULL, 7.0F, 384, 3, 1 | 2, 55, 40, 60, 0, "DarkIron", "Dark Iron", 0, 0, -1, 0, false, false, 5, 1, 1, Dyes.dyePurple);
        Desh = new Materials(884, TextureSet.SET_DULL, 20.0F, 2560, 4, 1 | 2 | 8 | 64 | 128, 40, 40, 40, 0, "Desh", "Desh", 0, 0, 2500, 2500, true, false, 1, 1, 1, Dyes.dyeBlack).disableAutoGeneratedBlastFurnaceRecipes();
        Draconic = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Draconic", "Draconic", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeRed);
        Duranium = new Materials(328, TextureSet.SET_METALLIC, 16.0F, 5120, 5, 1 | 2 | 64, 255, 255, 255, 0, "Duranium", "Duranium", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
        Eclogite = new Materials(-1/*860*/, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Eclogite", "Eclogite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
        ElectrumFlux = new Materials(320, TextureSet.SET_SHINY, 16.0F, 512, 3, 1 | 2, 255, 255, 120, 0, "ElectrumFlux", "Fluxed Electrum", 0, 0, 3000, 3000, true, false, 1, 1, 1, Dyes.dyeYellow).disableAutoGeneratedBlastFurnaceRecipes();
        Emery = new Materials(-1/*861*/, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Emery", "Emery", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
        Enderium = new Materials(321, TextureSet.SET_DULL, 8.0F, 1500, 3, 1 | 2 | 64 | 128, 89, 145, 135, 0, "Enderium", "Enderium", 0, 0, 4500, 4500, true, false, 1, 1, 1, Dyes.dyeGreen).disableAutoGeneratedBlastFurnaceRecipes();
        EnderiumBase = new Materials(381, TextureSet.SET_DULL, 16.0F, 768, 4, 1 | 16, 72, 119, 153, 0, "EnderiumBase", "Enderium Base", 0, 0, 3600, 3600, true, false, 1, 1, 1, Dyes.dyeGreen, 1, Arrays.asList(new MaterialStack(Tin, 2), new MaterialStack(Silver, 1), new MaterialStack(Platinum, 1)));
        Epidote = new Materials(-1/*862*/, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Epidote", "Epidote", 0, 0, -1, 0, false, false, 0, 1, 1, Dyes._NULL);
        Eximite = new Materials(-1/*959*/, TextureSet.SET_METALLIC, 5.0F, 2560, 3, 1 | 2 | 8, 124, 90, 150, 0, "Eximite", "Eximite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
        Fluorite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 2, 1, 255, 255, 255, 0, "Fluorite", "Fluorite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeGreen);
        FoolsRuby = new Materials(512, TextureSet.SET_RUBY, 1.0F, 0, 2, 1 | 4 | 8, 255, 100, 100, 127, "FoolsRuby", "Ruby", 0, 0, -1, 0, false, true, 3, 1, 1, Dyes.dyeRed);
        Forcicium = new Materials(518, TextureSet.SET_DIAMOND, 1.0F, 0, 1, 1 | 4 | 8 | 16, 50, 50, 70, 0, "Forcicium", "Forcicium", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeGreen);
        Forcillium = new Materials(-1/*519*/, TextureSet.SET_DIAMOND, 1.0F, 0, 1, 1 | 4 | 16, 50, 50, 70, 0, "Forcillium", "Forcillium", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeGreen);
        Gabbro = new Materials(863, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Gabbro", "Gabbro", 0, 0, -1, 0, false, false, 0, 1, 1, Dyes._NULL);
        Glowstone = new Materials(811, TextureSet.SET_SHINY, 1.0F, 0, 1, 1 | 16, 255, 255, 0, 0, "Glowstone", "Glowstone", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
        Gneiss = new Materials(-1/*864*/, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Gneiss", "Gneiss", 0, 0, -1, 0, false, false, 0, 1, 1, Dyes._NULL);
        Graphite = new Materials(865, TextureSet.SET_DULL, 5.0F, 32, 2, 1 | 8 | 16, 128, 128, 128, 0, "Graphite", "Graphite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeGray);
        Graphene = new Materials(819, TextureSet.SET_DULL, 6.0F, 32, 1, 1, 128, 128, 128, 0, "Graphene", "Graphene", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeGray);
        Greenschist = new Materials(866, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Greenschist", "Green Schist", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGreen);
        Greywacke = new Materials(868, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Greywacke", "Greywacke", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGray);
        HSLA = new Materials(322, TextureSet.SET_METALLIC, 6.0F, 500, 2, 1 | 2 | 128, 128, 128, 128, 0, "HSLA", "HSLA Steel", 0, 0, 1811, 1811, true, false, 3, 1, 1, Dyes._NULL);
        Infuscolium = new Materials(490, TextureSet.SET_METALLIC, 6.0F, 2680, 5, 1 | 2 | 8 | 16, 165, 165, 165, 0, "Infuscolium", "Infuscolium", 0, 0, 5000, 1000, true, false, 3, 1, 1, Dyes.dyeGray).disableAutoGeneratedBlastFurnaceRecipes();
        Jasper = new Materials(511, TextureSet.SET_EMERALD, 1.0F, 0, 2, 1 | 4, 200, 80, 80, 100, "Jasper", "Jasper", 0, 0, -1, 0, false, true, 3, 1, 1, Dyes.dyeRed);
        Komatiite = new Materials(869, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Komatiite", "Komatiite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
        Lava = new Materials(700, TextureSet.SET_FLUID, 1.0F, 0, 1, 16, 255, 64, 0, 0, "Lava", "Lava", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange);
        Limestone = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Limestone", "Limestone", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
        Magma = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 0, 255, 64, 0, 0, "Magma", "Magma", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange);
        MeteoricIron = new Materials(340, TextureSet.SET_METALLIC, 6.0F, 512, 2, 1 | 2 | 8 | 64, 100, 50, 80, 0, "MeteoricIron", "Meteoric Iron", 0, 0, 1811, 0, false, false, 1, 1, 1, Dyes.dyeGray);
        MeteoricSteel = new Materials(341, TextureSet.SET_METALLIC, 6.0F, 1280, 3, 1 | 2 | 64, 50, 25, 40, 0, "MeteoricSteel", "Meteoric Steel", 0, 0, 1811, 1000, true, false, 1, 1, 1, Dyes.dyeGray).disableAutoGeneratedBlastFurnaceRecipes();
        Meteorite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 1, 80, 35, 60, 0, "Meteorite", "Meteorite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyePurple);
        Moonstone = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 1 | 8, 255, 255, 255, 0, "Moonstone", "Moonstone", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeWhite);
        Naquadah = new Materials(324, TextureSet.SET_METALLIC, 6.0F, 1280, 4, 1 | 2 | 8 | 16, 50, 50, 50, 0, "Naquadah", "Naquadah", 0, 0, 5400, 5400, true, false, 10, 1, 1, Dyes.dyeBlack).disableAutoGeneratedBlastFurnaceRecipes();
        NaquadahAlloy = new Materials(325, TextureSet.SET_METALLIC, 8.0F, 5120, 5, 1 | 2 | 128, 40, 40, 40, 0, "NaquadahAlloy", "Naquadah Alloy", 0, 0, 7200, 7200, true, false, 10, 1, 1, Dyes.dyeBlack).disableAutoGeneratedBlastFurnaceRecipes();
        NaquadahEnriched = new Materials(326, TextureSet.SET_METALLIC, 6.0F, 1280, 4, 1 | 2 | 8 | 16, 50, 50, 50, 0, "NaquadahEnriched", "Enriched Naquadah", 0, 0, 4500, 4500, true, false, 15, 1, 1, Dyes.dyeBlack).disableAutoGeneratedBlastFurnaceRecipes();
        Naquadria = new Materials(327, TextureSet.SET_SHINY, 1.0F, 512, 4, 1 | 2 | 8 | 16, 30, 30, 30, 0, "Naquadria", "Naquadria", 0, 0, 9000, 9000, true, false, 20, 1, 1, Dyes.dyeBlack).disableAutoGeneratedBlastFurnaceRecipes();
        Nether = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 0, 255, 255, 255, 0, "Nether", "Nether", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL);
        NetherBrick = new Materials(814, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 100, 0, 0, 0, "NetherBrick", "Nether Brick", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeRed);
        NetherQuartz = new Materials(522, TextureSet.SET_QUARTZ, 1.0F, 32, 1, 1 | 4 | 8, 230, 210, 210, 0, "NetherQuartz", "Nether Quartz", 0, 0, -1, 0, false, false, 2, 1, 1, Dyes.dyeWhite);
        NetherStar = new Materials(506, TextureSet.SET_NETHERSTAR, 1.0F, 5120, 4, 1 | 4, 255, 255, 255, 0, "NetherStar", "Nether Star", 5, 50000, -1, 0, false, false, 15, 1, 1, Dyes.dyeWhite);
        Oilsands = new Materials(878, TextureSet.SET_NONE, 1.0F, 0, 1, 1 | 8, 10, 10, 10, 0, "Oilsands", "Oilsands", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
        Orichalcum = new Materials(966, TextureSet.SET_METALLIC, 4.5F, 3456, 3, 1 | 2 | 8, 84, 122, 56, 0, "Orichalcum", "Orichalcum", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
        Phoenixite = new Materials(420, TextureSet.SET_SHINY, 40.0F, 655360, 8, 1 | 2 | 16 | 64 | 128, 220, 220, 220, 0, "Phoenixite", "Phoenixite", 0, 0, -1, 0, false, false, 20, 1, 1, Dyes._NULL);
        Quartzite = new Materials(523, TextureSet.SET_QUARTZ, 1.0F, 0, 1, 1 | 4 | 8, 210, 230, 210, 0, "Quartzite", "Quartzite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeWhite, 1, Arrays.asList(new MaterialStack(Silicon, 1), new MaterialStack(Oxygen, 2)));
        Rhyolite = new Materials(-1/*875*/, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Rhyolite", "Rhyolite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
        Sand = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 0, 255, 255, 255, 0, "Sand", "Sand", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
        Siltstone = new Materials(876, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Siltstone", "Siltstone", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL);
        Tar = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 0, 10, 10, 10, 0, "Tar", "Tar", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack);
        Tartarite = new MaterialBuilder(956, TextureSet.SET_FLUID, "Tartarite").addCell().addFluid().setRGB(255, 118, 60).setColor(Dyes.dyeOrange).constructMaterial();
        Tritanium = new Materials(329, TextureSet.SET_METALLIC, 20.0F, 10240, 6, 1 | 2 | 64, 255, 255, 255, 0, "Tritanium", "Tritanium", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite);
        UUAmplifier = new Materials(721, TextureSet.SET_FLUID, 1.0F, 0, 1, 16, 96, 0, 128, 0, "UUAmplifier", "UU-Amplifier", 0, 0, -1, 0, false, false, 10, 1, 1, Dyes.dyePink);
        UUMatter = new Materials(703, TextureSet.SET_FLUID, 1.0F, 0, 1, 16, 128, 0, 196, 0, "UUMatter", "UU-Matter", 0, 0, -1, 0, false, false, 10, 1, 1, Dyes.dyePink);
        Void = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 1, 0, 255, 255, 255, 200, "Void", "Void", 0, 0, -1, 0, false, true, 1, 1, 1, Dyes._NULL);

        /**
         * Circuitry, Batteries and other Technical things
         */
        Primitive = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Primitive", "Primitive", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
        Basic = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Basic", "Basic", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
        Good = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Good", "Good", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
        Advanced = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Advanced", "Advanced", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
        Data = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Data", "Data", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
        Elite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Elite", "Elite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
        Master = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Master", "Master", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
        Ultimate = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Ultimate", "Ultimate", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
        Superconductor = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Superconductor", "Superconductor UHV", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
        Infinite = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Infinite", "Infinite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
        Bio = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Bio", "Bio", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
        Energy = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Energy", "Energy", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
        Nano = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Nano", "Nano", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
        Piko = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Piko", "Piko", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);

        /**
         * Not possible to determine exact Components
         */
        Antimatter = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Antimatter", "Antimatter", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyePink);
        BioFuel = new Materials(705, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 255, 128, 0, 0, "BioFuel", "Biofuel", 0, 6, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange);
        Biomass = new Materials(704, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 0, 255, 0, 0, "Biomass", "Biomass", 3, 8, -1, 0, false, false, 1, 1, 1, Dyes.dyeGreen);
        CharcoalByproducts = new MaterialBuilder(675, TextureSet.SET_FLUID, "Charcoal Byproducts").addCell().setRGB(120, 68, 33).setColor(Dyes.dyeBrown).constructMaterial();
        Cheese = new Materials(894, TextureSet.SET_FINE, 1.0F, 0, 0, 1, 255, 255, 0, 0, "Cheese", "Cheese", 0, 0, 320, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
        Chili = new Materials(895, TextureSet.SET_FINE, 1.0F, 0, 0, 1, 200, 0, 0, 0, "Chili", "Chili", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeRed);
        Chocolate = new Materials(886, TextureSet.SET_FINE, 1.0F, 0, 0, 1, 190, 95, 0, 0, "Chocolate", "Chocolate", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBrown);
        Cluster = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 127, "Cluster", "Cluster", 0, 0, -1, 0, false, true, 1, 1, 1, Dyes.dyeWhite);
        CoalFuel = new Materials(710, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 50, 50, 70, 0, "CoalFuel", "Coalfuel", 0, 16, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack);
        Cocoa = new Materials(887, TextureSet.SET_FINE, 1.0F, 0, 0, 1, 190, 95, 0, 0, "Cocoa", "Cocoa", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBrown);
        Coffee = new Materials(888, TextureSet.SET_FINE, 1.0F, 0, 0, 1, 150, 75, 0, 0, "Coffee", "Coffee", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBrown);
        Ethanol = new Materials(706, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 255, 128, 0, 0, "Ethanol", "Ethanol", 0, 148, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange, 1, Arrays.asList(new MaterialStack(Carbon, 2), new MaterialStack(Hydrogen, 6), new MaterialStack(Oxygen, 1)));
        FermentedBiomass = new MaterialBuilder(691, TextureSet.SET_FLUID, "Fermented Biomass").addCell().addFluid().setRGB(68, 85, 0).setColor(Dyes.dyeBrown).constructMaterial();
        FishOil = new Materials(711, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 255, 196, 0, 0, "FishOil", "Fish Oil", 3, 2, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
        Fuel = new Materials(708, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 255, 255, 0, 0, "Fuel", "Diesel", 0, 256, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
        Glue = new Materials(726, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 200, 196, 0, 0, "Glue", "Glue", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange);
        Gunpowder = new Materials(800, TextureSet.SET_DULL, 1.0F, 0, 0, 1, 128, 128, 128, 0, "Gunpowder", "Gunpowder", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGray);
        FryingOilHot = new Materials(727, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 200, 196, 0, 0, "FryingOilHot", "Hot Frying Oil", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange);
        Honey = new Materials(725, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 210, 200, 0, 0, "Honey", "Honey", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
        Leather = new Materials(-1, TextureSet.SET_ROUGH, 1.0F, 0, 0, 1, 150, 150, 80, 127, "Leather", "Leather", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange);
        LimePure = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "LimePure", "Pure Lime", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLime);
        Lubricant = new Materials(724, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 255, 196, 0, 0, "Lubricant", "Lubricant", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange);
        McGuffium239 = new Materials(999, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 200, 50, 150, 0, "McGuffium239", "Mc Guffium 239", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyePink);
        MeatRaw = new Materials(892, TextureSet.SET_FINE, 1.0F, 0, 0, 1, 255, 100, 100, 0, "MeatRaw", "Raw Meat", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyePink);
        MeatCooked = new Materials(893, TextureSet.SET_FINE, 1.0F, 0, 0, 1, 150, 60, 20, 0, "MeatCooked", "Cooked Meat", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyePink);
        Milk = new Materials(885, TextureSet.SET_FINE, 1.0F, 0, 0, 1 | 16, 254, 254, 254, 0, "Milk", "Milk", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite);
        Mud = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Mud", "Mud", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBrown);
        Oil = new Materials(707, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 10, 10, 10, 0, "Oil", "Oil", 3, 16, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack);
        Paper = new Materials(879, TextureSet.SET_PAPER, 1.0F, 0, 0, 1, 250, 250, 250, 0, "Paper", "Paper", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite);
        Peat = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Peat", "Peat", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBrown);
        //public static Materials Quantum = new Materials(-1, TextureSet.SET_NONE, 		1.0F, 0, 0, 0, 255, 255, 255, 0, "Quantum", "Quantum", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite);
        RareEarth = new Materials(891, TextureSet.SET_FINE, 1.0F, 0, 0, 1, 128, 128, 100, 0, "RareEarth", "Rare Earth", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGray);
        Red = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 0, 0, 0, "Red", "Red", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeRed);
        Reinforced = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "Reinforced", "Reinforced", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGray);
        SeedOil = new Materials(713, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 196, 255, 0, 0, "SeedOil", "Seed Oil", 3, 2, -1, 0, false, false, 1, 1, 1, Dyes.dyeLime);
        SeedOilHemp = new Materials(722, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 196, 255, 0, 0, "SeedOilHemp", "Hemp Seed Oil", 3, 2, -1, 0, false, false, 1, 1, 1, Dyes.dyeLime);
        SeedOilLin = new Materials(723, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 196, 255, 0, 0, "SeedOilLin", "Lin Seed Oil", 3, 2, -1, 0, false, false, 1, 1, 1, Dyes.dyeLime);
        Stone = new Materials(299, TextureSet.SET_ROUGH, 4.0F, 32, 1, 1 | 64 | 128, 205, 205, 205, 0, "Stone", "Stone", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
        TNT = new Materials(-1, TextureSet.SET_NONE, 1.0F, 0, 0, 0, 255, 255, 255, 0, "TNT", "TNT", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeRed);
        Vinegar = new MaterialBuilder(690, TextureSet.SET_FLUID, "Vinegar").setColor(Dyes.dyeBrown).constructMaterial();
        Wheat = new Materials(881, TextureSet.SET_POWDER, 1.0F, 0, 0, 1, 255, 255, 196, 0, "Wheat", "Wheat", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
        WoodGas = new MaterialBuilder(660, TextureSet.SET_FLUID, "Wood Gas").addCell().addGas().setRGB(222, 205, 135).setColor(Dyes.dyeBrown).setFuelType(MaterialBuilder.GAS).setFuelPower(24).constructMaterial();
        WoodTar = new MaterialBuilder(662, TextureSet.SET_FLUID, "Wood Tar").addCell().addFluid().addSemi().setRGB(40, 23, 11).setColor(Dyes.dyeBrown).setFuelType(MaterialBuilder.SEMI).setFuelPower(50).constructMaterial();
        WoodVinegar = new MaterialBuilder(661, TextureSet.SET_FLUID, "Wood Vinegar").addCell().addFluid().setRGB(212, 85, 0).setColor(Dyes.dyeBrown).constructMaterial();

        /**
         * TODO: This
         */
        Osmiridium = new Materials(317, TextureSet.SET_METALLIC, 7.0F, 1600, 3, 1 | 2 | 128, 100, 100, 255, 0, "Osmiridium", "Osmiridium", 0, 0, 3333, 2500, true, false, 1, 1, 1, Dyes.dyeLightBlue, 1, Arrays.asList(new MaterialStack(Iridium, 3), new MaterialStack(Osmium, 1))).disableAutoGeneratedBlastFurnaceRecipes();
        Sunnarium = new Materials(318, TextureSet.SET_SHINY, 1.0F, 0, 1, 1 | 2, 255, 255, 0, 0, "Sunnarium", "Sunnarium", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
        Endstone = new Materials(808, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 255, 255, 255, 0, "Endstone", "Endstone", 0, 0, -1, 0, false, false, 0, 1, 1, Dyes.dyeYellow);
        Netherrack = new Materials(807, TextureSet.SET_DULL, 1.0F, 0, 0, 1, 200, 0, 0, 0, "Netherrack", "Netherrack", 0, 0, -1, 0, false, false, 0, 1, 1, Dyes.dyeRed);
        SoulSand = new Materials(-1, TextureSet.SET_DULL, 1.0F, 0, 0, 1, 255, 255, 255, 0, "Soulsand", "Soulsand", 0, 0, -1, 0, false, false, 0, 1, 1, Dyes.dyeBrown);

        /**
         * First Degree Compounds
         */
        Methane = new Materials(715, TextureSet.SET_FLUID, 1.0F, 0, 1, 16, 255, 255, 255, 0, "Methane", "Methane", 1, 104, -1, 0, false, false, 3, 1, 1, Dyes.dyeMagenta, 1, Arrays.asList(new MaterialStack(Carbon, 1), new MaterialStack(Hydrogen, 4)));
        CarbonDioxide = new Materials(497, TextureSet.SET_FLUID, 1.0F, 0, 2, 16 | 32, 169, 208, 245, 240, "CarbonDioxide", "Carbon Dioxide", 0, 0, 25, 1, false, true, 1, 1, 1, Dyes.dyeLightBlue, 0, Arrays.asList(new MaterialStack(Carbon, 1), new MaterialStack(Oxygen, 2))).setHasCorrespondingGas(true);
        NobleGases = new Materials(496, TextureSet.SET_FLUID, 1.0F, 0, 2, 16 | 32, 169, 208, 245, 240, "NobleGases", "Noble Gases", 0, 0, 4, 0, false, true, 1, 1, 1, Dyes.dyeLightBlue, 2, Arrays.asList(new MaterialStack(CarbonDioxide, 21), new MaterialStack(Helium, 9), new MaterialStack(Methane, 3), new MaterialStack(Deuterium, 1))).setHasCorrespondingFluid(true).setLiquidTemperature(79);
        Air = new Materials(-1, TextureSet.SET_FLUID, 1.0F, 0, 2, 16 | 32, 169, 208, 245, 240, "Air", "Air", 0, 0, -1, 0, false, true, 1, 1, 1, Dyes.dyeLightBlue, 0, Arrays.asList(new MaterialStack(Nitrogen, 40), new MaterialStack(Oxygen, 11), new MaterialStack(Argon, 1), new MaterialStack(NobleGases, 1)));
        LiquidAir = new Materials(495, TextureSet.SET_FLUID, 1.0F, 0, 2, 16 | 32, 169, 208, 245, 240, "LiquidAir", "Liquid Air", 0, 0, 4, 0, false, true, 1, 1, 1, Dyes.dyeLightBlue, 2, Arrays.asList(new MaterialStack(Nitrogen, 40), new MaterialStack(Oxygen, 11), new MaterialStack(Argon, 1), new MaterialStack(NobleGases, 1))).setHasCorrespondingFluid(true).setLiquidTemperature(79);
        Almandine = new Materials(820, TextureSet.SET_ROUGH, 1.0F, 0, 1, 1 | 8, 255, 0, 0, 0, "Almandine", "Almandine", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeRed, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Iron, 3), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 12)));
        Andradite = new Materials(821, TextureSet.SET_ROUGH, 1.0F, 0, 1, 1 | 8, 150, 120, 0, 0, "Andradite", "Andradite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeYellow, 1, Arrays.asList(new MaterialStack(Calcium, 3), new MaterialStack(Iron, 2), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 12)));
        AnnealedCopper = new Materials(345, TextureSet.SET_SHINY, 1.0F, 0, 2, 1 | 2 | 128, 255, 120, 20, 0, "AnnealedCopper", "Annealed Copper", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeOrange, 2, Arrays.asList(new MaterialStack(Copper, 1)));
        Asbestos = new Materials(946, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 8, 230, 230, 230, 0, "Asbestos", "Asbestos", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 1, Arrays.asList(new MaterialStack(Magnesium, 3), new MaterialStack(Silicon, 2), new MaterialStack(Hydrogen, 4), new MaterialStack(Oxygen, 9))); // Mg3Si2O5(OH)4
        Ash = new Materials(815, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 150, 150, 150, 0, "Ash", "Ashes", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray);
        BandedIron = new Materials(917, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 145, 90, 90, 0, "BandedIron", "Banded Iron", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBrown, 1, Arrays.asList(new MaterialStack(Iron, 2), new MaterialStack(Oxygen, 3)));
        BatteryAlloy = new Materials(315, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 2, 156, 124, 160, 0, "BatteryAlloy", "Battery Alloy", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyePurple, 2, Arrays.asList(new MaterialStack(Lead, 4), new MaterialStack(Antimony, 1)));
        BlueTopaz = new Materials(513, TextureSet.SET_GEM_HORIZONTAL, 7.0F, 256, 3, 1 | 4 | 8, 0, 0, 255, 127, "BlueTopaz", "Blue Topaz", 0, 0, -1, 0, false, true, 3, 1, 1, Dyes.dyeBlue, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Silicon, 1), new MaterialStack(Fluorine, 2), new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 6)));
        Bone = new Materials(806, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 250, 250, 250, 0, "Bone", "Bone", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 0, Arrays.asList(new MaterialStack(Calcium, 1)));
        Brass = new Materials(301, TextureSet.SET_METALLIC, 7.0F, 96, 1, 1 | 2 | 128, 255, 180, 0, 0, "Brass", "Brass", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow, 2, Arrays.asList(new MaterialStack(Zinc, 1), new MaterialStack(Copper, 3)));
        Bronze = new Materials(300, TextureSet.SET_METALLIC, 6.0F, 192, 2, 1 | 2 | 64 | 128, 255, 128, 0, 0, "Bronze", "Bronze", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange, 2, Arrays.asList(new MaterialStack(Tin, 1), new MaterialStack(Copper, 3)));
        BrownLimonite = new Materials(930, TextureSet.SET_METALLIC, 1.0F, 0, 1, 1 | 8, 200, 100, 0, 0, "BrownLimonite", "Brown Limonite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBrown, 2, Arrays.asList(new MaterialStack(Iron, 1), new MaterialStack(Hydrogen, 1), new MaterialStack(Oxygen, 2))); // FeO(OH)
        Calcite = new Materials(823, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 8, 250, 230, 220, 0, "Calcite", "Calcite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange, 1, Arrays.asList(new MaterialStack(Calcium, 1), new MaterialStack(Carbon, 1), new MaterialStack(Oxygen, 3)));
        Cassiterite = new Materials(824, TextureSet.SET_METALLIC, 1.0F, 0, 1, 8, 220, 220, 220, 0, "Cassiterite", "Cassiterite", 0, 0, -1, 0, false, false, 4, 3, 1, Dyes.dyeWhite, 1, Arrays.asList(new MaterialStack(Tin, 1), new MaterialStack(Oxygen, 2)));
        CassiteriteSand = new Materials(937, TextureSet.SET_SAND, 1.0F, 0, 1, 8, 220, 220, 220, 0, "CassiteriteSand", "Cassiterite Sand", 0, 0, -1, 0, false, false, 4, 3, 1, Dyes.dyeWhite, 1, Arrays.asList(new MaterialStack(Tin, 1), new MaterialStack(Oxygen, 2)));
        Chalcopyrite = new Materials(855, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 8, 160, 120, 40, 0, "Chalcopyrite", "Chalcopyrite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow, 1, Arrays.asList(new MaterialStack(Copper, 1), new MaterialStack(Iron, 1), new MaterialStack(Sulfur, 2)));
        Charcoal = new Materials(536, TextureSet.SET_FINE, 1.0F, 0, 1, 1 | 4, 100, 70, 70, 0, "Charcoal", "Charcoal", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack, 1, Arrays.asList(new MaterialStack(Carbon, 1)));
        Chromite = new Materials(825, TextureSet.SET_METALLIC, 1.0F, 0, 1, 1 | 8, 35, 20, 15, 0, "Chromite", "Chromite", 0, 0, 1700, 1700, true, false, 6, 1, 1, Dyes.dyePink, 1, Arrays.asList(new MaterialStack(Iron, 1), new MaterialStack(Chrome, 2), new MaterialStack(Oxygen, 4)));
        ChromiumDioxide = new Materials(361, TextureSet.SET_DULL, 11.0F, 256, 3, 1 | 2, 230, 200, 200, 0, "ChromiumDioxide", "Chromium Dioxide", 0, 0, 650, 650, false, false, 5, 3, 1, Dyes.dyePink, 1, Arrays.asList(new MaterialStack(Chrome, 1), new MaterialStack(Oxygen, 2)));
        Cinnabar = new Materials(826, TextureSet.SET_ROUGH, 1.0F, 0, 1, 1 | 8, 150, 0, 0, 0, "Cinnabar", "Cinnabar", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeBrown, 2, Arrays.asList(new MaterialStack(Mercury, 1), new MaterialStack(Sulfur, 1)));
        Water = new Materials(701, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 0, 0, 255, 0, "Water", "Water", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlue, 0, Arrays.asList(new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 1)));
        Clay = new Materials(805, TextureSet.SET_ROUGH, 1.0F, 0, 1, 1, 200, 200, 220, 0, "Clay", "Clay", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeLightBlue, 1, Arrays.asList(new MaterialStack(Sodium, 2), new MaterialStack(Lithium, 1), new MaterialStack(Aluminium, 2), new MaterialStack(Silicon, 2), new MaterialStack(Water, 6)));
        Coal = new Materials(535, TextureSet.SET_ROUGH, 1.0F, 0, 1, 1 | 4 | 8, 70, 70, 70, 0, "Coal", "Coal", 0, 0, -1, 0, false, false, 2, 2, 1, Dyes.dyeBlack, 1, Arrays.asList(new MaterialStack(Carbon, 1)));
        Cobaltite = new Materials(827, TextureSet.SET_METALLIC, 1.0F, 0, 1, 1 | 8, 80, 80, 250, 0, "Cobaltite", "Cobaltite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeBlue, 1, Arrays.asList(new MaterialStack(Cobalt, 1), new MaterialStack(Arsenic, 1), new MaterialStack(Sulfur, 1)));
        Cooperite = new Materials(828, TextureSet.SET_METALLIC, 1.0F, 0, 1, 1 | 8, 255, 255, 200, 0, "Cooperite", "Sheldonite", 0, 0, -1, 0, false, false, 5, 1, 1, Dyes.dyeYellow, 2, Arrays.asList(new MaterialStack(Platinum, 3), new MaterialStack(Nickel, 1), new MaterialStack(Sulfur, 1), new MaterialStack(Palladium, 1)));
        Cupronickel = new Materials(310, TextureSet.SET_METALLIC, 6.0F, 64, 1, 1 | 2, 227, 150, 128, 0, "Cupronickel", "Cupronickel", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange, 2, Arrays.asList(new MaterialStack(Copper, 1), new MaterialStack(Nickel, 1)));
        DarkAsh = new Materials(816, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 50, 50, 50, 0, "DarkAsh", "Dark Ashes", 0, 0, -1, 0, false, false, 1, 2, 1, Dyes.dyeGray);
        DeepIron = new Materials(829, TextureSet.SET_METALLIC, 6.0F, 384, 2, 1 | 8, 150, 140, 140, 0, "DeepIron", "Deep Iron", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyePink);
        Diamond = new Materials(500, TextureSet.SET_DIAMOND, 8.0F, 1280, 3, 1 | 4 | 8 | 64 | 128, 200, 255, 255, 127, "Diamond", "Diamond", 0, 0, -1, 0, false, true, 5, 64, 1, Dyes.dyeWhite, 1, Arrays.asList(new MaterialStack(Carbon, 1)));
        Electrum = new Materials(303, TextureSet.SET_SHINY, 12.0F, 64, 2, 1 | 2 | 128, 255, 255, 100, 0, "Electrum", "Electrum", 0, 0, -1, 0, false, false, 4, 1, 1, Dyes.dyeYellow, 2, Arrays.asList(new MaterialStack(Silver, 1), new MaterialStack(Gold, 1)));
        Emerald = new Materials(501, TextureSet.SET_EMERALD, 7.0F, 256, 2, 1 | 4 | 8, 80, 255, 80, 127, "Emerald", "Emerald", 0, 0, -1, 0, false, true, 5, 1, 1, Dyes.dyeGreen, 1, Arrays.asList(new MaterialStack(Beryllium, 3), new MaterialStack(Aluminium, 2), new MaterialStack(Silicon, 6), new MaterialStack(Oxygen, 18)));
        Galena = new Materials(830, TextureSet.SET_DULL, 1.0F, 0, 3, 1 | 8, 100, 60, 100, 0, "Galena", "Galena", 0, 0, -1, 0, false, false, 4, 1, 1, Dyes.dyePurple, 1, Arrays.asList(new MaterialStack(Lead, 3), new MaterialStack(Silver, 3), new MaterialStack(Sulfur, 2)));
        Garnierite = new Materials(906, TextureSet.SET_METALLIC, 1.0F, 0, 3, 1 | 8, 50, 200, 70, 0, "Garnierite", "Garnierite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightBlue, 1, Arrays.asList(new MaterialStack(Nickel, 1), new MaterialStack(Oxygen, 1)));
        Glyceryl = new Materials(714, TextureSet.SET_FLUID, 1.0F, 0, 1, 16, 0, 150, 150, 0, "Glyceryl", "Glyceryl Trinitrate", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeCyan, 1, Arrays.asList(new MaterialStack(Carbon, 3), new MaterialStack(Hydrogen, 5), new MaterialStack(Nitrogen, 3), new MaterialStack(Oxygen, 9)));
        GreenSapphire = new Materials(504, TextureSet.SET_GEM_HORIZONTAL, 7.0F, 256, 2, 1 | 4 | 8, 100, 200, 130, 127, "GreenSapphire", "Green Sapphire", 0, 0, -1, 0, false, true, 5, 1, 1, Dyes.dyeCyan, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Oxygen, 3)));
        Grossular = new Materials(831, TextureSet.SET_ROUGH, 1.0F, 0, 1, 1 | 8, 200, 100, 0, 0, "Grossular", "Grossular", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeOrange, 1, Arrays.asList(new MaterialStack(Calcium, 3), new MaterialStack(Aluminium, 2), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 12)));
        HolyWater = new Materials(729, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 0, 0, 255, 0, "HolyWater", "Holy Water", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlue, 0, Arrays.asList(new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 1)));
        Ice = new Materials(702, TextureSet.SET_SHINY, 1.0F, 0, 0, 1 | 16, 200, 200, 255, 0, "Ice", "Ice", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlue, 0, Arrays.asList(new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 1)));
        Ilmenite = new Materials(918, TextureSet.SET_METALLIC, 1.0F, 0, 3, 1 | 8, 70, 55, 50, 0, "Ilmenite", "Ilmenite", 0, 0, -1, 0, false, false, 1, 2, 1, Dyes.dyePurple, 0, Arrays.asList(new MaterialStack(Iron, 1), new MaterialStack(Titanium, 1), new MaterialStack(Oxygen, 3)));
        Rutile = new Materials(375, TextureSet.SET_GEM_HORIZONTAL, 1.0F, 0, 2, 1, 212, 13, 92, 0, "Rutile", "Rutile", 0, 0, -1, 0, false, false, 1, 2, 1, Dyes.dyeRed, 0, Arrays.asList(new MaterialStack(Titanium, 1), new MaterialStack(Oxygen, 2)));
        Bauxite = new Materials(822, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 8, 200, 100, 0, 0, "Bauxite", "Bauxite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeBrown, 1, Arrays.asList(new MaterialStack(Rutile, 2), new MaterialStack(Aluminium, 16), new MaterialStack(Hydrogen, 10), new MaterialStack(Oxygen, 11)));
        Titaniumtetrachloride = new Materials(376, TextureSet.SET_FLUID, 1.0F, 0, 2, 16, 212, 13, 92, 0, "Titaniumtetrachloride", "Titaniumtetrachloride", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeRed, 0, Arrays.asList(new MaterialStack(Titanium, 1), new MaterialStack(Chlorine, 4)));
        Magnesiumchloride = new Materials(377, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 16, 212, 13, 92, 0, "Magnesiumchloride", "Magnesiumchloride", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeRed, 0, Arrays.asList(new MaterialStack(Magnesium, 1), new MaterialStack(Chlorine, 2)));
        Invar = new Materials(302, TextureSet.SET_METALLIC, 6.0F, 256, 2, 1 | 2 | 128, 180, 180, 120, 0, "Invar", "Invar", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBrown, 2, Arrays.asList(new MaterialStack(Iron, 2), new MaterialStack(Nickel, 1)));
        Kanthal = new Materials(312, TextureSet.SET_METALLIC, 6.0F, 64, 2, 1 | 2, 194, 210, 223, 0, "Kanthal", "Kanthal", 0, 0, 1800, 1800, true, false, 1, 1, 1, Dyes.dyeYellow, 2, Arrays.asList(new MaterialStack(Iron, 1), new MaterialStack(Aluminium, 1), new MaterialStack(Chrome, 1)));
        Lazurite = new Materials(524, TextureSet.SET_LAPIS, 1.0F, 0, 1, 1 | 4 | 8, 100, 120, 255, 0, "Lazurite", "Lazurite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeCyan, 1, Arrays.asList(new MaterialStack(Aluminium, 6), new MaterialStack(Silicon, 6), new MaterialStack(Calcium, 8), new MaterialStack(Sodium, 8)));
        Magnalium = new Materials(313, TextureSet.SET_DULL, 6.0F, 256, 2, 1 | 2 | 128, 200, 190, 255, 0, "Magnalium", "Magnalium", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightBlue, 2, Arrays.asList(new MaterialStack(Magnesium, 1), new MaterialStack(Aluminium, 2)));
        Magnesite = new Materials(908, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 8, 250, 250, 180, 0, "Magnesite", "Magnesite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyePink, 1, Arrays.asList(new MaterialStack(Magnesium, 1), new MaterialStack(Carbon, 1), new MaterialStack(Oxygen, 3)));
        Magnetite = new Materials(870, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 8, 30, 30, 30, 0, "Magnetite", "Magnetite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGray, 1, Arrays.asList(new MaterialStack(Iron, 3), new MaterialStack(Oxygen, 4)));
        Molybdenite = new Materials(942, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 8, 25, 25, 25, 0, "Molybdenite", "Molybdenite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlue, 1, Arrays.asList(new MaterialStack(Molybdenum, 1), new MaterialStack(Sulfur, 2))); // MoS2 (also source of Re)
        Nichrome = new Materials(311, TextureSet.SET_METALLIC, 6.0F, 64, 2, 1 | 2, 205, 206, 246, 0, "Nichrome", "Nichrome", 0, 0, 2700, 2700, true, false, 1, 1, 1, Dyes.dyeRed, 2, Arrays.asList(new MaterialStack(Nickel, 4), new MaterialStack(Chrome, 1)));
        NiobiumTitanium = new Materials(360, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 2, 29, 29, 41, 0, "NiobiumTitanium", "Niobium-Titanium", 0, 0, 4500, 4500, true, false, 1, 1, 1, Dyes.dyeBlack, 2, Arrays.asList(new MaterialStack(Niobium, 1), new MaterialStack(Titanium, 1))).disableAutoGeneratedBlastFurnaceRecipes();
        NitroCarbon = new Materials(716, TextureSet.SET_FLUID, 1.0F, 0, 1, 16, 0, 75, 100, 0, "NitroCarbon", "Nitro-Carbon", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeCyan, 1, Arrays.asList(new MaterialStack(Nitrogen, 1), new MaterialStack(Carbon, 1)));
        NitrogenDioxide = new Materials(717, TextureSet.SET_FLUID, 1.0F, 0, 1, 16, 100, 175, 255, 0, "NitrogenDioxide", "Nitrogen Dioxide", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeCyan, 1, Arrays.asList(new MaterialStack(Nitrogen, 1), new MaterialStack(Oxygen, 2)));
        Obsidian = new Materials(804, TextureSet.SET_DULL, 1.0F, 0, 3, 1 | 2, 80, 50, 100, 0, "Obsidian", "Obsidian", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack, 1, Arrays.asList(new MaterialStack(Magnesium, 1), new MaterialStack(Iron, 1), new MaterialStack(Silicon, 2), new MaterialStack(Oxygen, 8)));
        Phosphate = new Materials(833, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 8 | 16, 255, 255, 0, 0, "Phosphate", "Phosphate", 0, 0, -1, 0, false, false, 2, 1, 1, Dyes.dyeYellow, 1, Arrays.asList(new MaterialStack(Phosphor, 1), new MaterialStack(Oxygen, 4)));
        Plastic = new Materials(874, TextureSet.SET_DULL, 3.0F, 32, 1, 1 | 2 | 128, 200, 200, 200, 0, "Plastic", "Polyethylene", 0, 0, 400, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 0, Arrays.asList(new MaterialStack(Carbon, 1), new MaterialStack(Hydrogen, 2)));
        Epoxid = new Materials(470, TextureSet.SET_DULL, 3.0F, 32, 1, 1 | 2 | 128, 200, 140, 20, 0, "Epoxid", "Epoxy Resin", 0, 0, 400, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 0, Arrays.asList(new MaterialStack(Carbon, 2), new MaterialStack(Hydrogen, 4), new MaterialStack(Oxygen, 1)));
        Polydimethylsiloxane = new MaterialBuilder(633, TextureSet.SET_FLUID, "Polydimethylsiloxane").addDustItems().setRGB(245, 245, 245).setColor(Dyes.dyeWhite).setMaterialList(new MaterialStack(Carbon, 2), new MaterialStack(Hydrogen, 6), new MaterialStack(Oxygen, 1), new MaterialStack(Silicon, 1)).addElectrolyzerRecipe().constructMaterial();
        Silicone = new Materials(471, TextureSet.SET_DULL, 3.0F, 128, 1, 1 | 2 | 128, 220, 220, 220, 0, "Silicone", "Silicone Rubber", 0, 0, 900, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 0, Arrays.asList(new MaterialStack(Carbon, 2), new MaterialStack(Hydrogen, 6), new MaterialStack(Oxygen, 1), new MaterialStack(Silicon, 1)));
        Polycaprolactam = new Materials(472, TextureSet.SET_DULL, 3.0F, 32, 1, 1 | 2 | 128, 50, 50, 50, 0, "Polycaprolactam", "Polycaprolactam", 0, 0, 500, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 0, Arrays.asList(new MaterialStack(Carbon, 6), new MaterialStack(Hydrogen, 11), new MaterialStack(Nitrogen, 1), new MaterialStack(Oxygen, 1)));
        Polytetrafluoroethylene = new Materials(473, TextureSet.SET_DULL, 3.0F, 32, 1, 1 | 2 | 128, 100, 100, 100, 0, "Polytetrafluoroethylene", "Polytetrafluoroethylene", 0, 0, 1400, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 0, Arrays.asList(new MaterialStack(Carbon, 2), new MaterialStack(Fluorine, 4)));
        Powellite = new Materials(883, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 255, 255, 0, 0, "Powellite", "Powellite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow, 2, Arrays.asList(new MaterialStack(Calcium, 1), new MaterialStack(Molybdenum, 1), new MaterialStack(Oxygen, 4)));
        Pyrite = new Materials(834, TextureSet.SET_ROUGH, 1.0F, 0, 1, 1 | 8, 150, 120, 40, 0, "Pyrite", "Pyrite", 0, 0, -1, 0, false, false, 2, 1, 1, Dyes.dyeOrange, 1, Arrays.asList(new MaterialStack(Iron, 1), new MaterialStack(Sulfur, 2)));
        Pyrolusite = new Materials(943, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 150, 150, 170, 0, "Pyrolusite", "Pyrolusite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray, 1, Arrays.asList(new MaterialStack(Manganese, 1), new MaterialStack(Oxygen, 2)));
        Pyrope = new Materials(835, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 8, 120, 50, 100, 0, "Pyrope", "Pyrope", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyePurple, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Magnesium, 3), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 12)));
        RockSalt = new Materials(944, TextureSet.SET_FINE, 1.0F, 0, 1, 1 | 8, 240, 200, 200, 0, "RockSalt", "Rock Salt", 0, 0, -1, 0, false, false, 2, 1, 1, Dyes.dyeWhite, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Chlorine, 1)));
        Rubber = new Materials(880, TextureSet.SET_SHINY, 1.5F, 32, 0, 1 | 2 | 64 | 128, 0, 0, 0, 0, "Rubber", "Rubber", 0, 0, 400, 0, false, false, 1, 1, 1, Dyes.dyeBlack, 0, Arrays.asList(new MaterialStack(Carbon, 5), new MaterialStack(Hydrogen, 8)));
        RawRubber = new Materials(896, TextureSet.SET_DULL, 1.0F, 0, 0, 1, 204, 199, 137, 0, "RawRubber", "Raw Rubber", 0, 0, 400, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 0, Arrays.asList(new MaterialStack(Carbon, 5), new MaterialStack(Hydrogen, 8)));
        Ruby = new Materials(502, TextureSet.SET_RUBY, 7.0F, 256, 2, 1 | 4 | 8, 255, 100, 100, 127, "Ruby", "Ruby", 0, 0, -1, 0, false, true, 5, 1, 1, Dyes.dyeRed, 1, Arrays.asList(new MaterialStack(Chrome, 1), new MaterialStack(Aluminium, 2), new MaterialStack(Oxygen, 3)));
        Salt = new Materials(817, TextureSet.SET_FINE, 1.0F, 0, 1, 1 | 8, 250, 250, 250, 0, "Salt", "Salt", 0, 0, -1, 0, false, false, 2, 1, 1, Dyes.dyeWhite, 0, Arrays.asList(new MaterialStack(Sodium, 1), new MaterialStack(Chlorine, 1)));
        Saltpeter = new Materials(836, TextureSet.SET_FINE, 1.0F, 0, 1, 1 | 8, 230, 230, 230, 0, "Saltpeter", "Saltpeter", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeWhite, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Nitrogen, 1), new MaterialStack(Oxygen, 3)));
        SaltWater = new MaterialBuilder(692, TextureSet.SET_FLUID, "Salt Water").addCell().addFluid().setRGB(0, 0, 200).setColor(Dyes.dyeBlue).constructMaterial();
        Sapphire = new Materials(503, TextureSet.SET_GEM_VERTICAL, 7.0F, 256, 2, 1 | 4 | 8, 100, 100, 200, 127, "Sapphire", "Sapphire", 0, 0, -1, 0, false, true, 5, 1, 1, Dyes.dyeBlue, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Oxygen, 3)));
        Scheelite = new Materials(910, TextureSet.SET_DULL, 1.0F, 0, 3, 1 | 8, 200, 140, 20, 0, "Scheelite", "Scheelite", 0, 0, 2500, 2500, false, false, 4, 1, 1, Dyes.dyeBlack, 0, Arrays.asList(new MaterialStack(Tungsten, 1), new MaterialStack(Calcium, 2), new MaterialStack(Oxygen, 4)));
        SiliconDioxide = new Materials(837, TextureSet.SET_QUARTZ, 1.0F, 0, 1, 1 | 16, 200, 200, 200, 0, "SiliconDioxide", "Silicon Dioxide", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray, 1, Arrays.asList(new MaterialStack(Silicon, 1), new MaterialStack(Oxygen, 2)));
        Snow = new Materials(728, TextureSet.SET_FINE, 1.0F, 0, 0, 1 | 16, 250, 250, 250, 0, "Snow", "Snow", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 0, Arrays.asList(new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 1)));
        Sodalite = new Materials(525, TextureSet.SET_LAPIS, 1.0F, 0, 1, 1 | 4 | 8, 20, 20, 255, 0, "Sodalite", "Sodalite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeBlue, 1, Arrays.asList(new MaterialStack(Aluminium, 3), new MaterialStack(Silicon, 3), new MaterialStack(Sodium, 4), new MaterialStack(Chlorine, 1)));
        SodiumPersulfate = new Materials(718, TextureSet.SET_FLUID, 1.0F, 0, 2, 16, 255, 255, 255, 0, "SodiumPersulfate", "Sodium Persulfate", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange, 1, Arrays.asList(new MaterialStack(Sodium, 2), new MaterialStack(Sulfur, 2), new MaterialStack(Oxygen, 8)));
        SodiumSulfide = new Materials(719, TextureSet.SET_FLUID, 1.0F, 0, 2, 1, 255, 230, 128, 0, "SodiumSulfide", "Sodium Sulfide", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange, 1, Arrays.asList(new MaterialStack(Sodium, 2), new MaterialStack(Sulfur, 1)));
        HydricSulfide = new Materials(460, TextureSet.SET_FLUID, 1.0F, 0, 2, 16, 255, 255, 255, 0, "HydricSulfide", "Hydrogen Sulfide", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange, 0, Arrays.asList(new MaterialStack(Hydrogen, 2), new MaterialStack(Sulfur, 1)));
        OilHeavy = new Materials(730, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 10, 10, 10, 0, "OilHeavy", "Heavy Oil", 3, 32, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack);
        OilMedium = new Materials(731, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 10, 10, 10, 0, "OilMedium", "Raw Oil", 3, 24, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack);
        OilLight = new Materials(732, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 10, 10, 10, 0, "OilLight", "Light Oil", 3, 16, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack);
        NatruralGas = new Materials(733, TextureSet.SET_FLUID, 1.0F, 0, 1, 16, 255, 255, 255, 0, "NatruralGas", "Natural Gas", 1, 15, -1, 0, false, false, 3, 1, 1, Dyes.dyeWhite);
        SulfuricGas = new Materials(734, TextureSet.SET_FLUID, 1.0F, 0, 1, 16, 255, 255, 255, 0, "SulfuricGas", "Sulfuric Gas", 1, 20, -1, 0, false, false, 3, 1, 1, Dyes.dyeWhite);
        Gas = new Materials(735, TextureSet.SET_FLUID, 1.0F, 0, 1, 16, 255, 255, 255, 0, "Gas", "Refinery Gas", 1, 128, -1, 0, false, false, 3, 1, 1, Dyes.dyeWhite).setCanBeCracked(true);
        SulfuricNaphtha = new Materials(736, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 255, 255, 0, 0, "SulfuricNaphtha", "Sulfuric Naphtha", 1, 32, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
        SulfuricLightFuel = new Materials(737, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 255, 255, 0, 0, "SulfuricLightFuel", "Sulfuric Light Fuel", 0, 32, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
        SulfuricHeavyFuel = new Materials(738, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 255, 255, 0, 0, "SulfuricHeavyFuel", "Sulfuric Heavy Fuel", 3, 32, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack);
        Naphtha = new Materials(739, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 255, 255, 0, 0, "Naphtha", "Naphtha", 1, 256, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow).setCanBeCracked(true);
        LightFuel = new Materials(740, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 255, 255, 0, 0, "LightFuel", "Light Fuel", 0, 256, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow).setCanBeCracked(true);
        HeavyFuel = new Materials(741, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 255, 255, 0, 0, "HeavyFuel", "Heavy Fuel", 3, 192, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack).setCanBeCracked(true);
        LPG = new Materials(742, TextureSet.SET_FLUID, 1.0F, 0, 0, 16, 255, 255, 0, 0, "LPG", "LPG", 1, 256, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow);
        Chlorobenzene = new MaterialBuilder(605, TextureSet.SET_FLUID, "Chlorobenzene").addCell().addFluid().setRGB(0, 50, 65).setColor(Dyes.dyeGray).setMaterialList(new MaterialStack(Carbon, 6), new MaterialStack(Hydrogen, 5), new MaterialStack(Chlorine, 1)).addElectrolyzerRecipe().constructMaterial();
        DilutedHydrochloricAcid = new MaterialBuilder(606, TextureSet.SET_FLUID, "Diluted Hydrochloric Acid").setName("DilutedHydrochloricAcid_GT5U").addCell().addFluid().setRGB(153, 167, 163).setColor(Dyes.dyeLightGray).setMaterialList(new MaterialStack(Hydrogen, 1), new MaterialStack(Chlorine, 1)).constructMaterial();
        Pyrochlore = new MaterialBuilder(607, TextureSet.SET_METALLIC, "Pyrochlore").addDustItems().addOreItems().setRGB(43, 17, 0).setColor(Dyes.dyeBlack).setMaterialList(new MaterialStack(Calcium, 2), new MaterialStack(Niobium, 2), new MaterialStack(Oxygen, 7)).addElectrolyzerRecipe().constructMaterial();
        GrowthMediumRaw = new MaterialBuilder(608, TextureSet.SET_FLUID, "Raw Growth Medium").setName("GrowthMediumRaw").addCell().addFluid().setRGB(211, 141, 95).setColor(Dyes.dyeOrange).constructMaterial();
        GrowthMediumSterilized = new MaterialBuilder(609, TextureSet.SET_FLUID, "Sterilized Growth Medium").setName("GrowthMediumSterilized").addCell().addFluid().setRGB(222, 170, 135).setColor(Dyes.dyeOrange).constructMaterial();
        FerriteMixture = new MaterialBuilder(612, TextureSet.SET_METALLIC, "Ferrite Mixture").addDustItems().setRGB(180, 180, 180).setColor(Dyes.dyeGray).setMaterialList(new MaterialStack(Nickel, 1), new MaterialStack(Zinc, 1), new MaterialStack(Iron, 4)).constructMaterial();
        NickelZincFerrite = new MaterialBuilder(613, TextureSet.SET_ROUGH, "Nickel-Zinc Ferrite").addDustItems().addMetalItems().addGearItems().setToolSpeed(3.0f).setDurability(32).setRGB(60, 60, 60).setColor(Dyes.dyeBlack).setBlastFurnaceRequired(true).setBlastFurnaceTemp(1500).setMaterialList(new MaterialStack(Nickel, 1), new MaterialStack(Zinc, 1), new MaterialStack(Iron, 4), new MaterialStack(Oxygen, 8)).constructMaterial();
        Massicot = new MaterialBuilder(614, TextureSet.SET_DULL, "Massicot").addDustItems().setRGB(255, 221, 85).setColor(Dyes.dyeYellow).setMaterialList(new MaterialStack(Lead, 1), new MaterialStack(Oxygen, 1)).addElectrolyzerRecipe().constructMaterial();
        ArsenicTrioxide = new MaterialBuilder(615, TextureSet.SET_SHINY, "Arsenic Trioxide").addDustItems().setRGB(255, 255, 255).setColor(Dyes.dyeGreen).setMaterialList(new MaterialStack(Arsenic, 2), new MaterialStack(Oxygen, 3)).addElectrolyzerRecipe().constructMaterial();
        CobaltOxide = new MaterialBuilder(616, TextureSet.SET_DULL, "Cobalt Oxide").addDustItems().setRGB(102, 128, 0).setColor(Dyes.dyeGreen).setMaterialList(new MaterialStack(Cobalt, 1), new MaterialStack(Oxygen, 1)).addElectrolyzerRecipe().constructMaterial();
        Zincite = new MaterialBuilder(617, TextureSet.SET_DULL, "Zincite").addDustItems().setRGB(255, 255, 245).setColor(Dyes.dyeWhite).setMaterialList(new MaterialStack(Zinc, 1), new MaterialStack(Oxygen, 1)).addElectrolyzerRecipe().constructMaterial();
        AntimonyTrioxide = new MaterialBuilder(618, TextureSet.SET_DULL, "Antimony Trioxide").addDustItems().setRGB(230, 230, 240).setColor(Dyes.dyeWhite).setMaterialList(new MaterialStack(Antimony, 2), new MaterialStack(Oxygen, 3)).addElectrolyzerRecipe().constructMaterial();
        CupricOxide = new MaterialBuilder(619, TextureSet.SET_DULL, "Cupric Oxide").addDustItems().setRGB(15, 15, 15).setColor(Dyes.dyeBlack).setMaterialList(new MaterialStack(Copper, 1), new MaterialStack(Oxygen, 1)).addElectrolyzerRecipe().constructMaterial();
        Ferrosilite = new MaterialBuilder(620, TextureSet.SET_DULL, "Ferrosilite").addDustItems().setRGB(151, 99, 42).setColor(Dyes.dyeBrown).setMaterialList(new MaterialStack(Iron, 1), new MaterialStack(Silicon, 1), new MaterialStack(Oxygen, 3)).addElectrolyzerRecipe().constructMaterial();
        Magnesia = new MaterialBuilder(621, TextureSet.SET_DULL, "Magnesia").addDustItems().setRGB(255, 225, 225).setColor(Dyes.dyeWhite).setMaterialList(new MaterialStack(Magnesium, 1), new MaterialStack(Oxygen, 1)).addElectrolyzerRecipe().constructMaterial();
        Quicklime = new MaterialBuilder(622, TextureSet.SET_DULL, "Quicklime").addDustItems().setRGB(240, 240, 240).setColor(Dyes.dyeWhite).setMaterialList(new MaterialStack(Calcium, 1), new MaterialStack(Oxygen, 1)).addElectrolyzerRecipe().constructMaterial();
        Potash = new MaterialBuilder(623, TextureSet.SET_DULL, "Potash").addDustItems().setRGB(120, 66, 55).setColor(Dyes.dyeBrown).setMaterialList(new MaterialStack(Potassium, 2), new MaterialStack(Oxygen, 1)).addElectrolyzerRecipe().constructMaterial();
        SodaAsh = new MaterialBuilder(624, TextureSet.SET_DULL, "Soda Ash").addDustItems().setRGB(220, 220, 255).setColor(Dyes.dyeWhite).setMaterialList(new MaterialStack(Sodium, 2), new MaterialStack(Carbon, 1), new MaterialStack(Oxygen, 3)).addElectrolyzerRecipe().constructMaterial();
        Brick = new MaterialBuilder(625, TextureSet.SET_ROUGH, "Brick").addDustItems().setRGB(155, 86, 67).setColor(Dyes.dyeBrown).setMaterialList(new MaterialStack(Aluminium, 4), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 12)).constructMaterial();
        Fireclay = new MaterialBuilder(626, TextureSet.SET_ROUGH, "Fireclay").addDustItems().setRGB(173, 160, 155).setColor(Dyes.dyeBrown).setMaterialList(new MaterialStack(Brick, 1)).constructMaterial();
        BioDiesel = new MaterialBuilder(627, TextureSet.SET_FLUID, "Bio Diesel").addCell().addFluid().setRGB(255, 128, 0).setColor(Dyes.dyeOrange).setFuelType(MaterialBuilder.DIESEL).setFuelPower(192).constructMaterial();
        NitrationMixture = new MaterialBuilder(628, TextureSet.SET_FLUID, "Nitration Mixture").addCell().setRGB(230, 226, 171).setColor(Dyes.dyeBrown).constructMaterial();
        Creosote = new MaterialBuilder(712, TextureSet.SET_FLUID, "Creosot").addCell().addSemi().setRGB(128, 64, 0).setColor(Dyes.dyeBrown).setFuelType(MaterialBuilder.SEMI).setFuelPower(10).constructMaterial();
        Glycerol = new MaterialBuilder(629, TextureSet.SET_FLUID, "Glycerol").addCell().addFluid().setRGB(135, 222, 135).setColor(Dyes.dyeLime).setFuelType(MaterialBuilder.SEMIFLUID).setFuelType(164).setMaterialList(new MaterialStack(Carbon, 3), new MaterialStack(Hydrogen, 8), new MaterialStack(Oxygen, 3)).addElectrolyzerRecipe().constructMaterial();
        SodiumBisulfate = new MaterialBuilder(630, TextureSet.SET_FLUID, "Sodium Bisulfate").addDustItems().setRGB(0, 68, 85).setColor(Dyes.dyeBlue).setMaterialList(new MaterialStack(Sodium, 1), new MaterialStack(Hydrogen, 1), new MaterialStack(Sulfur, 1), new MaterialStack(Oxygen, 4)).constructMaterial();
        PolyphenyleneSulfide = new MaterialBuilder(631, TextureSet.SET_DULL, "Polyphenylene Sulfide").addDustItems().addMetalItems().addGearItems().setToolSpeed(3.0f).setDurability(32).setToolQuality(1).setRGB(170, 136, 0).setColor(Dyes.dyeBrown).setMaterialList(new MaterialStack(Carbon, 6), new MaterialStack(Hydrogen, 4), new MaterialStack(Sulfur, 1)).constructMaterial();
        Dichlorobenzene = new MaterialBuilder(632, TextureSet.SET_FLUID, "Dichlorobenzene").addCell().addFluid().setRGB(0, 68, 85).setColor(Dyes.dyeBlue).setMaterialList(new MaterialStack(Carbon, 6), new MaterialStack(Hydrogen, 4), new MaterialStack(Chlorine, 2)).addElectrolyzerRecipe().constructMaterial();
        Polystyrene = new MaterialBuilder(636, TextureSet.SET_DULL, "Polystyrene").addDustItems().addMetalItems().addToolHeadItems().addGearItems().setToolSpeed(3.0f).setDurability(32).setToolQuality(1).setRGB(190, 180, 170).setColor(Dyes.dyeLightGray).setMaterialList(new MaterialStack(Carbon, 8), new MaterialStack(Hydrogen, 8)).constructMaterial();
        Styrene = new MaterialBuilder(637, TextureSet.SET_FLUID, "Styrene").addCell().addFluid().setRGB(210, 200, 190).setColor(Dyes.dyeBlack).setMaterialList(new MaterialStack(Carbon, 8), new MaterialStack(Hydrogen, 8)).addElectrolyzerRecipe().constructMaterial();
        Isoprene = new MaterialBuilder(638, TextureSet.SET_FLUID, "Isoprene").addCell().addFluid().setRGB(20, 20, 20).setColor(Dyes.dyeBlack).setMaterialList(new MaterialStack(Carbon, 5), new MaterialStack(Hydrogen, 8)).addElectrolyzerRecipe().constructMaterial();
        Tetranitromethane = new MaterialBuilder(639, TextureSet.SET_FLUID, "Tetranitromethane").addCell().addFluid().setRGB(15, 40, 40).setColor(Dyes.dyeBlack).setMaterialList(new MaterialStack(Carbon, 1), new MaterialStack(Nitrogen, 4), new MaterialStack(Oxygen, 8)).addElectrolyzerRecipe().constructMaterial();
        Ethenone = new MaterialBuilder(641, TextureSet.SET_FLUID, "Ethenone").addCell().addGas().setRGB(20, 20, 70).setColor(Dyes.dyeBlack).setMaterialList(new MaterialStack(Carbon, 2), new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 1)).addElectrolyzerRecipe().constructMaterial();
        Ethane = new MaterialBuilder(642, TextureSet.SET_FLUID, "Ethane").addCell().addGas().setRGB(200, 200, 255).setColor(Dyes.dyeLightBlue).setFuelType(MaterialBuilder.GAS).setFuelPower(168).setMaterialList(new MaterialStack(Carbon, 2), new MaterialStack(Hydrogen, 6)).addElectrolyzerRecipe().setCanBeCracked(true).constructMaterial();
        Propane = new MaterialBuilder(643, TextureSet.SET_FLUID, "Propane").addCell().addGas().setRGB(250, 226, 80).setColor(Dyes.dyeYellow).setFuelType(MaterialBuilder.GAS).setFuelPower(232).setMaterialList(new MaterialStack(Carbon, 3), new MaterialStack(Hydrogen, 8)).addElectrolyzerRecipe().setCanBeCracked(true).constructMaterial();
        Butane = new MaterialBuilder(644, TextureSet.SET_FLUID, "Butane").addCell().addGas().setRGB(182, 55, 30).setColor(Dyes.dyeOrange).setFuelType(MaterialBuilder.GAS).setFuelPower(296).setMaterialList(new MaterialStack(Carbon, 4), new MaterialStack(Hydrogen, 10)).addElectrolyzerRecipe().setCanBeCracked(true).constructMaterial();
        Butene = new MaterialBuilder(645, TextureSet.SET_FLUID, "Butene").addCell().addGas().setRGB(207, 80, 5).setColor(Dyes.dyeOrange).setMaterialList(new MaterialStack(Carbon, 4), new MaterialStack(Hydrogen, 8)).addElectrolyzerRecipe().constructMaterial();
        Butadiene = new MaterialBuilder(646, TextureSet.SET_FLUID, "Butadiene").addCell().addGas().setRGB(232, 105, 0).setColor(Dyes.dyeOrange).setMaterialList(new MaterialStack(Carbon, 4), new MaterialStack(Hydrogen, 6)).addElectrolyzerRecipe().constructMaterial();
        RawStyreneButadieneRubber = new MaterialBuilder(634, TextureSet.SET_SHINY, "Raw Styrene-Butadiene Rubber").addDustItems().setRGB(84, 64, 61).setColor(Dyes.dyeGray).setMaterialList(new MaterialStack(Styrene, 1), new MaterialStack(Butadiene, 3)).constructMaterial();
        StyreneButadieneRubber = new MaterialBuilder(635, TextureSet.SET_SHINY, "Styrene-Butadiene Rubber").addDustItems().addMetalItems().addToolHeadItems().addGearItems().setToolSpeed(3.0f).setDurability(128).setToolQuality(1).setRGB(33, 26, 24).setColor(Dyes.dyeBlack).setMaterialList(new MaterialStack(Styrene, 1), new MaterialStack(Butadiene, 3)).constructMaterial();
        Toluene = new MaterialBuilder(647, TextureSet.SET_FLUID, "Toluene").addCell().setRGB(80, 29, 5).setColor(Dyes.dyeBrown).setFuelType(MaterialBuilder.GAS).setFuelPower(328).setMaterialList(new MaterialStack(Carbon, 7), new MaterialStack(Hydrogen, 8)).addElectrolyzerRecipe().constructMaterial();
        Epichlorohydrin = new MaterialBuilder(648, TextureSet.SET_FLUID, "Epichlorohydrin").addCell().setRGB(80, 29, 5).setColor(Dyes.dyeBrown).setMaterialList(new MaterialStack(Carbon, 3), new MaterialStack(Hydrogen, 5), new MaterialStack(Chlorine, 1), new MaterialStack(Oxygen, 1)).addElectrolyzerRecipe().constructMaterial();
        PolyvinylChloride = new MaterialBuilder(649, TextureSet.SET_DULL, "Polyvinyl Chloride").addDustItems().addMetalItems().addToolHeadItems().addGearItems().setToolSpeed(3.0f).setDurability(32).setToolQuality(1).setRGB(215, 230, 230).setColor(Dyes.dyeLightGray).setMaterialList(new MaterialStack(Carbon, 2), new MaterialStack(Hydrogen, 3), new MaterialStack(Chlorine, 1)).constructMaterial();
        VinylChloride = new MaterialBuilder(650, TextureSet.SET_FLUID, "Vinyl Chloride").addCell().addGas().setRGB(225, 240, 240).setColor(Dyes.dyeLightGray).setMaterialList(new MaterialStack(Carbon, 2), new MaterialStack(Hydrogen, 3), new MaterialStack(Chlorine, 1)).addElectrolyzerRecipe().constructMaterial();
        SulfurDioxide = new MaterialBuilder(651, TextureSet.SET_FLUID, "Sulfur Dioxide").addCell().addGas().setRGB(200, 200, 25).setColor(Dyes.dyeYellow).setMaterialList(new MaterialStack(Sulfur, 1), new MaterialStack(Oxygen, 2)).constructMaterial();
        SulfurTrioxide = new MaterialBuilder(652, TextureSet.SET_FLUID, "Sulfur Trioxide").addCell().addGas().setGasTemperature(344).setRGB(160, 160, 20).setColor(Dyes.dyeYellow).setMaterialList(new MaterialStack(Sulfur, 1), new MaterialStack(Oxygen, 3)).addElectrolyzerRecipe().constructMaterial();
        NitricAcid = new MaterialBuilder(653, TextureSet.SET_FLUID, "Nitric Acid").addCell().setRGB(230, 226, 171).setMaterialList(new MaterialStack(Hydrogen, 1), new MaterialStack(Nitrogen, 1), new MaterialStack(Oxygen, 3)).addElectrolyzerRecipe().constructMaterial();
        Dimethylhydrazine = new MaterialBuilder(654, TextureSet.SET_FLUID, "1,1-Dimethylhydrazine").addCell().addFluid().setRGB(0, 0, 85).setColor(Dyes.dyeBlue).setMaterialList(new MaterialStack(Carbon, 2), new MaterialStack(Hydrogen, 8), new MaterialStack(Nitrogen, 2)).addElectrolyzerRecipe().constructMaterial();
        Chloramine = new MaterialBuilder(655, TextureSet.SET_FLUID, "Chloramine").addCell().addFluid().setRGB(63, 159, 128).setColor(Dyes.dyeCyan).setMaterialList(new MaterialStack(Nitrogen, 1), new MaterialStack(Hydrogen, 2), new MaterialStack(Chlorine, 1)).addElectrolyzerRecipe().constructMaterial();
        Dimethylamine = new MaterialBuilder(656, TextureSet.SET_FLUID, "Dimethylamine").addCell().addGas().setRGB(85, 68, 105).setColor(Dyes.dyeGray).setMaterialList(new MaterialStack(Carbon, 2), new MaterialStack(Hydrogen, 7), new MaterialStack(Nitrogen, 1)).addElectrolyzerRecipe().constructMaterial();
        DinitrogenTetroxide = new MaterialBuilder(657, TextureSet.SET_FLUID, "Dinitrogen Tetroxide").addCell().addGas().setRGB(0, 65, 132).setColor(Dyes.dyeBlue).setMaterialList(new MaterialStack(Nitrogen, 2), new MaterialStack(Oxygen, 4)).addElectrolyzerRecipe().constructMaterial();
        NitricOxide = new MaterialBuilder(658, TextureSet.SET_FLUID, "Nitric Oxide").addCell().addGas().setRGB(125, 200, 240).setColor(Dyes.dyeCyan).setMaterialList(new MaterialStack(Nitrogen, 1), new MaterialStack(Oxygen, 1)).addElectrolyzerRecipe().constructMaterial();
        Ammonia = new MaterialBuilder(659, TextureSet.SET_FLUID, "Ammonia").addCell().addGas().setRGB(63, 52, 128).setColor(Dyes.dyeBlue).setMaterialList(new MaterialStack(Nitrogen, 1), new MaterialStack(Hydrogen, 3)).addElectrolyzerRecipe().constructMaterial();
        Dimethyldichlorosilane = new MaterialBuilder(663, TextureSet.SET_FLUID, "Dimethyldichlorosilane").addCell().addFluid().setRGB(68, 22, 80).setColor(Dyes.dyePurple).setMaterialList(new MaterialStack(Carbon, 2), new MaterialStack(Hydrogen, 6), new MaterialStack(Chlorine, 2), new MaterialStack(Silicon, 1)).addElectrolyzerRecipe().constructMaterial();
        Chloromethane = new MaterialBuilder(664, TextureSet.SET_FLUID, "Chloromethane").addCell().addGas().setRGB(200, 44, 160).setColor(Dyes.dyeMagenta).setMaterialList(new MaterialStack(Carbon, 1), new MaterialStack(Hydrogen, 3), new MaterialStack(Chlorine, 1)).addElectrolyzerRecipe().constructMaterial();
        PhosphorousPentoxide = new MaterialBuilder(665, TextureSet.SET_FLUID, "Phosphorous Pentoxide").addCell().addDustItems().setRGB(220, 220, 0).setColor(Dyes.dyeYellow).setMaterialList(new MaterialStack(Phosphor, 4), new MaterialStack(Oxygen, 10)).addElectrolyzerRecipe().constructMaterial();
        Tetrafluoroethylene = new MaterialBuilder(666, TextureSet.SET_FLUID, "Tetrafluoroethylene").addCell().addGas().setRGB(125, 125, 125).setColor(Dyes.dyeGray).setMaterialList(new MaterialStack(Carbon, 2), new MaterialStack(Fluorine, 4)).constructMaterial();
        HydrofluoricAcid = new MaterialBuilder(667, TextureSet.SET_FLUID, "Hydrofluoric Acid").setName("HydrofluoricAcid_GT5U").addCell().addFluid().setRGB(0, 136, 170).setColor(Dyes.dyeLightBlue).setMaterialList(new MaterialStack(Hydrogen, 1), new MaterialStack(Fluorine, 1)).addElectrolyzerRecipe().constructMaterial();
        Chloroform = new MaterialBuilder(668, TextureSet.SET_FLUID, "Chloroform").addCell().addFluid().setRGB(137, 44, 160).setColor(Dyes.dyePurple).setMaterialList(new MaterialStack(Carbon, 1), new MaterialStack(Hydrogen, 1), new MaterialStack(Chlorine, 3)).addElectrolyzerRecipe().constructMaterial();
        BisphenolA = new MaterialBuilder(669, TextureSet.SET_FLUID, "Bisphenol A").addCell().setRGB(212, 170, 0).setColor(Dyes.dyeBrown).setMaterialList(new MaterialStack(Carbon, 15), new MaterialStack(Hydrogen, 16), new MaterialStack(Oxygen, 2)).constructMaterial();
        AceticAcid = new MaterialBuilder(670, TextureSet.SET_FLUID, "Acetic Acid").addCell().addFluid().setRGB(200, 180, 160).setColor(Dyes.dyeWhite).setMaterialList(new MaterialStack(Carbon, 2), new MaterialStack(Hydrogen, 4), new MaterialStack(Oxygen, 2)).addElectrolyzerRecipe().constructMaterial();
        CalciumAcetateSolution = new MaterialBuilder(671, TextureSet.SET_RUBY, "Calcium Acetate Solution").addCell().addFluid().setRGB(220, 200, 180).setColor(Dyes.dyeCyan).setMaterialList(new MaterialStack(Calcium, 1), new MaterialStack(Carbon, 2), new MaterialStack(Oxygen, 4), new MaterialStack(Hydrogen, 6)).addElectrolyzerRecipe().constructMaterial();
        Acetone = new MaterialBuilder(672, TextureSet.SET_FLUID, "Acetone").addCell().addFluid().setRGB(175, 175, 175).setColor(Dyes.dyeWhite).setMaterialList(new MaterialStack(Carbon, 3), new MaterialStack(Hydrogen, 6), new MaterialStack(Oxygen, 1)).addElectrolyzerRecipe().constructMaterial();
        Methanol = new MaterialBuilder(673, TextureSet.SET_FLUID, "Methanol").addCell().addFluid().setRGB(170, 136, 0).setColor(Dyes.dyeBrown).setFuelPower(32).setMaterialList(new MaterialStack(Carbon, 1), new MaterialStack(Hydrogen, 4), new MaterialStack(Oxygen, 1)).addElectrolyzerRecipe().constructMaterial();
        CarbonMonoxide = new MaterialBuilder(674, TextureSet.SET_FLUID, "Carbon Monoxide").addCell().addGas().setRGB(14, 72, 128).setColor(Dyes.dyeBrown).setFuelType(MaterialBuilder.GAS).setFuelPower(24).setMaterialList(new MaterialStack(Carbon, 1), new MaterialStack(Oxygen, 1)).addElectrolyzerRecipe().constructMaterial();
        MetalMixture = new MaterialBuilder(676, TextureSet.SET_METALLIC, "Metal Mixture").addDustItems().setRGB(80, 45, 22).setColor(Dyes.dyeBrown).constructMaterial();
        Ethylene = new MaterialBuilder(677, TextureSet.SET_FLUID, "Ethylene").addCell().addGas().setRGB(225, 225, 225).setColor(Dyes.dyeWhite).setMaterialList(new MaterialStack(Carbon, 2), new MaterialStack(Hydrogen, 4)).addElectrolyzerRecipe().constructMaterial();
        Propene = new MaterialBuilder(678, TextureSet.SET_FLUID, "Propene").addCell().addGas().setRGB(255, 221, 85).setColor(Dyes.dyeYellow).setMaterialList(new MaterialStack(Carbon, 3), new MaterialStack(Hydrogen, 6)).addElectrolyzerRecipe().constructMaterial();
        VinylAcetate = new MaterialBuilder(679, TextureSet.SET_FLUID, "Vinyl Acetate").addCell().addFluid().setRGB(255, 179, 128).setColor(Dyes.dyeOrange).setMaterialList(new MaterialStack(Carbon, 4), new MaterialStack(Hydrogen, 6), new MaterialStack(Oxygen, 2)).addElectrolyzerRecipe().constructMaterial();
        PolyvinylAcetate = new MaterialBuilder(680, TextureSet.SET_FLUID, "Polyvinyl Acetate").addCell().addFluid().setRGB(255, 153, 85).setColor(Dyes.dyeOrange).setMaterialList(new MaterialStack(Carbon, 4), new MaterialStack(Hydrogen, 6), new MaterialStack(Oxygen, 2)).constructMaterial();
        MethylAcetate = new MaterialBuilder(681, TextureSet.SET_FLUID, "Methyl Acetate").addCell().addFluid().setRGB(238, 198, 175).setColor(Dyes.dyeOrange).setMaterialList(new MaterialStack(Carbon, 3), new MaterialStack(Hydrogen, 6), new MaterialStack(Oxygen, 2)).addElectrolyzerRecipe().constructMaterial();
        AllylChloride = new MaterialBuilder(682, TextureSet.SET_FLUID, "Allyl Chloride").addCell().addFluid().setRGB(135, 222, 170).setColor(Dyes.dyeCyan).setMaterialList(new MaterialStack(Carbon, 3), new MaterialStack(Hydrogen, 5), new MaterialStack(Chlorine, 1)).addElectrolyzerRecipe().constructMaterial();
        HydrochloricAcid = new MaterialBuilder(683, TextureSet.SET_FLUID, "Hydrochloric Acid").setName("HydrochloricAcid_GT5U").addCell().addFluid().setRGB(183, 200, 196).setColor(Dyes.dyeLightGray).setMaterialList(new MaterialStack(Hydrogen, 1), new MaterialStack(Chlorine, 1)).constructMaterial();
        HypochlorousAcid = new MaterialBuilder(684, TextureSet.SET_FLUID, "Hypochlorous Acid").addCell().addFluid().setRGB(111, 138, 145).setColor(Dyes.dyeGray).setMaterialList(new MaterialStack(Hydrogen, 1), new MaterialStack(Chlorine, 1), new MaterialStack(Oxygen, 1)).addElectrolyzerRecipe().constructMaterial();
        SodiumHydroxide = new MaterialBuilder(685, TextureSet.SET_DULL, "Sodium Hydroxide").setName("SodiumHydroxide_GT5U").addDustItems().setRGB(0, 51, 128).setColor(Dyes.dyeBlue).setMaterialList(new MaterialStack(Sodium, 1), new MaterialStack(Oxygen, 1), new MaterialStack(Hydrogen, 1)).addElectrolyzerRecipe().constructMaterial();
        Benzene = new MaterialBuilder(686, TextureSet.SET_FLUID, "Benzene").addCell().addFluid().setRGB(26, 26, 26).setColor(Dyes.dyeGray).setFuelType(MaterialBuilder.GAS).setFuelPower(288).setMaterialList(new MaterialStack(Carbon, 6), new MaterialStack(Hydrogen, 6)).addElectrolyzerRecipe().constructMaterial();
        Phenol = new MaterialBuilder(687, TextureSet.SET_FLUID, "Phenol").addCell().addFluid().setRGB(120, 68, 33).setColor(Dyes.dyeBrown).setFuelType(MaterialBuilder.GAS).setFuelPower(288).setMaterialList(new MaterialStack(Carbon, 6), new MaterialStack(Hydrogen, 6), new MaterialStack(Oxygen, 1)).addElectrolyzerRecipe().constructMaterial();
        Cumene = new MaterialBuilder(688, TextureSet.SET_FLUID, "Cumene").addCell().addFluid().setRGB(85, 34, 0).setColor(Dyes.dyeBrown).setMaterialList(new MaterialStack(Carbon, 9), new MaterialStack(Hydrogen, 12)).constructMaterial();
        PhosphoricAcid = new MaterialBuilder(689, TextureSet.SET_FLUID, "Phosphoric Acid").setName("PhosphoricAcid_GT5U").addCell().addFluid().setRGB(220, 220, 0).setColor(Dyes.dyeYellow).setMaterialList(new MaterialStack(Hydrogen, 3), new MaterialStack(Phosphor, 1), new MaterialStack(Oxygen, 4)).addElectrolyzerRecipe().constructMaterial();

        SolderingAlloy = new Materials(314, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 2, 220, 220, 230, 0, "SolderingAlloy", "Soldering Alloy", 0, 0, 400, 400, false, false, 1, 1, 1, Dyes.dyeWhite, 2, Arrays.asList(new MaterialStack(Tin, 6), new MaterialStack(Lead, 3), new MaterialStack(Antimony, 1)));
        GalliumArsenide = new Materials(980, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 2, 160, 160, 160, 0, "GalliumArsenide", "Gallium Arsenide", 0, 0, -1, 1200, true, false, 1, 1, 1, Dyes.dyeGray, 2, Arrays.asList(new MaterialStack(Arsenic, 1), new MaterialStack(Gallium, 1)));
        IndiumGalliumPhosphide = new Materials(981, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 2, 160, 140, 190, 0, "IndiumGalliumPhosphide", "Indium Gallium Phosphide", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLightGray, 2, Arrays.asList(new MaterialStack(Indium, 1), new MaterialStack(Gallium, 1), new MaterialStack(Phosphor, 1)));
        Spessartine = new Materials(838, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 255, 100, 100, 0, "Spessartine", "Spessartine", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeRed, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Manganese, 3), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 12)));
        Sphalerite = new Materials(839, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 8, 255, 255, 255, 0, "Sphalerite", "Sphalerite", 0, 0, -1, 0, false, false, 2, 1, 1, Dyes.dyeYellow, 1, Arrays.asList(new MaterialStack(Zinc, 1), new MaterialStack(Sulfur, 1)));
        StainlessSteel = new Materials(306, TextureSet.SET_SHINY, 7.0F, 480, 2, 1 | 2 | 64 | 128, 200, 200, 220, 0, "StainlessSteel", "Stainless Steel", 0, 0, -1, 1700, true, false, 1, 1, 1, Dyes.dyeWhite, 1, Arrays.asList(new MaterialStack(Iron, 6), new MaterialStack(Chrome, 1), new MaterialStack(Manganese, 1), new MaterialStack(Nickel, 1))).disableAutoGeneratedBlastFurnaceRecipes();
        Steel = new Materials(305, TextureSet.SET_METALLIC, 6.0F, 512, 3, 1 | 2 | 64 | 128, 128, 128, 128, 0, "Steel", "Steel", 0, 0, 1811, 1000, true, false, 4, 51, 50, Dyes.dyeGray, 1, Arrays.asList(new MaterialStack(Iron, 50), new MaterialStack(Carbon, 1)));
        Stibnite = new Materials(945, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 8, 70, 70, 70, 0, "Stibnite", "Stibnite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 2, Arrays.asList(new MaterialStack(Antimony, 2), new MaterialStack(Sulfur, 3)));
        SulfuricAcid = new Materials(720, TextureSet.SET_FLUID, 1.0F, 0, 2, 16, 255, 128, 0, 0, "SulfuricAcid", "Sulfuric Acid", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange, 1, Arrays.asList(new MaterialStack(Hydrogen, 2), new MaterialStack(Sulfur, 1), new MaterialStack(Oxygen, 4)));
        Tanzanite = new Materials(508, TextureSet.SET_GEM_VERTICAL, 7.0F, 256, 2, 1 | 4 | 8, 64, 0, 200, 127, "Tanzanite", "Tanzanite", 0, 0, -1, 0, false, true, 5, 1, 1, Dyes.dyePurple, 1, Arrays.asList(new MaterialStack(Calcium, 2), new MaterialStack(Aluminium, 3), new MaterialStack(Silicon, 3), new MaterialStack(Hydrogen, 1), new MaterialStack(Oxygen, 13)));
        Tetrahedrite = new Materials(840, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 200, 32, 0, 0, "Tetrahedrite", "Tetrahedrite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeRed, 2, Arrays.asList(new MaterialStack(Copper, 3), new MaterialStack(Antimony, 1), new MaterialStack(Sulfur, 3), new MaterialStack(Iron, 1))); //Cu3SbS3 + x(Fe, Zn)6Sb2S9
        TinAlloy = new Materials(363, TextureSet.SET_METALLIC, 6.5F, 96, 2, 1 | 2 | 128, 200, 200, 200, 0, "TinAlloy", "Tin Alloy", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 2, Arrays.asList(new MaterialStack(Tin, 1), new MaterialStack(Iron, 1)));
        Topaz = new Materials(507, TextureSet.SET_GEM_HORIZONTAL, 7.0F, 256, 3, 1 | 4 | 8, 255, 128, 0, 127, "Topaz", "Topaz", 0, 0, -1, 0, false, true, 5, 1, 1, Dyes.dyeOrange, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Silicon, 1), new MaterialStack(Fluorine, 2), new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 6)));
        Tungstate = new Materials(841, TextureSet.SET_DULL, 1.0F, 0, 3, 1 | 8, 55, 50, 35, 0, "Tungstate", "Tungstate", 0, 0, 2500, 2500, true, false, 4, 1, 1, Dyes.dyeBlack, 0, Arrays.asList(new MaterialStack(Tungsten, 1), new MaterialStack(Lithium, 2), new MaterialStack(Oxygen, 4)));
        Ultimet = new Materials(344, TextureSet.SET_SHINY, 9.0F, 2048, 4, 1 | 2 | 64 | 128, 180, 180, 230, 0, "Ultimet", "Ultimet", 0, 0, 2700, 2700, true, false, 1, 1, 1, Dyes.dyeLightBlue, 1, Arrays.asList(new MaterialStack(Cobalt, 5), new MaterialStack(Chrome, 2), new MaterialStack(Nickel, 1), new MaterialStack(Molybdenum, 1))); // 54% Cobalt, 26% Chromium, 9% Nickel, 5% Molybdenum, 3% Iron, 2% Tungsten, 0.8% Manganese, 0.3% Silicon, 0.08% Nitrogen and 0.06% Carbon
        Uraninite = new Materials(922, TextureSet.SET_METALLIC, 1.0F, 0, 3, 1 | 8, 35, 35, 35, 0, "Uraninite", "Uraninite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeLime, 2, Arrays.asList(new MaterialStack(Uranium, 1), new MaterialStack(Oxygen, 2)));
        Uvarovite = new Materials(842, TextureSet.SET_DIAMOND, 1.0F, 0, 2, 1, 180, 255, 180, 0, "Uvarovite", "Uvarovite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeGreen, 1, Arrays.asList(new MaterialStack(Calcium, 3), new MaterialStack(Chrome, 2), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 12)));
        VanadiumGallium = new Materials(357, TextureSet.SET_SHINY, 1.0F, 0, 2, 1 | 2, 128, 128, 140, 0, "VanadiumGallium", "Vanadium-Gallium", 0, 0, 4500, 4500, true, false, 1, 1, 1, Dyes.dyeGray, 2, Arrays.asList(new MaterialStack(Vanadium, 3), new MaterialStack(Gallium, 1)));
        Wood = new Materials(809, TextureSet.SET_WOOD, 2.0F, 16, 0, 1 | 2 | 64 | 128, 100, 50, 0, 0, "Wood", "Wood", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBrown, 0, Arrays.asList(new MaterialStack(Carbon, 1), new MaterialStack(Oxygen, 1), new MaterialStack(Hydrogen, 1)));
        WroughtIron = new Materials(304, TextureSet.SET_METALLIC, 6.0F, 384, 2, 1 | 2 | 64 | 128, 200, 180, 180, 0, "WroughtIron", "Wrought Iron", 0, 0, 1811, 0, false, false, 3, 1, 1, Dyes.dyeLightGray, 2, Arrays.asList(new MaterialStack(Iron, 1)));
        Wulfenite = new Materials(882, TextureSet.SET_DULL, 1.0F, 0, 3, 1 | 8, 255, 128, 0, 0, "Wulfenite", "Wulfenite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange, 2, Arrays.asList(new MaterialStack(Lead, 1), new MaterialStack(Molybdenum, 1), new MaterialStack(Oxygen, 4)));
        YellowLimonite = new Materials(931, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 8, 200, 200, 0, 0, "YellowLimonite", "Yellow Limonite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeYellow, 2, Arrays.asList(new MaterialStack(Iron, 1), new MaterialStack(Hydrogen, 1), new MaterialStack(Oxygen, 2))); // FeO(OH) + a bit Ni and Co
        YttriumBariumCuprate = new Materials(358, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 2, 80, 64, 70, 0, "YttriumBariumCuprate", "Yttrium Barium Cuprate", 0, 0, 4500, 4500, true, false, 1, 1, 1, Dyes.dyeGray, 0, Arrays.asList(new MaterialStack(Yttrium, 1), new MaterialStack(Barium, 2), new MaterialStack(Copper, 3), new MaterialStack(Oxygen, 7)));

        /**
         * Second Degree Compounds
         */
        WoodSealed = new Materials(889, TextureSet.SET_WOOD, 3.0F, 24, 0, 1 | 2 | 128, 80, 40, 0, 0, "WoodSealed", "Sealed Wood", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBrown, 0, Arrays.asList(new MaterialStack(Wood, 1)));
        Glass = new Materials(890, TextureSet.SET_GLASS, 1.0F, 4, 0, 1 | 4, 250, 250, 250, 220, "Glass", "Glass", 0, 0, 1500, 0, false, true, 1, 1, 1, Dyes.dyeWhite, 2, Arrays.asList(new MaterialStack(SiliconDioxide, 1)));
        BorosilicateGlass = new MaterialBuilder(611, TextureSet.SET_GLASS, "Borosilicate Glass").addDustItems().addMetalItems().setRGB(230, 243, 230).setColor(Dyes.dyeWhite).setMaterialList(new MaterialStack(Boron, 1), new MaterialStack(Glass, 7)).addCentrifugeRecipe().constructMaterial();
        Perlite = new Materials(925, TextureSet.SET_DULL, 1.0F, 0, 1, 1, 30, 20, 30, 0, "Perlite", "Perlite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack, 2, Arrays.asList(new MaterialStack(Obsidian, 2), new MaterialStack(Water, 1)));
        Borax = new Materials(941, TextureSet.SET_FINE, 1.0F, 0, 1, 1 | 8, 250, 250, 250, 0, "Borax", "Borax", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 1, Arrays.asList(new MaterialStack(Sodium, 2), new MaterialStack(Boron, 4), new MaterialStack(Oxygen, 7), new MaterialStack(Water, 10)));
        Lignite = new Materials(538, TextureSet.SET_LIGNITE, 1.0F, 0, 0, 1 | 4 | 8, 100, 70, 70, 0, "Lignite", "Lignite Coal", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack, 1, Arrays.asList(new MaterialStack(Carbon, 3), new MaterialStack(Water, 1)));
        Olivine = new Materials(505, TextureSet.SET_RUBY, 7.0F, 256, 2, 1 | 4 | 8, 150, 255, 150, 127, "Olivine", "Olivine", 0, 0, -1, 0, false, true, 5, 1, 1, Dyes.dyeLime, 1, Arrays.asList(new MaterialStack(Magnesium, 2), new MaterialStack(Iron, 1), new MaterialStack(SiliconDioxide, 2)));
        Opal = new Materials(510, TextureSet.SET_OPAL, 7.0F, 256, 2, 1 | 4 | 8, 0, 0, 255, 0, "Opal", "Opal", 0, 0, -1, 0, false, true, 3, 1, 1, Dyes.dyeBlue, 1, Arrays.asList(new MaterialStack(SiliconDioxide, 1)));
        Amethyst = new Materials(509, TextureSet.SET_FLINT, 7.0F, 256, 3, 1 | 4 | 8, 210, 50, 210, 127, "Amethyst", "Amethyst", 0, 0, -1, 0, false, true, 3, 1, 1, Dyes.dyePink, 1, Arrays.asList(new MaterialStack(SiliconDioxide, 4), new MaterialStack(Iron, 1)));
        Redstone = new Materials(810, TextureSet.SET_ROUGH, 1.0F, 0, 2, 1 | 8, 200, 0, 0, 0, "Redstone", "Redstone", 0, 0, 500, 0, false, false, 3, 1, 1, Dyes.dyeRed, 2, Arrays.asList(new MaterialStack(Silicon, 1), new MaterialStack(Pyrite, 5), new MaterialStack(Ruby, 1), new MaterialStack(Mercury, 3)));
        Lapis = new Materials(526, TextureSet.SET_LAPIS, 1.0F, 0, 1, 1 | 4 | 8, 70, 70, 220, 0, "Lapis", "Lapis", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeBlue, 2, Arrays.asList(new MaterialStack(Lazurite, 12), new MaterialStack(Sodalite, 2), new MaterialStack(Pyrite, 1), new MaterialStack(Calcite, 1)));
        Blaze = new Materials(801, TextureSet.SET_POWDER, 2.0F, 16, 1, 1, 255, 200, 0, 0, "Blaze", "Blaze", 0, 0, 6400, 0, false, false, 2, 3, 2, Dyes.dyeYellow, 2, Arrays.asList(new MaterialStack(DarkAsh, 1), new MaterialStack(Sulfur, 1)));
        EnderPearl = new Materials(532, TextureSet.SET_SHINY, 1.0F, 16, 1, 1 | 4, 108, 220, 200, 0, "EnderPearl", "Enderpearl", 0, 0, -1, 0, false, false, 1, 16, 10, Dyes.dyeGreen, 1, Arrays.asList(new MaterialStack(Beryllium, 1), new MaterialStack(Potassium, 4), new MaterialStack(Nitrogen, 5)));
        EnderEye = new Materials(533, TextureSet.SET_SHINY, 1.0F, 16, 1, 1 | 4, 160, 250, 230, 0, "EnderEye", "Endereye", 5, 10, -1, 0, false, false, 1, 2, 1, Dyes.dyeGreen, 2, Arrays.asList(new MaterialStack(EnderPearl, 1), new MaterialStack(Blaze, 1)));
        Flint = new Materials(802, TextureSet.SET_FLINT, 2.5F, 64, 1, 1 | 64, 0, 32, 64, 0, "Flint", "Flint", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGray, 2, Arrays.asList(new MaterialStack(SiliconDioxide, 1)));
        Diatomite = new Materials(948, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 8, 225, 225, 225, 0, "Diatomite", "Diatomite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGray, 2, Arrays.asList(new MaterialStack(Flint, 8), new MaterialStack(BandedIron, 1), new MaterialStack(Sapphire, 1)));
        HydratedCoal = new Materials(818, TextureSet.SET_ROUGH, 1.0F, 0, 1, 1, 70, 70, 100, 0, "HydratedCoal", "Hydrated Coal", 0, 0, -1, 0, false, false, 1, 9, 8, Dyes.dyeBlack, 2, Arrays.asList(new MaterialStack(Coal, 8), new MaterialStack(Water, 1)));
        Apatite = new Materials(530, TextureSet.SET_DIAMOND, 1.0F, 0, 1, 1 | 4 | 8, 200, 200, 255, 0, "Apatite", "Apatite", 0, 0, -1, 0, false, false, 2, 1, 1, Dyes.dyeCyan, 1, Arrays.asList(new MaterialStack(Calcium, 5), new MaterialStack(Phosphate, 3), new MaterialStack(Chlorine, 1)));
        Alumite = new Materials(-1, TextureSet.SET_METALLIC, 1.5F, 64, 0, 1 | 2, 255, 255, 255, 0, "Alumite", "Alumite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyePink, 2, Arrays.asList(new MaterialStack(Aluminium, 5), new MaterialStack(Iron, 2), new MaterialStack(Obsidian, 2)));
        Manyullyn = new Materials(-1, TextureSet.SET_METALLIC, 1.5F, 64, 0, 1 | 2, 255, 255, 255, 0, "Manyullyn", "Manyullyn", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyePurple, 2, Arrays.asList(new MaterialStack(Cobalt, 1)));
        Steeleaf = new Materials(339, TextureSet.SET_LEAF, 8.0F, 768, 3, 1 | 2 | 64 | 128, 50, 127, 50, 0, "Steeleaf", "Steeleaf", 5, 24, -1, 0, false, false, 4, 1, 1, Dyes.dyeGreen, 2, Arrays.asList(new MaterialStack(Steel, 1)));
        RoseGold = new Materials(351, TextureSet.SET_SHINY, 14.0F, 128, 2, 1 | 2 | 128, 255, 230, 30, 0, "RoseGold", "Rose Gold", 0, 0, -1, 1600, true, false, 4, 1, 1, Dyes.dyeOrange, 2, Arrays.asList(new MaterialStack(Copper, 1), new MaterialStack(Gold, 4)));
        BlackBronze = new Materials(352, TextureSet.SET_DULL, 12.0F, 256, 2, 1 | 2 | 64 | 128, 100, 50, 125, 0, "BlackBronze", "Black Bronze", 0, 0, -1, 2000, true, false, 4, 1, 1, Dyes.dyePurple, 2, Arrays.asList(new MaterialStack(Gold, 1), new MaterialStack(Silver, 1), new MaterialStack(Copper, 3)));
        BismuthBronze = new Materials(353, TextureSet.SET_DULL, 8.0F, 256, 2, 1 | 2 | 128, 100, 125, 125, 0, "BismuthBronze", "Bismuth Bronze", 0, 0, -1, 1100, true, false, 4, 1, 1, Dyes.dyeCyan, 2, Arrays.asList(new MaterialStack(Bismuth, 1), new MaterialStack(Zinc, 1), new MaterialStack(Copper, 3)));
        BlackSteel = new Materials(334, TextureSet.SET_METALLIC, 6.5F, 768, 2, 1 | 2 | 64 | 128, 100, 100, 100, 0, "BlackSteel", "Black Steel", 0, 0, -1, 1200, true, false, 4, 1, 1, Dyes.dyeBlack, 2, Arrays.asList(new MaterialStack(Nickel, 1), new MaterialStack(BlackBronze, 1), new MaterialStack(Steel, 3)));
        RedSteel = new Materials(348, TextureSet.SET_METALLIC, 7.0F, 896, 2, 1 | 2 | 64, 140, 100, 100, 0, "RedSteel", "Red Steel", 0, 0, -1, 1300, true, false, 4, 1, 1, Dyes.dyeRed, 2, Arrays.asList(new MaterialStack(Silver, 1), new MaterialStack(BismuthBronze, 1), new MaterialStack(Steel, 2), new MaterialStack(BlackSteel, 4)));
        BlueSteel = new Materials(349, TextureSet.SET_METALLIC, 7.5F, 1024, 2, 1 | 2 | 64, 100, 100, 140, 0, "BlueSteel", "Blue Steel", 0, 0, -1, 1400, true, false, 4, 1, 1, Dyes.dyeBlue, 2, Arrays.asList(new MaterialStack(RoseGold, 1), new MaterialStack(Brass, 1), new MaterialStack(Steel, 2), new MaterialStack(BlackSteel, 4)));
        DamascusSteel = new Materials(335, TextureSet.SET_METALLIC, 8.0F, 1280, 2, 1 | 2 | 64, 110, 110, 110, 0, "DamascusSteel", "Damascus Steel", 0, 0, 2000, 1500, true, false, 4, 1, 1, Dyes.dyeGray, 2, Arrays.asList(new MaterialStack(Steel, 1)));
        TungstenSteel = new Materials(316, TextureSet.SET_METALLIC, 8.0F, 2560, 4, 1 | 2 | 64 | 128, 100, 100, 160, 0, "TungstenSteel", "Tungstensteel", 0, 0, -1, 3000, true, false, 4, 1, 1, Dyes.dyeBlue, 2, Arrays.asList(new MaterialStack(Steel, 1), new MaterialStack(Tungsten, 1))).disableAutoGeneratedBlastFurnaceRecipes();
        NitroFuel = new Materials(709, TextureSet.SET_FLUID, 1.0F, 0, 2, 16, 200, 255, 0, 0, "NitroFuel", "Cetane-Boosted Diesel", 0, 512, -1, 0, false, false, 1, 1, 1, Dyes.dyeLime);
        Mithril = new Materials(331, TextureSet.SET_EMERALD, 14.0F, 64, 3, 1 | 4 | 8, 230, 90, 12, 0, "Mithril", "Mithril", 0, 0, -1, 0, false, false, 4, 3, 2, Dyes.dyeOrange);
        RedAlloy = new Materials(308, TextureSet.SET_DULL, 1.0F, 0, 0, 1 | 2, 200, 0, 0, 0, "RedAlloy", "Red Alloy", 0, 0, 500, 0, false, false, 3, 5, 1, Dyes.dyeRed, 2, Arrays.asList(new MaterialStack(Copper, 1), new MaterialStack(Redstone, 4)));
        CobaltBrass = new Materials(343, TextureSet.SET_METALLIC, 8.0F, 256, 2, 1 | 2 | 128, 180, 180, 160, 0, "CobaltBrass", "Cobalt Brass", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeOrange, 2, Arrays.asList(new MaterialStack(Brass, 7), new MaterialStack(Aluminium, 1), new MaterialStack(Cobalt, 1)));
        Phosphorus = new Materials(534, TextureSet.SET_FLINT, 1.0F, 0, 2, 1 | 4 | 8 | 16, 255, 255, 0, 0, "Phosphorus", "Phosphorus", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeYellow, 2, Arrays.asList(new MaterialStack(Calcium, 3), new MaterialStack(Phosphate, 2)));
        Basalt = new Materials(844, TextureSet.SET_ROUGH, 1.0F, 0, 1, 1, 30, 20, 20, 0, "Basalt", "Basalt", 0, 0, -1, 0, false, false, 2, 1, 1, Dyes.dyeBlack, 2, Arrays.asList(new MaterialStack(Olivine, 1), new MaterialStack(Calcite, 3), new MaterialStack(Flint, 8), new MaterialStack(DarkAsh, 4)));
        GarnetRed = new Materials(527, TextureSet.SET_RUBY, 7.0F, 128, 2, 1 | 4 | 8, 200, 80, 80, 127, "GarnetRed", "Red Garnet", 0, 0, -1, 0, false, true, 4, 1, 1, Dyes.dyeRed, 2, Arrays.asList(new MaterialStack(Pyrope, 3), new MaterialStack(Almandine, 5), new MaterialStack(Spessartine, 8)));
        GarnetYellow = new Materials(528, TextureSet.SET_RUBY, 7.0F, 128, 2, 1 | 4 | 8, 200, 200, 80, 127, "GarnetYellow", "Yellow Garnet", 0, 0, -1, 0, false, true, 4, 1, 1, Dyes.dyeYellow, 2, Arrays.asList(new MaterialStack(Andradite, 5), new MaterialStack(Grossular, 8), new MaterialStack(Uvarovite, 3)));
        Marble = new Materials(845, TextureSet.SET_FINE, 1.0F, 16, 1, 1 | 128, 200, 200, 200, 0, "Marble", "Marble", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 2, Arrays.asList(new MaterialStack(Magnesium, 1), new MaterialStack(Calcite, 7)));
        Sugar = new Materials(803, TextureSet.SET_FINE, 1.0F, 0, 1, 1, 250, 250, 250, 0, "Sugar", "Sugar", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeWhite, 1, Arrays.asList(new MaterialStack(Carbon, 12), new MaterialStack(Water, 11)));
        PotassiumFeldspar = new Materials(847, TextureSet.SET_FINE, 1.0F, 0, 1, 1, 120, 40, 40, 0, "PotassiumFeldspar", "Potassium Feldspar", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyePink, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Aluminium, 1), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 8)));
        Biotite = new Materials(848, TextureSet.SET_METALLIC, 1.0F, 0, 1, 1, 20, 30, 20, 0, "Biotite", "Biotite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGray, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Magnesium, 3), new MaterialStack(Aluminium, 3), new MaterialStack(Fluorine, 2), new MaterialStack(Silicon, 3), new MaterialStack(Oxygen, 10)));
        GraniteBlack = new Materials(849, TextureSet.SET_ROUGH, 4.0F, 64, 3, 1 | 128, 10, 10, 10, 0, "GraniteBlack", "Black Granite", 0, 0, -1, 0, false, false, 0, 1, 1, Dyes.dyeBlack, 2, Arrays.asList(new MaterialStack(SiliconDioxide, 4), new MaterialStack(Biotite, 1)));
        GraniteRed = new Materials(850, TextureSet.SET_ROUGH, 4.0F, 64, 3, 1 | 128, 255, 0, 128, 0, "GraniteRed", "Red Granite", 0, 0, -1, 0, false, false, 0, 1, 1, Dyes.dyeMagenta, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(PotassiumFeldspar, 1), new MaterialStack(Oxygen, 3)));
        VanadiumMagnetite = new Materials(923, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 8, 35, 35, 60, 0, "VanadiumMagnetite", "Vanadium Magnetite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack, 2, Arrays.asList(new MaterialStack(Magnetite, 1), new MaterialStack(Vanadium, 1))); // Mixture of Fe3O4 and V2O5
        BasalticMineralSand = new Materials(935, TextureSet.SET_SAND, 1.0F, 0, 1, 1 | 8, 40, 50, 40, 0, "BasalticMineralSand", "Basaltic Mineral Sand", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack, 2, Arrays.asList(new MaterialStack(Magnetite, 1), new MaterialStack(Basalt, 1)));
        GraniticMineralSand = new Materials(936, TextureSet.SET_SAND, 1.0F, 0, 1, 1 | 8, 40, 60, 60, 0, "GraniticMineralSand", "Granitic Mineral Sand", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeBlack, 2, Arrays.asList(new MaterialStack(Magnetite, 1), new MaterialStack(GraniteBlack, 1)));
        GarnetSand = new Materials(938, TextureSet.SET_SAND, 1.0F, 0, 1, 1 | 8, 200, 100, 0, 0, "GarnetSand", "Garnet Sand", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeOrange, 2, Arrays.asList(new MaterialStack(GarnetRed, 1), new MaterialStack(GarnetYellow, 1)));
        Bastnasite = new Materials(905, TextureSet.SET_FINE, 1.0F, 0, 2, 1 | 8, 200, 110, 45, 0, "Bastnasite", "Bastnasite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Cerium, 1), new MaterialStack(Carbon, 1), new MaterialStack(Fluorine, 1), new MaterialStack(Oxygen, 3))); // (Ce, La, Y)CO3F
        Pentlandite = new Materials(909, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 165, 150, 5, 0, "Pentlandite", "Pentlandite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Nickel, 9), new MaterialStack(Sulfur, 8))); // (Fe, Ni)9S8
        Spodumene = new Materials(920, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 190, 170, 170, 0, "Spodumene", "Spodumene", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Lithium, 1), new MaterialStack(Aluminium, 1), new MaterialStack(Silicon, 2), new MaterialStack(Oxygen, 6))); // LiAl(SiO3)2
        Pollucite = new Materials(919, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 240, 210, 210, 0, "Pollucite", "Pollucite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Caesium, 2), new MaterialStack(Aluminium, 2), new MaterialStack(Silicon, 4), new MaterialStack(Water, 2), new MaterialStack(Oxygen, 12))); // (Cs, Na)2Al2Si4O12 2H2O (also a source of Rb)
        Tantalite = new Materials(921, TextureSet.SET_METALLIC, 1.0F, 0, 3, 1 | 8, 145, 80, 40, 0, "Tantalite", "Tantalite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Manganese, 1), new MaterialStack(Tantalum, 2), new MaterialStack(Oxygen, 6))); // (Fe, Mn)Ta2O6 (also source of Nb)
        Lepidolite = new Materials(907, TextureSet.SET_FINE, 1.0F, 0, 2, 1 | 8, 240, 50, 140, 0, "Lepidolite", "Lepidolite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Lithium, 3), new MaterialStack(Aluminium, 4), new MaterialStack(Fluorine, 2), new MaterialStack(Oxygen, 10))); // K(Li, Al, Rb)3(Al, Si)4O10(F, OH)2
        Glauconite = new Materials(933, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 130, 180, 60, 0, "Glauconite", "Glauconite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Magnesium, 2), new MaterialStack(Aluminium, 4), new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 12))); // (K, Na)(Fe3+, Al, Mg)2(Si, Al)4O10(OH)2
        GlauconiteSand = new Materials(949, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 130, 180, 60, 0, "GlauconiteSand", "Glauconite Sand", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Magnesium, 2), new MaterialStack(Aluminium, 4), new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 12))); // (K, Na)(Fe3+, Al, Mg)2(Si, Al)4O10(OH)2
        Vermiculite = new Materials(932, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 8, 200, 180, 15, 0, "Vermiculite", "Vermiculite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Iron, 3), new MaterialStack(Aluminium, 4), new MaterialStack(Silicon, 4), new MaterialStack(Hydrogen, 2), new MaterialStack(Water, 4), new MaterialStack(Oxygen, 12))); // (Mg+2, Fe+2, Fe+3)3 [(AlSi)4O10] (OH)2 4H2O)
        Bentonite = new Materials(927, TextureSet.SET_ROUGH, 1.0F, 0, 2, 1 | 8, 245, 215, 210, 0, "Bentonite", "Bentonite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Sodium, 1), new MaterialStack(Magnesium, 6), new MaterialStack(Silicon, 12), new MaterialStack(Hydrogen, 6), new MaterialStack(Water, 5), new MaterialStack(Oxygen, 36))); // (Na, Ca)0.33(Al, Mg)2(Si4O10)(OH)2 nH2O
        FullersEarth = new Materials(928, TextureSet.SET_FINE, 1.0F, 0, 2, 1 | 8, 160, 160, 120, 0, "FullersEarth", "Fullers Earth", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Magnesium, 1), new MaterialStack(Silicon, 4), new MaterialStack(Hydrogen, 1), new MaterialStack(Water, 4), new MaterialStack(Oxygen, 11))); // (Mg, Al)2Si4O10(OH) 4(H2O)
        Pitchblende = new Materials(873, TextureSet.SET_DULL, 1.0F, 0, 3, 1 | 8, 200, 210, 0, 0, "Pitchblende", "Pitchblende", 0, 0, -1, 0, false, false, 5, 1, 1, Dyes.dyeYellow, 2, Arrays.asList(new MaterialStack(Uraninite, 3), new MaterialStack(Thorium, 1), new MaterialStack(Lead, 1)));
        Monazite = new Materials(520, TextureSet.SET_DIAMOND, 1.0F, 0, 1, 1 | 4 | 8, 50, 70, 50, 0, "Monazite", "Monazite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeGreen, 1, Arrays.asList(new MaterialStack(RareEarth, 1), new MaterialStack(Phosphate, 1))); // Wikipedia: (Ce, La, Nd, Th, Sm, Gd)PO4 Monazite also smelt-extract to Helium, it is brown like the rare earth Item Monazite sand deposits are inevitably of the monazite-(Ce) composition. Typically, the lanthanides in such monazites contain about 45ִ8% cerium, about 24% lanthanum, about 17% neodymium, about 5% praseodymium, and minor quantities of samarium, gadolinium, and yttrium. Europium concentrations tend to be low, about 0.05% Thorium content of monazite is variable and sometimes can be up to 20ֳ0%
        Malachite = new Materials(871, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 5, 95, 5, 0, "Malachite", "Malachite", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeGreen, 1, Arrays.asList(new MaterialStack(Copper, 2), new MaterialStack(Carbon, 1), new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 5))); // Cu2CO3(OH)2
        Mirabilite = new Materials(900, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 240, 250, 210, 0, "Mirabilite", "Mirabilite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Sodium, 2), new MaterialStack(Sulfur, 1), new MaterialStack(Water, 10), new MaterialStack(Oxygen, 4))); // Na2SO4 10H2O
        Mica = new Materials(901, TextureSet.SET_FINE, 1.0F, 0, 1, 1 | 8, 195, 195, 205, 0, "Mica", "Mica", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Aluminium, 3), new MaterialStack(Silicon, 3), new MaterialStack(Fluorine, 2), new MaterialStack(Oxygen, 10))); // KAl2(AlSi3O10)(F, OH)2
        Trona = new Materials(903, TextureSet.SET_METALLIC, 1.0F, 0, 1, 1 | 8, 135, 135, 95, 0, "Trona", "Trona", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Sodium, 3), new MaterialStack(Carbon, 2), new MaterialStack(Hydrogen, 1), new MaterialStack(Water, 2), new MaterialStack(Oxygen, 6))); // Na3(CO3)(HCO3) 2H2O
        Barite = new Materials(904, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 230, 235, 255, 0, "Barite", "Barite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Barium, 1), new MaterialStack(Sulfur, 1), new MaterialStack(Oxygen, 4)));
        Gypsum = new Materials(934, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 8, 230, 230, 250, 0, "Gypsum", "Gypsum", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Calcium, 1), new MaterialStack(Sulfur, 1), new MaterialStack(Water, 2), new MaterialStack(Oxygen, 4))); // CaSO4 2H2O
        Alunite = new Materials(911, TextureSet.SET_METALLIC, 1.0F, 0, 2, 1 | 8, 225, 180, 65, 0, "Alunite", "Alunite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Potassium, 1), new MaterialStack(Aluminium, 3), new MaterialStack(Silicon, 2), new MaterialStack(Hydrogen, 6), new MaterialStack(Oxygen, 14))); // KAl3(SO4)2(OH)6
        Dolomite = new Materials(914, TextureSet.SET_FLINT, 1.0F, 0, 1, 1 | 8, 225, 205, 205, 0, "Dolomite", "Dolomite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Calcium, 1), new MaterialStack(Magnesium, 1), new MaterialStack(Carbon, 2), new MaterialStack(Oxygen, 6))); // CaMg(CO3)2
        Wollastonite = new Materials(915, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 240, 240, 240, 0, "Wollastonite", "Wollastonite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Calcium, 1), new MaterialStack(Silicon, 1), new MaterialStack(Oxygen, 3))); // CaSiO3
        Zeolite = new Materials(916, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 240, 230, 230, 0, "Zeolite", "Zeolite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Sodium, 1), new MaterialStack(Calcium, 4), new MaterialStack(Silicon, 27), new MaterialStack(Aluminium, 9), new MaterialStack(Water, 28), new MaterialStack(Oxygen, 72))); // NaCa4(Si27Al9)O72 28(H2O)
        Kyanite = new Materials(924, TextureSet.SET_FLINT, 1.0F, 0, 2, 1 | 8, 110, 110, 250, 0, "Kyanite", "Kyanite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Silicon, 1), new MaterialStack(Oxygen, 5))); // Al2SiO5
        Kaolinite = new Materials(929, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 245, 235, 235, 0, "Kaolinite", "Kaolinite", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Aluminium, 2), new MaterialStack(Silicon, 2), new MaterialStack(Hydrogen, 4), new MaterialStack(Oxygen, 9))); // Al2Si2O5(OH)4
        Talc = new Materials(902, TextureSet.SET_DULL, 1.0F, 0, 2, 1 | 8, 90, 180, 90, 0, "Talc", "Talc", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Magnesium, 3), new MaterialStack(Silicon, 4), new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 12))); // H2Mg3(SiO3)4
        Soapstone = new Materials(877, TextureSet.SET_DULL, 1.0F, 0, 1, 1 | 8, 95, 145, 95, 0, "Soapstone", "Soapstone", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes._NULL, 1, Arrays.asList(new MaterialStack(Magnesium, 3), new MaterialStack(Silicon, 4), new MaterialStack(Hydrogen, 2), new MaterialStack(Oxygen, 12))); // H2Mg3(SiO3)4
        Concrete = new Materials(947, TextureSet.SET_ROUGH, 1.0F, 0, 1, 1, 100, 100, 100, 0, "Concrete", "Concrete", 0, 0, 300, 0, false, false, 0, 1, 1, Dyes.dyeGray, 0, Arrays.asList(new MaterialStack(Stone, 1)));
        IronMagnetic = new Materials(354, TextureSet.SET_MAGNETIC, 6.0F, 256, 2, 1 | 2 | 128, 200, 200, 200, 0, "IronMagnetic", "Magnetic Iron", 0, 0, -1, 0, false, false, 4, 51, 50, Dyes.dyeGray, 1, Arrays.asList(new MaterialStack(Iron, 1)));
        SteelMagnetic = new Materials(355, TextureSet.SET_MAGNETIC, 6.0F, 512, 2, 1 | 2 | 128, 128, 128, 128, 0, "SteelMagnetic", "Magnetic Steel", 0, 0, 1000, 1000, true, false, 4, 51, 50, Dyes.dyeGray, 1, Arrays.asList(new MaterialStack(Steel, 1)));
        NeodymiumMagnetic = new Materials(356, TextureSet.SET_MAGNETIC, 7.0F, 512, 2, 1 | 2 | 128, 100, 100, 100, 0, "NeodymiumMagnetic", "Magnetic Neodymium", 0, 0, 1297, 1297, true, false, 4, 51, 50, Dyes.dyeGray, 1, Arrays.asList(new MaterialStack(Neodymium, 1)));
        TungstenCarbide = new Materials(370, TextureSet.SET_METALLIC, 14.0F, 1280, 4, 1 | 2 | 128, 51, 0, 102, 0, "TungstenCarbide", "Tungstencarbide", 0, 0, 2460, 2460, true, false, 4, 1, 1, Dyes.dyeBlack, 2, Arrays.asList(new MaterialStack(Tungsten, 1), new MaterialStack(Carbon, 1))).disableAutoGeneratedBlastFurnaceRecipes();
        VanadiumSteel = new Materials(371, TextureSet.SET_METALLIC, 3.0F, 1920, 3, 1 | 2 | 64 | 128, 192, 192, 192, 0, "VanadiumSteel", "Vanadiumsteel", 0, 0, 1453, 1453, true, false, 4, 1, 1, Dyes.dyeWhite, 2, Arrays.asList(new MaterialStack(Vanadium, 1), new MaterialStack(Chrome, 1), new MaterialStack(Steel, 7)));
        HSSG = new Materials(372, TextureSet.SET_METALLIC, 10.0F, 4000, 3, 1 | 2 | 64 | 128, 153, 153, 0, 0, "HSSG", "HSS-G", 0, 0, 4500, 4500, true, false, 4, 1, 1, Dyes.dyeYellow, 2, Arrays.asList(new MaterialStack(TungstenSteel, 5), new MaterialStack(Chrome, 1), new MaterialStack(Molybdenum, 2), new MaterialStack(Vanadium, 1))).disableAutoGeneratedBlastFurnaceRecipes();
        HSSE = new Materials(373, TextureSet.SET_METALLIC, 10.0F, 5120, 4, 1 | 2 | 64 | 128, 51, 102, 0, 0, "HSSE", "HSS-E", 0, 0, 5400, 5400, true, false, 4, 1, 1, Dyes.dyeBlue, 2, Arrays.asList(new MaterialStack(HSSG, 6), new MaterialStack(Cobalt, 1), new MaterialStack(Manganese, 1), new MaterialStack(Silicon, 1))).disableAutoGeneratedBlastFurnaceRecipes();
        HSSS = new Materials(374, TextureSet.SET_METALLIC, 14.0F, 3000, 4, 1 | 2 | 64 | 128, 102, 0, 51, 0, "HSSS", "HSS-S", 0, 0, 5400, 5400, true, false, 4, 1, 1, Dyes.dyeRed, 2, Arrays.asList(new MaterialStack(HSSG, 6), new MaterialStack(Iridium, 2), new MaterialStack(Osmium, 1))).disableAutoGeneratedBlastFurnaceRecipes();
        DilutedSulfuricAcid = new MaterialBuilder(640, TextureSet.SET_FLUID, "Diluted Sulfuric Acid").addCell().addFluid().setRGB(192, 120, 32).setColor(Dyes.dyeOrange).setMaterialList(new MaterialStack(SulfuricAcid, 1)).constructMaterial();
        EpoxidFiberReinforced = new Materials(610, TextureSet.SET_DULL, 3.0F, 64, 1, 1 | 2 | 128, 160, 112, 16, 0, "EpoxidFiberReinforced", "Fiber-Reinforced Epoxy Resin", 0, 0, 400, 0, false, false, 1, 1, 1, Dyes.dyeBrown, 2, Arrays.asList(new MaterialStack(Epoxid, 1)));


        // Polybenzimidazole stuff
        PotassiumNitrade = new MaterialBuilder(590, TextureSet.SET_DULL, "Potassium Nitrade").setName("PotassiumNitrade").addDustItems().setRGB(129, 34, 141).setColor(Dyes.dyePurple).setMaterialList(new MaterialStack(Potassium, 1), new MaterialStack(Nitrogen, 1), new MaterialStack(Oxygen, 3)).addElectrolyzerRecipe().constructMaterial();
        ChromiumTrioxide = new MaterialBuilder(591, TextureSet.SET_DULL, "Chromium Trioxide").setName("Chromiumtrioxide").addDustItems().setRGB(255, 228, 225).setColor(Dyes.dyePink).setMaterialList(new MaterialStack(Chrome, 1), new MaterialStack(Oxygen, 3)).addElectrolyzerRecipe().constructMaterial();
        Nitrochlorobenzene = new MaterialBuilder(592, TextureSet.SET_FLUID, "2-Nitrochlorobenzene").addCell().addFluid().setRGB(143, 181, 26).setColor(Dyes.dyeLime).setMaterialList(new MaterialStack(Carbon, 6), new MaterialStack(Hydrogen, 4), new MaterialStack(Chlorine, 1), new MaterialStack(Nitrogen, 1), new MaterialStack(Oxygen, 2)).constructMaterial();
        Dimethylbenzene = new MaterialBuilder(593, TextureSet.SET_FLUID, "Dimethylbenzene").addCell().addFluid().setRGB(102, 156, 64).setColor(Dyes.dyeLime).setMaterialList(new MaterialStack(Carbon, 8), new MaterialStack(Hydrogen, 10)).constructMaterial();
        Potassiumdichromate = new MaterialBuilder(594, TextureSet.SET_DULL, "Potassium Dichromate").setName("PotassiumDichromate").addDustItems().setRGB(255, 8, 127).setColor(Dyes.dyePink).setMaterialList(new MaterialStack(Potassium, 2), new MaterialStack(Chrome, 2), new MaterialStack(Oxygen, 7)).addElectrolyzerRecipe().constructMaterial();
        PhthalicAcid = new MaterialBuilder(595, TextureSet.SET_FLUID, "Phtalic Acid").addCell().addFluid().setRGB(54, 133, 71).setColor(Dyes.dyeOrange).setMaterialList(new MaterialStack(Carbon, 8), new MaterialStack(Hydrogen, 6), new MaterialStack(Oxygen, 4)).constructMaterial();
        Dichlorobenzidine = new MaterialBuilder(596, TextureSet.SET_FLUID, "3,3-Dichlorobenzidine").addCell().addFluid().setRGB(161, 222, 166).setColor(Dyes.dyeOrange).setMaterialList(new MaterialStack(Carbon, 12), new MaterialStack(Hydrogen, 10), new MaterialStack(Nitrogen, 2), new MaterialStack(Chlorine, 2)).constructMaterial();
        Diaminobenzidin = new MaterialBuilder(597, TextureSet.SET_FLUID, "3,3-Diaminobenzidine").addCell().addFluid().setRGB(51, 125, 89).setColor(Dyes.dyeOrange).setMaterialList(new MaterialStack(Carbon, 12), new MaterialStack(Hydrogen, 14), new MaterialStack(Nitrogen, 4)).constructMaterial();
        Diphenylisophthalate = new MaterialBuilder(598, TextureSet.SET_FLUID, "Diphenyl Isophtalate").addCell().addFluid().setRGB(36, 110, 87).setColor(Dyes.dyeOrange).setMaterialList(new MaterialStack(Carbon, 20), new MaterialStack(Hydrogen, 20), new MaterialStack(Oxygen, 4)).constructMaterial();
        Polybenzimidazole = new Materials(599, TextureSet.SET_DULL, 3.0F, 64, 1, 1 | 2 | 128, 45, 45, 45, 0, "Polybenzimidazole", "Polybenzimidazole", 0, 0, 1450, 0, false, false, 1, 1, 1, Dyes.dyeBlack, 0, Arrays.asList(new MaterialStack(Carbon, 20), new MaterialStack(Nitrogen, 4), new MaterialStack(Hydrogen, 12)));

        NitrousOxide = new MaterialBuilder(993, TextureSet.SET_FLUID, "Nitrous Oxide").addCell().addGas().setRGB(125, 200, 255).setColor(Dyes.dyeBlue).setMaterialList(new MaterialStack(Nitrogen, 2), new MaterialStack(Oxygen, 1)).addElectrolyzerRecipe().constructMaterial();
        AntiKnock = new MaterialBuilder(994, TextureSet.SET_FLUID, "Ethyl Tert-Butyl Ether").addCell().addFluid().setRGB(255, 255, 255).setColor(Dyes.dyeWhite).constructMaterial();
        Octane = new MaterialBuilder(995, TextureSet.SET_FLUID, "Octane").addCell().addFluid().setRGB(255, 255, 255).setColor(Dyes.dyeWhite).setFuelType(MaterialBuilder.DIESEL).setFuelPower(80).setMaterialList(new MaterialStack(Carbon, 8), new MaterialStack(Hydrogen, 18)).constructMaterial();
        GasolineRaw = new MaterialBuilder(996, TextureSet.SET_FLUID, "Raw Gasoline").addCell().addFluid().setRGB(255, 100, 0).setColor(Dyes.dyeOrange).constructMaterial();
        GasolineRegular = new MaterialBuilder(997, TextureSet.SET_FLUID, "Gasoline").addCell().addFluid().setRGB(255, 165, 0).setColor(Dyes.dyeOrange).setFuelType(MaterialBuilder.DIESEL).setFuelPower(576).constructMaterial();
        GasolinePremium = new MaterialBuilder(998, TextureSet.SET_FLUID, "High Octane Gasoline").addCell().addFluid().setRGB(255, 165, 0).setColor(Dyes.dyeOrange).setFuelType(MaterialBuilder.DIESEL).setFuelPower(1728).constructMaterial();

        Oriharukon = new Materials(389, TextureSet.SET_SHINY, 32.0F, 10240, 5, 1 | 2 | 8 | 64 | 128, 103, 125, 104, 0, "Oriharukon", "Oriharukon", 0, 0, 5400, 5400, true, false, 4, 1, 1, Dyes.dyeLime, Element.Oh);
        MysteriousCrystal = new Materials(394, TextureSet.SET_DIAMOND, 8.0F, 256, 6, 1 | 4 | 8, 22, 133, 108, 0, "MysteriousCrystal", "Mysterious Crystal", 0, 0, 7200, 7200, true, true, 4, 1, 1, Dyes.dyeCyan).disableAutoGeneratedBlastFurnaceRecipes();
        EnrichedMysteriousCrystal = new Materials(395, TextureSet.SET_DIAMOND, 8.0F, 256, 6, 1 | 4, 28, 162, 108, 0, "EnrichedMysteriousCrystal", "Enriched Mysterious Crystal", 0, 0, 7200, 7200, true, true, 4, 1, 1, Dyes.dyeCyan).disableAutoGeneratedBlastFurnaceRecipes();

        Pentacadmiummagnesiumhexaoxid = new Materials(987, TextureSet.SET_SHINY, 1.0F, 0, 3, 1 | 2, 85, 85, 85, 0, "Pentacadmiummagnesiumhexaoxid", "Superconductor Base MV", 0, 0, 2500, 2500, true, false, 1, 1, 1, Dyes.dyeGray, 1, Arrays.asList(new MaterialStack(Cadmium, 5), new MaterialStack(Magnesium, 1), new MaterialStack(Oxygen, 6))).disableAutoGeneratedBlastFurnaceRecipes();
        Titaniumonabariumdecacoppereikosaoxid = new Materials(988, TextureSet.SET_METALLIC, 1.0F, 0, 3, 1 | 2, 51, 25, 0, 0, "Titaniumonabariumdecacoppereikosaoxid", "Superconductor Base HV", 0, 0, 3300, 3300, true, false, 1, 1, 1, Dyes.dyeBrown, 1, Arrays.asList(new MaterialStack(Titanium, 1), new MaterialStack(Barium, 9), new MaterialStack(Copper, 10), new MaterialStack(Oxygen, 20))).disableAutoGeneratedBlastFurnaceRecipes();
        Uraniumtriplatinid = new Materials(989, TextureSet.SET_SHINY, 1.0F, 0, 3, 1 | 2, 0, 135, 0, 0, "Uraniumtriplatinid", "Superconductor Base EV", 0, 0, 4400, 4400, true, false, 1, 1, 1, Dyes.dyeLime, 1, Arrays.asList(new MaterialStack(Uranium, 1), new MaterialStack(Platinum, 3))).disableAutoGeneratedBlastFurnaceRecipes();
        Vanadiumtriindinid = new Materials(990, TextureSet.SET_SHINY, 1.0F, 0, 3, 1 | 2, 51, 0, 51, 0, "Vanadiumtriindinid", "Superconductor Base IV", 0, 0, 5200, 5200, true, false, 1, 1, 1, Dyes.dyeMagenta, 1, Arrays.asList(new MaterialStack(Vanadium, 1), new MaterialStack(Indium, 3))).disableAutoGeneratedBlastFurnaceRecipes();
        Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid = new Materials(991, TextureSet.SET_METALLIC, 1.0F, 0, 3, 1 | 2, 153, 76, 0, 0, "Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid", "Superconductor Base LuV", 0, 0, 6000, 6000, true, false, 1, 1, 1, Dyes.dyeBrown, 1, Arrays.asList(new MaterialStack(Indium, 4), new MaterialStack(Tin, 2), new MaterialStack(Barium, 2), new MaterialStack(Titanium, 1), new MaterialStack(Copper, 7), new MaterialStack(Oxygen, 14))).disableAutoGeneratedBlastFurnaceRecipes();
        Tetranaquadahdiindiumhexaplatiumosminid = new Materials(992, TextureSet.SET_METALLIC, 1.0F, 0, 3, 1 | 2, 10, 10, 10, 0, "Tetranaquadahdiindiumhexaplatiumosminid", "Superconductor Base ZPM", 0, 0, 9000, 9000, true, false, 1, 1, 1, Dyes.dyeBlack, 1, Arrays.asList(new MaterialStack(Naquadah, 4), new MaterialStack(Indium, 2), new MaterialStack(Palladium, 6), new MaterialStack(Osmium, 1))).disableAutoGeneratedBlastFurnaceRecipes();
        Longasssuperconductornameforuvwire = new Materials(986, TextureSet.SET_METALLIC, 1.0F, 0, 3, 1 | 2, 224, 210, 7, 0, "Longasssuperconductornameforuvwire", "Superconductor Base UV", 0, 0, 9000, 9000, true, false, 1, 1, 1, Dyes.dyeYellow, 1, Arrays.asList(new MaterialStack(NaquadahEnriched, 4), new MaterialStack(Osmiridium, 3), new MaterialStack(Europium, 2), new MaterialStack(Duranium, 1))).disableAutoGeneratedBlastFurnaceRecipes();
        Longasssuperconductornameforuhvwire = new Materials(985, TextureSet.SET_METALLIC, 1.0F, 0, 3, 1 | 2, 255, 255, 255, 0, "Longasssuperconductornameforuhvwire", "Superconductor Base UHV", 0, 0, 10800, 10800, true, false, 1, 1, 1, Dyes.dyeWhite, 1, Arrays.asList(new MaterialStack(Naquadria, 6), new MaterialStack(Americium, 5), new MaterialStack(Tritanium, 4))).disableAutoGeneratedBlastFurnaceRecipes();
        Longasssuperconductornameforuevwire = new Materials(984, TextureSet.SET_METALLIC, 1.0F, 0, 3, 1 | 2, 125, 150, 115, 0, "Longasssuperconductornameforuevwire", "Superconductor Base UEV", 0, 0, 12600, 12600, true, false, 1, 1, 1, Dyes.dyeGreen, 1, Arrays.asList(new MaterialStack(Neutronium, 7), new MaterialStack(Oriharukon, 5), new MaterialStack(Infuscolium, 4))).disableAutoGeneratedBlastFurnaceRecipes();

        SuperconductorMV = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 0, 0, 85, 85, 85, 0, "SuperconductorMV", "Superconductor MV", 0, 0, -1, -1, false, false, 1, 1, 1, Dyes.dyeGray);
        SuperconductorHV = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 0, 0, 51, 25, 0, 0, "SuperconductorHV", "Superconductor HV", 0, 0, -1, -1, false, false, 1, 1, 1, Dyes.dyeBrown);
        SuperconductorEV = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 0, 0, 0, 135, 0, 0, "SuperconductorEV", "Superconductor EV", 0, 0, -1, -1, false, false, 1, 1, 1, Dyes.dyeLime);
        SuperconductorIV = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 0, 0, 51, 0, 51, 0, "SuperconductorIV", "Superconductor IV", 0, 0, -1, -1, false, false, 1, 1, 1, Dyes.dyeMagenta);
        SuperconductorLuV = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 0, 0, 153, 76, 0, 0, "SuperconductorLuV", "Superconductor LuV", 0, 0, -1, -1, false, false, 1, 1, 1, Dyes.dyeBrown);
        SuperconductorZPM = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 0, 0, 10, 10, 10, 0, "SuperconductorZPM", "Superconductor ZPM", 0, 0, -1, -1, false, false, 1, 1, 1, Dyes.dyeBlack);
        SuperconductorUV = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 0, 0, 224, 210, 7, 0, "SuperconductorUV", "Superconductor UV", 0, 0, -1, -1, false, false, 1, 1, 1, Dyes.dyeYellow);
        SuperconductorUEV = new Materials(-1, TextureSet.SET_SHINY, 1.0F, 0, 0, 0, 125, 150, 115, 0, "SuperconductorUEV", "Superconductor UEV", 0, 0, -1, -1, false, false, 1, 1, 1, Dyes.dyeGreen);

        Diamericiumtitanium = new Materials(380, TextureSet.SET_METALLIC, 14.0F, 3000, 4, 1 | 2 | 64 | 128, 230, 160, 250, 0, "Diamericiumtitanium", "Diamericium Titanium", 0, 0, 10800, 10800, true, false, 4, 1, 1, Dyes.dyePurple, 2, Arrays.asList(new MaterialStack(Americium, 2), new MaterialStack(Titanium, 1))).disableAutoGeneratedBlastFurnaceRecipes();
        Europiumoxide = new Materials(392, TextureSet.SET_METALLIC, 18.0F, 3000, 4, 1 | 2 | 128, 200, 200, 200, 0, "Europiumoxide", "Europium Oxide", 0, 0, 8000, 8000, true, false, 4, 1, 1, Dyes.dyeWhite, 2, Arrays.asList(new MaterialStack(Europium, 2), new MaterialStack(Oxygen, 3))).disableAutoGeneratedBlastFurnaceRecipes();
        EuropiumoxideMagnetic = new Materials(393, TextureSet.SET_MAGNETIC, 18.0F, 3000, 4, 1 | 2 | 128, 200, 200, 200, 0, "EuropiumoxideMagnetic", "Magnetic Europium Oxide", 0, 0, 8000, 8000, true, false, 4, 51, 50, Dyes.dyeWhite, 2, Arrays.asList(new MaterialStack(Europiumoxide, 1))).disableAutoGeneratedBlastFurnaceRecipes();
        //Fuels
        FluidNaquadahFuel = new MaterialBuilder(397, TextureSet.SET_FLUID, "Fluid Naquadah Fuel").setName("FluidNaqudriaFuel").addCell().addFluid().setRGB(62, 62, 62).setColor(Dyes.dyeBlack).constructMaterial();
        EnrichedNaquadria = new MaterialBuilder(398, TextureSet.SET_FLUID, "Enriched Naquadria").setName("EnrichedNaquadria").addCell().addFluid().setRGB(52, 52, 52).setColor(Dyes.dyeBlack).constructMaterial();
        FluidEnrichedNaquadahFuel = new MaterialBuilder(399, TextureSet.SET_FLUID, "Fluid Enriched Naquadah Fuel").setName("FluidEnrichedNaquadahFuel").addCell().addFluid().setRGB(42, 42, 42).setColor(Dyes.dyeBlack).constructMaterial();
        FluidNaquadriaFuel = new MaterialBuilder(400, TextureSet.SET_FLUID, "Fluid Naquadria Fuel").setName("FluidNaquadriaFuel").addCell().addFluid().setRGB(32, 32, 32).setColor(Dyes.dyeBlack).constructMaterial();

        //Custom Material
        Quantium = new Materials(391, TextureSet.SET_SHINY, 18.0F, 4096, 6, 1 | 2 | 8 | 128, 0, 209, 11, 0, "Quantium", "Quantium", 0, 0, 10800, 10800, true, false, 4, 1, 1, Dyes.dyeLime).disableAutoGeneratedBlastFurnaceRecipes();
        InfinityCatalyst = new Materials(401, TextureSet.SET_SHINY, 64.0F, 1310720, 10, 1 | 2 | 8 | 128, 255, 255, 255, 0, "InfinityCatalyst", "Infinity Catalyst", 5, 500000, 12600, 12600, true, false, 20, 1, 1, Dyes.dyeLightGray);
        Infinity = new Materials(402, TextureSet.SET_SHINY, 128.0F, 2621440, 17, 1 | 2 | 8 | 128, 255, 255, 255, 0, "Infinity", "Infinity", 5, 5000000, 12600, 12600, true, false, 40, 1, 1, Dyes.dyeWhite);
        ReinforcedGlass = new Materials(405, TextureSet.SET_GLASS, 1.0F, 4, 0, 1 | 4, 192, 245, 254, 220, "ReinforcedGlass", "Reinforced Glass", 0, 0, 1500, 0, false, true, 1, 1, 1, Dyes.dyeGray);
        BioMediumRaw = new MaterialBuilder(-1/*406*/, TextureSet.SET_FLUID, "Raw Bio Medium").setName("BioMediumRaw").addCell().addFluid().setRGB(97, 147, 46).setColor(Dyes.dyeLime).constructMaterial();
        BioMediumSterilized = new MaterialBuilder(-1/*407*/, TextureSet.SET_FLUID, "Sterilized Bio Medium").setName("BiohMediumSterilized").addCell().addFluid().setRGB(162, 253, 53).setColor(Dyes.dyeLime).constructMaterial();
        Bacteria = new MaterialBuilder(-1/*408*/, TextureSet.SET_FLUID, "Bacteria").setName("Bacteria").addCell().addFluid().setRGB(227, 150, 128).setColor(Dyes.dyeOrange).constructMaterial();
        BacterialSludge = new MaterialBuilder(-1, TextureSet.SET_FLUID, "Bacterial Sludge").setName("BacterialSludge").addCell().addFluid().setRGB(80, 250, 80).setColor(Dyes.dyeLime).constructMaterial();
        EnrichedBacterialSludge = new MaterialBuilder(409, TextureSet.SET_FLUID, "Enriched Bacterial Sludge").setName("EnrichedBacterialSludge").addCell().addFluid().setRGB(70, 250, 70).setColor(Dyes.dyeLime).constructMaterial();
        Mutagen = new MaterialBuilder(410, TextureSet.SET_FLUID, "Mutagen").setName("Mutagen").addCell().addFluid().setRGB(100, 200, 130).setColor(Dyes.dyeCyan).constructMaterial();
        IronIIIChloride = new MaterialBuilder(411, TextureSet.SET_FLUID, "Iron III Chloride").setName("IronIIIChloride").addCell().addFluid().setRGB(22, 21, 14).setColor(Dyes.dyeBlack).setMaterialList(new MaterialStack(Chlorine, 3), new MaterialStack(Iron, 1)).addElectrolyzerRecipe().constructMaterial();
        Lapotron = new Materials(412, TextureSet.SET_DIAMOND, 1.0F, 0, 1, 1 | 4 | 8, 50, 66, 199, 0, "Lapotron", "Lapotron", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeBlue);
        Pollution = new MaterialBuilder(-1/*396*/, TextureSet.SET_FLUID, "Pollution").addCell().addFluid().setRGB(90, 70, 15).setColor(Dyes.dyeBrown).constructMaterial();
        SluiceJuice = new MaterialBuilder(413, TextureSet.SET_FLUID, "Sluice Juice").addCell().addFluid().setRGB(100, 60, 20).setColor(Dyes.dyeBrown).constructMaterial();
        SluiceSand = new Materials(414, TextureSet.SET_SAND, 1.0F, 0, 2, 1, 20, 30, 20, 0, "SluiceSand", "Sluice Sand", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGray);
        AlienOrganic = new Materials(415, TextureSet.SET_DULL, 1.0F, 0, 2, 1, 75, 90, 10, 0, "AlienOrganic", "Alien Organic", 0, 0, -1, 0, false, false, 1, 1, 1, Dyes.dyeGreen);
        BlackPlutonium = new Materials(416, TextureSet.SET_DULL, 36.0F, 8192, 8, 1 | 2 | 8 | 64 | 128, 50, 50, 50, 0, "BlackPlutonium", "Black Plutonium", 0, 0, 10800, 10800, true, false, 4, 1, 1, Dyes.dyeBlack).disableAutoGeneratedBlastFurnaceRecipes();
        Ledox = new Materials(417, TextureSet.SET_SHINY, 15.0F, 1024, 4, 1 | 2 | 8 | 16 | 64 | 128, 0, 116, 255, 0, "Ledox", "Ledox", 0, 0, -1, 0, false, false, 4, 1, 1, Dyes.dyeBlue);
        CosmicNeutronium = new Materials(418, TextureSet.SET_SHINY, 96.0F, 163840, 12, 1 | 2 | 8 | 32 | 64 | 128, 50, 50, 50, 0, "CosmicNeutronium", "Cosmic Neutronium", 0, 0, 10800, 10800, true, false, 4, 1, 1, Dyes.dyeBlack);
        Electrotine = new Materials(812, TextureSet.SET_SHINY, 1.0F, 0, 1, 1 | 8, 60, 180, 200, 0, "Electrotine", "Electrotine", 0, 0, -1, 0, false, false, 3, 1, 1, Dyes.dyeCyan, 0, Arrays.asList(new MaterialStack(Redstone, 1), new MaterialStack(Electrum, 1)));
        BlueAlloy = new Materials(309, TextureSet.SET_DULL, 1.0F, 0, 0, 1 | 2, 100, 180, 255, 0, "BlueAlloy", "Blue Alloy", 0, 0, -1, 0, false, false, 3, 5, 1, Dyes.dyeLightBlue, 2, Arrays.asList(new MaterialStack(Silver, 1), new MaterialStack(Electrotine, 4)));

        //New chemical line
        AlienBiomass = new MaterialBuilder(-1, TextureSet.SET_DULL, "Alien Biomass").addCell().addFluid().setRGB(75, 90, 10).addFluid().constructMaterial();
        FermentedAlienBiomass = new MaterialBuilder(-1, TextureSet.SET_DULL, "Fermented Alien Biomass").addCell().addFluid().setRGB(85, 120, 50).addFluid().constructMaterial();
        PerroxSuperLight = new MaterialBuilder(-1, TextureSet.SET_DULL, "Super Light Perrox").addCell().addFluid().setRGB(120, 210, 140).addFluid().constructMaterial();
        PerroxLight = new MaterialBuilder(-1, TextureSet.SET_DULL, "Light Perrox").addCell().addFluid().setRGB(105, 205, 125).addFluid().constructMaterial();
        PerroxHeavy = new MaterialBuilder(-1, TextureSet.SET_DULL, "Heavy Perrox").addCell().addFluid().setRGB(85, 195, 105).addFluid().constructMaterial();
        PerroxSuperHeavy = new MaterialBuilder(-1, TextureSet.SET_DULL, "Super Heavy Perrox").addCell().addFluid().setRGB(70, 190, 90).addFluid().constructMaterial();
        PerroxSuperLightCracked = new MaterialBuilder(-1, TextureSet.SET_DULL, "Super Lightly Plasma-Cracked Perrox").setRGB(130, 215, 150).addGas().constructMaterial();
        PerroxLightCracked = new MaterialBuilder(-1, TextureSet.SET_DULL, "Lightly Plasma-Cracked Perrox").setRGB(115, 210, 135).addGas().constructMaterial();
        PerroxHeavyCracked = new MaterialBuilder(-1, TextureSet.SET_DULL, "Moderately Plasma-Cracked Perrox").setRGB(95, 200, 115).addGas().constructMaterial();
        PerroxSuperHeavyCracked = new MaterialBuilder(-1, TextureSet.SET_DULL, "Severely Plasma-Cracked Perrox").setRGB(80, 200, 100).addGas().constructMaterial();
        PerroxGas = new MaterialBuilder(-1, TextureSet.SET_DULL, "Perrox Gas").setRGB(150, 220, 160).addGas().constructMaterial();
        PerroxGasCoolant = new MaterialBuilder(-1, TextureSet.SET_DULL, "Cooled Perrox Gas").setRGB(120, 170, 120).addFluid().constructMaterial();
        PerroxHot = new MaterialBuilder(-1, TextureSet.SET_DULL, "Hot Perrox Liquid").setRGB(50, 150, 70).addFluid().constructMaterial().setLiquidTemperature(12406);
        PerroxPolymer = new Materials(421, TextureSet.SET_DULL, 8.0F, 2000, 3, 1 | 2 | 16, 50, 150, 70, 0, "PerroxPoly", "Perrox Polymer", 0, 0, 6203, 0, true, false, 1, 1, 1, Dyes.dyeGreen).disableAutoGeneratedBlastFurnaceRecipes();
        SuperCoolant = new MaterialBuilder(-1, TextureSet.SET_DULL, "Super Coolant").setRGB(2, 91, 111).addFluid().constructMaterial().setLiquidTemperature(1);

        //Galacticraft
        Moon = new MaterialBuilder(423, TextureSet.SET_DULL, "Moon").setName("Moon").addDustItems().setRGB(123, 124, 119).setColor(Dyes.dyeGray).constructMaterial();
        Mars = new MaterialBuilder(424, TextureSet.SET_DULL, "Mars").setName("Mars").addDustItems().setRGB(55, 21, 5).setColor(Dyes.dyeRed).constructMaterial();
        Asteroid = new MaterialBuilder(425, TextureSet.SET_DULL, "Asteroid").setName("Asteroid").addDustItems().setRGB(35, 29, 27).setColor(Dyes.dyeBlack).constructMaterial();


        Zirconium = new Materials           ( 27, TextureSet.SET_SHINY,128.0F,51200,8,1|8,  200,200,210,0,"Zirconium",         "Zirconium",           0,0,1000,0, true, false,4,1,1, Dyes.dyeLightGray, Element.Zr);
        Samarium = new Materials            ( 73, TextureSet.SET_SHINY,128.0F,51200,8,1,     255,255,255,0,"Samarium",          "Samarium",            0,0,1000,0, true, false,4,1,1, Dyes.dyeLightGray, Element.Sm);
        Gadolinium = new Materials          ( 74, TextureSet.SET_SHINY,128.0F,51200,8,1,     255,203,64 ,0,"Gadolinium",        "Gadolinium",          0,0,1000,0, true, false,4,1,1, Dyes.dyeLightGray, Element.Gd);

        Trinium = new Materials             ( 7 , TextureSet.SET_SHINY,128.0F,51200,8,1|2|8|64|128,200 ,200 , 200,0,"Trinium",  "Trinium",             0,0,7200,7200,true,false,4,1,1, Dyes.dyeLightGray).disableAutoGeneratedBlastFurnaceRecipes();
        HastelloyC276 = new Materials       ( 15, TextureSet.SET_SHINY,128.0F,51200,8,2|128, 207,109,57 ,0,"HastelloyC-276",    "Hastelloy C-276",     0,0,3666,3666,false, false,4,1,1, Dyes.dyeRed,  6, Arrays.asList(new MaterialStack(Materials.Cobalt, 1), new MaterialStack(Materials.Molybdenum, 8), new MaterialStack(Materials.Tungsten, 1), new MaterialStack(Materials.Copper, 1), new MaterialStack(Materials.Chrome, 7), new MaterialStack(Materials.Nickel, 32))).disableAutoGeneratedBlastFurnaceRecipes().setHasCorrespondingMoltenHot(true);
        GumMetal = new Materials            ( 16, TextureSet.SET_SHINY,128.0F,51200,8,2|128, 138,12 ,175,0,"TNTZAlloy",         "TNTZ Alloy",          0,0,3777,3777,false, false,4,1,1, Dyes.dyeRed,  4, Arrays.asList(new MaterialStack(Materials.Titanium,1), new MaterialStack(Materials.Niobium,23), new MaterialStack(Materials.Tantalum,1), new MaterialStack(Zirconium,2))).disableAutoGeneratedBlastFurnaceRecipes().setHasCorrespondingMoltenHot(true);
        Titaniolum = new Materials          ( 38, TextureSet.SET_SHINY,128.0F,51200,8,2|128, 209,168,85 ,0,"Titaniolum",        "Titaniolum",          0,0,3888,3888,false, false,4,1,1, Dyes.dyeRed,  3, Arrays.asList(new MaterialStack(Materials.Titanium,1), new MaterialStack(Materials.Niobium,1), new MaterialStack(Materials.Tantalum,1))).disableAutoGeneratedBlastFurnaceRecipes().setHasCorrespondingMoltenHot(true);
        Zamak = new Materials               ( 40, TextureSet.SET_SHINY,128.0F,51200,8,2|128, 43 ,117,222,0,"Zamak",             "Zamak",               0,0,3999,3999,false, false,4,1,1, Dyes.dyeRed,  3, Arrays.asList(new MaterialStack(Materials.Aluminium,4), new MaterialStack(Materials.Copper,3), new MaterialStack(Materials.Magnesium,1))).disableAutoGeneratedBlastFurnaceRecipes().setHasCorrespondingMoltenHot(true);
        Duraluminium = new Materials        ( 41, TextureSet.SET_SHINY,128.0F,51200,8,2|128, 1  ,165,87 ,0,"Duraluminium",      "Duraluminium",        0,0,4111,4111,false, false,4,1,1, Dyes.dyeRed,  4, Arrays.asList(new MaterialStack(Materials.Aluminium,3), new MaterialStack(Materials.Copper,3), new MaterialStack(Materials.Magnesium,1), new MaterialStack(Materials.Manganese,1))).disableAutoGeneratedBlastFurnaceRecipes().setHasCorrespondingMoltenHot(true);
        Inconel690 = new Materials          ( 42, TextureSet.SET_SHINY,128.0F,51200,8,2|128, 221,238,1  ,0,"Inconel-690",       "Inconel-690",         0,0,4222,4222,false, false,4,1,1, Dyes.dyeRed,  3, Arrays.asList(new MaterialStack(Materials.Chrome,1), new MaterialStack(Materials.Niobium,2), new MaterialStack(Materials.Molybdenum,2), new MaterialStack(Materials.Nichrome,1))).disableAutoGeneratedBlastFurnaceRecipes().setHasCorrespondingMoltenHot(true);
        Nitinol = new Materials             ( 43, TextureSet.SET_SHINY,128.0F,51200,8,2|128, 164,250,108,0,"Nitinol",           "Nitinol",             0,0,4333,4333,false, false,4,1,1, Dyes.dyeRed,  2, Arrays.asList(new MaterialStack(Materials.Titanium,1), new MaterialStack(Materials.Nickel,1))).disableAutoGeneratedBlastFurnaceRecipes().setHasCorrespondingMoltenHot(true);
        Inconel792 = new Materials          ( 44, TextureSet.SET_SHINY,128.0F,51200,8,2|128, 35 ,52 ,148,0,"Inconel-792",       "Inconel-792",         0,0,4444,4444,false, false,4,1,1, Dyes.dyeRed,  4, Arrays.asList(new MaterialStack(Materials.Nickel,2), new MaterialStack(Materials.Niobium,1), new MaterialStack(Materials.Aluminium,2), new MaterialStack(Materials.Nichrome,1))).disableAutoGeneratedBlastFurnaceRecipes().setHasCorrespondingMoltenHot(true);
        TiBetaC = new Materials             ( 46, TextureSet.SET_SHINY,128.0F,51200,8,2|128, 161,197,163,0,"TiBetaC",           "TiBetaC",             0,0,4555,4555,false, false,4,1,1, Dyes.dyeRed,  6, Arrays.asList(new MaterialStack(Materials.Titanium,2), new MaterialStack(Materials.Aluminium,3), new MaterialStack(Materials.Vanadium,8), new MaterialStack(Materials.Chrome,6), new MaterialStack(Materials.Molybdenum,4), new MaterialStack(Zirconium,4))).disableAutoGeneratedBlastFurnaceRecipes().setHasCorrespondingMoltenHot(true);
        MaragingSteel250 = new Materials    ( 49, TextureSet.SET_SHINY,128.0F,51200,8,2|128, 242,242,182,0,"MaragingSteel250",  "Maraging Steel 250",  0,0,4666,4666,false, false,4,1,1, Dyes.dyeRed,  5, Arrays.asList(new MaterialStack(Materials.Steel,16), new MaterialStack(Materials.Titanium,1), new MaterialStack(Materials.Aluminium,1), new MaterialStack(Materials.Nickel,4), new MaterialStack(Materials.Cobalt,2))).disableAutoGeneratedBlastFurnaceRecipes().setHasCorrespondingMoltenHot(true);
        Talonite = new Materials            ( 50, TextureSet.SET_SHINY,128.0F,51200,8,2|128, 1  ,29 ,66 ,0,"Talonite",          "Talonite",            0,0,4777,4777,false, false,4,1,1, Dyes.dyeRed,  5, Arrays.asList(new MaterialStack(Materials.Cobalt,4), new MaterialStack(Materials.Chrome,3), new MaterialStack(Materials.Phosphor,2), new MaterialStack(Materials.Molybdenum,1))).disableAutoGeneratedBlastFurnaceRecipes().setHasCorrespondingMoltenHot(true);
        Grisium = new Materials             ( 51, TextureSet.SET_SHINY,128.0F,51200,8,2|128, 67 ,88 ,221,0,"Grisium",           "Grisium",             0,0,4888,4888,false, false,4,1,1, Dyes.dyeRed,  5, Arrays.asList(new MaterialStack(Materials.Titanium,9), new MaterialStack(Materials.Carbon,9), new MaterialStack(Materials.Kalium,9), new MaterialStack(Materials.Lithium,9), new MaterialStack(Materials.Sulfur,9))).disableAutoGeneratedBlastFurnaceRecipes().setHasCorrespondingMoltenHot(true);
        Nitinol60 = new Materials           ( 53, TextureSet.SET_SHINY,128.0F,51200,8,2|128, 122,235,112,0,"Nitinol-60",        "Nitinol-60",          0,0,4999,4999,false, false,4,1,1, Dyes.dyeRed,  2, Arrays.asList(new MaterialStack(Materials.Nickel,2), new MaterialStack(Materials.Titanium,3))).disableAutoGeneratedBlastFurnaceRecipes().setHasCorrespondingMoltenHot(true);
        Kovar = new Materials               ( 59, TextureSet.SET_SHINY,128.0F,51200,8,2|128, 203,192,166,0,"Kovar",             "Kovar",               0,0,4000,4000,false, false,4,1,1, Dyes.dyeRed,  3, Arrays.asList(new MaterialStack(Materials.Iron,5), new MaterialStack(Materials.Nickel,3), new MaterialStack(Materials.Cobalt,2))).disableAutoGeneratedBlastFurnaceRecipes().setHasCorrespondingMoltenHot(true);
        Mangalloy = new Materials           ( 60, TextureSet.SET_SHINY,128.0F,51200,8,2|128, 57 ,152,213,0,"Mangalloy",         "Mangalloy",           0,0,3945,3945,false, false,4,1,1, Dyes.dyeRed,  2, Arrays.asList(new MaterialStack(Materials.Steel,5), new MaterialStack(Materials.Manganese,2))).disableAutoGeneratedBlastFurnaceRecipes().setHasCorrespondingMoltenHot(true);
        MaragingSteel300 = new Materials    ( 61, TextureSet.SET_SHINY,128.0F,51200,8,2|128, 99 ,112,135,0,"MaragingSteel300",  "Maraging Steel 300",  0,0,5001,5001,false, false,4,1,1, Dyes.dyeRed,  5, Arrays.asList(new MaterialStack(Materials.Steel,16), new MaterialStack(Materials.Titanium,1), new MaterialStack(Materials.Aluminium,1), new MaterialStack(Materials.Nickel,4), new MaterialStack(Materials.Cobalt,2))).disableAutoGeneratedBlastFurnaceRecipes().setHasCorrespondingMoltenHot(true);
        Stellite = new Materials            ( 88, TextureSet.SET_SHINY,128.0F,51200,8,2|128, 180,30 ,7  ,0,"Stellite",          "Stellite",            0,0,5399,5399,false, false,4,1,1, Dyes.dyeRed,  4, Arrays.asList(new MaterialStack(Materials.Cobalt,7), new MaterialStack(Materials.Chrome,3), new MaterialStack(Materials.Phosphor,2), new MaterialStack(Materials.Molybdenum,1))).disableAutoGeneratedBlastFurnaceRecipes().setHasCorrespondingMoltenHot(true);
        Zeron100 = new Materials            ( 68, TextureSet.SET_SHINY,128.0F,51200,8,2,     180,180,20, 0,"Zeron-100",         "Zeron-100",           0,0,5100,5100,false, false,4,1,1, Dyes.dyeRed,  6, Arrays.asList(new MaterialStack(Materials.Chrome,26), new MaterialStack(Materials.Nickel,6), new MaterialStack(Materials.Molybdenum,4), new MaterialStack(Materials.Copper,20), new MaterialStack(Materials.Tungsten,4), new MaterialStack(Materials.Steel,40))).disableAutoGeneratedBlastFurnaceRecipes().setHasCorrespondingMoltenHot(true);
        HastelloyN = new Materials          ( 69, TextureSet.SET_SHINY,128.0F,51200,8,2,     201,231,104,0,"HastelloyN",        "Hastelloy N",         0,0,4350,4350,false, false,4,1,1, Dyes.dyeRed,  5, Arrays.asList(new MaterialStack(Materials.Yttrium,8), new MaterialStack(Materials.Molybdenum,16), new MaterialStack(Materials.Chrome,8), new MaterialStack(Materials.Titanium,8), new MaterialStack(Materials.Nickel,60))).disableAutoGeneratedBlastFurnaceRecipes().setHasCorrespondingMoltenHot(true);
        Lafium = new Materials              ( 82, TextureSet.SET_SHINY,128.0F,51200,8,2,     144,167,154,0,"Lafium",            "Lafium",              0,0,6105,6105,false, false,4,1,1, Dyes.dyeRed,  6, Arrays.asList(new MaterialStack(HastelloyN,8), new MaterialStack(Samarium,2), new MaterialStack(Materials.Tungsten,4), new MaterialStack(Materials.Aluminium,6), new MaterialStack(Materials.Nickel,8), new MaterialStack(Materials.Carbon,2))).disableAutoGeneratedBlastFurnaceRecipes().setHasCorrespondingMoltenHot(true);
        CinobiteA243 = new Materials        ( 72, TextureSet.SET_SHINY,128.0F,51200,8,2,     245,245,220,0,"CinobiteA243",      "Cinobite A243",       0,0,7350,7350,false, false,4,1,1, Dyes.dyeRed,  6, Arrays.asList(new MaterialStack(Zeron100,16), new MaterialStack(Materials.Gadolinium,5), new MaterialStack(Materials.Aluminium,3), new MaterialStack(Materials.Tin,2), new MaterialStack(Materials.Titanium,12), new MaterialStack(Materials.Osmiridium,6))).disableAutoGeneratedBlastFurnaceRecipes().setHasCorrespondingMoltenHot(true);

        Potin = new Materials               ( 75, TextureSet.SET_SHINY,128.0F,51200,8,2,     201,151,129,0,"Potin",             "Potin",               0,0,1600,   0,false, false,4,1,1, Dyes.dyeRed,  3, Arrays.asList(new MaterialStack(Materials.Copper,6), new MaterialStack(Materials.Tin,2), new MaterialStack(Materials.Lead,1))).disableAutoGeneratedBlastFurnaceRecipes(); //Cu6Sn2Pb
        EglinSteel = new Materials          ( 76, TextureSet.SET_SHINY,128.0F,51200,8,2,     139,69 ,19 ,0,"EglinSteel",        "Eglin Steel",         0,0,2210,   0,false, false,4,1,1, Dyes.dyeRed,  5, Arrays.asList(new MaterialStack(Materials.Iron,5), new MaterialStack(Materials.Invar,5), new MaterialStack(Materials.Sulfur,1), new MaterialStack(Materials.Silicon,4), new MaterialStack(Materials.Carbon,1))).disableAutoGeneratedBlastFurnaceRecipes(); //Fe5Invar5S1Si4C1
        Birmabright = new Materials         ( 77, TextureSet.SET_SHINY,128.0F,51200,8,1|2|128,118,132,245,0,"Birmabright",       "Birmabright",       0,0,1476,   1476,true, false,4,1,1, Dyes.dyeRed,  3, Arrays.asList(new MaterialStack(Materials.Aluminium,5), new MaterialStack(Materials.Magnesium,1), new MaterialStack(Materials.Manganese,1))); //AlMgMn
        BT6 = new Materials                 ( 79, TextureSet.SET_SHINY,128.0F,51200,8,2|128, 129,57 ,133,0,"BT6",               "BT6",                 0,0,3200,3200,true, false,4,1,1, Dyes.dyeRed,  3, Arrays.asList(new MaterialStack(Materials.Iron,3), new MaterialStack(Materials.Carbon,1), new MaterialStack(Materials.Vanadium,5), new MaterialStack(Materials.Titanium,40), new MaterialStack(Materials.Aluminium,6))).disableAutoGeneratedBlastFurnaceRecipes(); //Fe3C1V5Ti40Al6
        Pikyonium64B = new Materials        ( 91, TextureSet.SET_SHINY,128.0F,51200,8,2,     52 ,103,186,0,"Pikyonium64B",      "Pikyonium64B",        0,0,9900,9900,false, false,4,1,1, Dyes.dyeRed,  7, Arrays.asList(new MaterialStack(Materials.Inconel792,16), new MaterialStack(Materials.EglinSteel,10), new MaterialStack(Materials.NaquadahEnriched,8),  new MaterialStack(Materials.Cerium,6), new MaterialStack(Materials.Antimony,4), new MaterialStack(Materials.Platinum,4), new MaterialStack(Materials.TungstenSteel,8))).disableAutoGeneratedBlastFurnaceRecipes(); //792Inconel16 EglinSteel10 Nqenriched8 Cerium6 Antimony4 Pt4 WSteel8
        Quantum = new Materials             ( 92, TextureSet.SET_SHINY,128.0F,51200,8,2,     118,132,245,0,"Quantum",           "Quantum",             0,0,12000,12000,false,false,4,1,1, Dyes.dyeRed,  6, Arrays.asList(new MaterialStack(Materials.Stellite,15), new MaterialStack(Materials.EnergeticAlloy,5), new MaterialStack(Materials.Carbon,5),  new MaterialStack(Materials.Gallium,5), new MaterialStack(Materials.Americium,5), new MaterialStack(Materials.Palladium,5))).disableAutoGeneratedBlastFurnaceRecipes(); //Stellite15 EnergeticAlloy5 Silicon5 Gallium5 Amercium5 Palladium5

        CokeCoal = new Materials            ( 860,TextureSet.SET_LIGNITE,1.0F,0,    1,4,     108,108,124,0,"CokeCoal",          "Coke Coal",           0,0,-1,  0,false, false,1,1,1, Dyes.dyeBlack,1, Arrays.asList(new MaterialStack(Carbon, 1)));

        RawRadox = new MaterialBuilder(-1, TextureSet.SET_DULL, "Raw Radox").setRGB(80, 30, 80).addFluid().constructMaterial();
        RadoxSuperLight = new MaterialBuilder(-1, TextureSet.SET_DULL, "Super Light Radox").setRGB(155, 0, 155).addGas().constructMaterial();
        RadoxLight = new MaterialBuilder(-1, TextureSet.SET_DULL, "Light Radox").setRGB(140, 0, 140).addGas().constructMaterial();
        RadoxHeavy = new MaterialBuilder(-1, TextureSet.SET_DULL, "Heavy Radox").setRGB(115, 0, 115).addFluid().constructMaterial();
        RadoxSuperHeavy = new MaterialBuilder(-1, TextureSet.SET_DULL, "Super Heavy Radox").setRGB(100, 0, 100).addFluid().constructMaterial();
        Xenoxene = new MaterialBuilder(-1, TextureSet.SET_DULL, "Xenoxene").setRGB(133, 130, 128).addFluid().constructMaterial();
        DelutedXenoxene = new MaterialBuilder(-1, TextureSet.SET_DULL, "Deluted Xenoxene").setRGB(206, 200, 196).addFluid().constructMaterial();
        RadoxCracked = new MaterialBuilder(-1, TextureSet.SET_DULL, "Cracked Radox").setRGB(180, 130, 180).addGas().constructMaterial();
        RadoxGas = new MaterialBuilder(-1, TextureSet.SET_DULL, "Radox Gas").setRGB(255, 130, 255).addGas().constructMaterial();
        RadoxPolymerHot = new MaterialBuilder(-1, TextureSet.SET_DULL, "Hot Radox Polymer").setRGB(255, 130, 255).addGas().constructMaterial();
        RadoxPolymer = new Materials(426, TextureSet.SET_DULL, 8.0F, 346, 3, 1 | 2 | 16, 133, 0, 128, 0, "RadoxPoly", "Radox Polymer", 0, 0, 6203, 0, true, false, 1, 1, 1, Dyes.dyePurple, 0, Arrays.asList(new MaterialStack(Carbon, 14), new MaterialStack(Materials.Osmium, 11), new MaterialStack(Materials.Oxygen, 7), new MaterialStack(Materials.Silver, 3), new MaterialStack(Materials.Ledox, 1))).setHasCorrespondingGas(true).setGasTemperature(12406).disableAutoGeneratedBlastFurnaceRecipes();

        SodiumPotassium = new MaterialBuilder(-1, TextureSet.SET_DULL, "Sodium Potassium (NaK)").setRGB(24, 212, 42).addFluid().constructMaterial();

        Osmirinigon = new Materials(66, TextureSet.SET_SHINY, 1.0F, 0, 1, 1 | 8, 60, 60, 240, 0, "Osmirinigon", "Osmirinigon", 0, 0, 3000, 0, false, false, 1, 1, 1, Dyes.dyeBlue);
        Naqlatigon = new Materials(71, TextureSet.SET_SHINY, 1.0F, 0, 1, 1 | 8, 70, 70, 70, 0, "Naqlatigon", "Naqlatigon", 0, 0, 5400, 0, false, false, 1, 1, 1, Dyes.dyeBlack);
        Mytryl = new Materials(387, TextureSet.SET_DULL, 8.0F, 512, 4, 1 | 2 | 128, 242, 100, 4, 0, "Mytryl", "Mytryl", 0, 0, 3600, 3600, true, false, 4, 1, 1, Dyes.dyeOrange);

        EnrichedTartarite = new MaterialBuilder(-1, TextureSet.SET_DULL, "Enriched Tartarite").setRGB(255, 120, 50).addFluid().constructMaterial();
        DraconiumPlasma = new MaterialBuilder(-1, TextureSet.SET_DULL, "Draconium Plasma").setRGB(122, 68, 176).addFluid().constructMaterial().setLiquidTemperature(10000);
        DraconiumAwakenedPlasma = new MaterialBuilder(-1, TextureSet.SET_DULL, "Awakened Draconium Plasma").setRGB(244, 78, 0).addFluid().constructMaterial().setLiquidTemperature(10800);


        //Materials which are renamed automatically
        Palygorskite = new Materials(FullersEarth, false);
        Adamantine = new Materials(Adamantium, true);
        Ashes = new Materials(Ash, false);
        DarkAshes = new Materials(DarkAsh, false);
        Abyssal = new Materials(Basalt, false);
        Adamant = new Materials(Adamantium, true);
        Americum = new Materials(Americium, false);
        Beryl = new Materials(Emerald, false);
        BlackGranite = new Materials(GraniteBlack, false);
        CalciumCarbonate = new Materials(Calcite, false);
        CrackedLightFuel = new Materials(LightFuel, false);
        CrackedHeavyFuel = new Materials(HeavyFuel, false);
        CreosoteOil = new Materials(Creosote, false);
        Chromium = new Materials(Chrome, false);
        Diesel = new Materials(Fuel, false);
        Enderpearl = new Materials(EnderPearl, false);
        Endereye = new Materials(EnderEye, false);
        EyeOfEnder = new Materials(EnderEye, false);
        Eyeofender = new Materials(EnderEye, false);
        Flour = new Materials(Wheat, false);
        Meat = new Materials(MeatRaw, false);
        Garnet = new Materials(GarnetRed, true);
        Granite = new Materials(GraniteBlack, false);
        Goethite = new Materials(BrownLimonite, false);
        Kalium = new Materials(Potassium, false);
        Lapislazuli = new Materials(Lapis, false);
        LapisLazuli = new Materials(Lapis, false);
        Monazit = new Materials(Monazite, false);
        Natrium = new Materials(Sodium, false);
        Mythril = new Materials(Mithril, false);
        NitroDiesel = new Materials(NitroFuel, false);
        Naquadriah = new Materials(Naquadria, false);
        Obby = new Materials(Obsidian, false);
        Peridot = new Materials(Olivine, true);
        Phosphorite = new Materials(Phosphorus, true);
        Quarried = new Materials(Marble, false);
        Quicksilver = new Materials(Mercury, true);
        QuickSilver = new Materials(Mercury, false);
        RefinedIron = new Materials(Iron, false);
        RedGranite = new Materials(GraniteRed, false);
        Sheldonite = new Materials(Cooperite, false);
        Soulsand = new Materials(SoulSand, false);
        Titan = new Materials(Titanium, false);
        Uran = new Materials(Uranium, false);
        Wolframite = new Materials(Tungstate, false);
        Wolframium = new Materials(Tungsten, false);
        Wolfram = new Materials(Tungsten, false);
        Nikolite = new Materials(Electrotine, false);

    }

    public final short[] mRGBa = new short[]{255, 255, 255, 0}, mMoltenRGBa = new short[]{255, 255, 255, 0};
    public TextureSet mIconSet;
    public int mMetaItemSubID;
    public boolean mUnificatable;
    public Materials mMaterialInto;
    public List<MaterialStack> mMaterialList = new ArrayList<MaterialStack>();
    public List<Materials> mOreByProducts = new ArrayList<Materials>(), mOreReRegistrations = new ArrayList<Materials>();
    public ArrayList<ItemStack> mMaterialItems = new ArrayList<ItemStack>();
    public Collection<SubTag> mSubTags = new LinkedHashSet<SubTag>();
    public Enchantment mEnchantmentTools = null, mEnchantmentArmors = null;
    public byte mEnchantmentToolsLevel = 0, mEnchantmentArmorsLevel = 0;
    public boolean mBlastFurnaceRequired = false, mAutoGenerateBlastFurnaceRecipes= true, mTransparent = false;
    public float mToolSpeed = 1.0F, mHeatDamage = 0.0F;
    public String mChemicalFormula = "?", mName = "null", mDefaultLocalName = "null", mCustomID = "null", mConfigSection = "null", mLocalizedName = "null";
    public Dyes mColor = Dyes._NULL;
    public short mMeltingPoint = 0, mBlastFurnaceTemp = 0, mGasTemp = 0;
    public int mTypes = 0;
    public int mDurability = 16, mFuelPower = 0, mFuelType = 0, mExtraData = 0, mOreValue = 0, mOreMultiplier = 1, mByProductMultiplier = 1, mSmeltingMultiplier = 1;
    public int mDensityMultiplier = 1, mDensityDivider = 1;
    public long mDensity = M;
    public Element mElement = null;
    public Materials mDirectSmelting = this, mOreReplacement = this, mMacerateInto = this, mSmeltInto = this, mArcSmeltInto = this, mHandleMaterial = this;
    public byte mToolQuality = 0;
    public boolean mHasParentMod = true, mHasPlasma = false, mHasGas = false, mCustomOre = false;
    public Fluid mSolid = null, mFluid = null, mGas = null, mPlasma = null;

    private boolean hasCorrespondingFluid = false, hasCorrespondingGas = false, hasCorrespondingSemi = false, canBeCracked = false, hasCorrespondingMoltenHot = false;
    private Fluid[] hydroCrackedFluids = new Fluid[3], steamCrackedFluids = new Fluid[3];

    /**
     * This Fluid is used as standard Unit for Molten Materials. 1296 is a Molten Block, that means 144 is one Material Unit worth of fluid.
     */
    public Fluid mStandardMoltenFluid = null, mStandardMoltenHot = null;

    static {
        genMaterials();
        initSubTags();

        WoodSealed				.setMaceratingInto(Wood				);
        NetherBrick				.setMaceratingInto(Netherrack		);

        NeodymiumMagnetic		.setSmeltingInto(Neodymium			).setMaceratingInto(Neodymium		).setArcSmeltingInto(Neodymium			);
        SteelMagnetic			.setSmeltingInto(Steel				).setMaceratingInto(Steel			).setArcSmeltingInto(Steel				);
        Iron					.setSmeltingInto(Iron				).setMaceratingInto(Iron			).setArcSmeltingInto(WroughtIron		);
        AnyIron					.setSmeltingInto(Iron				).setMaceratingInto(Iron			).setArcSmeltingInto(WroughtIron		);
        WroughtIron				.setSmeltingInto(WroughtIron		).setMaceratingInto(WroughtIron		).setArcSmeltingInto(WroughtIron		);
        IronMagnetic			.setSmeltingInto(Iron				).setMaceratingInto(Iron			).setArcSmeltingInto(WroughtIron		);
        Copper					.setSmeltingInto(Copper				).setMaceratingInto(Copper			).setArcSmeltingInto(AnnealedCopper		);
        AnyCopper				.setSmeltingInto(Copper				).setMaceratingInto(Copper			).setArcSmeltingInto(AnnealedCopper		);
        AnnealedCopper			.setSmeltingInto(AnnealedCopper		).setMaceratingInto(AnnealedCopper	).setArcSmeltingInto(AnnealedCopper		);
        EuropiumoxideMagnetic	.setSmeltingInto(Europiumoxide		).setMaceratingInto(Europiumoxide	).setArcSmeltingInto(Europiumoxide		);
        Netherrack				.setSmeltingInto(NetherBrick		);
        MeatRaw					.setSmeltingInto(MeatCooked			);
        Sand					.setSmeltingInto(Glass				);
        Ice						.setSmeltingInto(Water				);
        Snow					.setSmeltingInto(Water				);

        Mercury					.add(SubTag.SMELTING_TO_GEM);
        Cinnabar				.setDirectSmelting(Mercury		).add(SubTag.INDUCTIONSMELTING_LOW_OUTPUT).add(SubTag.SMELTING_TO_GEM);
        Tetrahedrite			.setDirectSmelting(Copper		).add(SubTag.INDUCTIONSMELTING_LOW_OUTPUT).add(SubTag.DONT_ADD_DEFAULT_BBF_RECIPE);
        Chalcopyrite			.setDirectSmelting(Copper		).add(SubTag.INDUCTIONSMELTING_LOW_OUTPUT).add(SubTag.DONT_ADD_DEFAULT_BBF_RECIPE);
        Malachite				.setDirectSmelting(Copper		).add(SubTag.INDUCTIONSMELTING_LOW_OUTPUT);
        Pentlandite				.setDirectSmelting(Nickel		).add(SubTag.INDUCTIONSMELTING_LOW_OUTPUT);
        Sphalerite				.setDirectSmelting(Zinc			).add(SubTag.INDUCTIONSMELTING_LOW_OUTPUT);
        Pyrite					.setDirectSmelting(Iron			).add(SubTag.INDUCTIONSMELTING_LOW_OUTPUT);
        BasalticMineralSand		.setDirectSmelting(Iron			).add(SubTag.INDUCTIONSMELTING_LOW_OUTPUT);
        GraniticMineralSand		.setDirectSmelting(Iron			).add(SubTag.INDUCTIONSMELTING_LOW_OUTPUT);
        YellowLimonite			.setDirectSmelting(Iron			).add(SubTag.INDUCTIONSMELTING_LOW_OUTPUT);
        BrownLimonite			.setDirectSmelting(Iron			);
        BandedIron				.setDirectSmelting(Iron			);
        Magnetite				.setDirectSmelting(Iron			);
        Cassiterite				.setDirectSmelting(Tin			);
        CassiteriteSand			.setDirectSmelting(Tin			);
        Chromite				.setDirectSmelting(Chrome		);
        Garnierite				.setDirectSmelting(Nickel		);
        Cobaltite				.setDirectSmelting(Cobalt		);
        Stibnite				.setDirectSmelting(Antimony		);
        Cooperite				.setDirectSmelting(Platinum		).add(SubTag.DONT_ADD_DEFAULT_BBF_RECIPE);
        Pyrolusite				.setDirectSmelting(Manganese	).add(SubTag.DONT_ADD_DEFAULT_BBF_RECIPE);
        Magnesite				.setDirectSmelting(Magnesium	).add(SubTag.DONT_ADD_DEFAULT_BBF_RECIPE);
        Molybdenite				.setDirectSmelting(Molybdenum	).add(SubTag.DONT_ADD_DEFAULT_BBF_RECIPE);
        Galena 					.setDirectSmelting(Lead			).add(SubTag.DONT_ADD_DEFAULT_BBF_RECIPE);

        Amber					.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        Salt					.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        RockSalt				.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        Scheelite				.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        Tungstate				.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        Cassiterite				.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        CassiteriteSand			.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        NetherQuartz			.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        CertusQuartz			.setOreMultiplier( 2).setSmeltingMultiplier( 2);
        Phosphorus				.setOreMultiplier( 3).setSmeltingMultiplier( 3);
        Saltpeter				.setOreMultiplier( 4).setSmeltingMultiplier( 4);
        Apatite					.setOreMultiplier( 4).setSmeltingMultiplier( 4).setByProductMultiplier(2);
        Nikolite				.setOreMultiplier( 5).setSmeltingMultiplier( 5);
        Redstone				.setOreMultiplier( 5).setSmeltingMultiplier( 5);
        Glowstone				.setOreMultiplier( 5).setSmeltingMultiplier( 5);
        Lapis					.setOreMultiplier( 6).setSmeltingMultiplier( 6).setByProductMultiplier(4);
        Sodalite				.setOreMultiplier( 6).setSmeltingMultiplier( 6).setByProductMultiplier(4);
        Lazurite				.setOreMultiplier( 6).setSmeltingMultiplier( 6).setByProductMultiplier(4);
        Monazite				.setOreMultiplier( 8).setSmeltingMultiplier( 8).setByProductMultiplier(2);

        Plastic					.setEnchantmentForTools(Enchantment.knockback, 1);
        PolyvinylChloride		.setEnchantmentForTools(Enchantment.knockback, 1);
        Polystyrene				.setEnchantmentForTools(Enchantment.knockback, 1);
        Rubber					.setEnchantmentForTools(Enchantment.knockback, 2);
        StyreneButadieneRubber	.setEnchantmentForTools(Enchantment.knockback, 2);

        Steeleaf				.setEnchantmentForTools(Enchantment.fortune, 2);
        Mithril					.setEnchantmentForTools(Enchantment.fortune, 3);

        Flint					.setEnchantmentForTools(Enchantment.fireAspect, 1);
        DarkIron				.setEnchantmentForTools(Enchantment.fireAspect, 2);
        Blaze					.setEnchantmentForTools(Enchantment.fireAspect, 3);

        Amber					.setEnchantmentForTools(Enchantment.silkTouch, 1);
        EnderPearl				.setEnchantmentForTools(Enchantment.silkTouch, 1);
        Enderium				.setEnchantmentForTools(Enchantment.silkTouch, 1);
        NetherStar				.setEnchantmentForTools(Enchantment.silkTouch, 1);

        BlackBronze				.setEnchantmentForTools(Enchantment.smite, 2);
        Gold					.setEnchantmentForTools(Enchantment.smite, 3);
        RoseGold				.setEnchantmentForTools(Enchantment.smite, 4);
        Platinum				.setEnchantmentForTools(Enchantment.smite, 5);

        Lead					.setEnchantmentForTools(Enchantment.baneOfArthropods, 2);
        Nickel					.setEnchantmentForTools(Enchantment.baneOfArthropods, 2);
        Invar					.setEnchantmentForTools(Enchantment.baneOfArthropods, 3);
        Antimony				.setEnchantmentForTools(Enchantment.baneOfArthropods, 3);
        BatteryAlloy			.setEnchantmentForTools(Enchantment.baneOfArthropods, 4);
        Bismuth					.setEnchantmentForTools(Enchantment.baneOfArthropods, 4);
        BismuthBronze			.setEnchantmentForTools(Enchantment.baneOfArthropods, 5);

        Iron					.setEnchantmentForTools(Enchantment.sharpness, 1);
        Bronze					.setEnchantmentForTools(Enchantment.sharpness, 1);
        Brass					.setEnchantmentForTools(Enchantment.sharpness, 2);
        HSLA					.setEnchantmentForTools(Enchantment.sharpness, 2);
        Steel					.setEnchantmentForTools(Enchantment.sharpness, 2);
        WroughtIron				.setEnchantmentForTools(Enchantment.sharpness, 2);
        StainlessSteel			.setEnchantmentForTools(Enchantment.sharpness, 3);
        BlackSteel				.setEnchantmentForTools(Enchantment.sharpness, 4);
        RedSteel				.setEnchantmentForTools(Enchantment.sharpness, 4);
        BlueSteel				.setEnchantmentForTools(Enchantment.sharpness, 5);
        DamascusSteel			.setEnchantmentForTools(Enchantment.sharpness, 5);
        TungstenCarbide			.setEnchantmentForTools(Enchantment.sharpness, 5);
        HSSE					.setEnchantmentForTools(Enchantment.sharpness, 5);
        HSSG					.setEnchantmentForTools(Enchantment.sharpness, 4);
        HSSS					.setEnchantmentForTools(Enchantment.sharpness, 5);

        Steeleaf				.setEnchantmentForArmors(Enchantment.protection, 2);

        FryingOilHot			.setHeatDamage(1.0F);
        Lava					.setHeatDamage(3.0F);

        Chalcopyrite			.addOreByProducts(Pyrite				, Cobalt				, Cadmium				, Gold			);
        Sphalerite				.addOreByProducts(GarnetYellow			, Cadmium				, Gallium				, Zinc			);
        MeteoricIron			.addOreByProducts(Iron					, Nickel				, Iridium				, Platinum		);
        GlauconiteSand			.addOreByProducts(Sodium				, Aluminium				, Iron					);
        Glauconite				.addOreByProducts(Sodium				, Aluminium				, Iron					);
        Vermiculite				.addOreByProducts(Iron					, Aluminium				, Magnesium				);
        FullersEarth			.addOreByProducts(Aluminium				, Silicon				, Magnesium				);
        Bentonite				.addOreByProducts(Aluminium				, Calcium				, Magnesium				);
        Uraninite				.addOreByProducts(Uranium				, Thorium				, Uranium235			);
        Pitchblende				.addOreByProducts(Thorium				, Uranium				, Lead					);
        Galena					.addOreByProducts(Sulfur				, Silver				, Lead					);
        Lapis					.addOreByProducts(Lazurite				, Sodalite				, Pyrite				);
        Pyrite					.addOreByProducts(Sulfur				, Phosphorus			, Iron					);
        Copper					.addOreByProducts(Cobalt				, Gold					, Nickel				);
        Nickel					.addOreByProducts(Cobalt				, Platinum				, Iron					);
        GarnetRed				.addOreByProducts(Spessartine			, Pyrope				, Almandine				);
        GarnetYellow			.addOreByProducts(Andradite				, Grossular				, Uvarovite				);
        Cooperite				.addOreByProducts(Palladium				, Nickel				, Iridium				);
        Cinnabar				.addOreByProducts(Redstone				, Sulfur				, Glowstone				);
        Tantalite				.addOreByProducts(Manganese				, Niobium				, Tantalum				);
        Pollucite				.addOreByProducts(Caesium				, Aluminium				, Rubidium				);
        Asbestos				.addOreByProducts(Asbestos				, Silicon				, Magnesium				);
        Pentlandite				.addOreByProducts(Iron					, Sulfur				, Cobalt				);
        Uranium					.addOreByProducts(Lead					, Uranium235			, Thorium				);
        Scheelite				.addOreByProducts(Manganese				, Molybdenum			, Calcium				);
        Tungstate				.addOreByProducts(Manganese				, Silver				, Lithium				);
        Bauxite					.addOreByProducts(Grossular				, Rutile				, Gallium				);
        Redstone				.addOreByProducts(Cinnabar				, RareEarth				, Glowstone				);
        Monazite				.addOreByProducts(Thorium				, Neodymium				, RareEarth				);
        Forcicium				.addOreByProducts(Orichalcum			, Neodymium				, Lutetium				);
        Forcillium				.addOreByProducts(Thorium				, Neodymium				, RareEarth				);
        Malachite				.addOreByProducts(Copper				, BrownLimonite			, Calcite				);
        YellowLimonite			.addOreByProducts(Nickel				, BrownLimonite			, Cobalt				);
        Lepidolite				.addOreByProducts(Lithium				, Caesium				, Boron					);
        Andradite				.addOreByProducts(GarnetYellow			, Iron					, Boron					);
        Pyrolusite				.addOreByProducts(Manganese				, Tantalite             , Niobium               );
        Phosphorus				.addOreByProducts(Apatite				, Phosphate				, Pyrochlore            );
        Apatite					.addOreByProducts(Phosphorus			, Phosphate             , Pyrochlore            );
        Pyrochlore              .addOreByProducts(Apatite               , Calcite               , Niobium               );
        Quartzite				.addOreByProducts(CertusQuartz			, Barite				);
        CertusQuartz			.addOreByProducts(Quartzite				, Barite				);
        BrownLimonite			.addOreByProducts(Malachite				, YellowLimonite		);
        Neodymium				.addOreByProducts(Monazite				, RareEarth				);
        Bastnasite				.addOreByProducts(Neodymium				, RareEarth				);
        Glowstone				.addOreByProducts(Redstone				, Gold					);
        Zinc					.addOreByProducts(Tin					, Gallium				);
        Tungsten				.addOreByProducts(Manganese				, Molybdenum			);
        Diatomite				.addOreByProducts(BandedIron			, Sapphire				);
        Iron					.addOreByProducts(Nickel				, Tin					);
        Gold					.addOreByProducts(Copper				, Nickel				);
        Tin						.addOreByProducts(Iron					, Zinc					);
        Antimony				.addOreByProducts(Zinc					, Iron					);
        Silver					.addOreByProducts(Lead					, Sulfur				);
        Lead					.addOreByProducts(Silver				, Sulfur				);
        Thorium					.addOreByProducts(Uranium				, Lead					);
        Plutonium				.addOreByProducts(Uranium				, Lead					);
        Electrum				.addOreByProducts(Gold					, Silver				);
        Bronze					.addOreByProducts(Copper				, Tin					);
        Brass					.addOreByProducts(Copper				, Zinc					);
        Coal					.addOreByProducts(Lignite				, Thorium				);
        Ilmenite				.addOreByProducts(Iron					, Rutile				);
        Manganese				.addOreByProducts(Chrome				, Iron					);
        Sapphire				.addOreByProducts(Aluminium				, GreenSapphire			);
        GreenSapphire			.addOreByProducts(Aluminium				, Sapphire				);
        Platinum				.addOreByProducts(Nickel				, Iridium				);
        Emerald					.addOreByProducts(Beryllium				, Aluminium				);
        Olivine					.addOreByProducts(Pyrope				, Magnesium				);
        Chrome					.addOreByProducts(Iron					, Magnesium				);
        Chromite				.addOreByProducts(Iron					, Magnesium				);
        Tetrahedrite			.addOreByProducts(Antimony				, Zinc					);
        GarnetSand				.addOreByProducts(GarnetRed				, GarnetYellow			);
        Magnetite				.addOreByProducts(Iron					, Gold					);
        GraniticMineralSand		.addOreByProducts(GraniteBlack			, Magnetite				);
        BasalticMineralSand		.addOreByProducts(Basalt				, Magnetite				);
        Basalt					.addOreByProducts(Olivine				, DarkAsh				);
        VanadiumMagnetite		.addOreByProducts(Magnetite				, Vanadium				);
        Lazurite				.addOreByProducts(Sodalite				, Lapis					);
        Sodalite				.addOreByProducts(Lazurite				, Lapis					);
        Spodumene				.addOreByProducts(Aluminium				, Lithium				);
        Ruby					.addOreByProducts(Chrome				, GarnetRed				);
        Iridium					.addOreByProducts(Platinum				, Osmium				);
        Pyrope					.addOreByProducts(GarnetRed				, Magnesium				);
        Almandine				.addOreByProducts(GarnetRed				, Aluminium				);
        Spessartine				.addOreByProducts(GarnetRed				, Manganese				);
        Grossular				.addOreByProducts(GarnetYellow			, Calcium				);
        Uvarovite				.addOreByProducts(GarnetYellow			, Chrome				);
        Calcite					.addOreByProducts(Andradite				, Malachite				);
        NaquadahEnriched		.addOreByProducts(Naquadah				, Naquadria				);
        Salt					.addOreByProducts(RockSalt				, Borax					);
        RockSalt				.addOreByProducts(Salt					, Borax					);
        Naquadah				.addOreByProducts(NaquadahEnriched		);
        Molybdenite				.addOreByProducts(Molybdenum			);
        Stibnite				.addOreByProducts(Antimony				);
        Garnierite				.addOreByProducts(Nickel				);
        Lignite					.addOreByProducts(Coal					);
        Diamond					.addOreByProducts(Graphite				);
        Beryllium				.addOreByProducts(Emerald				);
        Nikolite				.addOreByProducts(Diamond				);
        Magnesite				.addOreByProducts(Magnesium				);
        NetherQuartz			.addOreByProducts(Netherrack			);
        DeepIron				.addOreByProducts(Iron					);
        DarkIron				.addOreByProducts(Iron					);
        MeteoricIron			.addOreByProducts(Iron					);
        Steel					.addOreByProducts(Iron					);
        HSLA					.addOreByProducts(Iron					);
        Mithril					.addOreByProducts(Platinum				);
        Graphite				.addOreByProducts(Carbon				);
        Netherrack				.addOreByProducts(Sulfur				);
        Flint					.addOreByProducts(Obsidian				);
        Cobaltite				.addOreByProducts(Cobalt				);
        Cobalt					.addOreByProducts(Cobaltite				);
        Sulfur					.addOreByProducts(Sulfur				);
        Saltpeter				.addOreByProducts(Saltpeter				);
        Endstone				.addOreByProducts(Helium_3				);
        Osmium					.addOreByProducts(Iridium				);
        Magnesium				.addOreByProducts(Olivine				);
        Aluminium				.addOreByProducts(Bauxite				);
        Titanium				.addOreByProducts(Almandine				);
        Obsidian				.addOreByProducts(Olivine				);
        Ash						.addOreByProducts(Carbon				);
        DarkAsh					.addOreByProducts(Carbon				);
        Marble					.addOreByProducts(Calcite				);
        Clay					.addOreByProducts(Clay					);
        Cassiterite				.addOreByProducts(Tin					);
        CassiteriteSand			.addOreByProducts(Tin					);
        GraniteBlack			.addOreByProducts(Biotite				);
        GraniteRed				.addOreByProducts(PotassiumFeldspar		);
        Phosphate				.addOreByProducts(Phosphor				);
        Phosphor				.addOreByProducts(Phosphate				);
        Tanzanite				.addOreByProducts(Opal					);
        Opal					.addOreByProducts(Tanzanite				);
        Amethyst				.addOreByProducts(Amethyst				);
        FoolsRuby				.addOreByProducts(Jasper				);
        Amber					.addOreByProducts(Amber					);
        Topaz					.addOreByProducts(BlueTopaz				);
        BlueTopaz				.addOreByProducts(Topaz					);
        Neutronium				.addOreByProducts(Neutronium			);
        Lithium					.addOreByProducts(Lithium				);
        Silicon					.addOreByProducts(SiliconDioxide		);
        Desh				    .addOreByProducts(Tungsten				, Iridium				);
        Draconium				.addOreByProducts(Osmium				, Naquadah				);
        Mithril				    .addOreByProducts(Quartzite				, Platinum				, Mytryl                );
        Mytryl				    .addOreByProducts(Tartarite				, Zinc				    );

        Glue.mChemicalFormula = "No Horses were harmed for the Production";
        UUAmplifier.mChemicalFormula = "Accelerates the Mass Fabricator";
        WoodSealed.mChemicalFormula = "";
        Wood.mChemicalFormula = "";
        FoolsRuby.mChemicalFormula = Ruby.mChemicalFormula;

        Naquadah.mMoltenRGBa[0] = 0;
        Naquadah.mMoltenRGBa[1] = 255;
        Naquadah.mMoltenRGBa[2] = 0;
        Naquadah.mMoltenRGBa[3] = 0;
        NaquadahEnriched.mMoltenRGBa[0] = 64;
        NaquadahEnriched.mMoltenRGBa[1] = 255;
        NaquadahEnriched.mMoltenRGBa[2] = 64;
        NaquadahEnriched.mMoltenRGBa[3] = 0;
        Naquadria.mMoltenRGBa[0] = 128;
        Naquadria.mMoltenRGBa[1] = 255;
        Naquadria.mMoltenRGBa[2] = 128;
        Naquadria.mMoltenRGBa[3] = 0;

        Naquadah.mChemicalFormula = "Nq";
        NaquadahEnriched.mChemicalFormula = "Nq+";
        Naquadria.mChemicalFormula = "Nq*";
        NaquadahAlloy.mChemicalFormula="NqIr\u2083OsC";
        Adamantium.mChemicalFormula="Ad";
        MeteoricIron.mChemicalFormula="SpFe";
        MeteoricSteel.mChemicalFormula="SpFe\u2085\u2080C";
        Duranium.mChemicalFormula="Du";
        Tritanium.mChemicalFormula="Tn";
        BlackPlutonium.mChemicalFormula="SpPu";
        Ledox.mChemicalFormula="SpPb";
        Quantium.mChemicalFormula="Qt";
        Desh.mChemicalFormula="De";
        Oriharukon.mChemicalFormula="Oh";
        Draconium.mChemicalFormula="D";
        DraconiumAwakened.mChemicalFormula="D*";
        BlueAlloy.mChemicalFormula="AgRp\u2084";
        RedAlloy.mChemicalFormula="Cu("+Redstone.mChemicalFormula+")\u2084";
        ElectrumFlux.mChemicalFormula="The formula is too long...";
        Infinity.mChemicalFormula="If*";
        InfinityCatalyst.mChemicalFormula="If";
        CosmicNeutronium.mChemicalFormula="SpNt";
    }

    private static void initSubTags() {
        SubTag.ELECTROMAGNETIC_SEPERATION_NEODYMIUM.addTo(Bastnasite, Monazite, Forcicium, Forcillium);
        SubTag.ELECTROMAGNETIC_SEPERATION_GOLD.addTo(Magnetite, VanadiumMagnetite, BasalticMineralSand, GraniticMineralSand);
        SubTag.ELECTROMAGNETIC_SEPERATION_IRON.addTo(YellowLimonite, BrownLimonite, Pyrite, BandedIron, Nickel, Vermiculite, Glauconite, GlauconiteSand, Pentlandite, Tin, Antimony, Ilmenite, Manganese, Chrome, Chromite, Andradite);
        SubTag.BLASTFURNACE_CALCITE_DOUBLE.addTo(Pyrite, BrownLimonite, YellowLimonite, BasalticMineralSand, GraniticMineralSand, Magnetite);
        SubTag.BLASTFURNACE_CALCITE_TRIPLE.addTo(Iron, DeepIron, WroughtIron, MeteoricIron);
        SubTag.WASHING_MERCURY.addTo(Gold, Silver, Osmium, Mithril, Platinum, Cooperite);
        SubTag.WASHING_SODIUMPERSULFATE.addTo(Zinc, Nickel, Copper, Cobalt, Cobaltite, Tetrahedrite);
        SubTag.METAL.addTo(AnyIron, AnyCopper, AnyBronze, Metal, Aluminium, Americium, Antimony, Beryllium, Bismuth, Caesium, Cerium, Chrome, Cobalt, Copper, Europium, Gadolinium, Gallium, Gold,
                Indium, Iridium, Iron, Lanthanum, Lead, Lutetium, Magnesium, Manganese, Mercury, Niobium, Molybdenum, Neodymium, Neutronium, Nickel, Osmium, Palladium, Platinum, Plutonium, Plutonium241,
                Rubidium, Samarium, Silicon, Silver, Tantalum, Tellurium, Thorium, Tin, Titanium, Tungsten, Uranium, Uranium235, Vanadium, Ytterbium, Yttrium,
                Zinc, DarkSteel, TinAlloy, ConductiveIron, ElectricalSteel, EnergeticAlloy, VibrantAlloy,
                PulsatingIron, Adamantium, Ardite, DarkIron,
                Desh, Duranium, ElectrumFlux, Enderium, EnderiumBase, Eximite, HSLA, Infuscolium, MeteoricIron,
                MeteoricSteel, Naquadah, NaquadahAlloy, NaquadahEnriched, Naquadria, Orichalcum, Phoenixite,
                Tartarite, Tritanium, Osmiridium, Sunnarium, AnnealedCopper, BatteryAlloy, Brass, Bronze, ChromiumDioxide, Cupronickel, DeepIron,
                Electrum, Invar, Kanthal, Magnalium, Nichrome, NiobiumTitanium, SolderingAlloy, StainlessSteel, Steel, Ultimet, VanadiumGallium, WroughtIron,
                YttriumBariumCuprate, Alumite, Manyullyn, Steeleaf, RoseGold, BlackBronze, BismuthBronze, BlackSteel, RedSteel, BlueSteel, DamascusSteel,
                TungstenSteel, Mithril, BlueAlloy, RedAlloy, CobaltBrass, IronMagnetic, SteelMagnetic, NeodymiumMagnetic, EuropiumoxideMagnetic, HSSG, HSSE, HSSS, TungstenCarbide, Endium,
                VanadiumSteel, Infinity, InfinityCatalyst, BlackPlutonium, Draconium, DraconiumAwakened, Pentacadmiummagnesiumhexaoxid,Titaniumonabariumdecacoppereikosaoxid,
                Uraniumtriplatinid, Vanadiumtriindinid, Tetraindiumditindibariumtitaniumheptacoppertetrakaidekaoxid, Tetranaquadahdiindiumhexaplatiumosminid);

        SubTag.PUREIMPURE.addTo(
                Sphalerite, DeepIron, Ledox, Bentonite, Copper, Galena, Aluminium, Thorium, DraconiumAwakened, BandedIron, Endstone, Beryllium, Magnesite, Europium, GreenSapphire, Uraninite, Uranium235, BrownLimonite, Iridium, Coal, Stone, Chrome,
                DraconiumAwakened, Bastnasite, Almandine, Opal, Grossular, Cinnabar, Emerald, Flint, Tantalite, Spessartine, BlackPlutonium, Infuscolium, BrownLimonite, Phosphorus, GarnetRed, Sheldonite, Pyrochlore, Molybdenum,
                CertusQuartz, Salt, Pyrope, Talc, Infuscolium, Pentlandite, Neutronium, MysteriousCrystal, Topaz, Osmium, Tungstate, Pyrite, Zinc, Diatomite, Tantalite, Amethyst, Ruby, Bismuth, Marble, Europium, Spodumene, Magnetite,
                Glauconite, Calcite, Soapstone, Powellite, Gold, Quantium, Osmium, Netherrack, Infinity, Orichalcum, MeteoricIron, Pyrolusite, Chalcopyrite, InfinityCatalyst, Manganese, Quartzite, Desh, Scheelite, Olivine, Oriharukon, Naquadah, NaquadahEnriched,
                Iron, Neodymium, Chromite, Nickel, Plutonium, Sapphire, Lazurite, BlueTopaz, RedGranite, Garnierite, Monazite, Amber, Magnesite, Apatite, Thorium, Diamond, Barite, Tanzanite, Redstone, Lepidolite, Malachite, Palladium, Lead,
                Saltpeter, Lapotron, BrownLimonite, Tin, Platinum, Cassiterite, Adamantium, Sodalite, Uranium235, Stibnite, Bauxite, Wulfenite, CosmicNeutronium, Spessartine, Molybdenite, Sulfur, Naquadria, Phosphate, Lignite, CokeCoal, Titanium, Vanadium,
                VanadiumMagnetite, Graphite, NetherQuartz, Lithium, GreenSapphire, CassiteriteSand, Silver, RockSalt, Basalt, Ilmenite, Tetrahedrite, Bauxite, YellowLimonite, GarnetYellow, Cobaltite, Lapis, Uranium, Uran, Uraninite, Antimony, Borax, Draconium, Arsenic, Sheldonite);

        SubTag.FOOD.addTo(MeatRaw, MeatCooked, Ice, Water, Salt, Chili, Cocoa, Cheese, Coffee, Chocolate, Milk, Honey, FryingOilHot, FishOil, SeedOil, SeedOilLin, SeedOilHemp, Wheat, Sugar);

        SubTag.NO_FREEZING.addTo(StyreneButadieneRubber, GumMetal, BorosilicateGlass, Plastic, Rubber, Polycaprolactam, Epoxid, Polystyrene, EpoxidFiberReinforced, Lithium, Silicone, Inconel690, Polybenzimidazole, Beryllium, PolyphenyleneSulfide,
                PolyvinylChloride, Carbon, Mangalloy, Polytetrafluoroethylene, Titaniolum, MaragingSteel250, MaragingSteel300, Grisium, Obsidian, Magnesium, Magnalium, Aluminium, EglinSteel, Inconel792, Silicon, Birmabright, CinobiteA243,
                Zeron100, NickelZincFerrite, Zamak, Potassium, Duraluminium, Quantum, BlueSteel, BlackSteel, TiBetaC, RedSteel, Pikyonium64B, Chrome, Nitinol, Nitinol60, Talonite, VanadiumSteel, Manganese, Stellite, Steeleaf, WroughtIron,
                DamascusSteel, Iron, Invar, Steel, Kovar, IronMagnetic, SteelMagnetic, Nickel, CobaltBrass, Cobalt, Cupronickel, Copper, RedAlloy, AnnealedCopper, Brass, HastelloyN, Zinc, Potin, Gallium, IndiumGalliumPhosphide, EuropiumoxideMagnetic,
                GalliumArsenide, Lafium, Arsenic, Bronze,  RadoxPolymer, ChromiumDioxide, TinAlloy, BismuthBronze, Molybdenum, Orichalcum,  ElectricalSteel, ConductiveIron, EnergeticAlloy, DarkIron, Sunnarium, Phoenixite, Soularium,
                Endium, PulsatingIron, RedstoneAlloy, Duranium, DarkSteel, Ledox, MeteoricIron, Silver, BlueAlloy, Indium, Tin, Antimony, Caesium, Lanthanum, Cerium, Neodymium, SolderingAlloy, NeodymiumMagnetic, Electrum, RoseGold, Tantalum, BatteryAlloy,
                Gold, Lead, Bismuth, Thorium, Uranium235, Uranium, Plutonium, Plutonium241, Platinum, Americum, Tritanium);

        Wood.add(SubTag.WOOD, SubTag.FLAMMABLE, SubTag.NO_SMELTING, SubTag.NO_SMASHING);
        WoodSealed.add(SubTag.WOOD, SubTag.FLAMMABLE, SubTag.NO_SMELTING, SubTag.NO_SMASHING, SubTag.NO_WORKING);
        Steeleaf.add(SubTag.WOOD, SubTag.FLAMMABLE, SubTag.MAGICAL, SubTag.MORTAR_GRINDABLE, SubTag.NO_SMELTING);

        MeatRaw.add(SubTag.NO_SMASHING);
        MeatCooked.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Snow.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.NO_RECYCLING);
        Ice.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.NO_RECYCLING);
        Water.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.NO_RECYCLING);
        Sulfur.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.FLAMMABLE);
        Saltpeter.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.FLAMMABLE);
        Graphite.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.FLAMMABLE, SubTag.NO_SMELTING);

        Wheat.add(SubTag.FLAMMABLE, SubTag.MORTAR_GRINDABLE);
        Paper.add(SubTag.FLAMMABLE, SubTag.NO_SMELTING, SubTag.NO_SMASHING, SubTag.MORTAR_GRINDABLE, SubTag.PAPER);
        Coal.add(SubTag.FLAMMABLE, SubTag.NO_SMELTING, SubTag.NO_SMASHING, SubTag.MORTAR_GRINDABLE);
        Charcoal.add(SubTag.FLAMMABLE, SubTag.NO_SMELTING, SubTag.NO_SMASHING, SubTag.MORTAR_GRINDABLE);
        Lignite.add(SubTag.FLAMMABLE, SubTag.NO_SMELTING, SubTag.NO_SMASHING, SubTag.MORTAR_GRINDABLE);

        Rubber.add(SubTag.FLAMMABLE, SubTag.NO_SMASHING, SubTag.BOUNCY, SubTag.STRETCHY);
        StyreneButadieneRubber.add(SubTag.FLAMMABLE, SubTag.NO_SMASHING, SubTag.BOUNCY, SubTag.STRETCHY);
        Plastic.add(SubTag.FLAMMABLE, SubTag.NO_SMASHING, SubTag.BOUNCY);
        PolyvinylChloride.add(SubTag.FLAMMABLE, SubTag.NO_SMASHING, SubTag.BOUNCY);
        Polystyrene.add(SubTag.FLAMMABLE, SubTag.NO_SMASHING, SubTag.BOUNCY);
        Silicone.add(SubTag.FLAMMABLE, SubTag.NO_SMASHING, SubTag.BOUNCY, SubTag.STRETCHY);

        TNT.add(SubTag.FLAMMABLE, SubTag.EXPLOSIVE, SubTag.NO_SMELTING, SubTag.NO_SMASHING);
        Gunpowder.add(SubTag.FLAMMABLE, SubTag.EXPLOSIVE, SubTag.NO_SMELTING, SubTag.NO_SMASHING);
        Glyceryl.add(SubTag.FLAMMABLE, SubTag.EXPLOSIVE, SubTag.NO_SMELTING, SubTag.NO_SMASHING);
        NitroFuel.add(SubTag.FLAMMABLE, SubTag.EXPLOSIVE, SubTag.NO_SMELTING, SubTag.NO_SMASHING);
        NitroCarbon.add(SubTag.FLAMMABLE, SubTag.EXPLOSIVE, SubTag.NO_SMELTING, SubTag.NO_SMASHING);

        Lead.add(SubTag.MORTAR_GRINDABLE, SubTag.SOLDERING_MATERIAL, SubTag.SOLDERING_MATERIAL_BAD);
        Tin.add(SubTag.MORTAR_GRINDABLE, SubTag.SOLDERING_MATERIAL);
        SolderingAlloy.add(SubTag.MORTAR_GRINDABLE, SubTag.SOLDERING_MATERIAL, SubTag.SOLDERING_MATERIAL_GOOD);

        Cheese.add(SubTag.SMELTING_TO_FLUID);
        Sugar.add(SubTag.SMELTING_TO_FLUID);

        Concrete.add(SubTag.STONE, SubTag.NO_SMASHING, SubTag.SMELTING_TO_FLUID);
        ConstructionFoam.add(SubTag.STONE, SubTag.NO_SMASHING, SubTag.EXPLOSIVE, SubTag.NO_SMELTING);
        Redstone.add(SubTag.STONE, SubTag.NO_SMASHING, SubTag.UNBURNABLE, SubTag.SMELTING_TO_FLUID, SubTag.PULVERIZING_CINNABAR);
        Glowstone.add(SubTag.STONE, SubTag.NO_SMASHING, SubTag.UNBURNABLE, SubTag.SMELTING_TO_FLUID);
        Nikolite.add(SubTag.STONE, SubTag.NO_SMASHING, SubTag.UNBURNABLE, SubTag.SMELTING_TO_FLUID);
        Netherrack.add(SubTag.STONE, SubTag.NO_SMASHING, SubTag.UNBURNABLE, SubTag.FLAMMABLE);
        Stone.add(SubTag.STONE, SubTag.NO_SMASHING, SubTag.NO_RECYCLING);
        Brick.add(SubTag.STONE, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        NetherBrick.add(SubTag.STONE, SubTag.NO_SMASHING);
        Endstone.add(SubTag.STONE, SubTag.NO_SMASHING);
        Marble.add(SubTag.STONE, SubTag.NO_SMASHING);
        Basalt.add(SubTag.STONE, SubTag.NO_SMASHING);
        Obsidian.add(SubTag.STONE, SubTag.NO_SMASHING);
        Flint.add(SubTag.STONE, SubTag.NO_SMASHING, SubTag.MORTAR_GRINDABLE);
        GraniteRed.add(SubTag.STONE, SubTag.NO_SMASHING);
        GraniteBlack.add(SubTag.STONE, SubTag.NO_SMASHING);
        Salt.add(SubTag.STONE, SubTag.NO_SMASHING);
        RockSalt.add(SubTag.STONE, SubTag.NO_SMASHING);

        Sand.add(SubTag.NO_RECYCLING);

        Gold.add(SubTag.MORTAR_GRINDABLE);
        Silver.add(SubTag.MORTAR_GRINDABLE);
        Iron.add(SubTag.MORTAR_GRINDABLE);
        IronMagnetic.add(SubTag.MORTAR_GRINDABLE);
        HSLA.add(SubTag.MORTAR_GRINDABLE);
        Steel.add(SubTag.MORTAR_GRINDABLE);
        SteelMagnetic.add(SubTag.MORTAR_GRINDABLE);
        Zinc.add(SubTag.MORTAR_GRINDABLE);
        Antimony.add(SubTag.MORTAR_GRINDABLE);
        Copper.add(SubTag.MORTAR_GRINDABLE);
        AnnealedCopper.add(SubTag.MORTAR_GRINDABLE);
        Bronze.add(SubTag.MORTAR_GRINDABLE);
        Nickel.add(SubTag.MORTAR_GRINDABLE);
        Invar.add(SubTag.MORTAR_GRINDABLE);
        Brass.add(SubTag.MORTAR_GRINDABLE);
        WroughtIron.add(SubTag.MORTAR_GRINDABLE);
        Electrum.add(SubTag.MORTAR_GRINDABLE);
        Clay.add(SubTag.MORTAR_GRINDABLE);

        Glass.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_RECYCLING, SubTag.SMELTING_TO_FLUID);
        ReinforcedGlass.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_RECYCLING, SubTag.SMELTING_TO_FLUID);
        MysteriousCrystal.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        EnrichedMysteriousCrystal.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Diamond.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.FLAMMABLE);
        Emerald.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Amethyst.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Tanzanite.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Topaz.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        BlueTopaz.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Amber.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        GreenSapphire.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Sapphire.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Ruby.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        FoolsRuby.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Opal.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Olivine.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Jasper.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        GarnetRed.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        GarnetYellow.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        CrystalFlux.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Crystal.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Apatite.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE);
        Lapis.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE);
        Sodalite.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE);
        Lazurite.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE);
        Monazite.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE);
        Quartzite.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE, SubTag.QUARTZ);
        Quartz.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE, SubTag.QUARTZ);
        SiliconDioxide.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE, SubTag.QUARTZ);
        NetherQuartz.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE, SubTag.QUARTZ);
        CertusQuartz.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE, SubTag.QUARTZ);
        Fluix.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE, SubTag.QUARTZ);
        Phosphorus.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.FLAMMABLE, SubTag.EXPLOSIVE);
        Phosphate.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.FLAMMABLE, SubTag.EXPLOSIVE);
        NetherStar.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.MAGICAL, SubTag.UNBURNABLE);
        EnderPearl.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.MAGICAL, SubTag.PEARL);
        EnderEye.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.MAGICAL, SubTag.PEARL);
        Forcicium.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE, SubTag.MAGICAL);
        Forcillium.add(SubTag.CRYSTAL, SubTag.NO_SMASHING, SubTag.NO_SMELTING, SubTag.CRYSTALLISABLE, SubTag.MAGICAL);

        Primitive.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Basic.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Good.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Advanced.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Data.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Elite.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Master.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Ultimate.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Superconductor.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Infinite.add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Bio                     .add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        Energy                  .add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        SuperconductorMV        .add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        SuperconductorHV        .add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        SuperconductorEV        .add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        SuperconductorIV        .add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        SuperconductorLuV       .add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        SuperconductorZPM       .add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        SuperconductorUV       .add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);
        SuperconductorUEV       .add(SubTag.NO_SMASHING, SubTag.NO_SMELTING);


        Blaze.add(SubTag.NO_SMELTING, SubTag.SMELTING_TO_FLUID, SubTag.MORTAR_GRINDABLE, SubTag.UNBURNABLE, SubTag.BURNING);
    }

    public static void init() {
        new ProcessingConfig();
        if (!GT_Mod.gregtechproxy.mEnableAllMaterials) new ProcessingModSupport();
        for (IMaterialHandler aRegistrator : mMaterialHandlers) {
            aRegistrator.onMaterialsInit(); //This is where addon mods can add/manipulate materials
        }
        initMaterialProperties(); //No more material addition or manipulation should be done past this point!
        MATERIALS_ARRAY = MATERIALS_MAP.values().toArray(new Materials[MATERIALS_MAP.size()]); //Generate standard object array. This is a lot faster to loop over.
        VALUES = Arrays.asList(MATERIALS_ARRAY);
        if(!GT_Mod.gregtechproxy.mEnableAllComponentsWithoutIntegration)
        if (!GT_Mod.gregtechproxy.mEnableAllComponents) OrePrefixes.initMaterialComponents();
        for (Materials aMaterial : MATERIALS_ARRAY) {
            if (aMaterial.mMetaItemSubID >= 0) {
                if (aMaterial.mMetaItemSubID < 1000) {
                    if (aMaterial.mHasParentMod) {
                        if (GregTech_API.sGeneratedMaterials[aMaterial.mMetaItemSubID] == null) {
                            GregTech_API.sGeneratedMaterials[aMaterial.mMetaItemSubID] = aMaterial;
                        } else throw new IllegalArgumentException("The Material Index " + aMaterial.mMetaItemSubID + " for " + aMaterial.mName + " is already used!");
                    }
                } else throw new IllegalArgumentException("The Material Index " + aMaterial.mMetaItemSubID + " for " + aMaterial.mName + " is/over the maximum of 1000");
            }
        }
        // Fills empty spaces with materials, causes horrible load times.
        /*for (int i = 0; i < GregTech_API.sGeneratedMaterials.length; i++) {
            if (GregTech_API.sGeneratedMaterials[i] == null) {
                GregTech_API.sGeneratedMaterials[i] = new Materials(i, TextureSet.SET_NONE, 1.0F, 0, 2, 1|2|4|8|16|32|64|128, 92, 0, 168, 0, "TestMat" + i, 0, 0, -1, 0, false, false, 3, 1, 1, Dyes._NULL, "testmat");
            }
        }*/
    }


    public static void initMaterialProperties() {
        GT_Mod.gregtechproxy.mChangeHarvestLevels = GregTech_API.sMaterialProperties.get("harvestlevel", "ActivateHarvestLevelChange", false);
        GT_Mod.gregtechproxy.mMaxHarvestLevel = Math.min(15, GregTech_API.sMaterialProperties.get("harvestlevel", "MaxHarvestLevel",7));
        GT_Mod.gregtechproxy.mGraniteHavestLevel = GregTech_API.sMaterialProperties.get("harvestlevel", "GraniteHarvestLevel", 3);
        StringBuilder aConfigPathSB = new StringBuilder();
        for (Materials aMaterial : MATERIALS_MAP.values()) { /** The only place where MATERIALS_MAP should be used to loop over all materials. **/
            if (aMaterial != null && aMaterial != Materials._NULL && aMaterial != Materials.Empty) {
                aConfigPathSB.append("materials.").append(aMaterial.mConfigSection).append(".").append(aMaterial.mCustomOre ? aMaterial.mCustomID : aMaterial.mName);
                String aConfigPath = aConfigPathSB.toString();
                aMaterial.mMetaItemSubID = GregTech_API.sMaterialProperties.get(aConfigPath, "MaterialID", aMaterial.mCustomOre ? -1 : aMaterial.mMetaItemSubID);
                aMaterial.mDefaultLocalName = GregTech_API.sMaterialProperties.get(aConfigPath, "MaterialName", aMaterial.mCustomOre ? "CustomOre" + aMaterial.mCustomID : aMaterial.mDefaultLocalName);
                aMaterial.mMeltingPoint = (short) GregTech_API.sMaterialProperties.get(aConfigPath, "MeltingPoint", aMaterial.mMeltingPoint);
                aMaterial.mBlastFurnaceRequired = GregTech_API.sMaterialProperties.get(aConfigPath, "BlastFurnaceRequired", aMaterial.mBlastFurnaceRequired);
                aMaterial.mBlastFurnaceTemp = (short) GregTech_API.sMaterialProperties.get(aConfigPath, "BlastFurnaceTemp", aMaterial.mBlastFurnaceTemp);
                aMaterial.mAutoGenerateBlastFurnaceRecipes = GregTech_API.sMaterialProperties.get(aConfigPath, "AutoGenerateBlastFurnaceRecipes", aMaterial.mAutoGenerateBlastFurnaceRecipes);
                aMaterial.mFuelPower = GregTech_API.sMaterialProperties.get(aConfigPath, "FuelPower", aMaterial.mFuelPower);
                aMaterial.mFuelType = GregTech_API.sMaterialProperties.get(aConfigPath, "FuelType", aMaterial.mFuelType);
                aMaterial.mOreValue = GregTech_API.sMaterialProperties.get(aConfigPath, "OreValue", aMaterial.mOreValue);
                aMaterial.mDensityMultiplier = GregTech_API.sMaterialProperties.get(aConfigPath, "DensityMultiplier", aMaterial.mDensityMultiplier);
                aMaterial.mDensityDivider = GregTech_API.sMaterialProperties.get(aConfigPath, "DensityDivider", aMaterial.mDensityDivider);
                aMaterial.mDensity = (long) GregTech_API.sMaterialProperties.get(aConfigPath, "Density", (M * aMaterial.mDensityMultiplier) / aMaterial.mDensityDivider);
                aMaterial.mDurability = GregTech_API.sMaterialProperties.get(aConfigPath, "ToolDurability", aMaterial.mDurability);
                aMaterial.mToolSpeed = (float) GregTech_API.sMaterialProperties.get(aConfigPath, "ToolSpeed", aMaterial.mToolSpeed);
                aMaterial.mToolQuality = (byte) GregTech_API.sMaterialProperties.get(aConfigPath, "ToolQuality", aMaterial.mToolQuality);
                //aMaterial.mIconSet = TextureSet.valueOf(GregTech_API.sMaterialProperties.get(aConfigPath.toString(), "IconSet", aMaterial.mIconSet.mSetName));
                aMaterial.mTransparent = GregTech_API.sMaterialProperties.get(aConfigPath, "Transparent", aMaterial.mTransparent);
                String aColor = GregTech_API.sMaterialProperties.get(aConfigPath, "DyeColor", aMaterial.mColor == Dyes._NULL ? "None" : aMaterial.mColor.toString());
                aMaterial.mColor = aColor.equals("None") ? Dyes._NULL : Dyes.get(aColor);
                String[] aRGBA = GregTech_API.sMaterialProperties.get(aConfigPath, "MatRGBA", String.valueOf(aMaterial.mRGBa[0] + "," + aMaterial.mRGBa[1] + "," + aMaterial.mRGBa[2] + "," + aMaterial.mRGBa[3] + ",")).split(",");
                aMaterial.mRGBa[0] = Short.parseShort(aRGBA[0]);
                aMaterial.mRGBa[1] = Short.parseShort(aRGBA[1]);
                aMaterial.mRGBa[2] = Short.parseShort(aRGBA[2]);
                aMaterial.mRGBa[3] = Short.parseShort(aRGBA[3]);
                aMaterial.mTypes = GregTech_API.sMaterialProperties.get(aConfigPath, "MaterialTypes", aMaterial.mCustomOre ? 1|2|4|8|16|32|64|128 : aMaterial.mTypes);
                aMaterial.mUnificatable = GregTech_API.sMaterialProperties.get(aConfigPath, "Unificatable", aMaterial.mUnificatable);
                aMaterial.mChemicalFormula = GregTech_API.sMaterialProperties.get(aConfigPath, "ChemicalFormula", aMaterial.mChemicalFormula);
                aMaterial.mGasTemp = (short) GregTech_API.sMaterialProperties.get(aConfigPath, "GasTemp", aMaterial.mGasTemp);
                aMaterial.setOreMultiplier(GregTech_API.sMaterialProperties.get(aConfigPath, "OreMultiplier", aMaterial.mOreMultiplier));
                aMaterial.setSmeltingMultiplier(GregTech_API.sMaterialProperties.get(aConfigPath, "OreSmeltingMultiplier", aMaterial.mSmeltingMultiplier));
                aMaterial.setByProductMultiplier(GregTech_API.sMaterialProperties.get(aConfigPath, "OreByProductMultiplier", aMaterial.mByProductMultiplier));
                aMaterial.setHeatDamage((float) GregTech_API.sMaterialProperties.get(aConfigPath, "HeatDamage", aMaterial.mHeatDamage));
                aMaterial.mSmeltInto = MATERIALS_MAP.get(GregTech_API.sMaterialProperties.get(aConfigPath, "MaterialSmeltInto", aMaterial.mCustomOre ? "CustomMat" + aMaterial.mCustomID : aMaterial.mSmeltInto.mName));
                if (aMaterial.mSmeltInto == null) {
                    GT_Log.err.print("GregTech failed to load the property MaterialSmeltInto of Material:" + aMaterial.mName);
                    aMaterial.mSmeltInto = Materials._NULL;
                }
                aMaterial.mMacerateInto = MATERIALS_MAP.get(GregTech_API.sMaterialProperties.get(aConfigPath, "MaterialMacerateInto", aMaterial.mCustomOre ? "CustomMat" + aMaterial.mCustomID : aMaterial.mMacerateInto.mName));
                if (aMaterial.mMacerateInto == null) {
                    GT_Log.err.print("GregTech failed to load the property MaterialMacerateInto of Material:" + aMaterial.mName);
                    aMaterial.mMacerateInto = Materials._NULL;
                }
                aMaterial.mArcSmeltInto = MATERIALS_MAP.get(GregTech_API.sMaterialProperties.get(aConfigPath, "MaterialArcSmeltInto", aMaterial.mCustomOre ? "CustomMat" + aMaterial.mCustomID : aMaterial.mArcSmeltInto.mName));
                if (aMaterial.mArcSmeltInto == null) {
                    GT_Log.err.print("GregTech failed to load the property MaterialArcSmeltInto of Material:" + aMaterial.mName);
                    aMaterial.mArcSmeltInto = Materials._NULL;
                }
                aMaterial.mDirectSmelting = MATERIALS_MAP.get(GregTech_API.sMaterialProperties.get(aConfigPath, "MaterialDirectSmeltInto", aMaterial.mCustomOre ? "CustomMat" + aMaterial.mCustomID : aMaterial.mDirectSmelting.mName));
                if (aMaterial.mDirectSmelting == null) {
                    GT_Log.err.print("GregTech failed to load the property MaterialDirectSmeltInto of Material:" + aMaterial.mName);
                    aMaterial.mDirectSmelting = Materials._NULL;
                }
                aMaterial.mHasParentMod = GregTech_API.sMaterialProperties.get(aConfigPath, "HasParentMod", aMaterial.mHasParentMod);
                if (aMaterial.mHasPlasma = GregTech_API.sMaterialProperties.get(aConfigPath, "AddPlasma", aMaterial.mHasPlasma)) GT_Mod.gregtechproxy.addAutogeneratedPlasmaFluid(aMaterial);
                if (aMaterial.mHasGas = GregTech_API.sMaterialProperties.get(aConfigPath, "AddGas", aMaterial.mHasGas)) GT_Mod.gregtechproxy.addFluid(aMaterial.mName.toLowerCase(), aMaterial.mDefaultLocalName, aMaterial, 2, aMaterial.mGasTemp);
                aMaterial.mEnchantmentToolsLevel = (byte) GregTech_API.sMaterialProperties.get(aConfigPath, "EnchantmentLevel", aMaterial.mEnchantmentToolsLevel);
                String aEnchantmentName = GregTech_API.sMaterialProperties.get(aConfigPath, "Enchantment", aMaterial.mEnchantmentTools != null ? aMaterial.mEnchantmentTools.getName() : "");
                if (aMaterial.mEnchantmentTools != null && !aEnchantmentName.equals(aMaterial.mEnchantmentTools.getName())) {
                    for (int i = 0; i < Enchantment.enchantmentsList.length; i++) {
                        if (aEnchantmentName.equals(Enchantment.enchantmentsList[i].getName())) aMaterial.mEnchantmentTools = Enchantment.enchantmentsList[i];
                    }
                }
                /**
                 * Converts the pre-defined list of SubTags from a material into a list of SubTag names for setting/getting to/from the config.
                 * It is then converted to a String[] and finally to a singular String for insertion into the config
                 * If the config string is different from the default, we then want to clear the Materials SubTags and insert new ones from the config string.
                 */
                List<String> aSubTags = new ArrayList<>();
                for (SubTag aTag : aMaterial.mSubTags) aSubTags.add(aTag.mName);
                String aDefaultTagString = "," + aSubTags.toString().replace(" ", "").replace("[", "").replace("]", "");
                String aConfigTagString = GregTech_API.sMaterialProperties.get(aConfigPath, "ListSubTags", aDefaultTagString);
                if (!aConfigTagString.equals(aDefaultTagString)) {
                    aMaterial.mSubTags.clear();
                    if (aConfigTagString.length() > 0) {
                        aSubTags = new ArrayList<>(Arrays.asList(aConfigTagString.split(",")));
                        for (String aTagString : aSubTags) {
                            SubTag aTag = SubTag.sSubTags.get(aTagString);
                            if (aTag != null) aMaterial.mSubTags.add(aTag);
                        }
                    }
                }
                /** Same principal as SubTags **/
                List<String> aOreByProducts = new ArrayList<>();
                for (Materials aMat : aMaterial.mOreByProducts) aOreByProducts.add(aMat.mName);
                String aDefaultMatByProString = "," + aOreByProducts.toString().replace(" ", "").replace("[", "").replace("]", "");
                String aConfigMatByProString = GregTech_API.sMaterialProperties.get(aConfigPath, "ListMaterialByProducts", aDefaultMatByProString);
                if (!aConfigMatByProString.equals(aDefaultMatByProString)) {
                    aMaterial.mOreByProducts.clear();
                    if (aConfigMatByProString.length() > 0) {
                        aOreByProducts = new ArrayList<>(Arrays.asList(aConfigMatByProString.split(",")));
                        for (String aMaterialString : aOreByProducts) {
                            Materials aMat = MATERIALS_MAP.get(aMaterialString);
                            if (aMat != null) aMaterial.mOreByProducts.add(aMat);
                        }
                    }
                }
                /** Same principal as SubTags **/
                List<String> aOreReRegistrations = new ArrayList<>();
                for (Materials aMat : aMaterial.mOreReRegistrations) aOreReRegistrations.add(aMat.mName);
                String aDefaultMatReRegString = "," + aOreReRegistrations.toString().replace(" ", "").replace("[", "").replace("]", "");
                String aConfigMatMatReRegString = GregTech_API.sMaterialProperties.get(aConfigPath, "ListMaterialReRegistrations", aDefaultMatReRegString);
                if (!aConfigMatMatReRegString.equals(aDefaultMatReRegString)) {
                    aMaterial.mOreReRegistrations.clear();
                    if (aConfigMatMatReRegString.length() > 0) {
                        aOreReRegistrations = new ArrayList<>(Arrays.asList(aConfigMatMatReRegString.split(",")));
                        for (String aMaterialString : aOreReRegistrations) {
                            Materials aMat = MATERIALS_MAP.get(aMaterialString);
                            if (aMat != null) aMaterial.mOreReRegistrations.add(aMat);
                        }
                    }
                }
                /** Moved the harvest level changes from GT_Mod to have less things iterating over MATERIALS_ARRAY **/
                if (GT_Mod.gregtechproxy.mChangeHarvestLevels && aMaterial.mToolQuality > 0 && aMaterial.mMetaItemSubID < GT_Mod.gregtechproxy.mHarvestLevel.length && aMaterial.mMetaItemSubID >= 0) {
                    GT_Mod.gregtechproxy.mHarvestLevel[aMaterial.mMetaItemSubID] = GregTech_API.sMaterialProperties.get(aConfigPath, "HarvestLevel", aMaterial.mToolQuality);
                }
                /** Moved from GT_Proxy? (Not sure)**/
                aMaterial.mHandleMaterial = (aMaterial == Desh ? aMaterial.mHandleMaterial : aMaterial == Diamond ? Wood : aMaterial.contains(SubTag.BURNING) ? Blaze : aMaterial.getMass() > Element.Tc.getMass() * 2 ? TungstenSteel : aMaterial.getMass() > Element.Tc.getMass() ? Steel : Wood);
            }
            aConfigPathSB.setLength(0);
        }
    }

    public Materials(int aMetaItemSubID, TextureSet aIconSet, float aToolSpeed, int aDurability, int aToolQuality, boolean aUnificatable, String aName, String aDefaultLocalName) {
        this(aMetaItemSubID, aIconSet, aToolSpeed, aDurability, aToolQuality, aUnificatable, aName, aDefaultLocalName, "ore", false, "null");
    }

    public Materials(int aMetaItemSubID, TextureSet aIconSet, float aToolSpeed, int aDurability, int aToolQuality, boolean aUnificatable, String aName, String aDefaultLocalName, String aConfigSection, boolean aCustomOre, String aCustomID) {
        mMetaItemSubID = aMetaItemSubID;
        mDefaultLocalName = aDefaultLocalName;
        mName = aName;
        MATERIALS_MAP.put(mName, this);
        mCustomOre = aCustomOre;
        mCustomID = aCustomID;
        mConfigSection = aConfigSection;
        mUnificatable = aUnificatable;
        mDurability = aDurability;
        mToolSpeed = aToolSpeed;
        mToolQuality = (byte) aToolQuality;
        mMaterialInto = this;
        mIconSet = aIconSet;
    }

    public Materials(Materials aMaterialInto, boolean aReRegisterIntoThis) {
        mUnificatable = false;
        mDefaultLocalName = aMaterialInto.mDefaultLocalName;
        mName = aMaterialInto.mName;
        mMaterialInto = aMaterialInto.mMaterialInto;
        if (aReRegisterIntoThis) mMaterialInto.mOreReRegistrations.add(this);
        mChemicalFormula = aMaterialInto.mChemicalFormula;
        mMetaItemSubID = -1;
        mIconSet = SET_NONE;
    }

    public Materials(int aMetaItemSubID, TextureSet aIconSet, float aToolSpeed, int aDurability, int aToolQuality, int aTypes, int aR, int aG, int aB, int aA, String aName, String aDefaultLocalName, int aFuelType, int aFuelPower, int aMeltingPoint, int aBlastFurnaceTemp, boolean aBlastFurnaceRequired, boolean aTransparent, int aOreValue, int aDensityMultiplier, int aDensityDivider, Dyes aColor) {
        this(aMetaItemSubID, aIconSet, aToolSpeed, aDurability, aToolQuality, aTypes, aR, aG, aB, aA, aName, aDefaultLocalName, aFuelType, aFuelPower, aMeltingPoint, aBlastFurnaceTemp, aBlastFurnaceRequired, aTransparent, aOreValue, aDensityMultiplier, aDensityDivider, aColor, "ore", false, "null");
    }

    public Materials(int aMetaItemSubID, TextureSet aIconSet, float aToolSpeed, int aDurability, int aToolQuality, int aTypes, int aR, int aG, int aB, int aA, String aName, String aDefaultLocalName, int aFuelType, int aFuelPower, int aMeltingPoint, int aBlastFurnaceTemp, boolean aBlastFurnaceRequired, boolean aTransparent, int aOreValue, int aDensityMultiplier, int aDensityDivider, Dyes aColor, String aConfigSection) {
        this(aMetaItemSubID, aIconSet, aToolSpeed, aDurability, aToolQuality, aTypes, aR, aG, aB, aA, aName, aDefaultLocalName, aFuelType, aFuelPower, aMeltingPoint, aBlastFurnaceTemp, aBlastFurnaceRequired, aTransparent, aOreValue, aDensityMultiplier, aDensityDivider, aColor, aConfigSection, false, "null");
    }

    /**
     * @param aMetaItemSubID        the Sub-ID used in my own MetaItems. Range 0-1000. -1 for no Material
     * @param aTypes                which kind of Items should be generated. Bitmask as follows:
     *                              1 = Dusts of all kinds.
     *                              2 = Dusts, Ingots, Plates, Rods/Sticks, Machine Components and other Metal specific things.
     *                              4 = Dusts, Gems, Plates, Lenses (if transparent).
     *                              8 = Dusts, Impure Dusts, crushed Ores, purified Ores, centrifuged Ores etc.
     *                              16 = Cells
     *                              32 = Plasma Cells
     *                              64 = Tool Heads
     *                              128 = Gears
     *                              256 = Designates something as empty (only used for the Empty material)
     * @param aR,                   aG, aB Color of the Material 0-255 each.
     * @param aA                    transparency of the Material Texture. 0 = fully visible, 255 = Invisible.
     * @param aName                 The Name used as Default for localization.
     * @param aFuelType             Type of Generator to get Energy from this Material.
     * @param aFuelPower            EU generated. Will be multiplied by 1000, also additionally multiplied by 2 for Gems.
     * @param aMeltingPoint         Used to determine the smelting Costs in Furnii. >>>>**ADD 20000 to remove EBF recipes to add them MANUALLY ! :D**<<<<
     * @param aBlastFurnaceTemp     Used to determine the needed Heat capactiy Costs in Blast Furnii.
     * @param aBlastFurnaceRequired If this requires a Blast Furnace.
     * @param aColor                Vanilla MC Wool Color which comes the closest to this.
     */
    public Materials(int aMetaItemSubID, TextureSet aIconSet, float aToolSpeed, int aDurability, int aToolQuality, int aTypes, int aR, int aG, int aB, int aA, String aName, String aDefaultLocalName, int aFuelType, int aFuelPower, int aMeltingPoint, int aBlastFurnaceTemp, boolean aBlastFurnaceRequired, boolean aTransparent, int aOreValue, int aDensityMultiplier, int aDensityDivider, Dyes aColor, String aConfigSection, boolean aCustomOre, String aCustomID) {
        this(aMetaItemSubID, aIconSet, aToolSpeed, aDurability, aToolQuality, true, aName, aDefaultLocalName, aConfigSection, aCustomOre, aCustomID);
        mMeltingPoint = (short) aMeltingPoint;
        mBlastFurnaceRequired = aBlastFurnaceRequired;
        mBlastFurnaceTemp = (short) aBlastFurnaceTemp;
        mTransparent = aTransparent;
        mFuelPower = aFuelPower;
        mFuelType = aFuelType;
        mOreValue = aOreValue;
        mDensityMultiplier = aDensityMultiplier;
        mDensityDivider = aDensityDivider;
        mDensity = (M * aDensityMultiplier) / aDensityDivider;
        mColor = aColor;
        mRGBa[0] = mMoltenRGBa[0] = (short) aR;
        mRGBa[1] = mMoltenRGBa[1] = (short) aG;
        mRGBa[2] = mMoltenRGBa[2] = (short) aB;
        mRGBa[3] = mMoltenRGBa[3] = (short) aA;
        mTypes = aTypes;
        if (mColor != null) add(SubTag.HAS_COLOR);
        if (mTransparent) add(SubTag.TRANSPARENT);
        if ((mTypes & 2) != 0) add(SubTag.SMELTING_TO_FLUID);
    }

    public Materials(int aMetaItemSubID, TextureSet aIconSet, float aToolSpeed, int aDurability, int aToolQuality, int aTypes, int aR, int aG, int aB, int aA, String aName, String aDefaultLocalName, int aFuelType, int aFuelPower, int aMeltingPoint, int aBlastFurnaceTemp, boolean aBlastFurnaceRequired, boolean aTransparent, int aOreValue, int aDensityMultiplier, int aDensityDivider, Dyes aColor, Element aElement) {
        this(aMetaItemSubID, aIconSet, aToolSpeed, aDurability, aToolQuality, aTypes, aR, aG, aB, aA, aName, aDefaultLocalName, aFuelType, aFuelPower, aMeltingPoint, aBlastFurnaceTemp, aBlastFurnaceRequired, aTransparent, aOreValue, aDensityMultiplier, aDensityDivider, aColor);
        mElement = aElement;
        mElement.mLinkedMaterials.add(this);
        if (aElement == Element._NULL) {
            mChemicalFormula = "Empty";
        } else {
            mChemicalFormula = aElement.toString();
            mChemicalFormula = mChemicalFormula.replaceAll("_", "-");
        }
    }

    public Materials(int aMetaItemSubID, TextureSet aIconSet, float aToolSpeed, int aDurability, int aToolQuality, int aTypes, int aR, int aG, int aB, int aA, String aName, String aDefaultLocalName, int aFuelType, int aFuelPower, int aMeltingPoint, int aBlastFurnaceTemp, boolean aBlastFurnaceRequired, boolean aTransparent, int aOreValue, int aDensityMultiplier, int aDensityDivider, Dyes aColor, int aExtraData, List<MaterialStack> aMaterialList) {
        this(aMetaItemSubID, aIconSet, aToolSpeed, aDurability, aToolQuality, aTypes, aR, aG, aB, aA, aName, aDefaultLocalName, aFuelType, aFuelPower, aMeltingPoint, aBlastFurnaceTemp, aBlastFurnaceRequired, aTransparent, aOreValue, aDensityMultiplier, aDensityDivider, aColor);
        mExtraData = aExtraData;
        mMaterialList.addAll(aMaterialList);
        mChemicalFormula = "";
        for (MaterialStack tMaterial : mMaterialList) mChemicalFormula += tMaterial.toString();
        mChemicalFormula = mChemicalFormula.replaceAll("_", "-");

        int tAmountOfComponents = 0, tMeltingPoint = 0;
        for (MaterialStack tMaterial : mMaterialList) {
            tAmountOfComponents += tMaterial.mAmount;
            if (tMaterial.mMaterial.mMeltingPoint > 0)
                tMeltingPoint += tMaterial.mMaterial.mMeltingPoint * tMaterial.mAmount;
        }

        if (mMeltingPoint < 0) mMeltingPoint = (short) (tMeltingPoint / tAmountOfComponents);

        tAmountOfComponents *= aDensityMultiplier;
        tAmountOfComponents /= aDensityDivider;
    }

    public Materials disableAutoGeneratedBlastFurnaceRecipes(){
        mAutoGenerateBlastFurnaceRecipes=false;
        return this;
    }

    /**
     * This is for keeping compatibility with addons mods (Such as TinkersGregworks etc) that looped over the old materials enum
     */
    @Deprecated
    public String name() {
        return mName;
    }

    /**
     * This is for keeping compatibility with addons mods (Such as TinkersGregworks etc) that looped over the old materials enum
     */
    @Deprecated
    public static Materials valueOf(String aMaterialName) {
        return getMaterialsMap().get(aMaterialName);
    }

    /**
     * This is for keeping compatibility with addons mods (Such as TinkersGregworks etc) that looped over the old materials enum
     */
    public static Materials[] values() {
        return MATERIALS_ARRAY;
    }

    /**
     * This should only be used for getting a Material by its name as a String. Do not loop over this map, use values().
     */
    public static Map<String, Materials> getMaterialsMap() {
        return MATERIALS_MAP;
    }

    public static Materials get(String aMaterialName) {
        Materials aMaterial = getMaterialsMap().get(aMaterialName);
        if (aMaterial != null) return aMaterial;
        return Materials._NULL;
    }

    public static Materials getRealMaterial(String aMaterialName) {
        return get(aMaterialName).mMaterialInto;
    }

    public boolean isRadioactive() {
        if (mElement != null) return mElement.mHalfLifeSeconds >= 0;
        for (MaterialStack tMaterial : mMaterialList) if (tMaterial.mMaterial.isRadioactive()) return true;
        return false;
    }

    public long getProtons() {
        if (mElement != null) return mElement.getProtons();
        if (mMaterialList.size() <= 0) return Element.Tc.getProtons();
        long rAmount = 0, tAmount = 0;
        for (MaterialStack tMaterial : mMaterialList) {
            tAmount += tMaterial.mAmount;
            rAmount += tMaterial.mAmount * tMaterial.mMaterial.getProtons();
        }
        return (getDensity() * rAmount) / (tAmount * M);
    }

    public long getNeutrons() {
        if (mElement != null) return mElement.getNeutrons();
        if (mMaterialList.size() <= 0) return Element.Tc.getNeutrons();
        long rAmount = 0, tAmount = 0;
        for (MaterialStack tMaterial : mMaterialList) {
            tAmount += tMaterial.mAmount;
            rAmount += tMaterial.mAmount * tMaterial.mMaterial.getNeutrons();
        }
        return (getDensity() * rAmount) / (tAmount * M);
    }

    public long getMass() {
        if (mElement != null) return mElement.getMass();
        if (mMaterialList.size() <= 0) return Element.Tc.getMass();
        long rAmount = 0, tAmount = 0;
        for (MaterialStack tMaterial : mMaterialList) {
            tAmount += tMaterial.mAmount;
            rAmount += tMaterial.mAmount * tMaterial.mMaterial.getMass();
        }
        return (getDensity() * rAmount) / (tAmount * M);
    }

    public long getDensity() {
        return mDensity;
    }

    public String getToolTip() {
        return getToolTip(1, false);
    }

    public String getToolTip(boolean aShowQuestionMarks) {
        return getToolTip(1, aShowQuestionMarks);
    }

    public String getToolTip(long aMultiplier) {
        return getToolTip(aMultiplier, false);
    }

    public String getToolTip(long aMultiplier, boolean aShowQuestionMarks) {
        if (!aShowQuestionMarks && mChemicalFormula.equals("?")) return "";
        if (aMultiplier >= M * 2 && !mMaterialList.isEmpty()) {
            return ((mElement != null || (mMaterialList.size() < 2 && mMaterialList.get(0).mAmount == 1)) ? mChemicalFormula : "(" + mChemicalFormula + ")") + aMultiplier;
        }
        return mChemicalFormula;
    }

    /**
     * Adds a Class implementing IMaterialRegistrator to the master list
     */
    public static boolean add(IMaterialHandler aRegistrator) {
        if (aRegistrator == null) return false;
        return mMaterialHandlers.add(aRegistrator);
    }

    /**
     * Adds an ItemStack to this Material.
     */
    public Materials add(ItemStack aStack) {
        if (aStack != null && !contains(aStack)) mMaterialItems.add(aStack);
        return this;
    }

    /**
     * This is used to determine if any of the ItemStacks belongs to this Material.
     */
    public boolean contains(ItemStack... aStacks) {
        if (aStacks == null || aStacks.length <= 0) return false;
        for (ItemStack tStack : mMaterialItems)
            for (ItemStack aStack : aStacks)
                if (GT_Utility.areStacksEqual(aStack, tStack, !tStack.hasTagCompound())) return true;
        return false;
    }

    /**
     * This is used to determine if an ItemStack belongs to this Material.
     */
    public boolean remove(ItemStack aStack) {
        if (aStack == null) return false;
        boolean temp = false;
        int mMaterialItems_sS=mMaterialItems.size();
        for (int i = 0; i < mMaterialItems_sS; i++)
            if (GT_Utility.areStacksEqual(aStack, mMaterialItems.get(i))) {
                mMaterialItems.remove(i--);
                temp = true;
            }
        return temp;
    }

    /**
     * Adds a SubTag to this Material
     */
    @Override
    public ISubTagContainer add(SubTag... aTags) {
        if (aTags != null) for (SubTag aTag : aTags)
            if (aTag != null && !contains(aTag)) {
                aTag.addContainerToList(this);
                mSubTags.add(aTag);
            }
        return this;
    }

    /**
     * If this Material has this exact SubTag
     */
    @Override
    public boolean contains(SubTag aTag) {
        return mSubTags.contains(aTag);
    }

    /**
     * Removes a SubTag from this Material
     */
    @Override
    public boolean remove(SubTag aTag) {
        return mSubTags.remove(aTag);
    }

    /**
     * Sets the Heat Damage for this Material (negative = frost)
     */
    public Materials setHeatDamage(float aHeatDamage) {
        mHeatDamage = aHeatDamage;
        return this;
    }

    /**
     * Adds a Material to the List of Byproducts when grinding this Ore.
     * Is used for more precise Ore grinding, so that it is possible to choose between certain kinds of Materials.
     */
    public Materials addOreByProduct(Materials aMaterial) {
        if (!mOreByProducts.contains(aMaterial.mMaterialInto)) mOreByProducts.add(aMaterial.mMaterialInto);
        return this;
    }

    /**
     * Adds multiple Materials to the List of Byproducts when grinding this Ore.
     * Is used for more precise Ore grinding, so that it is possible to choose between certain kinds of Materials.
     */
    public Materials addOreByProducts(Materials... aMaterials) {
        for (Materials tMaterial : aMaterials) if (tMaterial != null) addOreByProduct(tMaterial);
        return this;
    }

    /**
     * If this Ore gives multiple drops of its Main Material.
     * Lapis Ore for example gives about 6 drops.
     */
    public Materials setOreMultiplier(int aOreMultiplier) {
        if (aOreMultiplier > 0) mOreMultiplier = aOreMultiplier;
        return this;
    }

    /**
     * If this Ore gives multiple drops of its Byproduct Material.
     */
    public Materials setByProductMultiplier(int aByProductMultiplier) {
        if (aByProductMultiplier > 0) mByProductMultiplier = aByProductMultiplier;
        return this;
    }

    /**
     * If this Ore gives multiple drops of its Main Material.
     * Lapis Ore for example gives about 6 drops.
     */
    public Materials setSmeltingMultiplier(int aSmeltingMultiplier) {
        if (aSmeltingMultiplier > 0) mSmeltingMultiplier = aSmeltingMultiplier;
        return this;
    }

    /**
     * This Ore should be smolten directly into an Ingot of this Material instead of an Ingot of itself.
     */
    public Materials setDirectSmelting(Materials aMaterial) {
        if (aMaterial != null) mDirectSmelting = aMaterial.mMaterialInto.mDirectSmelting;
        return this;
    }

    /**
     * This Material should be the Main Material this Ore gets ground into.
     * Example, Chromite giving Chrome or Tungstate giving Tungsten.
     */
    public Materials setOreReplacement(Materials aMaterial) {
        if (aMaterial != null) mOreReplacement = aMaterial.mMaterialInto.mOreReplacement;
        return this;
    }

    /**
     * This Material smelts always into an instance of aMaterial. Used for Magnets.
     */
    public Materials setSmeltingInto(Materials aMaterial) {
        if (aMaterial != null) mSmeltInto = aMaterial.mMaterialInto.mSmeltInto;
        return this;
    }

    /**
     * This Material arc smelts always into an instance of aMaterial. Used for Wrought Iron.
     */
    public Materials setArcSmeltingInto(Materials aMaterial) {
        if (aMaterial != null) mArcSmeltInto = aMaterial.mMaterialInto.mArcSmeltInto;
        return this;
    }

    /**
     * This Material macerates always into an instance of aMaterial.
     */
    public Materials setMaceratingInto(Materials aMaterial) {
        if (aMaterial != null) mMacerateInto = aMaterial.mMaterialInto.mMacerateInto;
        return this;
    }

    public Materials setEnchantmentForTools(Enchantment aEnchantment, int aEnchantmentLevel) {
        mEnchantmentTools = aEnchantment;
        mEnchantmentToolsLevel = (byte) aEnchantmentLevel;
        return this;
    }

    public Materials setEnchantmentForArmors(Enchantment aEnchantment, int aEnchantmentLevel) {
        mEnchantmentArmors = aEnchantment;
        mEnchantmentArmorsLevel = (byte) aEnchantmentLevel;
        return this;
    }

    public FluidStack getSolid(long aAmount) {
        if (mSolid == null) return null;
        return new GT_FluidStack(mSolid, (int) aAmount);
    }

    public FluidStack getFluid(long aAmount) {
        if (mFluid == null) return null;
        return new GT_FluidStack(mFluid, (int) aAmount);
    }

    public FluidStack getGas(long aAmount) {
        if (mGas == null) return null;
        return new GT_FluidStack(mGas, (int) aAmount);
    }

    public FluidStack getPlasma(long aAmount) {
        if (mPlasma == null) return null;
        return new GT_FluidStack(mPlasma, (int) aAmount);
    }

    public FluidStack getMolten(long aAmount) {
        if (mStandardMoltenFluid == null) return null;
        return new GT_FluidStack(mStandardMoltenFluid, (int) aAmount);
    }

    public FluidStack getMoltenHot(long aAmount) {
        if (mStandardMoltenHot == null) return null;
        return new GT_FluidStack(mStandardMoltenHot, (int) aAmount);
    }

    @Override
    public short[] getRGBA() {
        return mRGBa;
    }

    @Override
    public String toString() {
        return this.mName;
    }

    public String getDefaultLocalizedNameForItem(String aFormat) {
        return String.format(aFormat.replace("%s", "%temp").replace("%material", "%s"), this.mDefaultLocalName).replace("%temp", "%s");
    }

    public String getLocalizedNameForItem(String aFormat) {
        return String.format(aFormat.replace("%s", "%temp").replace("%material", "%s"), this.mLocalizedName).replace("%temp", "%s");
    }

    public static String getLocalizedNameForItem(String aFormat, int aMaterialID) {
        if (aMaterialID >= 0 && aMaterialID < 1000) {
            Materials aMaterial = GregTech_API.sGeneratedMaterials[aMaterialID];
            if (aMaterial != null)
                return aMaterial.getLocalizedNameForItem(aFormat);
        }
        return aFormat;
    }

    public static volatile int VERSION = 509;

    public static Collection<Materials> getAll(){
        return MATERIALS_MAP.values();
    }


    public boolean hasCorrespondingFluid() {
        return hasCorrespondingFluid;
    }


    public Materials setHasCorrespondingFluid(boolean hasCorrespondingFluid) {
        this.hasCorrespondingFluid = hasCorrespondingFluid;
        return this;
    }

    public boolean hasCorrespondingMoltenHot() {
        return hasCorrespondingMoltenHot;
    }

    public Materials setHasCorrespondingMoltenHot(boolean hasCorrespondingMoltenHot) {
        this.hasCorrespondingMoltenHot = hasCorrespondingMoltenHot;
        return this;
    }

    public boolean hasCorrespondingGas() {
        return hasCorrespondingGas;
    }
    public Materials setHasCorrespondingGas(boolean hasCorrespondingGas) {
        this.hasCorrespondingGas = hasCorrespondingGas;
        return this;
    }
    public boolean hasCorrespondingSemi() {
        return hasCorrespondingSemi;
    }
    public Materials setHasCorrespondingSemi(boolean hasCorrespondingSemi) {
        this.hasCorrespondingSemi = hasCorrespondingSemi;
        return this;
    }

    public boolean canBeCracked() {
        return canBeCracked;

    }
    public Materials setCanBeCracked(boolean canBeCracked) {
        this.canBeCracked = canBeCracked;
        return this;
    }
    public int getLiquidTemperature() {
        return mMeltingPoint == 0 ? 295 : mMeltingPoint;
    }

    public Materials setLiquidTemperature(int liquidTemperature) {
        this.mMeltingPoint = (short) liquidTemperature;
        return this;
    }

    public int getGasTemperature() {
        return mGasTemp == 0 ? 295 : mMeltingPoint;
    }

    public Materials setGasTemperature(int gasTemperature) {
        this.mGasTemp = (short) gasTemperature;
        return this;
    }

    public Materials setHydroCrackedFluids(Fluid[] hydroCrackedFluids) {
        this.hydroCrackedFluids = hydroCrackedFluids;
        return this;
    }

    public FluidStack getLightlyHydroCracked(int amount) {
        if (hydroCrackedFluids[0] == null) {
            return null;
        }
        return new FluidStack(hydroCrackedFluids[0], amount);
    }

    public FluidStack getModeratelyHydroCracked(int amount) {
        if (hydroCrackedFluids[0] == null) {
            return null;
        }
        return new FluidStack(hydroCrackedFluids[1], amount);
    }

    public FluidStack getSeverelyHydroCracked(int amount) {
        if (hydroCrackedFluids[0] == null) {
            return null;
        }
        return new FluidStack(hydroCrackedFluids[2], amount);
    }

    public Materials setSteamCrackedFluids(Fluid[] steamCrackedFluids) {
        this.steamCrackedFluids = steamCrackedFluids;
        return this;
    }

    public FluidStack getLightlySteamCracked(int amount) {
        if (hydroCrackedFluids[0] == null) {
            return null;
        }
        return new FluidStack(steamCrackedFluids[0], amount);
    }

    public FluidStack getModeratelySteamCracked(int amount) {
        if (hydroCrackedFluids[0] == null) {
            return null;
        }
        return new FluidStack(steamCrackedFluids[1], amount);
    }

    public FluidStack getSeverelySteamCracked(int amount) {
        if (hydroCrackedFluids[0] == null) {
            return null;
        }
        return new FluidStack(steamCrackedFluids[2], amount);
    }

    public ItemStack getCells(int amount){
        return GT_OreDictUnificator.get(OrePrefixes.cell, this, amount);
    }

    public ItemStack getDust(int amount){
        return GT_OreDictUnificator.get(OrePrefixes.dust, this, amount);
    }

    public ItemStack getDustSmall(int amount){
        return GT_OreDictUnificator.get(OrePrefixes.dustSmall, this, amount);
    }

    public ItemStack getDustTiny(int amount){
        return GT_OreDictUnificator.get(OrePrefixes.dustTiny, this, amount);
    }

    public ItemStack getGems(int amount){
        return GT_OreDictUnificator.get(OrePrefixes.gem, this, amount);
    }

    public ItemStack getIngots(int amount){
        return GT_OreDictUnificator.get(OrePrefixes.ingot, this, amount);
    }

    public ItemStack getNuggets(int amount){return GT_OreDictUnificator.get(OrePrefixes.nugget, this, amount); }

    public ItemStack getBlocks(int amount){
        return GT_OreDictUnificator.get(OrePrefixes.block, this, amount);
    }

    public ItemStack getPlates(int amount){
        return GT_OreDictUnificator.get(OrePrefixes.plate, this, amount);
    }

}
