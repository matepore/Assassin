package assassinRa.cards.common;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;

public class ExperiencedGuard extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.common.ExperiencedGuard.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.SELF,
            1
    );

    private static final int BLOCK = 9;
    private static final int ANOTHER_BLOCK = 15;
    private static final int UPG_COST = 0;

    public ExperiencedGuard() {
        super(ID, info);
        setBlock(BLOCK);
        setMagic(ANOTHER_BLOCK);
        setCostUpgrade(UPG_COST);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if(p.hasPower(VulnerablePower.POWER_ID)){
            addToBot(new GainBlockAction(p, magicNumber));
        }
        else{
            addToBot(new GainBlockAction(p, block));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.common.ExperiencedGuard();
    }
}