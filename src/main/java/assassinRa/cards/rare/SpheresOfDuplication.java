package assassinRa.cards.rare;

import assassinRa.actions.DuplicateCardAction;
import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.unique.LoseEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class SpheresOfDuplication extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.rare.SpheresOfDuplication.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.RARE,
            CardTarget.SELF,
            -1
    );

    private static final int TIMES = 0;
    private static final int UPG_TIMES = 1;

    public SpheresOfDuplication() {
        super(ID, info);
        setMagic(TIMES, UPG_TIMES);
        setExhaust(true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DuplicateCardAction(p, (energyOnUse + magicNumber), p.discardPile, p.drawPile));
        addToBot(new LoseEnergyAction(energyOnUse));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.rare.SpheresOfDuplication();
    }
}