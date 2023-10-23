package assassinRa.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;

public class HammerOfFateAction extends AbstractGameAction {
    private AbstractCreature source;
    private AbstractCreature target;
    private DamageInfo info;
    private int strAmount;
    private int dexAmount;

    public HammerOfFateAction(AbstractCreature source, AbstractCreature target, DamageInfo info, int strAmount, int dexAmount){
        this.source = source;
        this.target = target;
        this.info = info;
        this.strAmount = strAmount;
        this.dexAmount = dexAmount;
    }

    @Override
    public void update() {
        if (target != null) {
            AbstractDungeon.effectList.add(new FlashAtkImgEffect(target.hb.cX, target.hb.cY, AttackEffect.BLUNT_HEAVY));
            target.damage(info);
            if (((AbstractMonster)target).isDying || target.currentHealth <= 0) {
                addToBot(new ApplyPowerAction(source, source, new StrengthPower(source, strAmount)));
                addToBot(new ApplyPowerAction(source, source, new DexterityPower(source, dexAmount)));
            }

            if (AbstractDungeon.getCurrRoom().monsters.areMonstersBasicallyDead()) {
                AbstractDungeon.actionManager.clearPostCombatActions();
            }
        }
        this.tickDuration();
    }
}