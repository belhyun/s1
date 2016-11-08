/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
***/
package src.times2.ref.collection.fpij;

import java.util.function.Consumer;

import static src.times2.ref.collection.fpij.Folks.friends;

public class Iteration {
    /**
     * Consumer<T>는 <T> -> void를 명시한다
     * @param args
     */
    public static void main(final String[] args) {
        for(int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }

        for(String name : friends) {
            System.out.println(name);
        }

        System.out.println("//" + "START:INTERNAL_FOR_EACH_OUTPUT");

        friends.forEach(new Consumer<String>() {
            public void accept(final String name) {
                System.out.println(name);
            }
        });

        System.out.println("//" + "END:INTERNAL_FOR_EACH_OUTPUT");

        System.out.println("//" + "START:INTERNAL_OUTPUT");
        friends.forEach((final String name) -> System.out.println(name));
        System.out.println("//" + "END:INTERNAL_OUTPUT");

        friends.forEach((name) -> System.out.println(name));

        friends.forEach(name -> System.out.println(name));

        friends.forEach(System.out::println);
    }
}
