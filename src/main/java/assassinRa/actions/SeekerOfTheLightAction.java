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
        if (this.target == null){
            this.isDone = true;
            return;
        }

        int stackAmount = 0;

        for(int i = 0; i < this.target.powers.size(); i++){
            if(this.target.powers.get(i).type == AbstractPower.PowerType.DEBUFF){
                stackAmount += this.target.powers.get(i).amount;
            }
        }
        for(int j = 0; j < this.target.powers.size(); j++){
            if(this.target.powers.get(j).type == AbstractPower.PowerType.DEBUFF){
                addToBot(new RemoveSpecificPowerAction(this.target, this.target, this.target.powers.get(j).ID));
            }
        }

        if(stackAmount > 0){
            addToBot(new HealAction(this.target, this.target, (this.healAmount * stackAmount)));
        }
        else{
            addToBot(new HealAction(this.target, this.target, this.healAmount));
        }
        this.isDone = true;
    }
}