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

public class IronArm extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.common.IronArm.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            2
    );

    private static final int DAMAGE = 8;
    private static final int UPG_DAMAGE = 1;
    private static final int ANOTHER_DAMAGE = 16;
    private static final int UPG_ANOTHER_DAMAGE = 2;

    public IronArm() {
        super(ID, info);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(ANOTHER_DAMAGE, UPG_ANOTHER_DAMAGE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        int quantityAttack = 0;
        for(AbstractCard card : p.hand.group){
            if(card.type == CardType.ATTACK){
                quantityAttack++;
            }
        }
        if(quantityAttack <= 1){
            addToBot(new DamageAction(m, new DamageInfo(p, magicNumber, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
        }
        else{
            addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.common.IronArm();
    }
}