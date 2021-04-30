// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.github.derdan.explorerextension;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.github.derdan.explorerextension.psi.SRecordTypes;
import com.intellij.psi.TokenType;

%%

%class SRecordLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}
%{
private int byte_count;
private int address_state;
// nuschel
%}

HEX_8=[0-9A-Z]{2}
HEX_16=[0-9A-Z]{4}
HEX_24=[0-9A-Z]{6}
HEX_32=[0-9A-Z]{8}
BLOCK_HEADER=S0
DATA_HEADER_16=S1
DATA_HEADER_24=S2
DATA_HEADER_32=S3
COUNT_HEADER_16=S5
COUNT_HEADER_24=S6
START_ADDRESS_16=S9
START_ADDRESS_24=S8
START_ADDRESS_32=S7
CRLF= \R

%state WAITING_COUNT
%state WAIT_ADDRESS_16
%state WAIT_ADDRESS_24
%state WAIT_ADDRESS_32
%state WAITING_BYTES
%state WAITING_CS
%state BAD_SEQUENCE

%%

<YYINITIAL> {BLOCK_HEADER}      { yybegin(WAITING_COUNT); address_state=  WAIT_ADDRESS_16;return SRecordTypes.BLOCK_HEADER; }
<YYINITIAL> {DATA_HEADER_16}    { yybegin(WAITING_COUNT); address_state=  WAIT_ADDRESS_16;return SRecordTypes.DATA_HEADER_16; }
<YYINITIAL> {DATA_HEADER_24}    { yybegin(WAITING_COUNT); address_state=  WAIT_ADDRESS_24;return SRecordTypes.DATA_HEADER_24; }
<YYINITIAL> {DATA_HEADER_32}    { yybegin(WAITING_COUNT); address_state=  WAIT_ADDRESS_32;return SRecordTypes.DATA_HEADER_32; }
<YYINITIAL> {COUNT_HEADER_16}   { yybegin(WAITING_COUNT); address_state=  WAIT_ADDRESS_16;return SRecordTypes.COUNT_HEADER_16; }
<YYINITIAL> {COUNT_HEADER_24}   { yybegin(WAITING_COUNT); address_state=  WAIT_ADDRESS_24;return SRecordTypes.COUNT_HEADER_24; }
<YYINITIAL> {START_ADDRESS_16}  { yybegin(WAITING_COUNT); address_state=  WAIT_ADDRESS_16;return SRecordTypes.START_ADDRESS_16; }
<YYINITIAL> {START_ADDRESS_24}  { yybegin(WAITING_COUNT); address_state=  WAIT_ADDRESS_24;return SRecordTypes.START_ADDRESS_24; }
<YYINITIAL> {START_ADDRESS_32}  { yybegin(WAITING_COUNT); address_state=  WAIT_ADDRESS_32;return SRecordTypes.START_ADDRESS_32; }
<WAITING_COUNT> {HEX_8}         { byte_count = Integer.parseInt(yytext().toString(), 16); yybegin(address_state);  return SRecordTypes.COUNT; }
<WAIT_ADDRESS_16> {HEX_16}      { byte_count -= 2; yybegin(byte_count > 1 ? WAITING_BYTES:WAITING_CS);  return SRecordTypes.ADDRESS; }
<WAIT_ADDRESS_24> {HEX_24}      { byte_count -= 3; yybegin(byte_count > 1 ? WAITING_BYTES:WAITING_CS);  return SRecordTypes.ADDRESS; }
<WAIT_ADDRESS_32> {HEX_32}      { byte_count -= 4; yybegin(byte_count > 1 ? WAITING_BYTES:WAITING_CS);  return SRecordTypes.ADDRESS; }
<WAITING_BYTES> {HEX_8}         { byte_count -= 1; yybegin(byte_count > 1 ? WAITING_BYTES:WAITING_CS);  return SRecordTypes.BYTE; }
<WAITING_CS> {HEX_8}            { yybegin(YYINITIAL);  return SRecordTypes.CHECKSUM; }
{CRLF}                          { yybegin(YYINITIAL); return SRecordTypes.EOL; }
//<<EOF>>                         { return SRecordTypes.EOF; }
[^]                             { yybegin(BAD_SEQUENCE); }
<BAD_SEQUENCE>[^\R]             { yybegin(BAD_SEQUENCE); return TokenType.BAD_CHARACTER; }
