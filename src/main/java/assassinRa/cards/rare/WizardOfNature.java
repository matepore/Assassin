package assassinRa.cards.rare;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;

public class WizardOfNature extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.rare.WizardOfNature.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.RARE,
            CardTarget.SELF,
            1
    );


    public WizardOfNature() {
        super(ID, info);
        setExhaust(true, false);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if(p.hasPower(DexterityPower.POWER_ID)){
            addToBot(new ApplyPowerAction(p, p, new DexterityPower(p, p.getPower(DexterityPower.POWER_ID).amount)));
        }
        else{
            addToBot(new ApplyPowerAction(p, p, new DexterityPower(p, 1)));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.rare.WizardOfNature();
    }
}