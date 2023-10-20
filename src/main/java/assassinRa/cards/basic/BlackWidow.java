package assassinRa.cards.basic;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.powers.AssassinsMark;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;

public class BlackWidow extends BaseCard {
    public static final String ID = makeID(BlackWidow.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.BASIC,
            CardTarget.ENEMY,
            1
    );

    private static final int BLOCK = 3;
    private static final int UPG_BLOCK = 2;
    private static final int ASSASSIN_MARK = 1;
    private static final int WEAK = 1;

    public BlackWidow() {
        super(ID, info);
        setBlock(BLOCK, UPG_BLOCK);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if(m.hasPower("assassinRa:AssassinsMark")) {
            int marks = m.getPower("assassinRa:AssassinsMark").amount;
            addToBot(new GainBlockAction(p, p, block * marks));
            for(int i = 0; i < marks; i++){
                addToBot(new ApplyPowerAction(m, p, new WeakPower(p, WEAK, false)));
            }
        }
        addToBot(new ApplyPowerAction(m, p, new AssassinsMark(p, ASSASSIN_MARK)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new BlackWidow();
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeBlock(UPG_BLOCK);
        }
    }
}