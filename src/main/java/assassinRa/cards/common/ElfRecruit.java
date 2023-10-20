package assassinRa.cards.common;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.FrailPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;

import java.util.Random;

public class ElfRecruit extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.common.ElfRecruit.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );

    Random rand = new Random();

    private static final int DAMAGE = 6;
    private static final int UPG_DAMAGE = 3;
    private static final int ANOTHER_DAMAGE = 9;

    public ElfRecruit() {
        super(ID, info);
        setDamage(DAMAGE, UPG_DAMAGE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        for (AbstractMonster monster : AbstractDungeon.getMonsters().monsters) {
            if (!monster.isDeadOrEscaped() && monster != m) {
                addToBot(new DamageAction(monster, new DamageInfo(p, ANOTHER_DAMAGE, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
            }
        }
        int randomNum = rand.nextInt(3);

        if(randomNum == 0){
            addToBot(new ApplyPowerAction(p, p, new WeakPower(p, 1, false)));
        }
        else if(randomNum == 1){
            addToBot(new ApplyPowerAction(p, p, new FrailPower(p, 1, false)));
        }
        else{
            addToBot(new ApplyPowerAction(p, p, new VulnerablePower(p, 1, false)));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.common.ElfRecruit();
    }
}