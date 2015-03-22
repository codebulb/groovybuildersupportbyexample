package ch.codebulb.groovybyexample.buildersupport.model

import groovy.transform.*

class Car extends InsuredItem {
    public Car(String name, int price=0) {
        super(name, price)
    }
}
