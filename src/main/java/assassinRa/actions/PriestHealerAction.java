package assassinRa.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;

public class PriestHealerAction extends AbstractGameAction {
    private AbstractCreature source;
    private AbstractCreature target;
    private DamageInfo info;
    private int healAmount;

    public PriestHealerAction(AbstractCreature source, AbstractCreature target, DamageInfo info, int healAmount){
        this.source = source;
        this.target = target;
        this.info = info;
        this.healAmount = healAmount;
    }

    @Override
    public void update() {
        if (this.target != null) {
            AbstractDungeon.effectList.add(new FlashAtkImgEffect(this.target.hb.cX, this.target.hb.cY, AttackEffect.SLASH_HEAVY));
            this.target.damage(info);
            if (((AbstractMonster)this.target).isDying || this.target.currentHealth <= 0) {
                addToBot(new HealAction(this.source, this.source, this.healAmount));
            }

            if (AbstractDungeon.getCurrRoom().monsters.areMonstersBasicallyDead()) {
                AbstractDungeon.actionManager.clearPostCombatActions();
            }
        }
        this.tickDuration();
    }
}