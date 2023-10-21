package assassinRa.cards.uncommon;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.common.GainGoldAction;
import com.megacrit.cardcrawl.actions.unique.LoseEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.GainGoldTextEffect;

public class MageThief extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.uncommon.MageThief.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.UNCOMMON,
            CardTarget.NONE,
            -1
    );

    private static final int GOLD = 10;

    public MageThief() {
        super(ID, info);
        setMagic(GOLD);
        setExhaust(true);
        setInnate(false, true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        //Anda perfecto, pero me gustaría que hiciera sonido de monedas
        addToBot(new GainGoldAction(magicNumber * energyOnUse));
        AbstractDungeon.effectList.add(new GainGoldTextEffect(magicNumber * energyOnUse));
        addToBot(new LoseEnergyAction(energyOnUse));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.uncommon.MageThief();
    }
}