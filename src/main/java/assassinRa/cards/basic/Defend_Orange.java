package assassinRa.cards.basic;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Defend_Orange extends BaseCard {
    public static final String ID = makeID(Defend_Orange.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.BASIC,
            CardTarget.SELF,
            1
    );

    private static final int BLOCK = 5;
    private static final int UPG_BLOCK = 3;

    public Defend_Orange() {
        super(ID, info);
        setBlock(BLOCK, UPG_BLOCK);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, block));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Defend_Orange();
    }
}