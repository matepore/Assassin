package assassinRa.cards.rare;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Nephil extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.rare.Nephil.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.RARE,
            CardTarget.ALL_ENEMY,
            2
    );

    private static final int DAMAGE = 16;
    private static final int HP = 6;
    private static final int HP_LOSS = 6;
    private static final int UPG_HP_LOSS = -6;

    public Nephil() {
        super(ID, info);
        setDamage(DAMAGE);
        setMagic(HP);
        setCustomVar("hpLoss", HP_LOSS, UPG_HP_LOSS);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAllEnemiesAction(p, damage, DamageInfo.DamageType.NORMAL, AbstractGameAction.AttackEffect.SLASH_HEAVY));
        if(p.currentHealth < (p.maxHealth/2)){
            addToBot(new HealAction(p, p, HP));
        }
        else{
            if(customVar("hpLoss") > 0){
                addToBot(new LoseHPAction(p, p, customVar("hpLoss")));
            }
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.rare.Nephil();
    }
}