package xyz.epoch.wallettracker.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TxnDTO {
 private String block_signed_at ;
 private String block_height ;
 private String tx_hash;
 private int tx_offset ;
 private boolean successful ;
 private String from_address ;
 private String from_address_label ;
 private String to_address ;
 private String to_address_label ;
 private int value ;
 private int value_quote ;
 private int wallet_Id ;

 @Override
 public String toString() {
  return "TxnDTO{" +
          "block_signed_at='" + block_signed_at + '\'' +
          ", block_height='" + block_height + '\'' +
          ", tx_hash='" + tx_hash + '\'' +
          ", tx_offset=" + tx_offset +
          ", successful=" + successful +
          ", from_address='" + from_address + '\'' +
          ", from_address_label='" + from_address_label + '\'' +
          ", to_address='" + to_address + '\'' +
          ", to_address_label='" + to_address_label + '\'' +
          ", value=" + value +
          ", value_quote=" + value_quote +
          ", wallet_Id=" + wallet_Id +
          '}';
 }

 public String getBlock_signed_at() {
  return block_signed_at;
 }

 public void setBlock_signed_at(String block_signed_at) {
  this.block_signed_at = block_signed_at;
 }

 public String getBlock_height() {
  return block_height;
 }

 public void setBlock_height(String block_height) {
  this.block_height = block_height;
 }

 public String getTx_hash() {
  return tx_hash;
 }

 public void setTx_hash(String tx_hash) {
  this.tx_hash = tx_hash;
 }

 public int getTx_offset() {
  return tx_offset;
 }

 public void setTx_offset(int tx_offset) {
  this.tx_offset = tx_offset;
 }

 public boolean isSuccessful() {
  return successful;
 }

 public void setSuccessful(boolean successful) {
  this.successful = successful;
 }

 public String getFrom_address() {
  return from_address;
 }

 public void setFrom_address(String from_address) {
  this.from_address = from_address;
 }

 public String getFrom_address_label() {
  return from_address_label;
 }

 public void setFrom_address_label(String from_address_label) {
  this.from_address_label = from_address_label;
 }

 public String getTo_address() {
  return to_address;
 }

 public void setTo_address(String to_address) {
  this.to_address = to_address;
 }

 public String getTo_address_label() {
  return to_address_label;
 }

 public void setTo_address_label(String to_address_label) {
  this.to_address_label = to_address_label;
 }

 public int getValue() {
  return value;
 }

 public void setValue(int value) {
  this.value = value;
 }

 public int getValue_quote() {
  return value_quote;
 }

 public void setValue_quote(int value_quote) {
  this.value_quote = value_quote;
 }

 public int getWallet_Id() {
  return wallet_Id;
 }

 public void setWallet_Id(int wallet_Id) {
  this.wallet_Id = wallet_Id;
 }
}
