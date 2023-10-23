package assassinRa.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class SeekerOfTheLightAction extends AbstractGameAction {
    private AbstractCreature target;
    private int healAmount;

    public SeekerOfTheLightAction(AbstractCreature target, int healAmount){
        this.target = target;
        this.healAmount = healAmount;
    }

    @Override
    public void update() {
        if (target == null){
            this.isDone = true;
            return;
        }

        int stackAmount = 0;

        for(int i = 0; i < target.powers.size(); i++){
            if(target.powers.get(i).type == AbstractPower.PowerType.DEBUFF){
                stackAmount += target.powers.get(i).amount;
            }
        }
        for(int j = 0; j < target.powers.size(); j++){
            if(target.powers.get(j).type == AbstractPower.PowerType.DEBUFF){
                addToBot(new RemoveSpecificPowerAction(target, target, target.powers.get(j).ID));
            }
        }

        if(stackAmount > 0){
            addToBot(new HealAction(target, target, (healAmount * stackAmount)));
        }
        else{
            addToBot(new HealAction(target, target, healAmount));
        }
        this.isDone = true;
    }
}