package assassinRa.cards.rare;

import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;

public class Succubus extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.rare.Succubus.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.RARE,
            CardTarget.ALL_ENEMY,
            2
    );

    private static final int POISON = 6;
    private static final int UPG_POISON = 2;

    public Succubus() {
        super(ID, info);
        setMagic(POISON, UPG_POISON);
        setExhaust(true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        for(AbstractMonster monster : AbstractDungeon.getMonsters().monsters){
            addToBot(new ApplyPowerAction(monster, p, new PoisonPower(monster, p, magicNumber), magicNumber, AbstractGameAction.AttackEffect.POISON));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.rare.Succubus();
    }
}