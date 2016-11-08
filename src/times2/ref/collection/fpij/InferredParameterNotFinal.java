/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
***/
package src.times2.ref.collection.fpij;

import org.junit.Test;

import static src.times2.ref.collection.fpij.Folks.friends;

public class InferredParameterNotFinal {

    /**
     * 복수의 람다식을 명시할경우 {}를 사용한다.
     */
    @Test
    public void test_forEach() {
        friends.forEach(name -> {
            name = name.toUpperCase();
            System.out.println(name);
        });
    }
}
