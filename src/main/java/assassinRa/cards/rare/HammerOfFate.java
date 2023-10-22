package assassinRa.cards.rare;

import assassinRa.actions.HammerOfFateAction;
import assassinRa.cards.BaseCard;
import assassinRa.character.AssassinCharacter;
import assassinRa.util.CardStats;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.defect.SunderAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.vfx.combat.WeightyImpactEffect;

public class HammerOfFate extends BaseCard {
    public static final String ID = makeID(assassinRa.cards.rare.HammerOfFate.class.getSimpleName());
    private static final CardStats info = new CardStats(
            AssassinCharacter.Enums.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.RARE,
            CardTarget.ENEMY,
            1
    );

    private static final int DAMAGE = 12;
    private static final int STRENGTH = 1;
    private static final int DEXTERITY = 1;

    public HammerOfFate() {
        super(ID, info);
        setEthereal(true, false);
        setDamage(DAMAGE);
        setMagic(STRENGTH);
        setCustomVar("magicDex", DEXTERITY);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (m != null) {
            addToBot(new VFXAction(new WeightyImpactEffect(m.hb.cX, m.hb.cY)));
            addToBot(new WaitAction(0.8F));
        }

        addToBot(new HammerOfFateAction(p, m, new DamageInfo(p, damage, damageTypeForTurn), magicNumber, customVar("magicDex")));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new assassinRa.cards.rare.HammerOfFate();
    }
}