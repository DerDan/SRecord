// This is a generated file. Not intended for manual editing.
package com.github.derdan.explorerextension;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.derdan.explorerextension.psi.SRecordTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class SRecordParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return srecordFile(b, l + 1);
  }

  /* ********************************************************** */
  // BLOCK_HEADER     COUNT ADDRESS  data  CHECKSUM
  public static boolean block_record(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_record")) return false;
    if (!nextTokenIs(b, BLOCK_HEADER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BLOCK_HEADER, COUNT, ADDRESS);
    r = r && data(b, l + 1);
    r = r && consumeToken(b, CHECKSUM);
    exit_section_(b, m, BLOCK_RECORD, r);
    return r;
  }

  /* ********************************************************** */
  // COUNT_HEADER_16  COUNT ADDRESS  data  CHECKSUM
  public static boolean count_record_16(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "count_record_16")) return false;
    if (!nextTokenIs(b, COUNT_HEADER_16)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COUNT_HEADER_16, COUNT, ADDRESS);
    r = r && data(b, l + 1);
    r = r && consumeToken(b, CHECKSUM);
    exit_section_(b, m, COUNT_RECORD_16, r);
    return r;
  }

  /* ********************************************************** */
  // COUNT_HEADER_24  COUNT ADDRESS  data  CHECKSUM
  public static boolean count_record_24(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "count_record_24")) return false;
    if (!nextTokenIs(b, COUNT_HEADER_24)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COUNT_HEADER_24, COUNT, ADDRESS);
    r = r && data(b, l + 1);
    r = r && consumeToken(b, CHECKSUM);
    exit_section_(b, m, COUNT_RECORD_24, r);
    return r;
  }

  /* ********************************************************** */
  // BYTE*
  public static boolean data(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data")) return false;
    Marker m = enter_section_(b, l, _NONE_, DATA, "<data>");
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, BYTE)) break;
      if (!empty_element_parsed_guard_(b, "data", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // DATA_HEADER_16   COUNT ADDRESS  data  CHECKSUM
  public static boolean data_record_16(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data_record_16")) return false;
    if (!nextTokenIs(b, DATA_HEADER_16)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DATA_HEADER_16, COUNT, ADDRESS);
    r = r && data(b, l + 1);
    r = r && consumeToken(b, CHECKSUM);
    exit_section_(b, m, DATA_RECORD_16, r);
    return r;
  }

  /* ********************************************************** */
  // DATA_HEADER_24   COUNT ADDRESS  data  CHECKSUM
  public static boolean data_record_24(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data_record_24")) return false;
    if (!nextTokenIs(b, DATA_HEADER_24)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DATA_HEADER_24, COUNT, ADDRESS);
    r = r && data(b, l + 1);
    r = r && consumeToken(b, CHECKSUM);
    exit_section_(b, m, DATA_RECORD_24, r);
    return r;
  }

  /* ********************************************************** */
  // DATA_HEADER_32   COUNT ADDRESS  data  CHECKSUM
  public static boolean data_record_32(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data_record_32")) return false;
    if (!nextTokenIs(b, DATA_HEADER_32)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DATA_HEADER_32, COUNT, ADDRESS);
    r = r && data(b, l + 1);
    r = r && consumeToken(b, CHECKSUM);
    exit_section_(b, m, DATA_RECORD_32, r);
    return r;
  }

  /* ********************************************************** */
  // block_record
  //     |   data_record_16
  //     |   data_record_24
  //     |   data_record_32
  //     |   count_record_16
  //     |   count_record_24
  //     |   start_record_16
  //     |   start_record_24
  //     |   start_record_32
  public static boolean record(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RECORD, "<record>");
    r = block_record(b, l + 1);
    if (!r) r = data_record_16(b, l + 1);
    if (!r) r = data_record_24(b, l + 1);
    if (!r) r = data_record_32(b, l + 1);
    if (!r) r = count_record_16(b, l + 1);
    if (!r) r = count_record_24(b, l + 1);
    if (!r) r = start_record_16(b, l + 1);
    if (!r) r = start_record_24(b, l + 1);
    if (!r) r = start_record_32(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (record EOL)* record?
  static boolean srecordFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "srecordFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = srecordFile_0(b, l + 1);
    r = r && srecordFile_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (record EOL)*
  private static boolean srecordFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "srecordFile_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!srecordFile_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "srecordFile_0", c)) break;
    }
    return true;
  }

  // record EOL
  private static boolean srecordFile_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "srecordFile_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = record(b, l + 1);
    r = r && consumeToken(b, EOL);
    exit_section_(b, m, null, r);
    return r;
  }

  // record?
  private static boolean srecordFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "srecordFile_1")) return false;
    record(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // START_ADDRESS_16 COUNT ADDRESS        CHECKSUM
  public static boolean start_record_16(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "start_record_16")) return false;
    if (!nextTokenIs(b, START_ADDRESS_16)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, START_ADDRESS_16, COUNT, ADDRESS, CHECKSUM);
    exit_section_(b, m, START_RECORD_16, r);
    return r;
  }

  /* ********************************************************** */
  // START_ADDRESS_24 COUNT ADDRESS        CHECKSUM
  public static boolean start_record_24(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "start_record_24")) return false;
    if (!nextTokenIs(b, START_ADDRESS_24)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, START_ADDRESS_24, COUNT, ADDRESS, CHECKSUM);
    exit_section_(b, m, START_RECORD_24, r);
    return r;
  }

  /* ********************************************************** */
  // START_ADDRESS_32 COUNT ADDRESS        CHECKSUM
  public static boolean start_record_32(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "start_record_32")) return false;
    if (!nextTokenIs(b, START_ADDRESS_32)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, START_ADDRESS_32, COUNT, ADDRESS, CHECKSUM);
    exit_section_(b, m, START_RECORD_32, r);
    return r;
  }

}
