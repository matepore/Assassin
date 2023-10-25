package assassinRa.cards.rare;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.powers.AssassinsMark;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;

public class AssassinMaster extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.rare.AssassinMaster.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.RARE,
            CardTarget.ENEMY,
            1
    );

    private static final int DAMAGE = 2;
    private static final int BONUS_DAMAGE = 1;
    private static final int UPG_BONUS_DAMAGE = 1;

    public AssassinMaster() {
        super(ID, info);
        setDamage(DAMAGE);
        setMagic(BONUS_DAMAGE, UPG_BONUS_DAMAGE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if(m.hasPower(AssassinsMark.POWER_ID)){
            for(int i = 0; i < m.getPower(AssassinsMark.POWER_ID).amount; i++){
                if(m.hasPower(WeakPower.POWER_ID)){
                    addToBot(new DamageAction(m, new DamageInfo(p, damage + (m.getPower(WeakPower.POWER_ID).amount * magicNumber), DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
                }
                else{
                    addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
                }
            }
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.rare.AssassinMaster();
    }
}