package assassinRa.cards.uncommon;

import assassinRa.actions.SeekerOfTheLightAction;
import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class SeekerOfTheLight extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.uncommon.SeekerOfTheLight.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.UNCOMMON,
            CardTarget.SELF,
            3
    );

    private static final int HEAL = 2;
    private static final int UPG_COST = 2;

    public SeekerOfTheLight() {
        super(ID, info);
        setMagic(HEAL);
        setCostUpgrade(UPG_COST);
        setExhaust(true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new SeekerOfTheLightAction(p, magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.uncommon.SeekerOfTheLight();
    }
}