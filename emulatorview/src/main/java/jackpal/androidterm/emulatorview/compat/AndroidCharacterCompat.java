package jackpal.androidterm.emulatorview.compat;


import android.icu.lang.UCharacter;
import android.icu.lang.UProperty;

/**
 * Definitions related to android.text.AndroidCharacter
 */
public class AndroidCharacterCompat {
    public static final int EAST_ASIAN_WIDTH_NEUTRAL = 0;
    public static final int EAST_ASIAN_WIDTH_AMBIGUOUS = 1;
    public static final int EAST_ASIAN_WIDTH_HALF_WIDTH = 2;
    public static final int EAST_ASIAN_WIDTH_FULL_WIDTH = 3;
    public static final int EAST_ASIAN_WIDTH_NARROW = 4;
    public static final int EAST_ASIAN_WIDTH_WIDE = 5;

    public static int getEastAsianWidth(int codePoint) {
        return switch (UCharacter.getIntPropertyValue(codePoint, UProperty.EAST_ASIAN_WIDTH)) {
            case UCharacter.EastAsianWidth.FULLWIDTH, UCharacter.EastAsianWidth.WIDE -> 2;
            case UCharacter.EastAsianWidth.HALFWIDTH, UCharacter.EastAsianWidth.NARROW,
                 UCharacter.EastAsianWidth.NEUTRAL -> 1;
            default -> isCJKChar(codePoint) ? 2 : 1;
        };
    }

    private static boolean isCJKChar(int codePoint) {
        return (codePoint >= 0x4E00 && codePoint <= 0x9FFF)
                || (codePoint >= 0x3040 && codePoint <= 0x30FF)
                || (codePoint >= 0xAC00 && codePoint <= 0xD7AF);
    }
}
