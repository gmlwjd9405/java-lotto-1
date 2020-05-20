package lotto.domain.prize;

import java.util.EnumMap;

public class LottoPrizeResult {

    private static final int DEFAULT_MATCHED_COUNT = 0;

    private final EnumMap<Prize, Integer> matchedPrizes;

    private LottoPrizeResult() {
        this.matchedPrizes = new EnumMap<>(Prize.class);
        for (Prize rank : Prize.values()) {
            matchedPrizes.put(rank, DEFAULT_MATCHED_COUNT);
        }
    }

    public static LottoPrizeResult init() {
        return new LottoPrizeResult();
    }

    public void updateMatchedPrize(final Prize prize) {
        matchedPrizes.put(prize, increasedMatchedTicketCount(prize));
    }

    private int increasedMatchedTicketCount(final Prize prize) {
        return this.matchedPrizes.get(prize) + 1;
    }
}
