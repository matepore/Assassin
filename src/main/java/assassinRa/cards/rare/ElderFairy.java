package assassinRa.cards.rare;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class ElderFairy extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.rare.ElderFairy.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.RARE,
            CardTarget.ENEMY,
            0
    );

    private static final int ENERGY_GAIN = 1;

    public ElderFairy() {
        super(ID, info);
        exhaust = true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if(m.getIntentBaseDmg() == -1){
            addToBot(new GainEnergyAction(ENERGY_GAIN));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.rare.ElderFairy();
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            exhaust = false;
        }
    }
}