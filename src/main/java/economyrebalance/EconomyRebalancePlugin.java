package economyrebalance;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.campaign.comm.IntelInfoPlugin;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.campaign.BaseCampaignEventListener;
import com.fs.starfarer.api.impl.campaign.intel.BaseIntelPlugin;
import com.fs.starfarer.api.ui.TooltipMakerAPI;
import org.apache.log4j.Logger;
public class EconomyRebalancePlugin extends BaseModPlugin
{
    public static Logger log = Global.getLogger(EconomyRebalancePlugin.class);

    @Override
    public void onGameLoad(boolean newGame) {
        new EconUtil();
        new MissionUtil();
        log.info("EconomyRebalance: Loaded");
    }
}

public class EconUtil extends BaseCampaignEventListener {
    public static Logger log = Global.getLogger(EconUtil.class);

    public EconUtil() {
        super(false);
        Global.getSector().addTransientListener(this);
    }

    @Override
    public class reportPlayerOpenedMarket(MarketAPI market) {
        float rate = 10.0f;
        market.getTariff().setBaseValue(rate);
    }
}

public class MissionUtil extends BaseCampaignEventListener {
    public MissionUtil()
    {
        super(false);

    }
}