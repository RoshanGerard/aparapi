package com.amd.aparapi;

/**
 * Created with IntelliJ IDEA.
 * User: gfrost
 * Date: 4/27/13
 * Time: 9:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class TextRenderer<T extends TextRenderer>{
   final private StringBuilder sb = new StringBuilder();
   private int lastNewLineIndex = 0;
   private int lastMark = 0;

   final public T append(String s){
      sb.append(s);
      return ((T) this);
   }


   final public T append(int i){
      return (append("" + i));

   }

   final public T append(double d){
      return (append("" + d));
   }

   final public T append(float f){
      return (append("" + f));
   }

   final public T append(long l){
      return (append("" + l));
   }

   final public T appendConst(int i){
      return (append(i));

   }

   final public T appendConst(double d){
      return (append(d));
   }

   final public T appendConst(float f){
      append(f);
      return (append("f"));
   }

   final public T appendConst(long l){
      append(l);
      return (append("L"));
   }


   final public T commaSpace(){
      return (append(", "));
   }

   final public T nl(){
      append("\n");
      lastMark = lastNewLineIndex = sb.length();
      return ((T) this);
   }


   final public T pad(int n){
      while(sb.length() - lastNewLineIndex < n){
         space();
      }
      return ((T) this);
   }


   final public T mark(){
      lastMark = sb.length();
      return ((T) this);
   }

   final public T relpad(int n){
      while(sb.length() - lastMark < n){
         space();
      }
      return ((T) this);
   }

   final public T space(){
      return (append(" "));
   }

   final public T semicolon(){
      return (append(";"));
   }

   final public T dot(){
      return (append("."));
   }

   final public T append(TextRenderer _t){
      return (append(_t.toString()));
   }

   @Override
   final public String toString(){
      return (sb.toString());
   }

}