package assassinRa.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.PoisonPower;

import static assassinRa.assassinRa.makeID;

public class PredatorFormPower extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("PredatorFormPower");
    private static final AbstractPower.PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;
    public PredatorFormPower(AbstractCreature owner, int amount){
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    @Override
    public void onAttack(DamageInfo info, int damageAmount, AbstractCreature target) {
        if(target != null){
            addToBot(new ApplyPowerAction(target, owner, new PoisonPower(target, owner, 3), 3, AbstractGameAction.AttackEffect.POISON));
        }
    }

    public void updateDescription(){
        this.description = DESCRIPTIONS[0] + DESCRIPTIONS[1];
    }

    @Override
    public AbstractPower makeCopy(){
        return new PredatorFormPower(owner, amount);
    }
}