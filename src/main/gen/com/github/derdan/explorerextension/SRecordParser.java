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
  // BYTE BYTE
  public static boolean address_16(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "address_16")) return false;
    if (!nextTokenIs(b, BYTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BYTE, BYTE);
    exit_section_(b, m, ADDRESS_16, r);
    return r;
  }

  /* ********************************************************** */
  // BYTE BYTE BYTE
  public static boolean address_24(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "address_24")) return false;
    if (!nextTokenIs(b, BYTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BYTE, BYTE, BYTE);
    exit_section_(b, m, ADDRESS_24, r);
    return r;
  }

  /* ********************************************************** */
  // BYTE BYTE BYTE BYTE
  public static boolean address_32(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "address_32")) return false;
    if (!nextTokenIs(b, BYTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BYTE, BYTE, BYTE, BYTE);
    exit_section_(b, m, ADDRESS_32, r);
    return r;
  }

  /* ********************************************************** */
  // BLOCK_HEADER byte_count address_16  data  CHECKSUM
  public static boolean block_record(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_record")) return false;
    if (!nextTokenIs(b, BLOCK_HEADER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BLOCK_HEADER);
    r = r && byte_count(b, l + 1);
    r = r && address_16(b, l + 1);
    r = r && data(b, l + 1);
    r = r && consumeToken(b, CHECKSUM);
    exit_section_(b, m, BLOCK_RECORD, r);
    return r;
  }

  /* ********************************************************** */
  // COUNT
  public static boolean byte_count(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "byte_count")) return false;
    if (!nextTokenIs(b, COUNT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COUNT);
    exit_section_(b, m, BYTE_COUNT, r);
    return r;
  }

  /* ********************************************************** */
  // COUNT_HEADER_16 byte_count address_16  data  CHECKSUM
  public static boolean count_record_16(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "count_record_16")) return false;
    if (!nextTokenIs(b, COUNT_HEADER_16)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COUNT_HEADER_16);
    r = r && byte_count(b, l + 1);
    r = r && address_16(b, l + 1);
    r = r && data(b, l + 1);
    r = r && consumeToken(b, CHECKSUM);
    exit_section_(b, m, COUNT_RECORD_16, r);
    return r;
  }

  /* ********************************************************** */
  // COUNT_HEADER_24 byte_count address_24  data  CHECKSUM
  public static boolean count_record_24(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "count_record_24")) return false;
    if (!nextTokenIs(b, COUNT_HEADER_24)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COUNT_HEADER_24);
    r = r && byte_count(b, l + 1);
    r = r && address_24(b, l + 1);
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
  // DATA_HEADER_16 byte_count address_16  data  CHECKSUM
  public static boolean data_record_16(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data_record_16")) return false;
    if (!nextTokenIs(b, DATA_HEADER_16)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DATA_HEADER_16);
    r = r && byte_count(b, l + 1);
    r = r && address_16(b, l + 1);
    r = r && data(b, l + 1);
    r = r && consumeToken(b, CHECKSUM);
    exit_section_(b, m, DATA_RECORD_16, r);
    return r;
  }

  /* ********************************************************** */
  // DATA_HEADER_24 byte_count address_24  data  CHECKSUM
  public static boolean data_record_24(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data_record_24")) return false;
    if (!nextTokenIs(b, DATA_HEADER_24)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DATA_HEADER_24);
    r = r && byte_count(b, l + 1);
    r = r && address_24(b, l + 1);
    r = r && data(b, l + 1);
    r = r && consumeToken(b, CHECKSUM);
    exit_section_(b, m, DATA_RECORD_24, r);
    return r;
  }

  /* ********************************************************** */
  // DATA_HEADER_32 byte_count address_32  data  CHECKSUM
  public static boolean data_record_32(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "data_record_32")) return false;
    if (!nextTokenIs(b, DATA_HEADER_32)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DATA_HEADER_32);
    r = r && byte_count(b, l + 1);
    r = r && address_32(b, l + 1);
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
  // (record EOL? )*
  static boolean srecordFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "srecordFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!srecordFile_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "srecordFile", c)) break;
    }
    return true;
  }

  // record EOL?
  private static boolean srecordFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "srecordFile_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = record(b, l + 1);
    r = r && srecordFile_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EOL?
  private static boolean srecordFile_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "srecordFile_0_1")) return false;
    consumeToken(b, EOL);
    return true;
  }

  /* ********************************************************** */
  // START_ADDRESS_16 byte_count address_16  CHECKSUM
  public static boolean start_record_16(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "start_record_16")) return false;
    if (!nextTokenIs(b, START_ADDRESS_16)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, START_ADDRESS_16);
    r = r && byte_count(b, l + 1);
    r = r && address_16(b, l + 1);
    r = r && consumeToken(b, CHECKSUM);
    exit_section_(b, m, START_RECORD_16, r);
    return r;
  }

  /* ********************************************************** */
  // START_ADDRESS_24 byte_count address_24  CHECKSUM
  public static boolean start_record_24(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "start_record_24")) return false;
    if (!nextTokenIs(b, START_ADDRESS_24)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, START_ADDRESS_24);
    r = r && byte_count(b, l + 1);
    r = r && address_24(b, l + 1);
    r = r && consumeToken(b, CHECKSUM);
    exit_section_(b, m, START_RECORD_24, r);
    return r;
  }

  /* ********************************************************** */
  // START_ADDRESS_32 byte_count address_32  CHECKSUM
  public static boolean start_record_32(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "start_record_32")) return false;
    if (!nextTokenIs(b, START_ADDRESS_32)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, START_ADDRESS_32);
    r = r && byte_count(b, l + 1);
    r = r && address_32(b, l + 1);
    r = r && consumeToken(b, CHECKSUM);
    exit_section_(b, m, START_RECORD_32, r);
    return r;
  }

}
