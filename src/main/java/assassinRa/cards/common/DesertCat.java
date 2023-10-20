package assassinRa.cards.common;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveAllBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;

public class DesertCat extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.common.DesertCat.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            2
    );

    private static final int WEAK = 1;
    private static final int UPG_WEAK = 1;

    public DesertCat() {
        super(ID, info);
        setMagic(WEAK, UPG_WEAK);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        flash();
        addToBot(new RemoveAllBlockAction(m,p));
        addToBot(new ApplyPowerAction(m, p, new WeakPower(p, magicNumber, false)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.common.DesertCat();
    }
}