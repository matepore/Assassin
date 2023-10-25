package assassinRa.cards.rare;

import assassinRa.cards.BaseCard;
import assassinRa.cards.special.RoboHound;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Sentinel extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.rare.Sentinel.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.RARE,
            CardTarget.SELF,
            1
    );

    private static final int UPG_COST = 0;

    public Sentinel() {
        super(ID, info);
        setCostUpgrade(UPG_COST);
        setExhaust(true);
        cardsToPreview = new RoboHound();
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new MakeTempCardInDiscardAction(new RoboHound(), p.exhaustPile.size()));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.rare.Sentinel();
    }
}