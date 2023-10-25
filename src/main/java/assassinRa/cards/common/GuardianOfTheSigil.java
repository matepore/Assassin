package assassinRa.cards.common;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class GuardianOfTheSigil extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.common.GuardianOfTheSigil.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.SELF,
            0
    );


    public GuardianOfTheSigil() {
        super(ID, info);
        setExhaust(true, false);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if(p.drawPile.isEmpty() || p.discardPile.isEmpty()){
            addToBot(new GainEnergyAction(p.energy.energy - energyOnUse));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.common.GuardianOfTheSigil();
    }
}