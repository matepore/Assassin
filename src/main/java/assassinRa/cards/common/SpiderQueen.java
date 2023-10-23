package assassinRa.cards.common;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerToRandomEnemyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;

public class SpiderQueen extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.common.SpiderQueen.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.ALL_ENEMY,
            1
    );

    private static final int POISON = 5;
    private static final int NO_UPGRADE = 0;
    private static final int UPGRADED = 1;

    public SpiderQueen() {
        super(ID, info);
        setMagic(POISON);
        setCustomVar("isUpgraded?", NO_UPGRADE, UPGRADED);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if(customVarUpgraded("isUpgraded?")){
            for(AbstractMonster monster : AbstractDungeon.getMonsters().monsters){
                addToBot(new ApplyPowerAction(monster, p, new PoisonPower(monster, p, magicNumber), magicNumber, AbstractGameAction.AttackEffect.POISON));
            }
        }
        else{
            addToBot(new ApplyPowerToRandomEnemyAction(p, new PoisonPower(m, p, magicNumber)));//Por alguna razón esta linea me tira error critico, pero la carta funciona a la perfección.
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.common.SpiderQueen();
    }
}