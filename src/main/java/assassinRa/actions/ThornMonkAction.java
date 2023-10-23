package assassinRa.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.PoisonPower;
import com.megacrit.cardcrawl.powers.ThornsPower;

public class ThornMonkAction extends AbstractGameAction {
    private AbstractCreature source;
    private AbstractCreature target;

    public ThornMonkAction(AbstractCreature source, AbstractCreature target){
        this.source = source;
        this.target = target;
    }
    @Override
    public void update() {
        if (source == null || target == null){
            this.isDone = true;
            return;
        }

        int numThorn = 0;
        if (source.hasPower(ThornsPower.POWER_ID)){
            numThorn = Math.max(0, source.getPower(ThornsPower.POWER_ID).amount);
        }
        if (numThorn == 0){
            isDone = true;
            return;
        }
        addToBot(new DamageAction(target, new DamageInfo(source, numThorn, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
        this.isDone = true;
    }
}