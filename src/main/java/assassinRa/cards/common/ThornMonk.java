package assassinRa.cards.common;

import assassinRa.actions.ThornMonkAction;
import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ThornsPower;

public class ThornMonk extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.common.ThornMonk.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            2
    );

    private static final int THORNS = 2;
    private static final int UPG_COST = 1;

    public ThornMonk() {
        super(ID, info);
        setMagic(THORNS);
        setCostUpgrade(UPG_COST);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new ThornsPower(p, magicNumber)));
        addToBot(new ThornMonkAction(p, m));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.common.ThornMonk();
    }
}