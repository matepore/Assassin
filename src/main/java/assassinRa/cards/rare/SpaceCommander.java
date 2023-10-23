package assassinRa.cards.rare;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.BufferPower;
import com.megacrit.cardcrawl.powers.MetallicizePower;

public class SpaceCommander extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.rare.SpaceCommander.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.POWER,
            CardRarity.RARE,
            CardTarget.SELF,
            1
    );

    private static final int BUFFER = 1;
    private static final int METALLICIZE = 3;

    public SpaceCommander() {
        super(ID, info);
        setInnate(false, true);
        setMagic(BUFFER);
        setCustomVar("magicMet", METALLICIZE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if(p.currentHealth < (p.maxHealth / 2)){
            addToBot(new ApplyPowerAction(p, p, new BufferPower(p, magicNumber)));
        }
        else{
            addToBot(new ApplyPowerAction(p, p, new MetallicizePower(p, customVar("magicMet"))));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.rare.SpaceCommander();
    }
}