package assassinRa.cards.uncommon;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Protected extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.uncommon.Protected.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.UNCOMMON,
            CardTarget.SELF,
            1
    );

    private static final int BLOCK = 8;
    private static final int DRAW_CARD = 1;
    private static final int UPG_DRAW_CARD = 1;

    public Protected() {
        super(ID, info);
        setBlock(BLOCK);
        setMagic(DRAW_CARD, UPG_DRAW_CARD);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, block));
        addToBot(new DrawCardAction(p, magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.uncommon.Protected();
    }
}