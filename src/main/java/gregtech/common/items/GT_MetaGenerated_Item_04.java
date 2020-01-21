package gregtech.common.items;

import gregtech.api.GregTech_API;
import gregtech.api.enums.*;
import gregtech.api.interfaces.ITexture;
import gregtech.api.items.GT_MetaGenerated_Item_X32;
import gregtech.api.objects.GT_MultiTexture;
import gregtech.api.objects.GT_RenderedTexture;
import gregtech.common.covers.GT_Cover_FluidRegulator;

public class GT_MetaGenerated_Item_04
        extends GT_MetaGenerated_Item_X32 {
    public static GT_MetaGenerated_Item_04 INSTANCE;

    public GT_MetaGenerated_Item_04() {
        super("metaitem.04", new OrePrefixes[]{});
        INSTANCE = this;
        int tLastID = 0;
        Object[] o = new Object[0];
    }



    public boolean doesShowInCreative(OrePrefixes aPrefix, Materials aMaterial, boolean aDoShowAllItems) {
        return aDoShowAllItems;
    }
}
