package assassinRa.cards.uncommon;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.IntangiblePower;

public class SigilEssence extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.uncommon.SigilEssence.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.POWER,
            CardRarity.COMMON,
            CardTarget.SELF,
            2
    );

    private static final int UPG_COST = 1;
    private static final int INTANGIBLE = 1;
    private static final int DEXTERITY = 1;

    public SigilEssence() {
        super(ID, info);
        setEthereal(true);
        setCostUpgrade(UPG_COST);
        setMagic(INTANGIBLE);
        setCustomVar("magicDex", DEXTERITY);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new IntangiblePower(p, magicNumber)));
        addToBot(new ApplyPowerAction(p, p, new DexterityPower(p, customVar("magicDex"))));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.uncommon.SigilEssence();
    }
}