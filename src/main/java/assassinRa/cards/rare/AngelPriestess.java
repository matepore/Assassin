package assassinRa.cards.rare;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class AngelPriestess extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.rare.AngelPriestess.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.RARE,
            CardTarget.SELF,
            2
    );

    private static final int HEAL_QUANTITY = 2;
    private static final int UPG_HEAL_QUANTITY = 1;

    public AngelPriestess() {
        super(ID, info);
        setMagic(HEAL_QUANTITY, UPG_HEAL_QUANTITY);
        exhaust = true;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        for (AbstractCard card : p.hand.group) {
            if(card.type == CardType.SKILL){
                addToBot(new HealAction(p, p, magicNumber));
            }
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.rare.AngelPriestess();
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeMagicNumber(UPG_HEAL_QUANTITY);
        }
    }
}
