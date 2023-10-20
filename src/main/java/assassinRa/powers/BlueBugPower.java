package assassinRa.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static assassinRa.assassinRa.makeID;

public class BlueBugPower extends BasePower implements CloneablePowerInterface {
    public static final String POWER_ID = makeID("BlueBugPower");
    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
    private static final boolean TURN_BASED = false;
    private static final int HEAL_QUANTITY = 3;
    private static final int BLOCK = 3;

    public BlueBugPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    @Override
    public void atStartOfTurn() {
        flash();
        if(super.owner.currentHealth < super.owner.maxHealth / 2){
            addToBot(new HealAction(super.owner, super.owner, HEAL_QUANTITY));
        }
        else{
            addToBot(new GainBlockAction(super.owner, super.owner, BLOCK));
        }
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + DESCRIPTIONS[1];
    }

    //Optional, for CloneablePowerInterface.
    @Override
    public AbstractPower makeCopy() {
        return new BlueBugPower(owner, amount);
    }
}