// This is a generated file. Not intended for manual editing.
package com.github.derdan.explorerextension.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.derdan.explorerextension.psi.impl.*;

public interface SRecordTypes {

  IElementType BLOCK_RECORD = new SRecordElementType("BLOCK_RECORD");
  IElementType COUNT_RECORD_16 = new SRecordElementType("COUNT_RECORD_16");
  IElementType COUNT_RECORD_24 = new SRecordElementType("COUNT_RECORD_24");
  IElementType DATA = new SRecordElementType("DATA");
  IElementType DATA_RECORD_16 = new SRecordElementType("DATA_RECORD_16");
  IElementType DATA_RECORD_24 = new SRecordElementType("DATA_RECORD_24");
  IElementType DATA_RECORD_32 = new SRecordElementType("DATA_RECORD_32");
  IElementType RECORD = new SRecordElementType("RECORD");
  IElementType START_RECORD_16 = new SRecordElementType("START_RECORD_16");
  IElementType START_RECORD_24 = new SRecordElementType("START_RECORD_24");
  IElementType START_RECORD_32 = new SRecordElementType("START_RECORD_32");

  IElementType ADDRESS = new SRecordTokenType("ADDRESS");
  IElementType BLOCK_HEADER = new SRecordTokenType("BLOCK_HEADER");
  IElementType BYTE = new SRecordTokenType("BYTE");
  IElementType CHECKSUM = new SRecordTokenType("CHECKSUM");
  IElementType COUNT = new SRecordTokenType("COUNT");
  IElementType COUNT_HEADER_16 = new SRecordTokenType("COUNT_HEADER_16");
  IElementType COUNT_HEADER_24 = new SRecordTokenType("COUNT_HEADER_24");
  IElementType DATA_HEADER_16 = new SRecordTokenType("DATA_HEADER_16");
  IElementType DATA_HEADER_24 = new SRecordTokenType("DATA_HEADER_24");
  IElementType DATA_HEADER_32 = new SRecordTokenType("DATA_HEADER_32");
  IElementType EOL = new SRecordTokenType("EOL");
  IElementType START_ADDRESS_16 = new SRecordTokenType("START_ADDRESS_16");
  IElementType START_ADDRESS_24 = new SRecordTokenType("START_ADDRESS_24");
  IElementType START_ADDRESS_32 = new SRecordTokenType("START_ADDRESS_32");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BLOCK_RECORD) {
        return new SRecordBlockRecordImpl(node);
      }
      else if (type == COUNT_RECORD_16) {
        return new SRecordCountRecord16Impl(node);
      }
      else if (type == COUNT_RECORD_24) {
        return new SRecordCountRecord24Impl(node);
      }
      else if (type == DATA) {
        return new SRecordDataImpl(node);
      }
      else if (type == DATA_RECORD_16) {
        return new SRecordDataRecord16Impl(node);
      }
      else if (type == DATA_RECORD_24) {
        return new SRecordDataRecord24Impl(node);
      }
      else if (type == DATA_RECORD_32) {
        return new SRecordDataRecord32Impl(node);
      }
      else if (type == RECORD) {
        return new SRecordRecordImpl(node);
      }
      else if (type == START_RECORD_16) {
        return new SRecordStartRecord16Impl(node);
      }
      else if (type == START_RECORD_24) {
        return new SRecordStartRecord24Impl(node);
      }
      else if (type == START_RECORD_32) {
        return new SRecordStartRecord32Impl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
