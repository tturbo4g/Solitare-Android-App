package com.example.solitare2114.model;

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
