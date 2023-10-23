package assassinRa.cards.rare;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class V01B01 extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.rare.V01B01.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.RARE,
            CardTarget.SELF,
            1
    );

    private static final int BLOCK = 7;
    private static final int UPG_BLOCK = 5;
    private static final int ENERGY = 1;

    public V01B01() {
        super(ID, info);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(ENERGY);
        setExhaust(true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, block));
    }

    @Override
    public void triggerWhenDrawn() {
        // Add logic to gain 1 energy when the card is drawn
        AbstractPlayer player = AbstractDungeon.player;
        player.gainEnergy(magicNumber);
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.rare.V01B01();
    }
}