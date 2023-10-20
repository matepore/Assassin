package assassinRa.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static assassinRa.assassinRa.makeID;

public class AssassinsMark extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("AssassinsMark");
    private static final AbstractPower.PowerType TYPE = PowerType.DEBUFF;
    private static final boolean TURN_BASED = false;

    private static final int MAX_STACK = 3;
    public AssassinsMark(AbstractCreature owner, int amount){
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    @Override
    public void stackPower(int stackAmount) {
        // Limit the stack amount to the maximum allowed
        if (this.amount + stackAmount > MAX_STACK) {
            this.amount = MAX_STACK;
        }
        else {
            super.stackPower(stackAmount);
        }
    }

    @Override
    public int onAttacked(DamageInfo info, int damageAmount) {
        if(super.owner.hasPower("assassinRa:AssassinsMark") && super.owner.getPower("assassinRa:AssassinsMark").amount >= MAX_STACK){
            flash();
            addToTop(new RemoveSpecificPowerAction(super.owner, owner, this));
            DamageInfo secondHit = new DamageInfo(info.owner, damageAmount, DamageInfo.DamageType.NORMAL);
            int additionalDamage = (10 * super.owner.maxHealth)/100;
            return super.onAttacked(info, damageAmount) + super.onAttacked(secondHit, damageAmount + additionalDamage);
        }
        else{
            return super.onAttacked(info, damageAmount);
        }
    }

    public void updateDescription(){
        this.description = DESCRIPTIONS[0] + DESCRIPTIONS[1];
    }

    @Override
    public AbstractPower makeCopy(){
        return new AssassinsMark(owner, amount);
    }
}
