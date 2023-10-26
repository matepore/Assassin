package assassinRa.cards.common;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class SaltyWound extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.common.SaltyWound.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            2
    );

    private static final int DAMAGE = 12;
    private static final int UPG_COST = 1;

    public SaltyWound() {
        super(ID, info);
        setDamage(DAMAGE);
        setCostUpgrade(UPG_COST);
    }

    @Override//Diseñada por Dieganso-sama
    public void use(AbstractPlayer p, AbstractMonster m) {
        int debuffs = m.powers.size() * 2;
        addToBot(new DamageAction(m, new DamageInfo(p, damage + debuffs, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SMASH));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.common.SaltyWound();
    }
}