package com.github.derdan.explorerextension;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.openapi.util.Key;

import static com.github.derdan.explorerextension.psi.IntelHexTypes.IH_BYTE;
import static com.github.derdan.explorerextension.psi.IntelHexTypes.REC_LEN;

public class HexParserUtil extends GeneratedParserUtilBase {

    public static final Key<Integer> HEX_PARSER_UTIL_KEY = Key.create("HexParserUtil");
    public static boolean len_rule(PsiBuilder builder, int level) {
        if (!recursion_guard_(builder, level, "recLen")) return false;
        if (!nextTokenIs(builder, IH_BYTE)) return false;
        boolean r;
        PsiBuilder.Marker m = enter_section_(builder);
        String tokenText = builder.getTokenText();
        int count = Integer.parseInt(tokenText, 16);
        builder.putUserData(HEX_PARSER_UTIL_KEY, count);
        r = consumeToken(builder, IH_BYTE);
        exit_section_(builder, m, REC_LEN, r);
        return r;
    }
}
