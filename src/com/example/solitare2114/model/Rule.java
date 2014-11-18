package com.example.solitare2114.model;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Gregory Colella (gregc@vt.edu), Andrew Bryant (andrewpb),
 *  & Pelin Demir (pelind@vt.edu)
 *  @version Nov 17, 2014
 */
public abstract class Rule
{

   public abstract boolean canAdd(Hand in, Card c);

   public Rule and(final Rule other) {
       return new Rule() {
           public boolean canAdd(Hand in, Card c) {
               return this.canAdd(in, c) && other.canAdd(in,  c);
           }
       };
   }

   public Rule or(final Rule other) {
       return new Rule() {
           public boolean canAdd(Hand in, Card c) {
               return this.canAdd(in, c) || other.canAdd(in,  c);
           }
       };
   }

   public Rule not() {
       return new Rule() {

        @Override
        public boolean canAdd(Hand in, Card c)
        {
            return !this.canAdd(in, c);
        }

       };
   }

}
