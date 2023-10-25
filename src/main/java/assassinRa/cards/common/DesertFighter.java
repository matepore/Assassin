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

public class DesertFighter extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.common.DesertFighter.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            2
    );

    private static final int DAMAGE = 8;
    private static final int BLOCK_DAMAGE = 16;
    private static final int UPG_COST = 1;

    public DesertFighter() {
        super(ID, info);
        setCostUpgrade(UPG_COST);
        setDamage(DAMAGE);
        setCustomVar("magicDamage", BLOCK_DAMAGE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if(m.currentBlock > 0){
            addToBot(new DamageAction(m, new DamageInfo(p, customVar("magicDamage"), DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
        }
        else{
            addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.common.DesertFighter();
    }
}