package economyrebalance;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.campaign.BaseCampaignEventListener;
import org.apache.log4j.Logger;
import economyrebalance.util.TariffUtil;

public class EconomyRebalancePlugin extends BaseModPlugin
{   
    public static Logger log = Global.getLogger(EconomyRebalancePlugin.class);
    
    @Override
    public void onGameLoad(boolean newGame) {
        new EconUtil();
        log.info("EconomyRebalance: Loaded");
    }
}

public class EconUtil extends BaseCampaignEventListener {
    public static Logger log = Global.getLogger(EconUtil.class);
    public EconUtil() {
        super(false);
        Global.getSector().addTransientListener(this);
    }
}
