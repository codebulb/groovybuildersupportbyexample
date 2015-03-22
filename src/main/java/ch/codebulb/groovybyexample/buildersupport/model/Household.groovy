package ch.codebulb.groovybyexample.buildersupport.model

import groovy.transform.*

@TupleConstructor(includes="address")
@EqualsAndHashCode
class Household {
    String address
    List<Room> rooms = []
    List<Car> cars = []
    
    public leftShift(Room item) {rooms << item }
    public leftShift(Car item) {cars << item }
}
