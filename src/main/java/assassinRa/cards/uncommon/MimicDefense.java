package assassinRa.cards.uncommon;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class MimicDefense extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.uncommon.MimicDefense.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.UNCOMMON,
            CardTarget.ENEMY,
            2
    );

    private static final int UPG_COST = 1;

    public MimicDefense() {
        super(ID, info);
        setCostUpgrade(UPG_COST);
        setExhaust(true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if(m != null && m.currentBlock > 0){
            addToBot(new GainBlockAction(p, m.currentBlock));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.uncommon.MimicDefense();
    }
}