package com.github.derdan.srecord;


import com.github.derdan.srecord.psi.SRecordTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.EffectType;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.ui.JBColor;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class SRecordSyntaxHighlighter extends SyntaxHighlighterBase {


    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("SRECORD_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEY =
            createTextAttributesKey("SRECORD_KEY", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey VALUE =
            createTextAttributesKey("SRECORD_VALUE", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("SRECORD_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey PARAMETER =
            createTextAttributesKey("SRECORD_PARAMETER", DefaultLanguageHighlighterColors.PARAMETER);

    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("SRECORD_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);


    public static final TextAttributes DATA_BYTE_1 = new TextAttributes(new JBColor(0x000000, 0xFFFFFF), new JBColor(0xe0e0e0, 0x467cda), null, EffectType.BOXED, Font.PLAIN);
    public static final TextAttributes DATA_BYTE_2 = new TextAttributes(new JBColor(0x000000, 0x467cda), null, null, EffectType.BOXED, Font.PLAIN);
    public static final TextAttributes DATA_BYTE_3 = new TextAttributes(new JBColor(0x303030, 0x467cda), new JBColor(0xe0e0e0, 0x467cda), null, EffectType.BOXED, Font.PLAIN);
    public static final TextAttributes DATA_BYTE_4 = new TextAttributes(new JBColor(0x303030, 0x467cda), null, null, EffectType.BOXED, Font.PLAIN);
    private static final TextAttributesKey NUM_1 = TextAttributesKey.createTextAttributesKey("SRECORD_DATA1", DATA_BYTE_1);
    private static final TextAttributesKey NUM_2 = TextAttributesKey.createTextAttributesKey("SRECORD_DATA2", DATA_BYTE_2);
    private static final TextAttributesKey NUM_3 = TextAttributesKey.createTextAttributesKey("SRECORD_DATA3", DATA_BYTE_3);
    private static final TextAttributesKey NUM_4 = TextAttributesKey.createTextAttributesKey("SRECORD_DATA4", DATA_BYTE_4);
    public static final TextAttributesKey[] BYTES_KEYS = new TextAttributesKey[]{NUM_1, NUM_2, NUM_3, NUM_4};
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] KEY_KEYS = new TextAttributesKey[]{KEY};
    private static final TextAttributesKey[] VALUE_KEYS = new TextAttributesKey[]{VALUE};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] PARAMETER_KEYS = new TextAttributesKey[]{PARAMETER};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new SRecordLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(SRecordTypes.BLOCK_HEADER)
                || tokenType.equals(SRecordTypes.DATA_HEADER_16)
                || tokenType.equals(SRecordTypes.DATA_HEADER_24)
                || tokenType.equals(SRecordTypes.DATA_HEADER_32)
                || tokenType.equals(SRecordTypes.COUNT_HEADER_16)
                || tokenType.equals(SRecordTypes.COUNT_HEADER_24)
                || tokenType.equals(SRecordTypes.START_ADDRESS_16)
                || tokenType.equals(SRecordTypes.START_ADDRESS_24)
                || tokenType.equals(SRecordTypes.START_ADDRESS_32)) {
            return KEY_KEYS;
        } else if (tokenType.equals(SRecordTypes.COUNT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(SRecordTypes.ADDRESS)) {
            return KEY_KEYS;
        } else if (tokenType.equals(SRecordTypes.BYTE)) {
            return SEPARATOR_KEYS;
        } else if (tokenType.equals(SRecordTypes.CHECKSUM)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }

}
