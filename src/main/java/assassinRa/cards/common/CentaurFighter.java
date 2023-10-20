package assassinRa.cards.common;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class CentaurFighter extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.common.CentaurFighter.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );

    private static final int DAMAGE = 2;
    private static final int UPG_DAMAGE = 2;
    private static final int ANOTHER_DAMAGE = 6;
    private static final int UPG_ANOTHER_DAMAGE = 2;

    public CentaurFighter() {
        super(ID, info);
        setDamage(DAMAGE, UPG_DAMAGE);
        setMagic(ANOTHER_DAMAGE, UPG_ANOTHER_DAMAGE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
        for (AbstractMonster monster : AbstractDungeon.getMonsters().monsters) {
            if (!monster.isDeadOrEscaped() && monster != m) {
                addToBot(new DamageAction(monster, new DamageInfo(p, magicNumber, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
            }
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.common.CentaurFighter();
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeDamage(UPG_DAMAGE);
            upgradeMagicNumber(UPG_ANOTHER_DAMAGE);
        }
    }
}