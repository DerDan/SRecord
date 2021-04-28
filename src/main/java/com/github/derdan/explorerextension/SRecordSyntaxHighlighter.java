package com.github.derdan.explorerextension;


import com.github.derdan.explorerextension.psi.SRecordTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

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
    public TextAttributesKey [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(SRecordTypes.BLOCK_HEADER)
        || tokenType.equals(SRecordTypes.DATA_HEADER_16)
        || tokenType.equals(SRecordTypes.DATA_HEADER_24)
        || tokenType.equals(SRecordTypes.DATA_HEADER_32)
        || tokenType.equals(SRecordTypes.COUNT_HEADER_16)
        || tokenType.equals(SRecordTypes.COUNT_HEADER_24)
        || tokenType.equals(SRecordTypes.START_ADDRESS_16)
        || tokenType.equals(SRecordTypes.START_ADDRESS_24)
        || tokenType.equals(SRecordTypes.START_ADDRESS_32))
        {
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
