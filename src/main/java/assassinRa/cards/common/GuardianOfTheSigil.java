package assassinRa.cards.common;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.powers.AssassinsMark;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;

public class GuardianOfTheSigil extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.common.GuardianOfTheSigil.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.SELF,
            1
    );

    private static final int UPG_COST = 0;

    public GuardianOfTheSigil() {
        super(ID, info);
        setCostUpgrade(UPG_COST);
        exhaust = true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if(p.drawPile.isEmpty() || p.discardPile.isEmpty()){
            int energyAmount = p.energy.energyMaster - p.energy.energy;
            addToBot(new GainEnergyAction(energyAmount));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.common.GuardianOfTheSigil();
    }
}