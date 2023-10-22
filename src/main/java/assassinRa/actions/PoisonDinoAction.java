package assassinRa.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.PoisonPower;

public class PoisonDinoAction extends AbstractGameAction {
    private AbstractCreature source;
    private AbstractCreature target;

    public PoisonDinoAction(AbstractCreature source, AbstractCreature target){
        this.source = source;
        this.target = target;
    }
    @Override
    public void update() {
        if (source == null || target == null){
            this.isDone = true;
            return;
        }

        int numPoison = 0;
        if (target.hasPower(PoisonPower.POWER_ID)){
            numPoison = Math.max(0, target.getPower(PoisonPower.POWER_ID).amount);
        }
        if (numPoison == 0){
            isDone = true;
            return;
        }
        addToBot(new DamageAction(target, new DamageInfo(source, numPoison, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
        this.isDone = true;
    }
}
