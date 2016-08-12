package cardSuit;

import anotations.CardAnotation;
import interfaces.Card;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String cardRank = reader.readLine();
        String cardSuit = reader.readLine();

        Card firstCard = new CardIml(cardRank, cardSuit);
        cardRank = reader.readLine();
        cardSuit = reader.readLine();
        Card secondCard = new CardIml(cardRank, cardSuit);

        if (firstCard.compareTo(secondCard)>0) {
            System.out.println(firstCard.toString());
        }
        System.out.println(secondCard.toString());

        Annotation[] annotations = firstCard.getRank().getAnnotations();

        for(Annotation annotation : annotations){
            if(annotation instanceof CardAnotation){
                CardAnotation myAnnotation = (CardAnotation) annotation;
                System.out.println("name: " + myAnnotation.);
                System.out.println("value: " + myAnnotation.value());
            }
        }



    }

}
