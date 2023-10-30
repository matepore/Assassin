package assassinRa.cards.uncommon;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;

public class TheFortress extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.uncommon.TheFortress.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.UNCOMMON,
            CardTarget.ALL_ENEMY,
            1
    );

    private static final int BLOCK = 5;
    private static final int UPG_BLOCK = 3;
    private static final int WEAK = 2;

    public TheFortress() {
        super(ID, info);
        setBlock(BLOCK, UPG_BLOCK);
        setMagic(WEAK);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, block));
        for(AbstractMonster monster : AbstractDungeon.getMonsters().monsters){
            addToBot(new ApplyPowerAction(monster, p, new WeakPower(p, magicNumber, false)));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.uncommon.TheFortress();
    }
}