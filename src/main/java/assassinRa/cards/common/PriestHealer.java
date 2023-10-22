package assassinRa.cards.common;

import assassinRa.actions.PriestHealerAction;
import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class PriestHealer extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.common.PriestHealer.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );

    private static final int DAMAGE = 7;
    private static final int HEAL = 3;
    private static final int UPG_HEAL = 2;

    public PriestHealer() {
        super(ID, info);
        setDamage(DAMAGE);
        setMagic(HEAL, UPG_HEAL);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new PriestHealerAction(p, m, new DamageInfo(p, damage, damageTypeForTurn), magicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.common.PriestHealer();
    }
}