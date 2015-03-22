package ch.codebulb.groovybyexample.buildersupport.model

import groovy.transform.*

@TupleConstructor(includes="name")
@EqualsAndHashCode
class Room {
    String name
    List<Furniture> furniture = []
    
    public leftShift(Furniture item) {furniture << item }
}
