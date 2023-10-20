package assassinRa.relics;

import assassinRa.character.AssassinCharacter;
import assassinRa.powers.AssassinsMark;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static assassinRa.assassinRa.makeID;

public class AssassinBaseRelic extends BaseRelic{
    private static final String NAME = "AssassinBaseRelic";
    public static final String ID = makeID(NAME);
    private static final RelicTier RARITY = RelicTier.STARTER;
    private static final LandingSound SOUND = LandingSound.HEAVY;

    public AssassinBaseRelic(){
        super(ID, NAME, AssassinCharacter.Enums.CARD_COLOR, RARITY, SOUND);
    }

    @Override
    public void onAttack(DamageInfo info, int damageAmount, AbstractCreature target) {
        AbstractPlayer player = AbstractDungeon.player;

        // Check if the damage is unblocked and the target is a monster
        if (info.type == DamageInfo.DamageType.NORMAL && target instanceof AbstractMonster) {
            AbstractMonster monster = (AbstractMonster) target;

            if(monster.currentBlock == 0){
                // Apply 1 Assassin's Mark to the target
                addToTop(new ApplyPowerAction(monster, player, new AssassinsMark(monster, 1)));
            }
        }
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + DESCRIPTIONS[1];
    }
}
