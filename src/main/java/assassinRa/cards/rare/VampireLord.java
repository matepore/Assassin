package assassinRa.cards.rare;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class VampireLord extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.rare.VampireLord.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.RARE,
            CardTarget.ENEMY,
            1
    );

    private static final int DAMAGE = 7;
    private static final int UPG_DAMAGE = 3;

    public VampireLord() {
        super(ID, info);
        setDamage(DAMAGE, UPG_DAMAGE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        int healingAmount = damage - m.currentBlock;
        int currentPoints = m.currentHealth + m.currentBlock;
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));

        if(currentPoints < damage){
            addToBot(new HealAction(p, p, currentPoints));
        }
        else if(healingAmount > 0){
            addToBot(new HealAction(p, p, healingAmount));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.rare.VampireLord();
    }
}