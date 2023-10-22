package assassinRa.cards.rare;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.powers.PredatorFormPower;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ThornsPower;

public class PredatorForm extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.rare.PredatorForm.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.POWER,
            CardRarity.RARE,
            CardTarget.SELF,
            3
    );

    private static final int THORNS = 3;
    private static final int UPG_THORNS = 1;

    public PredatorForm() {
        super(ID, info);
        setMagic(THORNS, UPG_THORNS);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new ThornsPower(p, magicNumber)));
        addToBot(new ApplyPowerAction(p, p, new PredatorFormPower(p, 1)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.rare.PredatorForm();
    }
}